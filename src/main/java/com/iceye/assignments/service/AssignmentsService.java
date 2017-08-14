package com.iceye.assignments.service;

import com.iceye.assignments.exception.NoAssignmentsAvailable;
import com.iceye.assignments.model.Assignment;
import com.iceye.assignments.util.AssignmentsWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Ahmad Hamouda on 13/08/17.
 */
@Service
public class AssignmentsService {

    @Autowired
    AssignmentsWrapper assignmentsWrapper;
    @Value("${assignments.url}")
    private String assignmentsURL;

    public List<Assignment> getAssignments() throws IOException {
        return Arrays.stream(getAssignmentsList())
                .sorted(Comparator.comparing(Assignment::getUserId).thenComparing(Assignment::getId).reversed())
                .collect(Collectors.toList());
    }

    public List<Assignment> getUserAssignments(int userId) throws IOException {
        return Arrays.stream(getAssignmentsList()).filter(assignment -> assignment.getUserId() == userId)
                .sorted(Comparator.comparing(Assignment::getUserId).thenComparing(Assignment::getId).reversed())
                .collect(Collectors.toList());
    }

    private Assignment[] getAssignmentsList() throws IOException {
        Assignment[] assignments = assignmentsWrapper.getAssignments(assignmentsURL);
        if (assignments.length == 0) {
            throw new NoAssignmentsAvailable();
        }
        return assignments;
    }

}

package com.iceye.assignments.controller;

import com.iceye.assignments.exception.NoAssignmentsAvailable;
import com.iceye.assignments.model.Assignment;
import com.iceye.assignments.service.AssignmentsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

/**
 * Created by Ahmad Hamouda on 13/08/17.
 */
@Controller
public class AssignmentController {

    @Autowired
    AssignmentsService assignmentsService;


    @ApiOperation(value = "Get all assignments", notes = "Get all assignments.")
    @RequestMapping(value = "/iceye/assignments/", method = {RequestMethod.GET})
    @ResponseBody
    public List<Assignment> getAssignments() throws IOException {
        return assignmentsService.getAssignments();
    }

    @ApiOperation(value = "Get user assignments", notes = "Get user assignments.")
    @RequestMapping(value = "/iceye/assignments/{userId}", method = {RequestMethod.GET})
    @ResponseBody
    public List<Assignment> getUserAssignments(@PathVariable int userId) throws IOException {
        List<Assignment> userAssignments= assignmentsService.getUserAssignments(userId);
        if (userAssignments.size() == 0) {
            throw new NoAssignmentsAvailable();
        }
        return userAssignments;
    }

}

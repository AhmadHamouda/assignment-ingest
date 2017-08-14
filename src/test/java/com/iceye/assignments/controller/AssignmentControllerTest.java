package com.iceye.assignments.controller;

import com.iceye.assignments.AbstractWebTest;
import com.iceye.assignments.model.Assignment;
import com.iceye.assignments.service.AssignmentsService;
import com.iceye.assignments.util.AssignmentsWrapper;
import org.apache.log4j.Logger;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by Ahmad Hamouda on 13/08/17.
 */


@ActiveProfiles("test")
@SpringBootTest
@RunWith(SpringRunner.class)
public class AssignmentControllerTest extends AbstractWebTest {
    private static final Logger LOG = Logger.getLogger(AssignmentControllerTest.class);

    @Autowired
    @InjectMocks
    AssignmentsService assignmentsService;
    @MockBean
    AssignmentsWrapper assignmentsWrapper;

    private int userId = 1;
    private int wrongUserId = -1;
    private Assignment[] assignments = new Assignment[2];
    private Assignment[] emptyAssignments = new Assignment[0];


    @Before
    public void setup() throws IOException {

        Assignment assignment = new Assignment();
        assignment.setBody("Body");
        assignment.setId(1);
        assignment.setTitle("Title");
        assignment.setUserId(userId);
        Assignment anotherAssignment = new Assignment();
        anotherAssignment.setBody("Another Body");
        anotherAssignment.setId(2);
        anotherAssignment.setTitle("Another Title");
        anotherAssignment.setUserId(2);
        assignments[0] = assignment;
        assignments[1] = anotherAssignment;
        // Process mock annotations
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllAssignmentsOk() {
        try {
            LOG.info("Test get all assignments ok");
            when(assignmentsWrapper.getAssignments(any())).thenReturn(assignments);
            mockMvc.perform(get("/iceye/assignments/")).
                    andExpect(status().isOk()).
                    andExpect(jsonPath("$[0].body", Is.is("Another Body"))).
                    andExpect((jsonPath("$.*", Matchers.hasSize(2)))).
                    andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
        } catch (Exception ex) {
            LOG.error(ex);
            fail(ex.getMessage());
        }
    }

    @Test
    public void testGetAllAssignmentsReturnNoData() {
        try {
            LOG.info("Test get all assignments return not found");
            when(assignmentsWrapper.getAssignments(any())).thenReturn(emptyAssignments);
            mockMvc.perform(get("/iceye/assignments/")).
                    andExpect(status().isNotFound());
        } catch (Exception ex) {
            LOG.error(ex);
            fail(ex.getMessage());
        }
    }

    @Test
    public void testGetUserAssignmentsOk() {
        try {
            LOG.info("Test get all assignments ok");
            when(assignmentsWrapper.getAssignments(any())).thenReturn(assignments);
            mockMvc.perform(get("/iceye/assignments/"+userId)).
                    andExpect(status().isOk()).
                    andExpect(jsonPath("$[0].body", Is.is("Body"))).
                    andExpect((jsonPath("$.*", Matchers.hasSize(1)))).
                    andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
        } catch (Exception ex) {
            LOG.error(ex);
            fail(ex.getMessage());
        }
    }

    @Test
    public void testGetNonExistUserAssignmentsNotFound() {
        try {
            LOG.info("Test get all assignments for wrong userID return notfound");
            when(assignmentsWrapper.getAssignments(any())).thenReturn(assignments);
            mockMvc.perform(get("/iceye/assignments/"+wrongUserId)).
                    andExpect(status().isNotFound());
        } catch (Exception ex) {
            LOG.error(ex);
            fail(ex.getMessage());
        }
    }

}

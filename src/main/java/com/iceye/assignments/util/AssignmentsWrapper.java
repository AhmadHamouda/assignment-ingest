package com.iceye.assignments.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iceye.assignments.model.Assignment;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

/**
 * Created by Ahmad Hamouda on 13/08/17.
 */
@Service
public class AssignmentsWrapper {

    private static final Logger LOG = Logger.getLogger(AssignmentsWrapper.class);
    @Autowired
    private ObjectMapper objectMapper = new ObjectMapper();

    public Assignment[] getAssignments(String Url) throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> result = restTemplate.getForEntity(Url, String.class);
        String data = result.getBody().substring(result.getBody().indexOf('['));
        Assignment[] assignments = objectMapper.readValue(data, Assignment[].class);

        if (assignments.length == 0) {
            LOG.warn("No result found");
        }
        return assignments;
    }
}

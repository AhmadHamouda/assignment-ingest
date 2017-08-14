package com.iceye.assignments.exception;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Ahmad Hamouda on 13/08/17.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No Assignments Available.")
public class NoAssignmentsAvailable extends RuntimeException {

    private static final Logger LOG = Logger.getLogger(NoAssignmentsAvailable.class);

    @Override
    public String getMessage() {
        LOG.error("No Assignments Available.");
        return "No Assignments Available.";
    }

}

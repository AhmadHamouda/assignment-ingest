package com.iceye.assignments.exception;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Ahmad Hamouda on 13/08/17.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Image not exist please make sure from URL.")
public class ImageNotExist extends RuntimeException {

    private static final Logger LOG = Logger.getLogger(ImageNotExist.class);

    @Override
    public String getMessage() {
        LOG.error("Image not exist please make sure from URL.");
        return "Image not exist please make sure from URL.";
    }

}

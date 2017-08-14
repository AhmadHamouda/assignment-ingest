package com.iceye.assignments.util;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Ahmad Hamouda on 13/08/17.
 */
@Service
public class ImageWrapper {

    private static final Logger LOG = Logger.getLogger(ImageWrapper.class);

    @Value("${images.base.path}")
    private String imagesBasePath;


}

package com.iceye.assignments.controller;

import com.iceye.assignments.service.ImageService;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * Created by Ahmad Hamouda on 13/08/17.
 */
@Controller
public class IngestController {

    @Autowired
    ImageService imageService;

    @ApiOperation(value = "Save text as image", notes = "Save text as image.")
    @RequestMapping(value = "/iceye/images/", method = {RequestMethod.POST})
    @ResponseBody
    public String saveTextAsImage(@RequestBody String text) throws IOException {
        return imageService.saveTextAsImage(text);
    }

    @ApiOperation(value = "Get saved image", notes = "Get saved image.")
    @RequestMapping(value = "/iceye/image/", method = {RequestMethod.GET})
    public ResponseEntity<byte[]> getImage(@RequestParam String imageURl) throws IOException {

        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);

        return new ResponseEntity<byte[]>(IOUtils.toByteArray(imageService.getImage(imageURl)), headers, HttpStatus.FOUND);
    }
}

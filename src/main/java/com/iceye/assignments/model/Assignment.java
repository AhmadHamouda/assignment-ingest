package com.iceye.assignments.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Ahmad Hamouda on 14/08/17.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Assignment {
    private int id;
    private int userId;
    private String title;
    private String body;
}

package com.glimmer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recommendation {
    String username;
    String phone;
    String identity;
    String school;
    String major;
    Integer numWork;
    Integer numProject;
    String nature;
}

package com.glimmer.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Requirement {

    private String position;
    private String ask;
    private String salary;

}

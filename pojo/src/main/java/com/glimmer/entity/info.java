package com.glimmer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class info {

    private String stuPosition;
    private Date stuStartTime;
    private Date stuEndTime;
    private String stuDetail;
    private String scholarship;
    private Date scholarshipTime;
    private String scholarshipDetail;
    private String clubPosition;
    private Date clubStartTime;
    private Date clubEndTime;
    private String clubDetail;
    private String projectName;
    private String projectPosition;
    private Date projectStartTime;
    private Date projectEndTime;
    private String projectDetail;
    private String socialAct;
    private Date actStartTime;
    private Date actEndTime;
    private String actDetail;
    private String companyName;
    private String workPosition;
    private Date workStartTime;
    private Date workEndTime;
    private String workDetail;
    private String school;
    private String major;
    private String degree;
    private double grade;
    private int rank;
    private int gender;
    private String phone;
    private String email;
    private String identity;
}

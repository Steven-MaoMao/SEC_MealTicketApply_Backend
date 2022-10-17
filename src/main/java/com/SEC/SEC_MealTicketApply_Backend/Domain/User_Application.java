package com.SEC.SEC_MealTicketApply_Backend.Domain;

import lombok.Data;

@Data
public class User_Application {
    private int id;
    private String applicant;
    private String applicantName;
    private String applyDate;
    private int applyNum;
    private String applyReason;
    private String approver;
    private String approverName;
    private String approvalState;
    private String approvalDate;
}

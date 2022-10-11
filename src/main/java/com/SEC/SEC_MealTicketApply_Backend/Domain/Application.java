package com.SEC.SEC_MealTicketApply_Backend.Domain;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Application {
    private int id;
    private String applicant;
    private String applyDate;
    private int applyNum;
    private String applyReason;
    private String approver;
    private String approvalState;
    private String approvalDate;
}

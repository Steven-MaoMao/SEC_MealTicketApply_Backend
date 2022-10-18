package com.SEC.SEC_MealTicketApply_Backend.Domain;

import lombok.Data;

// 数据库Application对应的实体类
@Data
public class Application {
//  申请id
    private int id;

//  申请人
    private String applicant;

//  申请日期
    private String applyDate;

//  申请数量
    private int applyNum;

//  申请原因
    private String applyReason;

//  审批人
    private String approver;

//  审批状态
    private String approvalState;

//  审批日期
    private String approvalDate;
}

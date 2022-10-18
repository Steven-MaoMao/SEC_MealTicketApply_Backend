package com.SEC.SEC_MealTicketApply_Backend.Domain;

import lombok.Data;

// Application表左连接查询User表使用的数据结构
@Data
public class User_Application {
//  申请id
    private int id;

//  申请人
    private String applicant;

//  申请人姓名
    private String applicantName;

//  申请日期
    private String applyDate;

//  申请数量
    private int applyNum;

//  申请原因
    private String applyReason;

//  审批人
    private String approver;

//  审批人姓名
    private String approverName;

//  审批状态
    private String approvalState;

//  审批日期
    private String approvalDate;
}

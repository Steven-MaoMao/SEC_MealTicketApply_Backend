package com.SEC.SEC_MealTicketApply_Backend.Domain;

import lombok.Data;

// 数据库Ticket对应的实体类
@Data
public class Ticket {
//  饭票id
    private int id;

//  申请id
    private int orderId;

//  使用状态
    private String state;

//  发放日期
    private String appearDate;

//  使用日期
    private String useDate;

//  截至日期
    private String expiredDate;
}

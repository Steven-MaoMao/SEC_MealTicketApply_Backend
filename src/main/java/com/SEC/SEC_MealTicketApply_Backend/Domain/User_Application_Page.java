package com.SEC.SEC_MealTicketApply_Backend.Domain;

import lombok.Data;

import java.util.List;

// 查询申请分页返回时使用的数据格式
@Data
public class User_Application_Page {
//  申请列表
    private List<User_Application> records;

//  数据总数
    private int total;

//  当前页码
    private int current;

//  每页数据量
    private int size;
}

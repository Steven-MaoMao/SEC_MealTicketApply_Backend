package com.SEC.SEC_MealTicketApply_Backend.Domain;

import lombok.Data;

import java.util.List;

// 查询饭票分页返回时使用的数据格式
@Data
public class Ticket_Page {
//  饭票列表
    private List<Ticket> records;

//  数据总数
    private int total;

//  当前页码
    private int current;

//  每页数据量
    private int size;
}

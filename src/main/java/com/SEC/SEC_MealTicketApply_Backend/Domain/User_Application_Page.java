package com.SEC.SEC_MealTicketApply_Backend.Domain;

import lombok.Data;

import java.util.List;

@Data
public class User_Application_Page {
    private List<User_Application> records;
    private int total;
    private int current;
    private int size;
}

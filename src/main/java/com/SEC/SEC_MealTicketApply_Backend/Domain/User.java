package com.SEC.SEC_MealTicketApply_Backend.Domain;

import lombok.Data;

@Data
public class User {
    private String wno;
    private String name;
    private String phone;
    private String email;
    private String company;
    private String department;
    private String role;
    private String password;
}

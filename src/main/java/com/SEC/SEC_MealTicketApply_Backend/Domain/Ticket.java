package com.SEC.SEC_MealTicketApply_Backend.Domain;

import lombok.Data;

@Data
public class Ticket {
    private int id;
    private int orderId;
    private String state;
    private String appearDate;
    private String useDate;
    private String expiredDate;
}

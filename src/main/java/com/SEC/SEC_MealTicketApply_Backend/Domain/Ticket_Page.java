package com.SEC.SEC_MealTicketApply_Backend.Domain;

import lombok.Data;

import java.util.List;

@Data
public class Ticket_Page {
    private List<Ticket> records;
    private int total;
    private int current;
    private int size;
}

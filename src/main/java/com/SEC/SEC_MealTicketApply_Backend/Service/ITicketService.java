package com.SEC.SEC_MealTicketApply_Backend.Service;

import com.SEC.SEC_MealTicketApply_Backend.Domain.Ticket;
import com.SEC.SEC_MealTicketApply_Backend.Domain.User_Application;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface ITicketService extends IService<Ticket> {
    List<Ticket> getTicket(String phone, int start, int size);
}

package com.SEC.SEC_MealTicketApply_Backend.Service.Impl;

import com.SEC.SEC_MealTicketApply_Backend.Dao.TicketDao;
import com.SEC.SEC_MealTicketApply_Backend.Domain.Ticket;
import com.SEC.SEC_MealTicketApply_Backend.Service.ITicketService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl extends ServiceImpl<TicketDao, Ticket> implements ITicketService {
    @Autowired
    TicketDao ticketDao;

    @Override
    public List<Ticket> getTicket(String phone, int start, int size) {
        return ticketDao.getTicket(phone, start, size);
    }
}

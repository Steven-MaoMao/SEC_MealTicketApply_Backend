package com.SEC.SEC_MealTicketApply_Backend.Service.Impl;

import com.SEC.SEC_MealTicketApply_Backend.Dao.TicketDao;
import com.SEC.SEC_MealTicketApply_Backend.Domain.Ticket;
import com.SEC.SEC_MealTicketApply_Backend.Service.ITicketService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl extends ServiceImpl<TicketDao, Ticket> implements ITicketService {
}

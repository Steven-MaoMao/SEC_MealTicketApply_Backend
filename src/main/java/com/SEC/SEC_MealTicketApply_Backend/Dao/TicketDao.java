package com.SEC.SEC_MealTicketApply_Backend.Dao;

import com.SEC.SEC_MealTicketApply_Backend.Domain.Ticket;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TicketDao extends BaseMapper<Ticket> {
}

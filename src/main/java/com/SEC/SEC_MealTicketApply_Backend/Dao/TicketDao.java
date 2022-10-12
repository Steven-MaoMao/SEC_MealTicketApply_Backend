package com.SEC.SEC_MealTicketApply_Backend.Dao;

import com.SEC.SEC_MealTicketApply_Backend.Domain.Ticket;
import com.SEC.SEC_MealTicketApply_Backend.Domain.User_Application;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TicketDao extends BaseMapper<Ticket> {
    @Select("select * " +
            "from ticket " +
            "left join application on ticket.orderId = application.id " +
            "where application.applicant = #{phone} " +
            "order by ticket.id desc " +
            "limit #{start}, #{size};")
    List<Ticket> getTicket(String phone, int start, int size);
}

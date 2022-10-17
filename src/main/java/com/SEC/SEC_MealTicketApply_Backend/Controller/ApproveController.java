package com.SEC.SEC_MealTicketApply_Backend.Controller;

import com.SEC.SEC_MealTicketApply_Backend.Domain.Application;
import com.SEC.SEC_MealTicketApply_Backend.Domain.Ticket;
import com.SEC.SEC_MealTicketApply_Backend.Service.IApplicationService;
import com.SEC.SEC_MealTicketApply_Backend.Service.ITicketService;
import com.SEC.SEC_MealTicketApply_Backend.Service.IUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@RestController
@RequestMapping("/approve")
@CrossOrigin
public class ApproveController {
    @Autowired
    private IUserService userService;
    @Autowired
    private IApplicationService applicationService;
    @Autowired
    private ITicketService ticketService;

    // 审批通过
    @PutMapping("/pass")
    public boolean pass(@RequestBody Application application) {
        try {
            QueryWrapper<Ticket> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("orderId", application.getId());
            ticketService.remove(queryWrapper);

            applicationService.updateById(application);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            String appearDate = simpleDateFormat.format(date);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.DAY_OF_YEAR, 3);
            date = calendar.getTime();
            String expiredDate = simpleDateFormat.format(date);
            for(int i=0;i<application.getApplyNum();i++) {
                Ticket ticket = new Ticket();
                ticket.setOrderId(application.getId());
                ticket.setAppearDate(appearDate);
                ticket.setExpiredDate(expiredDate);
                ticketService.save(ticket);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // 审批不通过
    @PutMapping("/fail")
    public boolean fail(@RequestBody Application application) {
        try {
            QueryWrapper<Ticket> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("orderId", application.getId());
            ticketService.remove(queryWrapper);
            applicationService.updateById(application);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

package com.SEC.SEC_MealTicketApply_Backend.Controller;

import com.SEC.SEC_MealTicketApply_Backend.Domain.Application;
import com.SEC.SEC_MealTicketApply_Backend.Domain.Ticket;
import com.SEC.SEC_MealTicketApply_Backend.Domain.Ticket_Page;
import com.SEC.SEC_MealTicketApply_Backend.Service.IApplicationService;
import com.SEC.SEC_MealTicketApply_Backend.Service.ITicketService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
@CrossOrigin
public class TicketController {
    @Autowired
    private ITicketService ticketService;
    @Autowired
    private IApplicationService applicationService;

    // 对所有饭票记录分页返回
    @GetMapping("/page/{current}/{size}")
    public IPage<Ticket> getPage(@PathVariable int current, @PathVariable int size) {
        IPage<Ticket> page = new Page<Ticket>(current, size);
        QueryWrapper<Ticket> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        return ticketService.page(page, queryWrapper);
    }

    // 用id查询饭票，分页返回
    @GetMapping("/pageById/{id}/{current}/{size}")
    public IPage<Ticket> getPageById(@PathVariable int id, @PathVariable int current, @PathVariable int size) {
        IPage<Ticket> page = new Page<Ticket>(current, size);
        QueryWrapper<Ticket> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id).orderByDesc("id");
        return ticketService.page(page, queryWrapper);
    }

    // 用申请id查询饭票，分页返回
    @GetMapping("/pageByOrderId/{orderId}/{current}/{size}")
    public IPage<Ticket> getPageByOrderId(@PathVariable int orderId, @PathVariable int current, @PathVariable int size) {
        IPage<Ticket> page = new Page<Ticket>(current, size);
        QueryWrapper<Ticket> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("orderId", orderId).orderByDesc("id");
        return ticketService.page(page, queryWrapper);
    }

    // 用申请id查询饭票，全部返回
    @GetMapping("/getByOrderId/{orderId}")
    public List<Ticket> getByOrderId(@PathVariable int orderId) {
        QueryWrapper<Ticket> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("orderId", orderId).orderByDesc("id");
        return ticketService.list(queryWrapper);
    }

    // 用状态查询饭票，分页返回
    @GetMapping("/pageByState/{state}/{current}/{size}")
    public IPage<Ticket> getPageByState(@PathVariable String state, @PathVariable int current, @PathVariable int size) {
        IPage<Ticket> page = new Page<Ticket>(current, size);
        QueryWrapper<Ticket> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("state", state).orderByDesc("id");
        return ticketService.page(page, queryWrapper);
    }

    // 用生成日期查询饭票，分页返回
    @GetMapping("/pageByAppearDate/{date}/{current}/{size}")
    public IPage<Ticket> getPageByAppearDate(@PathVariable String date, @PathVariable int current, @PathVariable int size) {
        IPage<Ticket> page = new Page<Ticket>(current, size);
        QueryWrapper<Ticket> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("appearDate", date).orderByDesc("id");
        return ticketService.page(page, queryWrapper);
    }

    // 用手机查询饭票，分页返回
    @GetMapping("/getTicket/{phone}/{current}/{size}")
    public Ticket_Page getTicket(@PathVariable String phone, @PathVariable int current, @PathVariable int size) {
        int start = (current - 1) * size;
        Ticket_Page data = new Ticket_Page();
        data.setRecords(ticketService.getTicket(phone, start, size));
        QueryWrapper<Application> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("applicant", phone);
        queryWrapper.eq("approvalState", "通过");
        List<Application> list = applicationService.list(queryWrapper);
        int sum = 0;
        for(int i=0;i<list.size();i++) {
            sum += list.get(i).getApplyNum();
        }
        data.setTotal(sum);
        data.setCurrent(current);
        data.setSize(size);
        return data;
    }

    // 根据id更新一条饭票记录
    @PutMapping
    public boolean update(@RequestBody Ticket ticket) {
        try {
            return ticketService.updateById(ticket);
        } catch (Exception e) {
            return false;
        }
    }
}

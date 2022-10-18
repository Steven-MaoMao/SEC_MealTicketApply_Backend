package com.SEC.SEC_MealTicketApply_Backend.Controller;

import com.SEC.SEC_MealTicketApply_Backend.Domain.Application;
import com.SEC.SEC_MealTicketApply_Backend.Domain.User;
import com.SEC.SEC_MealTicketApply_Backend.Domain.User_Application_Page;
import com.SEC.SEC_MealTicketApply_Backend.Service.IApplicationService;
import com.SEC.SEC_MealTicketApply_Backend.Service.IUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/applications")
@CrossOrigin
public class ApplicationController {
    @Autowired
    private IApplicationService applicationService;
    @Autowired
    private IUserService userService;

//  添加申请
    @PostMapping
    public boolean save(@RequestBody Application application) {
        try {
            return applicationService.save(application);
        } catch (Exception e) {
            return false;
        }
    }

//  删除申请
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable int id) {
        try {
            return applicationService.removeById(id);
        } catch (Exception e) {
            return false;
        }
    }

//  对所有的申请记录分页返回
    @GetMapping("/page/{current}/{size}")
    public IPage<Application> getPage(@PathVariable int current, @PathVariable int size) {
        QueryWrapper<Application> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        IPage<Application> page = new Page<Application>(current, size);
        return applicationService.page(page, queryWrapper);
    }

//  对某用户的申请记录分页返回
    @GetMapping("/pageByPhone/{phone}/{current}/{size}")
    public User_Application_Page getPageByPhone(@PathVariable String phone, @PathVariable int current, @PathVariable int size) {
        int start = (current - 1) * size;
        User_Application_Page data = new User_Application_Page();
        data.setRecords(applicationService.getMyApply(phone, start, size));
        QueryWrapper<Application> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("applicant", phone);
        data.setTotal((int)applicationService.count(queryWrapper));
        data.setCurrent(current);
        data.setSize(size);
        return data;
    }

//  对待审批的申请分页返回
    @GetMapping("/toApprove/{phone}/{current}/{size}")
    public User_Application_Page getToApprove(@PathVariable String phone, @PathVariable int current, @PathVariable int size) {
        int start = (current - 1) * size;
        User_Application_Page data = new User_Application_Page();
        data.setRecords(applicationService.getToApprove(phone, start, size));
        QueryWrapper<Application> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("approvalState", "待审批");
        List<Application> records = applicationService.list(queryWrapper);
        int sum = 0;
        for(int i=0;i<records.size();i++) {
            QueryWrapper<User> applicantQW = new QueryWrapper<>();
            applicantQW.eq("phone", records.get(i).getApplicant());
            String applicantDepartment = userService.getOne(applicantQW).getDepartment();

            QueryWrapper<User> approverQW = new QueryWrapper<>();
            approverQW.eq("phone", phone);
            String approverDepartment = userService.getOne(approverQW).getDepartment();

            if(applicantDepartment.equals(approverDepartment)) {
                sum += 1;
            }
        }
        data.setTotal(sum);
        data.setCurrent(current);
        data.setSize(size);
        return data;
    }

//  对某用户的已审批记录分页返回
    @GetMapping("/approved/{phone}/{current}/{size}")
    public User_Application_Page getApproved(@PathVariable String phone, @PathVariable int current, @PathVariable int size) {
        int start = (current - 1) * size;
        User_Application_Page data = new User_Application_Page();
        data.setRecords(applicationService.getMyApprove(phone, start, size));
        QueryWrapper<Application> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("approver", phone);
        data.setTotal((int)applicationService.count(queryWrapper));
        data.setCurrent(current);
        data.setSize(size);
        return data;
    }

//  对符合查询条件的申请记录分页返回
    @PostMapping("/page/select/{current}/{size}")
    public IPage<Application> getSelectPage(@RequestBody Application select, @PathVariable int current, @PathVariable int size) {
        IPage<Application> page = new Page<Application>(current, size);
        QueryWrapper<Application> queryWrapper = new QueryWrapper<>();
        if(select.getId() > 0) {
            queryWrapper.eq("id", select.getId());
        }
        if(select.getApplicant() != "") {
            queryWrapper.eq("applicant", select.getApplicant());
        }
        if(select.getApplyDate() != null) {
            queryWrapper.eq("applyDate", select.getApplyDate());
        }
        if(select.getApprover() != "") {
            queryWrapper.eq("approver", select.getApprover());
        }
        if(select.getApprovalState() != "") {
            queryWrapper.eq("approvalState", select.getApprovalState());
        }
        if(select.getApprovalDate() != null) {
            queryWrapper.eq("approvalDate", select.getApprovalDate());
        }
        queryWrapper.orderByDesc("id");
        return applicationService.page(page, queryWrapper);
    }

//  根据id更新一条申请
    @PutMapping
    public boolean update(@RequestBody Application application) {
        try {
            return applicationService.updateById(application);
        } catch (Exception e) {
            return false;
        }
    }
}

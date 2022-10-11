package com.SEC.SEC_MealTicketApply_Backend.Service;

import com.SEC.SEC_MealTicketApply_Backend.Domain.Application;
import com.SEC.SEC_MealTicketApply_Backend.Domain.User_Application;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface IApplicationService extends IService<Application> {
    List<User_Application> getMyApply(String phone, int start, int size);
    List<User_Application> getMyApprove(String phone, int start, int size);
    List<User_Application> getToApprove(String phone, int start, int size);
}

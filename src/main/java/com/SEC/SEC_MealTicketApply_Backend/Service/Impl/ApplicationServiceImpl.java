package com.SEC.SEC_MealTicketApply_Backend.Service.Impl;

import com.SEC.SEC_MealTicketApply_Backend.Dao.ApplicationDao;
import com.SEC.SEC_MealTicketApply_Backend.Domain.Application;
import com.SEC.SEC_MealTicketApply_Backend.Domain.User_Application;
import com.SEC.SEC_MealTicketApply_Backend.Service.IApplicationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationServiceImpl extends ServiceImpl<ApplicationDao, Application> implements IApplicationService {
    @Autowired
    ApplicationDao applicationDao;

    @Override
    public List<User_Application> getMyApply(String phone, int start, int size) {
        return applicationDao.getMyApply(phone, start, size);
    }

    @Override
    public List<User_Application> getMyApprove(String phone, int start, int size) {
        return applicationDao.getMyApprove(phone, start, size);
    }

    @Override
    public List<User_Application> getToApprove(String phone, int start, int size) {
        return applicationDao.getToApprove(phone, start, size);
    }
}

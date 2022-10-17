package com.SEC.SEC_MealTicketApply_Backend.Service.Impl;

import com.SEC.SEC_MealTicketApply_Backend.Dao.UserDao;
import com.SEC.SEC_MealTicketApply_Backend.Domain.User;
import com.SEC.SEC_MealTicketApply_Backend.Service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements IUserService {
}
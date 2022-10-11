package com.SEC.SEC_MealTicketApply_Backend.Service;

import com.SEC.SEC_MealTicketApply_Backend.Domain.User;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTestCase {
    @Autowired
    private IUserService userservice;
    @Autowired
    private IApplicationService applicationService;

    @Test
    void testSave() {
        User user = new User();
        user.setWno("00000003");
        user.setName("员工3");
        user.setPhone("30000000");
        user.setEmail("3@qq.com");
        user.setCompany("上海电气");
        user.setDepartment("IT部");
        user.setRole("user");
        user.setPassword("123456");
        System.out.println(userservice.save(user));
    }

    @Test
    void testList() {
        System.out.println(userservice.list());
    }

    @Test
    void testDelete() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("wno", "00000003");
        userservice.remove(queryWrapper);
    }

    @Test
    void test() {
        applicationService.getMyApply("18116468332", 0, 10);
    }
}

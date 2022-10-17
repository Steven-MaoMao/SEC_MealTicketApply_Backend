package com.SEC.SEC_MealTicketApply_Backend.Dao;

import com.SEC.SEC_MealTicketApply_Backend.Domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserDaoTestCase {
    @Autowired
    private UserDao userdao;

    @Test
    void testSelectList() {
        userdao.selectList(null);
    }
}

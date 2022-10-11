package com.SEC.SEC_MealTicketApply_Backend.Dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ApplicationDaoTestCase {
    @Autowired
    private ApplicationDao orderDao;

    @Test
    void testSelectList() {
        orderDao.selectList(null);
    }
}

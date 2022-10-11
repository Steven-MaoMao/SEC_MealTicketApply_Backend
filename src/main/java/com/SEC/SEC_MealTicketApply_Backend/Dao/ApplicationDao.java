package com.SEC.SEC_MealTicketApply_Backend.Dao;

import com.SEC.SEC_MealTicketApply_Backend.Domain.Application;
import com.SEC.SEC_MealTicketApply_Backend.Domain.User_Application;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import javax.websocket.server.ServerEndpoint;
import java.util.List;

@Mapper
public interface ApplicationDao extends BaseMapper<Application> {
    @Select("select " +
            "application.id, " +
            "application.applicant, " +
            "user1.name as applicantName, " +
            "application.applyDate, " +
            "application.applyNum, " +
            "application.applyReason, " +
            "application.approver, " +
            "user2.name as approverName, " +
            "application.approvalState, " +
            "application.approvalDate " +
            "from application " +
            "left join user as user1 on application.applicant = user1.phone " +
            "left join user as user2 on application.approver = user2.phone " +
            "where application.applicant = #{phone} " +
            "order by application.id desc " +
            "limit #{start}, #{size};")
    List<User_Application> getMyApply(String phone, int start, int size);

    @Select("select " +
            "application.id, " +
            "application.applicant, " +
            "user1.name as applicantName, " +
            "application.applyDate, " +
            "application.applyNum, " +
            "application.applyReason, " +
            "application.approver, " +
            "user2.name as approverName, " +
            "application.approvalState, " +
            "application.approvalDate " +
            "from application " +
            "left join user as user1 on application.applicant = user1.phone " +
            "left join user as user2 on application.approver = user2.phone " +
            "where application.approver = #{phone} " +
            "order by application.id desc " +
            "limit #{start}, #{size};")
    List<User_Application> getMyApprove(String phone, int start, int size);

    @Select("select " +
            "application.id, " +
            "application.applicant, " +
            "user1.name as applicantName, " +
            "application.applyDate, " +
            "application.applyNum, " +
            "application.applyReason, " +
            "application.approver, " +
            "user2.name as approverName, " +
            "application.approvalState, " +
            "application.approvalDate " +
            "from application " +
            "left join user as user1 on application.applicant = user1.phone " +
            "left join user as user2 on application.approver = user2.phone " +
            "where application.approvalState = '待审批' and user1.department = (select department from user where phone = #{phone}) " +
            "order by application.id desc " +
            "limit #{start}, #{size};")
    List<User_Application> getToApprove(String phone, int start, int size);
}

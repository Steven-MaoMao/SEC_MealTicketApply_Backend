package com.SEC.SEC_MealTicketApply_Backend.Controller;

import com.SEC.SEC_MealTicketApply_Backend.Domain.User;
import com.SEC.SEC_MealTicketApply_Backend.Service.IUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {
    @Autowired
    private IUserService userService;

//  添加用户
    @PostMapping
    public boolean save(@RequestBody User user) {
        try {
            return userService.save(user);
        } catch (Exception e) {
            return false;
        }
    }

//  根据手机号删除用户
    @DeleteMapping("/phone/{phone}")
    public boolean deleteByPhone(@PathVariable String phone) {
        try {
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("phone", phone);
            return userService.remove(queryWrapper);
        } catch (Exception e) {
            return false;
        }
    }

//  根据工号删除用户
    @DeleteMapping("/wno/{wno}")
    public boolean deleteByWno(@PathVariable String wno) {
        try {
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("wno", wno);
            return userService.remove(queryWrapper);
        } catch (Exception e) {
            return false;
        }
    }

//  根据手机号更新用户信息
    @PutMapping("/phone/{phone}")
    public boolean updateByPhone(@PathVariable String phone, @RequestBody User user) {
        try {
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("phone", phone);
            return userService.update(user, queryWrapper);
        } catch (Exception e) {
            return false;
        }
    }

//  根据工号更新用户信息
    @PutMapping("/wno/{wno}")
    public boolean updateByWno(@PathVariable String wno, @RequestBody User user) {
        try {
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("wno", wno);
            return userService.update(user, queryWrapper);
        } catch (Exception e) {
            return false;
        }
    }

//  获取全部用户数据
    @GetMapping
    public List<User> getAll() {
        return userService.list();
    }

//  根据手机号返回一个用户
    @GetMapping("/phone/{phone}")
    public User getByPhone(@PathVariable String phone) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("phone", phone);
        return userService.getOne(queryWrapper);
    }

//  根据工号返回一个用户
    @GetMapping("/wno/{wno}")
    public User getByWno(@PathVariable String wno) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("wno", wno);
        return userService.getOne(queryWrapper);
    }

//  将所有用户分页返回
    @GetMapping("/page/{current}/{size}")
    public IPage<User> getPage(@PathVariable int current, @PathVariable int size) {
        IPage<User> page = new Page<User>(current, size);
        return userService.page(page);
    }

//  根据工号查询一个用户，用分页的方式返回
    @GetMapping("/pageByWno/{wno}/{current}/{size}")
    public IPage<User> getPageByWno(@PathVariable String wno, @PathVariable int current, @PathVariable int size) {
        IPage<User> page = new Page<User>(current, size);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("wno", wno);
        return userService.page(page, queryWrapper);
    }

//  根据名字模糊查询一个用户，用分页的方式返回
    @GetMapping("/pageByName/{name}/{current}/{size}")
    public IPage<User> getPageByName(@PathVariable String name, @PathVariable int current, @PathVariable int size) {
        IPage<User> page = new Page<User>(current, size);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", name);
        return userService.page(page, queryWrapper);
    }

//  根据手机号查询一个用户，用分页的方式返回
    @GetMapping("/pageByPhone/{phone}/{current}/{size}")
    public IPage<User> getPageByPhone(@PathVariable String phone, @PathVariable int current, @PathVariable int size) {
        IPage<User> page = new Page<User>(current, size);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("phone", phone);
        return userService.page(page, queryWrapper);
    }

//  根据邮箱模糊查询一个用户，用分页的方式返回
    @GetMapping("/pageByEmail/{email}/{current}/{size}")
    public IPage<User> getPageByEmail(@PathVariable String email, @PathVariable int current, @PathVariable int size) {
        IPage<User> page = new Page<User>(current, size);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("email", email);
        return userService.page(page, queryWrapper);
    }

//  根据公司模糊查询一个用户，用分页的方式返回
    @GetMapping("/pageByCompany/{company}/{current}/{size}")
    public IPage<User> getPageByCompany(@PathVariable String company, @PathVariable int current, @PathVariable int size) {
        IPage<User> page = new Page<User>(current, size);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("company", company);
        return userService.page(page, queryWrapper);
    }

//  根据部门模糊查询一个用户，用分页的方式返回
    @GetMapping("/pageByDepartment/{department}/{current}/{size}")
    public IPage<User> getPageByDepartment(@PathVariable String department, @PathVariable int current, @PathVariable int size) {
        IPage<User> page = new Page<User>(current, size);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("department", department);
        return userService.page(page, queryWrapper);
    }

//  根据身份查询一类用户，用分页的方式返回
    @GetMapping("/pageByRole/{role}/{current}/{size}")
    public IPage<User> getPageByRole(@PathVariable String role, @PathVariable int current, @PathVariable int size) {
        IPage<User> page = new Page<User>(current, size);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("role", role);
        return userService.page(page, queryWrapper);
    }
}

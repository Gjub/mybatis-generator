package com.jxkj.manage.controller;

import com.jxkj.manage.comm.ResultBody;
import com.jxkj.manage.pojo.User;
import com.jxkj.manage.service.IUserService;
import com.jxkj.manage.util.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService iUserService;

    /**
     * 登录功能
     * @param username
     * @param password
     * @return
     */
    @PostMapping("login")
    public ResultBody login(String username,String password){
        return iUserService.login(username,password);
    }

    @PostMapping("register")
    public ResultBody register(String username,String password,String tel){
        return iUserService.register(username,password,tel);
    }

    @GetMapping("findAll")
    public ResultBody findAllUser(){
        return iUserService.findAllUser();
    }

    @GetMapping("findById")
    public ResultBody findUserById(Long userId){
        return iUserService.findById(userId);
    }

    @PostMapping("update")
    public ResultBody updateUser(User user){
        return iUserService.updateUser(user);
    }

    @PostMapping("delete")
    public ResultBody deleteById(Long userId){
        return iUserService.deleteUserById(userId);
    }
}

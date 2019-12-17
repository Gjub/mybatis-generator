package com.jxkj.manage.service;

import com.jxkj.manage.comm.ResultBody;
import com.jxkj.manage.pojo.User;


public interface IUserService {
    /**
     * 登录验证
     * @param username
     * @param password
     * @return
     */
    ResultBody login(String username,String password);
    //注册新管理员
    ResultBody register(String username,String password,String tel);
    //查看所有用户
    ResultBody findAllUser();
    //通过id查找用户
    ResultBody findById(Long userId);
    //更新用户
    ResultBody updateUser(User user);
    //通过id删除一个用户
    ResultBody deleteUserById(Long userId);
}

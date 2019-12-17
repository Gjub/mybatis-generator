package com.jxkj.manage.service.impl;

import com.jxkj.manage.comm.ResultBody;
import com.jxkj.manage.dao.UserMapper;
import com.jxkj.manage.pojo.User;
import com.jxkj.manage.pojo.UserExample;
import com.jxkj.manage.pojo.WareHouse;
import com.jxkj.manage.service.IUserService;
import com.jxkj.manage.util.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.UUID;

@Service
public class IUserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public ResultBody login(String username, String password) {
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andNameEqualTo(username)
                .andPasswordEqualTo(password);
        List<User> list = userMapper.selectByExample(userExample);
        if (list.size() > 0) {
            return ResultUtils.success(list);
        } else {
            return ResultUtils.error(1, "用户名或密码错误");
        }

    }

    @Override
    public ResultBody register(String username, String password,String tel) {
        //用户名是否已经被注册
        UserExample userExample = new UserExample();
        userExample.or().andNameEqualTo(username);
        List<User> users = userMapper.selectByExample(userExample);
        if (users.size() > 0) {
            return ResultUtils.error(1, "用户名已存在");
        }
        User user = new User();
        user.setName(username);
        user.setPassword(password);
        user.setTel(tel);
        int i = userMapper.insertSelective(user);
        if (i > 0) {
            return ResultUtils.success();
        } else {
            return ResultUtils.error(1, "注册失败，请重试");
        }

    }

    @Override
    public ResultBody findAllUser() {
        List<User> users = userMapper.selectAllUser();
        return ResultUtils.success(users);
    }

    @Override
    public ResultBody findById(Long userId) {
        UserExample userExample = new UserExample();
        userExample.or().andUserIdEqualTo(userId);
        List<User> users = userMapper.selectByExample(userExample);
        return ResultUtils.success(users);
    }

    @Override
    public ResultBody updateUser(User user) {
        userMapper.updateByPrimaryKey(user);
        return ResultUtils.success();
    }

    @Override
    public ResultBody deleteUserById(Long userId) {
        userMapper.deleteByPrimaryKey(userId);
        return ResultUtils.success();
    }
}

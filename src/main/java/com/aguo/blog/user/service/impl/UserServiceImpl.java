package com.aguo.blog.user.service.impl;

import com.aguo.blog.user.co.UserCo;
import com.aguo.blog.user.domainmodel.UserCmd;
import com.aguo.blog.user.entity.User;
import com.aguo.blog.user.mapper.UserMapper;
import com.aguo.blog.user.service.IUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author aguo
 * @since 2021-12-07
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public Boolean loginUser(UserCmd cmd) {
        UserCo userCo = cmd.getUserCo();
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",userCo.getUsername());
        queryWrapper.eq("password",userCo.getPassword());
        User user = this.getOne(queryWrapper);
        log.info("查询出来的用户为:",user);
        return user != null;
    }
}

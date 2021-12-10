package com.aguo.blog.user.service.impl;

import com.aguo.blog.authority.utils.JWTTokenUtil;
import com.aguo.blog.response.code.RCode;
import com.aguo.blog.response.error.BaseException;
import com.aguo.blog.user.co.UserCo;
import com.aguo.blog.user.co.UserUpdatePwdCo;
import com.aguo.blog.user.domainmodel.UserCmd;
import com.aguo.blog.user.domainmodel.UserUpdatePwdCmd;
import com.aguo.blog.user.entity.User;
import com.aguo.blog.user.mapper.UserMapper;
import com.aguo.blog.user.service.IUserService;
import com.aguo.blog.user.vo.UserVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

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
        if (user == null){
            throw new BaseException(RCode.LOGIN_ERROR);
        }
        String token = JWTTokenUtil.token(user.getUsername(), user.getPassword());
        log.info("身份令牌："+token);
        return true;
    }

    @Override
    public UserVo getUser() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("author","wechat","qq","github").eq("id",1);
        User one = this.getOne(queryWrapper);
        UserVo vo = new UserVo();
        BeanUtils.copyProperties(one,vo);
        return vo;
    }

    @Override
    public Boolean updatePassword(UserUpdatePwdCmd cmd) {
        UserUpdatePwdCo userUpdatePwdCo = cmd.getUserUpdatePwdCo();

        //先查询是否存在该用户
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",userUpdatePwdCo.getUsername());
        queryWrapper.eq("password",userUpdatePwdCo.getOldPassword());
        User one = this.getOne(queryWrapper);
        if (one == null){
            throw new BaseException(RCode.USER_UPDATE_ERROR);
        }

        //存在则修改密码
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("username",one.getUsername()).set("password",userUpdatePwdCo.getNewPassword());
        boolean update = this.update(updateWrapper);
        return update;
    }
}

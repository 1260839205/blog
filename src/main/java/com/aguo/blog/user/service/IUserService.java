package com.aguo.blog.user.service;

import com.aguo.blog.user.domainmodel.UserCmd;
import com.aguo.blog.user.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author aguo
 * @since 2021-12-07
 */
public interface IUserService extends IService<User> {

    /**
     * 登录
     * @return 是否登录成功
     */
    Boolean loginUser(UserCmd cmd);
}

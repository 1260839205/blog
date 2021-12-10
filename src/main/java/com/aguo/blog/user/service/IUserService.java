package com.aguo.blog.user.service;

import com.aguo.blog.user.domainmodel.UserCmd;
import com.aguo.blog.user.domainmodel.UserUpdatePwdCmd;
import com.aguo.blog.user.entity.User;
import com.aguo.blog.user.vo.UserVo;
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

    /**
     * 查询用户信息
     * @return 用户信息
     */
    UserVo getUser();

    /**
     * 修改密码
     * @param cmd 入参修改数据
     * @return 是否修改成功
     */
    Boolean updatePassword(UserUpdatePwdCmd cmd);
}

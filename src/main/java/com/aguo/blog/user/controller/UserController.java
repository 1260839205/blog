package com.aguo.blog.user.controller;

import com.aguo.blog.user.domainmodel.UserCmd;
import com.aguo.blog.user.service.IUserService;
import com.baomidou.mybatisplus.extension.api.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author aguo
 * @since 2021-12-07
 */
@Slf4j
@Api(tags = "用户接口", value = "用户表")
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;

    @PostMapping("/login")
    @ApiOperation(value = "登录", notes = "账号&密码")
    public R<Boolean> loginUser(@RequestBody @Validated UserCmd cmd) {
        return R.ok(userService.loginUser(cmd));
    }
}

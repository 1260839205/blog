package com.aguo.blog.user.controller;

import com.aguo.blog.response.R;
import com.aguo.blog.response.annotation.BaseResponse;
import com.aguo.blog.response.code.RCode;
import com.aguo.blog.user.domainmodel.UserCmd;
import com.aguo.blog.user.domainmodel.UserUpdatePwdCmd;
import com.aguo.blog.user.service.IUserService;
import com.aguo.blog.user.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
@BaseResponse
@Api(tags = "用户接口", value = "用户表")
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    private IUserService userService;

    @PostMapping("/login")
    @ApiOperation(value = "登录", notes = "账号&密码")
    public Boolean loginUser(@RequestBody @Validated UserCmd cmd) {
        return userService.loginUser(cmd);
    }

    @GetMapping
    @ApiOperation(value = "查询博主信息", notes = "直接查询")
    public UserVo getUser(){
        return userService.getUser();
    }

    @PutMapping
    @ApiOperation(value = "修改密码",notes = "账号、旧密码、新密码")
    public Boolean updateUser(@RequestBody @Validated UserUpdatePwdCmd cmd){
        return userService.updatePassword(cmd);
    }

    @GetMapping("/test")
    @ApiOperation(value = "测试")
    public R  test() {
        return new R<>(RCode.SUCCESS.getCode(), RCode.SUCCESS.getMsg(), "成功");
    }
}

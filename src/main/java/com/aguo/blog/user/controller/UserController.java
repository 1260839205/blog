package com.aguo.blog.user.controller;

import com.aguo.blog.response.R;
import com.aguo.blog.response.annotation.BaseResponse;
import com.aguo.blog.response.code.RCode;
import com.aguo.blog.user.domainmodel.UserCmd;
import com.aguo.blog.user.domainmodel.UserRegisterCmd;
import com.aguo.blog.user.domainmodel.UserUpdatePwdCmd;
import com.aguo.blog.user.service.IUserService;
import com.aguo.blog.user.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

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
    public Map loginUser(@RequestBody @Validated UserCmd cmd) {
        Map<String,String> map = new HashMap<>(8);
        String token = userService.loginUser(cmd);
        map.put("Authentication",token);
        return map;
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

    @PostMapping("/register")
    @ApiOperation(value = "注册", notes = "注册")
    public Boolean register(@RequestBody @Validated UserRegisterCmd cmd){
        return userService.register(cmd);
    }

    @GetMapping("/test")
    @ApiOperation(value = "测试")
    public R  test(HttpServletRequest request) {
        System.out.println(request.getRemoteAddr());
        System.out.println(request.getRemoteHost());
        System.out.println(request.getRemoteUser());
        System.out.println(request.getRemotePort());
        return  new R<>(RCode.SUCCESS.getCode(),RCode.SUCCESS.getMsg(),"成功");
    }
}

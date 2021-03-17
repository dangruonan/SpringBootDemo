package com.dangruonan.demo.controller;


import com.dangruonan.demo.common.ResultDto;
import com.dangruonan.demo.common.ServiceException;
import com.dangruonan.demo.dto.UserDto;
import com.dangruonan.demo.service.DangruonanTestUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Api(tags = "dangruonan用户管理模块")
@RestController
@RequestMapping("dangruonan")
public class DangTestUserController {

    @Autowired
    private DangruonanTestUserService dangruonanTestUserService;

    @Value("${dangruonan.key1}")
//    获取配置文件的值
    private String dangruonankey1;

    //    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ApiOperation("登陆接口")
    @PostMapping("login")
    public ResultDto<UserDto> login(@RequestBody UserDto userDto){
        String result = dangruonanTestUserService.login(userDto);


            if (userDto.getName().contains("error")) {
                ServiceException.throwEx("用户名中有error");
            }
//        抛出空指针异常
            if (userDto.getName().contains("ccc")){
                throw new NullPointerException();
            }
        return ResultDto.success("登陆success" + result + "dangruonankey1" + dangruonankey1, userDto);
    }

    @PostMapping("register")
    public String register(@RequestBody UserDto userDto){
        return "注册成功";
    }


    //    @RequestMapping(value = "byId/{userID}/{id}", method = RequestMethod.GET)
    @GetMapping("byId/{userID}/{id}")
    public String getById(@PathVariable("userID") Long userID, @PathVariable("id") Long id){
        System.out.println(userID);
        System.out.println(id);
        return "success" + userID + id;
    }

    @GetMapping("byId")
    public String getById2(@RequestParam(value = "userID", required = false) Long userID, @RequestParam(value = "id", required = false) Long id){
        System.out.println(userID);
        System.out.println(id);
        return "success" + userID + id;
    }
}


package com.dangruonan.demo.service.impl;

import com.dangruonan.demo.dto.UserDto;
import com.dangruonan.demo.service.DangruonanTestUserService;
import org.springframework.stereotype.Service;

@Service
public class DangruonanTestUserServiceImpl implements DangruonanTestUserService {

    @Override
    public String login(UserDto userDto){
        System.out.println(userDto.getName());
        System.out.println(userDto.getPwd());
        return userDto.getName() + " " + userDto.getPwd();
    }
}

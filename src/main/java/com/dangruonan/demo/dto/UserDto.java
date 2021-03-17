package com.dangruonan.demo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "用户登陆类", description = "请求类")
public class UserDto {
    @ApiModelProperty(value = "用户名", example = "dangruonan", required = true)
    private String name;

    @ApiModelProperty(value = "用户密码", example = "dangruonan123", required = true)
    private String pwd;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}

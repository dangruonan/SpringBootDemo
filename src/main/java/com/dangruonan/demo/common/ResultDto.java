package com.dangruonan.demo.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/*
 *   响应返回类
*/
@ApiModel(value = "基础返回类", description = "基础返回类")
public class ResultDto<T> implements Serializable {

//    private static final long serialVersionUID = ;

    @ApiModelProperty(value = "成功为1，失败为0", required = true, allowableValues = "1,0")
    private Integer resultCode;

    @ApiModelProperty(value = "提示信息", required = true, allowableValues = "成功，失败")
    private String message = "";

    @ApiModelProperty(value = "响应结果数据")
    private T data = null;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ResultDto newInstance(){return new ResultDto();}

    public Integer getResultCode() {
        return resultCode;
    }

    public void setAsSuccess(){this.resultCode = 1;}

    public void setAsFailure(){this.resultCode = 0;}


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static ResultDto success(String message){
        ResultDto resultDto = new ResultDto<>();
        resultDto.setAsSuccess();
        resultDto.setMessage(message);
        return resultDto;
    }

    public static <T> ResultDto<T>  success(String message, T data){
        ResultDto resultDto = new ResultDto<>();
        resultDto.setAsSuccess();
        resultDto.setMessage(message);
        resultDto.setData(data);
        return resultDto;
    }

    public static <T> ResultDto<T> fail(String message, T data){
        ResultDto resultDto = new ResultDto<>();
        resultDto.setAsFailure();
        resultDto.setMessage(message);
        resultDto.setData(data);
        return resultDto;
    }

    public static ResultDto fail(String message){
        ResultDto resultDto = new ResultDto<>();
        resultDto.setAsFailure();
        resultDto.setMessage(message);
        return resultDto;
    }
}

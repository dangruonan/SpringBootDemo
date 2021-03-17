package com.dangruonan.demo.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

//全局异常
@Slf4j
@RestControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler({ServiceException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultDto serviceExceptionHandler(ServiceException se){
        return resultFormat(se);
    }

    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    public ResultDto exceptionHandler(Exception ex){
        return resultFormat(ex);
    }

    @ExceptionHandler({Throwable.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultDto exceptionHandler(Throwable th){
        return resultFormat(th);
    }

    private ResultDto resultFormat(Throwable th){
        log.error(th.getMessage());
        String tips = "网络异常，稍后使用";
        if (th instanceof ServiceException){
            return ResultDto.fail("业务异常 " + tips);
        }if (th instanceof Exception){
            return ResultDto.fail("非业务异常 " + tips);
        }
        return ResultDto.fail(tips);
    }



}

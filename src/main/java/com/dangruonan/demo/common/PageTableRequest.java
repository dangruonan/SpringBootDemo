package com.dangruonan.demo.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@ApiModel(value = "列表分页查询", description = "请求参数类")
@Data
public class PageTableRequest<Dto extends BaseDto> implements Serializable {

    @ApiModelProperty(value = "页码", required = true, example = "1")
    private Integer pageNum = 1;
    @ApiModelProperty(value = "每页数据量", required = true, example = "10")
    private Integer pagesize = 10;
    @ApiModelProperty(value = "特定查询参数", required = true, example = "status=1")
    private Dto Params;
}

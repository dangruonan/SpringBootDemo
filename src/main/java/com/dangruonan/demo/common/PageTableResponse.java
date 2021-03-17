package com.dangruonan.demo.common;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PageTableResponse<T> implements Serializable {

    private Integer recordTotal;
    private List<T> data;
}

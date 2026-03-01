package com.junhong.result;

import java.io.Serializable;
import java.util.List;

public class PageResult implements Serializable {
    private long total;//记录总数
    private List records;//当前页数据集合
}

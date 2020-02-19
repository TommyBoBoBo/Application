package com.example.myapplication.bean;

import java.util.List;

/**
 * @author: 王重阳
 * @date: 2020/1/7
 */
public class DataBean {
    private List<ResultBean> result;
    private String message;
    private String status;


    public List<ResultBean> getResult() {
        return result;
    }

    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }
}

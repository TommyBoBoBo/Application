package com.example.myyklx.bean;

import java.util.List;

/**
 * @author: 王重阳
 * @date: 2020/2/15
 */
public class DataBean {
    private int code;
    private String msg;
    private List<ResultBean> result;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }
}

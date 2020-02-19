package com.example.my210zyy.bean;

import java.util.List;

/**
 * @author: 王重阳
 * @date: 2020/2/11
 */
public class NetBean {
    private int code;
    private String msg;
    private List<ResultBean> result;


    public NetBean(int code, String msg, List<ResultBean> result) {
        this.code = code;
        this.msg = msg;
        this.result = result;
    }

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

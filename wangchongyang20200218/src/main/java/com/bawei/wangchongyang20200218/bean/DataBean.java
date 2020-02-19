package com.bawei.wangchongyang20200218.bean;

import java.util.List;

/**
 * @author: 王重阳
 * @date: 2020/2/18
 */
public class DataBean {
    private String code;
    private List<ResultBean> listdata;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<ResultBean> getListdata() {
        return listdata;
    }

    public void setListdata(List<ResultBean> listdata) {
        this.listdata = listdata;
    }
}

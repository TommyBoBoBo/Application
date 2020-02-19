package com.example.myzy.bean;

import java.util.List;

/**
 * @author: 王重阳
 * @date: 2020/1/12
 */
public class DataBean {
    private boolean error;
    private List<ResuletBean> results;


    public boolean isError() {
        return error;
    }

    public List<ResuletBean> getResults() {
        return results;
    }
}

package com.example.mytab.bean;

import java.util.List;

/**
 * @author: 王重阳
 * @date: 2020/1/8
 */
public class ResultBean {
    private String id;
    private String name;
    private List<SecondCategoryVoBean> secondCategoryVo;


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<SecondCategoryVoBean> getSecondCategoryVo() {
        return secondCategoryVo;
    }
}

package com.example.my210zyy.bean;

/**
 * @author: 王重阳
 * @date: 2020/2/11
 */
public class ResultBean {

    private String title;
    private String digest;
    private String imgsrc;
    private String ptime;
    private int type;

    public ResultBean(String title, String digest, String imgsrc, String ptime, int type) {
        this.title = title;
        this.digest = digest;
        this.imgsrc = imgsrc;
        this.ptime = ptime;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    public String getPtime() {
        return ptime;
    }

    public void setPtime(String ptime) {
        this.ptime = ptime;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}

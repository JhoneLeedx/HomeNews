package com.jhonlee.homenews.pojo;

/**
 * Created by JhoneLee on 2017/3/9.
 */

public class Bottomlink {

    /**
     * text : 常规赛赛程
     * url : http://sports.qq.com/nba/schedule/?ptag=360.onebox.schedule.nba
     */

    private String text;
    private String url;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

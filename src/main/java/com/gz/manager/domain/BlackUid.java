package com.gz.manager.domain;

/**
 * 描述：<br>
 * 版权：Copyright (c) 2011-2018<br>
 * 公司：北京活力天汇<br>
 * 作者：龚钊<br>
 * 版本：1.0<br>
 * 创建日期：2019年03月08日<br>
 */
public class BlackUid {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    private int id;
    private String des;

    public BlackUid(int id, String des){
        this.id = id;
        this.des = des;
    }


}

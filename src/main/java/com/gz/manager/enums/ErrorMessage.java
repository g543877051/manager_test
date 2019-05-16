package com.gz.manager.enums;

/**
 * 描述：<br>
 * 版权：Copyright (c) 2011-2018<br>
 * 公司：北京活力天汇<br>
 * 作者：龚钊<br>
 * 版本：1.0<br>
 * 创建日期：2019年02月18日<br>
 */
public enum ErrorMessage {
    OVERTIME("overtime", "overtime", 1, true),
    DISCONNECT("disconnect", "disconnect", 2, true);

    private String msgName;

    public String getMsgName() {
        return msgName;
    }

    public void setMsgName(String msgName) {
        this.msgName = msgName;
    }

    public String getMsgCode() {
        return msgCode;
    }

    public void setMsgCode(String msgCode) {
        this.msgCode = msgCode;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public boolean isPrint() {
        return isPrint;
    }

    public void setPrint(boolean print) {
        isPrint = print;
    }

    private String msgCode;
    private Integer level;
    private boolean isPrint;

    ErrorMessage(String msgName, String msgCode, Integer level, boolean isPrint){
        this.msgName = msgName;
        this.msgCode = msgCode;
        this.level = level;
        this.isPrint = isPrint;
    }
}

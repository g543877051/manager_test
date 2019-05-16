package com.gz.manager.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Map;

/**
 * 描述：访问日志<br>
 * 版权：Copyright (c) 2011-2018<br>
 * 公司：北京活力天汇<br>
 * 作者：龚钊<br>
 * 版本：1.0<br>
 * 创建日期：2019年03月07日<br>
 */
public class VisitLog {
    private String url;
    private String ip;
    private String action;
    private String method;
    private String authorization;
    @JsonIgnore
    private Map<String, String[]> paramMap;

    private String param;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getAuthorization() {
        return authorization;
    }

    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }

    public Map<String, String[]> getParamMap() {
        return paramMap;
    }

    public void setParamMap(Map<String, String[]> paramMap) {
        this.paramMap = paramMap;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }


}

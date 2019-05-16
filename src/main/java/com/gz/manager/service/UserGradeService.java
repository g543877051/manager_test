package com.gz.manager.service;

import com.gz.manager.enums.ErrorMessage;
import org.springframework.stereotype.Component;

/**
 * 描述：<br>
 * 版权：Copyright (c) 2011-2018<br>
 * 公司：北京活力天汇<br>
 * 作者：龚钊<br>
 * 版本：1.0<br>
 * 创建日期：2019年02月18日<br>
 */
@Component
public class UserGradeService implements UserService {

    @Override
    public void print() {
        System.out.println("this is UserGradeService");

        ErrorMessage errorMessage = ErrorMessage.DISCONNECT;

        System.out.println(errorMessage.getMsgCode());
    }
}

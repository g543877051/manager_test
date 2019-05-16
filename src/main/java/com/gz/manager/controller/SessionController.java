package com.gz.manager.controller;

import com.gz.manager.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.channels.Pipe;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class SessionController {
    private static Logger logger = LoggerFactory.getLogger(SessionController.class);

    public static void main(String[] args) {
        Map<String, String> DENIED_PIDS = new HashMap<>();
        DENIED_PIDS.put("4101", "获取短信验证码协议");
        DENIED_PIDS.put("4102", "验证码确认协议");
        DENIED_PIDS.put("4201", "机票搜索协议");
        DENIED_PIDS.put("4221", "获取舱位列表信息协议");
        DENIED_PIDS.put("4222", "获取国际舱位列表信息协议");
        DENIED_PIDS.put("4502", "机票预订舱位价格确认协议");
        DENIED_PIDS.put("4503", "机票预订接口协议");
        DENIED_PIDS.put("4508", "机票预订舱位价格确认协议");
        DENIED_PIDS.put("4509", "异步验价协议");
        DENIED_PIDS.put("4510", "机票预订接口协议");
        DENIED_PIDS.put("4312", "航班号搜索动态协议");
        DENIED_PIDS.put("4313", "起降地搜索动态协议");
        DENIED_PIDS.put("4314", "动态详情协议");

        List<String> list = new ArrayList<String>(DENIED_PIDS.keySet());

        List<String> list1 = list.stream().filter(number -> Integer.valueOf(number) > 4500)
                .sorted((p1, p2) -> Integer.valueOf(p2).compareTo(Integer.valueOf(p1)))
                .map(p -> p.toUpperCase())
                .collect(Collectors.toList());

        list1.forEach(p -> System.out.println(p));




    }
}

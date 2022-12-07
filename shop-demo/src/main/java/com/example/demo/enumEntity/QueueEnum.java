package com.example.demo.enumEntity;

import lombok.Getter;

/**
 * yzw
 * 2022/11/25
 * 消息队列枚举配置
 */
@Getter
public enum QueueEnum {
    /**
     * 消息通知队列
     */
//    QUEUE_ORDER_CANCEL("shop.order.direct","shop.order.cancel","shop.order.cancel");

    /**
     * 消息通知ttl队列
     */
    QUEUE_TTL_ORDER_CANCEL("shop.order.direct.ttl", "shop.order.cancel.ttl", "shop.order.cancel.ttl");

    /**
     * 交换机名称
     */
    private String exchange;

    /**
     * 队列名称
     */
    private String name;

    /**
     * 路由键
     */
    private String routekey;

    QueueEnum(String exchange,String name,String routekey){
        this.exchange = exchange;
        this.name = name;
        this.routekey = routekey;
    }
}

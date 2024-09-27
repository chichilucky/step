package com.ndllz.notice;

import cn.hutool.core.lang.Console;
import cn.hutool.http.HttpUtil;

/**
 * @author xjc
 */
public class WecomPusher {

    public static void push(String title, String message) {
        ThreadExecutor.execute(() -> {
            Console.log("企业微信推送消息 标题->{} 内容->{}", title, message);
            String url = "https://qyapi.weixin.qq.com/cgi-bin/webhook/send?key=837585a9-d098-4917-b8b5-9173765c8886";
            String sb = "#### " + title + "\n" +
                    "> " + message + "\n";
            String content = "{\"msgtype\": \"markdown\",\"markdown\": {\"content\": \"" + sb + "\"}}";
            HttpUtil.post(url, content);
        });
    }

    public static void main(String[] args) {
        push("测试标题", "测试内容");
    }
}

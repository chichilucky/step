package com.ndllz.notice;

import cn.hutool.core.lang.Console;
import cn.hutool.http.HttpUtil;

public class BarkPusher {
    public static void push(String title, String message) {
        ThreadExecutor.execute(() -> {
            Console.log("Bark推送消息 标题->[{}] , 内容-> {}", title, message);
            String noticeUrl = "https://api.day.app/你的cookie/" + title + "/" + message + "?sound=calypso&group=ndllz";
            HttpUtil.get(noticeUrl);
        });
    }
}

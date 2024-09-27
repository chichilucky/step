package com.ndllz.notice;

import cn.hutool.core.thread.ThreadUtil;

import java.util.concurrent.ExecutorService;

/**
 * @author xjc
 */
public class ThreadExecutor {
    private static ExecutorService EXECUTOR_SERVICE = ThreadUtil.newSingleExecutor();

    public static void execute(Runnable runnable) {
        if (EXECUTOR_SERVICE.isShutdown()) {
            EXECUTOR_SERVICE = ThreadUtil.newSingleExecutor();
        }
        EXECUTOR_SERVICE.execute(runnable);
        EXECUTOR_SERVICE.shutdown();
    }
}

package com.ndllz;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Console;
import cn.hutool.core.lang.Dict;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.setting.yaml.YamlUtil;

import java.util.List;
import java.util.Map;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Dict dict = YamlUtil.loadByPath("list.yml");
        Boolean enabled = dict.getBool("enabled");
        List<Map<String, Object>> userList = (List<Map<String, Object>>) dict.get("user");
        if (CollUtil.isEmpty(userList)) {
            return;
        }
        int step = RandomUtil.randomInt(19000, 22000);
        Console.log("step: {}", step);
        for (Map<String, Object> user : userList) {
            String account = String.valueOf(user.get("account"));
            String password = String.valueOf(user.get("password"));
            Console.log("account: {}", account);
            StepChangeService stepChangeService = new StepChangeService();
            int tempStep = step;
            if (user.get("minStep") != null && user.get("maxStep") != null) {
                int minStep = Integer.parseInt(String.valueOf(user.get("minStep")));
                int maxStep = Integer.parseInt(String.valueOf(user.get("maxStep")));
                tempStep = RandomUtil.randomInt(minStep, maxStep);
            }
            MiUser miUser = new MiUser(account, password, tempStep);
            if (enabled) {
                stepChangeService.miChange(miUser);
            }
            try {
                Thread.sleep(RandomUtil.randomInt(5000,10000));
            } catch (Exception ignored) {
            }
        }
    }
}

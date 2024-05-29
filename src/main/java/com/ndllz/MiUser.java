package com.ndllz;

import cn.hutool.core.util.RandomUtil;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author ns
 * @date 2020/11/5
 */
@Data
@EqualsAndHashCode
public class MiUser {
    private String account;
    private String password;

    private Integer step;

    public MiUser(String account, String password, Integer step) {
        this.account = account;
        this.password = password;
        this.step = step;
    }

    public MiUser() {
    }

    public MiUser(String account, String password) {
        this.account = account;
        this.password = password;
        this.step = RandomUtil.randomInt(10000, 35000);
    }
}

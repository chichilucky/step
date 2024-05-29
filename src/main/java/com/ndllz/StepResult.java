package com.ndllz;

import java.util.HashMap;
import java.util.Map;

public class StepResult extends HashMap<String, Object> {

    private static final long serialVersionUID = -1131681874214638255L;

    public StepResult() {
        this.put("code", 200);
        this.put("msg", "success");
    }

    public static StepResult error(int code, String msg) {
        StepResult r = new StepResult();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static StepResult ok(int code, String msg) {
        StepResult r = new StepResult();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static StepResult ok(String msg) {
        StepResult r = new StepResult();
        r.put("msg", msg);
        return r;
    }

    public static StepResult ok(Map<String, Object> map) {
        StepResult r = new StepResult();
        r.putAll(map);
        return r;
    }

    public static StepResult ok() {
        return new StepResult();
    }

    @Override
    public StepResult put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}

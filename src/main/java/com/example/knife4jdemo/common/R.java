package com.example.knife4jdemo.common;

import lombok.Data;

import java.io.Serializable;

/**
 * Created on 2022/5/25 23:26
 */
@Data
public class R implements Serializable {
    // 是否成功 200表示正常状态，400表示异常
    private int code;

    // 结果消息
    private String msg;

    // 结果数据 ，类型不确定
    private Object data;


    // 同时提供几个对外的方法
    // 必须有一个完整属性的 成功/失败 方法
    public static R ok(int code, String msg, Object data) {

        R result = new R();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);

        return result;
    }


    /**
     * 有时候我们比较关注的是 data 数据，其余两项不需要再手动去设置（简化代码），所以再提供一个重载的方法
     *
     * @param data
     * @return 直接调用 完全属性的 success 方法
     */
    public static R ok(Object data) {

        return ok(200, "success", data);
    }

    public static R ok() {

        return ok(200, "success", null);
    }


    public static R failure(int code, String msg, Object data) {

        R result = new R();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);

        return result;
    }


    /**
     * 当失败时，我们其实不太需要data，因为没有数据返回，比较关注msg
     *
     * @param data
     * @return
     */
    public static R failure(String msg, Object data) {

        return failure(400, msg, data);
    }

    // 可以再 封装一次，只关注 msg
    public static R failure(String msg) {

        return failure(400, msg, null);
    }
}
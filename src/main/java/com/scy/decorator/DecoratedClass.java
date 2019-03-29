package com.scy.decorator;

import java.math.BigDecimal;

/**
 * 类名： DecoratedClass <br>
 * 描述：具体的被装饰者类 <br>
 * example:纯豆浆
 * 创建日期： 2019/3/28 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class DecoratedClass implements BasicClass {
    @Override
    public BigDecimal price() {
        return BigDecimal.valueOf(10);
    }

    @Override
    public String desc() {
        return "纯豆浆";
    }
}

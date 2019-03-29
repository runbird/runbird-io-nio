package com.scy.decorator;

import java.math.BigDecimal;

/**
 * 类名： AbstractDecorator <br>
 * 描述：装饰者的基类 <br>
 * 创建日期： 2019/3/28 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public abstract class AbstractDecorator implements BasicClass {

    private BasicClass basic;

    public AbstractDecorator(BasicClass basic) {
        this.basic = basic;
    }

    @Override
    public BigDecimal price() {
        return basic.price();
    }

    @Override
    public String desc() {
        return basic.desc();
    }
}

package com.scy.decorator;

import java.math.BigDecimal;

/**
 * 类名： ThirdDecorator <br>
 * 描述：具体的被装饰者类 <br>
 * 创建日期： 2019/3/28 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class ThirdDecorator extends AbstractDecorator {

    public ThirdDecorator(BasicClass basic) {
        super(basic);
    }

    @Override
    public BigDecimal price() {
        return super.price().add(BigDecimal.valueOf(5));
    }

    @Override
    public String desc() {
        return super.desc() + "+加了点水";
    }
}

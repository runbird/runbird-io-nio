package com.scy.decorator;

import java.math.BigDecimal;

/**
 * 类名： SecondDecorator <br>
 * 描述：具体的被装饰者类 <br>
 * 创建日期： 2019/3/28 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class SecondDecorator extends AbstractDecorator {

    public SecondDecorator(BasicClass basic) {
        super(basic);
    }

    @Override
    public BigDecimal price() {
        return super.price().add(BigDecimal.valueOf(15));
    }

    @Override
    public String desc() {
        return super.desc() + "+加了点油条";
    }
}

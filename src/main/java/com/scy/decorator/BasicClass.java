package com.scy.decorator;

import java.math.BigDecimal;

/**
 * 类名： BasicClass <br>
 * 描述：被装饰者基类 <br>
 * example:drink
 * 创建日期： 2019/3/28 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public interface BasicClass {
    BigDecimal price();

    String desc();
}

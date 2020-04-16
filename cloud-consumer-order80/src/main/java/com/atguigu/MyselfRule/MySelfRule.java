/**
 *  Copyright (C), 2015-2020
 * FileName: MySelfRule
 * Author: hanlong
 * Date: 2020/4/16 10:19 上午
 * Description:
 */
package com.atguigu.MyselfRule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Configuration;

/** Copyright (C), 2015-2020 
 * FileName: MySelfRule 
 * Author: hanlong 
 * Date: 2020/4/16 10:19 上午 
 *Description:  自动以负载均衡规则类
 */
//@Configuration
public class MySelfRule {
    public IRule myRule()
    {
        return new RandomRule();
    }}

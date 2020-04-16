/**
 *  Copyright (C), 2015-2020
 * FileName: LoadBalancer
 * Author: hanlong
 * Date: 2020/4/16 10:37 上午
 * Description:
 */
package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/** Copyright (C), 2015-2020 
 * FileName: LoadBalancer 
 * Author: hanlong 
 * Date: 2020/4/16 10:37 上午 
 *Description: 模拟IloadBalancer 的接口
 */
public interface LoadBalancer {
   //获取eureka上的活着的机器总数量
    ServiceInstance instance(List<ServiceInstance> serviceInstances);

}

/**
 *  Copyright (C), 2015-2020
 * FileName: MyLB
 * Author: hanlong
 * Date: 2020/4/16 10:41 上午
 * Description:
 */
package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/** Copyright (C), 2015-2020 
 * FileName: MyLB 
 * Author: hanlong 
 * Date: 2020/4/16 10:41 上午 
 *Description: 手写轮询算法
 */
@Component
public class MyLB  implements LoadBalancer{
    //原子类
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    public final int getAndIncrement()
    {
        int current;
        int next;
        do{
            current =this.atomicInteger.get();
            //超过最大值，为0，重新计数 2147483647 Integer.MAX_VALUE
            next= current >= 2147483647 ? 0 : current + 1;
            //自旋锁
        }while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("*****第几次访问，次数next："+next);
        return next;
    }
   @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstance) {
       int index = getAndIncrement() % serviceInstance.size();
       return serviceInstance.get(index);
    }
}

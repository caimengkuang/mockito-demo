package cn.yase.mockito.demo;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 连续调用(迭代器式存根)
 * 
 * @author yase
 * @since 2019/7/8 下午3:56
 */
public class Demo10 {

    public static void main(String[] args) {

        Demo10 mock = mock(Demo10.class);

        when(mock.sayHello("yase")).thenThrow(new RuntimeException("error")).thenReturn("yase -- 你好");

        // 第一次调用: 抛出异常
        try {
            String result = mock.sayHello("yase");
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("error:" + e.getMessage());
        }
        // 第二次调用 : 返回 yase -- 你好
        System.out.println(mock.sayHello("yase"));
        // 第三次调用 : 返回 yase -- 你好
        System.out.println(mock.sayHello("yase"));

        System.out.println("========================");
        // 优化后：
        when(mock.sayHello("yase2")).thenReturn("one", "two", "three");
        System.out.println(mock.sayHello("yase2"));
        System.out.println(mock.sayHello("yase2"));
        System.out.println(mock.sayHello("yase2"));

        System.out.println("========================");
        // 如果 .thenReturn() 使用具有相同匹配器或参数的多个存
        // 根而不是链接调用则每个存在将覆盖前一个存根
        when(mock.sayHello("yase3")).thenReturn("one");
        when(mock.sayHello("yase3")).thenReturn("two");

        // 都返回two
        System.out.println(mock.sayHello("yase3"));
        System.out.println(mock.sayHello("yase3"));

    }

    public String sayHello(String name) {
        return name + " hello";
    }

}

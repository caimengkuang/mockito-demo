package cn.yase.mockito.demo;

import static org.mockito.Mockito.*;

import java.util.LinkedList;
import java.util.List;

/**
 * 监视真实物体
 * 
 * @author yase
 * @since 2019/7/8 下午4:18
 */
public class Demo13 {

    public static void main(String[] args) {
        List list = new LinkedList<>();
        List spy = spy(list);

        when(spy.size()).thenReturn(100);

        spy.add("one");
        spy.add("two");

        System.out.println(spy.get(0));

        verify(spy, times(1)).add("one");
        verify(spy, times(1)).add("two");

        System.out.println("====================");
        List list1 = new LinkedList<>();
        List spy1 = spy(list1);

        try {
            // 这种方式获取将会抛出 IndexOutOfBoundsException 异常
            when(spy1.get(0)).thenReturn("foo");
        } catch (Exception e) {
            System.out.println("error:" + e);
        }

        // 这样就不会有上诉问题
        doReturn("foo1").when(spy1).get(0);
        System.out.println(spy1.get(0));
    }

}

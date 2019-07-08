package cn.yase.mockito.demo;

import static org.mockito.Mockito.*;

import java.util.LinkedList;

/**
 * 查找冗余调用
 * 
 * @author yase
 * @since 2019/7/8 下午3:40
 */
public class Demo8 {

    public static void main(String[] args) {
        LinkedList mockList = mock(LinkedList.class);

        mockList.add("one");
        mockList.add("two");

        verify(mockList).add("one");

        // verifyNoMoreInteractions()方法可以传入多个
        // mock对象作为参数，用来验证传入的这些mock对象是
        // 否存在没有验证过的调用方法。本例中因为没有对
        // add("two")进行验证，所以这里会报错
        verifyNoMoreInteractions(mockList);
    }

}

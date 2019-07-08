package cn.yase.mockito.demo;

import static org.mockito.Mockito.*;

import java.util.LinkedList;

/**
 * 怎么存根
 * 
 * @author yase
 * @since 2019/7/8 下午2:05
 */
public class Demo2 {

    public static void main(String[] args) {
        // 您可以模拟具体的类，而不仅仅是接口
        LinkedList mockedList = mock(LinkedList.class);

        // 存根出现在实际执行之前
        when(mockedList.get(0)).thenReturn("first");

        when(mockedList.get(1)).thenThrow(new RuntimeException());

        // 以下打印的是“first”
        System.out.println(mockedList.get(0));

        // 以下打印“null”，因为GET(999)没有存根
        System.out.println(mockedList.get(999));

        // 以下抛出运行时异常
        System.out.println(mockedList.get(1));

        verify(mockedList).get(0);

    }

}

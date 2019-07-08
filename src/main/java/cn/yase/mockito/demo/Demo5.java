package cn.yase.mockito.demo;

import static org.mockito.Mockito.*;

import java.util.LinkedList;

/**
 * 使用异常对void方法进行存根
 * 
 * @author yase
 * @since 2019/7/8 下午3:23
 */
public class Demo5 {

    public static void main(String[] args) {
        LinkedList mockedList = mock(LinkedList.class);

        doThrow(new RuntimeException()).when(mockedList).clear();
        mockedList.clear();
    }

}

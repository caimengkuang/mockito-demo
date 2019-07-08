package cn.yase.mockito.demo;

import java.util.LinkedList;

import static org.mockito.Mockito.*;

/**
 * doReturn() | doThrow() | doAnswer() | doNothing | doCallRealMethod 一系列方法
 *
 * doThrow()当你想要使用异常存根void方法时使用:
 *
 * 可以使用doThrow(),doAnswer(),doNothing(),doReturn()和doCallRealMethod()
 * 在本地与调用相应的when()
 *
 * doReturn(Object)
 * doThrow(Class)
 * doThrow(Class)
 * doNothing(Answer)
 * doNothing()
 * doCallRealMethod()
 *
 * @author yase
 * @since 2019/7/8 下午4:12
 */
public class Demo12 {

    public static void main(String[] args) {
        LinkedList mockedList = mock(LinkedList.class);
        doThrow(new RuntimeException()).when(mockedList).clear();

        mockedList.clear();
    }
}

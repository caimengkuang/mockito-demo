package cn.yase.mockito.demo;

import java.util.LinkedList;

import static org.mockito.Mockito.*;

/**
 * 调用次数验证: 确切多少次／至少多少次／从不
 * @author yase
 * @since 2019/7/8 下午3:09
 */
public class Demo4 {

    public static void main(String[] args) {
        LinkedList mockedList = mock(LinkedList.class);

        mockedList.add("once");

        mockedList.add("twice");
        mockedList.add("twice");

        mockedList.add("three times");
        mockedList.add("three times");
        mockedList.add("three times");

        verify(mockedList).add("once");
        verify(mockedList,times(1)).add("once");

        verify(mockedList,times(2)).add("twice");
        verify(mockedList,times(3)).add("three times");

        verify(mockedList,never()).add("never happened");

        verify(mockedList,atMost(1)).add("once");
        verify(mockedList,atLeastOnce()).add("three times");
        verify(mockedList,atLeast(2)).add("three times");
        verify(mockedList,atMost(5)).add("three times");
    }

}

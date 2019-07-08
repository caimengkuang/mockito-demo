package cn.yase.mockito.demo;

import static org.mockito.Mockito.*;

import java.util.LinkedList;
import java.util.List;

import org.mockito.ArgumentMatcher;

/**
 * 论证匹配
 * 
 * @author yase
 * @since 2019/7/8 下午2:14
 */
public class Demo3 {

    public static void main(String[] args) {
        LinkedList mockedList = mock(LinkedList.class);

        // 使用内置的anyInt()参数匹配器进行存根
        when(mockedList.get(anyInt())).thenReturn("element");

        // 使用自定义matcher进行存根(假设isValid()返回您自己的matcher实现)
        // when(mockedList.contains(argThat(new ListOfTwoElements()))).thenReturn(true);

        System.out.println(mockedList.get(1));

        // verify 验证调用次数
        verify(mockedList).get(anyInt());
        // verify(mockedList).add(argThat(someString -> someString.length() > 5));
    }

    static class ListOfTwoElements extends ArgumentMatcher<List> {

        @Override
        public boolean matches(Object o) {
            List list = (List)o;
            return list.size() == 2;
        }

        @Override
        public String toString() {
            return "[list of 2 elements]";
        }
    }
}

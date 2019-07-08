package cn.yase.mockito.demo;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * @author yase
 * @since 2019/7/8 下午2:01
 */
public class Demo1 {

    public static void main(String[] args) {
        // mock creation
        List mockedList = mock(List.class);

        // 使用模拟对象-它不会抛出任何“意外交互”异常
        mockedList.add("one");
        System.out.println(mockedList.size());

        mockedList.clear();

        // 选择性、显式、可读性高的验证(verify验证调用次数，默认为1)
        verify(mockedList).add("one");
        verify(mockedList).clear();
    }


}

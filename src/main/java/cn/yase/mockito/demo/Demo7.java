package cn.yase.mockito.demo;

import java.util.LinkedList;

import static org.mockito.Mockito.*;

/**
 * 确保在模拟上从未发生过互动
 * 
 * @author yase
 * @since 2019/7/8 下午3:36
 */
public class Demo7 {

    public static void main(String[] args) {
        LinkedList mockOnce = mock(LinkedList.class);

        mockOnce.add("one");

        verify(mockOnce).add("one");

        verify(mockOnce,never()).add("two");

        LinkedList mockTwo = mock(LinkedList.class);
        LinkedList mockThree = mock(LinkedList.class);

        verifyZeroInteractions(mockTwo,mockThree);
    }

}

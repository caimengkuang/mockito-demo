package cn.yase.mockito.demo;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;

import java.util.List;

import org.mockito.InOrder;

/**
 * 按顺序验证
 * 
 * @author yase
 * @since 2019/7/8 下午3:30
 */
public class Demo6 {

    public static void main(String[] args) {

        List singleMock = mock(List.class);

        singleMock.add("was added first");
        singleMock.add("was added second");

        InOrder inOrder = inOrder(singleMock);

        inOrder.verify(singleMock).add("was added first");
        inOrder.verify(singleMock).add("was added second");

        System.out.println("==================");

        List firstMock = mock(List.class);
        List secondMock = mock(List.class);

        firstMock.add("was called first");
        secondMock.add("was called second");

        InOrder inOrder1 = inOrder(firstMock, secondMock);
        inOrder1.verify(firstMock).add("was called first");
        inOrder1.verify(secondMock).add("was called second");

    }
}

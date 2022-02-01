package mockito.mockitodemo;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ListTest {

    @Test
    public void test() {
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(10);
        assertEquals(10, listMock.size());
    }

    @Test
    public void testSize_multipleReturns() {
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(10).thenReturn(20);
        // It means that : when the method call it, return 10. And when it calls the second time, it returns 20. And so on ...
        assertEquals(10, listMock.size());
        assertEquals(20, listMock.size());
    }

    // when the method has parameters.
    @Test
    public void testGet_AccordingToSpecificParameter() {
        List listMock = mock(List.class);
        when(listMock.get(0)).thenReturn("WELCOME");  // listMock.get(0) means that first index. means (when it is called with 0, it will return WELCOME)
        // It means that : when the method call it, return 10. And when it calls the second time, it returns 20. And so on ...
        assertEquals("WELCOME", listMock.get(0));
        assertEquals(null, listMock.get(1));
    }

    @Test
    public void testGet_GenericParameter() {
        List listMock = mock(List.class);
        // when we want to return the same string every time in some kind of situations, you don't need to do it for each input, instead do it as follows :
        when(listMock.get(Mockito.anyInt())).thenReturn("Againnn"); // it means : when it is called with any integer, it will return the string.
        assertEquals("Againnn", listMock.get(0));
        assertEquals("Againnn", listMock.get(1));
    }


}


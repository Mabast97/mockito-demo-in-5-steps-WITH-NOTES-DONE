package mockito.mockitodemo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

// when we use mockito annotations, we should use @RunWith(MockitoJUnitRunner). And it looks at the annotations for running
@RunWith(MockitoJUnitRunner.class)
class SomeBusinessMockAnnotationsTest {

    @Mock
    DataService dataServiceMock;

    @InjectMocks
    SomeBusinessImpl  businessImpl;

    /* Here what we did is that :  when the (businessImpl) created, the (dataServiceMock) injected into it directly */

    @Test
    void testFindTheGreatestFromAllData() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {24, 15, 2});
        int result = businessImpl.findTheGreatestFromAllData();
        assertEquals(24, result);
    }

    @Test
    void testFindTheGreatestFromAllData_ForOneValue() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 15 });
        int result = businessImpl.findTheGreatestFromAllData();
        assertEquals(15, result);
    }
}


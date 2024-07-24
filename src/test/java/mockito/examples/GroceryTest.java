package mockito.examples;

import org.example.VeggieType;
import org.example.Grocery;
import org.example.OutOfStockException;
import org.example.Vegetable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;


public class GroceryTest extends BaseTest {

    @Mock
    private Grocery groceryMock;

    @BeforeEach
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test_example_then_return() {

        // Configuring the mock object to return 6 tomatoes on calling getTomatoes() method
        when(groceryMock.getTomatoes()).thenReturn(new Vegetable("tomato", 6));

        // Configuring the mock object to return different values on consecutive calls
        when(groceryMock.getTomatoes()).thenReturn(
                new Vegetable("tomato", 6),
                new Vegetable("tomato", 5),
                new Vegetable("tomato", 8));
    }


    @Test
    public void test_example_then_throw() throws OutOfStockException {
        // Configuring the mock object to throw an exception on calling getOnions() method
        when(groceryMock.getOnions()).thenThrow(new OutOfStockException());

        // Configuring the mock object with the exception type on calling getOnions() method
        when(groceryMock.getOnions()).thenThrow(OutOfStockException.class);
    }

    @Test
    public void test_example_thenCallRealMethod() throws OutOfStockException {
        // Configuring the mock object to call the actual implementation on calling getOnions() method
        when(groceryMock.getOnions()).thenCallRealMethod();

        groceryMock.getOnions();
    }

    @Test
    public void test_example_thenAnswer() {

        // Configuring the mock object to return output based on custom logic
        Answer<List<Vegetable>> customAnswer = invocation -> {
            List<Vegetable> vegetables = new ArrayList<>();
            VeggieType option = (VeggieType) invocation.getArguments()[0];
            if (VeggieType.SEASONAL.equals(option)) {
                // return seasonal vegetables
            } else {
                // return other vegetables
            }
            return vegetables;
        };

        when(groceryMock.suggestOptions(any())).thenAnswer(customAnswer);
    }
}

package matchers.examples;

import org.example.InventoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

public class InventoryServiceTest {

    @Mock
    private InventoryService inventoryServiceMock;

    @BeforeEach
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test_any_matcher() {
        when(inventoryServiceMock.getItemQuantity(any(String.class))).thenReturn(1);
        assertEquals(inventoryServiceMock.getItemQuantity("Any String"), 1);


        when(inventoryServiceMock.addItem(any(String.class), anyInt())).thenReturn(true);
        assertTrue(inventoryServiceMock.addItem("Any String", 25));

        verify(inventoryServiceMock, times(1)).getItemQuantity("Any String");
        verify(inventoryServiceMock, times(1)).addItem("Any String", 25);
        verifyNoMoreInteractions(inventoryServiceMock);
    }

    @Test
    public void test_null_non_null_matcher() {
        when(inventoryServiceMock.removeItem(isNull())).thenReturn(false);
        assertFalse(inventoryServiceMock.removeItem(null));

        when(inventoryServiceMock.removeItem(isNotNull())).thenReturn(true);
        assertTrue(inventoryServiceMock.removeItem("Any non null String"));
    }

    @Test
    public void test_equality_matcher() {
        when(inventoryServiceMock.getItemQuantity(eq("Chair"))).thenReturn(5);

        assertEquals(inventoryServiceMock.getItemQuantity("Chair"), 5);
        assertNotEquals(inventoryServiceMock.getItemQuantity("Not Chair"), 5);
    }

    @Test
    public void test_string_matcher() {
        when(inventoryServiceMock.getItemQuantity(startsWith("dining"))).thenReturn(10);
        when(inventoryServiceMock.getItemQuantity(endsWith("set"))).thenReturn(15);
        when(inventoryServiceMock.getItemQuantity(contains("baby"))).thenReturn(20);

        assertEquals(inventoryServiceMock.getItemQuantity("dining table"), 10);
        assertEquals(inventoryServiceMock.getItemQuantity("Furniture set"), 15);
        assertEquals(inventoryServiceMock.getItemQuantity("newborn baby clothes"), 20);

    }

    @Test
    public void test_arg_matcher() {
        when(inventoryServiceMock.addItem(argThat(s -> s != null && s.length() > 0), anyInt())).thenReturn(true);

        assertTrue(inventoryServiceMock.addItem("Any Item", 1));
        assertFalse(inventoryServiceMock.addItem("", 10));

    }
}
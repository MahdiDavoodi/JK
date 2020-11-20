package ir.blog.mahdidavoodi;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestStore {
    Store store = new Store();

    @Test
    public void testNewProduct() {
        assertTrue(store.newProduct(157365849, "LG TV 2020", 2300, 10, "LG", "LG.com", "ElectronicProducts"));
    }

    @Test
    public void testReduceProduct() {
        store.currentProductId = 157365849;
        assertEquals(store.reduceProduct(10), 0);
    }

}

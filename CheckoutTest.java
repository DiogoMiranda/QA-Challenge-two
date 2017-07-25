package model.bo;

import org.junit.Test;
import static org.junit.Assert.*;


/*
Product   Unit       Discount
          Price     
--------------------------
A         0.50       3 for 1.30
B         0.30       2 for 0.45
C         0.20
D         0.15
 
*/


public class CheckoutTest {

    Cart cart = new Cart();

    @Test
    public void test_empty() {
        int qtdA = 0;
        int qtdB = 0;
        cart.addProductToCart(new Product("A", 0.50f, qtdA));
        cart.addProductToCart(new Product("B", 0.30f, qtdB));
        assertEquals(0, cart.getTotalWithDiscount(), 0.01);
        assertEquals(0, cart.getTotalWithDiscount(), 0.01);
    }

    @Test 
    public void test_A() {
        int qtdA = 1;
        cart.addProductToCart(new Product("A", 0.50f, qtdA)); 
        assertEquals(0.5f, cart.getTotalWithDiscount(), 0.01);

    }

    @Test
    public void test_B() {
        int qtdB = 1;
        cart.addProductToCart(new Product("B", 0.30f, qtdB));
        assertEquals(0.3f, cart.getTotalWithDiscount(), 0.01);
    }

    @Test
    public void test_C() {
        int qtdC = 1;
        cart.addProductToCart(new Product("C", 0.20f, qtdC));
        assertEquals(0.2f, cart.getTotalWithDiscount(), 0.01);
    }

    @Test
    public void test_D() {
        int qtdD = 1;
        cart.addProductToCart(new Product("D", 0.15f, qtdD));
        assertEquals(0.15f, cart.getTotalWithDiscount(), 0.01);
    }

    @Test
    public void test_BB() {
        int qtdB = 2;
        cart.addProductToCart(new Product("B", 0.30f, qtdB));
        assertEquals(0.45f, cart.getTotalWithDiscount(), 0.01);
    }

    @Test
    public void test_AA() {

        int qtdA = 2;
        cart.addProductToCart(new Product("A", 0.50f, qtdA));
        assertEquals(1.0f, cart.getTotalWithDiscount(), 0.01);
    }

    @Test
    public void test_AAA() {
        int qtd = 3;
        cart.addProductToCart(new Product("A", 0.50f, qtd));
        assertEquals(1.3f, cart.getTotalWithDiscount(), 0.01);
    }

    @Test
    public void test_AB() {

        int qtdA = 1;
        int qtdB = 1;
        cart.addProductToCart(new Product("A", 0.50f, qtdA));
        cart.addProductToCart(new Product("B", 0.30f, qtdB));
        assertEquals(0.8f, cart.getTotalWithDiscount(), 0.01);

    }

    @Test
    public void test_ABC() {

        int qtdA = 1;
        int qtdB = 1;
        int qtdC = 1;
        cart.addProductToCart(new Product("A", 0.50f, qtdA));
        cart.addProductToCart(new Product("B", 0.30f, qtdB));
        cart.addProductToCart(new Product("C", 0.20f, qtdC));
        assertEquals(1.0f, cart.getTotalWithDiscount(), 0.01);

    }

    @Test (timeout = 1000)
    public void test_ABCD_discount() {

        int qtdA = 3;
        int qtdB = 2;
        int qtdC = 1;
        int qtdD = 1;
        cart.addProductToCart(new Product("A", 0.50f, qtdA));
        cart.addProductToCart(new Product("B", 0.30f, qtdB));
        cart.addProductToCart(new Product("C", 0.20f, qtdC));
        cart.addProductToCart(new Product("D", 0.15f, qtdD));
        assertEquals(2.10f, cart.getTotalWithDiscount(), 0.01);

    }

}

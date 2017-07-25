package model.bo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import model.roles.DiscountA;
import model.roles.DiscountB;
import model.roles.Rule;

public class Cart {

    private Map<String, Product> mapProduct;

    public Cart() {
        mapProduct = new HashMap<>();
        System.out.println("Cart Started");
    }

    public void addProductToCart(Product product) {

        if (mapProduct.containsKey(product.getName())) {
            Product prod = mapProduct.get(product.getName());
            prod.setQuantity(prod.getQuantity() + product.getQuantity());
            System.out.println("Class Cart - addProductToCart()");
        } else {
            setDiscountToProduct(product);
            mapProduct.put(product.getName(), product);
            System.out.println("Product add - Press 5 to return to the Main Menu");
        }
    }

    public float getTotal() {
        float total = 0;
        for (Map.Entry<String, Product> entry : mapProduct.entrySet()) {
            Product p = entry.getValue();
            total = total + p.getValueTotalProduct();
        }

        return total;
    }

    public float getTotalWithDiscount() {
        float total = 0;
        for (Map.Entry<String, Product> entry : mapProduct.entrySet()) {
            Product p = entry.getValue();
            total = total + p.getValueTotalProductDiscount();
        }
        return total;
    }

    private void setDiscountToProduct(Product product) {
        if (product.getName().equalsIgnoreCase("A")) {
            Rule rule = new DiscountA(3, (float) 130.0);
            product.addDiscount(rule);
        }
        if (product.getName().equalsIgnoreCase("B")) {
            Rule rule = new DiscountB();
            product.addDiscount(rule);
        }
    }

    public int getQuantityProductOnCart(String name) {
        return mapProduct.get(name).getQuantity();
    }

    public java.util.List<Product> listProductToCart() {
        java.util.List<Product> listProductName = new ArrayList<>();

        for (Map.Entry<String, Product> entry : mapProduct.entrySet()) {
            Product p = entry.getValue();
            listProductName.add(p);
        }
        return listProductName;
    }

    public void editProduct(String name, int newQuantiade) {
        if (mapProduct.containsKey(name)) {
            mapProduct.get(name).setQuantity(newQuantiade);
        }

    }

}

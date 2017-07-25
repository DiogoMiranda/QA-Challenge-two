package model.bo;

import model.roles.Rule;

public class Product {

    private String name;
    private float value;
    private int quantity;

    private Rule discount;

    public Product(String name, float value, int quantity) {
        this.name = name;
        this.value = value;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getValueTotalProduct() {
        return quantity * value;
    }

    public float getValueTotalProductDiscount() {
        if (discount != null) {
            return discount.getValueProductDiscount();
        } else {
            return getValueTotalProduct();
        }
    }

    protected void addDiscount(Rule discount) {

        this.discount = discount;
        this.discount.setProduct(this);
    }

    public Rule getDiscount() {
        return discount;
    }
}

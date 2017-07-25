package model.roles;

import model.bo.Product;

public abstract class Rule {

    private int quantityForRule;
    private float valueDiscount;
    private Product product;

    public Rule(int quantityForRule, float valorDiscount) {
        this.quantityForRule = quantityForRule;
        this.valueDiscount = valorDiscount;
    }

    public float getValueProductDiscount() {
        float occurrence = Math.abs(product.getQuantity() / getQuantityForRule());
        float value = occurrence * getDiscountValue();
        return product.getValueTotalProduct() - value;
    }

    protected int getQuantityForRule() {
        return quantityForRule;
    }

    protected void setQuantityForRule(int quantityForRule) {
        this.quantityForRule = quantityForRule;
    }

    public float getDiscountValue() {
        return valueDiscount;
    }

    public void setDiscountValue(float value) {
        this.valueDiscount = value;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}

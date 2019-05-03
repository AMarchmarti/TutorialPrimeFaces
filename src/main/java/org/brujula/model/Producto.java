package org.brujula.model;

import java.util.Objects;

public class Producto {

    private Integer codeProduct = 0;
    private String nameProduct = null;
    private Double price = 0d;

    public Integer getCodeProduct() {
        return codeProduct;
    }

    public void setCodeProduct(Integer codeProduct) {
        this.codeProduct = codeProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return codeProduct.equals(producto.codeProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codeProduct);
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codeProduct=" + codeProduct +
                '}';
    }
}

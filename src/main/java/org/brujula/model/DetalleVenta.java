package org.brujula.model;

public class DetalleVenta {

    private Integer codeDetail = 0;
    private Venta codeSale = null;
    private Producto codeProduct = null;
    private Integer quantity = 0;

    public Integer getCodeDetail() {
        return codeDetail;
    }

    public void setCodeDetail(Integer codeDetail) {
        this.codeDetail = codeDetail;
    }

    public Venta getCodeSale() {
        return codeSale;
    }

    public void setCodeSale(Venta codeSale) {
        this.codeSale = codeSale;
    }

    public Producto getCodeProduct() {
        return codeProduct;
    }

    public void setCodeProduct(Producto codeProduct) {
        this.codeProduct = codeProduct;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}

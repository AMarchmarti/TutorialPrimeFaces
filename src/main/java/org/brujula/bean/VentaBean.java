package org.brujula.bean;

import org.brujula.model.DetalleVenta;
import org.brujula.model.Producto;
import org.brujula.model.Venta;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@ViewScoped
public class VentaBean {

    private Venta venta = new Venta();
    private Producto producto = new Producto();
    private Integer cantidad;
    private List<DetalleVenta> lista = new ArrayList<DetalleVenta>();

    public List<DetalleVenta> getLista() {
        return lista;
    }

    public void setLista(DetalleVenta lista) {
        this.lista.add(lista);
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void agregar(){
        DetalleVenta det = new DetalleVenta();
        det.setQuantity(getCantidad());
        det.setCodeProduct(getProducto());
        setLista(det);
    }
}
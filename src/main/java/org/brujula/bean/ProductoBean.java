package org.brujula.bean;

import org.brujula.dao.ProductoDAO;
import org.brujula.model.Producto;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.List;

@ManagedBean
@ViewScoped
public class ProductoBean {

    private Producto producto = new Producto();
    private List<Producto> listaProducto = null;
    private String action;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public List<Producto> getListaProducto() {
        return listaProducto;
    }

    public void setListaProducto(List<Producto> listaProducto) {
        this.listaProducto = listaProducto;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void operar() throws Exception {
        if ("Registrar".equals(getAction())) {
            registerProduct();
            limpiar();
        } else if ("Modificar".equals(getAction())) {
            modifyProduct();
            limpiar();
        }
    }

    public Boolean isPostBack(){
        return FacesContext.getCurrentInstance().isPostback();
    }

    public void limpiar(){
        getProducto().setCodeProduct(0);
        getProducto().setNameProduct("");
        getProducto().setPrice(0d);
    }

    private void registerProduct() throws Exception {
        ProductoDAO dao = null;
        try{
            dao = new ProductoDAO();
            dao.registerProducto(getProducto());
            listarProducto();
        }catch (Exception e){
            throw e;
        }
    }

    public void listarProducto() throws Exception {
        ProductoDAO dao = null;
        try{
            if(isPostBack() == false){
                dao = new ProductoDAO();
                setListaProducto(dao.listaProducto());}
        }catch (Exception e){
            throw e;
        }
    }

    public void  leerID(Producto producto) throws Exception {
        ProductoDAO dao = null;
        Producto temp;
        try{
            dao = new ProductoDAO();
            temp = dao.leerID(producto);
            if(temp != null){
                setProducto(temp);
                setAction("Modificar");
            }
        }catch (Exception e){
            throw e;
        }
    }

    private void modifyProduct() throws Exception {
        ProductoDAO dao = null;
        try{
            dao = new ProductoDAO();
            dao.modifyProduct(getProducto());
            this.listarProducto();
        }catch (Exception e){
            throw e;
        }
    }

    public void eliminarID(Producto producto) throws Exception {
        ProductoDAO dao = null;
        try{
            dao = new ProductoDAO();
            dao.eliminar(producto);
            listarProducto();
        }catch (Exception e){
            throw e;
        }
    }
}

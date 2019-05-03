package org.brujula.dao;

import org.brujula.model.Producto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO extends DAO{


    public void registerProducto(Producto producto) throws Exception {
        try{
            this.conect();
            PreparedStatement prepare = this.getConexion().prepareStatement("INSERT INTO producto(nombre,precio) values (?,?)");
            prepare.setString(1, producto.getNameProduct());
            prepare.setDouble(2,producto.getPrice());
            prepare.executeUpdate();
        }catch (Exception e){
            throw e;
        }finally {
            this.closed();
        }
    }

    public List<Producto> listaProducto() throws Exception {

        List<Producto> listaPro = null;
        ResultSet rs;
        try{
            this.conect();
            PreparedStatement prepare = this.getConexion().prepareStatement("SELECT codigo, nombre, precio FROM producto");
            rs = prepare.executeQuery();
            listaPro = new ArrayList<Producto>();
            while (rs.next()){
                Producto pro = new Producto();
                pro.setCodeProduct(rs.getInt("codigo"));
                pro.setNameProduct(rs.getString("nombre"));
                pro.setPrice(rs.getDouble("precio"));

                listaPro.add(pro);
            }

        }catch (Exception e){
            throw e;
        }finally {
            this.closed();
        }
        return listaPro;
    }

    public Producto leerID(Producto pro) throws Exception {
        Producto producto = null;
        ResultSet result;
        try{
            this.conect();
            PreparedStatement prepare = this.getConexion().prepareStatement("SELECT codigo, nombre, precio FROM producto WHERE codigo = ?");
            prepare.setInt(1,pro.getCodeProduct());
            result = prepare.executeQuery();
            while (result.next()){
                producto = new Producto();
                producto.setCodeProduct(result.getInt("codigo"));
                producto.setNameProduct(result.getString("nombre"));
                producto.setPrice(result.getDouble("precio"));
            }
        }catch (Exception e){
            throw e;
        }finally {
            this.closed();
        }
        return producto;
        }

    public void modifyProduct(Producto person) throws Exception {
        try{
            this.conect();
            PreparedStatement prepare = this.getConexion().prepareStatement("UPDATE producto SET nombre = ?, precio = ? WHERE CODIGO = ?");
            prepare.setString(1, person.getNameProduct());
            prepare.setDouble(2,person.getPrice());
            prepare.setInt(3,person.getCodeProduct());
            prepare.executeUpdate();
        }catch (Exception e){
            throw e;
        }finally {
            this.closed();
        }
    }
    public void eliminar(Producto producto) throws Exception {
        try{
            this.conect();
            PreparedStatement prepare = this.getConexion().prepareStatement("DELETE FROM producto WHERE CODIGO = ?");
            prepare.setInt(1,producto.getCodeProduct());
            prepare.executeUpdate();
        }catch (Exception e){
            throw e;
        }finally {
            this.closed();
        }
    }
}

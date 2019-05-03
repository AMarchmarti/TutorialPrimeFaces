package org.brujula.dao;


import org.brujula.model.DetalleVenta;
import org.brujula.model.Venta;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class VentaDAO extends DAO {

    public void registerVenta(Venta venta, List<DetalleVenta> lista) throws Exception {
        try {
            this.conect();
            this.getConexion().setAutoCommit(false);//Para saber cuando hacemos efectivo que el bloque se realice.

            PreparedStatement prepare = this.getConexion().prepareStatement("INSERT INTO venta(fecha, codpersona, monto) values (?,?,?)");
            prepare.setDate(1, venta.getDate());
            prepare.setInt(2, venta.getCodePerson().getCode());
            prepare.setDouble(3, venta.getMonto());
            prepare.executeUpdate();
            prepare.close();

            PreparedStatement preparedSt = this.getConexion().prepareStatement("SELECT LAST_INSERT_ID() FROM venta limit 1");
            int codVenta = 0;
            ResultSet rs = preparedSt.executeQuery();
            while (rs.next()){
                codVenta = rs.getInt(1);
            }
            rs.close();

            for (DetalleVenta det : lista) {
                PreparedStatement pst = this.getConexion().prepareStatement("INSERT INTO detalleventa(codventa, codproducto, cantidad) values (?,?,?)");
                prepare.setInt(1, codVenta);
                prepare.setInt(2, det.getCodeProduct().getCodeProduct());
                prepare.setDouble(3, det.getQuantity());
                pst.executeUpdate();
                pst.close();
            }

            this.getConexion().commit();//Para ejecutar el bloque

        } catch (Exception e) {
            this.getConexion().rollback();//Por si habido algun error que se ejecute el rollback
            throw e;

        } finally {
            this.closed();
        }
    }
}

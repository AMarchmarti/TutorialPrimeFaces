package org.brujula.dao;


import org.brujula.model.DetalleVenta;
import org.brujula.model.Venta;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class VentaDAO extends DAO {

    public void registerVenta(Venta venta, List<DetalleVenta> lista) throws Exception {
        try {
            this.conect();
            this.getConnection().setAutoCommit(false);//Para saber cuando hacemos efectivo que el bloque se realice.

            PreparedStatement prepare = this.getConnection().prepareStatement("INSERT INTO venta(fecha, codpersona, monto) values (?,?,?)");
            prepare.setDate(1, (Date) venta.getDate());
            prepare.setInt(2, venta.getCodePerson().getCode());
            prepare.setDouble(3, venta.getMonto());
            prepare.executeUpdate();
            prepare.close();

            PreparedStatement preparedStatement = this.getConnection().prepareStatement("SELECT LAST_INSERT_ID() FROM venta limit 1");
            ResultSet rs;
            int codVenta = 0;
            rs = preparedStatement.executeQuery();
            while (rs.next()){
                codVenta = rs.getInt("1");
            }
            rs.close();

            for (DetalleVenta det : lista) {
                PreparedStatement pst = this.getConnection().prepareStatement("INSERT INTO detalleventa(codventa, codproducto, cantidad) values (?,?,?)");
                prepare.setInt(1, codVenta);
                prepare.setInt(2, det.getCodeProduct().getCodeProduct());
                prepare.setDouble(3, det.getQuantity());
                pst.executeUpdate();
                pst.close();
            }

            this.getConnection().commit();//Para ejecutar el bloque

        } catch (Exception e) {
            this.getConnection().rollback();//Por si habido algun error que se ejecute el rollback
            throw e;
        } finally {
            this.closed();
        }
    }
}

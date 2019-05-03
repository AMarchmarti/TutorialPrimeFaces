package org.brujula.model;

import java.sql.Date;

public class Venta {

    private Integer codeSale = 0;
    private Date date = null;
    private Persona codePerson = null;
    private Double monto = 0d;

    public Integer getCodeSale() {
        return codeSale;
    }

    public void setCodeSale(Integer codeSale) {
        this.codeSale = codeSale;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Persona getCodePerson() {
        return codePerson;
    }

    public void setCodePerson(Persona codePerson) {
        this.codePerson = codePerson;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }
}

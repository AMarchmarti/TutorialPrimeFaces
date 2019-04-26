package org.brujula.dao;

import org.brujula.model.Persona;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAO extends DAO{


    public void registerPerson(Persona person) throws Exception {
        try{
            this.conect();
            PreparedStatement prepare = this.getConnection().prepareStatement("INSERT INTO persona(nombre,sexo) values (?,?)");
            prepare.setString(1, person.getName());
            prepare.setString(2,person.getSex());
            prepare.executeUpdate();
        }catch (Exception e){
            throw e;
        }finally {
            this.closed();
        }
    }

    public List<Persona> listPerson() throws Exception {

        List<Persona> listPer = null;
        ResultSet rs;
        try{
            this.conect();
            PreparedStatement prepare = this.getConnection().prepareStatement("SELECT codigo, nombre, sexo FROM persona");
            rs = prepare.executeQuery();
            listPer = new ArrayList<Persona>();
            while (rs.next()){
                Persona per = new Persona();
                per.setCode(rs.getInt("codigo"));
                per.setName(rs.getString("nombre"));
                per.setSex(rs.getString("sexo"));

                listPer.add(per);
            }

        }catch (Exception e){
            throw e;
        }finally {
            this.closed();
        }
        return listPer;
    }

    public Persona leerID(Persona persona) throws Exception {
        Persona person = null;
        ResultSet result;
        try{
            this.conect();
            PreparedStatement prepare = this.getConnection().prepareStatement("SELECT codigo, nombre, sexo FROM persona WHERE codigo = ?");
            prepare.setInt(1,persona.getCode());
            result = prepare.executeQuery();
            while (result.next()){
                person = new Persona();
                person.setCode(result.getInt("codigo"));
                person.setName(result.getString("nombre"));
                person.setSex(result.getString("sexo"));
            }
        }catch (Exception e){
            throw e;
        }finally {
            this.closed();
        }
        return person;
        }

    public void modifyPerson(Persona person) throws Exception {
        try{
            this.conect();
            PreparedStatement prepare = this.getConnection().prepareStatement("UPDATE persona SET nombre = ?, sexo = ? WHERE CODIGO = ?");
            prepare.setString(1, person.getName());
            prepare.setString(2,person.getSex());
            prepare.setInt(3,person.getCode());
            prepare.executeUpdate();
        }catch (Exception e){
            throw e;
        }finally {
            this.closed();
        }
    }
    public void eliminar(Persona person) throws Exception {
        try{
            this.conect();
            PreparedStatement prepare = this.getConnection().prepareStatement("DELETE FROM persona  WHERE CODIGO = ?");
            prepare.setInt(1,person.getCode());
            prepare.executeUpdate();
        }catch (Exception e){
            throw e;
        }finally {
            this.closed();
        }
    }
}

package org.brujula.bean;

import org.brujula.dao.PersonaDAO;
import org.brujula.model.Persona;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

@ManagedBean
@ViewScoped
public class PersonaBean {

    private Persona person = new Persona();
    private List<Persona> listaPersona = null;

    public List<Persona> getListaPersona() {
        return listaPersona;
    }

    public void setListaPersona(List<Persona> listaPersona) {
        this.listaPersona = listaPersona;
    }

    public Persona getPerson() {
        return person;
    }

    public void setPerson(Persona person) {
        this.person = person;
    }

    public void registerPerson() throws Exception {
        PersonaDAO dao = null;
        try{
            dao = new PersonaDAO();
            dao.registerPerson(getPerson());
        }catch (Exception e){
            throw e;
        }
    }

    public void listarPersona() throws Exception {
        PersonaDAO dao = null;
        try{
            dao = new PersonaDAO();
            setListaPersona(dao.listPerson());
        }catch (Exception e){
            throw e;
        }
    }

    public void  leerID(Persona person) throws Exception {
        PersonaDAO dao = null;
        Persona temp;
        try{
            dao = new PersonaDAO();
            temp = dao.leerID(person);
            if(temp != null){
                this.person = temp;
            }
        }catch (Exception e){
            throw e;
        }
    }

    public void modifyPerson() throws Exception {
        PersonaDAO dao = null;
        try{
            dao = new PersonaDAO();
            dao.modifyPerson(getPerson());
            this.listarPersona();
        }catch (Exception e){
            throw e;
        }
    }
}

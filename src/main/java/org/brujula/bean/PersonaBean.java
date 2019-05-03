package org.brujula.bean;

import org.brujula.dao.PersonaDAO;
import org.brujula.model.Persona;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.List;

@ManagedBean
@ViewScoped
public class PersonaBean {

    private Persona person = new Persona();
    private List<Persona> listaPersona = null;
    private String action;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

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

    public Boolean isPostBack(){
        return FacesContext.getCurrentInstance().isPostback();
    }

    public void operar() throws Exception {
        if ("Registrar".equals(getAction())) {
            registerPerson();
            limpiar();
        } else if ("Modificar".equals(getAction())) {
            modifyPerson();
            limpiar();
        }
    }

    public void limpiar(){
        getPerson().setCode(0);
        getPerson().setName("");
        getPerson().setSex("");
    }

    private void registerPerson() throws Exception {
        PersonaDAO dao = null;
        try{
            dao = new PersonaDAO();
            dao.registerPerson(getPerson());
            listarPersona();
        }catch (Exception e){
            throw e;
        }
    }

    public void listarPersona() throws Exception {
        PersonaDAO dao = null;
        try{
            if(isPostBack() == false){
                dao = new PersonaDAO();
                setListaPersona(dao.listPerson());}
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
                setPerson(temp);
                setAction("Modificar");
            }
        }catch (Exception e){
            throw e;
        }
    }

    private void modifyPerson() throws Exception {
        PersonaDAO dao = null;
        try{
            dao = new PersonaDAO();
            dao.modifyPerson(getPerson());
            this.listarPersona();
        }catch (Exception e){
            throw e;
        }
    }

    public void eliminarID(Persona person) throws Exception {
        PersonaDAO dao = null;
        try{
            dao = new PersonaDAO();
            dao.eliminar(person);
            listarPersona();
        }catch (Exception e){
            throw e;
        }
    }
}

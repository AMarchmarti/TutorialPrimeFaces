package org.brujula.converter;


import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("sexConverter")
public class SexConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return value;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        String sex = "";

        if (value != null){
            sex = (String) value;
            if ("M".equals(sex)) {
                sex = "MASCULINO";
            } else if ("F".equals(sex)) {
                sex = "FEMENINO";
            }
        }
        return sex;
    }
}

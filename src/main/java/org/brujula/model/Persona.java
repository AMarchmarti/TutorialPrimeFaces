package org.brujula.model;

import java.util.Objects;

public class Persona {

    private Integer code = 0;
    private String name = null;
    private String sex = null;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "code=" + code +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return code.equals(persona.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
}

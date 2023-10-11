package org.example;

public class Persona {

    private Integer id;
    private String empresa;
    private String ciudad;
    private String correo;
    private String nombre;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Persona(Integer id, String empresa, String ciudad, String correo, String nombre) {
        this.id = id;
        this.empresa = empresa;
        this.ciudad = ciudad;
        this.correo = correo;
        this.nombre = nombre;
    }



}

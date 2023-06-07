package com.myapp.empleados_gestion.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "departamento")
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String descripcion;
    private String ubicacion;

    @ManyToOne
    @JoinColumn(name = "jefe_departamento")
    private Empleado jefeDepartamento;

    @ManyToMany(mappedBy = "departamentos")
    private List<Empleado> empleados;

    // Constructor, getters y setters

    public Departamento() {
    }

    public Departamento(Integer id, String nombre, String descripcion, String ubicacion, Empleado jefeDepartamento) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.jefeDepartamento = jefeDepartamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Empleado getJefeDepartamento() {
        return jefeDepartamento;
    }

    public void setJefeDepartamento(Empleado jefeDepartamento) {
        this.jefeDepartamento = jefeDepartamento;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }
}

package com.myapp.empleados_gestion.controller;

import com.myapp.empleados_gestion.model.Departamento;
import com.myapp.empleados_gestion.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {
    private final DepartamentoService departamentoService;

    @Autowired
    public DepartamentoController(DepartamentoService departamentoService) {
        this.departamentoService = departamentoService;
    }

    @GetMapping
    public List<Departamento> obtenerTodosLosDepartamentos() {
        return departamentoService.obtenerTodosLosDepartamentos();
    }

    @GetMapping("/{id}")
    public Departamento obtenerDepartamentoPorId(@PathVariable Long id) {
        return departamentoService.obtenerDepartamentoPorId(id);
    }

    @PostMapping
    public Departamento crearDepartamento(@RequestBody Departamento departamento) {
        return departamentoService.crearDepartamento(departamento);
    }

    @PutMapping("/{id}")
    public Departamento actualizarDepartamento(@PathVariable Long id, @RequestBody Departamento departamento) {
        return departamentoService.actualizarDepartamento(id, departamento);
    }

    @DeleteMapping("/{id}")
    public void eliminarDepartamento(@PathVariable Long id) {
        departamentoService.eliminarDepartamento(id);
    }
}

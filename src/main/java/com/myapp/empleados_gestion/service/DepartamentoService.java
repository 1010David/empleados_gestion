package com.myapp.empleados_gestion.service;

import com.myapp.empleados_gestion.model.Departamento;
import com.myapp.empleados_gestion.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoService {
    private final DepartamentoRepository departamentoRepository;

    @Autowired
    public DepartamentoService(DepartamentoRepository departamentoRepository) {
        this.departamentoRepository = departamentoRepository;
    }

    public List<Departamento> obtenerTodosLosDepartamentos() {
        return departamentoRepository.findAll();
    }

    public Departamento obtenerDepartamentoPorId(Long id) {
        return departamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Departamento no encontrado con ID: " + id));
    }

    public Departamento crearDepartamento(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    public Departamento actualizarDepartamento(Long id, Departamento departamentoActualizado) {
        Departamento departamentoExistente = obtenerDepartamentoPorId(id);
        departamentoExistente.setNombre(departamentoActualizado.getNombre());
        departamentoExistente.setDescripcion(departamentoActualizado.getDescripcion());
        departamentoExistente.setUbicacion(departamentoActualizado.getUbicacion());
        departamentoExistente.setJefeDepartamento(departamentoActualizado.getJefeDepartamento());
        return departamentoRepository.save(departamentoExistente);
    }

    public void eliminarDepartamento(Long id) {
        departamentoRepository.deleteById(id);
    }
}

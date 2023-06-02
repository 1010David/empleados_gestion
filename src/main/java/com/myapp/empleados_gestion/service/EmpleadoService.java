package com.myapp.empleados_gestion.service;

import com.myapp.empleados_gestion.model.Empleado;
import com.myapp.empleados_gestion.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {
    private final EmpleadoRepository empleadoRepository;

    @Autowired
    public EmpleadoService(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    public List<Empleado> obtenerTodosLosEmpleados() {
        return empleadoRepository.findAll();
    }

    public Empleado obtenerEmpleadoPorId(Long id) {
        return empleadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado con ID: " + id));
    }

    public Empleado crearEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    public Empleado actualizarEmpleado(Long id, Empleado empleadoActualizado) {
        Empleado empleadoExistente = obtenerEmpleadoPorId(id);
        empleadoExistente.setNombre(empleadoActualizado.getNombre());
        empleadoExistente.setApellido(empleadoActualizado.getApellido());
        empleadoExistente.setFechaNacimiento(empleadoActualizado.getFechaNacimiento());
        empleadoExistente.setDireccion(empleadoActualizado.getDireccion());
        empleadoExistente.setTelefono(empleadoActualizado.getTelefono());
        empleadoExistente.setCorreoElectronico(empleadoActualizado.getCorreoElectronico());
        empleadoExistente.setNumeroIdentificacion(empleadoActualizado.getNumeroIdentificacion());
        empleadoExistente.setFechaContratacion(empleadoActualizado.getFechaContratacion());
        empleadoExistente.setSalario(empleadoActualizado.getSalario());
        return empleadoRepository.save(empleadoExistente);
    }

    public void eliminarEmpleado(Long id) {
        empleadoRepository.deleteById(id);
    }
}

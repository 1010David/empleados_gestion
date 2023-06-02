package com.myapp.empleados_gestion.repository;

import com.myapp.empleados_gestion.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    // Agrega métodos de consulta adicionales si es necesario
}

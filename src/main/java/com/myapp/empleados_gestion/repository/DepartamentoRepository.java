package com.myapp.empleados_gestion.repository;

import com.myapp.empleados_gestion.model.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
    // Agrega métodos de consulta adicionales si es necesario
}

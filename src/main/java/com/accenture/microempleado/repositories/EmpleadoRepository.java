package com.accenture.microempleado.repositories;

import com.accenture.microempleado.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado,Long> {

    Empleado getById(Long id);
    Optional<Empleado> findById(Long id);
    Boolean removeById(Long id);
}

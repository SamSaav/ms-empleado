package com.accenture.microempleado.repositories;

import com.accenture.microempleado.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado,Long> {

    Empleado getById(Long id);

}

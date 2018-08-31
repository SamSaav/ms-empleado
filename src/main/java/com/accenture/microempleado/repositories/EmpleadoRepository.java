package com.accenture.microempleado.repositories;

import com.accenture.microempleado.model.Empleado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
<<<<<<< Updated upstream
public interface EmpleadoRepository extends CrudRepository<Empleado,Long> {

=======
public interface EmpleadoRepository extends JpaRepository<Empleado,Long> {

    Optional<Empleado> findById(Long id);
    Boolean removeById(Long id);
>>>>>>> Stashed changes
}

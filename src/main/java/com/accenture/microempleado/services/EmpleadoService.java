package com.accenture.microempleado.services;

import com.accenture.microempleado.model.Empleado;
import com.accenture.microempleado.repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmpleadoService {

    @Autowired
    EmpleadoRepository empleadoRepository;

    public List<Object> getAllEmpleadosActivos(){
        List<Empleado> lstEmpleados = empleadoRepository.findAll();
        return makeListEmpleadosActivos(lstEmpleados);
    }

    public  List<Object> getAllEmpleadosInactivos(){
        List<Empleado> lstEmpleados = empleadoRepository.findAll();
        return makeListEmpleadosInactivos(lstEmpleados);
    }

    public Map<String, Object> getOneEmpleado(Long id){
        Empleado empleado = empleadoRepository.getById(id);
        return getEmpledoDTO(empleado.getId());
    }

    public Empleado saveEmpleado(Empleado empleado){
        empleadoRepository.save(empleado);
        return empleado;
    }

    public List<Object> makeListEmpleadosActivos(List<Empleado> empleados){
        return empleados.stream()
                .filter(e -> e.getStatusEmpleado().equals(true) && e.getStatusEmpleado() != null)
                .map(e -> getEmpledoDTO(e.getId()))
                .collect(Collectors.toList());
    }

    public List<Object> makeListEmpleadosInactivos(List<Empleado> empleados){
        return empleados.stream()
                .filter(e -> e.getStatusEmpleado().equals(false) && e.getStatusEmpleado() != null)
                .map(e -> getEmpledoDTO(e.getId()))
                .collect(Collectors.toList());
    }

    public Map<String, Object> getEmpledoDTO(Long id){
        Empleado empleado = empleadoRepository.getById(id);
        Map<String, Object> dto = new LinkedHashMap<>();
        dto.put("ID", empleado.getId());
        dto.put("fullName", empleado.getLastName() + ", " + empleado.getName());
        dto.put("enterpriseID", empleado.getEnterpriseID());
        dto.put("phoneNumber", empleado.getPhoneNumber());
        dto.put("resourceRole", empleado.getResourceRole());
        dto.put("englishLevel", empleado.getEnglishLevel());
        dto.put("officeLocation", empleado.getOfficeLocation());
        return dto;
    }

}

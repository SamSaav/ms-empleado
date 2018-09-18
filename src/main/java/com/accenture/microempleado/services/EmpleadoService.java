package com.accenture.microempleado.services;

import com.accenture.microempleado.model.Empleado;
import com.accenture.microempleado.repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.ArrayList;
@Service
public class EmpleadoService {

    @Autowired
    EmpleadoRepository empleadoRepository;

    public List<Object> getAllEmpleados() {
        return empleadoRepository.findAll().stream().collect(Collectors.toList());
    }

    public Map<String, Object> getOneEmpleado(Long id){
        Empleado empleado = empleadoRepository.getById(id);
        return getEmpledoDTO(empleado.getId());
    }

    public Empleado saveEmpleado(Empleado newEmpleado) {
        if(empleadoRepository.findByEnterpriseID(newEmpleado.getEnterpriseID())!=null){
            return null;
        }
        newEmpleado.setStatusEmpleado(true);
        empleadoRepository.save(newEmpleado);
        return newEmpleado;
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

    public Map<String, Object> getEmpledoDTO(Long id) {
        Empleado empleado = empleadoRepository.getById(id);
        Map<String, Object> dto = new LinkedHashMap<>();
        dto.put("id", empleado.getId());
        dto.put("name",empleado.getName());
        dto.put("lastName", empleado.getLastName());
        dto.put("enterpriseID", empleado.getEnterpriseID());
        dto.put("resourceNumber", empleado.getResourceNumber());
        dto.put("gender",empleado.getGender());
        dto.put("resourceRole", empleado.getResourceRole());
        dto.put("englishLevel", empleado.getEnglishLevel());
        dto.put("officeLocation", empleado.getOfficeLocation());
        dto.put("client",empleado.getClient());
        dto.put("project",empleado.getProject());
        dto.put("statusEmpleado", empleado.getStatusEmpleado());

        return dto;
    }

    public Boolean updateEmpleado(Long id, Empleado empleado){
        if (empleado != null && empleadoRepository.getById(id) != null) {
            Empleado changedEmpleado = empleadoRepository.getById(id);
            empleadoRepository.save(updateEmpleadoData(changedEmpleado, empleado));
            return true;
        } else return false;
    }


//deleteEmpleado: oculta al empleado para que no se pueda ver, cambia el flag a false
    public Boolean deleteEmpleado(Long id) {
        if (id != null && empleadoRepository.findById(id).get() != null) {
            Empleado deletedEmpleado = empleadoRepository.findById(id).get();
            deletedEmpleado.setStatusEmpleado(false);
            empleadoRepository.save(deletedEmpleado);
            return true;
        }
        else return false;
    }

    public Map<String,Object> makeDeleteDTO(Long id){
        Map<String,Object> dto = new LinkedHashMap<>();
        dto.put("id",id);
        dto.put("deleted",deleteEmpleado(id));
        return dto;
    }

    public List<Object> makeDeletedDTO(List<Long> ids){
        return ids.stream().map(m->makeDeleteDTO(m)).collect(Collectors.toList());
    }

//removeEmpleado: saca de la base al empleado
    @Transactional
    public Boolean removeEmpleado(Long id) {
        if (id != null && empleadoRepository.findById(id).get() != null) {
            empleadoRepository.deleteById(id);
            return true;
        }
        return false;
    }


    public List<Empleado> removeEmpleados(List<Long> ids) {
        List<Empleado> empleadosRemoved = new ArrayList<>();
        for (Long id : ids) {
            if (id != null && empleadoRepository.findById(id).get() != null) {
                empleadosRemoved.add(empleadoRepository.findById(id).get());
                removeEmpleado(id);
            }
        }
        return empleadosRemoved;
    }

    public Map<String,Object> makeRemoveDTO(Long id){
        Map<String,Object> dto = new LinkedHashMap<>();
        dto.put("id",id);
        dto.put("removed",removeEmpleado(id));
        return dto;
    }

    public List<Object> makeRemovedDTO(List<Long> ids){
        return ids.stream().map(m->makeRemoveDTO(m)).collect(Collectors.toList());
    }

    public Empleado updateEmpleadoData(Empleado changeEmpleado, Empleado empleado){
        if (empleado.getName() != null && empleado.getName() != changeEmpleado.getName()) {
            changeEmpleado.setName(empleado.getName());
        }
        if (empleado.getLastName() != null && empleado.getLastName() != changeEmpleado.getLastName()) {
            changeEmpleado.setLastName(empleado.getLastName());
        }
        if (empleado.getEnterpriseID() != null && empleado.getEnterpriseID() != changeEmpleado.getEnterpriseID()) {
            changeEmpleado.setEnterpriseID(empleado.getEnterpriseID());
        }
        if (empleado.getResourceNumber() != null && empleado.getResourceNumber() != changeEmpleado.getResourceNumber()) {
            changeEmpleado.setResourceNumber(empleado.getResourceNumber());
        }
        if (empleado.getGender() != null && empleado.getGender() != changeEmpleado.getGender()) {
            changeEmpleado.setGender(empleado.getGender());
        }
        if (empleado.getResourceRole() != null && empleado.getResourceRole() != changeEmpleado.getResourceRole()) {
            changeEmpleado.setResourceRole(empleado.getResourceRole());
        }
        if (empleado.getEnglishLevel() != null && empleado.getEnglishLevel() != changeEmpleado.getEnglishLevel()) {
            changeEmpleado.setEnglishLevel(empleado.getEnglishLevel());
        }
        if (empleado.getOfficeLocation() != null && empleado.getOfficeLocation() != changeEmpleado.getOfficeLocation()) {
            changeEmpleado.setOfficeLocation(empleado.getOfficeLocation());
        }
        if (empleado.getClient() != null && empleado.getClient() != changeEmpleado.getClient()) {
            changeEmpleado.setClient(empleado.getClient());
        }
        if (empleado.getProject() != null && empleado.getProject() != changeEmpleado.getProject()) {
            changeEmpleado.setProject(empleado.getProject());
        }
        return changeEmpleado;
    }

}



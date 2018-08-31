package com.accenture.microempleado.services;

import com.accenture.microempleado.model.Empleado;
import com.accenture.microempleado.repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmpleadoService {

    @Autowired
    EmpleadoRepository empleadoRepository;


    public Boolean updateEmpleado(Empleado empleado) {
        if (empleado != null && empleadoRepository.findById(empleado.getId()) != null) {
            Empleado changedEmpleado = empleadoRepository.findById(empleado.getId()).get();
            changedEmpleado.updateEmpleado(empleado);
            return true;
        } else return false;
    }


    public Boolean deleteEmpleado(Long id) {
        if (id != null && empleadoRepository.findById(id).get() != null) {
            Empleado deletedEmpleado = empleadoRepository.findById(id).get();
            deletedEmpleado.setStatusEmpleado(false);
            return true;
        }
        else return false;
    }

    private Map<String,Object> makeDeleteDTO(Long id){
        Map<String,Object> dto = new LinkedHashMap<>();
        dto.put("id",id);
        dto.put("deleted",deleteEmpleado(id));
        return dto;
    }

    public List<Object> makeDeletedDTO(List<Long> ids){
        return ids.stream().map(m->makeDeleteDTO(m)).collect(Collectors.toList());
    }


    public Boolean removeEmpleado(Long id) {
        if (id != null && empleadoRepository.findById(id).get() != null) {
            return empleadoRepository.removeById(id);
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

    private Map<String,Object> makeRemoveDTO(Long id){
        Map<String,Object> dto = new LinkedHashMap<>();
        dto.put("id",id);
        dto.put("removed",removeEmpleado(id));
        return dto;
    }

    public List<Object> makeRemovedDTO(List<Long> ids){
        return ids.stream().map(m->makeRemoveDTO(m)).collect(Collectors.toList());
    }


}



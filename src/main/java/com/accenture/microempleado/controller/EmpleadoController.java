package com.accenture.microempleado.controller;


import com.accenture.microempleado.model.Empleado;
import com.accenture.microempleado.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping("employees")
    @ResponseBody
    public List<Object> showAllEmployees() {
        return empleadoService.getAllEmpleados();
    }

    @GetMapping("{id}")
    @ResponseBody
    public Object getEmpleado(@PathVariable("id") Long id){
        return empleadoService.getOneEmpleado(id);
    }

    @PostMapping
    @ResponseBody
    public Empleado createEmpleado(@RequestBody Empleado empleado) {
        return empleadoService.saveEmpleado(empleado);
    }

    @PutMapping("update/{id}")
    @ResponseBody
    public Boolean updateEmpleado(@PathVariable("id") Long id, @RequestBody Empleado empleado){
        return empleadoService.updateEmpleado(id, empleado);
    }

    @DeleteMapping("delete/{id}")
    @ResponseBody
    public Map<String, Object> deleteEmpleado(@PathVariable Long id){
        return empleadoService.makeDeleteDTO(id);
    }

    @DeleteMapping("permanentDelete/{id}")
    @ResponseBody
    public Map<String, Object> removeEmpleado(@PathVariable("id") Long id){ return empleadoService.makeRemoveDTO(id); }

}


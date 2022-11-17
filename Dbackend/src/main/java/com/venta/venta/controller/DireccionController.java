package com.venta.venta.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.venta.venta.model.Direccion;
import com.venta.venta.service.DireccionService;

@RestController
@RequestMapping("/api/direccion/")
public class DireccionController {
    
    @Autowired
    private DireccionService direccionService;


    @PostMapping
    private ResponseEntity<Direccion> guardar(@RequestBody Direccion direccion){
        Direccion direccion2 = direccionService.create(direccion);

        try {
            return ResponseEntity.created(new URI("/api/direccion"+direccion2.getId())).body(direccion2);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }   

    @GetMapping
    private ResponseEntity<List<Direccion>> listarPersonas(){
        return ResponseEntity.ok(direccionService.listarDirecciones());
        
    }

    @DeleteMapping
    private ResponseEntity<Void> eliminarPersona(@RequestBody Direccion direccion){
        direccionService.eliminarDireccion(direccion);
        return ResponseEntity.ok().build();        
    }

    @GetMapping(value ="{id}")
    private ResponseEntity<Optional<Direccion>> buscarPersona(@PathVariable("id") Long id){
        return ResponseEntity.ok(direccionService.buscarId(id));
        
    }
}

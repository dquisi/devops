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

import com.venta.venta.dto.PersonaDireccionDTO;
import com.venta.venta.model.Persona;
import com.venta.venta.service.PersonaService;


@RestController
@RequestMapping("/api/persona/")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping("personadir")
    public List<PersonaDireccionDTO> listarPersonaLugar() {
        return personaService.getPersonaDireccion();
    }

    @PostMapping
    private ResponseEntity<Persona> guardar(@RequestBody Persona persona) {
        Persona persona2 = personaService.create(persona);

        try {
            return ResponseEntity.created(new URI("/api/persona" + persona2.getId())).body(persona2);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping
    private ResponseEntity<List<Persona>> listarPersonas() {
        return ResponseEntity.ok(personaService.listarPersonas());

    }

    @DeleteMapping
    private ResponseEntity<Void> eliminarPersona(@RequestBody Persona persona) {
        personaService.eliminarPersona(persona);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "{id}")
    private ResponseEntity<Optional<Persona>> buscarPersona(@PathVariable("id") Long id) {
        return ResponseEntity.ok(personaService.buscarId(id));

    }

}

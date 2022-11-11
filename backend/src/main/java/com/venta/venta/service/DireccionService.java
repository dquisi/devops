package com.venta.venta.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.venta.venta.model.Direccion;
import com.venta.venta.repository.DireccionRepository;

@Service
public class DireccionService {

    @Autowired
    private DireccionRepository direccionRepository;
    

    public Direccion create(Direccion direccion){
        return direccionRepository.save(direccion);
    }

    public List<Direccion> listarDirecciones(){
        return direccionRepository.findAll();
    }

    public void eliminarDireccion(Direccion direccion){
        direccionRepository.delete(direccion);
    }

    public Optional<Direccion> buscarId(Long id){
        return direccionRepository.findById(id);
    }
}

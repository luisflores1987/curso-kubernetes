package org.aguzman.springcloud.msvc.usuarios.controllers;


import org.aguzman.springcloud.msvc.usuarios.models.entity.Usuario;
import org.aguzman.springcloud.msvc.usuarios.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping("/")
    public List<Usuario> listar(){
        return service.listar();
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> listar(@PathVariable(name = "id") Long id){

        Optional<Usuario> oUsuario =  service.porId(id);
        if(oUsuario.isPresent()){
            return ResponseEntity.ok(oUsuario.get());
        }
        return ResponseEntity.notFound().build();

    }

}

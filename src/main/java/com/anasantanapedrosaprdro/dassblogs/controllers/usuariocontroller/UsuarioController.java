package com.anasantanapedrosaprdro.dassblogs.controllers.usuariocontroller;

import com.anasantanapedrosaprdro.dassblogs.DTOs.usuari.UsuarioDTO;
import com.anasantanapedrosaprdro.dassblogs.model.Usuaria;
import com.anasantanapedrosaprdro.dassblogs.services.usuarioservice.UsuarioService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<Object> salvarUsuario(@RequestBody @Valid UsuarioDTO usuarioDTO){
        var usuario = new Usuaria();
        BeanUtils.copyProperties(usuarioDTO,usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.saveUsuario(usuario));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Usuaria> findById(@PathVariable(value = "id") Long id){
        Usuaria usuaria=usuarioService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(usuaria);
    }
    @GetMapping
    public ResponseEntity<Page<Usuaria>> findAll(Pageable pageable){
        Page<Usuaria> usuarias =usuarioService.findAll(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(usuarias);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarUsuario(@PathVariable(value = "id") Long id,@RequestBody @Valid UsuarioDTO usuarioDTO){
        var usuario= new Usuaria();
        BeanUtils.copyProperties(usuarioDTO,usuario);
        usuarioService.atualizarUsuario(id,usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.saveUsuario(usuario));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> daletarUsuario(@PathVariable(value = "id") Long id){
        usuarioService.delatarUsuario(id);
        return ResponseEntity.status(HttpStatus.OK).body("Usuario delatada com sucesso");
    }
}

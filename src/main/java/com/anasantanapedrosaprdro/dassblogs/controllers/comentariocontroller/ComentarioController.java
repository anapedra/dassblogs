package com.anasantanapedrosaprdro.dassblogs.controllers.comentariocontroller;

import com.anasantanapedrosaprdro.dassblogs.DTOs.comentarioDTO.ComentarioDTO;
import com.anasantanapedrosaprdro.dassblogs.model.Comentario;
import com.anasantanapedrosaprdro.dassblogs.services.comentarioservice.ComentarioService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/comentario")
public class ComentarioController {

    final ComentarioService comentarioService;
    public ComentarioController(ComentarioService comentarioService) {
        this.comentarioService = comentarioService;
    }
    @PostMapping
    public ResponseEntity<Object> salvarComentario(@RequestBody @Valid ComentarioDTO comentarioDTO){
        var comentario=new Comentario();
        BeanUtils.copyProperties(comentarioDTO,comentario);
        return ResponseEntity.status(HttpStatus.CREATED).body(comentarioService.seveCoentario(comentario));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Comentario> findById(@PathVariable(value = "id") Long id){
        Comentario comentario=comentarioService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(comentario);
    }
    @GetMapping
    public ResponseEntity<Page<Comentario>> findAll(Pageable pageable){
        Page<Comentario> comentarios=comentarioService.findAll(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(comentarios);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarComentario(@PathVariable(value = "id") Long id,@RequestBody @Valid ComentarioDTO comentarioDTO){
        var comentario=new Comentario();
        BeanUtils.copyProperties(comentarioDTO,comentario);
        comentarioService.atualizarComentario(id,comentario);
        return ResponseEntity.status(HttpStatus.CREATED).body(comentarioService.seveCoentario(comentario));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarComentario(@PathVariable(value = "id") Long id){
        comentarioService.delatarComentario(id);
        return ResponseEntity.status(HttpStatus.OK).body("Post delatado com sucesso");
    }
}

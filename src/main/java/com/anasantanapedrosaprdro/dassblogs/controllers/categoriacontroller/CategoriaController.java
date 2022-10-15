package com.anasantanapedrosaprdro.dassblogs.controllers.categoriacontroller;

import com.anasantanapedrosaprdro.dassblogs.DTOs.categoriaDTO.CategoriaDTO;
import com.anasantanapedrosaprdro.dassblogs.model.Categoria;
import com.anasantanapedrosaprdro.dassblogs.services.categoriaservice.CategoriaService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/categoria")
public class CategoriaController {

    final CategoriaService categoriaService;
    public CategoriaController(CategoriaService categoriaService) {
         this.categoriaService = categoriaService;
    }
    @PostMapping
    public ResponseEntity<Object> salvarCategoria(@RequestBody @Valid CategoriaDTO categoriaDTO){
        var categoria = new Categoria();
        BeanUtils.copyProperties(categoriaDTO,categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.savarCategoria(categoria));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable(value = "id") Long id){
        Categoria categoria=categoriaService.findByid(id);
        return ResponseEntity.status(HttpStatus.OK).body(categoria);
    }
    @GetMapping
    public ResponseEntity<Page<Categoria>> findAll(Pageable pageable){
        Page<Categoria>categorias=categoriaService.findAll(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(categorias);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarCategoria(@PathVariable(value = "id") Long id,@RequestBody @Valid CategoriaDTO categoriaDTO){
        var categoria= new Categoria();
        BeanUtils.copyProperties(categoriaDTO,categoria);
        categoriaService.atualizarCategoria(id,categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.savarCategoria(categoria));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> daletarCategoria(@PathVariable(value = "id") Long id){
        categoriaService.deletarCategoria(id);
        return ResponseEntity.status(HttpStatus.OK).body("Categoria delatada com sucesso");
    }
}

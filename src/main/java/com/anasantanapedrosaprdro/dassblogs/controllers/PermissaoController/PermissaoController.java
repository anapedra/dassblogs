package com.anasantanapedrosaprdro.dassblogs.controllers.PermissaoController;

import com.anasantanapedrosaprdro.dassblogs.DTOs.permissaoDTO.PermissaoDTO;
import com.anasantanapedrosaprdro.dassblogs.model.Permissao;
import com.anasantanapedrosaprdro.dassblogs.services.PermissaoService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("permissoes")
public class PermissaoController {

    private final PermissaoService permissaoService;
    public PermissaoController(PermissaoService permissaoService) {
        this.permissaoService = permissaoService;
    }

    @PostMapping
    public ResponseEntity<Object> salvarPermissao(@RequestBody @Valid PermissaoDTO permissaoDTO){
        var permissao= new Permissao();
        BeanUtils.copyProperties(permissaoDTO,permissao);
        return ResponseEntity.status(HttpStatus.CREATED).body(permissaoService.savePermissao(permissao));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Permissao> findById(@PathVariable Long id){
        var permissao=permissaoService.findByIdPermissao(id);
        return ResponseEntity.status(HttpStatus.OK).body(permissao);
    }
    @GetMapping
    public ResponseEntity<Page<Permissao>> findAll(Pageable pageable){
        Page<Permissao> permissaos=permissaoService.findAllPermissao(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(permissaos);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarPermissao(@PathVariable Long id,@RequestBody @Valid PermissaoDTO permissaoDTO){
        var permissao=new Permissao();
        BeanUtils.copyProperties(permissaoDTO,permissao);
        permissaoService.atualizarPermissao(id,permissao);
        return ResponseEntity.status(HttpStatus.CREATED).body(permissaoService.savePermissao(permissao));

    }
}

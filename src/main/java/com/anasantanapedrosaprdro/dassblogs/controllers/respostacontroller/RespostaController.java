package com.anasantanapedrosaprdro.dassblogs.controllers.respostacontroller;

import com.anasantanapedrosaprdro.dassblogs.DTOs.respostaDTO.RespostaDTO;
import com.anasantanapedrosaprdro.dassblogs.model.Respota;
import com.anasantanapedrosaprdro.dassblogs.services.respostaservice.RespostaService;
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
@RequestMapping("/resposta")
public class RespostaController {

    final RespostaService respostaService;
    public RespostaController(RespostaService respostaService) {
        this.respostaService = respostaService;
    }
    @PostMapping
    public ResponseEntity<Object> salvarResposta(@RequestBody @Valid RespostaDTO respostaDTO){
        var resposta = new Respota();
        BeanUtils.copyProperties(respostaDTO,resposta);
        return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Long id){
        Optional<Respota> respota=respostaService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(respota);
    }
    @GetMapping
    public ResponseEntity<Page<Respota>> findAll(Pageable pageable){
        Page<Respota>respotas = respostaService.findAll(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(respotas);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> atualizatCategoria(@PathVariable(value = "id") Long id, @RequestBody @Valid RespostaDTO respostaDTO){
        var resposta = new Respota();
        BeanUtils.copyProperties(respostaDTO,resposta);
        respostaService.atualizarResposra(id,resposta);
        return ResponseEntity.status(HttpStatus.CREATED).body(respostaService.savarResposta(resposta));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarRespsosta(@PathVariable(value = "id") Long id){
        respostaService.deletarResposta(id);
        return ResponseEntity.status(HttpStatus.OK).body("Resposta delatada com sucesso");
    }
}

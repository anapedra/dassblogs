package com.anasantanapedrosaprdro.dassblogs.controllers.paiscontroller;

import com.anasantanapedrosaprdro.dassblogs.model.Pais;
import com.anasantanapedrosaprdro.dassblogs.services.paisservice.PaisService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pais")
public class PaisController {

    private final PaisService paisService;
    public PaisController(PaisService paisService) {
        this.paisService = paisService;
    }
    @PostMapping
    public ResponseEntity<Pais> savePais(@RequestBody Pais pais){
        return ResponseEntity.status(HttpStatus.CREATED).body(  paisService.savePais(pais));
    }
    @GetMapping
    public ResponseEntity<List<Pais>> findAll(){
        List<Pais> pais= paisService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(pais);
    }
}

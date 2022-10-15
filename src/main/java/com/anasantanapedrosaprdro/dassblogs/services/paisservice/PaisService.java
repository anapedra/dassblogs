package com.anasantanapedrosaprdro.dassblogs.services.paisservice;

import com.anasantanapedrosaprdro.dassblogs.model.Pais;
import com.anasantanapedrosaprdro.dassblogs.model.Post;
import com.anasantanapedrosaprdro.dassblogs.repositorys.paisrepository.PaisRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PaisService {

    private final PaisRepository paisRepository;
    public PaisService(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }
    @Transactional
    public Pais savePais(Pais pais){
       return paisRepository.saveAndFlush(pais);
    }
    public List<Pais> findAll(){
        List<Pais> paises=paisRepository.findAll();
        return paises;
    }
}

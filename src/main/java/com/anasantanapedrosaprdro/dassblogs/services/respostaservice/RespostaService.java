package com.anasantanapedrosaprdro.dassblogs.services.respostaservice;

import com.anasantanapedrosaprdro.dassblogs.model.Respota;
import com.anasantanapedrosaprdro.dassblogs.repositorys.respostarepository.RespostaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

@Service
public class RespostaService {

    final RespostaRepository respostaRepository;
    public RespostaService(RespostaRepository respostaRepository) {
        this.respostaRepository = respostaRepository;
    }
    @Transactional
    public Respota savarResposta(Respota resposta){
        resposta.setDataResposta(LocalDateTime.now(ZoneId.of("UTC")));
        return respostaRepository.save(resposta);
    }
    public Optional<Respota> findById(Long id){
        return respostaRepository.findById(id);
    }
    public Page<Respota> findAll(Pageable pageable){
        Page<Respota>respotas=respostaRepository.findAll(pageable);
        return respotas;
    }
    @Transactional
    public Respota atualizarResposra(Long id,Respota respota){
      respota.setId(id);
      return respostaRepository.save(respota);
    }
    @Transactional
    public void deletarResposta(Long id){
        respostaRepository.deleteById(id);
    }
}

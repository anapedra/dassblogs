package com.anasantanapedrosaprdro.dassblogs.services;

import com.anasantanapedrosaprdro.dassblogs.model.Permissao;
import com.anasantanapedrosaprdro.dassblogs.repositorys.permissaorepository.PermissaoRepository;
import com.anasantanapedrosaprdro.dassblogs.services.exeptions.EntityNotFoundExcepion;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

@Service
@Transactional
public class PermissaoService {

    private final PermissaoRepository permissaoRepository;
    public PermissaoService(PermissaoRepository permissaoRepository) {
        this.permissaoRepository = permissaoRepository;
    }
    public Permissao savePermissao(Permissao permissao){
        permissao.setDataCriaão(LocalDateTime.now(ZoneId.of("UTC")));
        return permissaoRepository.saveAndFlush(permissao);
    }
    public Permissao findByIdPermissao(Long id){
        Optional<Permissao> permissao=permissaoRepository.findById(id);
        return permissao.orElseThrow(
                ()->new EntityNotFoundExcepion("Id "+id+" not found"));
    }
    public Page<Permissao> findAllPermissao(Pageable pageable){
        Page<Permissao> permissaos=permissaoRepository.findAll(pageable);
        return permissaos;
    }
    public Permissao atualizarPermissao(Long id,Permissao permissao){
        permissao= findByIdPermissao(id);
        permissao.setDataAtualizacao(LocalDateTime.now(ZoneId.of("UTC")));
        BeanUtils.copyProperties(permissao,"id");
        permissao.setId(id);
        return permissao;
        /*
        desse geito da certo!
        Respota res=findById(id);
        BeanUtils.copyProperties(respota,res,"id");
        respota.setId(id);
        return respostaRepository.save(respota);
         */

    }
    public void delatarPermissao(Long id){
        findByIdPermissao(id);
        permissaoRepository.deleteById(id);
    }


}

package com.anasantanapedrosaprdro.dassblogs.services.usuarioservice;

import com.anasantanapedrosaprdro.dassblogs.model.Usuaria;
import com.anasantanapedrosaprdro.dassblogs.repositorys.usuariorepository.UsuarioRepository;
import com.anasantanapedrosaprdro.dassblogs.services.exeptions.EntityNotFoundExcepion;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

@Service
@Transactional
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    public Usuaria saveUsuario(Usuaria usuaria){
        usuaria.setDataCriação(LocalDateTime.now(ZoneId.of("UTC")));
      return   usuarioRepository.saveAndFlush(usuaria);
    }
    public Usuaria findById(Long id){
        Optional<Usuaria> usuario= usuarioRepository.findById(id);
        return usuario.orElseThrow(
                ()->new EntityNotFoundExcepion("Id "+id+" not found"));
    }
    public Page<Usuaria> findAll(Pageable pageable){
        Page<Usuaria> usuario = usuarioRepository.findAll(pageable);
        return usuario;
    }
    public Usuaria atualizarUsuario(Long id,Usuaria usuaria){
        Usuaria usuario =findById(id);
        usuario.setDataAtualização(LocalDateTime.now(ZoneId.of("UTC")));
        BeanUtils.copyProperties(usuaria,usuario,"id");
        usuario.setId(id);
        return usuarioRepository.saveAndFlush(usuario);
    }
    public void delatarUsuario(Long id){
        findById(id);
        usuarioRepository.deleteById(id);
    }

}

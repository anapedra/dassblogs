package com.anasantanapedrosaprdro.dassblogs.services.comentarioservice;

import com.anasantanapedrosaprdro.dassblogs.model.Comentario;
import com.anasantanapedrosaprdro.dassblogs.repositorys.comentariorepository.ComentarioRepository;
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
public class ComentarioService {

    final ComentarioRepository comentarioRepository;
    public ComentarioService(ComentarioRepository comentarioRepository) {
        this.comentarioRepository = comentarioRepository;
    }
    @Transactional
    public Comentario seveCoentario(Comentario comentario){
        comentario.setDataComentario(LocalDateTime.now(ZoneId.of("UTC")));
        return comentarioRepository.save(comentario);
    }
    public Comentario findById(Long id){
      Optional<Comentario> comentario=comentarioRepository.findById(id);
      return comentario.orElseThrow(
              ()->new EntityNotFoundExcepion("Id "+id+" not found"));
    }
    public Page<Comentario> findAll(Pageable pageable){
        Page<Comentario>comentarios=comentarioRepository.findAll(pageable);
        return comentarios;
    }
    @Transactional
    public Comentario atualizarComentario(Long id,Comentario comentario){
        Comentario comenta=findById(id);
        BeanUtils.copyProperties(comentario,comenta,"id");
        comentario.setId(id);
        return comentarioRepository.save(comentario);
    }
    @Transactional
    public void delatarComentario(Long id){
        findById(id);
        comentarioRepository.deleteById(id);
    }
}

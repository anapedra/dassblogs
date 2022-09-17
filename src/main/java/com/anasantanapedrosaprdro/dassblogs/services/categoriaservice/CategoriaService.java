package com.anasantanapedrosaprdro.dassblogs.services.categoriaservice;

import com.anasantanapedrosaprdro.dassblogs.model.Categoria;
import com.anasantanapedrosaprdro.dassblogs.repositorys.categoriarepository.CategoriaRepository;
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
public class CategoriaService {

    final CategoriaRepository categoriaRepository;
    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }
    @Transactional
    public Categoria savarCategoria(Categoria categoria){
        categoria.setDataCategoria(LocalDateTime.now(ZoneId.of("UTC")));
      return   categoriaRepository.save(categoria);
    }
    public Categoria findByid(Long id){
        Optional<Categoria> categoria=categoriaRepository.findById(id);
        return categoria.orElseThrow(
                ()-> new EntityNotFoundExcepion("Id "+id+" not found"));

    }
    public Page<Categoria> findAll(Pageable pageable){
        Page<Categoria>categorias=categoriaRepository.findAll(pageable);
        return categorias;
    }
    @Transactional
    public Categoria atualizarCategoria(Long id, Categoria categoria){
        Categoria categ= findByid(id);
        BeanUtils.copyProperties(categoria,categ,"id");
        categoria.setId(id);
        return categoriaRepository.save(categoria);
    }
    @Transactional
    public void deletarCategoria(Long id){
         findByid(id);
        categoriaRepository.deleteById(id);
    }
}

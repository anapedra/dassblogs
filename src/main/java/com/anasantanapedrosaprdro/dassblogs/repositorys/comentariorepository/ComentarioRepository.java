package com.anasantanapedrosaprdro.dassblogs.repositorys.comentariorepository;

import com.anasantanapedrosaprdro.dassblogs.model.Comentario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario,Long> {

}

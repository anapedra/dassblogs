package com.anasantanapedrosaprdro.dassblogs.repositorys.comentariorepository;

import com.anasantanapedrosaprdro.dassblogs.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario,Long> {
}

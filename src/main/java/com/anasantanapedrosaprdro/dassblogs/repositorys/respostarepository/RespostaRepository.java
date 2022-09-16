package com.anasantanapedrosaprdro.dassblogs.repositorys.respostarepository;

import com.anasantanapedrosaprdro.dassblogs.model.Respota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RespostaRepository extends JpaRepository<Respota,Long> {
}

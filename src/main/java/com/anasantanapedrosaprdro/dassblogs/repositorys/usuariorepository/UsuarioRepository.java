package com.anasantanapedrosaprdro.dassblogs.repositorys.usuariorepository;

import com.anasantanapedrosaprdro.dassblogs.model.Usuaria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuaria, Long> {
}

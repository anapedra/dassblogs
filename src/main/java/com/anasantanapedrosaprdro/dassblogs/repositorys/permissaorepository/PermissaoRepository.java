package com.anasantanapedrosaprdro.dassblogs.repositorys.permissaorepository;

import com.anasantanapedrosaprdro.dassblogs.model.Permissao;
import com.anasantanapedrosaprdro.dassblogs.repositorys.postrepository.PostRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


public interface PermissaoRepository extends JpaRepository<Permissao,Long> {

}

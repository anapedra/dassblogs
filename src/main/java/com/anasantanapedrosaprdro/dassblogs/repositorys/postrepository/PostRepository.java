package com.anasantanapedrosaprdro.dassblogs.repositorys.postrepository;

import com.anasantanapedrosaprdro.dassblogs.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {

    @Query("SELECT obj from Post obj WHERE obj.dataPost >= :minDataPost AND obj.dataPost <= :maxDataPost")
    Page<Post> searchPost(LocalDateTime minDataPost, LocalDateTime maxDataPost, Pageable pageable);

}

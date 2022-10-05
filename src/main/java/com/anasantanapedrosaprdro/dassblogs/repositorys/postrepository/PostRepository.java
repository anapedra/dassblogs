package com.anasantanapedrosaprdro.dassblogs.repositorys.postrepository;

import com.anasantanapedrosaprdro.dassblogs.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {

    @Query("SELECT t FROM Post t WHERE t.dataPost BETWEEN :minDataPost and :maxDataPost")
    public Page<Post> findByPeriod(String minDataPost, String maxDataPost, Pageable pageable);

  //  @Modifying
  //  @Transactional
    @Query("select d from Post d where d.dataPost >= :minDataPost and d.dataPost <= :maxDataPost ")
    Page<Post> findByCreatedDateBetween(@Param("minDataPost") Date from, @Param("maxDataPost ") Date to,Pageable pageable);


    @Query("SELECT obj from Post obj WHERE obj.dataPost >= :minDataPost AND obj.dataPost <= :maxDataPost")
    Page<Post> findPosFildBetwenn(LocalDateTime minDataPost, LocalDateTime maxDataPost, Pageable pageable);


    /*
    valoresDoble

    @Query("SELECT * FROM Post u WHERE u.dataPost BETWEEN  startDate AND endDate")
    Page<Post> findPostFildBetween(LocalDateTime startDate, LocalDateTime endDate,Pageable pageable)

SELECT * FROM users WHERE timeStamp BETWEEN 'fromDate' AND 'toDate';
findByTimeStampGreaterThanEqualAndTimeStampLessThanEqual(fromDate,toDate)


@Temporal(value = TemporalType.DATE)
@DateTimeFormat(pattern = "yyyy/MM/dd")
 private Date date = new Date();

@Query("SELECT t FROM Conta t WHERE t.date BETWEEN :inicio and :termino")
public List<Conta> findByPeriod(String inicio, String termino);

@GetMapping(value = "/findByPeriod/{inicio}/{termino}")
public ResponseEntity<List<Conta>> findByPeriod(@PathVariable String inicio, @PathVariable String termino) {
    List<Conta> collection = contaRepository.findByPeriod(inicio, termino);
    return ResponseEntity.ok().body(collection);
    }
     */



}

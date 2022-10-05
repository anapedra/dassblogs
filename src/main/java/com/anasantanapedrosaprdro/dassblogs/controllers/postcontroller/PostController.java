package com.anasantanapedrosaprdro.dassblogs.controllers.postcontroller;

import com.anasantanapedrosaprdro.dassblogs.DTOs.postDTO.PostDTO;
import com.anasantanapedrosaprdro.dassblogs.model.Post;
import com.anasantanapedrosaprdro.dassblogs.services.postservice.PostService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NamedStoredProcedureQueries;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/post")
public class PostController {

    final PostService postService;
    public PostController(PostService postService) {
        this.postService = postService;
    }
    @PostMapping
    public ResponseEntity<Object> savePost(@RequestBody @Valid PostDTO postDTO){
        var post= new Post();
        BeanUtils.copyProperties(postDTO,post);
        return ResponseEntity.status(HttpStatus.CREATED).body(postService.savePost(post));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable(value = "id") Long id){
      Post post=postService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(post);
    }
    @GetMapping
    public ResponseEntity<Page<Post>> findAll(Pageable pageable){
        Page<Post>posts=postService.findAll(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(posts);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarPost(@PathVariable(value = "id") Long id, @RequestBody @Valid PostDTO postDTO){
        var post=new Post();
        BeanUtils.copyProperties(postDTO,post);
        postService.atualizarPost(id,post);
        return ResponseEntity.status(HttpStatus.CREATED).body(postService.savePost(post));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarPost(@PathVariable(value = "id") Long id){
        postService.dalatarPost(id);
        return ResponseEntity.status(HttpStatus.OK).body("Post delatado com sucesso!");
    }
    /*
    @GetMapping(value = "/searchdata")
    public ResponseEntity<Page<Post>> searchData(@RequestParam(defaultValue = "2022-01-18T22:36:38Z")String minDataPost,
                                                 @RequestParam(defaultValue = "2500-09-18T22:36:38Z")String maxDataPost,Pageable pageable){
        Page<Post> posts=postService.findByCreatedDateBetween(minDataPost,maxDataPost,pageable);
        return ResponseEntity.status(HttpStatus.OK).body(posts);
    }
    @GetMapping(value = "/findByPeriod/{minDataPos}/{maxDataPostr}")
    public ResponseEntity<Page<Post>> findByPeriod(@PathVariable String minDataPost, @PathVariable String maxDataPostr,Pageable pageable) {
        Page<Post> posts = postService.findByPeriod(minDataPost,maxDataPostr,pageable);
        return ResponseEntity.ok().body(posts);
    }

     */

}

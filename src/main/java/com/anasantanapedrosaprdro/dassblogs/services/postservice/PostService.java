package com.anasantanapedrosaprdro.dassblogs.services.postservice;

import com.anasantanapedrosaprdro.dassblogs.model.Post;
import com.anasantanapedrosaprdro.dassblogs.repositorys.postrepository.PostRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

@Service
public class PostService {

    final PostRepository postRepository;
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
    @Transactional
    public Post savePost(Post post){
        post.setDataPost(LocalDateTime.now(ZoneId.of("UTC")));
      return    postRepository.save(post);
    }
    public Optional<Post> findById(Long id){
        return postRepository.findById(id);
    }
    public Page<Post> findAll(Pageable pageable){
        Page<Post>posts=postRepository.findAll(pageable);
        return posts;
    }
    @Transactional
    public Post atualizarPost(Long id,Post post){
        post.setId(id);
        return postRepository.save(post);
    }
    @Transactional
    public void dalatarPost(Long id){
        postRepository.deleteById(id);
    }
}

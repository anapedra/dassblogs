package com.anasantanapedrosaprdro.dassblogs.services.postservice;

import com.anasantanapedrosaprdro.dassblogs.model.Post;
import com.anasantanapedrosaprdro.dassblogs.repositorys.postrepository.PostRepository;
import com.anasantanapedrosaprdro.dassblogs.services.exeptions.EntityNotFoundExcepion;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
@Transactional
public class PostService {

    final PostRepository postRepository;
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post savePost(Post post){
        post.setDataPost(LocalDateTime.now(ZoneId.of("UTC")));
      return    postRepository.save(post);
    }
    public Post findById(Long id){
        return postRepository.findById(id).orElseThrow(
                ()-> new EntityNotFoundExcepion("Id "+id+" not found"));
    }
    public Page<Post> findAll(Pageable pageable){
        Page<Post>posts=postRepository.findAll(pageable);
        return posts;
    }

    public Post atualizarPost(Long id,Post post){
        Post postar= findById(id);
        BeanUtils.copyProperties(post,postar,"id");
        post.setId(id);
        return postRepository.save(postar);
    }

    public void dalatarPost(Long id){
        findById(id);
        postRepository.deleteById(id);
    }


    public Page<Post>findByCreatedDateBetween (String minDataPost, String maxDataPost, Pageable pageable) {
        Page<Post> posts=postRepository.findByPeriod(minDataPost,maxDataPost,pageable);
        return posts;
    }

    public Page<Post> findByPeriod(String minDataapaost, String maxDataPost,Pageable pageable) {
        Page<Post> posts=postRepository.findByPeriod(minDataapaost,maxDataPost,pageable);
        return posts;
    }
}

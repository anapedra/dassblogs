package com.anasantanapedrosaprdro.dassblogs.services.permissaoAutorAervice;

import com.anasantanapedrosaprdro.dassblogs.model.Comentario;
import com.anasantanapedrosaprdro.dassblogs.model.Permissao;
import com.anasantanapedrosaprdro.dassblogs.model.Post;
import com.anasantanapedrosaprdro.dassblogs.model.Respota;
import com.anasantanapedrosaprdro.dassblogs.repositorys.comentariorepository.ComentarioRepository;
import com.anasantanapedrosaprdro.dassblogs.repositorys.permissaorepository.PermissaoRepository;
import com.anasantanapedrosaprdro.dassblogs.repositorys.postrepository.PostRepository;
import com.anasantanapedrosaprdro.dassblogs.repositorys.respostarepository.RespostaRepository;
import com.anasantanapedrosaprdro.dassblogs.services.exeptions.EntityNotFoundExcepion;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

@Service
@Transactional
public class PermissaoAutorService {
    private final PostRepository postRepository;
    private final ComentarioRepository comentarioRepository;
    private final RespostaRepository respostaRepository;
    private final PermissaoRepository permissaoRepository;

    public PermissaoAutorService(PostRepository postRepository, ComentarioRepository comentarioRepository,
                                 RespostaRepository respostaRepository, PermissaoRepository permissaoRepository) {
        this.postRepository = postRepository;
        this.comentarioRepository = comentarioRepository;
        this.respostaRepository = respostaRepository;
        this.permissaoRepository = permissaoRepository;
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

    public Comentario findByIdComentario(Long id){
        Optional<Comentario> comentario=comentarioRepository.findById(id);
        return comentario.orElseThrow(
                ()->new EntityNotFoundExcepion("Id "+id+" not found"));
    }
    public Page<Comentario> findAllComentario(Pageable pageable){
        Page<Comentario>comentarios=comentarioRepository.findAll(pageable);
        return comentarios;
    }
    public void delatarComentario(Long id){
        findById(id);
        comentarioRepository.deleteById(id);
    }
    public Respota findByIdResposta(Long id){
        Optional<Respota>respota=respostaRepository.findById(id);
        return respota.orElseThrow(
                ()->new EntityNotFoundExcepion("Id "+id+" not found"));
    }
    public Page<Respota> findAllResposta(Pageable pageable){
        Page<Respota>respotas=respostaRepository.findAll(pageable);
        return respotas;
    }
    public void deletarResposta(Long id){
        findById(id);
        respostaRepository.deleteById(id);
    }
    public Respota findByIdPermissao(Long id){
        Optional<Respota>respota=respostaRepository.findById(id);
        return respota.orElseThrow(
                ()->new EntityNotFoundExcepion("Id "+id+" not found"));
    }
    public Page<Respota> findAllPermissao(Pageable pageable){
        Page<Respota>respotas=respostaRepository.findAll(pageable);
        return respotas;
    }
    public void delatarPermissao(Long id){
        Permissao permissao=new Permissao();
        findByIdPermissao(id);
        permissaoRepository.deleteById(id);
        permissao.setUsuaria(null);

    }


}



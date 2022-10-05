package com.anasantanapedrosaprdro.dassblogs.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "post_tb")
public class Post implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false)
    private String autor;
    @Column(nullable = false)
    private String titulo;
    @Lob
    private String texto;
    @Column
    private LocalDateTime dataPost;
    @ManyToMany
    @JoinTable(name = "tb_post_category",joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Comentario> comentarios=new ArrayList<>();


    public Post(){
    }

    public Post(long id, String autor, String titulo, String texto, LocalDateTime dataPost, List<Comentario> comentarios) {
        this.id = id;
        this.autor = autor;
        this.titulo = titulo;
        this.texto = texto;
        this.dataPost = dataPost;
        this.comentarios = comentarios;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post)) return false;
        Post post = (Post) o;
        return getId() == post.getId() && Objects.equals(getAutor(), post.getAutor()) && Objects.equals(getTitulo(),
                post.getTitulo()) && Objects.equals(getTexto(), post.getTexto()) && Objects.equals(getDataPost(), post.getDataPost())
                && Objects.equals(getCategorias(), post.getCategorias()) && Objects.equals(getComentarios(), post.getComentarios());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAutor(), getTitulo(), getTexto(), getDataPost(), getCategorias(), getComentarios());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public LocalDateTime getDataPost() {
        return dataPost;
    }

    public void setDataPost(LocalDateTime dataPost) {
        this.dataPost = dataPost;
    }

    public Set<Categoria> getCategorias() {
        return getCategorias();
    }


    public List<Comentario> getComentarios() {
        return comentarios;
    }
 }


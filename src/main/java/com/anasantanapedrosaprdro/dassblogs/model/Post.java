package com.anasantanapedrosaprdro.dassblogs.model;

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
    @ManyToOne
    @JoinColumn(name = "pais_id")
    private Pais pais;
    @ManyToMany(mappedBy = "posts")
   // @JoinTable(name = "tb_post_categoria",joinColumns = @JoinColumn(name = "post_id"),inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    private Set<Categoria> categorias=new HashSet<>();
    @OneToMany (mappedBy = "post")
    private List<Comentario> comentarios=new ArrayList<>();


    public Post(){
    }


    public Post(long id, String autor, String titulo, String texto, LocalDateTime dataPost) {
        this.id = id;
        this.autor = autor;
        this.titulo = titulo;
        this.texto = texto;
        this.dataPost = dataPost;


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

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", autor='" + autor + '\'' +
                ", titulo='" + titulo + '\'' +
                ", texto='" + texto + '\'' +
                ", dataPost=" + dataPost +
                ", pais=" + pais +
                ", categorias=" + categorias +
                ", comentarios=" + comentarios +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post)) return false;
        Post post = (Post) o;
        return getId() == post.getId() && Objects.equals(getAutor(), post.getAutor()) && Objects.equals(getTitulo(), post.getTitulo()) &&
                Objects.equals(getTexto(), post.getTexto()) && Objects.equals(getDataPost(), post.getDataPost()) &&
                Objects.equals(getPais(), post.getPais()) && Objects.equals(getCategorias(), post.getCategorias()) &&
                Objects.equals(getComentarios(), post.getComentarios());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAutor(), getTitulo(), getTexto(), getDataPost(), getPais(), getCategorias(), getComentarios());
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Pais getPais() {
        return pais;
    }

    public Set<Categoria> getCategorias() {
        return categorias;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }


}


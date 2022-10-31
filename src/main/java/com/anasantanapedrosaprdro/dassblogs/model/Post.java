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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String autor;
    @Column(nullable = false)
    private String titulo;
    @Lob
    private String texto;
    @Column
    private LocalDateTime dataPost;
    @OneToMany (mappedBy = "post")
    private List<Comentario> comentarios=new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Categoria categoria;
    @OneToMany(mappedBy = "post")
    private List<Usuaria> usuarias=new ArrayList<>();


    /*
    @ManyToMany
    @JoinTable(name = "tb_post_categoria",joinColumns =
            {@JoinColumn(name = "post_id")},inverseJoinColumns =
            {@JoinColumn(name = "categoria_id")})
    private Set<Categoria> categorias=new HashSet<>();

     */


    public Post(){
    }
    public Post(long id, String autor, String titulo, String texto, LocalDateTime dataPost,Categoria categoria) {
        this.id = id;
        this.autor = autor;
        this.titulo = titulo;
        this.texto = texto;
        this.dataPost = dataPost;
        this.categoria=categoria;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", autor='" + autor + '\'' +
                ", titulo='" + titulo + '\'' +
                ", texto='" + texto + '\'' +
                ", dataPost=" + dataPost +
                ", comentarios=" + comentarios +
                ", categoria=" + categoria +
                ", usuarias=" + usuarias +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post)) return false;
        Post post = (Post) o;
        return getId() == post.getId() && Objects.equals(getAutor(), post.getAutor()) && Objects.equals(getTitulo(), post.getTitulo()) && Objects.equals(getTexto(), post.getTexto()) && Objects.equals(getDataPost(), post.getDataPost()) && Objects.equals(getComentarios(), post.getComentarios()) && Objects.equals(getCategoria(), post.getCategoria()) && Objects.equals(getUsuarias(), post.getUsuarias());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAutor(), getTitulo(), getTexto(), getDataPost(), getComentarios(), getCategoria(), getUsuarias());
    }

    public List<Usuaria> getUsuarias() {
        return usuarias;
    }

    public long getId() {
        return id;
    }

    public String getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getTexto() {
        return texto;
    }

    public LocalDateTime getDataPost() {
        return dataPost;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setDataPost(LocalDateTime dataPost) {
        this.dataPost = dataPost;
    }


    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

}


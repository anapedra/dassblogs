package com.anasantanapedrosaprdro.dassblogs.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "comentario_tb")
public class Comentario implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String texto;
    @Column
    private LocalDateTime dataComentario;
    @ManyToOne
    @JoinColumn(name = "idPost")
    private Post post;
    @OneToMany(mappedBy = "comentario")
    private List<Respota>respotas=new ArrayList<>();

    public Comentario(){
    }

    public Comentario(long id, String texto, LocalDateTime dataComentario, Post post, List<Respota> respotas) {
        this.id = id;
        this.texto = texto;
        this.dataComentario = dataComentario;
        this.post = post;
        this.respotas = respotas;
    }

    @Override
    public String toString() {
        return "Comentario{" +
                "id=" + id +
                ", texto='" + texto + '\'' +
                ", dataComentario=" + dataComentario +
                ", post=" + post +
                ", respotas=" + respotas +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comentario)) return false;
        Comentario that = (Comentario) o;
        return getId() == that.getId() && Objects.equals(getTexto(), that.getTexto()) && Objects.equals(getDataComentario(), that.getDataComentario()) && Objects.equals(getPost(), that.getPost()) && Objects.equals(getRespotas(), that.getRespotas());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTexto(), getDataComentario(), getPost(), getRespotas());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public LocalDateTime getDataComentario() {
        return dataComentario;
    }

    public void setDataComentario(LocalDateTime dataComentario) {
        this.dataComentario = dataComentario;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public List<Respota> getRespotas() {
        return respotas;
    }

    public void setRespotas(List<Respota> respotas) {
        this.respotas = respotas;
    }
}

package com.anasantanapedrosaprdro.dassblogs.DTOs.comentarioDTO;

import com.anasantanapedrosaprdro.dassblogs.model.Post;
import com.anasantanapedrosaprdro.dassblogs.model.Respota;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ComentarioDTO {

    private String texto;
    private Post post;
    private List<Respota> respotas=new ArrayList<>();

    public ComentarioDTO(){
    }

    public ComentarioDTO(String texto, Post post, List<Respota> respotas) {
        this.texto = texto;
        this.post = post;
        this.respotas = respotas;
    }

    @Override
    public String toString() {
        return "ComentarioDTO{" +
                "texto='" + texto + '\'' +
                ", post=" + post +
                ", respotas=" + respotas +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ComentarioDTO)) return false;
        ComentarioDTO that = (ComentarioDTO) o;
        return Objects.equals(getTexto(), that.getTexto()) && Objects.equals(getPost(), that.getPost()) && Objects.equals(getRespotas(), that.getRespotas());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTexto(), getPost(), getRespotas());
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
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

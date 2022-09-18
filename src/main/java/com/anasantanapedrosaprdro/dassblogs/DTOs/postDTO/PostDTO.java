package com.anasantanapedrosaprdro.dassblogs.DTOs.postDTO;

import com.anasantanapedrosaprdro.dassblogs.model.Categoria;
import com.anasantanapedrosaprdro.dassblogs.model.Comentario;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PostDTO {
    @NotBlank
    private String autor;
    @NotBlank
    private String titulo;
    private String texto;
    private Categoria categoria;
    private List<Comentario> comentarios=new ArrayList<>();

    public PostDTO(){
    }

    public PostDTO(String autor, String titulo, String texto, Categoria categoria, List<Comentario> comentarios) {
        this.autor = autor;
        this.titulo = titulo;
        this.texto = texto;
        this.categoria = categoria;
        this.comentarios = comentarios;
    }

    @Override
    public String toString() {
        return "PostDTO{" +
                "autor='" + autor + '\'' +
                ", titulo='" + titulo + '\'' +
                ", texto='" + texto + '\'' +
                ", categoria=" + categoria +
                ", comentarios=" + comentarios +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PostDTO)) return false;
        PostDTO postDTO = (PostDTO) o;
        return Objects.equals(getAutor(), postDTO.getAutor()) && Objects.equals(getTitulo(), postDTO.getTitulo()) && Objects.equals(getTexto(), postDTO.getTexto()) && Objects.equals(getCategoria(), postDTO.getCategoria()) && Objects.equals(getComentarios(), postDTO.getComentarios());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAutor(), getTitulo(), getTexto(), getCategoria(), getComentarios());
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
}

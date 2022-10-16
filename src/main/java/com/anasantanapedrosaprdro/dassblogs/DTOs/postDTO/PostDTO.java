package com.anasantanapedrosaprdro.dassblogs.DTOs.postDTO;

import com.anasantanapedrosaprdro.dassblogs.model.Categoria;
import com.anasantanapedrosaprdro.dassblogs.model.Comentario;
import javax.validation.constraints.NotBlank;
import java.util.*;

public class PostDTO {
    @NotBlank
    private String autor;
    @NotBlank
    private String titulo;
    private String texto;
    private List<Comentario> comentarios=new ArrayList<>();
    private Set<Categoria> categorias=new HashSet<>();

    public PostDTO(){
    }

    public PostDTO(String autor, String titulo, String texto) {
        this.autor = autor;
        this.titulo = titulo;
        this.texto = texto;
    }

    @Override
    public String toString() {
        return "PostDTO{" +
                "autor='" + autor + '\'' +
                ", titulo='" + titulo + '\'' +
                ", texto='" + texto + '\'' +
                ", comentarios=" + comentarios +
                ", categorias=" + categorias +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PostDTO)) return false;
        PostDTO postDTO = (PostDTO) o;
        return Objects.equals(getAutor(), postDTO.getAutor()) && Objects.equals(getTitulo(), postDTO.getTitulo()) && Objects.equals(getTexto(), postDTO.getTexto()) && Objects.equals(getComentarios(), postDTO.getComentarios()) && Objects.equals(getCategorias(), postDTO.getCategorias());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAutor(), getTitulo(), getTexto(), getComentarios(), getCategorias());
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public Set<Categoria> getCategorias() {
        return categorias;
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
}

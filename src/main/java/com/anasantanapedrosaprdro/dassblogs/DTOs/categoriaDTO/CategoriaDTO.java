package com.anasantanapedrosaprdro.dassblogs.DTOs.categoriaDTO;

import com.anasantanapedrosaprdro.dassblogs.model.Post;

import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class CategoriaDTO {

    @NotBlank
    private String nome;
    private Set<Post>posts=new HashSet<>();

    public CategoriaDTO(){
    }

    public CategoriaDTO(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CategoriaDTO)) return false;
        CategoriaDTO that = (CategoriaDTO) o;
        return Objects.equals(getNome(), that.getNome()) && Objects.equals(getPosts(), that.getPosts());
    }

    @Override
    public String toString() {
        return "CategoriaDTO{" +
                "nome='" + nome + '\'' +
                ", posts=" + posts +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Post> getPosts() {
        return posts;
    }
}

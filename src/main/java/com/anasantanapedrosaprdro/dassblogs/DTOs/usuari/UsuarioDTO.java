package com.anasantanapedrosaprdro.dassblogs.DTOs.usuari;

import com.anasantanapedrosaprdro.dassblogs.model.Permissao;
import com.anasantanapedrosaprdro.dassblogs.model.Post;

import java.util.List;
import java.util.Objects;

public class UsuarioDTO {
    private String nome;
    private String email;
    private List<Permissao> permissaos;
    private Post post;

    public UsuarioDTO(String nome, String email,Post post) {
        this.nome = nome;
        this.email = email;
        this.post=post;

    }
    public UsuarioDTO(){

    }

    public List<Permissao> getPermissaos() {
        return permissaos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UsuarioDTO{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", permissaos=" + permissaos +
                ", post=" + post +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UsuarioDTO)) return false;
        UsuarioDTO that = (UsuarioDTO) o;
        return Objects.equals(getNome(), that.getNome()) && Objects.equals(getEmail(), that.getEmail()) && Objects.equals(getPermissaos(), that.getPermissaos()) && Objects.equals(getPost(), that.getPost());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getEmail(), getPermissaos(), getPost());
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}

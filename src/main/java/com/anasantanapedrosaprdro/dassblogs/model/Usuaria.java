package com.anasantanapedrosaprdro.dassblogs.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_usuario")
public class Usuaria implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Email
    private String email;
    @Column
    private String senha;
    @Column
    private  LocalDateTime dataCriação;
    @Column
    private LocalDateTime dataAtualização;
    @OneToMany(mappedBy = "usuaria")
    private List<Permissao> permissaos;
    @ManyToOne
    @JoinColumn(name = "post_id")
    @JsonIgnore
    private Post post;


    public Usuaria() {

    }

    @Override
    public String toString() {
        return "Usuaria{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", dataCriação=" + dataCriação +
                ", dataAtualização=" + dataAtualização +
                ", permissaos=" + permissaos +
                ", post=" + post +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuaria)) return false;
        Usuaria usuaria = (Usuaria) o;
        return Objects.equals(getId(), usuaria.getId()) && Objects.equals(getNome(), usuaria.getNome()) && Objects.equals(getEmail(), usuaria.getEmail()) && Objects.equals(getSenha(), usuaria.getSenha()) && Objects.equals(getDataCriação(), usuaria.getDataCriação()) && Objects.equals(getDataAtualização(), usuaria.getDataAtualização()) && Objects.equals(getPermissaos(), usuaria.getPermissaos()) && Objects.equals(post, usuaria.post);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getEmail(), getSenha(), getDataCriação(), getDataAtualização(), getPermissaos(), post);
    }

    public Usuaria(Long id, String nome, String email, String senha, LocalDateTime dataCriação, LocalDateTime dataAtualização, Post post) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dataCriação = dataCriação;
        this.dataAtualização = dataAtualização;
        this.post=post;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDateTime getDataCriação() {
        return dataCriação;
    }

    public void setDataCriação(LocalDateTime dataCriação) {
        this.dataCriação = dataCriação;
    }

    public LocalDateTime getDataAtualização() {
        return dataAtualização;
    }

    public void setDataAtualização(LocalDateTime dataAtualização) {
        this.dataAtualização = dataAtualização;
    }

    public List<Permissao> getPermissaos() {
        return permissaos;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}

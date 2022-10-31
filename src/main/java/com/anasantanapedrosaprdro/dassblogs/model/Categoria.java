package com.anasantanapedrosaprdro.dassblogs.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "categoria_tb" )
public class Categoria implements Serializable {


    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String nome;
    @Column
    private LocalDateTime dataCategoria;
    @OneToMany(mappedBy = "categoria")
    @JsonIgnore
    private List<Post>posts=new ArrayList<>();




    //  @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  //@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "categorias")
 // @JsonIgnore


    public Categoria(){
    }

    public Categoria(long id, String nome, LocalDateTime dataCategoria) {
        this.id = id;
        this.nome = nome;
        this.dataCategoria = dataCategoria;

    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDateTime getDataCategoria() {
        return dataCategoria;
    }
    public void setId(long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataCategoria(LocalDateTime dataCategoria) {
        this.dataCategoria = dataCategoria;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dataCategoria=" + dataCategoria +
                ", posts=" + posts +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Categoria)) return false;
        Categoria categoria = (Categoria) o;
        return getId() == categoria.getId() && Objects.equals(getNome(), categoria.getNome()) && Objects.equals(getDataCategoria(), categoria.getDataCategoria()) && Objects.equals(getPosts(), categoria.getPosts());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getDataCategoria(), getPosts());
    }

    public List<Post> getPosts() {
        return posts;
    }

}

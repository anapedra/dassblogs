package com.anasantanapedrosaprdro.dassblogs.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "tb_permissao")
public class Permissao implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipoPermissao;
    private LocalDateTime dataCriaão;
    private LocalDateTime dataAtualizacao;
    @ManyToOne
    @JoinColumn(name = "permissao_id")
    @JsonIgnore
    private Usuaria usuaria;

    public Permissao(Long id,String tipoPermissao ,LocalDateTime dataCriaão, LocalDateTime dataAtualizacao, Usuaria usuaria) {
        this.id = id;
        this.tipoPermissao=tipoPermissao;
        this.dataCriaão = dataCriaão;
        this.dataAtualizacao = dataAtualizacao;
        this.usuaria = usuaria;
    }

    public Permissao() {

    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Permissao{" +
                "id=" + id +
                ", tipoPermissao='" + tipoPermissao + '\'' +
                ", dataCriaão=" + dataCriaão +
                ", dataAtualizacao=" + dataAtualizacao +
                ", usuaria=" + usuaria +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Permissao)) return false;
        Permissao permissao = (Permissao) o;
        return Objects.equals(getId(), permissao.getId()) && Objects.equals(getTipoPermissao(), permissao.getTipoPermissao()) && Objects.equals(getDataCriaão(), permissao.getDataCriaão()) && Objects.equals(getDataAtualizacao(), permissao.getDataAtualizacao()) && Objects.equals(getUsuaria(), permissao.getUsuaria());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTipoPermissao(), getDataCriaão(), getDataAtualizacao(), getUsuaria());
    }

    public String getTipoPermissao() {
        return tipoPermissao;
    }

    public void setTipoPermissao(String tipoPermissao) {
        this.tipoPermissao = tipoPermissao;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataCriaão() {
        return dataCriaão;
    }

    public void setDataCriaão(LocalDateTime dataCriaão) {
        this.dataCriaão = dataCriaão;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public Usuaria getUsuaria() {
        return usuaria;
    }

    public void setUsuaria(Usuaria usuaria) {
        this.usuaria = usuaria;
    }

}

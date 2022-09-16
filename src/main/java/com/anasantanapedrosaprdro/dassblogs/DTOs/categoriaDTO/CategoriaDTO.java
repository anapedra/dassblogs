package com.anasantanapedrosaprdro.dassblogs.DTOs.categoriaDTO;

import javax.validation.constraints.NotBlank;
import java.util.Objects;

public class CategoriaDTO {

    @NotBlank
    private String nome;

    public CategoriaDTO(){
    }

    public CategoriaDTO(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "CategoriaDTO{" +
                "nome='" + nome + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CategoriaDTO)) return false;
        CategoriaDTO that = (CategoriaDTO) o;
        return Objects.equals(getNome(), that.getNome());
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
}

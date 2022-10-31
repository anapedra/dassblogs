package com.anasantanapedrosaprdro.dassblogs.DTOs.permissaoDTO;

import com.anasantanapedrosaprdro.dassblogs.model.Usuaria;

import java.util.Objects;

public class PermissaoDTO {
    private Usuaria usuaria;
    private String tipoPermissao;

    public PermissaoDTO(Usuaria usuaria,String tipoPermissao) {
        this.usuaria = usuaria;
        this.tipoPermissao=tipoPermissao;
    }
    public PermissaoDTO(){

    }

    @Override
    public String toString() {
        return "PermissaoDTO{" +
                "usuaria=" + usuaria +
                ", tipoPermissao='" + tipoPermissao + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PermissaoDTO)) return false;
        PermissaoDTO that = (PermissaoDTO) o;
        return Objects.equals(getUsuaria(), that.getUsuaria()) && Objects.equals(getTipoPermissao(), that.getTipoPermissao());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUsuaria(), getTipoPermissao());
    }

    public String getTipoPermissao() {
        return tipoPermissao;
    }

    public void setTipoPermissao(String tipoPermissao) {
        this.tipoPermissao = tipoPermissao;
    }

    public Usuaria getUsuaria() {
        return usuaria;
    }

    public void setUsuaria(Usuaria usuaria) {
        this.usuaria = usuaria;
    }

}

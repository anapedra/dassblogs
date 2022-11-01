package com.anasantanapedrosaprdro.dassblogs.DTOs.permissaoautorDTO;

import com.anasantanapedrosaprdro.dassblogs.model.Usuaria;

import java.util.Objects;

public class PermissaoAutorDTO {
    private Usuaria usuaria;

    public PermissaoAutorDTO(){

    }

    public PermissaoAutorDTO(Usuaria usuaria) {
        this.usuaria = usuaria;
    }

    @Override
    public String toString() {
        return "PermissaoAutorDTO{" +
                "usuaria=" + usuaria +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PermissaoAutorDTO)) return false;
        PermissaoAutorDTO that = (PermissaoAutorDTO) o;
        return Objects.equals(getUsuaria(), that.getUsuaria());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUsuaria());
    }

    public Usuaria getUsuaria() {
        return usuaria;
    }

    public void setUsuaria(Usuaria usuaria) {
        this.usuaria = usuaria;
    }
}


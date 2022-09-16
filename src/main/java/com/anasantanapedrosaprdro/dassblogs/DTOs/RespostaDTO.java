package com.anasantanapedrosaprdro.dassblogs.DTOs;

import com.anasantanapedrosaprdro.dassblogs.model.Comentario;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

public class RespostaDTO {
    @NotBlank
    private String texto;
    private Comentario comentario;

    public RespostaDTO(){
    }

    public RespostaDTO(String texto, Comentario comentario) {
        this.texto = texto;
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "RespostaDTO{" +
                "texto='" + texto + '\'' +
                ", comentario=" + comentario +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RespostaDTO)) return false;
        RespostaDTO that = (RespostaDTO) o;
        return Objects.equals(getTexto(), that.getTexto()) && Objects.equals(getComentario(), that.getComentario());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTexto(), getComentario());
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Comentario getComentario() {
        return comentario;
    }

    public void setComentario(Comentario comentario) {
        this.comentario = comentario;
    }
}

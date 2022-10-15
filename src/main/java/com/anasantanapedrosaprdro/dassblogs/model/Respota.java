package com.anasantanapedrosaprdro.dassblogs.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "resposta_tb")
public class Respota implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String texto;
    @Column
    private LocalDateTime dataResposta;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "idComentario")
    private Comentario comentario;



    public Respota(){
    }

    public Respota(long id, String texto, LocalDateTime dataResposta, Comentario comentario) {
        this.id = id;
        this.texto = texto;
        this.dataResposta = dataResposta;
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "Respota{" +
                "id=" + id +
                ", texto='" + texto + '\'' +
                ", dataResposta=" + dataResposta +
                ", comentario=" + comentario +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Respota)) return false;
        Respota respota = (Respota) o;
        return id == respota.id && Objects.equals(texto, respota.texto) && Objects.equals(dataResposta, respota.dataResposta) && Objects.equals(comentario, respota.comentario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, texto, dataResposta, comentario);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public LocalDateTime getDataResposta() {
        return dataResposta;
    }

    public void setDataResposta(LocalDateTime dataResposta) {
        this.dataResposta = dataResposta;
    }

    public Comentario getComentario() {
        return comentario;
    }

    public void setComentario(Comentario comentario) {
        this.comentario = comentario;
    }
}

package App.Domain.Response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class Localizacao {

    private Long id;

    private String referencia;

    private Boolean disponivel;

    private int numeroLocalizacao;

    private Planta planta;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime timeStamp;

    public Localizacao() {
    }

    public Localizacao(Long id, String referencia, Boolean disponivel, int numeroLocalizacao, Planta planta, LocalDateTime timeStamp) {
        this.id = id;
        this.referencia = referencia;
        this.disponivel = disponivel;
        this.numeroLocalizacao = numeroLocalizacao;
        this.planta = planta;
        this.timeStamp = timeStamp;
    }

    public int getNumeroLocalizacao() {
        return numeroLocalizacao;
    }

    public void setNumeroLocalizacao(int numeroLocalizacao) {
        this.numeroLocalizacao = numeroLocalizacao;
    }

    public Planta getPlanta() {
        return planta;
    }

    public void setPlanta(Planta planta) {
        this.planta = planta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }


}

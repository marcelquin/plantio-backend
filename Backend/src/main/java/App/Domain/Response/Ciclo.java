package App.Domain.Response;

import App.Infra.Persistence.Enum.CICLO;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Ciclo {

    private Long id;

    @Enumerated(EnumType.STRING)
    private CICLO ciclo;

    private Germinacao germinacao;

    private Muda muda;

    private Crecimento crecimento;

    private Floracao floracao;

    private Frutificacao frutificacao;

    private Maturacao maturacao;

    private Fim fim;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataUltimoCiclo;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCicloAtual;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime timeStamp;

    public Ciclo() {
    }

    public Ciclo(Long id, CICLO ciclo, Germinacao germinacao, Muda muda, Crecimento crecimento, Floracao floracao, Frutificacao frutificacao, Maturacao maturacao, Fim fim, LocalDate dataUltimoCiclo, LocalDate dataCicloAtual, LocalDateTime timeStamp) {
        this.id = id;
        this.ciclo = ciclo;
        this.germinacao = germinacao;
        this.muda = muda;
        this.crecimento = crecimento;
        this.floracao = floracao;
        this.frutificacao = frutificacao;
        this.maturacao = maturacao;
        this.fim = fim;
        this.dataUltimoCiclo = dataUltimoCiclo;
        this.dataCicloAtual = dataCicloAtual;
        this.timeStamp = timeStamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CICLO getCiclo() {
        return ciclo;
    }

    public void setCiclo(CICLO ciclo) {
        this.ciclo = ciclo;
    }

    public Germinacao getGerminacao() {
        return germinacao;
    }

    public void setGerminacao(Germinacao germinacao) {
        this.germinacao = germinacao;
    }

    public Muda getMuda() {
        return muda;
    }

    public void setMuda(Muda muda) {
        this.muda = muda;
    }

    public Crecimento getCrecimento() {
        return crecimento;
    }

    public void setCrecimento(Crecimento crecimento) {
        this.crecimento = crecimento;
    }

    public Floracao getFloracao() {
        return floracao;
    }

    public void setFloracao(Floracao floracao) {
        this.floracao = floracao;
    }

    public Frutificacao getFrutificacao() {
        return frutificacao;
    }

    public void setFrutificacao(Frutificacao frutificacao) {
        this.frutificacao = frutificacao;
    }

    public Maturacao getMaturacao() {
        return maturacao;
    }

    public void setMaturacao(Maturacao maturacao) {
        this.maturacao = maturacao;
    }

    public Fim getFim() {
        return fim;
    }

    public void setFim(Fim fim) {
        this.fim = fim;
    }

    public LocalDate getDataUltimoCiclo() {
        return dataUltimoCiclo;
    }

    public void setDataUltimoCiclo(LocalDate dataUltimoCiclo) {
        this.dataUltimoCiclo = dataUltimoCiclo;
    }

    public LocalDate getDataCicloAtual() {
        return dataCicloAtual;
    }

    public void setDataCicloAtual(LocalDate dataCicloAtual) {
        this.dataCicloAtual = dataCicloAtual;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

}

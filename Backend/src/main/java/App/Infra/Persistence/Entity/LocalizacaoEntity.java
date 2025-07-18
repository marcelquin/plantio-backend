package App.Infra.Persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Localizacao")
public class LocalizacaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String referencia;

    private Boolean disponivel;

    private int numeroLocalizacao;

    @OneToOne
    @JoinColumn(name = "plantaEntity_id", referencedColumnName = "id")
    private PlantaEntity planta;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime timeStamp;

    public LocalizacaoEntity() {
    }

    public LocalizacaoEntity(Long id, String referencia, Boolean disponivel, int numeroLocalizacao, PlantaEntity planta, LocalDateTime timeStamp) {
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

    public PlantaEntity getPlanta() {
        return planta;
    }

    public void setPlanta(PlantaEntity planta) {
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

    public void SetInfoInicial(String identificadorLinha, int numeroLocalizacao)
    {
        this.disponivel = Boolean.TRUE;
        this.numeroLocalizacao = numeroLocalizacao;
        this.referencia = identificadorLinha+"-LC"+numeroLocalizacao;
        this.timeStamp = LocalDateTime.now();
    }

    public void AlterarReferencia(String linhaIdentificacao)
    {
        this.referencia = linhaIdentificacao+"-LC"+this.numeroLocalizacao;
        this.timeStamp = LocalDateTime.now();
    }

    public void Disponibilizar()
    {
        this.disponivel = Boolean.TRUE;
        this.planta = null;
        this.timeStamp = LocalDateTime.now();
    }

    public void Indisponibilizar(PlantaEntity planta)
    {
        this.disponivel = Boolean.FALSE;
        this.planta = planta;
        this.timeStamp = LocalDateTime.now();
    }
}

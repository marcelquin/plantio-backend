package App.Infra.Persistence.Entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Planta")
public class PlantaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeCientifico;

    private String nomePopular;

    private String instrucoes;

    private String localizacao;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate DataPlantio;

    @OneToOne
    @JoinColumn(name = "cicloEntity_id", referencedColumnName = "id")
    private CicloEntity ciclo;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime timeStamp;

    public PlantaEntity() {
    }

    public PlantaEntity(Long id, String nomeCientifico, String nomePopular, String instrucoes, String localizacao, LocalDate dataPlantio, CicloEntity ciclo, LocalDateTime timeStamp) {
        this.id = id;
        this.nomeCientifico = nomeCientifico;
        this.nomePopular = nomePopular;
        this.instrucoes = instrucoes;
        this.localizacao = localizacao;
        DataPlantio = dataPlantio;
        this.ciclo = ciclo;
        this.timeStamp = timeStamp;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCientifico() {
        return nomeCientifico;
    }

    public void setNomeCientifico(String nomeCientifico) {
        this.nomeCientifico = nomeCientifico;
    }

    public String getNomePopular() {
        return nomePopular;
    }

    public void setNomePopular(String nomePopular) {
        this.nomePopular = nomePopular;
    }

    public String getInstrucoes() {
        return instrucoes;
    }

    public void setInstrucoes(String instrucoes) {
        this.instrucoes = instrucoes;
    }


    public LocalDate getDataPlantio() {
        return DataPlantio;
    }

    public void setDataPlantio(LocalDate dataPlantio) {
        DataPlantio = dataPlantio;
    }

    public CicloEntity getCiclo() {
        return ciclo;
    }

    public void setCiclo(CicloEntity ciclo) {
        this.ciclo = ciclo;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void SetInfo(String nomePopular, String nomeCientifico, String instrucoes,String localizacao, CicloEntity ciclo)
    {
        this.nomePopular = nomePopular;
        this.instrucoes = instrucoes;
        this.nomeCientifico = nomeCientifico;
        this.timeStamp = LocalDateTime.now();
        this.localizacao = localizacao;
        this.DataPlantio = LocalDate.now();
        this.ciclo = ciclo;
    }

    public void EditInfo(String nomePopular, String nomeCientifico, String instrucoes)
    {
        this.nomePopular = nomePopular;
        this.nomeCientifico = nomeCientifico;
        this.instrucoes = instrucoes;
        this.timeStamp = LocalDateTime.now();
    }

    public void AlterarLocalizacao(String localizacao)
    {
        this.localizacao = localizacao;
        this.timeStamp = LocalDateTime.now();
    }

    public void FimCiclo()
    {
        this.localizacao = null;
        this.timeStamp = LocalDateTime.now();
    }

    public void ResetEntity()
    {
        this.ciclo = null;
        this.localizacao = null;
        this.timeStamp = LocalDateTime.now();
    }

}

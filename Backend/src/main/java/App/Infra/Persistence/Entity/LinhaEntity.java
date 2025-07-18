package App.Infra.Persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Linha")
public class LinhaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String identificador;

    private int numero;

    @OneToMany(cascade = CascadeType.ALL)
    private List<LocalizacaoEntity> localizacoes;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime timeStamp;

    public LinhaEntity() {
    }

    public LinhaEntity(Long id, String identificador, int numero, List<LocalizacaoEntity> localizacoes, LocalDateTime timeStamp) {
        this.id = id;
        this.identificador = identificador;
        this.numero = numero;
        this.localizacoes = localizacoes;
        this.timeStamp = timeStamp;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public List<LocalizacaoEntity> getLocalizacoes() {
        return localizacoes;
    }

    public void setLocalizacoes(List<LocalizacaoEntity> localizacoes) {
        this.localizacoes = localizacoes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void SetInfoInicial(String identificadorPlantio,int numero)
    {
        List<LocalizacaoEntity> list = new ArrayList<>();
        this.localizacoes = list;
        this.timeStamp = LocalDateTime.now();
        this.numero = numero;
        this.identificador = identificadorPlantio+":L"+numero;
    }

    public void AlterarIdentificador(String identificadorPlantio)
    {
        this.identificador = identificadorPlantio+":L"+this.numero;
        this.timeStamp = LocalDateTime.now();
    }

    public void ResetEntity()
    {
        List<LocalizacaoEntity> localizacaoEntities = new ArrayList<>();
        this.localizacoes = localizacaoEntities;
    }

}

package br.ifrs.vaccinare.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "crianca_vacina")
public class CriancaVacina implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "crianca_id")
    private Crianca crianca = new Crianca();
    @Id
    @ManyToOne
    @JoinColumn(name = "vacina_id")
    private Vacina vacina = new Vacina();
 
    
    @Column(nullable=false, length=10) 
    private String lote;
    @Temporal(value=TemporalType.DATE)
    private Date data;
     
    public CriancaVacina() {
    }
 
    
    
    public Crianca getCrianca() {
        return crianca;
    }

    public void setCrianca(Crianca crianca) {
        this.crianca = crianca;
    }

    public Vacina getVacina() {
        return vacina;
    }

    public void setVacina(Vacina vacina) {
        this.vacina = vacina;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass())
            return false;
 
        CriancaVacina that = (CriancaVacina) o;
        return Objects.equals(crianca, that.crianca) &&
               Objects.equals(vacina, that.vacina);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(crianca, vacina);
    }
    
}

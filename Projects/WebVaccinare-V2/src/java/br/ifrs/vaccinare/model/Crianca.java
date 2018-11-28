package br.ifrs.vaccinare.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(
    name="crianca",
    uniqueConstraints={@UniqueConstraint(columnNames="nome")}
)
public class Crianca implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable=false, length=100) 
    private String nome;
    @Column(nullable=false,precision=3) 
    private int idade;
    @Column(nullable=false, length=1) 
    private String sexo;
    @Column(nullable=false) 
    private boolean  parto;
    @Column(nullable=false, length=1) 
    private String etnia;
    @Column(name="nome_mae",nullable=false, length=100) 
    private String mae;
    @Column(nullable=false, length=100) 
    private String email;
    @Column(nullable=false, length=20) 
    private String telefone;
    
    @OneToMany(mappedBy = "crianca", cascade = CascadeType.ALL, orphanRemoval = true    )
    private List<CriancaVacina> criancaVacinas = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public boolean isParto() {
        return parto;
    }

    public void setParto(boolean parto) {
        this.parto = parto;
    }

    public String getEtnia() {
        return etnia;
    }

    public void setEtnia(String etnia) {
        this.etnia = etnia;
    }

    public String getMae() {
        return mae;
    }

    public void setMae(String mae) {
        this.mae = mae;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<CriancaVacina> getCriancaVacinas() {
        return criancaVacinas;
    }

    public void setCriancaVacinas(List<CriancaVacina> criancaVacinas) {
        this.criancaVacinas = criancaVacinas;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Crianca)) {
            return false;
        }
        Crianca other = (Crianca) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }    
    
}

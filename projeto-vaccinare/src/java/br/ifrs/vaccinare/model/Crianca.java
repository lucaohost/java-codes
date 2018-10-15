/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifrs.vaccinare.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author lucaxrl
 */
@Entity
public class Crianca implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, length = 100)
    private String nome;
    @Column(nullable = false, precision = 3)
    private int idade;
    @Column(nullable = false, length = 1)
    private char sexo;
    @Column(nullable = false, length = 1)
    private char etnia;
    @Column(nullable = false)
    private boolean partoNatural;
    @Column(nullable = false, length = 100)
    private String nomeMae;
    @Column(nullable = false, length = 100)
    private String email;
    @Column(nullable = false, length = 100)
    private String telefone;

    public boolean isPartoNatural() {
        return partoNatural;
    }

    public void setPartoNatural(boolean partoNatural) {
        this.partoNatural = partoNatural;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
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

    public char getEtnia() {
        return etnia;
    }

    public void setEtnia(char etnia) {
        this.etnia = etnia;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Crianca)) {
            return false;
        }
        Crianca other = (Crianca) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Crianca{" + "id=" + id + ", nome=" + nome + ", idade=" + idade + ", sexo=" + sexo + ", etnia=" + etnia + ", partoNatural=" + partoNatural + ", nomeMae=" + nomeMae + ", email=" + email + ", telefone=" + telefone + '}';
    }

}

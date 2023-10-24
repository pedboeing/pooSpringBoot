package br.edu.unicesumar.crud.model.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "ES_EDITORA")
public class Editora {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private Integer ano;

    public Editora(Long id, String nome, Integer ano) {
        this.id = id;
        this.nome = nome;
        this.ano = ano;
    }

    public Editora(){
    }

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

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }
}

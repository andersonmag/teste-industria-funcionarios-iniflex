package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Pessoa {
    private String nome;
    private LocalDate dataNascimento;

    public Pessoa(String nome, LocalDate dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public String getDataNascimentoFormatada() {
        return dataNascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
}

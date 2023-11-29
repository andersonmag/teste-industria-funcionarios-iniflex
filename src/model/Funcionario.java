package model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Funcionario extends Pessoa {
    private final String nome;
    private final LocalDate dataNascimento;
    private BigDecimal salario;
    private String funcao;

    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.salario = salario;
        this.funcao = funcao;
    }
}

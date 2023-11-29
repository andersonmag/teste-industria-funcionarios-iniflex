package model;

import util.ConversorValores;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Funcionario extends Pessoa {
    private BigDecimal salario;
    private String funcao;

    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    public void aumentarSalario(BigDecimal percentAumento) {
        if (salario == null) {
            return;
        }
        BigDecimal aumento = salario.multiply(percentAumento.divide(BigDecimal.valueOf(100)));
        this.salario = this.salario.add(aumento);
    }

    public String getSalarioFormatado() {
        return ConversorValores.converte(getSalario());
    }

    public BigDecimal getSalario() {
        if (salario == null) {
            return BigDecimal.ZERO;
        }
        return salario;
    }

    public String getFuncao() {
        return funcao;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "nome=" + getNome() +
                ", dataNascimento=" + getDataNascimentoFormatada() +
                ", salario=" + getSalarioFormatado() +
                ", funcao='" + funcao + '\'' +
                '}';
    }
}

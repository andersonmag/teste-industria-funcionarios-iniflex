package model;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;

public class Funcionario extends Pessoa {
    private BigDecimal salario;
    private String funcao;

    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    public BigDecimal getSalario() {
        if (salario == null) {
            return BigDecimal.ZERO;
        }
        return salario;
    }

    private String getSalarioFormatado() {
        DecimalFormat decimalFormat = new DecimalFormat("###,###,##0.00");
        return decimalFormat.format(getSalario());
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

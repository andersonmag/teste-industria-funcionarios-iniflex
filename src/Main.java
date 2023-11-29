import model.Funcionario;
import service.FuncionarioService;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        var funcionarioService = new FuncionarioService();

        funcionarioService.addFuncionario(new Funcionario("Maria", LocalDate.parse("2000-10-18"), BigDecimal.valueOf(2009.44), "Operador"));
        funcionarioService.addFuncionario(new Funcionario("João", LocalDate.parse("1990-05-12"), BigDecimal.valueOf(2284.38), "Operador"));
        funcionarioService.addFuncionario(new Funcionario("Caio", LocalDate.parse("1961-05-02"), BigDecimal.valueOf(9836.14), "Coordenador"));
        funcionarioService.addFuncionario(new Funcionario("Miguel", LocalDate.parse("1988-10-14"), BigDecimal.valueOf(19119.88), "Diretor"));
        funcionarioService.addFuncionario(new Funcionario("Alice", LocalDate.parse("1995-01-05"), BigDecimal.valueOf(2234.68), "Recepcionista"));
        funcionarioService.addFuncionario(new Funcionario("Heitor", LocalDate.parse("1999-11-19"), BigDecimal.valueOf(1582.72), "Operador"));
        funcionarioService.addFuncionario(new Funcionario("Arthur", LocalDate.parse("1993-03-31"), BigDecimal.valueOf(4071.84), "Contador"));
        funcionarioService.addFuncionario(new Funcionario("Laura", LocalDate.parse("1994-07-08"), BigDecimal.valueOf(3017.45), "Gerente"));
        funcionarioService.addFuncionario(new Funcionario("Heloísa", LocalDate.parse("2003-05-24"), BigDecimal.valueOf(1606.85), "Eletricista"));
        funcionarioService.addFuncionario(new Funcionario("Helena", LocalDate.parse("1996-09-02"), BigDecimal.valueOf(2799.93), "Gerente"));





    }
}
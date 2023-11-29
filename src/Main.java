import model.Funcionario;
import model.Pessoa;
import service.FuncionarioService;
import util.ConversorValores;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        var funcionarioService = new FuncionarioService();

        // adicionando funcionarios com base em lista passada
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
        System.out.println();

        // removendo joão
        var nomeRemover = "João";
        funcionarioService.removeFuncionario(nomeRemover);

        // listando funcionarios
        funcionarioService.exibirFuncionarios();

        List<Funcionario> funcionarios = funcionarioService.getFuncionarios();

        //aumentar em 10% o salario dos funcionarios
        var percentAumento = BigDecimal.valueOf(10);
        funcionarios.forEach(funcionario -> funcionario.aumentarSalario(percentAumento));

        // criando map de funcionarios
        Map<String, List<Funcionario>> mapFuncionariosFuncao =
            funcionarios.stream().collect(Collectors.groupingBy(funcionario -> funcionario.getFuncao()));
        // Listar map de funcionarios
        mapFuncionariosFuncao.values().forEach(System.out::println);
        System.out.println();

        // Funcionarios que fazem aniversario mês 10 e 12
        funcionarios.stream()
                .filter(funcionario -> funcionario.getDataNascimento().getMonth().getValue() == 10
                            || funcionario.getDataNascimento().getMonth().getValue() == 12)
                .forEach(System.out::println);
        System.out.println();

        // Imprimir funcionario com maior idade
        exibirFuncionarioComMaiorIdade(funcionarios);

        // Litstar por ordem alfabetica
        funcionarios.stream()
                .sorted(Comparator.comparing(Pessoa::getNome))
                .forEach(System.out::println);
        System.out.println();

        // Total salario funcionarios
        var totalSalarioFuncionarios = funcionarios.stream()
                .map(funcionario -> funcionario.getSalario()).reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("Total salários funcionarios: " + ConversorValores.converte(totalSalarioFuncionarios) + "\n");

        // Quantidade de salarios minimos de cada funcionario
        var salarioMinimo = BigDecimal.valueOf(1212.00);
        System.out.println("Salário mínimo atual: " + ConversorValores.converte(salarioMinimo));
        funcionarios.forEach(funcionario -> System.out.println(funcionario.getNome() + " - " + funcionario.getSalarioFormatado() + " - "
                                + funcionario.getSalario().divide(salarioMinimo, RoundingMode.DOWN).intValue() + " salário(s) mínimo(s)!"));
    }

    private static void exibirFuncionarioComMaiorIdade(List<Funcionario> funcionarios) {
        Funcionario funcionarioMaiorIdade = null;
        long maiorIdade = 0;

        for (Funcionario funcionario : funcionarios) {
            LocalDate dataNascimento = funcionario.getDataNascimento();
            LocalDate dataHoje = LocalDate.now();

            long anos = dataNascimento.datesUntil(dataHoje, Period.ofYears(1))
                            .filter(aniversario -> !aniversario.equals(dataNascimento)).count();

            boolean fazendoAniversarioHoje = (dataNascimento.getMonth().equals(dataHoje.getMonth()) && dataNascimento.getDayOfMonth() == dataHoje.getDayOfMonth());
            if(fazendoAniversarioHoje) ++anos;

            if(anos > maiorIdade) {
                funcionarioMaiorIdade = funcionario;
                maiorIdade = anos;
            }
        }

        System.out.println("Maior idade: " + funcionarioMaiorIdade.getNome() + " - " + maiorIdade + " anos \n");
    }
}
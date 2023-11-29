package service;

import model.Funcionario;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioService {

    private List<Funcionario> funcionarios = new ArrayList<>();

    public void addFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void removeFuncionario(String nomeRemover) {
        boolean removeu = funcionarios.removeIf(func -> func.getNome().equals(nomeRemover));

        if(removeu) {
          System.out.println(nomeRemover + " foi removido! \n");
        } else {
            System.out.println("Nenhum funcionário encontrado com nome " + nomeRemover + "\n");
        }
    }

    public void listaFuncionarios() {
        funcionarios.forEach(System.out::println);
    }
}

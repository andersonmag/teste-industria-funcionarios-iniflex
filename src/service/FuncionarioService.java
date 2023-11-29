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
}

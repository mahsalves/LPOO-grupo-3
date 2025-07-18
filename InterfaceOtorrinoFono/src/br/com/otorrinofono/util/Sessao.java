package br.com.otorrinofono.util;

import br.com.otorrinofono.entities.Funcionario;

public class Sessao {
    private static Funcionario funcionarioLogado;

    public static Funcionario getFuncionarioLogado() {
        return funcionarioLogado;
    }

    public static void setFuncionarioLogado(Funcionario funcionario) {
        funcionarioLogado = funcionario;
    }

    public static void limparSessao() {
        funcionarioLogado = null;
    }
}
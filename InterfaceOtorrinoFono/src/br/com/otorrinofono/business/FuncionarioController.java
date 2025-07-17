package br.com.otorrinofono.business;

import br.com.otorrinofono.data.FuncionarioRepository;
import br.com.otorrinofono.entities.Funcionario;
import br.com.otorrinofono.exception.BusinessException;
import br.com.otorrinofono.exception.SystemException;

public class FuncionarioController {
	public void cadastrarFuncionario(Funcionario funcionario, String confirmacaoSenha) throws BusinessException, SystemException {
        
        if (funcionario.getCpf() == null || funcionario.getCpf().isBlank()) {
            throw new BusinessException("CPF não pode ser vazio");
        }

        if (funcionario.getNome() == null || funcionario.getNome().isBlank()) {
            throw new BusinessException("Nome completo é obrigatório");
        }

        if (funcionario.getSenha() == null || funcionario.getSenha().isBlank()) {
            throw new BusinessException("Senha não pode ser vazia");
        }

        if (funcionario.getSenha().length() < 5) {
            throw new BusinessException("A senha precisa ter ao menos 5 caracteres");
        }

        if (!funcionario.getSenha().equals(confirmacaoSenha)) {
            throw new BusinessException("Senha e confirmação não conferem");
        }

        FuncionarioRepository repository = new FuncionarioRepository();

        if (repository.existsCpf(funcionario.getCpf())) {
            throw new BusinessException("Já existe um funcionário com esse CPF");
        }

        repository.salvar(funcionario);
    }
	
}
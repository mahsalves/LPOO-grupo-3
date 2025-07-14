package br.com.otorrinofono.business;

import br.com.otorrinofono.entities.Paciente;
import br.com.otorrinofono.exception.BusinessException;
import br.com.otorrinofono.exception.SystemException;
import br.com.otorrinofono.data.PacienteRepository;

import java.util.List;
import java.util.regex.Pattern;

public class PacienteController {
	private PacienteRepository repository;

    public PacienteController() {
        this.repository = new PacienteRepository();
    }

    public void cadastrarPaciente(Paciente paciente) throws BusinessException, SystemException {
        if (paciente.getNome() == null || paciente.getNome().trim().isEmpty()) {
            throw new BusinessException("O nome completo é obrigatório.");
        }

        if (paciente.getDataNascimento() == null) {
            throw new BusinessException("A data de nascimento é obrigatória.");
        }

        if (paciente.getCpf() == null || paciente.getCpf().trim().isEmpty()) {
            throw new BusinessException("O CPF é obrigatório.");
        }
        if (!validarCpf(paciente.getCpf())) {
            throw new BusinessException("CPF inválido.");
        }

        if (paciente.getGenero() == null || paciente.getGenero().trim().isEmpty()) {
            throw new BusinessException("O gênero é obrigatório.");
        }

        if (paciente.getEstado() == null || paciente.getEstado().trim().isEmpty()) {
            throw new BusinessException("O estado é obrigatório.");
        }

        if (paciente.getNumeroProntuario() == null || paciente.getNumeroProntuario().trim().isEmpty()) {
            throw new BusinessException("O número de prontuário é obrigatório.");
        }

        if (paciente.getEmail() != null && !paciente.getEmail().trim().isEmpty()) {
            if (!validarEmail(paciente.getEmail())) {
                throw new BusinessException("E-mail inválido.");
            }
        }

        if (paciente.getTelefone() != null && !paciente.getTelefone().trim().isEmpty()) {
            if (!validarTelefone(paciente.getTelefone())) {
                throw new BusinessException("Telefone inválido.");
            }
        }

        if (paciente.getCep() != null && !paciente.getCep().trim().isEmpty()) {
            
            String cepLimpo = paciente.getCep().replaceAll("\\D", "");
            if (cepLimpo.length() != 8) {
                throw new BusinessException("CEP inválido. Deve conter 8 dígitos.");
            }
        }
        
        if (repository.existePorCpf(paciente.getCpf())) {
            throw new BusinessException("Já existe um paciente cadastrado com este CPF.");
        }
        
        try {
            repository.salvar(paciente);
        } catch (Exception e) {
            throw new SystemException("Erro ao salvar paciente: " + e.getMessage(), e);
        }
    }


    public void atualizarPaciente(Paciente paciente) throws BusinessException, SystemException {
        if (paciente.getCpf() == null || paciente.getCpf().trim().isEmpty()) {
            throw new BusinessException("CPF é obrigatório para atualização.");
        }

        if (!validarCpf(paciente.getCpf())) {
            throw new BusinessException("CPF inválido.");
        }

        if (!repository.existePorCpf(paciente.getCpf())) {
            throw new BusinessException("Paciente não encontrado para atualização.");
        }

        if (paciente.getNome() == null || paciente.getNome().trim().isEmpty()) {
            throw new BusinessException("O nome completo é obrigatório.");
        }

        if (paciente.getDataNascimento() == null) {
            throw new BusinessException("A data de nascimento é obrigatória.");
        }

        if (paciente.getGenero() == null || paciente.getGenero().trim().isEmpty()) {
            throw new BusinessException("O gênero é obrigatório.");
        }

        if (paciente.getEstado() == null || paciente.getEstado().trim().isEmpty()) {
            throw new BusinessException("O estado é obrigatório.");
        }

        if (paciente.getNumeroProntuario() == null || paciente.getNumeroProntuario().trim().isEmpty()) {
            throw new BusinessException("O número de prontuário é obrigatório.");
        }

        if (paciente.getEmail() != null && !paciente.getEmail().trim().isEmpty()) {
            if (!validarEmail(paciente.getEmail())) {
                throw new BusinessException("E-mail inválido.");
            }
        }

        if (paciente.getTelefone() != null && !paciente.getTelefone().trim().isEmpty()) {
            if (!validarTelefone(paciente.getTelefone())) {
                throw new BusinessException("Telefone inválido.");
            }
        }

        if (paciente.getCep() != null && !paciente.getCep().trim().isEmpty()) {
            String cepLimpo = paciente.getCep().replaceAll("\\D", "");
            if (cepLimpo.length() != 8) {
                throw new BusinessException("CEP inválido. Deve conter 8 dígitos.");
            }
        }

        try {
            repository.atualizar(paciente);
        } catch (Exception e) {
            throw new SystemException("Erro ao atualizar paciente: " + e.getMessage(), e);
        }
    }
    
    public List<Paciente> listarPacientes() throws SystemException {
    try {
        return repository.listarTodos();
    } catch (Exception e) {
        throw new SystemException("Erro ao listar pacientes: " + e.getMessage(), e);
    }
}

public Paciente buscarPorCpf(String cpf) throws SystemException {
    try {
        return repository.buscarPorCpf(cpf);
    } catch (Exception e) {
        throw new SystemException("Erro ao buscar paciente por CPF: " + e.getMessage(), e);
    }
}

public void removerPaciente(String cpf) throws BusinessException, SystemException {
    if (cpf == null || cpf.trim().isEmpty()) {
        throw new BusinessException("CPF é obrigatório para remoção.");
    }
    try {
        repository.removerPorCpf(cpf);
    } catch (Exception e) {
        throw new SystemException("Erro ao remover paciente: " + e.getMessage(), e);
    }
}

private boolean validarCpf(String cpf) {
    String cpfLimpo = cpf.replaceAll("\\D", "");
    if (cpfLimpo.length() != 11) {
        return false;
    }
    return true;
}

private boolean validarEmail(String email) {
    String regex = "^[\\w\\.-]+@[\\w\\.-]+\\.\\w{2,}$";
    return Pattern.matches(regex, email);
}

private boolean validarTelefone(String telefone) {
    String regex = "^\\(?\\d{2}\\)?\\s?\\d{4,5}-?\\d{4}$";
    return Pattern.matches(regex, telefone);
}
}
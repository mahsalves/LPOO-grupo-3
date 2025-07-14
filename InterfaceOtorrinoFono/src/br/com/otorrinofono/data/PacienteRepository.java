package br.com.otorrinofono.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import br.com.otorrinofono.entities.Paciente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PacienteRepository {
	private List<Paciente> pacientes = new ArrayList<>();

    public void salvar(Paciente paciente) {
        pacientes.add(paciente);
    }

    public List<Paciente> listarTodos() {
        return new ArrayList<>(pacientes);
    }

    public boolean existePorCpf(String cpf) {
        return pacientes.stream()
                .anyMatch(p -> p.getCpf().equals(cpf));
    }

    public Paciente buscarPorCpf(String cpf) {
        Optional<Paciente> paciente = pacientes.stream()
                .filter(p -> p.getCpf().equals(cpf))
                .findFirst();
        return paciente.orElse(null);
    }

    public void removerPorCpf(String cpf) {
        pacientes.removeIf(p -> p.getCpf().equals(cpf));
    }
}

package br.com.otorrinofono.business;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import br.com.otorrinofono.entities.Consulta;
import br.com.otorrinofono.data.ConsultaRepository;
import br.com.otorrinofono.exception.BusinessException;
import br.com.otorrinofono.exception.SystemException; 

public class ConsultaController {
	 private ConsultaRepository consultaRepository;

	    public ConsultaController() {
	        this.consultaRepository = new ConsultaRepository();
	    }

	    public void salvarOuAtualizarConsulta(Consulta consulta) throws BusinessException, SystemException {
	        
	        if (consulta == null) {
	            throw new BusinessException("Consulta não pode ser nula.");
	        }
	        if (consulta.getPacienteId() <= 0) {
	            throw new BusinessException("ID do paciente é obrigatório e deve ser maior que zero.");
	        }
	        if (consulta.getDataConsulta() == null) {
	            throw new BusinessException("A data da consulta é obrigatória.");
	        }
	        
	        if (consulta.getDataConsulta().isAfter(LocalDate.now())) {
	            throw new BusinessException("A data da consulta não pode ser no futuro.");
	        }
	        if (consulta.getAnamnese() == null || consulta.getAnamnese().trim().isEmpty()) {
	            throw new BusinessException("Anamnese é um campo obrigatório.");
	        }
	        

	        try {
	            consultaRepository.salvar(consulta);
	        } catch (SystemException e) {
	            throw new SystemException("Erro no banco de dados ao salvar/atualizar consulta: " + e.getMessage(), e);
	        } 
	    }

	    /**
	     * Busca uma consulta pelo ID.
	     * @param id O ID da consulta a ser buscada.
	     * @return O objeto Consulta encontrado ou null.
	     * @throws SystemException Se ocorrer um erro no sistema (BD).
	     */
	    public Consulta buscarConsultaPorId(int id) throws SystemException {
	        if (id <= 0) {
	            throw new BusinessException("ID da consulta inválido.");
	        }
	        try {
	            return consultaRepository.buscarPorId(id);
	        } catch (SystemException e) {
	            throw new SystemException("Erro no banco de dados ao buscar consulta por ID: " + e.getMessage(), e);
	        } catch (Exception e) {
	            throw new SystemException("Erro inesperado ao buscar consulta por ID: " + e.getMessage(), e);
	        }
	    }
	    
	    public List<Consulta> buscarConsultasPorNomeOuCpf(String termoBusca) throws SystemException {
	        if (termoBusca == null || termoBusca.trim().isEmpty()) {
	            throw new BusinessException("O campo de busca está vazio.");
	        }

	        return consultaRepository.buscarConsultasPorNomeOuCpf(termoBusca);
	    }

	    /**
	     * Deleta uma consulta pelo ID.
	     * @param id O ID da consulta a ser deletada.
	     * @return true se a consulta foi deletada, false caso contrário.
	     * @throws BusinessException Se o ID for inválido.
	     * @throws SystemException Se ocorrer um erro no sistema (BD).
	     */
	    public boolean deletarConsulta(int id) throws BusinessException, SystemException {
	        if (id <= 0) {
	            throw new BusinessException("ID da consulta inválido para exclusão.");
	        }
	        try {
	            return consultaRepository.deletar(id);
	        } catch (SystemException e) {
	            throw new SystemException("Erro no banco de dados ao deletar consulta: " + e.getMessage(), e);
	        } catch (Exception e) {
	            throw new SystemException("Erro inesperado ao deletar consulta: " + e.getMessage(), e);
	        }
	    }

	   
	    public List<Consulta> listarTodasConsultas() throws SystemException {
	        try {
	            return consultaRepository.listarTodasConsultas();
	        } catch (SystemException e) {
	            throw new SystemException("Erro no banco de dados ao listar todas as consultas: " + e.getMessage(), e);
	        } catch (Exception e) {
	            throw new SystemException("Erro inesperado ao listar todas as consultas: " + e.getMessage(), e);
	        }
	    }

	    /**
	     * Lista consultas de um paciente específico.
	     * @param pacienteId O ID do paciente.
	     * @return Uma lista de consultas do paciente.
	     * @throws BusinessException Se o ID do paciente for inválido.
	     * @throws SystemException Se ocorrer um erro no sistema (BD).
	     */
	    public List<Consulta> listarConsultasPorPaciente(int pacienteId) throws BusinessException, SystemException {
	        if (pacienteId <= 0) {
	            throw new BusinessException("ID do paciente inválido para listar consultas.");
	        }
	        try {
	            return consultaRepository.listarConsultasPorPaciente(pacienteId);
	        } catch (SystemException e) {
	            throw new SystemException("Erro no banco de dados ao listar consultas por paciente: " + e.getMessage(), e);
	        } catch (Exception e) {
	            throw new SystemException("Erro inesperado ao listar consultas por paciente: " + e.getMessage(), e);
	        }
	    }
	}
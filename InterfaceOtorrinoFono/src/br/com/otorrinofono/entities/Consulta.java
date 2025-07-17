package br.com.otorrinofono.entities;

import java.time.LocalDate;

public class Consulta {
	private int id;
    private String pacienteCpf;
    private LocalDate dataConsulta; 

    private String anamnese;
    private String avaliacaoVocal;
    private String diagnostico;
    private String conduta;
    private String observacoes;
    private byte[] anexarExames;

    
    public Consulta() {
        this.id = 0;
    }

    
    public Consulta(int id, String pacienteCpf, LocalDate dataConsulta, String anamnese, String avaliacaoVocal, String diagnostico, String conduta, String observacoes, byte[] anexarExames) {
        this.id = id;
        this.pacienteCpf = pacienteCpf;
        this.dataConsulta = dataConsulta;
        this.anamnese = anamnese;
        this.avaliacaoVocal = avaliacaoVocal;
        this.diagnostico = diagnostico;
        this.conduta = conduta;
        this.observacoes = observacoes;
        this.anexarExames = anexarExames;
    }

    public Consulta(String pacienteCpf, LocalDate dataConsulta, String anamnese, String avaliacaoVocal, String diagnostico, String conduta, String observacoes, byte[] anexarExames) {
        this(0, pacienteCpf, dataConsulta, anamnese, avaliacaoVocal, diagnostico, conduta, observacoes, anexarExames);
    }

    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getPacienteCpf() { return pacienteCpf; }
    public void setPacienteCpf(String pacienteCpf) { this.pacienteCpf = pacienteCpf; }

    public LocalDate getDataConsulta() { return dataConsulta; }
    public void setDataConsulta(LocalDate dataConsulta) { this.dataConsulta = dataConsulta; }

    public String getAnamnese() { return anamnese; }
    public void setAnamnese(String anamnese) { this.anamnese = anamnese; }

    public String getAvaliacaoVocal() { return avaliacaoVocal; }
    public void setAvaliacaoVocal(String avaliacaoVocal) { this.avaliacaoVocal = avaliacaoVocal; }

    public String getDiagnostico() { return diagnostico; }
    public void setDiagnostico(String diagnostico) { this.diagnostico = diagnostico; }

    public String getConduta() { return conduta; }
    public void setConduta(String conduta) { this.conduta = conduta; }

    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }

    public byte[] getAnexarExames() { return anexarExames; }
    public void setAnexarExames(byte[] anexarExames) { this.anexarExames = anexarExames; }

    @Override
    public String toString() {
        return "Consulta [ID=" + id + ", Paciente CPF=" + pacienteCpf + ", Data=" + dataConsulta + "]";
    }
}

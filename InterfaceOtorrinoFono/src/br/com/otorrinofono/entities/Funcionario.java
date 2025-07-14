package br.com.otorrinofono.entities;

import java.time.LocalDate;

public class Funcionario {
	private int id;
	private String cpf;
    private String nome;
    private String email;
    private String senha;
    private LocalDate dataNascimento;
    private String genero;
    private String funcao;
    private String crmCrf;
    private String telefone;
    private boolean administrador;

    public Funcionario() {
    	this.id = 0;
    }

    public Funcionario(String cpf, String nome, String email, String senha, LocalDate dataNascimento, String genero, String funcao, String crmCrf, String telefone, boolean administrador) {
    	//this.id = id;
    	this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
        this.funcao = funcao;
        this.crmCrf = crmCrf;
        this.telefone = telefone;
        this.administrador = administrador;
        
    }
    
    
    
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public LocalDate getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public String getFuncao() { return funcao; }
    public void setFuncao(String funcao) { this.funcao = funcao; }

    public String getCrmCrf() { return crmCrf; }
    public void setCrmCrf(String crmCrf) { this.crmCrf = crmCrf; }
    
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public boolean isAdministrador() { return administrador; }
    public void setAdministrador(boolean administrador) { this.administrador = administrador; }
    
    @Override
    public String toString() {
        return "Funcionario [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", crmCrf=" + crmCrf + "]";
    }
}
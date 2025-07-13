package br.com.otorrinofono.entities;

public class Funcionario {
	private String cpf;
    private String nome;
    private String email;
    private String senha;
    private String dataNasc;
    private String genero;
    private String funcao;
    private String numRegistro;
    private boolean administrador;

    public Funcionario() {}

    public Funcionario(String cpf, String nome, String email, String senha, String dataNasc, String genero, String funcao, String numRegistro, boolean administrador) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dataNasc = dataNasc;
        this.genero = genero;
        this.funcao = funcao;
        this.numRegistro = numRegistro;
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

    public String getDataNasc() { return dataNasc; }
    public void setDataNasc(String dataNasc) { this.dataNasc = dataNasc; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public String getFuncao() { return funcao; }
    public void setFuncao(String funcao) { this.funcao = funcao; }

    public String getNumRegistro() { return numRegistro; }
    public void setNumRegistro(String numRegistro) { this.numRegistro = numRegistro; }

    public boolean isAdministrador() { return administrador; }
    public void setAdministrador(boolean administrador) { this.administrador = administrador; }
}
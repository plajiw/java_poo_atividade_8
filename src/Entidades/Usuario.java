package Entidades;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private String cpf;
    private ArrayList<ContaBancaria> contasBancarias = new ArrayList<>();

    public Usuario(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public List<ContaBancaria> getContasBancarias() {
        return new ArrayList<>(contasBancarias);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    void adicionarConta(ContaBancaria conta) {
        this.contasBancarias.add(conta);
    }

    void removerConta(ContaBancaria conta) {
        this.contasBancarias.remove(conta);
    }

    @Override
    public String toString() {
        return "Nome: " + nome +"\nCPF: " + cpf;
    }
}
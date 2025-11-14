package Entidades;

import Enums.TipoDaConta;

import java.util.ArrayList;
import java.util.List;

public class ContaBancaria {
    private String numeroDaConta;
    private double saldo;
    private Usuario usuarioDaConta;
    private TipoDaConta tipoDaConta;
    private List<String> historicoTransacoes = new ArrayList<>();

    ContaBancaria(String numeroDaConta, Usuario usuarioDaConta, TipoDaConta tipoDaConta) {
        this.numeroDaConta = numeroDaConta;
        this.usuarioDaConta = usuarioDaConta;
        this.saldo = 0.0;
        this.tipoDaConta = tipoDaConta;
        registrarTransacao("Conta " + tipoDaConta.getTipoDaConta() + " com saldo inicial de R$ 0,00", 0);
    }

    public String getNumeroDaConta() {
        return numeroDaConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public Usuario getUsuarioDaConta() {
        return usuarioDaConta;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            registrarTransacao("Depósito", valor);
            System.out.println("Depósito de R$ " + valor + " realizado na conta " + numeroDaConta);
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    public boolean sacar(double valor) {
        if (valor > 0 && valor <= this.saldo) {
            this.saldo -= valor;
            registrarTransacao("Saque", -valor); // Armazena como negativo
            System.out.println("Saque de R$ " + valor + " realizado na conta " + numeroDaConta);
            return true;
        } else {
            System.out.println("Saque não realizado. Saldo insuficiente ou valor inválido.");
            return false;
        }
    }

    public void exibirExtrato() {
        System.out.println("Extrato da Conta " + this.numeroDaConta);
        System.out.println("Dono: " + this.usuarioDaConta.getNome() + " (CPF: " + this.usuarioDaConta.getCpf() + ")");

        for (String registro : historicoTransacoes) {
            System.out.println(registro);
        }

        System.out.println("Saldo Atual: R$ " + String.format("%.2f", this.saldo));
    }

    private void registrarTransacao(String tipo, double valor) {
        String registro;
        if (tipo.equals("Saque") || tipo.equals("Depósito")) {
            registro = tipo + ": R$ " + String.format("%.2f",(valor));
        } else {
            registro = tipo;
        }
        this.historicoTransacoes.add(registro);
    }

    @Override
    public String toString() {
        return "Número da conta: " + numeroDaConta
                + "\nSaldo: R$" + String.format("%.2f",(saldo))
                + "\nDono: " + usuarioDaConta;
    }
}
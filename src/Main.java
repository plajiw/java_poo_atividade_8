import Entidades.Banco;
import Entidades.ContaBancaria;

public class Main {

    public static void main(String[] args) {
        Banco bancoEmMemoria = new Banco();

        System.out.println("\nCENÁRIO 1");
        bancoEmMemoria.criarNovoUsuario("Ana Silva", "111.111.111-11");
        ContaBancaria c1 = bancoEmMemoria.criarContaCorrente("111.111.111-11");
        bancoEmMemoria.realizarDeposito(c1.getNumeroDaConta(), 1000.00);
        bancoEmMemoria.realizarSaque(c1.getNumeroDaConta(), 200.00);

        bancoEmMemoria.criarNovoUsuario("Bruno Costa", "222.222.222-22");
        ContaBancaria c2 = bancoEmMemoria.criarContaPoupanca("222.222.222-22");
        bancoEmMemoria.realizarDeposito(c2.getNumeroDaConta(), 500.00);
        bancoEmMemoria.realizarSaque(c2.getNumeroDaConta(), 50.00);

        System.out.println("\nCENÁRIO 2");
        bancoEmMemoria.criarNovoUsuario("Carla Dias", "333.333.333-33");
        ContaBancaria c3_1 = bancoEmMemoria.criarContaCorrente("333.333.333-33");
        ContaBancaria c3_2 = bancoEmMemoria.criarContaPoupanca("333.333.333-33");
        bancoEmMemoria.realizarDeposito(c3_1.getNumeroDaConta(), 1500.00);
        bancoEmMemoria.realizarDeposito(c3_2.getNumeroDaConta(), 3000.00);
        bancoEmMemoria.realizarSaque(c3_1.getNumeroDaConta(), 100.00);

        bancoEmMemoria.criarNovoUsuario("Daniel Moreira", "444.444.444-44");
        ContaBancaria c4_1 = bancoEmMemoria.criarContaCorrente("444.444.444-44");
        ContaBancaria c4_2 = bancoEmMemoria.criarContaEmpresarial("444.444.444-44");
        bancoEmMemoria.realizarDeposito(c4_1.getNumeroDaConta(), 800.00);
        bancoEmMemoria.realizarDeposito(c4_2.getNumeroDaConta(), 10000.00);
        bancoEmMemoria.realizarSaque(c4_2.getNumeroDaConta(), 5000.00);

        System.out.println("\nCENÁRIO 3");
        bancoEmMemoria.criarNovoUsuario("Eduarda Fernandes", "555.555.555-55");
        ContaBancaria c5_1 = bancoEmMemoria.criarContaCorrente("555.555.555-55");
        ContaBancaria c5_2 = bancoEmMemoria.criarContaPoupanca("555.555.555-55");
        ContaBancaria c5_3 = bancoEmMemoria.criarContaEmpresarial("555.555.555-55");
        bancoEmMemoria.realizarDeposito(c5_1.getNumeroDaConta(), 100.00);
        bancoEmMemoria.realizarSaque(c5_1.getNumeroDaConta(), 10.00);
        bancoEmMemoria.realizarDeposito(c5_2.getNumeroDaConta(), 200.00);
        bancoEmMemoria.realizarSaque(c5_2.getNumeroDaConta(), 20.00);
        bancoEmMemoria.realizarDeposito(c5_3.getNumeroDaConta(), 300.00);
        bancoEmMemoria.realizarSaque(c5_3.getNumeroDaConta(), 30.00);

        bancoEmMemoria.consultarExtrato(c1.getNumeroDaConta());

        bancoEmMemoria.consultarExtrato(c5_3.getNumeroDaConta());
    }
}
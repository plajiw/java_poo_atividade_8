package Entidades;

import Enums.TipoDaConta;
import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Usuario> usuarios = new ArrayList<>();
    private List<ContaBancaria> contas = new ArrayList<>();
    private int proximoNumeroConta = 2025001;

    public Usuario criarNovoUsuario(String nome, String cpf) {
        if (buscarUsuarioPorCpf(cpf) != null) {
            System.out.println("Erro: CPF " + cpf + " já cadastrado.");
            return null;
        }
        Usuario novoUsuario = new Usuario(nome, cpf);
        this.usuarios.add(novoUsuario);
        System.out.println("Cliente " + nome + " criado com sucesso.");
        return novoUsuario;
    }

    public Usuario buscarUsuarioPorCpf(String cpf) {
        for (Usuario usuario : usuarios) {
            if (usuario.getCpf().equals(cpf)) {
                return usuario;
            }
        }
        return null;
    }

    public boolean atualizarUsuario(String cpf, String novoNome) {
        Usuario usuario = buscarUsuarioPorCpf(cpf);
        if (usuario != null) {
            usuario.setNome(novoNome);
            System.out.println("Nome do cliente " + cpf + " atualizado para " + novoNome);
            return true;
        }
        return false;
    }

    public boolean deletarUsuario(String cpf) {
        Usuario usuario = buscarUsuarioPorCpf(cpf);
        if (usuario == null) {
            System.out.println("Erro: Usuário " + cpf + " não encontrado.");
            return false;
        }

        List<ContaBancaria> contasParaRemover = new ArrayList<>(usuario.getContasBancarias());
        for (ContaBancaria conta : contasParaRemover) {
            deletarConta(conta.getNumeroDaConta());
        }

        this.usuarios.remove(usuario);
        System.out.println("Usuário " + usuario.getNome() + " e suas contas foram removidos.");
        return true;
    }

    private ContaBancaria criarNovaConta(String cpfDono, TipoDaConta tipo) {
        Usuario dono = buscarUsuarioPorCpf(cpfDono);
        if (dono == null) {
            System.out.println("Erro: Usuário " + cpfDono + " não encontrado.");
            return null;
        }

        String numeroConta = String.valueOf(proximoNumeroConta++);
        ContaBancaria novaConta = new ContaBancaria(numeroConta, dono, tipo);

        this.contas.add(novaConta);
        dono.adicionarConta(novaConta);

        System.out.println("Conta " + tipo.getTipoDaConta() + " (" + numeroConta + ") criada para " + dono.getNome());
        return novaConta;
    }

    public ContaBancaria criarContaCorrente(String cpfDono) {
        return criarNovaConta(cpfDono, TipoDaConta.CORRENTE);
    }

    public ContaBancaria criarContaPoupanca(String cpfDono) {
        return criarNovaConta(cpfDono, TipoDaConta.POUPANCA);
    }

    public ContaBancaria criarContaEmpresarial(String cpfDono) {
        return criarNovaConta(cpfDono, TipoDaConta.EMPRESARIAL);
    }

    public boolean deletarConta(String numeroConta) {
        ContaBancaria conta = buscarContaPorNumero(numeroConta);
        if (conta == null) {
            System.out.println("Erro: Conta " + numeroConta + " não encontrada.");
            return false;
        }

        conta.getUsuarioDaConta().removerConta(conta);
        this.contas.remove(conta);
        System.out.println("Conta " + numeroConta + " removida.");
        return true;
    }

    public ContaBancaria buscarContaPorNumero(String numero) {
        for (ContaBancaria c : contas) {
            if (c.getNumeroDaConta().equals(numero)) {
                return c;
            }
        }
        return null;
    }

    public void realizarDeposito(String numeroConta, double valor) {
        ContaBancaria conta = buscarContaPorNumero(numeroConta);
        if (conta != null) {
            conta.depositar(valor);
        } else {
            System.out.println("Erro: Conta " + numeroConta + " não encontrada.");
        }
    }

    public void realizarSaque(String numeroConta, double valor) {
        ContaBancaria conta = buscarContaPorNumero(numeroConta);
        if (conta != null) {
            conta.sacar(valor);
        } else {
            System.out.println("Erro: Conta " + numeroConta + " não encontrada.");
        }
    }

    public void consultarExtrato(String numeroConta) {
        ContaBancaria conta = buscarContaPorNumero(numeroConta);
        if (conta != null) {
            conta.exibirExtrato();
        } else {
            System.out.println("Erro: Conta " + numeroConta + " não encontrada.");
        }
    }
}
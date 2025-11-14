package Enums;

public enum TipoDaConta {
    POUPANCA("Polpança"),
    CORRENTE("Corrente"),
    EMPRESARIAL("Empresarial");

    private String tipoDaConta;

    TipoDaConta(String tipoDaConta ) {
        this.tipoDaConta = tipoDaConta;
    }

    public String getTipoDaConta() {
        return tipoDaConta;
    }
}

package com.mycompany.tp1_arthurguardieiro_carlosmoraes_rodrigomartins;

/**
 *
 * @author MASTER
 */
public abstract class Pessoa {

    private String cpf;
    private String nomeCompleto;
    private int idade;
    private String email;

    protected Pessoa(String cpf, String nomeCompleto, int idade, String email) {
        this.cpf = cpf;
        this.nomeCompleto = nomeCompleto.toLowerCase();
        this.idade = idade;
        this.email = email;
    }
    
    protected String getNomeCompleto() {
        return nomeCompleto;
    }

    protected String getCpf() {
        return cpf;
    }


    public abstract void exibirDados();

    @Override
    public String toString() {
        return String.format("Nome: %s. CPF: %s. Idade: %d. E-Mail: %s.", nomeCompleto, cpf, idade, email);
    }

}

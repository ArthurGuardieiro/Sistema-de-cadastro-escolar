package com.mycompany.tp1_arthurguardieiro_carlosmoraes_rodrigomartins;

import java.util.Scanner;

public class Aluno extends Pessoa {

    private String turno;
    private float notaTotal;

    public Aluno(String turno, float notaTotal, String cpf, String nomeCompleto, int idade, String email) {
        super(cpf, nomeCompleto, idade, email);
        this.turno = turno;
        this.notaTotal = notaTotal;
    }

    public static boolean cadastraAluno(Aluno a[], int alunosCadastrados, Professor p[], int professoresCadastrados) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o cpf do aluno: ");
        String cpf = sc.nextLine();
        for (int i = 0; i < alunosCadastrados; i++) {
            if (a[i].getCpf().equals(cpf)) {
                System.out.println("Ja existe um aluno cadastrado com esse CPF.");
                return false;
            }
        }
        for (int i = 0; i < professoresCadastrados; i++) {
            if (p[i].getCpf().equals(cpf)) {
                System.out.println("Ja existe um professor cadastrado com esse CPF.");
                return false;
            }
        }

        System.out.println("Digite o nome completo do aluno: ");
        String nomeCompleto = sc.nextLine();
        System.out.println("Digite a idade do aluno: ");
        int idade = sc.nextInt();
        System.out.println("Digite o email do aluno: ");
        sc.nextLine();
        String email = sc.nextLine();
        System.out.println("Digite o turno do aluno: ");
        String turno = sc.nextLine();
        turno = turno.toLowerCase();
        while(!"manha".equals(turno) && !"tarde".equals(turno) && !"noite".equals(turno)){
            System.out.println("Turno invalido, digite manha, tarde ou noite: ");
            turno = sc.nextLine();
            turno = turno.toLowerCase();
        }
        System.out.println("Digite a nota total do aluno(de 0 a 100): ");
        float nota = sc.nextFloat();
        while (nota < 0 || nota > 100) {
            System.out.println("Nota invalida, digite um valor de 0 a 100: \n");
            nota = sc.nextFloat();
        }
        a[alunosCadastrados] = new Aluno(turno, nota, cpf, nomeCompleto, idade, email);
        return true;
    }

    public boolean passouDeAno() {
        return notaTotal >= 60;
    }

    @Override
    public void exibirDados() {
        System.out.printf("%s Turno: %s. Nota Total: %.2f. \n", this.toString(), turno, notaTotal);
    }

    public static int procuraAluno(Aluno alunos[], int qtdAlunos, String nome) {
        nome = nome.toLowerCase();
        for (int i = 0; i < qtdAlunos; i++) {
            if (alunos[i].getNomeCompleto().equals(nome)) {
                return i;
            }
        }
        return -1;
    }

    public static boolean excluirAluno(Aluno alunos[], int qtdAlunos, String nome) {
        nome = nome.toLowerCase();
        for (int i = 0; i < qtdAlunos; i++) {
            if (alunos[i].getNomeCompleto().equals(nome)) {
                alunos[i] = alunos[qtdAlunos];
                qtdAlunos--;
                return true;
            } else {
                System.out.println("Aluno não encontrado");
            }
        }
        return false;
    }
    
    public String getTurno(){
        return turno;
    }

}

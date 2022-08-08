package com.mycompany.tp1_arthurguardieiro_carlosmoraes_rodrigomartins;

import java.util.Scanner;

public class Professor extends Pessoa {

    private double salario;
    private int horasAula;

    public Professor(double salario, int horasAula, String cpf, String nomeCompleto, int idade, String email) {
        super(cpf, nomeCompleto, idade, email);
        this.salario = salario;
        this.horasAula = horasAula;
    }
    
    public double getSalario() {
        return salario;
    }

    public int getHorasAula() {
        return horasAula;
    }


    @Override
    public void exibirDados() {
        System.out.printf("%s Salario: %.2f. Horas Aula: %d. \n", this.toString(), salario, horasAula);
    }

    public static boolean cadastrarProfessor(Professor profs[], int profsCadastrados, Aluno als[], int alunosCadastrados) {
        System.out.println("Digite as informaçoes para o cadastro do professor: ");
        Scanner s = new Scanner(System.in);

        System.out.println("CPF: ");
        String cpf = s.nextLine();
        for (int i = 0; i < profsCadastrados; i++) {
            if (profs[i].getCpf().equalsIgnoreCase(cpf)) {
                System.out.println("Ja existe um professor cadastrado com esse CPF.");
                return false;
            }
        }
        for (int i = 0; i < alunosCadastrados; i++) {
            if (als[i].getCpf().equalsIgnoreCase(cpf)) {
                System.out.println("Ja existe um aluno cadastrado com esse CPF.");
                return false;
            }
        }
        System.out.println("Nome: ");
        String nome = s.nextLine();
        System.out.println("Email: ");
        String email = s.nextLine();

        System.out.println("Idade: ");
        int idade = s.nextInt();
        while (idade < 18 || idade >= 65) {
            System.out.println("Idade invalida, digite um valor entre 18 e 65: ");
            idade = s.nextInt();
        }
        System.out.println("Salario: ");
        double salario = s.nextDouble();
        while (salario < 0) {
            System.out.println("Salario invalido, digite um valor positivo: ");
            salario = s.nextDouble();
        }
        System.out.println("Horas Aula: ");
        int horasAula = s.nextInt();
        while (horasAula <= 0 || horasAula >= 80) {
            System.out.println("Numero de horas aula invalido, digite um valor entre 1 e 60: ");
            horasAula = s.nextInt();
        }
        Professor novoProfessor = new Professor(salario, horasAula, cpf, nome, idade, email);
        profs[profsCadastrados] = novoProfessor;
        return true;
    }
    public static int procuraProfessor(Professor professores[], int qtdProfessores, String nome) {
        nome = nome.toLowerCase();
        for (int i = 0; i < qtdProfessores; i++) {
            if (professores[i].getNomeCompleto().equals(nome)) {
                return i;
            }
        }
        return -1;
    }

    public static int[]relatorioHorasAula(Professor profs[], int qtdProfs, int valorAlvo) {
        int resultado[] = new int[qtdProfs];
        int j = 0;
        for (int i = 0; i < qtdProfs; i++) {
            if (profs[i].horasAula <= valorAlvo) {
                resultado[j++] = i;
            }
        }
        return resultado;
    }

	public double calculaSalarioTotal() {
		double total = horasAula * salario;  
		return (total + (total * 0.08));        
    }

}

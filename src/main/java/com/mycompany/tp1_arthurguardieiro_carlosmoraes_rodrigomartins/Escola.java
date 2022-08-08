package com.mycompany.tp1_arthurguardieiro_carlosmoraes_rodrigomartins;

import java.util.Scanner;

public class Escola {

    Scanner sc = new Scanner(System.in);

    private Aluno[] alunos;
    private int alunosCadastrados;
    private Professor[] professores;
    private int profsCadastrados;

    public Escola(int numAlunos, int numProfessores) {
        alunos = new Aluno[numAlunos];
        professores = new Professor[numProfessores];
	}
	
    private void adicionarExemplos() {
        alunos[0] = new Aluno("Manha", 80, "888.999.000-11", "Al Um", 17, "aluno@g.com");
        alunos[1] = new Aluno("Tarde", 55, "888.999.000-11", "Al Dois", 17, "aluno@g.com");
        alunos[2] = new Aluno("Manha", 60, "888.999.000-11", "Al Tres", 17, "aluno@g.com");
        alunosCadastrados = 3;
        professores[0] = new Professor(18.5, 160, "777.888.999-00", "P Um", 25, "prof1@g.com");
        professores[1] = new Professor(20.1, 14, "777.888.999-00", "P Dois", 50, "prof2@g.com");
        professores[2] = new Professor(19.5, 82, "777.888.999-00", "P Tres", 30, "prof3@g.com");
        profsCadastrados = 3;    
	}

    void cadastrarAluno() {
        if (alunosCadastrados == alunos.length) {
            System.out.println("O sistema ja chegou no numero maximo de cadastros.");
        } else {
            boolean cadastroValido = Aluno.cadastraAluno(alunos, alunosCadastrados, professores, profsCadastrados);
            if (cadastroValido) {
                alunosCadastrados++;
            }
        }
    }

    void cadastrarProfessor() {
        if (profsCadastrados == alunos.length) {
            System.out.println("O sistema ja chegou no numero máximo de cadastros.");
        } else {
            boolean cadastroValido = Professor.cadastrarProfessor(professores, profsCadastrados, alunos, alunosCadastrados);
            if (cadastroValido) {
                profsCadastrados++;
            }
        }
    }

    void exibirProfessores() {
        if (profsCadastrados == 0) {
            System.out.println("Não existe nenhum professor cadastrado.");
        } else {
            for (int i = 0; i < profsCadastrados; i++) {
                professores[i].exibirDados();
            }
        }
    }

    void consultarAluno() {
        if (alunosCadastrados == 0) {
            System.out.println("Nenhum aluno cadastrado para consulta");
            return;
        }
        System.out.println("Digite o nome completo do aluno para consultar: ");
        String nome = sc.nextLine();
        int indiceEncontrado = Aluno.procuraAluno(alunos, alunosCadastrados, nome);
        if (indiceEncontrado != -1) {
            alunos[indiceEncontrado].exibirDados();
        } else {
            System.out.println("Aluno não encontrado");
        }
    }

    void consultarProfessor() {
        if (profsCadastrados == 0) {
            System.out.println("Nenhum professor cadastrado para consulta");
            return;
        }
        System.out.println("Digite o nome completo do professor para consultar: ");
        String nome = sc.nextLine();
        int indiceEncontrado = Professor.procuraProfessor(professores, profsCadastrados, nome);
        if (indiceEncontrado != -1) {
            professores[indiceEncontrado].exibirDados();
        } else {
            System.out.println("Professor não encontrodado!");
        }
    }

    void excluirProfessor() {
        if (profsCadastrados == 0) {
            System.out.println("Nenhum professor foi cadastrado.");
        } else {
            System.out.println("Digite o nome do professor desejado para exclusão: ");
            String nome = sc.nextLine();
            int indiceEncontrado = Professor.procuraProfessor(professores, profsCadastrados, nome);
            if (indiceEncontrado != -1) {
                professores[indiceEncontrado] = null;
                professores[indiceEncontrado] = professores[profsCadastrados - 1];
                profsCadastrados--;
                System.out.println("Professor excluído do sistema");
            } else {
                System.out.println("Professor não encontrado.");
            }
        }
    }

    void excluirAluno() {
        if (alunosCadastrados == 0) {
            System.out.println("Nenhum aluno foi cadastrado.");
        } else {
            System.out.println("Digite o nome do aluno desejado para exclusão: ");
            String nome = sc.nextLine();
            int indiceEncontrado = Aluno.procuraAluno(alunos, alunosCadastrados, nome);
            if (indiceEncontrado != -1) {
                alunos[indiceEncontrado] = null;
                alunos[indiceEncontrado] = alunos[alunosCadastrados - 1];
                alunosCadastrados--;
                System.out.println("Aluno excluído do sistema");
            } else {
                System.out.println("Aluno não encontrado.");
            }
        }
    }

    void consultaHorasAula() {
		if (profsCadastrados == 0) {
            System.out.println("Nenhum professor cadastrado para consulta");
            return;
        }
        System.out.println("Digite um valor de horas aula para exibir todos os professores até esse valor: ");
        int horas = sc.nextInt();
		while (horas <= 0)
		{
			System.out.println("Digite um valor maior que zero: ");
			horas = sc.nextInt();
		}
        int[] encontrados = Professor.relatorioHorasAula(professores, profsCadastrados, horas);
		StringBuilder res = new StringBuilder();
		for	(int i = 0; i < encontrados.length; i++) 
		{
			if (encontrados[i] != -1)
			{
				res.append(String.format("\nNome: %s. Horas aula: %d. ", professores[i].getNomeCompleto(), professores[i].getHorasAula()));
			}
		}
        if (res.length() == 0) 
		{
            System.out.println("Não foi encontrado nenhum professor");
        } else 
		{
			System.out.println("Foram encontrados os seguintes professores: "+ res);            
		}
        sc.nextLine();
    }

    void alunosTurno() {
        if (alunosCadastrados == 0) {
            System.out.println("Nenhum aluno foi cadastrado.");
            return;
        }
        System.out.println("Digite o turno: \n");
        String turno = sc.nextLine();
        turno = turno.toLowerCase();
        while (!"manha".equals(turno) && !"tarde".equals(turno) && !"noite".equals(turno)) {
            System.out.println("Digite o turno(manha, tarde ou noite): \n");
            turno = sc.nextLine();
            turno = turno.toLowerCase();
        }
        System.out.println("Alunos da parte da " + turno + ":");
        boolean achou = false;
        for (int i = 0; i < alunosCadastrados; i++) {
            if (alunos[i].getTurno().equals(turno)) {
                achou = true;
                System.out.println(alunos[i].getNomeCompleto() + "\n");
            }
        }
        if (!achou) {
            System.out.println("Nenhum aluno está nesse turno.");
        }
    }

    void relatorioAprovados() {
        if (alunosCadastrados == 0) {
            System.out.println("O sistema nao possui nenhum aluno para verificação.");
            return;
        }

        System.out.println("Relatório de alunos aprovados:");

        for (int i = 0; i < alunosCadastrados; i++) {
            if (alunos[i].passouDeAno()) {
                System.out.println(alunos[i].getNomeCompleto());
            }
        }
    }

    void mostrarSalario() {
        if(profsCadastrados == 0){
            System.out.println("Nenhum professor cadastrado");
            return;
        }
		System.out.println("Digite um valor mínimo de salário a ser procurado: ");
        double salario = sc.nextDouble();
        while (salario <= 0) 
		{
			System.out.println("Digite um valor acima de zero: ");
            salario = sc.nextDouble();
        }
		sc.nextLine();
		StringBuilder resultado = new StringBuilder();		
        for (int i = 0; i < profsCadastrados; i++) {
            if (salario <= professores[i].getSalario()) {
				resultado.append(String.format("\nNome: %s. Salario por hora-aula: %.2f. Salario mensal: %.2f.", professores[i].getNomeCompleto(), professores[i].getSalario(), professores[i].calculaSalarioTotal()));
            }
        }
		if (resultado.length() > 0)
		{
        	System.out.println("Professores com salario maior ou igual que "+salario+": " + resultado);			
		} else
		{
			System.out.println("Não foi encontrado nenhum professor com o salario de pelomenos " + salario + ".");
		}
    }
	

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.tp1_arthurguardieiro_carlosmoraes_rodrigomartins;

import java.util.Scanner;

public class Tp1_ArthurGuardieiro_CarlosMoraes_RodrigoMartins {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        Escola es = new Escola(5, 5);


        int opcao;

        do {
            System.out.println("""
                               
                               Menu:
                               1 - Cadastro de aluno.
                               2 - Cadastro de professor.
                               3 - Consulta de aluno por nome.
                               4 - Consulta de professor por nome.
                               5 - Excluir aluno pelo nome.
                               6 - Excluir professor pelo nome.
                               7 - Mostrar todos os alunos de determinado turno.
                               8 - Mostrar todos os alunos aprovados.
                               9 - Mostrar salario dos professores.
                               10 - Mostrar horas aula dos professores.
                               0 - Encerrar.""");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    es.cadastrarAluno();
                    break;
                case 2:
                    es.cadastrarProfessor();
                    break;
                case 3:
                    es.consultarAluno();
                    break;
                case 4:
                    es.consultarProfessor();
                    break;
                case 5:
                    es.excluirAluno();
                    break;
                case 6:
                    es.excluirProfessor();
                    break;
                case 7:
                    es.alunosTurno();
                    break;
                case 8:
                    es.relatorioAprovados();
                    break;
                case 9:
                    es.mostrarSalario();
                    break;
                case 10:
                    es.consultaHorasAula();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Essa opção não existe.");

            }
            

        } while (opcao != 0);

    }
}

package arrays;

import java.util.Scanner;

public class DesafioArray {
	
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Quantas notas voce quer informar?");
		int e1 = entrada.nextInt();
		
		double[] notasAluno = new double[e1]; 
		
		for (int i = 0; i < notasAluno.length; i++) {
			System.out.printf("Digite a nota %d: ", i+1);
			notasAluno[i] = entrada.nextDouble();
		}
		
		double soma = 0;
		
		for (double notas : notasAluno) {
			soma += notas;
		}
		
		System.out.printf("a media do aluno e: %.2f", soma/e1);
		
		entrada.close();
	}
	
	
	

}

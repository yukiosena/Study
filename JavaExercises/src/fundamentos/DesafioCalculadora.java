package fundamentos;

import java.util.Scanner;

public class DesafioCalculadora {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Digite um numero");
		int num1 = entrada.nextInt();
		
		System.out.print("Digite outro numero");
		int num2 = entrada.nextInt();
		
		System.out.print("Digite o comando");
		String comando = entrada.next();
		
		int resultado = 0;
		
		if(comando.equals("+")) {
			resultado = num1 + num2;
		} else if(comando.equals("-")) {
			resultado = num1 - num2;
		} else if(comando.equals("*")) {
			resultado = num1 * num2;
		} else if(comando.equals("/")) {
			resultado = num1 / num2;
		} else if(comando.equals("%")) {
			resultado = num1 % num2;
		}
		
		System.out.printf("%d %s %d = %d", num1,comando,num2,resultado);
		
		entrada.close();
	}
}

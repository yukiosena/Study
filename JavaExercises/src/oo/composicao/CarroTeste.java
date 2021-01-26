package oo.composicao;

public class CarroTeste {

	public static void main(String[] args) {
		
		Carro c1 = new Carro();
		System.out.println(c1.estaLigado());
		
		c1.ligar();
		System.out.println(c1.estaLigado());
		
		System.out.println(c1.motor.giros());
		
		c1.acelerear();
		c1.acelerear();
		c1.acelerear();
		c1.acelerear();

		System.out.println(c1.motor.giros());
		
		c1.frear();
		c1.frear();
		c1.frear();
		c1.frear();
		c1.frear();
		c1.frear();

		//c1.motor.fatorInjecao = -30;
		//faltou encapsulamento!!!
		
		System.out.println(c1.motor.giros());
	}
}

package classe;

public class Jantar {

	public static void main(String[] args) {
		
		Comida c1 = new Comida("Feijao", 0.223);
		Comida c2 = new Comida("Arroz", 0.300);
		
		Pessoa p = new Pessoa("Leo", 65.00);
		
		System.out.printf("O %s pesa: %.2f kg %n", p.nome, p.peso);
		
		p.comer(c2);
		
		System.out.printf("comeu %s e passou a pesar %.2f kg", c2.nomeComida, p.peso);
	}
}

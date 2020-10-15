package classe;

public class ProdutoTeste {
	
	public static void main(String[] args) {
		
		Produto p1 = new Produto("Notebook", 4356.89);
		
		var p2 = new Produto();
		p2.nome = "Caneta Azul";
		p2.preco = 12.56;
		
		Produto.desconto = 0.50;
		
		System.out.println(p1.nome);
		System.out.println(p2.nome);
		
		double valorFinal1 = p1.precoComDesconto();
		double valorFinal2 = p2.precoComDesconto(0.1);
		double mediaCarrinho = (valorFinal1 + valorFinal2) / 2;
		
		System.out.println(p1.nome + " " + valorFinal1);
		System.out.println(p2.nome + " " + valorFinal2);
		System.out.printf("Media do carrinho = R$%.2f.", mediaCarrinho);
	}
}

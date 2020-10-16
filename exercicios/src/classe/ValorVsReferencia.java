package classe;

public class ValorVsReferencia {
	
	public static void main(String[] args) {
		
		double a = 2;
		double b = a;
		
		a++;
		b--;
		
		System.out.println(a + " " + b);
		
		Data d1 = new Data(1, "Junho", 2022);
		Data d2 = d1;
		
		d1.dia = 31;
		d2.mes = "Dezembro";
		
		d1.ano = 2025;
		
		System.out.println(d1.obterData());
		System.out.println(d2.obterData());
		
		voltarDataParaValorPadrao(d1);
		
		System.out.println(d1.obterData());
		System.out.println(d2.obterData());
		
	}
	
	static void voltarDataParaValorPadrao(Data d) {
		d.dia = 1;
		d.mes = "Janeiro";
		d.ano = 1970;
	}

}

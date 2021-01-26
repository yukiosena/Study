package classe;

public class Data {
	int dia;
	String mes;
	int ano;
	
	Data() {
//		dia = 1;
//		mes = "Janeiro";
//		ano = 1970;
		this(1, "Janeiro", 1970);
	}
	
	Data(int dia, String mes, int ano) {
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}
	
	String obterData() {
		return "O dia e " + dia + " do mes de " + mes + " do ano " + ano;
	}
	
	void imprimirData() {
		System.out.println(obterData());
	}
}

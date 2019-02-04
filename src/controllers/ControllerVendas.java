package controllers;

public class ControllerVendas {
 /** recebe o valor e a quantidade de produtos e retorna o valor final*/
	public double realizaVendas(double valor, int qtn ) {
		 double valorFinal = (valor*qtn);
		 return valorFinal;
	}
}

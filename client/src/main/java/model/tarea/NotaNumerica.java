package model.tarea;

public class NotaNumerica extends Nota{
	
	private double valorNumerico;
	
	public NotaNumerica(double numero) {
		this.valorNumerico = numero;
	}
	
	public double valor() {
		return valorNumerico;
	}

	public boolean esAprobada() {
		return valorNumerico >= 6.0;
	}
	
	public String getValor() {
		return Double.toString(valorNumerico);
	}
	
}

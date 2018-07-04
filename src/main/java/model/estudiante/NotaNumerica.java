package model.estudiante;

public class NotaNumerica implements Nota{
	
	private double valorNumerico;
	
	public NotaNumerica(double numero) {
		this.valorNumerico = numero;
	}

	@Override
	public boolean esAprobada() {
		return valorNumerico >= 6.0;
	}
	
}

package ui.viewmodel;

import org.uqbar.commons.model.annotations.Observable;

@Observable
public class HomeViewModel {
	int legajo;

	public int getLegajo() {
		return legajo;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}
	
	
}

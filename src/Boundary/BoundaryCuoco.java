package Boundary;

import Controller.ControllerRicettario;

public class BoundaryCuoco {
	
	ControllerRicettario controllerRicettario;
	
	public Object[][] getRicette() {
		controllerRicettario = new ControllerRicettario();
		Object[][] ricette = controllerRicettario.getRicette();
		return ricette;
	}
	

}

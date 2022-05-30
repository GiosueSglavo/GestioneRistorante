package Boundary;


import Controller.ControllerOrdini;
import Controller.ControllerRistorante;

public class BoundaryCameriere {

    
    ControllerOrdini controllerOrdini;
    ControllerRistorante controllerRistorante;
    	
    public int creaNuovoOrdine(int identificativoTavolo, int numeroOccupanti) {
    	controllerOrdini = new ControllerOrdini();
    	return controllerOrdini.creaOrdine(identificativoTavolo, numeroOccupanti);
    }
    
    public int getNumeroTavoli() {
    	controllerRistorante = new ControllerRistorante();
    	int numeroTavoli = controllerRistorante.getNumeroTavoli();
    	return numeroTavoli;
    }
    
    public int getMaxPostiTavolo(int identificativoTavolo) {
    	controllerRistorante = new ControllerRistorante();
    	int maxPostiTavolo = controllerRistorante.getMaxPostiTavolo(identificativoTavolo);
    	return maxPostiTavolo;
    }
    
   
    
    public Object[][] getInfoOrdiniAperti(){
    	controllerOrdini = new ControllerOrdini();
    	Object[][] infoOrdiniAperti = controllerOrdini.getInfoOrdiniAperti();
    	return infoOrdiniAperti;
    }
    
    /*
    public Object[][] getPietanzeOrdine(int numeroTavolo){
    	controllerOrdini = new ControllerOrdini();
    	Object[][] infoPietanzeOrdine = controllerOrdini.getPietanzeOrdine(numeroTavolo);
    	return infoPietanzeOrdine;
    }
    */
}

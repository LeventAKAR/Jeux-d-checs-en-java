package piece;

public class Roi extends piece{
	/**Constructeur de la classe Roi */

    public Roi(char couleur){

        super('R', couleur);
    }
    // Le ROI se deplace d'une case dans toute les direction 
    // Prend 4 parametres , les coordonnees (x,y) de depart et (x,y) d'arrivee
    // Retourne True si le deplacement est valide , False sinon.
    public boolean estValide (int xDepart, int yDepart, int xArriver, int yArriver, int tour, char couleur) {
    	boolean verif = false;
    	
    	int x = xDepart - xArriver;
    	if (x < 0) {
    		x = -x; // valeur absolue
    	}
    	
    	int y = yDepart - yArriver;
    	if (y < 0) {
    		y = -y; // valeur absolue
    	}
    	
    	if(x >= 0 && x <= 1 && y >=0 && y <= 1) {
    		verif = true;
    	}
    	
    	return verif;
    		
    		
    		
    		
    	
    	
    }
    

}

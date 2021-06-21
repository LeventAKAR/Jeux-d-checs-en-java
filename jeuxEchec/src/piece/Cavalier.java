package piece;

public class Cavalier extends piece {
	
	public Cavalier(char couleur) {
		
		super('C', couleur);
	}
	
	// le CAVALIER se deplace en L ( il avance de 2 cases horizontalement puis il monte dune case verticalement )
	// Prend 4 parametres , les coordonnees (x,y) de depart et (x,y) d'arrivee
    // Retourne True si le deplacement est valide , False sinon.
    public boolean estValide (int xDepart, int yDepart, int xArriver, int yArriver, int tour, char couleur) {
    	boolean verif = false;
    	// Variable qui calcule si le deplacement est correct
    	int calcul = (xArriver-xDepart)*(xArriver-xDepart)+(yArriver-yDepart)*(yArriver-yDepart);
    	if(calcul == 5)  {
    		verif = true;
    	}
    	
    	return verif;

    }
    
	

}

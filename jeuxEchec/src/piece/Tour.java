package piece;

public class Tour extends piece {
	
	/**Constructeur de la classe Tour */

    public Tour(char couleur){

        super('T', couleur);
    }
    
    
    // la TOUR se déplace horizontalement ou verticalement 
    // Prend 4 parametres , les coordonnees (x,y) de depart et (x,y) d'arrivee
    // Retourne True si le deplacement est valide , False sinon.
    public boolean estValide (int xDepart, int yDepart, int xArriver, int yArriver, int tour, char couleur) {
    	boolean verif = false;
    	
    	//&& = et exclusif / || = ou logique
    	if((xDepart == xArriver && yDepart != yArriver) || (xDepart != xArriver && yDepart == yArriver))  {
    		verif = true;
    	}
    	
    	return verif;

    }

}

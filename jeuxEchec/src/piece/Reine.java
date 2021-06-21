package piece;

public class Reine extends piece {
	
public Reine(char couleur) {
		
		super('D', couleur);
	}
     

	//Prend 4 parametres , les coordonnees (x,y) de depart et (x,y) d'arrivee
	// Retourne True si le deplacement est valide , False sinon.
	public boolean estValide(int xDepart, int yDepart, int xArriver, int yArriver, int tour, char couleur) {
		int x = xDepart - xArriver;
		int y = yDepart - yArriver;
	
		if( (x == y) || (x == -y) 
			|| x == 0 || y == 0)
		{
			return true;
		}
		return false;
}

}
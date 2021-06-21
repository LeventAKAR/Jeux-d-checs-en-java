package piece;

public class Fou extends piece {
	
public Fou(char couleur) {
		
		super('F', couleur);
	}
     
    // le FOU se deplace en diagonale
	//Prend 4 parametres , les coordonnees (x,y) de depart et (x,y) d'arrivee
	// Retourne True si le deplacement est valide , False sinon.
	public boolean estValide(int xDepart, int yDepart, int xArriver, int yArriver, int tour, char couleur) {
		int x = xDepart + yDepart;
		int y = xArriver + yArriver;

		if( (x == y) || (x == y-2) || (x == y+2) || (x == y+4) || (x == y-4) || (x == y+6) || (x == y-6) || (x == y+8)
				|| (x == y-8) || (x == y+10) || (x == y-10)|| (x == y+12) || (x == y-12)|| (x == y+14)|| (x == y-14))
		{
			return true;
		}
		return false;
	}

}
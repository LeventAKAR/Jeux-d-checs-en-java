package piece;

import java.util.ArrayList;

public class Pion extends piece {
	private ArrayList<Integer> pieceChemin;
	
	public Pion(char couleur) {
		
		super('P', couleur);
	}
	
	
	/**
	 *  Prend 4 paramètres , les coordonnées (x,y) de départ et (x,y) d'arrivée
        Retourne True si le déplacement est valide , False sinon.
	 */
	
	public boolean estValide (int xDepart, int yDepart, int xArriver, int yArriver, int tour, char couleur) {
		boolean verif = false;
		//System.out.println("estvalide pion");
		
		int x = xDepart - xArriver;
		
    	if (x < 0) x = -x; // valeur absolue pour les pions noir
    	
    	if (tour==0 && couleur=='B') {
    		if((x >=0 && x <= 2)) {
        		verif = true;
        	}
    		return verif;
    	}
    	
    	if (tour==1 && couleur=='N') {
    		if((x >=0 && x <= 2)) {
        		verif = true;
        	}
    		return verif;
    	}
    	/*
    	if (tour != 0 && couleur=='B') {
    		if(this.plateau[xDepart-1][yDepart+1].getCouleur()=='N') {
    			verif = true;
    		}
    		return verif;
    	}
    	
    	if (tour != 0 && couleur=='B') {
    		if(this.plateau[xDepart-1][yDepart-1].getCouleur()=='N') {
    			verif = true;
    		}
    		return verif;
    	}
    	*/
    	if((x >=0 && x <= 1)) {
    		verif = true;
    	}
    	
    	return verif;
    	
    	
		/*
		int y = yDepart - yArriver;
    	if (y < 0) y = -y; // valeur absolue pour les pions noir
    	
    	if((y >=0 && y <= 1) && yDepart==yArriver) {
    		verif = true;
    	}
    	
    	return verif;
		
		*/
		}
	

	
	//Vérifie si une pièce est sur le chemin de parcours , le pion ne se déplace que d'une case donc
    // pas besoin de savoir si ya une piece sur le chemin ou pas ( car soit elle va la manger ou soit elle va pas se placer dessus
    // selon la couleur de la piece quil y a sur la case de destination.
    //prend en + le plateau contenant les pieces en paramètre
    //return true si il y a une pièce , false sinon
	
    public ArrayList<Integer> pieceChemin(int xDepart, int yDepart, int tour, char couleur) {
    	pieceChemin = new ArrayList<Integer>();
    	//System.out.println("piecechemin piece");

    	if (tour==0 && couleur=='B') {
    			//System.out.println("test calcul");
    			pieceChemin.add(xDepart-1);
    			pieceChemin.add(xDepart-2);
        	
    	}
    	
    	if (tour==1 && couleur=='N') {
    			//System.out.println("test calcul2");
    			pieceChemin.add(xDepart+1);
    			pieceChemin.add(xDepart+2);
        	
    	}
    	
    	if(tour != 1 && couleur=='N') {
    		//System.out.println("test calcul3");
    		pieceChemin.add(xDepart+1);
    	}
    	
    	if(tour != 0 && couleur=='B') {
    		//System.out.println("test calcul4");
    		pieceChemin.add(xDepart-1);
    	}
    	
    	return pieceChemin;
    	
    	
    	
    }
	

}
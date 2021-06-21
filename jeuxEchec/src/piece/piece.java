package piece;

import java.util.ArrayList;

//Création d'une classe abstraite
public class piece {
	
	/** type de la piece (pion ou fou ou roi etc...) */
    private char type;
	
	/** couleur de la piece (blanc ou noir..)  */
    private char couleur;
    private ArrayList<Integer> pieceChemins;

    protected piece[][] plateau = new piece[8][8];
    
    private ArrayList<piece>EchequierContientBlanc = new ArrayList<piece>();
    private ArrayList<piece>EchequierContientNoir = new ArrayList<piece>();
    private ArrayList<piece>EchequierCaseVide = new ArrayList<piece>();
    private ArrayList<String>EchequierString = new ArrayList<String>();
    

    /** constructeur */
    
    public piece() {
    	
    	int i = 0;
    	while (i < 8) {
    		int j = 0;
    		while (j < 8) {
    			this.plateau[i][j]= new Vide('X');
    			j++;
    		}
    		i++;	
    	}
    	//System.out.println(this.plateau.toString());
    	
		this.plateau[0][0] = new Tour('N');
		this.plateau[0][1] = new Cavalier('N');
		this.plateau[0][2] = new Fou('N');
		this.plateau[0][3] = new Reine('N');
		this.plateau[0][4] = new Roi('N');
		this.plateau[0][5] = new Fou('N');
		this.plateau[0][6] = new Cavalier('N');
		this.plateau[0][7] = new Tour('N');
		
		this.plateau[1][0] = new Pion('N');
		this.plateau[1][1] = new Pion('N');
		this.plateau[1][2] = new Pion('N');
		this.plateau[1][3] = new Pion('N');
		this.plateau[1][4] = new Pion('N');
		this.plateau[1][5] = new Pion('N');
		this.plateau[1][6] = new Pion('N');
		this.plateau[1][7] = new Pion('N');
		
		this.plateau[6][0] = new Pion('B');
		this.plateau[6][1] = new Pion('B');
		this.plateau[6][2] = new Pion('B');
		this.plateau[6][3] = new Pion('B');
		this.plateau[6][4] = new Pion('B');
		this.plateau[6][5] = new Pion('B');
		this.plateau[6][6] = new Pion('B');
		this.plateau[6][7] = new Pion('B');
		
		
		this.plateau[7][0] = new Tour('B');
		this.plateau[7][1] = new Cavalier('B');
		this.plateau[7][2] = new Fou('B');
		this.plateau[7][3] = new Reine('B');
		this.plateau[7][4] = new Roi('B');
		this.plateau[7][5] = new Fou('B');
		this.plateau[7][6] = new Cavalier('B');
		this.plateau[7][7] = new Tour('B');
		
		//return this.plateau;
	}
    
    public piece getPlateau(int i, int y) {
		return plateau[i][y];
	}
    
    public piece getPlateauI(int i) {
		return plateau[i][0];
	}
    
    public piece getPlateauY(int y) {
		return plateau[0][y];
	}
    

    public piece(char type,char couleur){
    	this.type=type;
    	this.couleur=couleur;

    }
    

//----------------------------------------------------------------------------------------------------------------------
	public void deplacement(int xDepart, int yDepart, int xArriver, int yArriver) throws IllegalArgumentException {
			piece Test = new piece();

			if (this.plateau[xDepart][yDepart].getCouleur()=='B' && this.plateau[xArriver][yArriver].getCouleur()=='N') {
					
					// piece de depart stocké dans Test
					Test=this.plateau[xDepart][yDepart];
					
					// se fait manger donc devient vide
					this.plateau[xArriver][yArriver]=new Vide('X');
					
					// arriver est remplacer par test
					this.plateau[xArriver][yArriver]=Test;
					
					// test se deplace sur arriver donc depart devien vide
					this.plateau[xDepart][yDepart]=new Vide('X');
			}
				
			else if (this.plateau[xDepart][yDepart].getCouleur()=='N' && this.plateau[xArriver][yArriver].getCouleur()=='B') {
					Test=this.plateau[xDepart][yDepart];
					this.plateau[xArriver][yArriver]=new Vide('X');
					this.plateau[xArriver][yArriver]=Test;
					this.plateau[xDepart][yDepart]=new Vide('X');
			}
			
			// deplacement dune piece sur une case vide
			else {
				Test=this.plateau[xDepart][yDepart];
				this.plateau[xDepart][yDepart]=this.plateau[xArriver][yArriver];
				this.plateau[xArriver][yArriver]=Test;
			}
			
		}

	
	
	public ArrayList<piece> contientEqB() {
		EchequierContientBlanc = new ArrayList<piece>();
		int i=0;
		
		while (i<8) {
			int j=0;
			while (j<8) {
			if (this.plateau[i][j].getCouleur()=='B') {
				EchequierContientBlanc.add(this.plateau[i][j]);
			}
			j++;
		}
		i++;	
	}
		return EchequierContientBlanc;	
	}

	
	
	public ArrayList<piece> contientEqN() {
		EchequierContientNoir = new ArrayList<piece>();
		int i=0;
		
		while (i<8) {
			int j=0;
			while (j<8) {
			if (this.plateau[i][j].getCouleur()=='N') {
				EchequierContientNoir.add(this.plateau[i][j]);
			}
			j++;
		}
		i++;	
	}
		return EchequierContientNoir;	
	}

	
	
	public ArrayList<piece> contientCaseV() {
		EchequierCaseVide = new ArrayList<piece>();
		int i=0;
		
		while (i<8) {
			int j=0;
			while (j<8) {
			if (this.plateau[i][j].getCouleur()=='X') {
				EchequierCaseVide.add(this.plateau[i][j]);
			}
			j++;
		}
		i++;	
	}
		return EchequierCaseVide;	
	}

	
	
	public ArrayList<String> EchequierString() {
		EchequierString = new ArrayList<String>();
		int i=0;
		
		while (i<8) {
			int j=0;
			while (j<8) {
			if (this.plateau[i][j].getCouleur()=='B' || this.plateau[i][j].getCouleur()=='N'|| this.plateau[i][j].getCouleur()=='X') {
				EchequierString.add(this.plateau[i][j].toString());
			}
			j++;
		}
		i++;	
	}
		return EchequierString;	
	}
	
	
    // Methode toString pour une pièce
    public String toString(){
    	String StrObjet = ""+this.type+this.couleur;
    	return StrObjet;
    }
    // getters
    public char getCouleur(){
    	return this.couleur;
    }
    
    public void setCoord(int x, int y) {
    	
    }

    public char getType(){
    	return this.type;
    }
    // setters 
    public void setCouleur(char couleur){
    	this.couleur=couleur;
    }

    public void setType(char type){
    	this.type=type;
    }

	public boolean estValide(int xDepart, int yDepart, int xArrive, int yArrive, int tour, char couleur) {
		System.out.println("estvalide piece");
		// TODO Auto-generated method stub
		return false;
	}
	
	public ArrayList<Integer> pieceChemin(int xDepart, int yDepart, int tour, char couleur) {System.out.println("piecechemin piece");return pieceChemins;}

    public boolean estVivant() {
    	System.out.println("est vivant piece pour le roi");
    	for (int i=0; i < 7 ; i++) {
    		for (int j=0; j < 7 ; j++) {
    			if (this.plateau[i][j].getType()=='R') {
    				return true;
    			}
    		}
    	}
    	return false;
    }
    




}
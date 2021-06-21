package jeux;
import java.io.File;

import jeux.*;
import java.util.*;

import java.util.InputMismatchException;
import piece.*;
// save load
import javax.swing.JFileChooser;


public class jeux {
	

	//------------------------------------------------------------------------------
	//------------------------------------------------------------------------------
	//-------- Début Charles -------------------------------------------------------
	//------------------------------------------------------------------------------


	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
	
	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
	
    public static final String BLACK_BOLD_BRIGHT = "\033[1;90m"; // BLACK
    public static final String RED_BOLD_BRIGHT = "\033[1;91m";   // RED
    public static final String GREEN_BOLD_BRIGHT = "\033[1;92m"; // GREEN
    public static final String YELLOW_BOLD_BRIGHT = "\033[1;93m";// YELLOW
    public static final String BLUE_BOLD_BRIGHT = "\033[1;94m";  // BLUE
    public static final String PURPLE_BOLD_BRIGHT = "\033[1;95m";// PURPLE
    public static final String CYAN_BOLD_BRIGHT = "\033[1;96m";  // CYAN
    public static final String WHITE_BOLD_BRIGHT = "\033[1;97m"; // WHITE
    
    public static final String BLACK_UNDERLINED = "\033[4;30m";  // BLACK
    public static final String RED_UNDERLINED = "\033[4;31m";    // RED
    public static final String GREEN_UNDERLINED = "\033[4;32m";  // GREEN
    public static final String YELLOW_UNDERLINED = "\033[4;33m"; // YELLOW
    public static final String BLUE_UNDERLINED = "\033[4;34m";   // BLUE
    public static final String PURPLE_UNDERLINED = "\033[4;35m"; // PURPLE
    public static final String CYAN_UNDERLINED = "\033[4;36m";   // CYAN
    public static final String WHITE_UNDERLINED = "\033[4;37m";  // WHITE
	
	
	public static void affichage(piece echequier) {
		
		


		//System.out.println("     |   "+ANSI_CYAN+0+ANSI_RESET+"  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |");
		String res = "     |   ";
		
		int i = 0;
		while (i < 8) {res=res+YELLOW_BOLD_BRIGHT+String.valueOf(i)+ANSI_RESET+"  |  ";i++;}
		System.out.println(res);

		res = "";
		System.out.println("------------------------------------------------------------");
		for(i = 0 ; i < 8 ; i ++) {
			int val = 7+i;
			res="  "+BLUE_BOLD_BRIGHT+i+ANSI_RESET+"  |  ";
			for(int j = 0 ; j < 8 ; j ++) {
				/*
				if (echequier.getPlateau(i,j).getType()=='T' || echequier.getPlateau(i,j).getType()=='C' ||
					echequier.getPlateau(i,j).getType()=='F' || echequier.getPlateau(i,j).getType()=='D' ||
					echequier.getPlateau(i,j).getType()=='R' || echequier.getPlateau(i,j).getType()=='P') 
				{res=res+echequier.getPlateau(i,j)+"  | ";}
				*/
				if (echequier.getPlateau(i,j).getType()!='V' && echequier.getPlateau(i,j).getCouleur()=='B') 
				{res=res+ANSI_WHITE_BACKGROUND+ANSI_BLACK+echequier.getPlateau(i,j)+ANSI_RESET+"  | ";}
				//{res=res+WHITE_UNDERLINED+echequier.getPlateau(i,j)+ANSI_RESET+"  | ";}
				
				if (echequier.getPlateau(i,j).getType()!='V' && echequier.getPlateau(i,j).getCouleur()=='N') 
				{res=res+ANSI_BLACK_BACKGROUND+ANSI_WHITE+echequier.getPlateau(i,j)+ANSI_RESET+"  | ";}
				
				if (echequier.getPlateau(i,j).getType()=='V')
				{res=res+" "+"   | ";}
				
				}
			System.out.println(res+" "+BLUE_BOLD_BRIGHT+i+ANSI_RESET);
			//System.out.println("| "+i);
			System.out.println("------------------------------------------------------------");		
				
	
		}
		
		
		res = "     |   ";
		i = 0;
		while (i < 8) {res=res+YELLOW_BOLD_BRIGHT+String.valueOf(i)+ANSI_RESET+"  |  ";i++;}
		System.out.println(res);
	}
	
	int secondesPasser = 0;
	Timer timer = new Timer();
	TimerTask temps = new TimerTask() {
		public void run() {
			secondesPasser++;
			System.out.println(secondesPasser+" secondes ce sont ecoules...");
		}
	};
	
	public void lancerChrono() {
		timer.scheduleAtFixedRate(temps,120000,120000);
	}
	//------------------------------------------------------------------------------
	//------------------------------------------------------------------------------
	//-------- Fin Charles ---------------------------------------------------------
	//------------------------------------------------------------------------------




	//------------------------------------------------------------------------------
	//------------------------------------------------------------------------------
	//-------- Début Levent --------------------------------------------------------
	//------------------------------------------------------------------------------


	public static void main(String[] args) {
		
		
		int xDepart = 0, yDepart = 0, xArrive = 0, yArrive = 0 ;
		Scanner scanner = new Scanner(System.in);
		boolean tour = true;
		int tourInt = 0;
		piece echiquier = new piece();
		String st = RED_BOLD_BRIGHT+"start"+ANSI_RESET;
		
		// scanner entrer start pour commencer une partie	
		Scanner scan = new Scanner(System.in);
		System.out.println(WHITE_BOLD_BRIGHT+"Bienvenue dans le jeu d'echecs de AKAR Levent et BATCHAEV Charles.\nLes pieces de l'echiquier sont definies par leurs initiales et de leur couleur d'equipe (TB = Tour Blanc, CN = Cavalier Noir, ...).\nLes coordonees en colonnes de couleur bleu font reference a l'axe 'X'.\nLes coordonees en lignes de couleur jaune font reference a l'axe 'Y'.\nLe joueur qui commence à jouer sera dans l'équipe blanche \r\n"
				+ "Le joueur qui joue en deuxième sera dans l'équipe noir \r\n"
				+ "Mettez-vous donc d'accord sur le tour pour le choix des équipes !"+ANSI_RESET+"\nTaper "+st+" pour commencer une partie :");
		String start = scan.nextLine();
		
		//equalsignorecase verifie si les chaines sont identique
		while (start.equalsIgnoreCase( "start" )==false) {System.out.println("Ecrivez "+st+" correctement !");start = scan.nextLine();}
		if (start.equalsIgnoreCase( "start" )==true) {

		System.out.println("\n");
		System.out.println(WHITE_BOLD_BRIGHT+"             ----- Presentation de l'echiquier -----\n"+ANSI_RESET);
		affichage(echiquier);
		//System.out.println(echiquier.contientEqN());
		//System.out.println(echiquier.contientEqB());
		
		


		while (tour == true) {
				
				boolean deplacement = false;
				boolean contient = false;
				boolean tourBlanc = false;
				boolean tourNoir = false;
				boolean testC = false;
				String choix = " ";
				int quitter = 0;
				jeux test = new jeux();
				//System.out.println(echiquier.EchequierString());
				//System.out.println("-----"+echiquier.getPlateau(xDepart, yDepart).getType());
				//test.lancerChrono();

				


				//Jeu - equipe blanche
				
				if (tourInt%2==0) {
					
					
					while (tourBlanc==false) {
					System.out.println("\n		-----  "+ANSI_WHITE_BACKGROUND+ANSI_BLACK+"Equipe BLANCHE"+ANSI_RESET+"   -----\n");
					System.out.println(PURPLE_BOLD_BRIGHT+"             	---- Jeu d'Echecs TOUR "+String.valueOf(tourInt+1)+" ----\n"+ANSI_RESET);
					//demande des coordonee du piece de depart
					//System.out.println(WHITE_BOLD_BRIGHT+"\n		SAUVER ou CHARGER ?\n 	1 - Oui\n 	2 - Non"+ANSI_RESET);
					//choix = scanner.nextInt();
					
					testC=false;
					choix=" ";
					while (testC==false) {
						System.out.println(WHITE_BOLD_BRIGHT+"\n		---- SAUVER ou CHARGER ? ----\n - Oui\n - Non"+ANSI_RESET);
						choix = scanner.next();
						if (choix.equalsIgnoreCase("Oui")==true || choix.equalsIgnoreCase("Non")==true) {
							testC=true;
						}
					}
					if (choix.equalsIgnoreCase("Oui")==true) {
						System.out.println(WHITE_BOLD_BRIGHT+"\n	---- Ouverture de l'interface de choix... ----"+ANSI_RESET);
						// creation fenetre de sauvegarde
						new Save();
					}
					
					
					testC=false;
					choix=" ";
					// proposition d'arreter de jouer au bout dun certains temps
					if (tourInt>2) {
					while (testC==false) {
						System.out.println(WHITE_BOLD_BRIGHT+"\n		---- Arreter de jouer ? ----\n - Oui\n - Non"+ANSI_RESET);
						choix = scanner.next();
						if (choix.equalsIgnoreCase("Oui")==true) {
							System.out.println(PURPLE_BOLD_BRIGHT+"Au revoir"+ANSI_RESET);
							quitter=1;
							testC=true;
							// boucle du programme
							tour=false;
						}
						else if (choix.equalsIgnoreCase("Non")==true) {
							testC=true;
						}
					}
					}
					
					//Bloc saisi coordonnées départ
					System.out.println(BLUE_BOLD_BRIGHT+"\n		----- Saisissez xDepart -----"+ANSI_RESET);
					xDepart = scanner.nextInt();
					System.out.println(YELLOW_BOLD_BRIGHT+"\n		----- Saisissez yDepart -----"+ANSI_RESET);
					yDepart = scanner.nextInt();
					contient = false;
					while (contient==false) {
						// verification dans lechiquier si l'array contient la piece à lorigine
						if ((echiquier.contientEqB().contains(echiquier.getPlateau(xDepart, yDepart)))==false ) {
						System.out.println(RED_BOLD_BRIGHT+"		----- Ce n'est pas votre piece ! Entrez la position d'une piece de VOTRE equipe ! -----");
						System.out.println(BLUE_BOLD_BRIGHT+"\n		----- Saisissez xDepart -----"+ANSI_RESET);
						xDepart = scanner.nextInt();
						System.out.println(YELLOW_BOLD_BRIGHT+"\n		----- Saisissez yDepart -----"+ANSI_RESET);
						yDepart = scanner.nextInt();
						}
						
						if ((echiquier.contientEqB().contains(echiquier.getPlateau(xDepart, yDepart)))==true) {
							contient=true;}
					}
					
					//Bloc saisi coordonnées darriver
					System.out.println(BLUE_BOLD_BRIGHT+"\n		----- Saisissez xArrive -----"+ANSI_RESET);
					xArrive = scanner.nextInt();
					System.out.println(YELLOW_BOLD_BRIGHT+"\n		----- Saisissez yArrive -----"+ANSI_RESET);
					yArrive = scanner.nextInt();
					contient = false;
					while (contient==false) {
						if (echiquier.contientEqB().contains(echiquier.getPlateau(xArrive, yArrive))==true) {
						System.out.println("		----- Il y a deja une piece de VOTRE equipe ! -----"+ANSI_RESET);
						System.out.println(BLUE_BOLD_BRIGHT+"\n		----- Saisissez xArrive -----"+ANSI_RESET);
						xDepart = scanner.nextInt();
						System.out.println(YELLOW_BOLD_BRIGHT+"\n		----- Saisissez yArrive -----"+ANSI_RESET);
						yDepart = scanner.nextInt();
						}
						
						if (echiquier.contientEqB().contains(echiquier.getPlateau(xArrive, yArrive))==false) { 
							{if (echiquier.contientCaseV().contains(echiquier.getPlateau(xArrive, yArrive))==true) 
							{contient=true;}
							else {
								contient=true;
							}
							}
					}
						}
					

					
						// Verification validité (deplacement) de la piece selectionner
						if(echiquier.getPlateau(xDepart, yDepart).estValide(xDepart, yDepart, xArrive, yArrive, tourInt, 'B')==true) {
							//System.out.println("avant deplacement");
							
							echiquier.deplacement(xDepart, yDepart, xArrive, yArrive);
							
							//deplacement tourblanc effectué
							tourBlanc=true;
						}
						else {System.out.println(RED_BOLD_BRIGHT+"\nVous n'etes pas autorise a aller la-bas...\nSaisissez a nouveau des donnees (correctes)\n"+ANSI_RESET);}

					    // methode dans piece , vérifie si roi vivant ou non
						if ((echiquier.estVivant())==false) {System.out.println(GREEN_BOLD_BRIGHT+"Merci, au revoir..."+ANSI_RESET);tour=false;}
						
						
						
					affichage(echiquier);
				}
				}
				
				if (quitter==1) {tour=false;}
//------------------------------------------------------------------------------------------------------------------------------------------				

				//Jeu - Equipe noire
				if (tourInt%2!=0) {
					
					while (tourNoir==false) {
						System.out.println("\n		-----  "+ANSI_BLACK_BACKGROUND+ANSI_WHITE+"Equipe NOIRE"+ANSI_RESET+"   -----\n");
					System.out.println(PURPLE_BOLD_BRIGHT+"             	---- Jeu d'Echecs TOUR "+String.valueOf(tourInt+1)+" ----\n"+ANSI_RESET);
					//demande des coordonee du piece de depart
					//System.out.println(WHITE_BOLD_BRIGHT+"		SAUVER ou CHARGER ?\n 1 - Oui\n 2 - Non"+ANSI_RESET);
					//choix = scanner.nextInt();
					testC=false;
					choix=" ";
					while (testC==false) {
						System.out.println(WHITE_BOLD_BRIGHT+"\n		---- SAUVER ou CHARGER ? ----\n - Oui\n - Non"+ANSI_RESET);
						choix = scanner.next();
						if (choix.equalsIgnoreCase("Oui")==true || choix.equalsIgnoreCase("Non")==true) {
							testC=true;
						}
					}
					if (choix.equalsIgnoreCase("Oui")==true) {
						System.out.println(WHITE_BOLD_BRIGHT+"\n	---- Ouverture de l'interface de choix... ----"+ANSI_RESET);
						new Save();
					}
					
					
					testC=false;
					choix="";
					if (tourInt>2) {
					while (testC==false) {
						System.out.println(WHITE_BOLD_BRIGHT+"\n		---- Arreter de jouer ? ----\n - Oui\n - Non"+ANSI_RESET);
						choix = scanner.next();
						if (choix.equalsIgnoreCase("Oui")==true) {
							System.out.println(PURPLE_BOLD_BRIGHT+"Au revoir"+ANSI_RESET);
							tour=false;
							testC=true;
						}
						else if (choix.equalsIgnoreCase("Non")==true) {
							testC=true;
						}
					}
					}
					
					System.out.println(BLUE_BOLD_BRIGHT+"\n		----- Saisissez xDepart -----"+ANSI_RESET);
					xDepart = scanner.nextInt();
					System.out.println(YELLOW_BOLD_BRIGHT+"\n		----- Saisissez yDepart -----"+ANSI_RESET);
					yDepart = scanner.nextInt();
					contient = false;
					while (contient==false) {
						if (echiquier.contientEqN().contains(echiquier.getPlateau(xDepart, yDepart))==false) {
						System.out.println(RED_BOLD_BRIGHT+"		----- Entrez la position d'une piece de VOTRE equipe ! -----"+ANSI_RESET);
						System.out.println(BLUE_BOLD_BRIGHT+"\n		----- Saisissez xDepart -----"+ANSI_RESET);
						xDepart = scanner.nextInt();
						System.out.println(YELLOW_BOLD_BRIGHT+"\n		----- Saisissez yDepart -----"+ANSI_RESET);
						yDepart = scanner.nextInt();
						}
						if (echiquier.contientEqN().contains(echiquier.getPlateau(xDepart, yDepart))==true) 
						{contient=true;}
						
					}
					
					//demande des coordonee du piece de arrive
					System.out.println(BLUE_BOLD_BRIGHT+"\n		----- Saisissez xArrive -----"+ANSI_RESET);
					xArrive = scanner.nextInt();
					System.out.println(YELLOW_BOLD_BRIGHT+"\n		----- Saisissez yArrive -----"+ANSI_RESET);
					yArrive = scanner.nextInt();
					contient = false;
					while (contient==false) {
						//System.out.println(echiquier.EchequierString());
						//System.out.println(echiquier.contientEqN());
						if (echiquier.contientEqN().contains(echiquier.getPlateau(xArrive, yArrive))==true) {
						System.out.println(RED_BOLD_BRIGHT+"		----- Il y a deja une piece de VOTRE equipe ! -----"+ANSI_RESET);
						System.out.println(BLUE_BOLD_BRIGHT+"\n		----- Saisissez xArrive -----"+ANSI_RESET);
						xDepart = scanner.nextInt();
						System.out.println(YELLOW_BOLD_BRIGHT+"\n		----- Saisissez yArrive -----"+ANSI_RESET);
						yDepart = scanner.nextInt();}	
						
						if (echiquier.contientEqN().contains(echiquier.getPlateau(xArrive, yArrive))==false) 
						{contient=true;}
						
						if ((echiquier.contientCaseV().contains(echiquier.getPlateau(xArrive, yArrive)))==true){contient=true;}
								
					}
					
					//echiquier+deplacement
					//System.out.println("             ----- Jeu d'Echecs TOUR "+String.valueOf(tourInt+1)+" -----\n");
					
					
					
						
						if(echiquier.getPlateau(xDepart, yDepart).estValide(xDepart, yDepart, xArrive, yArrive, tourInt, 'N')==true) {
							//System.out.println("avant deplacement");
							echiquier.deplacement(xDepart, yDepart, xArrive, yArrive);
							//System.out.println("apres deplacement");
							//deplacement=true;
							tourNoir=true;
						}
						else {System.out.println(RED_BOLD_BRIGHT+"\nVous n'etes pas autorise a aller la-bas...\nSaisissez a nouveau des donnees (correctes)\n"+ANSI_RESET);}

						
						if ((echiquier.estVivant())==false) {System.out.println(GREEN_BOLD_BRIGHT+"Merci, au revoir..."+ANSI_RESET);tour=false;}
					
					
					affichage(echiquier);


				
				}
				}
				if (quitter==1) {tour=false;}
				
				tourInt++;
			
			
		}
		
		
	}


	}
}


	//------------------------------------------------------------------------------
	//------------------------------------------------------------------------------
	//-------- Fin Levent ----------------------------------------------------------
	//------------------------------------------------------------------------------
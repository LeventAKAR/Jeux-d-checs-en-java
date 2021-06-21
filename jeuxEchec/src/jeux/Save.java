package jeux;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import piece.*;



public class Save extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	static final int SAVE = 1;
	static final int LOAD = 2;
	private JButton sauver;
	private JButton loader;
	private String[] listt;
 	
	public static final String ANSI_RESET = "\u001B[0m";
    public static final String BLACK_BOLD_BRIGHT = "\033[1;90m"; // BLACK
    public static final String RED_BOLD_BRIGHT = "\033[1;91m";   // RED
    public static final String GREEN_BOLD_BRIGHT = "\033[1;92m"; // GREEN
    public static final String YELLOW_BOLD_BRIGHT = "\033[1;93m";// YELLOW
    public static final String BLUE_BOLD_BRIGHT = "\033[1;94m";  // BLUE
    public static final String PURPLE_BOLD_BRIGHT = "\033[1;95m";// PURPLE
    public static final String CYAN_BOLD_BRIGHT = "\033[1;96m";  // CYAN
    public static final String WHITE_BOLD_BRIGHT = "\033[1;97m"; // WHITE
    
    
	
	public Save() {
		super("Sauver ou charger une partie");
		this.Composants();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.centrer(0.4);
		this.setSize(350, 95);
		this.setVisible(true);
		this.Ecouteurs();
	}
	
	public void charger() {
		
	}
	
	private void Composants() {
		JPanel PanSaveLoad = new JPanel();
		this.add(PanSaveLoad);
		PanSaveLoad.add(addText());
		PanSaveLoad.add(addButtons());
		PanSaveLoad.setLayout(new FlowLayout());

	}
	public JPanel addButtons() {
		JPanel Pannel = new JPanel();
		
		sauver = new JButton("Sauver");
		Pannel.add(sauver);
		loader = new JButton("Charger");
		Pannel.add(loader);
		Pannel.setBorder(BorderFactory.createEtchedBorder());
		return Pannel;
	}
	public JPanel addText() {
		JPanel Pannel = new JPanel();
		
		JLabel label = new JLabel("Choisissez : ");
		label.setFont(new Font("Verdana", Font.PLAIN, 18));
		Pannel.add(label);
		return Pannel;
	}
	
	
	
	public void centrer(double d) {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int largeur = (int) (d * dim.width);
		int longueur = (int) (d * dim.height);
		this.setBounds((dim.width - largeur) / 2, (dim.height - longueur) / 2, largeur, longueur);
	}
	
	
	
	
	
	public String[] plateauFile(ArrayList<String> echeq) {
		String[] list = new String[64];
		for (int i=0; i<echeq.size(); i++) {
			list[i]=echeq.get(i);
			listt[i]=echeq.get(i);
		}
		return list;
	}
	
	public void sauver(String nomFichier) {
		try {
			BufferedWriter test = Files.newBufferedWriter(Paths.get(nomFichier));
			//test.write(this.listt);
			test.close();
			
		} catch (IOException e) {
			System.err.println(e);
		}
	}
	
	
	
	
	
	
	
	public void Ecouteurs() {
		this.loader.addActionListener(new EcouteurBoutons(LOAD));
		this.sauver.addActionListener(new EcouteurBoutons(SAVE));
	}
	
	class EcouteurBoutons implements ActionListener {
		
		private int choix;
 
		public EcouteurBoutons(int x) {
			this.choix = x;
		}
		 
		public void actionPerformed(ActionEvent e) {
			
			switch (choix) {
			case SAVE: {
				System.out.println(YELLOW_BOLD_BRIGHT+"Sauvegarder un fichier !"+ANSI_RESET);
				JFileChooser fileChoooser = new JFileChooser("./");
				fileChoooser.setDialogTitle("Où sauvegarder le fichier ?");    
				int userSelection = fileChoooser.showSaveDialog(null);
				File fileToSave = fileChoooser.getSelectedFile();
				System.out.println("Sauvegardé dans : " + fileToSave.getAbsolutePath());
				String fileToSaveString = fileToSave.toString()+".txt";
				break;
			}
			
			case LOAD: {
				System.out.println(YELLOW_BOLD_BRIGHT+"Charger un fichier !"+ANSI_RESET);
				JFileChooser FileChooser = new JFileChooser("./");
				FileChooser.setDialogTitle("Quel fichier charger ?");
				int test = FileChooser.showOpenDialog(null);
				File fileToLoad = FileChooser.getSelectedFile();
				System.out.println("Chargé depuis : " + fileToLoad.getAbsolutePath());
				String nom = fileToLoad.getPath();
				break;
			}
			
					
				
}
}
			}
	}

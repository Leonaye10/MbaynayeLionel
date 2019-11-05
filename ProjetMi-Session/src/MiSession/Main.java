package MiSession;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.CardLayout;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JScrollPane;
import java.awt.TextArea;

public class Main {

	private static final String String = null;
	private JFrame frame;
	private JTextField txtNom;
	private JTextField txtPrenom;
	private JTextField txtNAS;
	private JTextField txtSalaire;
	private JTextField txtDay;
	private JTextField txtSolde;
	private JTextField txtAge;
	private JTextField txtNbreEtud;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtMois;
	private JTextField txtYear;
	private JTextField txtChercher;
	
	
	public int nbClients = 2;
	public int select = 0;
	public int modif = 0;
	public void viderText()
	{
		txtNom.setText("");
		txtPrenom.setText("");
		txtNAS.setText("");
		txtSalaire.setText("");
		txtSolde.setText("");
		txtAge.setText("");
		txtNbreEtud.setText("");
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("unused")
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().setBackground(SystemColor.inactiveCaption);
		frame.getContentPane().setForeground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 828, 488);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Clients[] matab = new Clients[100];
		MiniBanque bank = new MiniBanque("TecBank",matab);
		CompteBancaire affairCompte = new CompteBancaire(3000);
		ClientsAffaire affaire = new ClientsAffaire("Lionel","naye","9874562",15000,LocalDate.now(),affairCompte,1,"leoCorp");
		CompteBancaire etudCompte = new CompteBancaire(5000);
		ClientsEtudiant etud = new ClientsEtudiant("kodji","kemta","98745452",25000,LocalDate.now(),etudCompte,1,2);
		matab[0] = affaire;
		matab[1] = etud;
		double tauxRistourn = 0;
		
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 57, 225, 381);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewClient = new JButton("Cr\u00E9er Client");
		
		btnNewClient.setBounds(10, 36, 205, 23);
		panel.add(btnNewClient);
		
		JButton btnModif = new JButton("Modifier Client");
		
		btnModif.setBounds(10, 70, 205, 23);
		panel.add(btnModif);
		
		JButton btnAfficherUnClient = new JButton("Afficher un client");
		
		btnAfficherUnClient.setBounds(10, 104, 205, 23);
		panel.add(btnAfficherUnClient);
		
		TextArea textArea = new TextArea();
		textArea.setBounds(289, 116, 258, 265);
		
		JButton btnFaireUnDepot = new JButton("Faire un depot");
		btnFaireUnDepot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double montant = 0.0,total = 0.0;
				int num;
				
					num = Integer.parseInt(JOptionPane.showInputDialog(null,"Veuillez entrer le numero de compte : "));
					montant = Double.parseDouble(JOptionPane.showInputDialog(null,"Veuillez entrer le montant a deposer : "));
					for(int i=0;i<nbClients;i++)
					{
						if(num==(matab[i].leCompte.getNumCompte()))
						{
							matab[i].leCompte.Depot(montant);
							JOptionPane.showMessageDialog(null, "Le solde du compte " + num + " est de : " + matab[i].leCompte.getSolde());
						}
					}
			}
		});
		
		
		btnFaireUnDepot.setBounds(10, 138, 205, 23);
		panel.add(btnFaireUnDepot);
		
		JButton btnFaireUnRetrait = new JButton("Faire un retrait");
		btnFaireUnRetrait.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double montant = 0.0,total = 0.0;
				int num;
				num = Integer.parseInt(JOptionPane.showInputDialog(null,"Veuillez entrer le numero de compte : "));
					montant = Double.parseDouble(JOptionPane.showInputDialog(null,"Veuillez entrer le montant a retirer : "));
					for(int i=0;i<nbClients;i++)
					{
						if(num==matab[i].leCompte.getNumCompte())
						{
							
							matab[i].leCompte.Retrait(montant);
							JOptionPane.showMessageDialog(null, "Le solde du compte " + num + " est de : " + matab[i].leCompte.getSolde());
						}
					}
			}
		});
		
		
		btnFaireUnRetrait.setBounds(10, 172, 205, 23);
		panel.add(btnFaireUnRetrait);
		
		JButton btnAfficherTousLes = new JButton("Afficher tous les clients");
		
		btnAfficherTousLes.setBounds(10, 206, 205, 23);
		panel.add(btnAfficherTousLes);
		
		JButton btnAfficherTotalDes = new JButton("Afficher total des salaires");
		
		btnAfficherTotalDes.setBounds(10, 240, 205, 23);
		panel.add(btnAfficherTotalDes);
		
		JButton btnCalculDeLa = new JButton("Ristourne annuelle");
		btnCalculDeLa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<nbClients;i++)
				{
					matab[i].Ristourne();
				}
				JOptionPane.showMessageDialog(null, "Ristourne annuelle des clients a bien été effectué");
				
			}
		});
		
		btnCalculDeLa.setBounds(10, 274, 205, 23);
		panel.add(btnCalculDeLa);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnQuitter.setBounds(10, 347, 205, 23);
		panel.add(btnQuitter);
		Calendar leo = Calendar.getInstance();
		Date DateEm1 = leo.getTime();
		
		JPanel panelClient = new JPanel();
		panelClient.setBounds(245, 57, 557, 381);
		frame.getContentPane().add(panelClient);
		panelClient.setLayout(null);
		panelClient.show(false);
		
		txtNom = new JTextField();
		txtNom.setBounds(167, 21, 116, 20);
		panelClient.add(txtNom);
		txtNom.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nom :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 21, 147, 17);
		panelClient.add(lblNewLabel_1);
		
		txtPrenom = new JTextField();
		txtPrenom.setColumns(10);
		txtPrenom.setBounds(167, 52, 116, 20);
		panelClient.add(txtPrenom);
		
		txtNAS = new JTextField();
		txtNAS.setColumns(10);
		txtNAS.setBounds(167, 83, 116, 20);
		panelClient.add(txtNAS);
		
		txtSalaire = new JTextField();
		txtSalaire.setColumns(10);
		txtSalaire.setBounds(167, 114, 116, 20);
		panelClient.add(txtSalaire);
		
		txtDay = new JTextField();
		txtDay.setEnabled(false);
		txtDay.setColumns(10);
		txtDay.setBounds(167, 145, 32, 20);
		panelClient.add(txtDay);
		
		txtSolde = new JTextField();
		txtSolde.setColumns(10);
		txtSolde.setBounds(167, 176, 116, 20);
		panelClient.add(txtSolde);
		
		txtAge = new JTextField();
		txtAge.setColumns(10);
		txtAge.setBounds(167, 207, 116, 20);
		panelClient.add(txtAge);
		
		txtNbreEtud = new JTextField();
		txtNbreEtud.setColumns(10);
		txtNbreEtud.setBounds(167, 238, 116, 20);
		panelClient.add(txtNbreEtud);
		
		JLabel lblPrenom = new JLabel("Prenom :");
		lblPrenom.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrenom.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblPrenom.setBounds(10, 55, 147, 17);
		panelClient.add(lblPrenom);
		
		JLabel lblNAS = new JLabel("N A S :");
		lblNAS.setHorizontalAlignment(SwingConstants.LEFT);
		lblNAS.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNAS.setBounds(10, 86, 147, 17);
		panelClient.add(lblNAS);
		
		JLabel lblSalaireAnnuelle = new JLabel("Salaire annuelle :");
		lblSalaireAnnuelle.setHorizontalAlignment(SwingConstants.LEFT);
		lblSalaireAnnuelle.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblSalaireAnnuelle.setBounds(10, 117, 147, 17);
		panelClient.add(lblSalaireAnnuelle);
		
		JLabel lblDateDinscription = new JLabel("Date d'inscription :");
		lblDateDinscription.setHorizontalAlignment(SwingConstants.LEFT);
		lblDateDinscription.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblDateDinscription.setBounds(10, 148, 147, 17);
		panelClient.add(lblDateDinscription);
		
		JLabel lblSolde = new JLabel("Solde : ");
		lblSolde.setHorizontalAlignment(SwingConstants.LEFT);
		lblSolde.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblSolde.setBounds(10, 179, 147, 17);
		panelClient.add(lblSolde);
		
		JLabel lblAge = new JLabel("Age :");
		lblAge.setHorizontalAlignment(SwingConstants.LEFT);
		lblAge.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblAge.setBounds(10, 210, 147, 17);
		panelClient.add(lblAge);
		
		JLabel lblNombreDetudeRestant = new JLabel("Nombre etude restant :");
		lblNombreDetudeRestant.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombreDetudeRestant.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNombreDetudeRestant.setBounds(10, 241, 147, 17);
		panelClient.add(lblNombreDetudeRestant);
		
		txtMois = new JTextField();
		txtMois.setEnabled(false);
		txtMois.setColumns(10);
		txtMois.setBounds(209, 145, 32, 20);
		panelClient.add(txtMois);
		
		txtYear = new JTextField();
		txtYear.setEnabled(false);
		txtYear.setColumns(10);
		txtYear.setBounds(251, 145, 32, 20);
		panelClient.add(txtYear);
		
		JRadioButton radio = new JRadioButton("Normal");
		radio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtAge.show(false);
				lblAge.show(false);
				txtNbreEtud.show(false);
				lblNombreDetudeRestant.show(false);
			}
		});
		buttonGroup.add(radio);
		radio.setBounds(17, 285, 72, 23);
		panelClient.add(radio);
		
		JRadioButton radioEtud = new JRadioButton("Etudiant");
		radioEtud.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtAge.show(true);
				lblAge.show(true);
				lblAge.setText("Age :");
				txtNbreEtud.show(true);
				lblNombreDetudeRestant.show(true);
				lblNombreDetudeRestant.setText("Nombre etude restant :");
			}
		});
		buttonGroup.add(radioEtud);
		radioEtud.setBounds(91, 285, 72, 23);
		panelClient.add(radioEtud);
		
		JRadioButton radioAffaire = new JRadioButton("Affaire");
		radioAffaire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtAge.show(true);
				lblAge.show(true);
				lblAge.setText("Type de compagnie :");
				txtNbreEtud.show(true);
				lblNombreDetudeRestant.show(true);
				lblNombreDetudeRestant.setText("Nom de compagnie :");
			}
		});
		buttonGroup.add(radioAffaire);
		radioAffaire.setBounds(167, 285, 65, 23);
		panelClient.add(radioAffaire);
		
		JButton btnNewButton = new JButton("Valider");
		
		btnNewButton.setBounds(41, 329, 116, 23);
		panelClient.add(btnNewButton);
		
		JLabel lblVotreNumeroBancaire = new JLabel("Votre numero bancaire");
		lblVotreNumeroBancaire.setBounds(373, 21, 129, 17);
		panelClient.add(lblVotreNumeroBancaire);
		
		txtChercher = new JTextField();
		txtChercher.setBounds(373, 52, 129, 20);
		panelClient.add(txtChercher);
		txtChercher.setColumns(10);
		
		JButton btnChercher = new JButton("Chercher");
		btnChercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch(select)
				{
				case 3:
					int search1 = Integer.parseInt(txtChercher.getText());
					for(int i=0;i<nbClients;i++)
					{
						if(search1 == matab[i].leCompte.getNumCompte())
						{
							String t=matab[i].toString();
							textArea.setText(String.valueOf(t));
						}
					}
					break;
				case 2:
					int search = Integer.parseInt(txtChercher.getText());
					for(int i=0;i<nbClients;i++)
					{
						if(search == matab[i].leCompte.getNumCompte())
						{
							modif = i;
							txtNom.setText(matab[i].Nom);
							txtPrenom.setText(matab[i].Prenom);
							txtNAS.setText(matab[i].NAS);
							txtSalaire.setText(""+matab[i].Salaire);
							txtSolde.setText(""+matab[i].leCompte.getSolde());
							//txtAge.setText(""+matab[i]);
							//txtNbreEtud.setText(""+matab[i]);
						}
					}
					break;
				}
			}
		});
		
		btnChercher.setBounds(373, 82, 129, 23);
		panelClient.add(btnChercher);
		
		
		panelClient.add(textArea);
		
		JLabel lblNewLabel = new JLabel("Mini Banque");
		lblNewLabel.setBounds(199, 0, 366, 51);
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setForeground(new Color(0, 0, 153));
		lblNewLabel.setLabelFor(frame);
		lblNewLabel.setBackground(SystemColor.menu);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 30));
	
		
	
		btnNewClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				select=1;
				
				panelClient.show(true);
				textArea.show(false);
				lblVotreNumeroBancaire.show(false);
				btnChercher.show(false);
				txtChercher.show(false);
				radio.show(true);
				radioEtud.show(true);
				radioAffaire.show(true);
				viderText();
			}
		});
		
		btnModif.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				select = 2;
				panelClient.show(true);
				textArea.show(false);
				lblVotreNumeroBancaire.show(true);
				btnChercher.show(true);
				txtChercher.show(true);
				radio.show(false);
				radioEtud.show(false);
				radioAffaire.show(false);
				txtAge.show(true);
				lblAge.show(true);
				txtNbreEtud.show(true);
				lblNombreDetudeRestant.show(true);
				viderText();
			}
		});
		btnAfficherUnClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				select = 3;
				panelClient.show(true);
				textArea.show(true);
				textArea.setText(null);
				lblVotreNumeroBancaire.show(true);
				btnChercher.show(true);
				txtChercher.show(true);
				radio.show(false);
				radioEtud.show(false);
				radioAffaire.show(false);
				txtAge.show(true);
				lblAge.show(true);
				txtNbreEtud.show(true);
				lblNombreDetudeRestant.show(true);
				viderText();
			}
		});
		
		btnAfficherTotalDes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				NumberFormat nf = NumberFormat.getCurrencyInstance();
				double totalSalaire = 0.0, moyenneSalaire = 0.0;
				for(int i=0;i<nbClients;i++)
				{
					totalSalaire += matab[i].getSalaire();
				}
				moyenneSalaire = totalSalaire/nbClients;
				JOptionPane.showMessageDialog(null, "Le total des salaires est : " + nf.format(totalSalaire) + "\nEt la moyenne est : " + nf.format(moyenneSalaire));
			}
		});
		
		btnAfficherTousLes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelClient.show(true);
				textArea.show(true);
				viderText();
				String t="";
				for(int i=0;i<nbClients;i++)
				{
					t+="******************\n"+matab[i].toString()+"\n";
				}
				textArea.setText(String.valueOf(t));
			}
		});
		
		
		
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("null")
			public void actionPerformed(ActionEvent arg0) {
				switch(select)
				{
				case 1:
					if(radioEtud.isSelected())
					{
						String nom = txtNom.getText();
			    	    String prenom = txtPrenom.getText();
			    	    String Nas = txtNAS.getText();
			    	    Double sal = Double.parseDouble(txtSalaire.getText());
			    	    int niveau = Integer.parseInt(txtNbreEtud.getText());
			    	    int age = Integer.parseInt(txtAge.getText());
			    	    Double solde = Double.parseDouble(txtSolde.getText());
			    	    CompteBancaire etudCompte = new CompteBancaire(solde);
						ClientsEtudiant etud1 = new ClientsEtudiant(nom,prenom,Nas,sal,LocalDate.now(),etudCompte,niveau,age);
			    	    matab[nbClients] = etud1;
			    	    nbClients++;
			    	    JOptionPane.showMessageDialog(null, "Le client etudiant a été ajouter");
			    	    viderText();
					}
					else if(radioAffaire.isSelected())
					{
						String nom = txtNom.getText();
			    	    String prenom = txtPrenom.getText();
			    	    String Nas = txtNAS.getText();
			    	    Double sal = Double.parseDouble(txtSalaire.getText().toString());
			    	    int age = Integer.parseInt(txtAge.getText().toString());
			    	    String niveau = txtNbreEtud.getText();
			    	    Double solde = Double.parseDouble(txtSolde.getText().toString());
			    	    CompteBancaire affairCompte = new CompteBancaire(solde);
						ClientsAffaire affaire1 = new ClientsAffaire(nom,prenom,Nas,sal,LocalDate.now(),affairCompte,age,niveau);
			    	    matab[nbClients] = affaire1;
			    	    nbClients++;
			    	    JOptionPane.showMessageDialog(null, "Le client affaire a été ajouter " + modif);
			    	    viderText();
					}
					else
					{
						String nom = txtNom.getText();
			    	    String prenom = txtPrenom.getText();
			    	    String Nas = txtNAS.getText();
			    	    Double sal = Double.parseDouble(txtSalaire.getText());
			    	    Double solde = Double.parseDouble(txtSolde.getText());
			    	    CompteBancaire normalCompte = new CompteBancaire(solde);
						Clients normal = new Clients(nom, prenom, Nas, sal, LocalDate.now(), normalCompte);
						/*normal ={nom, prenom, Nas, sal, LocalDate.now(), normalCompte};
						normal.ajout(nom, prenom, Nas, sal, LocalDate.now(), normalCompte);
						normal.setNom(nom);
						normal.Prenom=prenom;
						normal.NAS=Nas;
						normal.Salaire=sal;
						normal.DateInscription=LocalDate.now();
						normal.leCompte=normalCompte;*/
			    	    matab[nbClients] = normal;
			    	    nbClients++;
			    	    JOptionPane.showMessageDialog(null, "Le client a été ajouter");
			    	    viderText();
					}
					break;
				case 2:
					String nom = txtNom.getText();
		    	    String prenom = txtPrenom.getText();
		    	    String Nas = txtNAS.getText();
		    	    Double sal = Double.parseDouble(txtSalaire.getText());
		    	    //int niveau = Integer.parseInt(txtNbreEtud.getText());
		    	    //int age = Integer.parseInt(txtAge.getText());
		    	    Double solde = Double.parseDouble(txtSolde.getText());
		    	    for(int i=0;i<nbClients;i++)
		    	    {
		    	    	if(i == modif)
		    	    	{
		    	    		matab[modif].Nom = nom;
		    	    		matab[modif].Prenom=prenom;
		    	    		matab[modif].NAS=Nas;
		    	    		matab[modif].Salaire=sal;
		    	    		matab[modif].leCompte.setSolde(solde);
		    	    		JOptionPane.showMessageDialog(null, "Le client a été modifier");
		    	    	}
		    	    }
					break;
				
				}
			}
		});
		btnCalculDeLa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num;
				
				num = Integer.parseInt(JOptionPane.showInputDialog(null,"Veuillez entrer le numero de compte : "));
					for(int i=0;i<nbClients;i++)
					{
						if(num==matab[i].leCompte.getNumCompte())
						{
							//matab[i].setRistourne();
							JOptionPane.showMessageDialog(null, "Le solde du compte " + num + " est de : " + matab[i].getSalaire());
						}
					}
			}
		});
	
	}
}

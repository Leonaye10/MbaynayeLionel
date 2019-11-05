package MiSession;

import java.text.NumberFormat;
import java.util.Locale;

public class CompteBancaire {
	private static int Numero=1000;
	private double Solde;
	private int numCompte;
	
	public CompteBancaire(double vSolde)
	{ 
		this.Solde = vSolde;
		this.numCompte = CompteBancaire.Numero++;
	}
	
	/*public void construc(double vSolde)
	{
		this.Solde = vSolde;
		this.numCompte = CompteBancaire.Numero++;
	}*/
	
	public static int getNumero() {
		return Numero;
	}

	public static void setNumero(int numero) {
		Numero = numero;
	}

	public double getSolde() {
		return Solde;
	}
	public void setSolde(double solde) {
		if(solde>0)
			Solde = solde;
	}
	public int getNumCompte() {
		return numCompte;
	}
	public void setNumCompte(int numCompte) {
		this.numCompte = numCompte;
	}
	
	NumberFormat monnaie = NumberFormat.getCurrencyInstance(Locale.CANADA_FRENCH);
	public String toString()
	{
		return String.format("Numero du compte : %s\nSolde du compte : %s",this.numCompte,monnaie.format(getSolde()) );
	}
	
	public void Retrait(double montant)
	{
		if(getSolde() > montant)
		{
			this.Solde -=montant;
		}
	}
	
	public void Depot(double montant)
	{
		if(montant>0)
		{
			this.Solde +=montant;
		}
	}
}

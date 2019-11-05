package MiSession;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Locale;

public class Clients {
	protected String Nom;
	protected String Prenom;
	protected String NAS;
	protected double Salaire;
	protected LocalDate DateInscription;
	protected CompteBancaire leCompte;
	
	public Clients(String vNom,String vPrenom,String vNAS,double vSalaire,LocalDate vDateInscription,CompteBancaire vLecompte)
	{
		this.Nom = vNom;
		this.Prenom = vPrenom;
		this.NAS = vNAS;
		this.Salaire = vSalaire;
		this.DateInscription = vDateInscription;
		this.leCompte = vLecompte;
	}
	
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
	public String getNAS() {
		return NAS;
	}
	public void setNAS(String nAS) {
		NAS = nAS;
	}
	public double getSalaire() {
		return Salaire;
	}
	public void setSalaire(double salaire) {
		Salaire = salaire;
	}
	public LocalDate getDateInscription() {
		return DateInscription;
	}
	public void setDateInscription(LocalDate dateInscription) {
		DateInscription = dateInscription;
	}
	public CompteBancaire getLeCompte() {
		return leCompte;
	}
	public void setLeCompte(CompteBancaire leCompte) {
		this.leCompte = leCompte;
	}
	
	public void ajout(String vNom,String vPrenom,String vNAS,double vSalaire,LocalDate vDateInscription,CompteBancaire vLecompte)
	{
		this.Nom = vNom;
		this.Prenom = vPrenom;
		this.NAS = vNAS;
		this.Salaire = vSalaire;
		this.DateInscription = vDateInscription;
		this.leCompte = vLecompte;
	}
	
	public void Ristourne() {
	}
	
	//public abstract double earnings();
	NumberFormat monnaie = NumberFormat.getCurrencyInstance(Locale.CANADA_FRENCH);
	public String toString()
	{
		return String.format("Nom : %s\nPrenom : %s\nNAS : %s\nSalaire annuel : %s\n%s\nDate de creation : %s",
				getNom(),getPrenom(),getNAS(),monnaie.format(getSalaire()),leCompte.toString(),getDateInscription());
	}
}

package MiSession;

import java.time.LocalDate;

public class ClientsEtudiant extends Clients {
	private int NiveauScolarite;
	private int Age;
	
	public ClientsEtudiant(String vNom,String vPrenom,String vNAS,double vSalaire,LocalDate vDateInscription,CompteBancaire vLecompte,int vNiveauScolarite,int vAge)
	{
		super(vNom,vPrenom,vNAS,vSalaire,vDateInscription,vLecompte);
		this.NiveauScolarite = vNiveauScolarite;
		this.Age = vAge;
	}
	
	public int getNiveauScolarite() {
		return NiveauScolarite;
	}
	public void setNiveauScolarite(int NiveauScolarite) {
		this.NiveauScolarite = NiveauScolarite;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int Age) {
		if(Age>0)
			this.Age = Age;
	}
	
	public double earnings()
	{
		return 0;
	}
	
	public void Ristourne()
	{
		this.leCompte.setSolde(this.leCompte.getSolde()*1.5);
	}
	
	@Override
	public String toString()
	{
		return String.format("%s\nType de clients : Etudiant\nAge : %s Année d'études restantes : %s",
				super.toString(),getAge(),getNiveauScolarite());
	}
}

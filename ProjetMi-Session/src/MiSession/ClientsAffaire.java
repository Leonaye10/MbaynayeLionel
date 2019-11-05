package MiSession;

import java.time.LocalDate;

public class ClientsAffaire extends Clients{
	private int typeConmpagnie;
	private String NomCompagnie;
	
	public ClientsAffaire(String vNom,String vPrenom,String vNAS,double vSalaire,LocalDate vDateInscription,CompteBancaire vLecompte,int vtypeConmpagnie,String vNomCompagnie)
	{
		super(vNom,vPrenom,vNAS,vSalaire,vDateInscription,vLecompte);
		this.typeConmpagnie = vtypeConmpagnie;
		this.NomCompagnie = vNomCompagnie;
	}
	
	public int getTypeConmpagnie() {
		return typeConmpagnie;
	}
	public void setTypeConmpagnie(int typeConmpagnie) {
		this.typeConmpagnie = typeConmpagnie;
	}
	public String getNomCompagnie() {
		return NomCompagnie;
	}
	public void setNomCompagnie(String nomCompagnie) {
		NomCompagnie = nomCompagnie;
	}
	
	public double earnings()
	{
		return 0;
	}
	
	public void Ristourne()
	{
		if(this.typeConmpagnie==1)
		{
			this.leCompte.setSolde(this.leCompte.getSolde()*0.8);
		}
		else if(this.typeConmpagnie==2)
		{
			this.leCompte.setSolde(this.leCompte.getSolde()*0.6);
		}
		else if(this.typeConmpagnie==3)
		{
			this.leCompte.setSolde(this.leCompte.getSolde()*0.4);
		}
		
			
		
	}
	
	@Override
	public String toString()
	{
		return String.format("%s\nType de clients : Affaire\nType de compagnie : %s Nom de la compagnie : %s",
				super.toString(),getTypeConmpagnie(),getNomCompagnie());
	}
}

package MiSession;

public class MiniBanque {
	private String Nom;
	private Clients lesClients[];
	private double tauxRistourne;
	
	public MiniBanque(String vNom,Clients vLesClients[])
	{
		this.Nom = vNom;
		this.lesClients = vLesClients;
		//this.tauxRistourne = vTauxRistourne;
	}
	

	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public Clients[] getLesClients() {
		return lesClients;
	}
	public void setLesClients(Clients[] lesClients) {
		this.lesClients = lesClients;
	}
	public double getTauxRistourne() {
		return tauxRistourne;
	}
	public void setTauxRistourne(double tauxRistourne) {
		
		this.tauxRistourne = tauxRistourne;
	}
	
	public String toString()
	{
		return String.format("Nom : %s\n",getNom() );
	}
}

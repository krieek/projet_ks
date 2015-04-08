package org.istv.parametres;

public class Gain {

	double utilisateur;
	double assistant;
	
	public Gain(double utilisateur, double assistant)
	{
		this.utilisateur = utilisateur;
		this.assistant = assistant;
	}

	public double getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(double utilisateur) {
		this.utilisateur = utilisateur;
	}

	public double getAssistant() {
		return assistant;
	}

	public void setAssistant(double assistant) {
		this.assistant = assistant;
	}
	
	public double total()
	{
		return this.assistant + this.utilisateur;
	}
}

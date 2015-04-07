package org.istv.parametres;

public class Parametre1 {

	int valeur;
	int valeurMax;
	int valeurMin;
	
	public Parametre1(int valeur, int valeurMax, int valeurMin) {
		super();
		this.valeur = valeur;
		this.valeurMax = valeurMax;
		this.valeurMin = valeurMin;
	}
	public int getValeur() {
		return valeur;
	}
	public void setValeur(int valeur) {
		this.valeur = valeur;
	}
	public int getValeurMax() {
		return valeurMax;
	}
	public void setValeurMax(int valeurMax) {
		this.valeurMax = valeurMax;
	}
	public int getValeurMin() {
		return valeurMin;
	}
	public void setValeurMin(int valeurMin) {
		this.valeurMin = valeurMin;
	}
	
	public boolean verificationValeur()
	{
		if (this.valeur < this.valeurMin || this.valeur > this.valeurMax)
			return false;
		else 
			return true;
	}
	
}

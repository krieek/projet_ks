package org.istv.parametres;

public class Matrice {

	boolean calcule;
	//
	int cas;
	//assistant aide, utilisateur fait
	Gain af;
	//assistant n'aide pas, utilisateur fait
	Gain nf;
	//assistant aide, utilisateur demande
	Gain ad;
	//assistant n'aide pas, utilisteur demande
	Gain nd;
	
	
	public Matrice(Gain af, Gain nf, Gain ad, Gain nd, int cas)
	{
		this.calcule = false;
		this.cas= cas;
		this.af = af;
		this.nf = nf;
		this.ad = ad;
		this.nd = nd;
	}
	
	public Matrice(int cas)
	{
		if(cas == 1)
			noDiv();
		else if (cas == 2)
			noIrre();
		else if (cas == 3)
			pIrre();
	}
	
	public void noDiv()
	{
		if(calcule == false)
		{
		this.af = new Gain(7.5, 0);
		this.nf = new Gain(10, 10);
		this.ad = new Gain(5, 5);
		this.nd = new Gain(2.5, 2.5);
		calcule = true;
		}
		else
		{
			this.af = new Gain(2.5, 0);
			this.nf = new Gain(10, 10);
			this.ad = new Gain(5, 10);
			this.nd = new Gain(5, 2.5);
			calcule = true;
			}
	}
	
	public void noIrre()
	{
		if(calcule == false)
		{
		this.af = new Gain(5, 2.5);
		this.nf = new Gain(9, 8);
		this.ad = new Gain(7.5, 9);
		this.nd = new Gain(2.5, 1.5);
		calcule = true;
		}
		else
		{

			this.af = new Gain(5, 2.5);
			this.nf = new Gain(9, 8);
			this.ad = new Gain(7.5, 5);
			this.nd = new Gain(2.5, 1.5);
		}
	}
	
	public void pIrre()
	{
		if(calcule == false)
		{
		this.af = new Gain(7.5, 5);
		this.nf = new Gain(5, 2.5);
		this.ad = new Gain(10, 10);
		this.nd = new Gain(2.5, 0);
		calcule = true;
		}
		else
		{
			this.af = new Gain(7.5, 5);
			this.nf = new Gain(5, 2.5);
			this.ad = new Gain(10, 0);
			this.nd = new Gain(0, 0);
		}
	}
	
	
	/**
	 * Operation a effectuer selon le cas présenté
	 * @return boolean
	 * true : aide l'utilisateur 
	 * false : n'aide pas l'utilisateur
	 */

	
	
}

package controleur;

import personnages.Gaulois;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur, Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public boolean verifierIdentite(String nomAcheteur) {
		return controlVerifierIdentite.verifierIdentite(nomAcheteur);
	}

	public String[] rechercherVendeursProduit(String produit) {
		Gaulois[] vendeursGaulois = village.rechercherVendeursProduit(produit);

		String[] vendeursString = new String[vendeursGaulois.length];

		for (int i = 0; i < vendeursGaulois.length; i++) {
			vendeursString[i] = vendeursGaulois[i].getNom();
		}

		return vendeursString;
	}

	public int acheterProduit(String nomVendeur, int nbProduit) {

		return controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur).acheterProduit(nbProduit);
	}

}

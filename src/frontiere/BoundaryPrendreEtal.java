package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		boolean vendeurConnu = controlPrendreEtal.verifierIdentite(nomVendeur);

		if (!vendeurConnu) {
			System.out.println("Je suis désolé " + nomVendeur
					+ " mais il faut être un habitant de notre village pour commercer ici\n");
		} else {
			System.out.println("Bonjour " + nomVendeur + " je vais regarder si je peux vous trouver un étal\n");
			boolean etatDisponible = controlPrendreEtal.resteEtals();

			if (!etatDisponible) {
				System.out.println("Désolée " + nomVendeur + "je n'ai plus d'étal qui ne soit pas occupé\n");
			} else {
				installerVendeur(nomVendeur);
			}
		}

	}

	private void installerVendeur(String nomVendeur) {
		System.out.println("C'est parfait il me reste un étal\n");
		System.out.println("Il me faudrait quelques renseignements :\n");

		String produit = Clavier.entrerChaine("Quel produit souhaitez-vous vendre ?");
		int nbProduit = Clavier.entrerEntier("Combien souhaitez-vous en prendre ?");

		int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);

		if (numeroEtal != -1) {
			System.out.println("Le vendeur " + nomVendeur + "s'est installé à l'étal n°" + numeroEtal);
		}

	}
}

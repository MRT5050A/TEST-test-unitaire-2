package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		boolean vendeurReconnu = controlLibererEtal.isVendeur(nomVendeur);

		if (!vendeurReconnu) {
			System.out.println("Mais vous n'êtes même pas sur notre marché aujourd'hui");
		} else {
			String[] donneesEtal = controlLibererEtal.libererEtal(nomVendeur);

			if (Boolean.parseBoolean(donneesEtal[0])) {
				System.out.println(
						"Vous avez vendu " + donneesEtal[2] + " sur " + donneesEtal[3] + " " + donneesEtal[4] + ".");

				System.out.println("Au revoir " + nomVendeur + ", passez une bonne journée.");
			}
		}
	}

}

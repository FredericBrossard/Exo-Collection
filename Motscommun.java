import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeSet;


public class Motscommun {

	/*----------------------------------------------------------------------------------------------
	 * Semaine 4 
	 * Consolidation sur les collections
	 * Exercice 1 : Mots communs
	 * ----------------------------------------------------------------------------------------------
	Écrire un programme qui permette d'afficher (un mot par ligne) les mots qui sont communs aux deux fichiers.
	Bonus : prendre les noms de chiers / chemins en argument
	        afficher les mots communs dans l'ordre alphabétique
	-------------------------------------------------------------------------------------------------*/	
	public static void main(String[] args) throws IOException {

		// -----------Déclaration des 2 fichiers----------------------- -----------
		String fileName1 = args.length > 0 ? args[0] : "ethics.txt"; // Une manière de le faire. args[0] = si nom fihier en "argument" de "Run Configuration".
		// Conversion du chemin spécifié "chaine de caractere" en "Objet de chemin"
		Path filePath1 = Paths.get(fileName1);
		//Création d'un Objet de classe File() en précisant le nom de fichier ou le chemin du fichier
		Path filePath2= Paths.get("wealth.txt"); // Une autre manière de le faire
						
		//Instanciation d'une variable "tab1" de type TreeSet (liste triée sans doublon)
		TreeSet<String> tab1 = new TreeSet<String>();
		//Flux de caractere "BufferedReader". Permet de mettre des données de flux dans une mémoire tampon.
		try (BufferedReader br = Files.newBufferedReader(filePath1)) {
			//Utilisation de la méthode ReadLine pour lire une ligne. A la fin de fichier BufferedReader retourne null
			for (String line = br.readLine(); line != null; line = br.readLine()) {
				tab1.add(line);
				// System.out.println(tab1);
			}
			}catch(NoSuchFileException e){
	            System.out.printf("Pas de fichier nommé : " + filePath1.toString() + "\n");
	            System.out.println(" ");
		}
		
		TreeSet<String> tab2 = new TreeSet<String>();
		
		try (BufferedReader br = Files.newBufferedReader(filePath2)) { 
			String line;
			while ((line = br.readLine()) != null) {
				tab2.add(line);
				// System.out.println(tab2);
			}
			
		}catch(NoSuchFileException e){   // Permet de gérer le "fichier non trouvé" et poursuivre l'execution sans 'planter'.         
            System.out.printf("Pas de fichier nommé : " + filePath2.toString() + "\n");
	
		}

		intersection(tab1, tab2);

	}

	// Méthode de recherche de mot commun dans deux Collections pour stockage en Liste "ArrayList" ordonnée.
	public static void intersection(Collection<String> tab, Collection<String> tab2) {
		ArrayList<String> tabResult = new ArrayList<String>();
		int i = 0;
		for (String elt1 : tab) {
			for (String elt2 : tab2) {
				if (elt2.equals(elt1)) {
					tabResult.add(elt1);
					++i;
				}
			}
		}
		//Affichage par ordre alphabétique car gestion collection arrayList
		System.out.println("Il y a " + i + " mots communs aux 2 listes.\nLes Voici : " + tabResult);
		//Tentative ko d'affichage en colonne et pas en ligne
		/*for (int j=1; j != i; ++j) {
			System.out.println(tabResult.get(i));
		}*/
	}

}

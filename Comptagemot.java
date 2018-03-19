import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

/*Écrire un programme qui, pour un fichier, affiche le nombre d'occurrences de chaque mot.
Bonus  prendre le nom de chier / chemin en argument
 afficher les résultats par ordre alphabétique des mots
 afficher les résultats par ordre décroissant des nombres d'occurrences
*/

public class Comptagemot {

	public static void main(String[] args) throws IOException {
		// La classe Paths convertie une chaine de carctere précisant un chemin ou un un
		// nom de fichier ou URL en objet de chemin
		/*
		 * 3 exemples Path p1 = Paths.get("/tmp/foo"); Path p2 = Paths.get(args[0]);
		 * Path p3 = Paths.get(URI.create("file:///Users/joe/FileTest.java"));
		 */
		Path pathFile = Paths.get("Toto.txt");
		// Une HashMap est une collection en Java qui associe une clé à une valeur. Ici,
		// la clef est le mot et la valeur le compteur de mot
		HashMap<String, Integer> wordCounter = new HashMap<>();

		int nbreOcc = 0;
		// Flux de caractere "BufferedReader". Permet de mettre des données de flux dans
		// une mémoire tampon.
		try (BufferedReader br = Files.newBufferedReader(pathFile)) {

			for (String mot = br.readLine(); mot != null; mot = br.readLine()) {

				if (wordCounter.containsKey(mot)) {
					nbreOcc = ((Integer) wordCounter.get(mot)).intValue();
					nbreOcc++;
					wordCounter.put(mot, new Integer(nbreOcc));
					System.out.println(wordCounter);
				} else
					nbreOcc = 1;
				wordCounter.put(mot, new Integer(nbreOcc));
				System.out.println(wordCounter);
			}
		} catch (NoSuchFileException e) { // Gere le cas d'erreur de nom de fichier dans Path
			System.out.printf("Pas de fichier nommé : " + pathFile.toString() + "\n");
			System.out.println(" ");
		}

	}

}

/*7. Készítsen egy programot, amely paraméterként kap egy file-t, amelyben beléptetõrendszer 
adatok vannak a következõ szerkezetben: Idõ, név, be/ki 
Írja ki, hogy ki hányszor felejtkezett el kijelentkezni. Csak azokat írja ki, akik legalább egyszer nem jelentkeztek ki.*/

package JavaHaziFeladat;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class SzemelyFut {
	public static void main(String[] args) throws ParseException {

		ArrayList<Szemely> lista = new ArrayList<Szemely>();
		Map<String, Integer> hanyszor = new HashMap<String, Integer>();
		Map<String, Integer> nemnulla = new HashMap<String, Integer>();

		if (args.length == 1) {
			String fajlnev = args[0];
			try {
				BufferedReader bemenet = new BufferedReader(new FileReader(fajlnev));

				for (String sor = bemenet.readLine(); sor != null; sor = bemenet.readLine()) {

					StringTokenizer st = new StringTokenizer(sor);

					String str_date = st.nextToken(",");
					DateFormat formatter;
					Date date;
					formatter = new SimpleDateFormat("yyyy-MM-dd");
					date = formatter.parse(str_date);
					String nev = st.nextToken(",");
					String jelentkezes = st.nextToken(",");

					Szemely sz = new Szemely(date, nev, jelentkezes);
					lista.add(sz);
					System.out.println(sz.toString());
				}
				Iterator<Szemely> it = lista.iterator();

				while (it.hasNext()) {
					Szemely elem = it.next();
					if (!hanyszor.containsKey(elem.getNev())) {
						hanyszor.put(elem.getNev(), 0);
					}
					if (elem.getJelentkezes().equals("be")) {
						int szamlalo = 0;
						szamlalo = hanyszor.get(elem.getNev()) + 1;
						hanyszor.remove(elem.getNev());
						hanyszor.put(elem.getNev(), szamlalo);
					} else {
						int szamlalo = 0;
						szamlalo = hanyszor.get(elem.getNev()) - 1;
						hanyszor.remove(elem.getNev());
						hanyszor.put(elem.getNev(), szamlalo);
					}
				}

				Iterator<Entry<String, Integer>> iterator = hanyszor.entrySet().iterator();
				while (iterator.hasNext()) {
					Entry<String, Integer> e = iterator.next();
					if (e.getValue() != 0) {
						nemnulla.put(e.getKey(), e.getValue());
					}
				}

				for (String kulcs : nemnulla.keySet()) {
					System.out.println("Név: " + kulcs + ": " + nemnulla.get(kulcs).toString());
				}

				bemenet.close();
			} catch (IOException e) {
				System.out.println("A fájl nem nyitható meg...");
			}
		} else {
			System.out.println("Nem megfelelõ számú argumentum...");
		}
	}
}
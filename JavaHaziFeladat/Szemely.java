/*7. Készítsen egy programot, amely paraméterként kap egy file-t, amelyben beléptetõrendszer 
adatok vannak a következõ szerkezetben: Idõ, név, be/ki 
Írja ki, hogy ki hányszor felejtkezett el kijelentkezni. Csak azokat írja ki, akik legalább egyszer nem jelentkeztek ki.*/

package JavaHaziFeladat;

import java.util.Date;

public class Szemely {
	private Date ido;
	private String nev;
	private String jelentkezes;
	
	public Szemely(Date date, String nev, String jelentkezes) {
		this.ido = date;
		this.nev = nev;
		this.jelentkezes = jelentkezes;
	}

	@Override
	public String toString() {
		return "Szemely [ido=" + ido + ", nev=" + nev + ", jelentkezes="
				+ jelentkezes + "]";
	}

	public Date getIdo() {
		return ido;
	}

	public String getNev() {
		return nev;
	}

	public String getJelentkezes() {
		return jelentkezes;
	}
}
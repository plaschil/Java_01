/*7. K�sz�tsen egy programot, amely param�terk�nt kap egy file-t, amelyben bel�ptet�rendszer 
adatok vannak a k�vetkez� szerkezetben: Id�, n�v, be/ki 
�rja ki, hogy ki h�nyszor felejtkezett el kijelentkezni. Csak azokat �rja ki, akik legal�bb egyszer nem jelentkeztek ki.*/

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
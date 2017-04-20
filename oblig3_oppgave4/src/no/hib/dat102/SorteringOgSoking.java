package no.hib.dat102;

public class SorteringOgSoking {
	private static final int MIN = 10;
	public static <T extends Comparable<T>> void kvikkSortNy(T[] data, int min, int maks) {
		kvikkSort2(data, min, maks);
		sorteringVedInnsetting2(data, min, maks);
	}

	public static <T extends Comparable<T>> void kvikkSort2(T[] data, int min, int maks){

		int posPartisjon;
		if (maks - min +1 > MIN) {
			//
			/** Lager partisjon */
			posPartisjon = finnPartisjon(data, min, maks);
			/** Sorterer venstre side */
			kvikkSort2(data, min, posPartisjon -1);
			/** Sorterer høyre side */
			kvikkSort2(data, posPartisjon + 1, maks);  
		}
	}// metode

	public static <T extends Comparable<T>> void sorteringVedInnsetting2(T[] data, int forste, int siste) {
		for (int indeks = forste + 1; indeks <= siste; indeks++) {
			T nokkel = data[indeks];
			int p = indeks;
			// Forskyv større verdier mot høyre
			while (p > 0 && data[p - 1].compareTo(nokkel) > 0) {
				data[p] = data[p - 1];
				p--;
			}
			data[p] = nokkel;
		} // ytre
	}// metode
	
	private static  <T extends Comparable<T>> int finnPartisjon(T[] tab, int min, int maks){
		int venstre;
		int hoeyre;
		T temp;
		T pivot;

		// Pivot første element
		pivot = tab[min];
		venstre = min;
		hoeyre = maks;

		while (venstre < hoeyre) {
			// ser etter element større enn pivot 
			while (venstre < hoeyre && tab[venstre].compareTo(pivot) <= 0) {
				venstre++;
			}
			//Ser etter element som er mindre enn pivot 
			while (tab[hoeyre].compareTo(pivot) > 0) {
				hoeyre--;
			}
			if (venstre < hoeyre) {
				temp = tab[venstre];
				tab[venstre] = tab[hoeyre];
				tab[hoeyre] = temp;
			}
		}
		
		temp = tab[min];
		tab[min] = tab[hoeyre];
		tab[hoeyre] = temp;
		return hoeyre;
	}
}
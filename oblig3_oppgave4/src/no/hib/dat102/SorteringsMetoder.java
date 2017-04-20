package no.hib.dat102;

public class SorteringsMetoder<T extends Comparable<T>> {
	public void utvalgsSortering(T[] tab) {
		int minste;
		T hjelper;
		for (int i = 0; i < tab.length - 1; i++) {
			minste = i;
			for (int j = 0; j < tab.length; j++) { // finner den minste som
				if (tab[j].compareTo(tab[minste]) < 0) { // er igjen i den
															// usorterte
															// tabellen
					minste = j;
				}
			}
			hjelper = tab[minste];
			tab[minste] = tab[i];
			tab[i] = hjelper;
		}
	}

	public void soerteringVedInnseting(T[] tab) {
		for (int i = 0; i < tab.length - 1; i++) {
			T noekkel = tab[i];
			int a = i;
			// flytter elementer til høyre
			while (a > 0 && tab[a - 1].compareTo(noekkel) > 0) {
				tab[a] = tab[a - 1];
				a--;
			}
			tab[a] = noekkel;
		}
	}

	public void bobleSort(T[] tab) {
		T hjelper;

		for (int i = tab.length - 1; i >= 0; i--) {
			for (int soek = 0; soek <= i - 1; soek++) {
				if (tab[soek].compareTo(tab[soek + 1]) > 0) {
					hjelper = tab[soek];
					tab[soek] = tab[soek + 1];
					tab[soek + 1] = hjelper;
				}
			}
		}
	}

	public void fletteSorter(T[] tab, int foerste, int siste) {
		if (foerste < siste) { // mer enn et elemenet
			int mid = (foerste + siste) / 2;
			fletteSorter(tab, foerste, mid);
			fletteSorter(tab, mid + 1, siste);
			flett(tab, foerste, mid, siste);
		}
	}

	private void flett(T[] tab, int foerste, int mid, int siste) {
		int stor = siste - foerste + 1;
		T[] hjelpeTabell = (T[]) (new Comparable[stor]);

		int foerste1 = foerste;
		int siste1 = mid;

		int foerste2 = mid + 1;
		int siste2 = siste;

		int indeks = 0;

		while ((foerste1 <= siste1) && (foerste2 <= siste2)) {
			if (tab[foerste1].compareTo(tab[foerste2]) <= 0) {
				hjelpeTabell[indeks] = tab[foerste1];
				foerste1++;
			} else {
				hjelpeTabell[indeks] = tab[foerste2];
				foerste2++;
			}
			indeks++;
		}

		while (foerste1 <= siste1) {
			hjelpeTabell[indeks] = tab[foerste1];
			foerste1++;
			indeks++;
		}

		while (foerste2 <= siste2) {
			hjelpeTabell[indeks] = tab[foerste2];
			foerste2++;
			indeks++;
		}
		int h = 0;
		for (indeks = foerste; indeks <= siste; indeks++) {
			tab[indeks] = hjelpeTabell[h];
			h++;
		}
	}


	public void kvikkSort(T[] tab, int min, int maks) {
		int partisjon;
		if (min < maks) {
			// Lager partisjon
			partisjon = finnPartisjon(tab, min, maks);

			// venstre side
			kvikkSort(tab, min, partisjon - 1);

			// høyre side 
			kvikkSort(tab, partisjon + 1, maks);
		}
	}
	
	private int finnPartisjon(T[] tab, int min, int maks){
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
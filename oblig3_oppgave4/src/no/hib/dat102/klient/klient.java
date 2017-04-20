package no.hib.dat102.klient;

import no.hib.dat102.*;
import java.util.Random;
import java.time.Duration;
import java.time.Instant;

public class klient {
	static final int n = 128000;
	static Integer[] tab = new Integer[n];	
	static Random tall = new Random();



	public static void main(String[] args) {
		SorteringsMetoder<Integer> sM = new SorteringsMetoder<Integer>();
		lagTabell();

		Instant foer = Instant.now();
		sM.kvikkSort(tab, 0, tab.length-1);
		Instant etter = Instant.now();
		tiden(foer, etter);
	}

	public static void tiden(Instant foer, Instant etter) {
		Duration tid = Duration.between(foer, etter);

		System.out.println("Tid i millisekund: " + tid.toMillis());
	}

	static public void lagTabell() {
		for (int i = 0; i < tab.length; i++) {
			tab[i]=tall.nextInt(100);
		}
	}
}

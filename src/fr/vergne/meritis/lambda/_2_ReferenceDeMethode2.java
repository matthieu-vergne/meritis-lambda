package fr.vergne.meritis.lambda;

import java.util.LinkedList;
import java.util.List;

public class _2_ReferenceDeMethode2 {
	@FunctionalInterface
	static interface Consumer {
		boolean consume(Integer value);
	}
	
	public static void main(String[] args) {
		List<Integer> list = new LinkedList<>();
		// Référence de méthode sur objet
		Consumer consumer = list::add;
		// Si pas besoin de valeur de retour, référence sur méthode avec retour reste compatible
		// L'inverse ne compile pas car type de retour incompatible
		
		consumer.consume(1);
		consumer.consume(2);
		consumer.consume(3);
		
		System.out.println(list);
	}
}

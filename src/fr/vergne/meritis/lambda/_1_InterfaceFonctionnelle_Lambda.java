package fr.vergne.meritis.lambda;

import java.util.LinkedList;
import java.util.List;

public class _1_InterfaceFonctionnelle_Lambda {
	// L'interface ne définie qu'une seule méthode
	// Elle ne couvre donc qu'une seule fonction (au sens large)
	// C'est une interface *fonctionelle*
	
	@FunctionalInterface // On peut le contraindre par annotation, optionnel
	static interface Criteria {
		boolean check(Integer value);
	}
	
	static List<Integer> filter(List<Integer> values, Criteria criteria) {
		List<Integer> retainedValues = new LinkedList<>();
		for (Integer value : values) {
			if (criteria.check(value)) {
				retainedValues.add(value);
			}
		}
		return retainedValues;
	}
	
	public static void main(String[] args) {
		List<Integer> originalList = List.of(0, -5, 45, -3, 12);
		
		// Les lambda permettent de réduire au minimum :
		// - info de type vient de la variable
		// - signature de méthode vient du type
		// - une seule méthode donc pas d'ambiguité
		
		// On a juste besoin de nommer l'argument (value)
		// et de fournir l'implémentation l'utilisant
		
		/*
		Criteria criteria = new Criteria() {
			@Override
			public boolean check(Integer value) {
				return value <= 5;
			}
		};
		 */
		Criteria criteria = (value) -> value <= 5;
		
		/* Pour plusieurs intructions, on garde le bloc :
		Criteria criteria = (value) -> {
			boolean isBetween0and5 = value >= 0 && value <= 5;
			boolean isEven = value % 2 == 0;
			return isBetween0and5 && isEven;
		};
		 */
		
		// Conseillé de garder les parenthèses, même si mono-argument
		// Code plus homogène si plusieurs lambda différentes
		
		List<Integer> filteredList = filter(originalList, criteria);
		System.out.println(filteredList);
	}
}

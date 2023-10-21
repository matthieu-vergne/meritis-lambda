package fr.vergne.meritis.lambda;

import java.util.LinkedList;
import java.util.List;

public class _0_Contexte2 {
	static class originalMethod {
		static List<Integer> filter(List<Integer> values) {
			List<Integer> retainedValues = new LinkedList<>();
			for (Integer value : values) {
				if (value >= 5) {
					retainedValues.add(value);
				}
			}
			return retainedValues;
		}

		public static void main(String[] args) {
			List<Integer> originalList = List.of(0, -5, 45, -3, 12);
			List<Integer> filteredList = filter(originalList);
			System.out.println(filteredList);
		}
		// On souhaite personnaliser le calcul de filtrage
	}

	static class abstractBehavior {
		// On crée une interface pour abstraire le comportement
		static interface Criteria {
			boolean check(Integer value);
		}

		// On crée une classe implémentant le comportement initial
		static class AtLeast5Criteria implements Criteria {
			@Override
			public boolean check(Integer value) {
				return value >= 5;
			}
		}

		static List<Integer> filter(List<Integer> values) {
			// On abstrait via l'interface et son implémentation
			Criteria criteria = new AtLeast5Criteria();

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
			List<Integer> filteredList = filter(originalList);
			System.out.println(filteredList);
		}
	}

	static class generalizeMethod {
		static interface Criteria {
			boolean check(Integer value);
		}

		static class AtLeast5Criteria implements Criteria {
			@Override
			public boolean check(Integer value) {
				return value >= 5;
			}
		}

		// On récupère le comportement en argument
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
			Criteria criteria = new AtMost5Criteria(); // On change le calcul selon besoin
			List<Integer> filteredList = filter(originalList, criteria);
			System.out.println(filteredList);
		}

		// On implémente les classes nécessaires
		static class AtMost5Criteria implements Criteria {
			@Override
			public boolean check(Integer value) {
				return value <= 5;
			}
		}
		
		// C'est très verbeux : chaque nouveau comportement a sa nouvelle classe
		// Si générique, moins de classes différentes, mais plus verbeux (champs + constructeur)
	}

	static class simplifyWithAnonymousClass {
		// On ne définie que l'interface
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
			// On déclare l'implémentation à la volée
			// Seule l'implémentation nécessaire est déclarée
			Criteria criteria = new Criteria() {
				@Override
				public boolean check(Integer value) {
					return value <= 5;
				}
			};
			List<Integer> filteredList = filter(originalList, criteria);
			System.out.println(filteredList);
		}
		
		// La classe anonyme est plus adaptée pour un usage unique
		// Elle reste cependant verbeuse au sein de la méthode
		// 6 lignes pour exprimer une simple comparaison
		
		// En pratique, ce genre de besoin arrive fréquemment
		// La verbosité répétée introduite semble déraisonnable
		// On se limite alors aux comportements les plus complexes
		// On abstrait alors la complexité dans une classe nommée plutôt qu'une méthode
	}
	
	static class moveVerbosityToMethod {
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
			// On déplace la classe anonyme dans une méthode dédiée
			Criteria criteria = below(5);
			List<Integer> filteredList = filter(originalList, criteria);
			System.out.println(filteredList);
		}

		private static Criteria below(int maxValue) {
			return new Criteria() {
				@Override
				public boolean check(Integer value) {
					return value <= maxValue;
				}
			};
		}
		
		// On se contente de déplacer le problème
		// Les cas plus complexes nécessitent des efforts de design supplémentaires
		// Notamment entre implémentation dédiée et framework avec combinatoire
	}
}

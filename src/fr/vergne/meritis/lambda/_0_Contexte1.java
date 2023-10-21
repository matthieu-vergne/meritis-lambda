package fr.vergne.meritis.lambda;

import java.util.LinkedList;
import java.util.List;

public class _0_Contexte1 {
	// Questions préliminaires :
	// Qui connaîts les lambda/références de méthode ?
	// Qui en écrit ?
	// Qui connait les classes anonymes ?
	// Qui en écrivait avant l'arrivée des lambda ?
	
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
		// On souhaite personnaliser le seuil de filtrage
	}

	static class abstractValue {
		static List<Integer> filter(List<Integer> values) {
			// On abstrait le seuil via une variable
			int minValue = 5;

			List<Integer> retainedValues = new LinkedList<>();
			for (Integer value : values) {
				if (value >= minValue) {
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
		// On récupère le seuil en argument
		static List<Integer> filter(List<Integer> values, int minValue) {
			List<Integer> retainedValues = new LinkedList<>();
			for (Integer value : values) {
				if (value >= minValue) {
					retainedValues.add(value);
				}
			}
			return retainedValues;
		}

		public static void main(String[] args) {
			List<Integer> originalList = List.of(0, -5, 45, -3, 12);
			List<Integer> filteredList = filter(originalList, 0); // On change la valeur selon besoin
			System.out.println(filteredList);
		}
	}
}

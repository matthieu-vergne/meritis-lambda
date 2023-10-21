package fr.vergne.meritis.lambda;

import java.util.LinkedList;
import java.util.List;

public class _2_ReferenceDeMethode1 {
	@FunctionalInterface
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
	
	// Fonction utilitaire à disposition avec signature équivalente (Integer -> boolean)
	static class CheckUtils {
		static public boolean isEven(Integer value) {
			return value % 2 == 0;
		}
	}
	
	public static void main(String[] args) {
		List<Integer> originalList = List.of(0, -5, 45, -3, 12);
		/*
		Criteria criteria = (value) -> CheckUtils.isEven(value);
		 */
		Criteria criteria = CheckUtils::isEven;
		// En pratique, on choisira le plus clair entre référence de méthode et lambda
		List<Integer> filteredList = filter(originalList, criteria);
		System.out.println(filteredList);
	}
}

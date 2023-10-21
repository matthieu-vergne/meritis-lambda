package fr.vergne.meritis.lambda;

import static java.util.function.Predicate.isEqual;
import static java.util.function.Predicate.not;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

@SuppressWarnings("unused")
public class _3_InterfacesFonctionnellesStandard4 {
	public static void main(String[] args) {
		Predicate<Integer> is123 = Predicate.isEqual(123);
		
		Predicate<Integer> isNot123 = is123.negate();
		
		Predicate<Integer> isNegative = (value) -> value <= 0;
		Predicate<Integer> isPositive = Predicate.not(isNegative);
		
		Predicate<Integer> completePredicate = isPositive.and(isNot123);
		
		System.out.println(completePredicate.test(-5));
		System.out.println(completePredicate.test(5));
		System.out.println(completePredicate.test(123));
	}
	
	// On organisera le code pour faciliter sa compréhension :
	/*
	Predicate<Integer> isPositive() {
		return (value) -> value >= 0;
	}
	
	Predicate<Integer> completePredicate = isPositive().and(not(isEqual(123)));
	 */
	
	// D'autres interfaces standard fournissent des transformations:
	// consumer1.andThen(consumer2)
	// function1.andThen(function2)
	// function2.compose(function1)
	
	// D'autres interfaces standard fournissent des implémentations de base:
	// Predicate.isEqual(object);
	// Function.identity()
}

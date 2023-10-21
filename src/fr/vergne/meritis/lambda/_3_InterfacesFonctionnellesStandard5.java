package fr.vergne.meritis.lambda;

import static java.util.function.Predicate.isEqual;
import static java.util.function.Predicate.not;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.DoubleToIntFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

@SuppressWarnings("unused")
public class _3_InterfacesFonctionnellesStandard5 {
	public static void main(String[] args) {
		// Il existe des variantes pour types primitifs
		DoubleToIntFunction numberOfDecimals = (value) -> Double.toString(value).split("\\.")[1].length();

		System.out.println(numberOfDecimals.applyAsInt(123.456));
		System.out.println(numberOfDecimals.applyAsInt(0.123456));
	}
	
	// On remarquera que les interfaces standard restent très génériques
	// Il ne faut pas hésiter à faire sa propre interface représentative du domaine
}

package fr.vergne.meritis.lambda;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

@SuppressWarnings("unused")
public class _3_InterfacesFonctionnellesStandard3 {
	void predicate() {
		Predicate<Integer> predicate = (value) -> value > 123;
		boolean isAbove123 = predicate.test(123);
	}
	
	void unaryOperator() {
		UnaryOperator<Integer> operator = (value) -> value * 2;
		Integer result = operator.apply(123);
	}
	
	void binaryOperator() {
		BinaryOperator<Integer> operator = (value1, value2) -> value1 * value2;
		Integer result = operator.apply(123, 2);
	}
}

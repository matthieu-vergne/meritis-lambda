package fr.vergne.meritis.lambda;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@SuppressWarnings("unused")
public class _3_InterfacesFonctionnellesStandard2 {
	void biConsumer() {
		BiConsumer<Integer, Integer> biConsumer = (value1, value2) -> System.out.println(value1+value2);
		biConsumer.accept(123, 321);
	}
	
	void biFunction() {
		BiFunction<Integer, Integer, String> function = (value1, value2) -> "" + (value1 + value2);
		String str = function.apply(123, 321);
	}
}

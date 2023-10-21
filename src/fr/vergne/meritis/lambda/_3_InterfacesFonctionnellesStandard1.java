package fr.vergne.meritis.lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@SuppressWarnings("unused")
public class _3_InterfacesFonctionnellesStandard1 {
	void runnable() {
		Runnable runnable = () -> System.out.println(123);
		runnable.run();
	}
	
	void supplier() {
		Supplier<Integer> supplier = () -> 123;
		Integer value = supplier.get();
	}
	
	void consumer() {
		Consumer<Integer> consumer = (value) -> System.out.println(value);
		consumer.accept(123);
	}
	
	void function() {
		Function<Integer, String> function = (value) -> value.toString();
		String str = function.apply(123);
	}
}

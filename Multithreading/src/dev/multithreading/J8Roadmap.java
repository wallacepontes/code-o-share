package dev.multithreading;

import java.nio.file.DirectoryStream.Filter;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class J8Roadmap {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		List<Integer> squaredNumbers = numbers.stream()
		                                         .map(n -> n * n)
		                                         .collect(Collectors.toList());
		numbers.forEach(System.out::println);
		squaredNumbers.forEach(System.out::println); // method reference 
		squaredNumbers.forEach((n) -> System.out.println("without method reference " + n));
		 
		Optional<String> optional = Optional.of("Hello");
		optional.ifPresent(System.out::println);
		 
		 
		Optional<String> emptyOptional = Optional.empty();
		Optional<String> nonEmptyOptional = Optional.of("Hello, World!");
		Optional<String> nullableOptional = Optional.ofNullable("someString");
		if (nonEmptyOptional.isPresent()) {
			System.out.println("Value is present");
		}
		nonEmptyOptional.ifPresent(value -> System.out.println("Value: " + value));
		
		
        
        MyFunctionalInterface func = () -> System.out.println("Hello, Functional Interface!");
        func.execute();
        
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println(currentDateTime);
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);
        System.out.println(Instant.now());
        
        List<String> list = Arrays.asList("one", "two", "three");
        list.forEach(s -> System.out.println(s));
        
        List<Integer> evenNumbers = numbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        evenNumbers.forEach(System.out::println);
        
        
        
        Sayable sayable = (msg) -> {
        	System.out.println(msg);
        };
        sayable.say("Say something...");
        
        // Stream
        int sum = Arrays.stream(new int[]{1,2,3})
        			.filter(i -> i >= 2)
        			.map(i -> i*3)
        			.sum();
        System.out.println(sum);
        
        //StringJoiner
        StringJoiner joinNames = new StringJoiner(",");
        joinNames.add("Peter");
        joinNames.add("Corina");
        joinNames.add("Kalil");
        joinNames.add("Livia");
        System.out.println(joinNames);
        
        // static method in interface
        System.out.println(Vehicle.getHorsePower(2, 12000));
        
        Car c = new Car();
        c.print();
        
        D d = new D();
        d.display();
        int min1 = Arrays.stream(new int[]{1, 2, 3, 4, 5})
        		  .min()
        		  .orElse(0);
        //assertEquals(1, min1);
        FunctionalInterfacesExample.main();
        
        //Runnable
        //Callable<V>
        //Comparator<T>
        Predicate<String> stringPredicate = s -> s.isEmpty();
        
        // Iterating over a Collection
        // 
        List<String> names = Arrays.asList("John", "Jane", "Jack", "Doe");
        for (String name : names) {
            System.out.println("Old way (Pre-Java 8) : " + name);
        }
        names.forEach(name -> System.out.println("New Way (Java 8) : " + name));
        //Filtering a Collection
        List<String> filteredNames = new ArrayList<>();
        for (String name : names) {
            if (name.startsWith("D")) {
                filteredNames.add(name);
            }
        }
        for (String name : filteredNames) {
            System.out.println("Old way (Pre-Java 8) : " + name);
        }
        filteredNames = names.stream()
                .filter(name -> name.startsWith("D"))
                .collect(Collectors.toList());

        filteredNames.forEach(System.out::println);
        // Map
        // Compare
        List<String> sortedNames = names.stream().sorted().collect(Collectors.toList());
        sortedNames.forEach(System.out::println); 
        names.stream().sorted().collect(Collectors.toList()); //not sorted
        names.forEach(System.out::println);
        //or
        names.sort((s1, s2) -> s1.compareTo(s2));
        names.forEach(System.out::println);
        //
        Stream<String> st = Stream.iterate("", (str) -> str + "x"); 
        System.out.println(st.limit(3).map(str -> str + "y"));
	}
}

@FunctionalInterface
interface MyFunctionalInterface {
    void execute(); // abstract method
    //void execute2();
}

@FunctionalInterface
interface Sayable {
    void say(String msg); // abstract method
}

interface Vehicle {
	String getBrand();
	String speedUp();
	default String turnAlarmOn() {
		return "Turning on";
	}
	default String turnAlarmOff() {
		return "Turning off";
	}
	static int getHorsePower(int rpm, int torque) {
		return (rpm * torque) / 5252;
	}
	default void print() {
		System.out.println("I am a vehicle!");
	}
	static void blowHorn() {
		System.out.println("Blowing horn!");
	}
}

class Car implements Vehicle {
	public void print() {
		Vehicle.super.print();
		Vehicle.blowHorn();
	}

	@Override
	public String getBrand() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String speedUp() {
		// TODO Auto-generated method stub
		return null;
	}
}

interface A {
	default void display() { //code goes here 
		System.out.println("A display!");
	}
}
interface B extends A {
	default void display() { //code goes here 
		System.out.println("B display!");
	}
}
interface C extends A {
	default void display() { //code goes here 
		System.out.println("C display!");
	}
}
class D implements B, C {

	@Override
	public void display() {
		// TODO Auto-generated method stub
		B.super.display();
	}

}

class FunctionalInterfacesExample {
    public static void main() {
        // Consumer Example
        Consumer<String> printConsumer = s -> System.out.println(s);
        printConsumer.accept("Hello, Consumer!");

        // Supplier Example
        Supplier<String> stringSupplier = () -> "Hello, Supplier!";
        System.out.println(stringSupplier.get());

        // BiFunction Example
        BiFunction<Integer, Integer, Integer> sumBiFunction = (a, b) -> a + b;
        int sum = sumBiFunction.apply(10, 20);
        System.out.println("Sum using BiFunction: " + sum);

        // BinaryOperator Example
        BinaryOperator<Integer> multiplyOperator = (a, b) -> a * b;
        int product = multiplyOperator.apply(5, 4);
        System.out.println("Product using BinaryOperator: " + product);

        // UnaryOperator Example
        UnaryOperator<String> toUpperCaseOperator = s -> s.toUpperCase();
        String upperCaseString = toUpperCaseOperator.apply("hello");
        System.out.println("Uppercase using UnaryOperator: " + upperCaseString);
        
        // Creating predicate - it takes on argument ad returns a boolean
        Predicate<Integer> lesserthan = i -> (i < 18);
        System.out.println(lesserthan.test(18));
        
        // Creating a Function - it takes one argument and returns a result
 		Function<IntUnaryOperator, IntUnaryOperator> twice = f -> f.andThen(f);
         IntUnaryOperator plusThree = i -> i + 3;
         var g = twice.apply(plusThree);
         System.out.println(g.applyAsInt(7)); // 13
         
         
    }
}

interface Parent { 
	public void parentMethod(); 
} 
//@FunctionalInterface 
interface Child extends Parent { 
	public int childMethod(); 
}

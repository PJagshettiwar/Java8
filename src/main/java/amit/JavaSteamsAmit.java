package amit;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class JavaSteamsAmit {

	public static void main(String[] args) {
		sumValues();
	}
	
	private static void sumValues() {
		List<Integer> list = Arrays.asList(10,20,30,14,15,60,10,15);
		Integer sum = list.stream().map(i -> i).reduce(0,Integer::sum);
		System.out.println(sum);
		
	}
	
	private static void firstNonRepeatingChar() {
		String str = "Java Hungry Blog Alive is Awesome";
			char c = str.chars()
			.mapToObj(s -> Character.valueOf((char) s))
			.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
			.entrySet()
			.stream()
			.filter(e -> e.getValue()==1)
			.map(e -> e.getKey())
			.findFirst().get();
	
			System.out.println(c);
	}
	
	private static void findMax() {
		List<Integer> list = Arrays.asList(10,20,30,14,15,60,10,15);
		int max = list.stream().max(Integer::compare).get();
		System.out.println(max);
	}
	
	private static void findDuplicate() {
		List<Integer> list = Arrays.asList(10,20,30,14,15,60,10,15);
		
		//using extra space
		Set<Integer> set = new HashSet<>();
		Set<Integer> output = list.stream().filter(i -> !set.add(i)).collect(Collectors.toSet());
		System.out.println(output);
		
		//using zero space
		List<Integer> output1 = list.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet()
				.stream()
				.filter(entry -> entry.getValue()>1)
				.map(entry -> entry.getKey())
				.collect(Collectors.toList());
		System.out.println(output1);
	}
	
	private static void numberStartingFromOne() {
		List<Integer> list = Arrays.asList(10,20,30,14,15,60);
		//Using map : map is converter from string to int
		List<Integer> op = list.stream()
				.map(i -> ""+i)
				.filter(i -> i.charAt(0)=='1')
				.map(i -> Integer.valueOf(i))
				.collect(Collectors.toList());
		System.out.println(op);
		
		//Direct filter 
		List<Integer> op1 = list.stream()
				.filter(i -> i.toString().charAt(0)=='1')
				.collect(Collectors.toList());
		System.out.println(op1);
	}
	
	private static void primeEvenNumber() {
		
		//Source : list (Ugam)
		//Processor 1..n : Filter pe filter
		//Sink : Aggregate (Samundar)
		
		List<Integer> list = Arrays.asList(1,2,3,4,5,6);
		List<Integer> op = list.stream().filter(i -> i%2==0).collect(Collectors.toList());
		System.out.println(op);
		List<Integer> op1 = list.stream().filter(i -> 
		{
			return i % 2 == 0;
		}).collect(Collectors.toList());
		
		System.out.println(op1);
		
		List<Integer> op2 = list.stream().filter(new Predicate<Integer>() {

			@Override
			public boolean test(Integer t) {
				// TODO Auto-generated method stub
				return t%2==0;
			} 
			
		}).collect(Collectors.toList());
		System.out.println(op2);
		
		Long count = list.stream().filter(i -> i%2==0).collect(Collectors.counting());
		System.out.println(count);
	}
}

package application;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import entities.Product;
import services.ProductServices;

public class Main {

	public static void main(String[] args) {
		

		System.out.println("Exemple predicate:");
		examplePredicate();
		System.out.println("= - = - = - = - = -");
		System.out.println("Exemple Consumer:");
		exampleConsumer();
		System.out.println("= - = - = - = - = -");
		System.out.println("Exemple Function:");
		exampleFunction();
		System.out.println("= - = - = - = - = -");
		System.out.println("Using a custom function that receives a function:");
		exampleFunctionFromFunction();
		System.out.println("= - = - = - = - = -");
	}
	
	public static void exampleFunctionFromFunction() {
		List<Product> list = new ArrayList<>();

		list.add(new Product("Tv", 900.00));
		list.add(new Product("Mouse", 50.00));
		list.add(new Product("Tablet", 350.50));
		list.add(new Product("HD Case", 80.90));
		
		ProductServices ps = new ProductServices();
		
		double sum = ps.filteredSum(list, p->p.getName().charAt(0)=='T');
		System.out.println("Sum Product with T: " + sum);
		sum = ps.filteredSum(list, p->p.getPrice()< 100);
		System.out.println("Sum Product price < 100: " + sum);
	}
	
	public static void exampleFunction() {
		List<Product> list = new ArrayList<>();

		list.add(new Product("Tv", 900.00));
		list.add(new Product("Mouse", 50.00));
		list.add(new Product("Tablet", 350.50));
		list.add(new Product("HD Case", 80.90));
		
//		List<String> names = list.stream().map(new UpperCaseName()).collect(Collectors.toList());
//		List<String> names = list.stream().map(Product::staticUpperCaseName).collect(Collectors.toList());
//		List<String> names = list.stream().map(Product::nonStaticUpperCaseName).collect(Collectors.toList());
		
//		Function<Product, String> func = p -> p.getName().toUpperCase();
//		List<String> names = list.stream().map(func).collect(Collectors.toList());
		
		List<String> names = list.stream().map(p -> p.getName().toUpperCase()).collect(Collectors.toList());
		
		names.forEach(System.out::println);
	}
	
	public static void exampleConsumer() {
		List<Product> list = new ArrayList<>();

		list.add(new Product("Tv", 900.00));
		list.add(new Product("Mouse", 50.00));
		list.add(new Product("Tablet", 350.50));
		list.add(new Product("HD Case", 80.90));
		
//		list.forEach(new PriceUpdate());
//		list.forEach(Product::staticPriceUpdate);
//		list.forEach(Product::nonStaticPriceUpdate);
		
		double factor = 1.1;
//		Consumer<Product> cons = p-> p.setPrice(p.getPrice()*factor);
//		list.forEach(cons);

		list.forEach(p-> p.setPrice(p.getPrice()*factor));
		
		list.forEach(System.out::println);
	}
	
	public static void examplePredicate() {
		List<Product> list = new ArrayList<>();

		list.add(new Product("Tv", 900.00));
		list.add(new Product("Mouse", 50.00));
		list.add(new Product("Tablet", 350.50));
		list.add(new Product("HD Case", 80.90));

		/*
		 * XXX o predicado pode ser usado de v�rias formas
		 * Podemos usar a implementa��o da interface
		 * 	EX: list.removeIf(new ProductPredicate());
		 * Podemos usar referencia � um metodo est�tico
		 * 	EX: list.removeIf(Product::staticProductPredicate);
		 * 
		 * Podemos usar referencia � um metodo n�o est�tico
		 * 	EX: list.removeIf(Product::nonStaticProductPredicate);
		 * 
		 * Podemos usar express�o lambda declarada
		 * 	EX:	Predicate<Product> pred = p -> p.getPrice()>=100.0;
		 *		list.removeIf(pred);
		 * 
		 * Podemos usar express�o lambda inline  
		 * 	EX: list.removeIf(p -> p.getPrice() >= min);
		 */
		

//		list.removeIf(new ProductPredicate());
		/* fazendo referencia para um metodo da classe
		 *   <nome da classe> :: <nome do metodo>
		 */
//		list.removeIf(Product::staticProductPredicate);
//		list.removeIf(Product::nonStaticProductPredicate);
		
		/*
		 * Declarando fun��o lambda e usando no removeIF
		 */
//		Predicate<Product> pred = p -> p.getPrice()>=100.0;
//		list.removeIf(pred);
		
		/*
		 * Fun��o lambda inline e com vari�vel sendo usada para o valor minimo
		 * dessa forma podemos parametrizar o filtro e inclusive usar input do usu�rio
		 * se assim quisermos
		 */
		double min = 100.0;
		list.removeIf(p -> p.getPrice() >= min);

		
		
		for (Product p : list) {
			System.out.println(p);
		}
	}

}

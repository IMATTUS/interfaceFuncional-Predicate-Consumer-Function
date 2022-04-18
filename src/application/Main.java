package application;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import entities.Product;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Exemple predicate:");
		examplePredicate();
		System.out.println("= - = - = - = - = -");

	}
	
	public static void examplePredicate() {
		List<Product> list = new ArrayList<>();

		list.add(new Product("Tv", 900.00));
		list.add(new Product("Mouse", 50.00));
		list.add(new Product("Tablet", 350.50));
		list.add(new Product("HD Case", 80.90));

		/*
		 * XXX o predicado pode ser usado de várias formas
		 * Podemos usar a implementação da interface
		 * 	EX: list.removeIf(new ProductPredicate());
		 * Podemos usar referencia à um metodo estático
		 * 	EX: list.removeIf(Product::staticProductPredicate);
		 * 
		 * Podemos usar referencia à um metodo não estático
		 * 	EX: list.removeIf(Product::nonStaticProductPredicate);
		 * 
		 * Podemos usar expressão lambda declarada
		 * 	EX:	Predicate<Product> pred = p -> p.getPrice()>=100.0;
		 *		list.removeIf(pred);
		 * 
		 * Podemos usar expressão lambda inline  
		 * 	EX: list.removeIf(p -> p.getPrice() >= min);
		 */
		

//		list.removeIf(new ProductPredicate());
		/* fazendo referencia para um metodo da classe
		 *   <nome da classe> :: <nome do metodo>
		 */
//		list.removeIf(Product::staticProductPredicate);
//		list.removeIf(Product::nonStaticProductPredicate);
		
		/*
		 * Declarando função lambda e usando no removeIF
		 */
//		Predicate<Product> pred = p -> p.getPrice()>=100.0;
//		list.removeIf(pred);
		
		/*
		 * Função lambda inline e com variável sendo usada para o valor minimo
		 * dessa forma podemos parametrizar o filtro e inclusive usar input do usuário
		 * se assim quisermos
		 */
		double min = 100.0;
		list.removeIf(p -> p.getPrice() >= min);

		
		
		for (Product p : list) {
			System.out.println(p);
		}
	}

}

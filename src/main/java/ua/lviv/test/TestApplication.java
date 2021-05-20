package ua.lviv.test;

import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ua.lviv.test.domain.Category;
import ua.lviv.test.service.CategoryService;

@SpringBootApplication
public class TestApplication implements CommandLineRunner {
	@Autowired
	private CategoryService categoryService;

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Scanner sc = new Scanner(System.in);

		while (true) {
			menu();

			switch (sc.next()) {
			case "1": {
				System.out.println("Введіть назву категорії: ");
				sc = new Scanner(System.in);
				String name = sc.next();
				System.out.println("Введіть ціну продукту: ");
				Integer price = sc.nextInt();
				System.out.println("Введіть кількість одиниць продукту: ");
				Integer quantity = sc.nextInt();
				categoryService.addCategory(new Category(name, price, quantity));
				break;
			}

			case "2": {
				System.out.println("Введіть назву категорії: ");
				sc = new Scanner(System.in);
				String name = sc.next();
				System.out.println("Введіть кількість одиниць продукту: ");
				Integer quantity = sc.nextInt();
//				Category category = categoryService.getAllCategories().stream()
//						.filter(x -> x.getCategoryname().toString().equalsIgnoreCase(name)).findAny().get();
//				category.setQuantity(quantity + category.getQuantity());
				categoryService.addItem(name, quantity);
				break;
			}
			case "3": {
				System.out.println("Введіть назву категорії: ");
				sc = new Scanner(System.in);
				String name = sc.next();

//				Category category = categoryService.getAllCategories().stream()
//						.filter(x -> x.getCategoryname().toString().equalsIgnoreCase(name)).findFirst().get();
//				category.setQuantity(category.getQuantity() - 1);
				categoryService.purchase(name);
				break;
			}
			case "4": {
				categoryService.getAllCategories().stream().filter(x -> x.getHaveItems() == true).sorted(Comparator.comparingInt(Category::getQuantity).reversed())
						.collect(Collectors.toList()).forEach(System.out::println);
				break;
			}

			case "5": {

				categoryService.clear();
				break;
			}
			}

		}
	}

	static void menu() {
		System.out.println("Натисніть 1, щоб додати нову категорію");
		System.out.println("Натисніть 2, щоб додати продукти у категорії");
		System.out.println("Натисніть 3, щоб придбати одиницю продукту");
		System.out.println("Натисніть 4, щоб вивести список категорій, які є в продажі");
		System.out.println("Натисніть 5, щоб заборонити продавати товар, якого немає на даний момент");
	}
}

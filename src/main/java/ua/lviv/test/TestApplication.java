package ua.lviv.test;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ua.lviv.test.domain.Degree;
import ua.lviv.test.domain.Lector;
import ua.lviv.test.service.LectorService;

@SpringBootApplication
public class TestApplication implements CommandLineRunner{
	@Autowired
	private LectorService lectorService;
	
	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}
	@Override
    public void run(String... args) throws Exception {

    	List<Lector> allLectors = lectorService.getAllLectors();
    	
  		Scanner sc = new Scanner(System.in);

		while (true) {
			menu();

			switch (sc.next()) {
			case "1": {
				System.out.println("Введіть назву відділу: ");
				sc = new Scanner(System.in);
				String name = sc.next();
				List<Lector> collect = allLectors.stream().filter(x -> x.getDepartment().getName().equalsIgnoreCase(name)).collect(Collectors.toList());
				long countOfAssist = collect.stream().filter(x -> x.getDegree().equals(Degree.ASSISTANT)).count();
				long countOfProf = collect.stream().filter(x -> x.getDegree().equals(Degree.PROFESSOR)).count();
				long countOfAssoc = collect.stream().filter(x -> x.getDegree().equals(Degree.ASSOCIATE_PROFESSOR)).count();
				System.out.println("assistans - " + countOfAssist + " associate professors - " + countOfAssoc + "  professors - " + countOfProf);
				break;
			}

			case "2": {
				System.out.println("Введіть назву відділу: ");
				sc = new Scanner(System.in);
				String name = sc.next();
		    	List<Lector> collect = allLectors.stream().filter(x -> x.getDepartment().getName().equalsIgnoreCase(name)).collect(Collectors.toList());
		    	double avg = 0;
		    	for (Lector lector : collect) {
					avg += lector.getSalary();
				}
		    	avg /= collect.size();
		    	System.out.println("Середня зарплата - " + avg);
				break;
			}

			case "3": {
				System.out.println("Введіть назву відділу: ");
				sc = new Scanner(System.in);
				String name = sc.next();
				
				long countOfEmployees = allLectors.stream().filter(x -> x.getDepartment().getName().equalsIgnoreCase(name)).count();
		    	System.out.println(countOfEmployees);
				
				break;
			}

			case "4": {
				System.out.println("Введіть ваш шаблон: ");
				sc = new Scanner(System.in);
				String template = sc.next();
				
				allLectors.stream().filter(x -> x.getFullName().contains(template)).collect(Collectors.toList()).forEach(System.out::println);
				break;
			}

			case "5": {
				System.out.println("Не зрозумів до кінця, що за завідуючий відділом)). Можливо потрібно було додати ще 1 value в Degree, але я не впевнений. В будь-якому разі, не думаю, що це було б складно реалізувати.");
				break;
			}
			}

		}
    }
	
	static void menu() {
		System.out.println("Натисніть 1, щоб вивести статистику відділу");
		System.out.println("Натисніть 2, щоб вивести середню зарплату працівників відділу");
		System.out.println("Натисніть 3, щоб вивести кількість співробітників у відділі");
		System.out.println("Натисніть 4, щоб шукати за шаблоном");
		System.out.println("Натисніть 5, щоб вивести завідуючого відділу");
	}
}

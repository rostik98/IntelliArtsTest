package ua.lviv.test.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.test.dao.CategoryRepository;
import ua.lviv.test.domain.Category;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public void addCategory(Category category) {
		categoryRepository.save(category);
	}
	
	public void addItem(String name, Integer items) {
		Category category = categoryRepository.findAll().stream()
		.filter(x -> x.getCategoryname().toString().equalsIgnoreCase(name)).findAny().get();
		category.addItems(items);
		categoryRepository.save(category);
		
	}
	
	public void purchase(String name) {
		Category category = categoryRepository.findAll().stream()
				.filter(x -> x.getCategoryname().toString().equalsIgnoreCase(name)).findFirst().get();
		category.setQuantity(category.getQuantity() - 1);
		categoryRepository.save(category);
	}
	
	public List<Category> getAllCategoriesWithItems() {
		return categoryRepository.findAll().stream().filter(x -> x.getHaveItems() == true).collect(Collectors.toList());
	}

	public void clear() {
		List<Category> filter = categoryRepository.findAll().stream().filter(x -> x.getQuantity() == 0).collect(Collectors.toList());
		filter.forEach(x -> x.setHaveItems(false));
//		List<Category> collect = filter.collect(Collectors.toList());
		System.out.println(filter);
		categoryRepository.saveAll(filter);
	}
	
	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}
}

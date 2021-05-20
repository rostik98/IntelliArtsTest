package ua.lviv.test.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.lviv.test.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}

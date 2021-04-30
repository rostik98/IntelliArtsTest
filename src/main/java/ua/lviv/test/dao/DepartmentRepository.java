package ua.lviv.test.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.lviv.test.domain.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}

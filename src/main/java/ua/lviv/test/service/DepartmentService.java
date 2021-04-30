package ua.lviv.test.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.test.dao.DepartmentRepository;
import ua.lviv.test.domain.Department;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	public void save(Department department) {
		departmentRepository.save(department);

	}

	public void delete(Department department) {
		if (findByName(department.getName()) == null) {
			departmentRepository.delete(department);
		}
	}

	public Department findByName(String name) {
		return departmentRepository.findAll().stream().filter(x -> x.getName().equalsIgnoreCase(name)).findFirst().get();
	}

	public List<Department> getAllDepartments() {
		return departmentRepository.findAll();
	}
}

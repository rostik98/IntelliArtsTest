package ua.lviv.test.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "lector")
public class Lector {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String fullName;
	private Integer salary;
	private Degree degree;
	@ManyToOne
	@JoinColumn(name = "department_id", referencedColumnName = "id")
	private Department department;
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public Degree getDegree() {
		return degree;
	}
	public void setDegree(Degree degree) {
		this.degree = degree;
	}
	public Lector() {
	}
	public Lector(Integer id, String fullName, Integer salary, Degree degree, Department department) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.salary = salary;
		this.degree = degree;
		this.department = department;
	}
	public Lector(String fullName, Integer salary, Degree degree, Department department) {
		super();
		this.fullName = fullName;
		this.salary = salary;
		this.degree = degree;
		this.department = department;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((degree == null) ? 0 : degree.hashCode());
		result = prime * result + ((department == null) ? 0 : department.hashCode());
		result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((salary == null) ? 0 : salary.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lector other = (Lector) obj;
		if (degree != other.degree)
			return false;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (fullName == null) {
			if (other.fullName != null)
				return false;
		} else if (!fullName.equals(other.fullName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (salary == null) {
			if (other.salary != null)
				return false;
		} else if (!salary.equals(other.salary))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Lector [id=" + id + ", fullName=" + fullName + ", salary=" + salary + ", degree=" + degree
				+ ", department=" + department + "]";
	}
}

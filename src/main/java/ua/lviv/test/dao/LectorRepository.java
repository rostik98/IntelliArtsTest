package ua.lviv.test.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.lviv.test.domain.Lector;

public interface LectorRepository extends JpaRepository<Lector, Integer> {
}

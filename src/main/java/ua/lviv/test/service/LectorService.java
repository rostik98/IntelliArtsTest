package ua.lviv.test.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.test.dao.LectorRepository;
import ua.lviv.test.domain.Lector;

@Service
public class LectorService {

	@Autowired
	private LectorRepository lectorRepository;

	public void save(Lector lector) {
		lectorRepository.save(lector);
	}

	public List<Lector> getAllLectors() {
		return lectorRepository.findAll();
	}
}

package ua.softserve.ita.service;

import ua.softserve.ita.model.CV;

import java.util.List;
import java.util.Optional;

public interface CVService {
    Optional<CV> findById(Long id);

    List<CV> findAll();

    CV save(CV cv);

    CV update(CV cv);

    void deleteById(Long id);

    CV findByUserId(Long id);
}

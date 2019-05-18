package ua.softserve.ita.dao.impl;

import org.springframework.stereotype.Repository;
import ua.softserve.ita.dao.VacancyDao;
import ua.softserve.ita.model.Vacancy;
import ua.softserve.ita.utility.QueryUtility;

import java.util.List;
import java.util.Optional;

@Repository
public class VacancyDaoImpl extends AbstractDao<Vacancy, Long> implements VacancyDao {
    private static final String ID = "id";
    private static final String NAME = "name";

    @Override
    @SuppressWarnings("unchecked")
    public List<Vacancy> findAllByCompanyNameWithPagination(String name, int first, int count) {
        return (List<Vacancy>)createNamedQuery(Vacancy.FIND_BY_COMPANY)
                .setParameter(NAME, name)
                .setFirstResult(first)
                .setMaxResults(count)
                .getResultList();
    }

    @Override
    public Long getCountOfVacancies(String name) {
        return (Long) createNamedQuery(Vacancy.FIND_COUNT_VACANCY)
                .setParameter(NAME, name)
                .getSingleResult();
    }

    @Override
    public Long getCountOfAllVacancies() {
        return (Long) createNamedQuery(Vacancy.FIND_COUNT_All_VACANCY)
                .getSingleResult();
    }

    @Override
    public Long getCountAllHotVacancies() {
        return (Long) createNamedQuery(Vacancy.FIND_COUNT_HOT_VACANCIES)
                .getSingleResult();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Vacancy> findAllVacanciesWithPagination(int first, int count) {
        return (List<Vacancy>)createNamedQuery(Vacancy.FIND_VACANCIES)
                .setFirstResult(first)
                .setMaxResults(count)
                .getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Vacancy> findAllHotVacanciesWithPagination(int first, int count) {
        return (List<Vacancy>)createNamedQuery(Vacancy.FIND_ALL_HOT_VACANCIES)
                .setFirstResult(first)
                .setMaxResults(count)
                .getResultList();
    }

    @Override
    public Optional<Vacancy> findByRequirementId(Long id) {
        return QueryUtility.findOrEmpty(() -> ((Vacancy) createNamedQuery(Vacancy.FIND_BY_REQUIREMENT)
                .setParameter(ID, id)
                .getSingleResult()));
    }

}

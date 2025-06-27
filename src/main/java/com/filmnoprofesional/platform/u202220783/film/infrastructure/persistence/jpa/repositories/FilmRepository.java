package com.filmnoprofesional.platform.u202220783.film.infrastructure.persistence.jpa.repositories;

import com.filmnoprofesional.platform.u202220783.film.domain.model.aggregates.Film;
import com.filmnoprofesional.platform.u202220783.film.domain.model.entities.FilmType;
import com.filmnoprofesional.platform.u202220783.film.domain.model.valueobjects.FilmCountry;
import com.filmnoprofesional.platform.u202220783.film.domain.model.valueobjects.FilmId;
import com.filmnoprofesional.platform.u202220783.film.domain.model.valueobjects.FilmName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Film Repository
 */
@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {

    /**
     * Check if a Film exists by Email Address
     *
     * @param name
     * @param filmCountry
     * @param filmType
     * @param filmId
     */
    boolean existsByNameAndFilmCountryAndFilmTypeAndFilmId(FilmName name, FilmCountry filmCountry, FilmType filmType, FilmId filmId);
}

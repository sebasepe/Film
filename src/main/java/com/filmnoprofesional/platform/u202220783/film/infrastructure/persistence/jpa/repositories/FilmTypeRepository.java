package com.filmnoprofesional.platform.u202220783.film.infrastructure.persistence.jpa.repositories;

import com.filmnoprofesional.platform.u202220783.film.domain.model.entities.FilmType;
import com.filmnoprofesional.platform.u202220783.film.domain.model.valueobjects.FilmTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * This interface is responsible for providing the FilmType entity related operations.
 * It extends the JpaRepository interface.
 */
@Repository
public interface FilmTypeRepository extends JpaRepository<FilmType, Long> {

    /**
     * This method is responsible for finding the role by name.
     * @param name The role name.
     * @return The role object.
     */
    Optional<FilmType> findByName(FilmTypes name);

    /**
     * This method is responsible for checking if the role exists by name.
     * @param name The role name.
     * @return True if the role exists, false otherwise.
     */
    boolean existsByName(FilmTypes name);

}







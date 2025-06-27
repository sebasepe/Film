package com.filmnoprofesional.platform.u202220783.film.interfaces.rest.transform;

import com.filmnoprofesional.platform.u202220783.film.domain.model.aggregates.Film;
import com.filmnoprofesional.platform.u202220783.film.domain.model.entities.FilmType;
import com.filmnoprofesional.platform.u202220783.film.interfaces.rest.resources.FilmResource;
import com.filmnoprofesional.platform.u202220783.shared.domain.model.valueobjects.RegisterEmailAddress;
import jakarta.persistence.Embedded;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.util.Date;

/**
 * Assembler to convert a Film entity to a FilmResource.
 */
public class FilmResourceFromEntityAssembler {
    /**
     * Converts a Film entity to a FilmResource.
     * @param entity The {@link Film} entity to convert.
     * @return The {@link FilmResource} resource.
     */
    public static FilmResource toResourceFromEntity(Film entity) {
        return new FilmResource(
                entity.getId(),
                entity.getFilmId().filmId(),
                entity.getName().value(),
                entity.getEmailAddress().value(),
                entity.getFilmType().toString(),
                entity.getFilmCountry().value(),
                entity.getLanguage().value(),
                entity.getDirector().value(),
                entity.getFilmDateAt()
        );
    }
}



package com.filmnoprofesional.platform.u202220783.film.interfaces.rest.transform;

import com.filmnoprofesional.platform.u202220783.film.domain.model.commands.CreateFilmCommand;
import com.filmnoprofesional.platform.u202220783.film.interfaces.rest.resources.CreateFilmResource;

import java.util.Date;

/**
 * Assembler to convert a CreateFilmResource to a CreateFilmCommand.
 */
public class CreateFilmCommandFromResourceAssembler {
    /**
     * Converts a CreateFilmResource to a CreateFilmCommand.
     *
     * @param resource The {@link CreateFilmResource} resource to convert.
     * @return The {@link CreateFilmCommand} command that results from the conversion.
     */
    public static CreateFilmCommand toCommandFromResource(CreateFilmResource resource, Long filmId) {
        return new CreateFilmCommand(
                filmId,
                resource.name(),
                resource.emailAddress(),
                resource.filmType(),
                resource.filmCountry(),
                resource.language(),
                resource.director(),
                resource.filmDateAt()
        );
    }
}



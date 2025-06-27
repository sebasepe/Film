package com.filmnoprofesional.platform.u202220783.film.domain.services;


import com.filmnoprofesional.platform.u202220783.film.domain.model.commands.SeedFilmTypesCommand;

/**
 * FilmType command service
 * <p>
 *     This interface represents the service to handle role commands.
 * </p>
 */
public interface FilmTypeCommandService {
    /**
     * Handle seed roles command
     * @param command the {@link SeedFilmTypesCommand} command
     *
     */
    void handle(SeedFilmTypesCommand command);
}


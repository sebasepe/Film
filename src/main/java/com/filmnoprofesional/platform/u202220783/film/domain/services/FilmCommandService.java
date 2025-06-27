package com.filmnoprofesional.platform.u202220783.film.domain.services;

import com.filmnoprofesional.platform.u202220783.film.domain.model.aggregates.Film;
import com.filmnoprofesional.platform.u202220783.film.domain.model.commands.CreateFilmCommand;

import java.util.Optional;

/**
 * Film Command Service
 */
public interface FilmCommandService {

    /**
     * Handle Create Film Command
     *
     * @param command The {@link CreateFilmCommand} Command
     * @return A {@link Film} instance if the command is valid, otherwise empty
     * @throws IllegalArgumentException if the email address already exists
     */
    Optional<Film> handle(CreateFilmCommand command);
}

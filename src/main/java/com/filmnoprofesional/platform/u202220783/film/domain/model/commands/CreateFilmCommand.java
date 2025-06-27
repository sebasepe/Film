package com.filmnoprofesional.platform.u202220783.film.domain.model.commands;

import java.util.Date;

/**
 * Create Film Command
 */
public record CreateFilmCommand(
        Long filmId,
        String name,
        String emailAddress,
        String filmType,
        String filmCountry,
        String language,
        String director,
        Date filmDateAt
) {
}

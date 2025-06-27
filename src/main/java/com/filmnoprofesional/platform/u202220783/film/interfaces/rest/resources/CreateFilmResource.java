package com.filmnoprofesional.platform.u202220783.film.interfaces.rest.resources;

import java.util.Date;

public record CreateFilmResource(
        String name,
        String emailAddress,
        String filmType,
        String filmCountry,
        String language,
        String director,
        Date filmDateAt
) {
}

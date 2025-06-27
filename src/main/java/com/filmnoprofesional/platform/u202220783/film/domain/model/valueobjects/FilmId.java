package com.filmnoprofesional.platform.u202220783.film.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

/**
 * FilmId value object
 * @summary
 * This value object represents the unique identifier of a film.
 * The filmId must be greater than 0. It throws an IllegalArgumentException if the filmId is null or less than or equal to 0.
 * @see IllegalArgumentException
 * @since 1.0
 */
@Embeddable
public record FilmId(Long filmId) {

    public FilmId {
        if (filmId == null || filmId < 0) {
            throw new IllegalArgumentException("FilmId cannot be null or less than or equal to 0");
        }
    }
}

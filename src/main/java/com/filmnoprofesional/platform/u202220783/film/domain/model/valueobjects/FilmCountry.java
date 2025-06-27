package com.filmnoprofesional.platform.u202220783.film.domain.model.valueobjects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Size;

@Embeddable
public record FilmCountry(
        @Column(name="film_country")
        @Size(max = 250)
        String value
) {
}

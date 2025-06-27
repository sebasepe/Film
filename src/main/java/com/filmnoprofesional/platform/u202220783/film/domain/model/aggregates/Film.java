package com.filmnoprofesional.platform.u202220783.film.domain.model.aggregates;

import com.filmnoprofesional.platform.u202220783.film.domain.model.commands.CreateFilmCommand;
import com.filmnoprofesional.platform.u202220783.film.domain.model.entities.FilmType;
import com.filmnoprofesional.platform.u202220783.film.domain.model.valueobjects.*;
import com.filmnoprofesional.platform.u202220783.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import com.filmnoprofesional.platform.u202220783.shared.domain.model.valueobjects.RegisterEmailAddress;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


/**
 * Film aggregate root
 * This class represents the aggregate root for the Film entity.
 *
 * @see AuditableAbstractAggregateRoot
 */
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Film extends AuditableAbstractAggregateRoot<Film> {

    @Embedded
    FilmId filmId;

    @Embedded
    private FilmName name;

    @Embedded
    private RegisterEmailAddress emailAddress;

    @Getter
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "film_type_id", nullable = false, unique = false)
    private FilmType filmType;

    @Embedded
    private FilmCountry filmCountry;

    @Embedded
    private FilmLanguage language;

    @Embedded
    private FilmDirector director;

    private Date filmDateAt;

    public Film(CreateFilmCommand command, FilmType type) {
        if(command.filmId() == null) throw new IllegalArgumentException("Film id is required");
        if(command.name() == null) throw new IllegalArgumentException("Film id is required");
        if(command.emailAddress() == null) throw new IllegalArgumentException("Email address is required");
        if(command.filmCountry() == null) throw new IllegalArgumentException("Film id is required");
        if(command.language() == null) throw new IllegalArgumentException("Film id is required");
        if(command.director() == null) throw new IllegalArgumentException("Film id is required");
        if(command.filmDateAt() == null) throw new IllegalArgumentException("Film date is required");

        this.filmId = new FilmId(command.filmId());
        this.name = new FilmName(command.name());
        this.emailAddress = new RegisterEmailAddress(command.emailAddress());
        this.filmType = type;
        this.filmCountry = new FilmCountry(command.filmCountry());
        this.language = new FilmLanguage(command.language());
        this.director = new FilmDirector(command.director());
        this.filmDateAt = command.filmDateAt();
    }
}



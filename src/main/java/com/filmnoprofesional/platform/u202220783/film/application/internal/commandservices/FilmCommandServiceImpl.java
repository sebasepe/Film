package com.filmnoprofesional.platform.u202220783.film.application.internal.commandservices;

import com.filmnoprofesional.platform.u202220783.film.domain.model.aggregates.Film;
import com.filmnoprofesional.platform.u202220783.film.domain.model.commands.CreateFilmCommand;
import com.filmnoprofesional.platform.u202220783.film.domain.model.entities.FilmType;
import com.filmnoprofesional.platform.u202220783.film.domain.model.valueobjects.FilmCountry;
import com.filmnoprofesional.platform.u202220783.film.domain.model.valueobjects.FilmId;
import com.filmnoprofesional.platform.u202220783.film.domain.model.valueobjects.FilmName;
import com.filmnoprofesional.platform.u202220783.film.domain.model.valueobjects.FilmTypes;
import com.filmnoprofesional.platform.u202220783.film.domain.services.FilmCommandService;
import com.filmnoprofesional.platform.u202220783.film.infrastructure.persistence.jpa.repositories.FilmRepository;
import com.filmnoprofesional.platform.u202220783.film.infrastructure.persistence.jpa.repositories.FilmTypeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FilmCommandServiceImpl implements FilmCommandService {

    private final FilmRepository filmRepository;
    private final FilmTypeRepository filmTypeRepository;

    public FilmCommandServiceImpl(FilmRepository filmRepository, FilmTypeRepository filmTypeRepository) {
        this.filmRepository = filmRepository;
        this.filmTypeRepository = filmTypeRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Film> handle(CreateFilmCommand command) {
        FilmType type = filmTypeRepository.findByName(FilmTypes.valueOf(command.filmType())).orElseThrow(() -> new IllegalArgumentException("Film type " + command.filmType() + " does not exist."));

        //var type = filmTypeRepository.findByName(FilmTypes.valueOf(command.filmType()));
        //if(type.isEmpty()) throw new IllegalArgumentException("Film type " + command.filmType() + " does not exist.");

        boolean alreadyExists = this.filmRepository.existsByNameAndFilmCountryAndFilmTypeAndFilmId(
                new FilmName(command.name()),
                new FilmCountry(command.filmCountry()),
                type, // o type.get() con la segunda forma
                new FilmId(command.filmId())
        );

        if(alreadyExists) throw new IllegalArgumentException("A movie with the specified name, film country, type and filmId already exists.");

        Film film = new Film(command, type);

        this.filmRepository.save(film);

        return Optional.of(film);
    }
}



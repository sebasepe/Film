package com.filmnoprofesional.platform.u202220783.film.application.internal.commandservices;

import com.filmnoprofesional.platform.u202220783.film.domain.model.commands.SeedFilmTypesCommand;
import com.filmnoprofesional.platform.u202220783.film.domain.model.entities.FilmType;
import com.filmnoprofesional.platform.u202220783.film.domain.model.valueobjects.FilmTypes;
import com.filmnoprofesional.platform.u202220783.film.domain.services.FilmTypeCommandService;
import com.filmnoprofesional.platform.u202220783.film.infrastructure.persistence.jpa.repositories.FilmTypeRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * Implementation of {@link FilmTypeCommandService} to handle {@link SeedFilmTypesCommand}
 */
@Service
public class FilmTypeCommandServiceImpl implements FilmTypeCommandService {

    private final FilmTypeRepository roleRepository;

    public FilmTypeCommandServiceImpl(FilmTypeRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    /**
     * This method will handle the {@link SeedFilmTypesCommand} and will create the roles if not exists
     * @param command {@link SeedFilmTypesCommand}
     * @see SeedFilmTypesCommand
     */
    @Override
    public void handle(SeedFilmTypesCommand command) {
        Arrays.stream(FilmTypes.values()).forEach(role -> {
            if(!roleRepository.existsByName(role)) {
                roleRepository.save(new FilmType(FilmTypes.valueOf(role.name())));
            }
        } );
    }
}



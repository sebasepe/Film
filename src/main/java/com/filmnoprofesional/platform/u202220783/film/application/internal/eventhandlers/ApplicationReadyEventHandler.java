package com.filmnoprofesional.platform.u202220783.film.application.internal.eventhandlers;

import com.filmnoprofesional.platform.u202220783.film.domain.model.commands.SeedFilmTypesCommand;
import com.filmnoprofesional.platform.u202220783.film.domain.services.FilmTypeCommandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

/**
 * ApplicationReadyEventHandler class
 * This class is used to handle the ApplicationReadyEvent
 */
@Service
public class ApplicationReadyEventHandler {
    private final FilmTypeCommandService filmTypeCommandService;
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationReadyEventHandler.class);

    public ApplicationReadyEventHandler(FilmTypeCommandService filmTypeCommandService) {
        this.filmTypeCommandService = filmTypeCommandService;
    }

    /**
     * Handle the ApplicationReadyEvent
     * This method is used to seed the filmTypes
     * @param event the ApplicationReadyEvent the event to handle
     */
    @EventListener
    public void on(ApplicationReadyEvent event) {
        var applicationName = event.getApplicationContext().getId();
        LOGGER.info("Starting to verify if filmTypes seeding is needed for {} at {}", applicationName, currentTimestamp());


        var seedFilmTypesCommand = new SeedFilmTypesCommand();
        filmTypeCommandService.handle(seedFilmTypesCommand);


        LOGGER.info("FilmTypes seeding verification finished for {} at {}", applicationName, currentTimestamp());
    }

    private Timestamp currentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }
}



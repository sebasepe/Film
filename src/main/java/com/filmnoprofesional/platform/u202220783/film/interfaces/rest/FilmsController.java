package com.filmnoprofesional.platform.u202220783.film.interfaces.rest;

import com.filmnoprofesional.platform.u202220783.film.domain.services.FilmCommandService;
import com.filmnoprofesional.platform.u202220783.film.interfaces.rest.resources.CreateFilmResource;
import com.filmnoprofesional.platform.u202220783.film.interfaces.rest.resources.FilmResource;
import com.filmnoprofesional.platform.u202220783.film.interfaces.rest.transform.CreateFilmCommandFromResourceAssembler;
import com.filmnoprofesional.platform.u202220783.film.interfaces.rest.transform.FilmResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * FilmsController
 */
@RestController
@RequestMapping(value = "/api/v1/films", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Films", description = "Available Film Endpoints")
public class FilmsController {
    private final FilmCommandService filmCommandService;

    /**
     * Constructor
     * @param filmCommandService The {@link FilmCommandService} instance
     */
    public FilmsController(FilmCommandService filmCommandService) {
        this.filmCommandService = filmCommandService;
    }

    /**
     * Create a new film
     * @param resource The {@link CreateFilmResource} instance
     * @return A {@link FilmResource} resource for the created film, or a bad request response if the film could not be created.
     */
    @PostMapping(path = "/{filmId}")
    @Operation(summary = "Create a new film")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Film created"),
            @ApiResponse(responseCode = "400", description = "Bad request")})
    public ResponseEntity<FilmResource> createFilm(@RequestBody CreateFilmResource resource, @PathVariable Long filmId) {
        
        var createFilmCommand = CreateFilmCommandFromResourceAssembler.toCommandFromResource(resource, filmId);
        var film = filmCommandService.handle(createFilmCommand);
        if (film.isEmpty()) return ResponseEntity.badRequest().build();
        var createdFilm = film.get();
        var filmResource = FilmResourceFromEntityAssembler.toResourceFromEntity(createdFilm);
        return new ResponseEntity<>(filmResource, HttpStatus.CREATED);
    }
}

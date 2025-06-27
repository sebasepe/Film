package com.filmnoprofesional.platform.u202220783.film.domain.model.entities;

import com.filmnoprofesional.platform.u202220783.film.domain.model.valueobjects.FilmTypes;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

import java.util.List;

/**
 * FilmType entity
 * <p>
 *     This entity represents the role of a user in the system.
 *     It is used to define the permissions of a user.
 * </p>
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@With
public class FilmType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private FilmTypes name;

    public FilmType(FilmTypes name) {
        this.name = name;
    }

    /**
     * Get the name of the role as a string
     * @return the name of the role as a string
     */
    public String getStringName() {
        return name.name();
    }

    /**
     * Get the default role
     * @return the default role
     */
    public static FilmType getDefaultFilmType() {
        return new FilmType(FilmTypes.HORROR);
    }

    /**
     * Get the role from its name
     * @param name the name of the role
     * @return the role
     */
    public static FilmType toFilmTypeFromName(String name) {
        return new FilmType(FilmTypes.valueOf(name));
    }

    /**
     * Validate the role set
     * <p>
     *     This method validates the role set and returns the default role if the set is empty.
     * </p>
     * @param roles the role set
     * @return the role set
     */
    public static List<FilmType> validateFilmTypeSet(List<FilmType> roles) {
        if (roles == null || roles.isEmpty()) {
            return List.of(getDefaultFilmType());
        }
        return roles;
    }

}





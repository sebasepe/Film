package com.filmnoprofesional.platform.u202220783.shared.domain.model.valueobjects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Size;

@Embeddable
public record RegisterEmailAddress(
        @Column(name="register_email_address")
        @Size(max = 250)
        String value
) {
}

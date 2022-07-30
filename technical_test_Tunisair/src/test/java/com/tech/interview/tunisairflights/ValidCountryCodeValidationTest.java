package com.tech.interview.tunisairflights;

import com.tech.interview.tunisairflights.domain.TunisAirRequest;
import com.tech.interview.tunisairflights.util.validator.country.ValidCountryCodeValidator;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintValidatorContext;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;

/**
 * Valid country code format
 */
public class ValidCountryCodeValidationTest {


    ValidCountryCodeValidator validCountryCodeValidator;
    ConstraintValidatorContext validCountryCodeconstraintValidatorContext;
    TunisAirRequest tunisAirRequest;

    @BeforeEach
    public void setUp() {
        validCountryCodeconstraintValidatorContext = mock(ConstraintValidatorContext.class);
        validCountryCodeValidator = new ValidCountryCodeValidator();
        tunisAirRequest = new TunisAirRequest("AAA", "TUN", "27/07/2022", StringUtils.EMPTY);

    }

    @Test
    public void givenInvalidCountryCode_whenValidate_thenReturnInvalid() {
        assertFalse(validCountryCodeValidator.isValid(tunisAirRequest.getOrigin(), validCountryCodeconstraintValidatorContext));
    }

}

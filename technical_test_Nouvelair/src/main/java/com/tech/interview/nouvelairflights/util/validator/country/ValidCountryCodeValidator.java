package com.tech.interview.nouvelairflights.util.validator.country;

import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.*;

/**
 * Validator to validate the ISO Country code.
 *
 */
public class ValidCountryCodeValidator implements ConstraintValidator<ValidCountryCode, String> {

    private static final List<String> ISO_COUNTRIES = new ArrayList<>(Locale.getISOCountries(Locale.IsoCountryCode.PART1_ALPHA3));

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return StringUtils.isEmpty(value) || ISO_COUNTRIES.contains(value);
    }
}
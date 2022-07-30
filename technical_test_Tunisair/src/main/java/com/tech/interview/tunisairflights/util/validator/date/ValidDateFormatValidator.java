package com.tech.interview.tunisairflights.util.validator.date;

import com.tech.interview.tunisairflights.enums.DateFormat;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.internal.engine.constraintvalidation.ConstraintValidatorContextImpl;
import org.hibernate.validator.internal.metadata.descriptor.ConstraintDescriptorImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/**
 * Validator to validate the date format.
 */
public class ValidDateFormatValidator implements ConstraintValidator<ValidDateFormat, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        DateFormat dateFormat = (DateFormat) ((ConstraintDescriptorImpl) ((ConstraintValidatorContextImpl) constraintValidatorContext).getConstraintDescriptor()).getAnnotationDescriptor().getAttribute("requireddateformat");
        if (StringUtils.isNotEmpty(value)) {
            try {
                LocalDate.parse(value, DateFormat.ISO_LOCAL_DATE.getDateTimeFormatter());
            } catch (DateTimeParseException exception) {
                return false;
            }
        }
        return true;

    }
}
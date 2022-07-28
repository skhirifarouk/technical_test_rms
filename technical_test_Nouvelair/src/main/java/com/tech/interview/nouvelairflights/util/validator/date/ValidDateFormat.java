package com.tech.interview.nouvelairflights.util.validator.date;

import com.tech.interview.nouvelairflights.enums.DateFormat;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Annotation to validate the date format.
 *
 */
@Target({FIELD, PARAMETER})
@Retention(RUNTIME)
@Constraint(validatedBy = ValidDateFormatValidator.class)
@Documented
public @interface ValidDateFormat {
    String message() default "invalid date format";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
    // Required date format
    DateFormat requireddateformat();
}

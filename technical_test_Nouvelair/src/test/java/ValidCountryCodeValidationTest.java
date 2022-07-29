import com.tech.interview.nouvelairflights.util.validator.country.ValidCountryCodeValidator;
import com.tech.interview.nouvelairflights.domain.NouvelairRequest;
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
    NouvelairRequest nouvelairRequest;

    @BeforeEach
    public void setUp() {
        validCountryCodeconstraintValidatorContext = mock(ConstraintValidatorContext.class);
        validCountryCodeValidator = new ValidCountryCodeValidator();
        nouvelairRequest = new NouvelairRequest("AAA", "TUN", "27/07/2022", StringUtils.EMPTY, 5);

    }

    @Test
    public void givenInvalidCountryCode_whenValidate_thenReturnInvalid() {
        assertFalse(validCountryCodeValidator.isValid(nouvelairRequest.getFrom(), validCountryCodeconstraintValidatorContext));
    }

}

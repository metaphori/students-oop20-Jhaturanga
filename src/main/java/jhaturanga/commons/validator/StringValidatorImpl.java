package jhaturanga.commons.validator;

import java.util.function.Function;
import java.util.ArrayList;
import java.util.List;
import jhaturanga.commons.validator.StringValidatorImpl.ValidationResult;

import static jhaturanga.commons.validator.StringValidatorImpl.ValidationResult.CORRECT;

/**
 * A String Validator that evaluate all functions added and drop on first that is not CORRECT.
 *
 */
public final class StringValidatorImpl implements FunctionConcatenator<String, ValidationResult> {

    private final List<Function<String, ValidationResult>> rules = new ArrayList<>();

    @Override
    public FunctionConcatenator<String, ValidationResult> add(final Function<String, ValidationResult> function) {
        this.rules.add(function);
        return this;
    }

    @Override
    public Function<String, ValidationResult> build() {
        return s -> this.rules.stream()
                .map(x -> x.apply(s))
                .dropWhile(CORRECT::equals)
                .findFirst().orElse(CORRECT);
    }

    /**
    *
    * The Result of the Validation.
    */
   public enum ValidationResult {

       /**
        * The string is correct.
        */
       CORRECT("Correct"),

       /**
        * The string is empty.
        */
       EMPTY("Empty"),

       /**
        * The string is too short.
        */
       TOO_SHORT("Too short"),

       /**
        * The string is too long.
        */
       TOO_LONG("Too long"),

       /**
        * The string contains forbidden strings.
        */
       FORBIDDEN("Forbidden");

       private String message; 

       ValidationResult(final String message) {
           this.message = message;
       }

       public String getMessage() {
           return this.message;
       }
   }

}

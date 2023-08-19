package onlineShopV1.beans;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {ImageValidator.class})
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Image {

    String message() default "file content must img file, min img file is 500KB, max img file is 1MB, extension file must (jpeg, jpg, png)";

    Class<?>[] groups() default {};

    Class<? extends Payload[]>[] payload() default {};

}

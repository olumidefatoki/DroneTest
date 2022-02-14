package com.musala.drone.validation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Documented
@Constraint(validatedBy = EnumValidator.class)
public @interface EnumValidation {
    Class<? extends Enum> enumClass();

    String message() default "Invalid enum type";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

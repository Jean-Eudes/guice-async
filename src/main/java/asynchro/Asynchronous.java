package asynchro;


import static java.lang.annotation.ElementType.METHOD;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Target(value = {METHOD, TYPE})
@Retention(value = RUNTIME)
public @interface Asynchronous {

}

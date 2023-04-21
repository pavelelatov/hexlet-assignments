package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
public class Validator {

    public static List<String> validate(Address address) {
        List<String> result = new ArrayList<>();

        for (Field f : address.getClass().getDeclaredFields()) {
            if (f.isAnnotationPresent(NotNull.class)) {
                try {
                    f.setAccessible(true);
                    if (f.get(address) == null) {
                        result.add(f.getName());
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("Cannot get access to field " + f.getName());
                }
            }
        }

        return result;
    }

    public static Map<String, List<String>> advancedValidate(Address address) {
        Map<String, List<String>> result = new HashMap<>();

        for (Field f : address.getClass().getDeclaredFields()) {
            try {
                List<String> fieldViolations = new ArrayList<>();

                if (f.isAnnotationPresent(NotNull.class)) {
                    f.setAccessible(true);
                    if (f.get(address) == null) {
                        fieldViolations.add("can not be null");
                    }
                }

                if (f.isAnnotationPresent(MinLength.class)) {
                    MinLength ann = f.getAnnotation(MinLength.class);
                    if (f.get(address) != null
                            && ((String) f.get(address)).length() < ann.minLength()) {
                        fieldViolations.add("length less than " + ann.minLength());
                    }
                }

                if (!fieldViolations.isEmpty()) {
                    result.put(f.getName(), fieldViolations);
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Cannot get access to field " + f.getName());
            }
        }

        return result;
    }
}
// END

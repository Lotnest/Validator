package lotnest;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Validator {

    /**
     * Validates whether one object is equal to another.
     *
     * @param t1 Any object
     * @param t2 Another object
     * @return true if objects are equal, false otherwise
     * @since 1.0-SNAPSHOT
     * @author Lotnest
     */
    public <T> boolean equals(T t1, T t2) {
        if (t1 == t2) return true;
        if (t1 == null || t2 == null || t1.getClass() != t2.getClass()) return false;
        return t1.equals(t2);
    }

    public static <T> T notNull(T t) {
        if (t == null) {
            try {
                throw new ValidatorException("Object can not be null");
            } catch (ValidatorException e) {
                e.printStackTrace();
            }
        }
        return t;
    }

    public static <T> T notNull(T t, String objectName) {
        if (t == null) try {
            throw new ValidatorException(objectName + " can not be null");
        } catch (ValidatorException e) {
            e.printStackTrace();
        }
        return t;
    }

    public static <T> boolean isNull(T t) { return t == null; }

    public static <T> T notContains(T t, List<T> list) {
        if (list.contains(t)) try {
            throw new ValidatorException("List must not contain " + t.toString());
        } catch (ValidatorException e) {
            e.printStackTrace();
        }
        return t;
    }

    public static <T> boolean notContains(T t, Set<T> set) {
        if (set.contains(t)) try {
            throw new ValidatorException("Set must not contain " + t.toString());
        } catch (ValidatorException e) {
            e.printStackTrace();
        }
        return true;
    }

    @SafeVarargs
    public static <T> boolean notContains(T t, T... array) {
        if (Arrays.asList(array).contains(t)) try {
            throw new ValidatorException("Array must not contain " + t.toString());
        } catch (ValidatorException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static <T> boolean isUppercase(T t) {
        if (t instanceof Integer || t instanceof Short || t instanceof Byte || t instanceof Long || t instanceof Double || t instanceof Float) return false;
        String string = String.valueOf(t);
        char[] array = string.toCharArray();
        for (char c : array) {
            if (!Character.isUpperCase(c)) return false;
        }
        return true;
    }

    public static <T> boolean isLowercase(T t) {
        if (t instanceof Integer || t instanceof Short || t instanceof Byte || t instanceof Long || t instanceof Double || t instanceof Float) return false;
        String string = String.valueOf(t);
        char[] array = string.toCharArray();
        for (char c : array) {
            if (Character.isUpperCase(c)) return false;
        }
        return true;
    }
}
package lotnest;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Validator {

   public static <T> T notNull(T t) {
        if (t == null) {
            try {
                throw new ValidatorException("Object must not be null");
            } catch (ValidatorException e) {
                e.printStackTrace();
            }
        }
        return t;
    }

    public static <T> T notNull(T t, String objectName) {
        notEmpty(objectName, "Name");
        if (t == null) try {
            throw new ValidatorException(objectName + " must not be null");
        } catch (ValidatorException e) {
            e.printStackTrace();
        }
        return t;
    }

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
        notNull(t1);
        notNull(t2);
        if (t1 == t2) return true;
        if (t1 == null || t2 == null || t1.getClass() != t2.getClass()) return false;
        return t1.equals(t2);
    }

    public static <T> boolean isNull(T t) { return t == null; }

    public static String notEmpty(String string) {
        notNull(string, "String");
        if (string.equals("") || string.equals(" ")) try {
            throw new ValidatorException("String must not be empty");
        } catch (ValidatorException e) {
            e.printStackTrace();
        }
        return string;
    }

    public static String notEmpty(String string, String stringName) {
        notNull(string, notEmpty(stringName));
        if (string.equals("") || string.equals(" ")) try {
            throw new ValidatorException(stringName + " must not be empty");
        } catch (ValidatorException e) {
            e.printStackTrace();
        }
        return string;
    }

    public static <E> List<E> notEmpty(List<E> list) {
        notNull(list, "List");
        if (list.isEmpty()) try {
            throw new ValidatorException("List must not be empty");
        } catch (ValidatorException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static <E> List<E> notEmpty(List<E> list, String listName) {
        notNull(list, notEmpty(listName));
        if (list.isEmpty()) try {
            throw new ValidatorException(listName + " must not be empty");
        } catch (ValidatorException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static <E> Set<E> notEmpty(Set<E> set) {
        notNull(set, "Set");
        if (set.isEmpty()) try {
            throw new ValidatorException("Set must not be empty");
        } catch (ValidatorException e) {
            e.printStackTrace();
        }
        return set;
    }

    public static <E> Set<E> notEmpty(Set<E> set, String setName) {
        notNull(set, notEmpty(setName));
        if (set.isEmpty()) try {
            throw new ValidatorException(setName + " must not be empty");
        } catch (ValidatorException e) {
            e.printStackTrace();
        }
        return set;
    }

    public static <E> E[] notEmpty(E[] array) {
        notNull(array, "Array");
        if (array.length == 0) try {
            throw new ValidatorException("Array must not be empty");
        } catch (ValidatorException e) {
            e.printStackTrace();
        }
        return array;
    }

    public static <E> E[] notEmpty(E[] array, String arrayName) {
        notNull(array, notEmpty(arrayName));
        if (array.length == 0) try {
            throw new ValidatorException(arrayName + " must not be empty");
        } catch (ValidatorException e) {
            e.printStackTrace();
        }
        return array;
    }

    public static <E> List<E> notContains(E e, List<E> list) {
        notNull(list, "List");
        if (list.contains(e)) try {
            throw new ValidatorException("List must not contain " + e.toString());
        } catch (ValidatorException e1) {
            e1.printStackTrace();
        }
        return list;
    }

    public static <E> List<E> notContains(E e, List<E> list, String listName) {
        notNull(e);
        notNull(list, notEmpty(listName));
        if (list.contains(e)) try {
            throw new ValidatorException(listName + " must not contain " + e.toString());
        } catch (ValidatorException e1) {
            e1.printStackTrace();
        }
        return list;
    }

    public static <E> boolean notContains(E e, Set<E> set) {
        notNull(e);
        notNull(set, "Set");
        if (set.contains(e)) try {
            throw new ValidatorException("Set must not contain " + e.toString());
        } catch (ValidatorException e1) {
            e1.printStackTrace();
        }
        return true;
    }

    public static <E> boolean notContains(E e, Set<E> set, String setName) {
        notNull(e);
        notNull(set, notEmpty(setName));
        if (set.contains(e)) try {
            throw new ValidatorException(setName + " must not contain " + e.toString());
        } catch (ValidatorException e1) {
            e1.printStackTrace();
        }
        return true;
    }

    public static <E> boolean notContains(E e, E[] array) {
        notNull(e);
        notNull(array);
        if (Arrays.asList(array).contains(e)) try {
            throw new ValidatorException("Array must not contain " + e.toString());
        } catch (ValidatorException e1) {
            e1.printStackTrace();
        }
        return true;
    }

    public static <E> boolean notContains(E e, E[] array, String arrayName) {
        notNull(e);
        notNull(array, notEmpty(arrayName));
        if (Arrays.asList(array).contains(e)) try {
            throw new ValidatorException(arrayName + " must not contain " + e.toString());
        } catch (ValidatorException e1) {
            e1.printStackTrace();
        }
        return true;
    }

    public static <T> boolean isUppercase(T t) {
        notNull(t);
        if (t instanceof Integer || t instanceof Short || t instanceof Byte || t instanceof Long || t instanceof Double || t instanceof Float) return false;
        String string = String.valueOf(t);
        char[] array = string.toCharArray();
        for (char c : array) {
            if (!Character.isUpperCase(c)) return false;
        }
        return true;
    }

    public static <T> boolean isLowercase(T t) {
        notNull(t);
        if (t instanceof Integer || t instanceof Short || t instanceof Byte || t instanceof Long || t instanceof Double || t instanceof Float) return false;
        String string = String.valueOf(t);
        char[] array = string.toCharArray();
        for (char c : array) {
            if (Character.isUpperCase(c)) return false;
        }
        return true;
    }

    public static <T> boolean isFirstLetterUppercase(T t) {
        notNull(t);
        if (t instanceof Integer || t instanceof Short || t instanceof Byte || t instanceof Long || t instanceof Double || t instanceof Float) return false;
        return Character.isUpperCase(String.valueOf(t).toCharArray()[0]);
    }

    public static <T> boolean isFirstLetterLowercase(T t) {
        notNull(t);
        if (t instanceof Integer || t instanceof Short || t instanceof Byte || t instanceof Long || t instanceof Double || t instanceof Float) return false;
        return Character.isLowerCase(String.valueOf(t).toCharArray()[0]);
    }

    public static boolean matches(CharSequence input, String regex) {
        notNull(input);
        notEmpty(regex);
        return Pattern.compile(regex).matcher(input).matches();
    }

    public static boolean requireFalse(boolean b) {
        if (b) try {
            throw new ValidatorException("Boolean must be false");
        } catch (ValidatorException e) {
            e.printStackTrace();
        }
        return b;
    }

    public static boolean requireFalse(boolean b, String booleanName) {
        if (b) try {
            throw new ValidatorException(booleanName + " must be false");
        } catch (ValidatorException e) {
            e.printStackTrace();
        }
        return b;
    }

    public static boolean requireTrue(boolean b) {
        if (!b) try {
            throw new ValidatorException("Boolean must be true");
        } catch (ValidatorException e) {
            e.printStackTrace();
        }
        return b;
    }

    public static boolean requireTrue(boolean b, String booleanName) {
        if (!b) try {
            throw new ValidatorException(booleanName + " must be true");
        } catch (ValidatorException e) {
            e.printStackTrace();
        }
        return b;
    }

    public static <E> List<E> requireUniqueElements(List<E> list) {
        notNull(list, "List");
        Set<E> set = new HashSet<E>(list);
        if (set.size() < list.size()) try {
            throw new ValidatorException("List must contain unique elements");
        } catch (ValidatorException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static <E> List<E> requireUniqueElements(List<E> list, String listName) {
        notNull(list, notEmpty(listName));
        Set<E> set = new HashSet<E>(list);
        if (set.size() < list.size()) try {
            throw new ValidatorException(listName + " must contain unique elements");
        } catch (ValidatorException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static <E> E[] requireUniqueElements(E[] array) {
        notNull(array, "Array");
        Set<E> set = new HashSet<E>(Arrays.asList(array));
        if (set.size() < array.length) try {
            throw new ValidatorException("Array must contain unique elements");
        } catch (ValidatorException e) {
            e.printStackTrace();
        }
        return array;
    }

    public static <E> E[] requireUniqueElements(E[] array, String arrayName) {
        notNull(array, notEmpty(arrayName));
        Set<E> set = new HashSet<E>(Arrays.asList(array));
        if (set.size() < array.length) try {
            throw new ValidatorException(arrayName + " must contain unique elements");
        } catch (ValidatorException e) {
            e.printStackTrace();
        }
        return array;
    }

    public static boolean isEven(BigInteger bigInteger) {
        notNull(bigInteger, "BigInteger");
        return bigInteger.toString().endsWith("0") || bigInteger.toString().endsWith("2") || bigInteger.toString().endsWith("4") || bigInteger.toString().endsWith("6") || bigInteger.toString().endsWith("8");
    }

    public static boolean isEven(double d) { return d % 2 == 0; }

    public static boolean isCamelCase(String string) {
        notEmpty(string);
        return matches(string, "^[a-z]+([A-Z][a-z0-9]+)+");
    }
}
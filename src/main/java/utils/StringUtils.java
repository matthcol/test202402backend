package utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class StringUtils {

    public static<T> String toString1(T object, boolean displayPropertyName, String property) {
        String getterMethodName = "get" + property.substring(0, 1).toUpperCase() + property.substring(1);
        try {
            Method getterMethod = object.getClass().getMethod(getterMethodName);
            Object propertyValue = getterMethod.invoke(object);
            if (displayPropertyName) {
                return Objects.toString(propertyValue);
            } else {
                return MessageFormat.format("{}={}", property, propertyValue);
            }
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException("Unknown attribute: " + property);
        } catch (InvocationTargetException e) {
            throw new IllegalArgumentException("Getter called with wrong arguments: " + property);
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException("Getter is not visible in this context: " + property);
        }
    }

    public static<T> String toString(T object, boolean displayPropertyNames, String... properties){
        var builder = new StringBuilder();
        builder.append(object.getClass().getSimpleName())
                .append('[');
        builder.append(
                Arrays.stream(properties)
                .map(property -> toString1(object, displayPropertyNames, property))
                .collect(Collectors.joining(","))
        );
        return builder.append(']')
                .toString();
    }

    public static<T> String toString(T object, String... properties){
        return toString(object, false, properties);
    }
}

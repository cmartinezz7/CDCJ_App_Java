package io.apptik.widget;

public class Util {
    private Util() {
    }

    public static <T> T requireNonNull(T o) {
        if (o != null) {
            return o;
        }
        throw new NullPointerException();
    }

    public static <T> T requireNonNull(T o, String message) {
        if (o != null) {
            return o;
        }
        throw new NullPointerException(message);
    }
}

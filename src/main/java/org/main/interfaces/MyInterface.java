package org.main.interfaces;

@FunctionalInterface
public interface MyInterface<I, R, U> {
    public U transform(Object... objects);
}

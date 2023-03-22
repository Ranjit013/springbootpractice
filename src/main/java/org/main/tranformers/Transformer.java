package org.main.tranformers;


import java.io.IOException;

public interface Transformer<I, O> {
    public O transform(I a, Class<?> b) throws IOException;
}
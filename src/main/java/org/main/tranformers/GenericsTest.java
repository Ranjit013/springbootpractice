package org.main.tranformers;

import java.util.List;

public interface GenericsTest<T, E> {
    public List<E> transformerTest(T t, Class<E> e);
}

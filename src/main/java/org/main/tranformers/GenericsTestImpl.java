package org.main.tranformers;

import java.util.List;

public class GenericsTestImpl<T, E> implements GenericsTest<T, E>{
    @Override
    public List<E> transformerTest(T t, Class<E> e) {
        return null;
    }
}

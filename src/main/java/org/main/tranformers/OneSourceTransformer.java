package org.main.tranformers;

import org.springframework.stereotype.Service;

import java.io.IOException;

@Service("OneSource")
public class OneSourceTransformer<A, B> implements Transformer<A,B> {

    @Override
    public B transform(A a, Class<?> b) throws IOException {
        return null;
    }
}

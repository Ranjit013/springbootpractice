package org.main.tranformers;

import org.apache.commons.lang3.ClassUtils;
import org.junit.Before;
import org.junit.Test;
import org.main.model.Employee;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class CSVTransformerTest {

    private CSVTransformer<String, List<Employee>> transformer;

    @Before
    public void setUp() throws Exception {
        transformer = new CSVTransformer<>();
    }

    @Test
    public void readAnnotationsTest() {
        assertEquals(1, transformer.readAnnotations());
    }


    @Test
    public void transformTest() throws IOException {
        String path = "C:\\Users\\Ranjit\\Documents\\Employee.csv";
        final List<Employee> transform = transformer.transform(path, Employee.class);
    }

    @Test
    public void fancyStuffTest() {
        final Class<?> aClass = ClassUtils.primitiveToWrapper(int.class);
        assertFalse(aClass.isPrimitive());
    }
}
package org.main.tranformers;

import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.main.model.Employee;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Service("csvTransformer")
public class CSVTransformer<I, O> implements Transformer<I, O> {

    @Override
    public O transform(I path, Class<?> tClass) throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get(path.toString()));
        final CsvToBean csvBean = new CsvToBeanBuilder(reader).withType(tClass).withSkipLines(1).build();
        final List parse = csvBean.parse();
        return ((O) parse);
    }


    public int readAnnotations()
    {
        final Field employeeId = FieldUtils.getField(Employee.class, "employeeName", true);
        final CsvBindByPosition[] annotationsByType = employeeId.getAnnotationsByType(CsvBindByPosition.class);
        for (CsvBindByPosition byPosition : annotationsByType) {
            return byPosition.position();
        }
        return 0;
    }

}

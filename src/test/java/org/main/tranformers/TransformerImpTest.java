package org.main.tranformers;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.Test;
import org.main.model.Address;
import org.main.model.Employee;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TransformerImpTest {

    public String myString = "{\n" +
            "  pets: [\n" +
            "    {id:1, petName: \"Blaze\", petType: \"Canine\", age: 2},\n" +
            "    {id: 2, petName: \"Felicia\", petType: \"Feline\", age: 1},\n" +
            "    {id: 2, petName: \"Bolt\", petType: \"Canine\", age: 3}\n" +
            "    \n" +
            "  ]\n" +
            "}";


    public String myString_1 = "{\n" +
            "  \"name\": \"David\",\n" +
            "  \"role\": \"Manager\",\n" +
            "  \"city\": \"Los Angeles\"\n" +
            "}";

    @Test
    public void transformTest() {
        String name = "Ranjit";
        Integer id = 2;
    }


    @Test
    public void reflectFieldsTest() throws IllegalAccessException, NoSuchFieldException {
        final Address address = new Address("ADDRESS1", "LANDMARK1", "PINCODE1", "STATE1", "COUNTRY1");
        final List<String> allFieldValue = getAllFieldValue(address, Address.class);
        final List<String> addressList = Arrays.asList("ADDRESS1", "LANDMARK1", "PINCODE1", "STATE1", "COUNTRY1");
        assertEquals(true, Iterables.elementsEqual(addressList, allFieldValue));
    }

    @Test
    public void jsonTest() throws IOException {
        ObjectMapper ob = new ObjectMapper();
        ob.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        final JsonNode jsonNode = ob.readTree(myString);
        final JsonParser parser = new JsonFactory().createParser(myString).configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        final Employee employee1 = ob.readValue(parser, Employee.class);
        final Employee employee = ob.readValue(myString, Employee.class);
        final Employee employee2 = ob.treeToValue(jsonNode, Employee.class);
        System.out.println(employee2.getPets().toString());
    }

    @Test
    public void jsonFileTest() throws IOException {
        final URL path = Thread.currentThread().getContextClassLoader().getResource("test.json");
        ObjectMapper ob = new ObjectMapper();
        ob.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        final Employee employee = ob.readValue(path, Employee.class);
        System.out.println(employee.getPets().toString());
    }

    private <T> List<String> getAllFieldValue(T object, Class<T> tClass) throws IllegalAccessException {
        List<String> listObjectValue = new ArrayList<>();
        final Field[] allFields = FieldUtils.getAllFields(tClass);
        for (Field field : allFields) {
            field.setAccessible(true);
            listObjectValue.add(((String) field.get(object)));
        }
        return listObjectValue;
    }


    @Test
    public void listCreateTest() {
        final List<String> list = Lists.newArrayListWithExpectedSize(5);
        assertEquals(0, list.size());
    }

    @Test
    public void myJobTest() {

    }
}

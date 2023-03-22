package org.main.dao;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


/*final List<String> resultList = new ArrayList<String>();
        resultList.add("test1");
        resultList.add("test2");

final JdbcTemplate template = mock(JdbcTemplate.class);

        when(template.query(anyString(), any(Object[].class), any(RowMapper.class)))
        .thenAnswer(new Answer<List<String>>() {
@Override
public Object answer(InvocationOnMock invocation) throws Throwable {
        // Fetch the method arguments
        Object[] args = invocation.getArguments();

        // Fetch the row mapper instance from the arguments
        RowMapper<String> rm = (RowMapper<String>) args[2];

        // Create a mock result set and setup an expectation on it
        ResultSet rs = mock(ResultSet.class);
        String expected = "value returned by query";
        when(rs.getString(1)).thenReturn(expected);

        // Invoke the row mapper
        String actual = rm.mapRow(rs, 0);

        // Assert the result of the row mapper execution
        assertEquals(expected, actual);

        // Return your created list for the template#query call
        return resultList;
        }
        });*/

public class AddressDaoTest {
    private AddressDao testVariable;

    @Mock
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        testVariable = new AddressDao(jdbcTemplate);
    }

    @Test
    public void saveAddressTest() {
        when(jdbcTemplate.queryForObject(anyString(), any(MapSqlParameterSource.class), any(RowMapper.class))).thenAnswer(this::getMockUserObjectList);
        when(jdbcTemplate.queryForObject(anyString(), any(MapSqlParameterSource.class), any(RowMapper.class))).thenReturn(Arrays.asList("test1", "test2"));
        List<String> strings = testVariable.saveAddressToDataBase();
        assertEquals(2, strings.size());

    }

    private List<String> getMockUserObjectList(InvocationOnMock invocation) throws SQLException {
        List<String> resultList = new ArrayList<>();
        resultList.add("test1");
        resultList.add("test2");
        return resultList;
    }


}
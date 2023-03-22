package org.main.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AddressDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    public AddressDao(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public boolean saveAddress() {
        System.out.println("AddressDao.saveAddress");
        return true;
    }

    public List<String> saveAddressToDataBase() {
        String sql = "select * from Address where Id =:id";
        Map<String, String> map = new HashMap<>();
        map.put("id", "Id");
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("id", 1);
        return namedParameterJdbcTemplate.queryForObject(sql, mapSqlParameterSource, (rs, rowNum) -> Arrays.asList("Hello", "World"));
    }

}

package com.pupu.designPattern.design10_template.template03_jdbc.framework;

import java.sql.ResultSet;

/**
 * Created by Tom.
 */
public interface RowMapper<T> {

    T mapRow(ResultSet rs, int rowNum) throws Exception;

}

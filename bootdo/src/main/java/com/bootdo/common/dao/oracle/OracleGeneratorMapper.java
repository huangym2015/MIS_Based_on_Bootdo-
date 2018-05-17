package com.bootdo.common.dao.oracle;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * Created by ian on 2018/5/17.
 */

public interface OracleGeneratorMapper {

    @Select("SELECT a.object_name tableName, b.comments tableComment, a.created createTime FROM user_objects a LEFT JOIN user_tab_comments b on a.object_name = b.table_name WHERE a.object_name in(\n" +
            "  select table_name from user_all_tables)")
    List<Map<String, Object>> list();

    @Select("select count(1) from user_objects WHERE object_type = 'TABLE'")
    int count(Map<String, Object> map);

    @Select("SELECT a.object_name as tableName, b.comments as tableComment, a.created createTime FROM user_objects a LEFT JOIN user_tab_comments b on a.object_name = b.table_name WHERE a.object_name = #{tableName}")
    Map<String, String> get(String tableName);

    @Select("SELECT a.COLUMN_NAME as columnName,a.data_type as dataType,b.comments as comments\n" +
            "FROM user_tab_columns a LEFT JOIN user_col_comments b on a.column_name = b.column_name\n" +
            "WHERE a.table_name = #{tableName} AND a.table_name = b.table_name")
    List<Map<String, String>> listColumns(String tableName);
}

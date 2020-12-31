package com.project.crm.model;

import com.baomidou.mybatisplus.entity.TableInfo;
import com.baomidou.mybatisplus.mapper.AutoSqlInjector;
import org.apache.ibatis.builder.MapperBuilderAssistant;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.session.Configuration;

/**
 * @author: Muma
 * @date: Created in 2020/6/19 15:24
 */
public class MySqlInjector extends AutoSqlInjector {
    @Override
    public void inject(Configuration configuration, MapperBuilderAssistant builderAssistant,
                       Class<?> mapperClass, Class<?> modelClass, TableInfo table) {
        /* 添加一个自定义方法 */
        selectAllUser(mapperClass, modelClass, table);
    }

    public void selectAllUser(Class<?> mapperClass, Class<?> modelClass, TableInfo table) {
        /* 执行 SQL ，动态 SQL 参考类 SqlMethod */
        String sql = "select * from " + table.getTableName();
        /* mapper 接口方法名一致 */
        String method = "selectAll";
        SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, modelClass);
        this.addSelectMappedStatement(mapperClass, method, sqlSource, modelClass, table);
    }
}

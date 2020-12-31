package com.project.crm.Generator;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

/**
 * @author: Muma
 * @date: Created in 2020/6/16 11:36
 */
public class TestGenerator {
    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());  // 选择 freemarker 引擎，默认 Veloctiy
        //1、全局配置
        GlobalConfig config = new GlobalConfig();
        config.setActiveRecord(true)//开启AR模式
                .setAuthor("Muma")//设置作者
                .setOutputDir("D:\\VMS_CODE") //生成路径(一般都是生成在此项目的src/main/java下面)
                .setFileOverride(true)//第二次生成会把第一次生成的覆盖掉
                .setIdType(IdType.AUTO)//主键策略
                .setServiceName("%sService")//生成的service接口名字首字母是否为I，这样设置就没有I
                .setBaseResultMap(true)//生成resultMap
                .setBaseColumnList(true)//在xml中生成基础列
                .setOpen(false) //生成完成是否打开文件所在目录
                .setEnableCache(false);// xml二级缓存
                //.setSwegger(true); //实体属性 Swagger2 注解
        //2、数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.SQL_SERVER)//数据库类型
                .setDriverName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
                .setUrl("jdbc:sqlserver://123.56.27.190:1433;database=AC_MDJHB_XGB")
                .setUsername("sa")
                .setPassword("Success@jianlan");
        //3、策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setCapitalMode(true)//开启全局大写命名
                .setDbColumnUnderline(true)//表名字段名使用下划线
                .setNaming(NamingStrategy.underline_to_camel)//下划线到驼峰的命名方式
                .setColumnNaming(NamingStrategy.underline_to_camel)//实体字段生成策略
//                .setTablePrefix("")//去掉表名表名前缀
                .setEntityLombokModel(true)//使用lombok
                .setInclude("H_BACK_DATA","H_BACK_PHOTO","H_BACK_VFLM","H_BACK_VTIE")//逆向工程使用的表
                .setRestControllerStyle(true) //@RestController注解
                .entityTableFieldAnnotationEnable(true); //@TableField注解
        //4、包名策略配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.jlkj.mykj")//设置包名的parent
                .setMapper("mapper")
                .setService("service")
                .setController("controller")
                .setEntity("model")
                .setXml("mapper");//设置xml文件的目录
        //5、整合配置
        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator.setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(packageConfig);
        //6、执行
        autoGenerator.execute();
    }

}

package com.example.mybatisplus.config;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.sql.Types;
import java.util.Collections;

public class CodeGenerator {

    private static String url = "jdbc:mysql://?useUnicode=true&characterEncoding=UTF-8&useSSL=true&serverTimezone=Asia/Shanghai";
    private static String userName = "root";
    private static String password = "";

    public static void main(String[] args) {

        FastAutoGenerator.create(url, userName, password)
                .globalConfig(builder -> {
                    builder.author("xxb") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件

                            .outputDir("D:\\project\\cimc\\datacenter\\mmt-collector\\data-collect\\src\\main\\java"); // 指定输出目录
                })
                .dataSourceConfig(builder -> builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
                    int typeCode = metaInfo.getJdbcType().TYPE_CODE;
                    if (typeCode == Types.SMALLINT) {
                        // 自定义类型转换
                        return DbColumnType.INTEGER;
                    }
                    if (typeCode == Types.TIMESTAMP){
                        return DbColumnType.DATE;
                    }
                    return typeRegistry.getColumnType(metaInfo);
                }))
                .packageConfig(builder -> {
                    builder.parent("com.mmt.collector") // 设置父包名
                            .entity("model.entity")
//                            .moduleName("data-collect") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "D:\\project\\cimc\\datacenter\\mmt-collector\\data-collect\\src\\main\\resources\\mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("finance_audit_record") // 设置需要生成的表名.
                            .addTablePrefix() // 设置过滤表前缀
                            .mapperBuilder().enableBaseColumnList().enableBaseResultMap().build();

                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }

}

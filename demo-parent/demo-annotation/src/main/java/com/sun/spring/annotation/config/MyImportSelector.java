package com.sun.spring.annotation.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author shawn
 * @descript
 * 基于@Import 自定义选择器
 * @create 2020-11-15 9:35 下午
 */
public class MyImportSelector implements ImportSelector {
    /**
     *
     * @param annotationMetadata 当前标注@Import的所有bean
     * @return
     */
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{"com.sun.spring.annotation.clasz.Monkey"};
    }
}

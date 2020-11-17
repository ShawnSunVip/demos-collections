package com.sun.spring.annotation.filter;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * @author shawn
 * @descript
 * 基于@ComponentScan 的自定义匹配规则
 * @create 2020-11-15 6:29 下午
 */
public class MyTypeFilter implements TypeFilter {
    /**
     *
     * @param metadataReader 当前正在扫描的类信息
     * @param metadataReaderFactory 获取其他任何类信息
     * @return
     * @throws IOException
     */
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        // 获取当前类注解信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        // 获取当前类的信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        // 获取当前类资源 类路径
        Resource resource = metadataReader.getResource();

        String className = classMetadata.getClassName();
        System.out.println("==>"+className);
        // 如果类名含有xxx则表示匹配成功
        if(className.contains("xxx")){
            return true;
        }
        return false;
    }
}

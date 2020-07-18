package com.hyp.service;

import com.hyp.pojo.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @ProjectName blog
 * @ClassName TypeService
 * @create 2020-07-10 18:42
 * @Author by hyp
 */
public interface TypeService {
    Type saveType(Type type);

    Type getType(Long id);

    Type getTypeByName(String name);

    Page<Type> listType(Pageable pageable);

    List<Type> listType();

    List<Type> listTypeTop(Integer size);

    Type updateType(Long id,Type type);

    void deleteType(Long id);
}

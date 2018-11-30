package com.example.demo.stream;


import com.example.demo.entity.base.ID;
import org.springframework.beans.BeanUtils;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author zhang
 */
public class EntityUtil {

    /**
     * 获取ID (单个)
     *
     * @param entities entities data
     * @param <T>      entities Type
     * @param <R>      entities`s id Type
     * @return List<R>
     */
    public static <T extends ID<R>, R> List<R> getID(List<T> entities) {
        return entities.stream().map(T::getId).distinct().collect(Collectors.toList());
    }

    /**
     * 获取ID (多个)
     *
     * @param entity   entity
     * @param function lambda express
     * @param <E>      entity Type
     * @param <R>      result Type
     * @return List<Number>
     */
    public static <E, R extends ID<R>> List<R> getID(List<E> entity, Function<List<E>, List<R>> function) {
        return function.apply(entity).stream().map(ID::getId).distinct().collect(Collectors.toList());
    }

    /**
     * 整理数据
     *
     * @param entity entity
     * @param mapper lambda express
     * @param <T>    entity Type
     * @param <R>    result Type
     * @return List<R>
     */
    public static <T, R> List<R> mapperData(List<T> entity, Function<T, R> mapper) {
        return entity.stream().map(mapper).collect(Collectors.toList());
    }

    public static <T, R> List<R> mapperData(List<T> entity, Predicate<T> filter, Function<T, R> mapper) {
        return entity.stream().filter(filter).map(mapper).collect(Collectors.toList());
    }

    public static <T, R> List<R> mapperData(List<T> entity, Comparator<? super R> comparable, Function<T, R> mapper) {
        return entity.stream().map(mapper).sorted(comparable).collect(Collectors.toList());
    }

    public static <T, R> List<R> mapperData(List<T> entity, Predicate<T> filter, Comparator<? super R> comparable, Function<T, R> mapper) {
        return entity.stream().filter(filter).map(mapper).sorted(comparable).collect(Collectors.toList());
    }

    /**
     * 数据排序
     *
     * @param entity     entity
     * @param comparable lambda express
     * @param <R>        entity Type
     * @return List<R>
     */
    public static <R> List<R> sortData(List<R> entity, Comparator<? super R> comparable) {
        return entity.stream().sorted(comparable).collect(Collectors.toList());
    }

    /**
     * 数据过滤
     *
     * @param entity    entity
     * @param predicate lambda express
     * @param <R>       entity Type
     * @return List<R>
     */
    public static <R> List<R> filterData(List<R> entity, Predicate<R> predicate) {
        return entity.stream().filter(predicate).collect(Collectors.toList());
    }

    /**
     * 数据格式转换
     *
     * @param entity entity
     * @param key    lambda express
     * @param value  lambda express
     * @param <T>    entity Type
     * @param <K>    key Type
     * @param <V>    value Type
     * @return Map
     */
    public static <T, K, V> Map<K, V> toMap(List<T> entity, Function<T, K> key, Function<T, V> value) {
        return entity.stream().collect(Collectors.toMap(key, value));
    }

    public static <T, F, K, V> Map<K, V> toMap(List<T> entity, Function<T, F> sort, Function<F, K> key, Function<F, V> value) {
        return entity.stream().map(sort).collect(Collectors.toMap(key, value));
    }

    public static <T, K, V> Map<K, V> toMap(List<T> entity, Predicate<T> filter, Function<T, K> key, Function<T, V> value) {
        return entity.stream().filter(filter).collect(Collectors.toMap(key, value));
    }

    public static <T, F, K, V> Map<K, V> toMap(List<T> entity, Function<T, F> sort, Predicate<T> filter, Function<F, K> key, Function<F, V> value) {
        return entity.stream().filter(filter).map(sort).collect(Collectors.toMap(key, value));
    }

    static DoubleUnaryOperator curriedConverter(double f, double b) {
        return (double x) -> x * f + b;
    }

    /**
     * 单个 数据转换
     *
     * @param source source
     * @param target target
     * @param <T>    source Type
     * @param <R>    target Type
     * @return target
     */
    public static <T, R> R convert(T source, R target) {
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /**
     * 类型转换
     *
     * @param entities 原数据
     * @param target   目标数据
     * @param <T>      原数据类型
     * @param <R>      目标数据类型
     * @return List<目标数据>
     */
    public static <T, R> List<R> convertAll(List<T> entities, R target) {
        return entities.stream().map(e -> EntityUtil.convert(e, target)).collect(Collectors.toList());
    }

    /**
     * 数据转换
     *
     * @param source   原数据
     * @param function 自定义转换策略
     * @param <T>      原数据类型
     * @param <R>      目标数据类型
     * @return List<目标数据>
     */
    public static <T, R> List<R> convertAll(List<T> source, Function<T, R> function) {
        return source.stream().map(function).collect(Collectors.toList());
    }


}

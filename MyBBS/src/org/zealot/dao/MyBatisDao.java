package org.zealot.dao;

import java.util.List;
import java.util.Map;

public interface MyBatisDao {

	<T> List<T> get(T t, String sqlId);

	<T> List<T> get(T t, Map map, String sqlId);

	<T, E, A> A getOnePrimitive(T t, E e, String sqlId);

	<T> int add(T t, String sqlId);

	<T> int add(T t, Map map, String sqlId);

	<T> int add(T t, List list, String sqlId);

	<T> int update(T t, Map map, String sqlId);

	<T> int update(T t, List list, String sqlId);

	<T> int update(T t, String sqlId);

	<T> int remove(T t, List list, String sqlId);

	<T> int remove(T t, String sqlId);

	<T> int remove(T t, Map map, String sqlId);

}

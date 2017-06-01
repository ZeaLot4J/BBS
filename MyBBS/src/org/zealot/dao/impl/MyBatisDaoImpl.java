package org.zealot.dao.impl;

import java.util.List;
import java.util.Map;

import org.zealot.dao.MyBatisDao;
import org.zealot.util.MyBatisUtils;

public class MyBatisDaoImpl implements MyBatisDao {
	
	private String mapperLocation="org.zealot.mapper.";
	
	private <T> String getMapperId(T t,String sqlId){
		return mapperLocation+t.getClass().getSimpleName()+"Mapper."+sqlId;
	}
	
	@Override
	public <T> List<T> get(T t, String sqlId) {
		return MyBatisUtils.getSqlSession().selectList(getMapperId(t,sqlId),t);
	}
	@Override
	public <T> List<T> get(T t, Map map, String sqlId) {
		return MyBatisUtils.getSqlSession().selectList(getMapperId(t,sqlId),map);
	}
	@Override
	public <T,E,A> A getOnePrimitive(T t, E e, String sqlId){
		return MyBatisUtils.getSqlSession().selectOne(getMapperId(t, sqlId), e);
	}
	@Override
	public <T> int add(T t, String sqlId) {
		return MyBatisUtils.getSqlSession().insert(getMapperId(t,sqlId),t);
	}
	@Override
	public <T> int add(T t, Map map, String sqlId) {
		return MyBatisUtils.getSqlSession().insert(getMapperId(t,sqlId),map);
	}
	@Override
	public <T> int add(T t, List list, String sqlId) {
		return MyBatisUtils.getSqlSession().insert(getMapperId(t,sqlId),list);
	}
	@Override
	public <T> int remove(T t, String sqlId) {
		return MyBatisUtils.getSqlSession().delete(getMapperId(t,sqlId),t);
	}
	@Override
	public <T> int remove(T t, Map map, String sqlId) {
		return MyBatisUtils.getSqlSession().delete(getMapperId(t,sqlId),map);
	}
	@Override
	public <T> int remove(T t, List list, String sqlId) {
		return MyBatisUtils.getSqlSession().delete(getMapperId(t,sqlId),list);
	}
	@Override
	public <T> int update(T t, String sqlId) {
		return MyBatisUtils.getSqlSession().update(getMapperId(t,sqlId),t);
		
	}
	@Override
	public <T> int update(T t, Map map, String sqlId) {
		return MyBatisUtils.getSqlSession().update(getMapperId(t,sqlId),map);
	}
	@Override
	public <T> int update(T t, List list, String sqlId) {
		return MyBatisUtils.getSqlSession().update(getMapperId(t,sqlId),list);
	}
}

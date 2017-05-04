package util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import annotation.Mapping;

public class CopyUtil {
	
	/**
	 * 实现对象的直接拷贝
	 * @param fromObj
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T copyObject(Object fromObj,Class<T> clazz){
		T toObject = null;
		Class<?> fromClass = fromObj.getClass();
		try{
			//如果是基本类型，则直接返回
			if(clazz.isPrimitive()){
				return (T)fromObj;
			}
			
			Field[] fields = clazz.getDeclaredFields();
			toObject = clazz.newInstance();
			for (Field tofield : fields){
				//静态变量，常量，不做拷贝
				int mod = tofield.getModifiers();
				if(Modifier.isFinal(mod)||Modifier.isStatic(mod)){
					continue;
				}
				//获取to类的字段名称
				String tofieldname = tofield.getName();
				//获取from类的字段名称
				String fromfieldname = tofieldname;
				//判断mapping注解
				//如果存在注解，则更新对应的from字段名称
				if(tofield.isAnnotationPresent(Mapping.class)){
					fromfieldname = tofield.getAnnotation(Mapping.class).value();
				}
				//根据字段名称获取from对象的字段定义
				Field fromField = fromClass.getDeclaredField(fromfieldname);
				//如果fromfield为空，表名from类中无匹配字段
				if(fromField == null){
					continue;
				}
				//设置from指定字段的可见性
				fromField.setAccessible(true);
				//获取from对象的指定字段的值
				Object value = fromField.get(fromObj);
				//设置to指定字段的可见性
				tofield.setAccessible(true);
				//设置to对象指定字段的值
				tofield.set(toObject, value);	
			}
			
		}catch(Exception e){
			System.out.println("对象copy失败！");
		}
		
		return toObject;
		
	}

}

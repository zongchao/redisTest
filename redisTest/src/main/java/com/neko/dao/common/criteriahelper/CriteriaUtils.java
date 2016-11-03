package com.neko.dao.common.criteriahelper;

import org.springframework.util.StringUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by zongtao on 2016/9/8.
 */
public class CriteriaUtils {

    public static void criteriaAndEqualTo(Object bean, Object exampleCriteria) {
        if (null == bean || null == exampleCriteria) {
            return;
        }

        Class beanClass = bean.getClass();

        Class exampleCriteriaClass = exampleCriteria.getClass();

        // 取得key = 属性名，value = 属性值得map
        Map paramMap = Stream.of(beanClass.getDeclaredMethods()).filter(beanMethod -> beanMethod.getName().startsWith("get"))
                .collect(Collectors.toMap(k -> k.getName().replace("get", ""), v -> {
                    Object o = "";
                    try {
                        if (null != v.invoke(bean)) {
                            o = v.invoke(bean);
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                    return o;
                }));
        paramMap.forEach((key, value) -> {
            if (!StringUtils.isEmpty(value)) {
                try {
                    // 取得 and+Key+EqualTo 为条件赋值
                    Method method = exampleCriteriaClass.getMethod("and" + key + "EqualTo", beanClass.getDeclaredField(StringUtils.uncapitalize(key.toString())).getType());
                    method.invoke(exampleCriteria, value);
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}

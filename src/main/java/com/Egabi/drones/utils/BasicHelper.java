package com.Egabi.drones.utils;

import java.lang.reflect.Field;

public class BasicHelper {
    public static Object updateObject(Object obj1, Object obj2) throws Exception {
        Class<?> obj1Class = obj1.getClass();
        Class<?> obj2Class = obj2.getClass();
        if(!obj1Class.equals( obj2Class)){
            throw new Exception("types of different objects given, cannot convert");
        }
        Field[] obj1Fields = obj1Class.getDeclaredFields();
        Field[] obj2Fields = obj1Class.getDeclaredFields();
//        for(Field field:obj1Fields){
//            field.setAccessible(true);
//            Object value = field.get(obj1);
//            System.out.println(field.getName()+" : "+value);
//        }

        for(int i = 0; i< obj1Fields.length; i++){
            obj1Fields[i].setAccessible(true); obj2Fields[i].setAccessible(true);
            if(obj2Fields[i].get(obj2)!=null && obj1Fields[i].getName().equals(obj2Fields[i].getName())){
                obj1Fields[i].set(obj1, obj2Fields[i].get(obj2));
            }
        }
        return obj1;
    }

}

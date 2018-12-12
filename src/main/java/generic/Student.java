package generic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class Student extends Person<String> {
    void ff(){
        Class clazz = getClass();
        Type  type = clazz.getGenericSuperclass();
        System.out.println((type.getTypeName()));

        Type type1= ((ParameterizedType)type).getRawType();
        System.out.println(type1);
        Type type2 = ((ParameterizedType)type).getActualTypeArguments()[0];
        System.out.println(type2);
        Class superClass = clazz.getSuperclass();
    }

    public static void main(String[] args) {
//        Student student = new Student();
//        student.ff();
//        System.out.println(Tag.class);
        getType();
    }

    public static Type getType(){
        Student student = new Student();
        Person perRef = (Person)student;

//        Student stuRef = (Student);
        return ((Type)new Object());
    }
}

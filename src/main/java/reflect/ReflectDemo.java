package reflect;

import java.lang.reflect.*;

public class ReflectDemo <T>{
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, NoSuchFieldException, InvocationTargetException {
        ReflectDemo demo = new ReflectDemo();
        demo.tt();
    }

    public  void ff() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class clazz = Class.forName("reflect.Person");
        Constructor constructor = clazz.getConstructor(String.class);
        Person o = (Person) constructor.newInstance("fang");
        System.out.println("old name : " + o.name);
        Field field = clazz.getField("name");
        field.set(o,"cong");
        System.out.println("new name : " + o.name);
    }

    public void ft() throws NoSuchMethodException {
        Class clazz = Person.class;
        Method method = clazz.getMethod("getList");
        Type genericType = method.getGenericReturnType();
        if(genericType instanceof ParameterizedType){
            ParameterizedType parameterizedType = (ParameterizedType)genericType;
            Type[] types = parameterizedType.getActualTypeArguments();
            System.out.println(types[0]);
            for(Type actuType : types){
                Class cla = (Class) actuType;
                System.out.println(cla);
            }

            Type type = parameterizedType.getRawType();
            System.out.println(type);

            System.out.println(parameterizedType.getOwnerType());
        }
    }

    public void tt() throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class clazz = Person.class;
        Method method = clazz.getMethod("hello", String.class, Integer.class);
        Person person = (Person)clazz.newInstance();
        method.invoke(person,"fang",20);
        if(!Modifier.isPublic(method.getModifiers()) && Modifier.isStatic(method.getModifiers())){
            method.setAccessible(true);
        }
    }
}

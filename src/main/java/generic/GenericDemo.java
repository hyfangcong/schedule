package generic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GenericDemo<Client, Response> extends GenericFather{
    protected Class<Client> clientClass;
    protected Class<Response> responseClass;

    public GenericDemo(){
        Class clazz = getClass();
        Type type = clazz.getGenericSuperclass();
        List<Type> types = new ArrayList<>();
        types.add(type);
        while(!type.getTypeName().startsWith(GenericDemo.class.getName())){
            clazz = clazz.getSuperclass();
            type = clazz.getGenericSuperclass();
        }

        Type client = ((ParameterizedType)type).getActualTypeArguments()[0];
        Type response = ((ParameterizedType)type).getActualTypeArguments()[1];
        
    }






    public static void main(String[] args) {
        GenericDemo genericDemo = new GenericDemo();
        genericDemo.f1();
    }

    public void f1(){
        Class<?> clazz = getClass();
        Type type = clazz.getGenericSuperclass();
        Type type1 = clazz.getSuperclass();
        System.out.println(type.getTypeName());
        System.out.println(type1.getTypeName());
    }
}

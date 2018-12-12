package reflect;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public class Person<R> {
   public String name;
    public int age;
    private String password;



    public Person(){
    }

    public Person(String name){
        this.name = name;
    }

    public List<Person> getList(){
        List<Person> list = new ArrayList<>();
        return list;
    }

    public void hello(String name,Integer age){
        System.out.println(name + ":" + age);
    }
}

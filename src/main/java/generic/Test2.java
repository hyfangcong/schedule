package generic;

public class Test2 {
    public void ff(){
        getClass();
        getClass().getGenericSuperclass();
    }


    public static void main(String[] args) {
        Test2 test2 = new Test2();
        test2.ff();
    }
}

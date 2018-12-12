package generic;

import sun.reflect.generics.reflectiveObjects.TypeVariableImpl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class BaskHandler<Client extends BaskClient, Response> implements Handler<Response> {
    Class<Client> clientClass;
    Class<Response> responseClass;


    public BaskHandler(){
        Class clazz = getClass();
         Type type = clazz.getGenericSuperclass();
        List<Type> types = new ArrayList<>();
        types.add(type);
        while (!type.getTypeName().startsWith(BaskHandler.class.getName())){
            clazz = clazz.getSuperclass();
            type = clazz.getGenericSuperclass();
            types.add(type);
        }

        Type client = ((ParameterizedType)type).getActualTypeArguments()[0];
        Type respones = ((ParameterizedType)type).getActualTypeArguments()[1];
        this.clientClass = (Class<Client>)findClass(client,types);
        this.responseClass = (Class<Response>)findClass(respones, types);
    }

    private Class<?> findClass(Type client, List<Type> types) {
        Class<?> result = null;
        if(client instanceof Class) {
            result = (Class<?>)client;
        }else {
            String clientClassName = ((Class)((TypeVariableImpl)client).getGenericDeclaration()).getName();
            for (Type item : types) {
                if(item.getTypeName().startsWith(clientClassName)) {
                    Type innerType = ((ParameterizedType) item).getActualTypeArguments()[0];
                    if(innerType instanceof Class) {
                        result = (Class<?>)innerType;
                        break;
                    }
                }
            }
        }
        if(result == null) {
            throw new NullPointerException("can not find class" + client.getTypeName());
        }
        return result;
    }


    @Override
    public <Request> Response hand(Request request) {
        return null;
    }
}

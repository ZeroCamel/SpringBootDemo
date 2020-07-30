package Service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// java 动态代理
public class DynaProxyHellp implements InvocationHandler {

    private Object delegate;

    public Object bind(Object delegate)
    {
        this.delegate = delegate;
        return Proxy.newProxyInstance(this.delegate.getClass().getClassLoader(), this.delegate.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        try {
            System.out.println("问候之前的日志记录");
            result = method.invoke(this.delegate,args);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return  result;
    }
}

package Service;

public class StaticProxy implements IHello {

    private IHello iHello;
    public void setImpl(IHello impl)
    {
        this.iHello = impl;
    }

    @Override
    public void sayHello(String name) {
        System.out.println(name);
        iHello.sayHello(name);
    }

    @Override
    public void sayGoodBye(String name) {
        System.out.println(name);
        iHello.sayGoodBye(name);
    }
}

package com.example.starter;

/**
 * @Author zeroCamel
 */
public class HelloService {

    HelloProperties helloProperties;

    public HelloProperties getHelloProperties() {
        return helloProperties;
    }

    public void setHelloProperties(HelloProperties helloProperties) {
        this.helloProperties = helloProperties;
    }

    public String sayHelloExample(String name)
    {
        return helloProperties.getPrefix()+'-'+ name +'-'+ helloProperties.getSuffix();
    }
}

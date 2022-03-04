package com.wsy;

public abstract class Test1{
    public void process() {
        m();
        n();
        o();
        System.out.println("Test1");
    }
    protected abstract void m();

    protected void n() {
        System.out.println(" Test1 n");
    }

    protected void o() {
        System.out.println(" Test1 o");
    }

    void runM(Test1 t){
        t.m();
        System.out.println(t instanceof Test2);
        System.out.println(t instanceof Test3);
        System.out.println(t.getClass());
    }

}


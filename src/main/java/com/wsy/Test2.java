package com.wsy;

class  Test2 extends Test1{
    @Override
    protected void m(){
        System.out.println("Test2");
    }

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        test2.m();
    }
}
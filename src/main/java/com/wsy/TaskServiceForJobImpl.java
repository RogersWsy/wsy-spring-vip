package com.wsy;

public class TaskServiceForJobImpl extends Test1 implements TaskServiceForJob {
    public void process() {
        super.process();
    }

    protected void m() {
        System.out.println("TaskServiceForJobImpl m");
    }

    protected void o() {
        System.out.println("TaskServiceForJobImpl o");
    }

    public static void main(String[] args) {
        TaskServiceForJobImpl t = new TaskServiceForJobImpl();
        t.process();
    }
}

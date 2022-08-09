package model;

public class Task1 extends Thread{
    int num;
    public Task1(int num)
    {
        this.num = num;
    }
    @Override
    public void run() {
        for (int i = 1; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " : "+ num*i);
        }
        System.out.println(Thread.currentThread().getName() + " ends");
    }
}

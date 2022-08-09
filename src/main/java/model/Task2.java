package model;

public class Task2 extends Thread{
    int num;
    public Task2(int num)
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

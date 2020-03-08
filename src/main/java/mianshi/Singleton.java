package mianshi;

/**
 * Created by wangshunxi on 2019/11/25.
 * e-mail: mcphilex1989@gmail.com
 * phone: 15652608401
 */
//单例模式
public class Singleton {
    /*//懒汉式 线程不安全
    private static Singleton instance;
    private Singleton(){}
    public static Singleton getInstance(){
        if (instance == null){
            instance =  new Singleton();
        }
        return instance;
    }*/
/*

    //懒汉式 线程安全
    private static Singleton instance;
    private Singleton (){}
    public static synchronized Singleton getInstance(){
        if (instance == null){
            instance = new Singleton();
        }
        return instance;
    }
*//*
    //饿汉式
    private static Singleton instance = new Singleton();
    private Singleton(){}
    public static Singleton getInstance(){
        return instance;
    }
    */

    //双重校验锁
    private volatile static Singleton instance;
    private Singleton(){}
    public static Singleton getInstance(){
        if (instance == null){
            synchronized (Singleton.class){
                if (instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}

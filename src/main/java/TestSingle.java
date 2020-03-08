/**
 * Created by wangshunxi on 2019/11/21.
 * e-mail: mcphilex1989@gmail.com
 * phone: 15652608401
 */
/*
* 单例模式
* 涉及到一个单一的类，该类负责创建自己的对象，同时确保只有单个对象被创建
*
* 注 单例类只能有一个实例
*    单例类必须自己创建自己的唯一实例
*    单例类必须给所有其他对象提供这一实例
* * */
//getInstance()方法中需要使用同步锁synchronized(Singleton.class)防止多线程同时进入造成instance被多次实例话
public class TestSingle {
    /*
    //懒汉式 线程不安全
    private static TestSingle instance;
    private TestSingle(){};
    public static TestSingle getInstance(){
        if (instance == null){
            instance = new TestSingle();
        }
        return instance;
    }
*//*
    //懒汉式 线程安全
    private static TestSingle instance;
    private TestSingle(){}
    public static synchronized TestSingle getInstance(){
        if (instance == null){
            instance = new TestSingle();
        }
        return instance;
    }*/
/*

    //恶汉式
    private static TestSingle instance = new TestSingle();
    private TestSingle() {}
    public static TestSingle getInstance(){
        return instance;
    }
*/

    //双重校验锁
    private volatile static TestSingle instance;
    private TestSingle(){}
    public static TestSingle getInstance(){
        if (instance == null){
            synchronized (TestSingle.class){
                if (instance == null){
                    instance = new TestSingle();
                }
            }
        }
        return instance;
    }
}
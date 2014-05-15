/**
 * Created on 5/5/14.
 */

public class SingletonEx {
}

/**
 * Using synchronized lock on the class
 */
class SingletonSynchronizedLock {
    private static SingletonSynchronizedLock instance;
    private SingletonSynchronizedLock(){
    }

    public static SingletonSynchronizedLock getInstance(){
        if(instance==null){
            synchronized (SingletonSynchronizedLock.class){ // locks on the class object
                if(instance==null){
                    instance=new SingletonSynchronizedLock();
                }
            }
            return instance;
        }else{
            return instance;
        }
    }
}

/**
 * Using 'Holder' inner class
 */
class Singleton_InnerClass {
    private Singleton_InnerClass() { }

    /**
     * SingletonHolder is loaded on the first execution of Singleton.getInstance()
     * or the first access to SingletonHolder.INSTANCE, not before.
     */
    private static class SingletonHolder {
        private static final Singleton_InnerClass INSTANCE = new Singleton_InnerClass();
    }

    public static Singleton_InnerClass getInstance() {
        return SingletonHolder.INSTANCE;
    }
}

/**
 * using enum
 */
enum SingletonEnum {
    INSTANCE;
    public void execute (String arg) {
        // Perform operation here
    }
}
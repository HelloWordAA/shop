package base;

/**
 * yzw
 * 2022/12/3
 * 抽象类：对一类事物的抽象
 * 抽象方法：事物确实存在某种行为，但是该行为是不具体的
 */
public abstract class BaseServiceImpl<T> implements IBaseService<T>{
    //子类实现抽象方法，注入具体的mapper
    abstract IBaseDao<T> getBaseDao();
}

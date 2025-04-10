package xx.data.sync.core.schedule;


public interface SyncJob<T> {
    void init();

    void preCheck(T t);

    void setResource(T t);

    void run(T t);

    void postDeal(T t);

    void destory(T t);
}

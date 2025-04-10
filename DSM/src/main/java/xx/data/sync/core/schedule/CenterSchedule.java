package xx.data.sync.core.schedule;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;


/**
 * 中央调度器
 */
public class CenterSchedule extends AbstractSchedule{
    /**
     * 中央线程池
     */
    private final ScheduledExecutorService executor =
            Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors() * 2);
    /**
     * 特意化线程池
     */
    private final ConcurrentHashMap<JobConfig,ScheduledExecutorService> scheduleChannel = new ConcurrentHashMap<>();

    /**
     * 单次执行队列
     * 使用容器线程池并发处理
     */
    static Queue<JobConfig> instantExeTasks;

    volatile static boolean isDataProcessing = false;



    private JobContainer.InstantTaskContainer instantTaskContainer;

    @PostConstruct
    void init(){
        instantTaskContainer = new JobContainer.InstantTaskContainer();

    }

    void start(){
        while (!instantExeTasks.isEmpty()) {
            JobConfig task = instantExeTasks.poll();
//                executor.schedule()
        }
    }

    void commit(List<JobConfig> jobConfigList){
        instantExeTasks.addAll(jobConfigList);
        if (!isDataProcessing) this.start();
    }
}

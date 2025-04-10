package xx.data.sync.core.schedule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 分割，组装，日志，提交任务
 */
public class JobContainer {
    InstantTaskContainer instantTaskContainer;
    PeriodicJobContainer periodicJobContainer;

    static CenterSchedule centerSchedule ;

    void init(){
        instantTaskContainer = new InstantTaskContainer();
        periodicJobContainer = new PeriodicJobContainer();
        periodicJobContainer.periodExeJob = new ArrayList<>();
    }

    public static class InstantTaskContainer {



       void Start(List<JobConfig> jobConfigList){
           List<JobConfig> instantTaskConfigList = new ArrayList<>();
           for (JobConfig jobConfig : jobConfigList) {
               if (jobConfig.getTaskList().isEmpty()){
                   instantTaskConfigList.addAll(JobContainer.splitJob2Task(jobConfig));
               }else {
                   instantTaskConfigList.add(jobConfig);
               }
           }
           centerSchedule .commit(instantTaskConfigList);
       }


    }

    static List<JobConfig> splitJob2Task(JobConfig config){
        return Collections.emptyList();
    }

    public static class PeriodicJobContainer {
        /**
         * 周期执行任务
         * 使用特异性线程池并发处理
         */
        List<SyncJob> periodExeJob;
    }


}

package xx.data.sync.core.schedule;

import lombok.Data;

import java.util.List;

@Data
public class JobConfig<T> {

    SyncJob<T> job;

//    List<SyncTask> taskList;

}

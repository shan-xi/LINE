package workers;

public interface WorkerManager {
    void addTask(Task task);

    // offset is sequential ID, 1,2,3,4,...
    long getCompleteOffset();

    // multithreaded needed
    TaskAndCallback poll();
}

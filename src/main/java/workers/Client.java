package workers;

public class Client {
    class WorkManagerImpl implements WorkerManager {

        @Override
        public void addTask(Task task) {

        }

        @Override
        public long getCompleteOffset() {
            return 0;
        }

        @Override
        public TaskAndCallback poll() {
            return null;
        }
    }

    public static void main(String[] args) {
        WorkManagerImpl WorkManagerImpl = new Client().new WorkManagerImpl();
        WorkManagerImpl.addTask(new Task());// offset 1
        WorkManagerImpl.addTask(new Task());// offset 2
        WorkManagerImpl.addTask(new Task());// offset 3

        // if first task is processed, getCompleteOffset = 1
        // if second task is not yet processed, getCompleteOffset = 1
        // if second task is processed, getCompleteOffset = 2
        // if third task is not yet processed, , getCompleteOffset = 2
    }
}

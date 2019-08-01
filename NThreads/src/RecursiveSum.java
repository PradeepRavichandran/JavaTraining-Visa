import java.util.List;
import java.util.concurrent.RecursiveTask;

class RecursiveSum extends RecursiveTask<Long> {
    static final int THRESHOLD = 1000;
    List<Integer> list;
    int begin;
    int end;

    public RecursiveSum(List<Integer> list, int begin, int end) {
        super();
        this.list = list;
        this.begin = begin;
        this.end = end;
    }

    @Override
    protected Long compute() {       
        final int size = end - begin;
        if (size < THRESHOLD) {
            long sum = 0;
            for (int i = begin; i < end; i++)
                sum += list.get(i);
            return sum;
        } else {
            final int middle = begin + ((end - begin) / 2);
            RecursiveSum left = new RecursiveSum(list, begin, middle);
            left.fork();
            RecursiveSum right = new RecursiveSum(list, middle, end);
            return right.compute() + left.join(); // we can even put right.fork() but its unnecessary here 
            									// because parent is just only splitting nothing much its doing
        }
    }
}


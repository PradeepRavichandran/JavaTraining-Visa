import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;


public class RecursiveTaskExample {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 10000; i++) {
			int random = 1 + (int) (Math.random() * ((100 - 1) + 1));
			list.add(random);
		}

		// create pool size based on available processors
		ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
		
		RecursiveSum recursiveSum = new RecursiveSum(list, 0, list.size());
		long recSum = forkJoinPool.invoke(recursiveSum);
		System.out.println("recursive-sum: " + recSum);
	}

}

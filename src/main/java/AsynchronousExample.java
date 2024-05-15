import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AsynchronousExample {
    public static void main(String[] args) {
// supplyAsync() method takes a `Supplier`
// function as a parameter, which is a function that produces a result.
// The `supplyAsync` method starts the operation asynchronously, typically in a separate thread or a thread pool.

//TODO : **Non-Blocking Execution**: The key advantage of using `CompletableFuture`
// is that it doesn't block the current thread while the asynchronous operation is running.
// This means the web server can continue to handle other requests while the operation is in progress.

      /*  CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> getMessage("call"));

        future.thenAccept(s -> System.out.println(s.charAt(80)));

        future.exceptionally(throwable -> {
            return throwable.getMessage();
        });

        future.thenApply(s -> s + ' ');


        ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.submit(() -> {
            System.out.println("dfdsf");
        });

        executorService.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                return null;
            }
        });
*/

        List<String> list1 = Arrays.asList("A", "B", "C");
        List<String> list2 = Arrays.asList("D", "E", "F");
        List<String> list3 = Arrays.asList("G", "A", "I");

        List<String> a = Stream.of(list1, list2, list3, list1)
                .flatMap(Collection::stream)
                .filter(strings -> strings.contains("A"))

                .collect(Collectors.toList());
        System.out.println(a);

    }


    static String getMessage(String message) {
        return "Asynchronous";
    }
}

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class ParallelStreamInJava8 {

    /*TODO: In Java, the parallelStream() method is a
           feature of the Stream API that allows you to process elements of a collection
           concurrently using multiple threads. It provides a convenient way to
           take advantage of multi-core processors and potentially speed up operations
           that can be parallelized, such as mapping, filtering, and reducing.*/

    public static void main(String[] args) {

       /* TODO: Suppose you have a large list of URLs and you want to check the
               response status of each URL using HTTP requests.
               This operation can be easily parallelized, as each URL can be processed independently.*/
        List<String> urls = Arrays.asList(
                "https://www.example.com",
                "https://www.google.com",
                "https://www.github.com"
                // ... (add more URLs)
        );

        long startTime = System.currentTimeMillis();
        urls.parallelStream()
                .forEach(url -> {
                    try {
                        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
                        int responseCode = connection.getResponseCode();
                        System.out.println(url + " => " + responseCode);
                    } catch (IOException e) {
                        System.err.println(url + " => Error: " + e.getMessage());
                    }
                });
        long endTime = System.currentTimeMillis();

        System.out.println("Total time: " + (endTime - startTime) + " ms");

    }
}

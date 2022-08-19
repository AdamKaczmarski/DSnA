package Hackerrank;
//https://www.hackerrank.com/challenges/dynamic-array/problem
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result_3 {

    /*
     * Complete the 'dynamicArray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        // Write your code here
        List<List<Integer>> arr = new ArrayList<>();
        int lastAnswer=0;
        List<Integer> answers = new ArrayList<>();
        for (int i =0 ;i<n;i++){
            arr.add(new ArrayList<>());
        }

        for(int i=0;i<queries.size();++i){
            if(queries.get(i).get(0)==1){
                Integer x = queries.get(i).get(1);
                Integer y = queries.get(i).get(2);
                int idx =  ((x^lastAnswer)%n);
                arr.get(idx).add(y);
            } else if (queries.get(i).get(0)==2) {
                Integer x = queries.get(i).get(1);
                Integer y = queries.get(i).get(2);
                int idx = ((x^lastAnswer)%n);
                lastAnswer = arr.get(idx).get(y%arr.get(idx).size());
                answers.add(lastAnswer);
            } else {
                return null;
            }
        }


        return answers;

    }

}

public class Array_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = Result_3.dynamicArray(n, queries);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

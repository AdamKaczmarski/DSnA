package Hackerrank;

import java.io.*;
import java.sql.Array;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
//https://www.hackerrank.com/challenges/crush/problem
class Result_5 {

    /*
     * Complete the 'arrayManipulation' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */

    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        // Write your code here
        long answer  = Long.MIN_VALUE;
        int[] ops = new int[n+1];
        for(int i=0;i<n+1;++i) ops[i]=0;

        for (int i=0;i<queries.size();++i){
            Integer left = queries.get(i).get(0)-1;
            Integer right = queries.get(i).get(1);
            Integer value = queries.get(i).get(2);
            ops[left]+=value;
            ops[right]-=value;
        }
        int sum=0;
        for (int num:ops){
            sum+=num;
            answer = Math.max(sum,answer);
        }
        return answer;
    }

}

public class Array_5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
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

        long result = Result_5.arrayManipulation(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

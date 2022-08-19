package Hackerrank;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
//https://www.hackerrank.com/challenges/2d-array/problem
class Result_2 {

    /*
     * Complete the 'hourglassSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int hourglassSum(List<List<Integer>> arr) {
        // Write your code here
        int max = Integer.MIN_VALUE;
        int tmp_max=0;
        for(int i =0;i<4;i++){
            for(int j=0;j<4;j++){
                tmp_max += arr.get(i).get(j);
                tmp_max += arr.get(i).get(j+1);
                tmp_max += arr.get(i).get(j+2);
                tmp_max += arr.get(i+1).get(j+1);
                tmp_max += arr.get(i+2).get(j);
                tmp_max += arr.get(i+2).get(j+1);
                tmp_max += arr.get(i+2).get(j+2);
                if (tmp_max>max) max = tmp_max;
                tmp_max=0;
            }
        }

        return max;
    }

}

public class Array_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result_2.hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

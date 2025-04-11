package dsa.array_and_strings;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static List<Integer> spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return null;
        }
        int maxR = matrix.length - 1;
        int maxC = matrix[0].length - 1;
        int minR = 0;
        int minC = 0;
        int total = matrix.length * matrix[0].length;
        int count = 0;
        List<Integer>  list = new ArrayList<>();


        while(count < total){

            for(int i=minC; i<= maxC && count < total; i++){
                list.add(matrix[minR][i]);
                count++;
            }
            minR++;

            for(int j = minR; j <= maxR && count < total; j++){
                list.add(matrix[j][maxC]);
                count++;
            }
            maxC--;

            for(int k= maxC; k>=minC && count < total; k--){
                list.add(matrix[maxR][k]);
                count++;
            }
            maxR--;

            for(int l = maxR; l >= minR && count<total; l--){
                list.add(matrix[l][minC]);
                count++;
            }
            minC++;
        }
        return list;

    }

/*    public static void spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        int maxR = matrix.length - 1;
        int maxC = matrix[0].length - 1;
        int minR = 0;
        int minC = 0;
        int total = matrix.length * matrix[0].length;
        int count = 0;
        List<Integer> list = new ArrayList<>();


        while (count < total) {

            for (int i = minC; i <= maxC && count < total; i++) {
                System.out.print(matrix[minR][i] + " ");
                count++;
                //list.add(matrix[row][i]);
            }
            minR++;
            for (int j = minR; j <= maxR && count < total; j++) {
                System.out.print(matrix[j][maxC] + " ");
                count++;
                //list.add(matrix[j][m]);
            }
            maxC--;
            for (int k = maxC; k >= minC && count < total; k--) {
                System.out.print(matrix[maxR][k] + " ");
                count++;
                // list.add(matrix[n][k]);
            }
            maxR--;
            for (int l = maxR; l >= minR && count < total; l--) {
                System.out.print(matrix[l][minC] + " ");
                count++;
            }
            minC++;
        }
    }*/

    public static void main(String[] args) {
        int[][] matrix = {
//                {1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}
                {7},{8},{9}
        };

        List<Integer> list = spiralOrder(matrix);
        for(Integer integer : list){
            System.out.println(integer);
        }
        //  System.out.println(spiralOrder(matrix));

    }
}

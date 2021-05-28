package br.pucrs;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.concurrent.Semaphore;

public class Matrix {
    private static final DecimalFormat df = new DecimalFormat("0.00");
    private Semaphore sem = new Semaphore(1);
    Element [][] matrix;
    int size;

    public  Matrix(int value){
        df.setRoundingMode(RoundingMode.DOWN);
        try {
            this.size = value;
            matrix = new Element[size][size];
            fillMatrix(matrix, size);
        }catch (NegativeArraySizeException e){
            System.out.println("Matrix size can't be negative!");
        }
    }

    public void phase1() {
        System.out.println("------------------------");
        calculateAverageLoop();
    }

    private void calculateAverageLoop() {
        for(int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
             double average =   calculateAverage(i, j);

            }
            System.out.println(" |");
        }
    }

    private double calculateAverage(int i, int j) {
        double average = 0;
        int count = 0;
        try {
           average += matrix[i +1][j].getValue();
           count++;
        }catch (ArrayIndexOutOfBoundsException e){

        }
        try {
            average += matrix[i -1][j].getValue();
            count++;
        }catch (ArrayIndexOutOfBoundsException e){}

        try {
            average += matrix[i][j +1].getValue();
            count++;
        }catch (ArrayIndexOutOfBoundsException e){}

        try {
            average += matrix[i][j -1].getValue();
            count++;
        }catch (ArrayIndexOutOfBoundsException e){}

        average = average/count;
        matrix[i][j].setAverage(average);
        System.out.print(" | "+df.format(matrix[i][j].getAverage()));
        return average;
    }

    public  void fillMatrix(Element [][] matrix, int size){
        for(int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){

                matrix[i][j] = new Element();
                System.out.print(" | " +(int)matrix[i][j].value);
            }
            System.out.println(" |");
        }
    }
}

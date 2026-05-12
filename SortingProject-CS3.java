//package chartsdemoapp;

import java.awt.event.ActionEvent;
import java.lang.reflect.Array;
import java.util.Arrays;
import javax.swing.*;
import java.awt.*;
/*
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

 */


public class Main {
    public static void main(String[] args) {
        //11/11/24
        //sequential search, binary search
        // selection sort, insertion sort, merge sort, bubble sort,

        //Integer[] array1 = {9, 34, 3, 10, 1, 4, -3};
        //System.out.println("Selection sort result: "+ Arrays.toString(selectionSort(array1)));
        //System.out.println("Insertion sort result: "+Arrays.toString(insertionSort(array1)));
        //System.out.println("Merge sort result: "+ Arrays.toString(mergeSort(array1)));
       // System.out.println("Bubble sort result: "+Arrays.toString(bubbleSort(array1)));

        Integer[] array = {9, 34, 3, 10, 1, 4, -3};
        Visualizer visualizer = new Visualizer(array);

        // Sorting algorithms with visualization
        /*
        selectionSort(array.clone(), visualizer);
        insertionSort(array.clone(), visualizer);
        bubbleSort(array.clone(), visualizer);
        mergeSort(array.clone(), visualizer);

         */
        visualizer.setAlgorithm("Selection Sort", Color.BLUE);
        selectionSort(array.clone(), visualizer);

        visualizer.setAlgorithm("Insertion Sort", Color.GREEN);
        insertionSort(array.clone(), visualizer);

        visualizer.setAlgorithm("Bubble Sort", Color.ORANGE);
        bubbleSort(array.clone(), visualizer);

        visualizer.setAlgorithm("Merge Sort", Color.RED);
        mergeSort(array.clone(), visualizer);

    }
    static Integer[] selectionSort(Integer[] array,Visualizer visualizer){
        System.out.println("------SELECTION SORT---------");
        int size = array.length;
        for (int step = 0; step < size - 1; step++) {
            int min_idx = step;
            for (int i = step + 1; i < size; i++) {
                // To sort in descending order, change > to < in this line.
                // Select the minimum element in each loop.
                if (array[i] < array[min_idx]) {
                    min_idx = i;
                }
            }
            // put min at the correct position
            int temp = array[step];
            array[step] = array[min_idx];
            array[min_idx] = temp;
            visualizer.update(array);
            try {
                Thread.sleep(700); // Slow down for visualization
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println(Arrays.toString(array));
        }
        return array;
    }

    static Integer[] insertionSort(Integer[] array, Visualizer visualizer){
        System.out.println("------INSERTION SORT---------");
        Integer[] tempArray = array;

        int size = array.length;
            for (int step = 1; step < size; step++) {
                int key = array[step]; //store each index's value in a temp var
                int j = step - 1;

                // Compare key with each element on the left of it until an element smaller than
                // it is found.
                // For descending order, change key<array[j] to key>array[j].
                while (j >= 0 && key < array[j]) {  //temp var key less than the index's value before it, then swap
                    array[j + 1] = array[j]; //switch part 1
                    tempArray[j+1]=array[j];
                    --j;
                    visualizer.update(array);
                    try {
                        Thread.sleep(700);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                // Place key at after the element just smaller than it.
                array[j + 1] = key; //switch part 2
                tempArray[j+1]=key;
                visualizer.update(array);
                // System.out.println("tempArray: "+ Arrays.toString(tempArray));
                System.out.println(Arrays.toString(array));
            }

            return array;

    }
    static Integer[] mergeSort(Integer[] a, Visualizer visualizer){
        //visualize more textually rather than with bar chart, bc its splitting and merging recursion
//        int count=0;
//        if (count==0) {
//            System.out.println("------MERGE SORT---------");
//            count++;
//        }
        //System.out.println("-----MERGE SORT-----");

            if (a.length >= 2) {
                // split array into two halves
                Integer[ ] left = Arrays.copyOfRange(a, 0, a.length/2);  //public static function of the Class Arrays (like  Math.pow or )
                Integer[ ] right = Arrays.copyOfRange(a, a.length/2, a.length); // new memory to store left and right arrays

                // sort the two halves
                mergeSort(left,  visualizer);  //recursion!!!
                mergeSort(right,  visualizer);

                // merge the sorted halves into a sorted whole
                merge(a, left, right, visualizer); //^split split split (using recursion), now merge
                //count=1;
            }
            return a;
    }
    public static void merge(Integer[ ] result, Integer[ ] left, Integer[ ] right, Visualizer visualizer) {
        //passed in 3 int arrays
        // Merges the left/right elements into a sorted result.
        // Precondition: left/right are sorted
        int i1 = 0;  // index into left array
        int i2 = 0;  // index into right array

        for (int i = 0; i < result.length; i++) {
            if ( i2 >= right.length  ||  ( i1 < left.length && left[i1] <= right[i2] ) ) {
                result [ i ] = left [ i1 ]; // take from left
                i1++;
            } else {
                result [ i ] = right [ i2 ]; // take from right
                i2++;
            }
            visualizer.update(result);
            try {
                Thread.sleep(700);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    static Integer[] bubbleSort(Integer[] array, Visualizer visualizer){
        System.out.println("------BUBBLE SORT---------");
        int size = array.length;
        // loop to access each array element
        for (int i = 0; i < size - 1; i++)
            // loop to compare array elements
            for (int j = 0; j < size - i - 1; j++)
                // compare two adjacent elements
                // change > to < to sort in descending order
                if (array[j] > array[j + 1]) {
                    // swapping occurs if elements
                    // are not in the intended order
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    visualizer.update(array);
                    try {
                        Thread.sleep(700);

                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
        return array;
    }
}
class Visualizer extends JPanel {
    private Integer[] array;
    private String algorithm = "";
    private Color barColor = Color.BLUE;

    public Visualizer(Integer[] array) {
        this.array = array.clone();
        JFrame frame = new JFrame("Sorting Visualizer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);
        frame.add(this);
        frame.setVisible(true);
    }
    public void setAlgorithm(String algorithm, Color barColor) {
        this.algorithm = algorithm;
        this.barColor = barColor;
        repaint();
    }
    public void update(Integer[] array) {
        this.array = array.clone();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        int barWidth = width / array.length;
        int max = Arrays.stream(array).max(Integer::compare).orElse(1);

        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString(algorithm, 10, 20);

        for (int i = 0; i < array.length; i++) {
            int barHeight = (int) (((double) array[i] / max) * (height - 50));
            g.setColor(barColor);
            g.fillRect(i * barWidth, height - barHeight - 30, barWidth - 2, barHeight);
            g.setColor(Color.BLACK);
            g.drawString(array[i].toString(), i * barWidth + barWidth / 4, height - 10);
        }
    }
}

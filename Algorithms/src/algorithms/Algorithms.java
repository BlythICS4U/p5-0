/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

/**
 *
 * @author cgallinaro
 */
public class Algorithms {
    
    public static final String FILE_NAME = "intArray100.bin";

    public static void main(String[] args) {

        ObjectInputStream ois = null;
        Scanner keyboard = new Scanner(System.in);
        int[] numbers = null;

        try {
            File file = new File(FILE_NAME);
            FileInputStream fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);
            
            System.out.println("Reading in array");
            numbers = (int[]) ois.readObject();
            System.out.println("Read in " + numbers.length + " numbers");
           
        } catch (FileNotFoundException ex) {
            System.out.println("Exception occurred: ");
            ex.printStackTrace(System.out);
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Exception occurred:");
            ex.printStackTrace(System.out);
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ioe) {
                System.out.println("Exception occurred:");
                ioe.printStackTrace(System.out);
            }
        }
        
        IntegerSet set = new IntegerSet(numbers);
        
        printAverage(set);
        printRange(set);
        printMedian(set);
    }
    
    private static void printAverage(IntegerSet set) {
        long startTime = System.nanoTime();
        double average = set.getAverage();
        long endTime = System.nanoTime();

        long duration = (endTime - startTime);  // divide by 1000000 to get milliseconds.
        
        System.out.println("Average is: " + average + " (took " + duration + " nanoseconds)");
    }
    
    private static void printRange(IntegerSet set) {
        long startTime = System.nanoTime();
        int range = set.getRange();
        long endTime = System.nanoTime();

        long duration = (endTime - startTime);  // divide by 1000000 to get milliseconds.
        
        System.out.println("Range is: " + range + " (took " + duration + " nanoseconds)");
    }
    
    private static void printMedian(IntegerSet set) {
        long startTime = System.nanoTime();
        double median = set.getMedian();
        long endTime = System.nanoTime();

        long duration = (endTime - startTime);  // divide by 1000000 to get milliseconds.
        
        System.out.println("Median is: " + median + " (took " + duration + " nanoseconds)");
    }
    
}

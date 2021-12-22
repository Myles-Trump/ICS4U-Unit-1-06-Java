/*
* This is a program that calculates mean, median and mode
* after reading in a text file into an array.
*
* @author  Myles Trump
* @version 1.0
* @since   2021-12-03
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

/**
* This is the statistics program.
*/
final class Statistics {

    /**
    * Prevent instantiation
    * Throw an exception IllegalStateException.
    * if this ever is called
    *
    * @throws IllegalStateException
    *
    */
    private Statistics() {
        throw new IllegalStateException("Cannot be instantiated");
    }

    /**
    * The mean() function.
    *
    * @param arrayOfIntegers the collection of integers
    * @return the mean of the integers
    */
    public static double mean(final Integer[] arrayOfIntegers) {

        int arrayLength = arrayOfIntegers.length;
        double arraySum = 0;

        for (int arrayValue = 0; arrayValue < arrayLength; arrayValue++) {
            arraySum = arraySum + arrayOfIntegers[arrayValue];
        }

            double mean = arraySum / arrayLength;
            return mean;
    }

    /**
    * The median() function.
    *
    * @param arrayOfIntegers the collection of integers
    * @return the median of the integers
    */
    public static double median(final Integer[] arrayOfIntegers) {

        Arrays.sort(arrayOfIntegers);
        int arrayLength = arrayOfIntegers.length;

        if (arrayLength % 2 == 0) {
            int middleValue1 = arrayOfIntegers[arrayLength / 2];
            int middleValue2 = arrayOfIntegers[(arrayLength / 2) + 1];
            double median = (middleValue1 + middleValue2) / 2;
            return median;
        } else {
            return arrayOfIntegers[arrayLength / 2];
        }
    }

    //**
    //* The mode() function.
    //*
    //* @param numbers the collection of integers
    //* @return the mode of the integers
    //*/
    //public static List<Integer> mode(final Integer[] numbers) {

    //    return mode;
    //}

    /**
    * The starting main() function.
    *
    * @param args No args will be used
    */
    public static void main(final String[] args) {
        Integer tempNumber;
        final ArrayList<Integer> listOfNumbers = new ArrayList<Integer>();
        final Path filePath = Paths.get("./", args[0]);
        final Charset charset = Charset.forName("UTF-8");

        try (BufferedReader reader = Files.newBufferedReader(
                                     filePath, charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                tempNumber = Integer.parseInt(line);
                listOfNumbers.add(tempNumber);
            }
        } catch (IOException errorCode) {
            System.err.println(errorCode);
        }

        final Integer[] arrayOfNumbers = listOfNumbers.toArray(new Integer[0]);
        System.out.println(Arrays.toString(arrayOfNumbers));

        System.out.println("\nCalculating stats...");
        final double mean = mean(arrayOfNumbers);
        final double median = median(arrayOfNumbers);
        // final List<Integer> mode = mode(arrayOfNumbers);

        System.out.println("The mean is: " + mean);
        System.out.println("The median is: " + median);
        // System.out.println("The mode(s) is/are: "
                            // + Arrays.toString(mode.toArray()));

        System.out.println("\nDone.");
    }
}

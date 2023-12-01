package com.codegym.task.task33.task3310;

import com.codegym.task.task33.task3310.strategy.*;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {

        testStrategy(new HashMapStorageStrategy(), 10000);
        System.out.println("----------------------");
        testStrategy(new OurHashMapStorageStrategy(), 10000);
        System.out.println("----------------------");
        testStrategy(new OurHashBiMapStorageStrategy(), 10000);
        System.out.println("----------------------");
        testStrategy(new HashBiMapStorageStrategy(), 10000);
        System.out.println("----------------------");
        testStrategy(new DualHashBidiMapStorageStrategy(), 10000);


    }

    public static Set<Long> getIds(Shortener shortener, Set<String> strings){
        Set<Long> result = new HashSet<>();

        for (String string : strings) {
            result.add(shortener.getId(string));
        }

        return result;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys){
        Set<String> result = new HashSet<>();

        for (Long key : keys) {
            result.add(shortener.getString(key));
        }

        return result;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber){
//        6.2.3. testStrategy(StorageStrategy strategy, long elementsNumber).
//        The method will test the passed strategy on a specific number of elements (elementsNumber).
//        The implementation should:
//        6.2.3.1. Display the name of the class strategy. The name must not include the package name. OK
//        6.2.3.2. Generate a test set using Helper and the specified number of elements (elementsNumber). OK
//        6.2.3.3. Create a Shortener object using the passed strategy. OK
//        6.2.3.4. Measure and display the time required to run the getIds method for the given strategy and the given set of elements.
//        Display time in milliseconds. When measuring the method's execution time,
//        you can ignore the processor switching to other threads, as well as the time spent on the call itself,
//        returning values, and calling methods to get the time (date). Measure time using Date objects. OK
//        6.2.3.5. Measure and display the time required to run the getStrings method for a given strategy
//        and the set of identifiers obtained in the previous clause. OK
//        6.2.3.6. Check whether the contents of the set of generated strings and the set returned by getStrings method are the same.
//        If the sets are the same, then display "The test passed.". Otherwise, display "The test failed.".

        Helper.printMessage(strategy.getClass().getSimpleName());

        Set<String> testSet = new HashSet<>();
        for (int i = 0; i < elementsNumber; i++) {
            testSet.add(Helper.generateRandomString());
        }

        Shortener shortener = new Shortener(strategy);
        Date dateBeforeIds = new Date();
        Set<Long> ids = getIds(shortener, testSet);
        Date dateAfterIds = new Date();
        long processingTimeIds = dateAfterIds.getTime() - dateBeforeIds.getTime();
        Helper.printMessage(String.valueOf(processingTimeIds));

        Date dateBeforeStrings = new Date();
        Set<String> strings = getStrings(shortener, ids);
        Date dateAfterStrings = new Date();
        long processingTimeStrings = dateAfterStrings.getTime() - dateBeforeStrings.getTime();
        Helper.printMessage(String.valueOf(processingTimeStrings));

//        strings.add("test");

        boolean passed = true;
        for (String string : strings) {
            if (!testSet.contains(string)){
                passed = false;
                break;
            }
        }

        if (passed) Helper.printMessage("The test passed.");
        else Helper.printMessage("The test failed.");
    }
}

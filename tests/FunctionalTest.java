package com.codegym.task.task33.task3310.tests;


import org.junit.Assert;
import org.junit.Test;

import com.codegym.task.task33.task3310.strategy.*;
import com.codegym.task.task33.task3310.*;


public class FunctionalTest {

    // @Test
    public void testStorage(Shortener shortener) {
        String str1 = "string1";
        String str2 = "string2";
        String str3 = "string1";

        Long str11 = shortener.getId(str1);

        Long str22 = shortener.getId(str2);

        Long str33 = shortener.getId(str3);
        Assert.assertNotEquals(str11, str22);
        Assert.assertNotEquals(str33, str22);
        Assert.assertEquals(str11, str33);

        Assert.assertEquals(str1, shortener.getString(str11));
        Assert.assertEquals(str2, shortener.getString(str22));
        Assert.assertEquals(str3, shortener.getString(str33));

    }

    @Test
    public void testHashMapStorageStrategy() {
        HashMapStorageStrategy hashMapStorageStrategy = new HashMapStorageStrategy();
        Shortener shortener = new Shortener(hashMapStorageStrategy);
        testStorage(shortener);

    }

    @Test
    public void testOurHashMapStorageStrategy()
    {
        StorageStrategy ourHashMapStorageStrategy = new OurHashMapStorageStrategy();
        Shortener shortener = new Shortener(ourHashMapStorageStrategy);
        testStorage(shortener);
    }
    @Test
    public void testFileStorageStrategy()
    {
        FileStorageStrategy fileStorageStrategy = new FileStorageStrategy();
        Shortener shortener = new Shortener(fileStorageStrategy);
        testStorage(shortener);
    }
    @Test
    public void testHashBiMapStorageStrategy()
    {
        HashBiMapStorageStrategy hashBiMapStorageStrategy = new HashBiMapStorageStrategy();
        Shortener shortener = new Shortener(hashBiMapStorageStrategy);
        testStorage(shortener);
    }
    @Test
    public void testDualHashBidiMapStorageStrategy()
    {
        DualHashBidiMapStorageStrategy dualHashBidiMapStorageStrategy = new DualHashBidiMapStorageStrategy();
        Shortener shortener = new Shortener(dualHashBidiMapStorageStrategy);
        testStorage(shortener);
    }
    @Test
    public void testOurHashBiMapStorageStrategy()
    {
        OurHashBiMapStorageStrategy ourHashBiMapStorageStrategy = new OurHashBiMapStorageStrategy();
        Shortener shortener = new Shortener(ourHashBiMapStorageStrategy);
        testStorage(shortener);
    }

}
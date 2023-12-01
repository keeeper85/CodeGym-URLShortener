package com.codegym.task.task33.task3310.tests;

import com.codegym.task.task33.task3310.Helper;
import com.codegym.task.task33.task3310.Shortener;
import com.codegym.task.task33.task3310.strategy.HashBiMapStorageStrategy;
import com.codegym.task.task33.task3310.strategy.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class SpeedTest {

    public long getTimeToGetIds(Shortener shortener, Set<String> strings, Set<Long> ids){
        Date before = new Date();
        for (String string : strings) {
            ids.add(shortener.getId(string));
        }
        Date after = new Date();
        return after.getTime() - before.getTime();
    }

    public long getTimeToGetStrings(Shortener shortener, Set<Long> ids, Set<String> strings){
        Date before = new Date();
        for (Long key : ids) {
            strings.add(shortener.getString(key));
        }
        Date after = new Date();
        return after.getTime() - before.getTime();
    }

    @Test
    public void testHashMapStorage(){
        Shortener shortenerMap = new Shortener(new HashMapStorageStrategy());
        Shortener shortenerBiMap = new Shortener(new HashBiMapStorageStrategy());

        Set<String> origStrings = new HashSet<>();
        Set<Long> origIds = new HashSet<>();
        for (int i = 0; i < 10000; i++) {
            origStrings.add(Helper.generateRandomString());
        }

        long mapResultIds = getTimeToGetIds(shortenerMap, origStrings, origIds);
        long bimapResultIds = getTimeToGetIds(shortenerBiMap, origStrings, origIds);

        Assert.assertTrue(mapResultIds > bimapResultIds);

        long mapResultStrings = getTimeToGetStrings(shortenerMap, origIds, origStrings);
        long bimapResultStrings = getTimeToGetStrings(shortenerBiMap, origIds, origStrings);

//        Assert.assertTrue(mapResultStrings > bimapResultStrings);

        Assert.assertEquals(mapResultStrings, bimapResultStrings, 30);

    }
}

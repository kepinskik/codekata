package com.codewars.dubstep;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class DubstepTest {

    @Test
    public void testIdentity() {
        assertEquals("ABC", new Dubstep().SongDecoder("ABC"));
    }

    @Test
    public void testDecoding() {
        assertEquals("A", new Dubstep().SongDecoder("WUBA"));
        assertEquals("A", new Dubstep().SongDecoder("WUBWUBA"));
        assertEquals("A", new Dubstep().SongDecoder("WUBWUBAWUB"));
        assertEquals("A B", new Dubstep().SongDecoder("WUBWUBAWUBB"));
        assertEquals("A B", new Dubstep().SongDecoder("AWUBWUBB"));
        assertEquals("A B", new Dubstep().SongDecoder("AWUBWUBWUBWUBB"));
        assertEquals("A B", new Dubstep().SongDecoder("AWUBWUBWUBWUBWUBB"));
        assertEquals("A B", new Dubstep().SongDecoder("AWUBWUBWUBWUBWUBWUBB"));
        assertEquals("A B", new Dubstep().SongDecoder("AWUBWUBWUBWUBWUBWUBWUBB"));
        assertEquals("A B", new Dubstep().SongDecoder("AWUBWUBWUBWUBWUBWUBWUBWUBB"));
    }

    @Test
    public void testLargeAmountsOfWub() {
        for (int i = 1; i < 101; i++) {
            assertEquals("Number of WUBs = " + String.valueOf(i) ,"A B", new Dubstep().SongDecoder("A" + generateWubs(i) + "B"));
        }
    }

    private String generateWubs(int n) {
        String wubs = "";
        for (int i = 0; i < n; i++) {
            wubs = wubs.concat("WUB");
        }
        return wubs;
    }

    @Test
    public void Test1() {
        assertEquals("ABC", new Dubstep().SongDecoder("WUBWUBABCWUB"));
    }
    @Test
    public void Test2()
    {
        assertEquals("R L", new Dubstep().SongDecoder("RWUBWUBWUBLWUB"));
    }
}

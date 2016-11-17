package com.codewars.dubstep;

public class Dubstep {

    private final String wub = "(WUB)+";

    public String SongDecoder(String dubbed) {
        String decoded = dubbed.replaceAll(wub, " ");
        return decoded.trim();
    }
}

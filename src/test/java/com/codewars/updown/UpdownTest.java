package com.codewars.updown;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UpdownTest {

    private static void testing(String actual, String expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void tddTests() {
        testing(Updown.arrange(""), "");
        testing(Updown.arrange("Word"), "word");
        testing(Updown.arrange("a bc"), "a BC");
        testing(Updown.arrange("bc a"), "a BC");
        testing(Updown.arrange("bc a D"), "a BC d");
        testing(Updown.arrange("bc A def"), "a DEF bc");
    }

    @Test
    public void test() {
        System.out.println("Fixed Tests arrange");

        testing(Updown.arrange("who hit retaining The That a we taken"),
                "who RETAINING hit THAT a THE we TAKEN"); // 3
        testing(Updown.arrange("on I came up were so grandmothers"),
                "i CAME on WERE up GRANDMOTHERS so"); // 4
        testing(Updown.arrange("way the my wall them him"),
                "way THE my WALL him THEM"); // 1
        testing(Updown.arrange("turn know great-aunts aunt look A to back"),
                "turn GREAT-AUNTS know AUNT a LOOK to BACK"); // 2

    }
}

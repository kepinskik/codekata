package com.codewars.updown;

public class Updown {
    public static String arrange(String strng) {
        SwappingStringArray words = new SwappingStringArray(strng);
        words.processAll();
        return words.toString();
    }

    private static class SwappingStringArray {

        private final String separator = " ";
        private String[] base;
        private int currentItemNumber;

        public SwappingStringArray(String toSplit) {
            base = toSplit.split(separator);
        }

        public void processAll() {
            currentItemNumber = 1;
            do {
                processCurrent();
                moveNext();
            }
            while ( !currentBeyondLast() );
        }

        private void processCurrent() {
            if( hasNext() && shouldSwapCurrentWithNext() ) {
                swapWithNext();
            }
            fixCaseForCurrent();
        }

        private void moveNext() {
            currentItemNumber++;
        }

        private boolean currentBeyondLast() {
            return currentItemNumber > base.length;
        }

        private boolean hasNext() {
            return currentItemNumber < base.length;
        }

        private boolean shouldSwapCurrentWithNext() {
            if(currentItemNumber % 2 == 1) {
                return isLongerThan(getCurrent(), getNext());
            }
            else return isLongerThan(getNext(), getCurrent());
        }

        private boolean isLongerThan(String a, String b) {
            return a.length() > b.length();
        }

        private void swapWithNext() {
            String valueTemp = getCurrent();
            setCurrent( getNext() );
            setNext( valueTemp );
        }

        private void fixCaseForCurrent() {
            if(currentItemNumber % 2 == 1) {
                lowerify();
            }
            else upperify();
        }

        private void upperify() {
            setCurrent( getCurrent().toUpperCase() );
        }

        private void lowerify() {
            setCurrent( getCurrent().toLowerCase() );
        }

        private String getCurrent() {
            return base[currentItemNumber - 1];
        }

        private void setCurrent(String value) {
            base[currentItemNumber - 1] = value;
        }

        private String getNext() {
            return base[currentItemNumber];
        }

        private void setNext(String value) {
            base[currentItemNumber] = value;
        }

        @Override
        public String toString() {
            return String.join(separator, base);
        }
    }

}
package me.sudohippie.weather.util;

/**
 * Raghav Sidhanti
 * 9/20/13
 */
public class Assert {
    public static void notNull(Object obj, String message){
        if(obj == null) throw new IllegalArgumentException(message);
    }

    public static void notBlank(String str, String message){
        // check string is not null
        notNull(str, message);

        int strLength = str.length();
        int blankCtr = 0;
        // go through each character,
        for(int i = 0; i < strLength; i++){
            Character strChar = Character.valueOf(str.charAt(i));
            if(!strChar.equals(' ')) break;

            blankCtr ++;
        }

        // if all the characters are blank spaces, throw exception
        if(blankCtr == strLength) throw new IllegalArgumentException(message);
    }

    public static void isTrue(boolean bool, String message){
        if(!bool) throw new IllegalArgumentException(message);
    }
}

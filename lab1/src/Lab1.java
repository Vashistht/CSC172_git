import java.util.Arrays;
import java.util.Scanner;

public class Lab1 {

    /* isAnagram: a static class that returns a boolean
    - It takes in two strings and returns true or false for isAnagram
    - returns true if it is an anagram and false if it is not */

    static boolean isAnagram(String str1, String str2) {
        // if the length is different they cannot be anagrams
        if (str1.length() != str2.length()) {
            return false;
        }
        char[] listStr1 = str1.toCharArray(); // create an array of chracters in string 1
        char[] listStr2 = str2.toCharArray(); // create an array of chracters in string 2
        Arrays.sort(listStr1); // sort the array_string1
        Arrays.sort(listStr2); //  sort the array_string2
        return Arrays.equals(listStr1, listStr2); // compare if the sorted string arrays are the same
    }

    /* isRotation: a static class that returns a boolean
    - It takes in two strings and returns true or false for isRotation
    - returns true if it is a rotation and false if it is not */

    static boolean isRotation(String str1, String str2) {
        // if the length is different they cannot be rotations
        if (str1.length() != str2.length()) {
            return false;
        }
        str1 = str1.concat(str1);
        if (str1.contains(str2)) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        while (true) {
            Scanner keyboardInput = new Scanner(System.in);
            System.out.print("Enter String 1: "); //  get user input for string 1
            String str1 = keyboardInput.nextLine();

            System.out.print("Enter String 2: "); //  get user input for string 2
            String str2 = keyboardInput.nextLine();
            // print the final result for isAnagram
            System.out.println(str1 + " and " + str2 + " are anagrams: " + isAnagram(str1, str2));
            System.out.println(str1 + " and " + str2 + " are rotations: " + isRotation(str1, str2));

            System.out.print("Press quit to quit, enter to continue: "); //  get user input for string 2
            String str3 = keyboardInput.nextLine();
            if (str3.equalsIgnoreCase("quit")) {
                break;
            } else {
                continue;
            }
        }
    }
}

/* This one is without wrapper (only works once)
 */

//import java.util.Arrays;
//import java.util.Scanner;
//
//public class Main {
//
//    /* isAnagram: a static class that returns a boolean
//    - It takes in two strings and returns true or false for isAnagram
//    - returns true if it is an anagram and false if it is not */
//    static boolean isAnagram(String str1, String str2) {
//        // if the length is different they cannot be anagrams
//        if (str1.length() != str2.length()) {
//            return false;
//        }
//        char[] listStr1 = str1.toCharArray(); // create an array of chracters in string 1
//        char[] listStr2 = str2.toCharArray(); // create an array of chracters in string 2
//        Arrays.sort(listStr1); // sort the array_string1
//        Arrays.sort(listStr2); //  sort the array_string2
//        return Arrays.equals(listStr1, listStr2); // compare if the sorted string arrays are the same
//    }
//
//    /* isRotation: a static class that returns a boolean
//    - It takes in two strings and returns true or false for isRotation
//    - returns true if it is a rotation and false if it is not */
//
//    static boolean isRotation(String str1, String str2) {
//        // if the length is different they cannot be rotations
//        if (str1.length() != str2.length()) {
//            return false;
//        }
//        str1 = str1.concat(str1); //why does str3 not work here?
//        if (str1.contains(str2)){
//            return true;
//        }
//        return false;
//    }
//
//
//    public static void main(String[] args) {
//        Scanner keyboardInput = new Scanner(System.in);
//        System.out.print("Enter String 1: "); //  get user input for string 1
//        String str1 = keyboardInput.nextLine();
//
//        System.out.print("Enter String 2: "); //  get user input for string 2
//        String str2 = keyboardInput.nextLine();
//        // print the final result for isAnagram
//        System.out.println(str1 + " and " + str2 + " are anagrams: " + isAnagram(str1, str2));
//        System.out.println(str1 + " and " + str2 + " are rotations: " + isRotation(str1, str2));
//    }
//}

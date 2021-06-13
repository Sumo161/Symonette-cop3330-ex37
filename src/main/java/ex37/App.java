package ex37;

import java.util.*;

public class App {public static void main(String[] args) {
    Scanner inputScanner = new Scanner(System.in);
    ArrayList<String> passwordChars = new ArrayList<>();

    System.out.print("What is the minimum length? ");
    int minLength = inputScanner.nextInt();
    System.out.print("How many special characters? ");
    int numSpecialChars = inputScanner.nextInt();
    System.out.print("How many numbers? ");
    int numNumbers = inputScanner.nextInt();

    // generate special characters
    String specialChars = generateRandomString(" !\"#$%&'()*+,-./:;<=>?@[]^_`{|}~", numSpecialChars);
    // generate numbers
    String numbers = generateRandomString("0123456789", numNumbers);
    // generate remaining alpha numeric characters
    String alphaNumerics = generateRandomString("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ",
            minLength - (numSpecialChars + numNumbers));

    // add the random strings to the list of password characters
    passwordChars.addAll(new ArrayList<String>(Arrays.asList(specialChars)));
    passwordChars.addAll(new ArrayList<String>(Arrays.asList(numbers)));
    passwordChars.addAll(new ArrayList<String>(Arrays.asList(alphaNumerics)));
    // randomize the characters
    Collections.shuffle(passwordChars);
    String randomPassword = String.join("", passwordChars);

    System.out.println("Your password is " + randomPassword);

    inputScanner.close();
}

    private static String generateRandomString(String charset, int length) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {

            // generate random index number
            int index = random.nextInt(charset.length());
            // fetch character at the given index
            char randomChar = charset.charAt(index);

            // append the character to string builder
            sb.append(randomChar);
        }

        return sb.toString();
    }
}


import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;
import Acc.*;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ADMIN
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here       
        Menu menu = new Menu();
        Locale Vietname = new Locale("vn");
        Locale English = new Locale("en");
        List list = new List();
        ArrayList<Account> accounts = list.database();
        while (true) {
            int choice = menu.getChoice(1, 3);
            switch (choice) {
                case 1:
                    login(Vietname, accounts);
                    break;
                case 2:
                    login(English, accounts);
                    break;
                case 3:
                    return;
            }
        }
    }

    static void getWordLanguage(Locale language, String key) {
        ResourceBundle rb = ResourceBundle.getBundle("Language", language);
        String output = rb.getString(key);
        System.out.print(output);

    }

    public static String inputAccount(Locale language) {
        Scanner sc = new Scanner(System.in);
        //loop until user enter corrcect
        while (true) {
            System.out.println("");
            getWordLanguage(language, "accountNumber");
            String acc = sc.nextLine();
            if (acc.isEmpty()) {
                getWordLanguage(language, "accountError");
            } else {
                if (!acc.matches("^\\d{10}$")) {
                    getWordLanguage(language, "accountError");
                } else {
                    return acc;
                }
            }
        }
    }

    public static String inputPassword(Locale language) {
        Scanner sc = new Scanner(System.in);
        //loop until user enter corrcect
        while (true) {
            getWordLanguage(language, "password");
            String pass = sc.nextLine();
            if (pass.isEmpty()) {
                getWordLanguage(language, "passwordError");
            } else {
                if (isValidPassword(pass, language)) {
                    return pass;
                }
            }
        }
    }

    static boolean isValidPassword(String password, Locale language) {
        int lengthPassword = password.length();
        if (lengthPassword < 8 || lengthPassword > 31) {
            getWordLanguage(language, "passwordError");
            System.out.println();
            return false;
        } else {
            int countDigit = 0;
            int countLetter = 0;
            for (int i = 0; i < lengthPassword - 1; i++) {
                if (Character.isDigit(password.charAt(i))) {
                    countDigit++;
                } else if (Character.isLetter(password.charAt(i))) {
                    countLetter++;
                }
            }
            if (countDigit < 1 || countLetter < 1) {
                getWordLanguage(language, "passwordError");
                System.out.println();
                return false;
            }
        }
        return true;
    }

    public static String inputCaptcha(Locale language) {
        Scanner sc = new Scanner(System.in);
        //loop until user enter corrcect
        while (true) {
            getWordLanguage(language, "captchaInput");
            String captcha = sc.nextLine();
            if (captcha.isEmpty()) {
                getWordLanguage(language, "captchaInputError");
            } else {
                return captcha;
            }
        }
    }

    static boolean checkInputCaptcha(String captchaGenerated, Locale language) {
        getWordLanguage(language, "captcha");
        System.out.println(captchaGenerated);

        String captchaInput = inputCaptcha(language);
        for (int i = 0; i < captchaInput.length(); i++) {
            if (!captchaGenerated.contains(Character.toString(captchaInput.charAt(i)))) {
                return false;
            }
        }
        return true;
    }

    static String generateCaptcha(int n) {
        Random rand = new Random(62);
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String captcha = "";
        while (n-- > 0) {
            int index = (int) (Math.random() * 62);
            captcha += chars.charAt(index);
        }

        return captcha;
    }

    public static Account checkAccount(String acc, String pass, ArrayList<Account> accounts) {
        for (Account account : accounts) {
            if (pass.equalsIgnoreCase(account.getPasswords()) && acc.equalsIgnoreCase(account.getAcount())) {
                return account;
            }
        }
        return null;
    }

    public static void login(Locale language, ArrayList<Account> accounts) {
        String accountNumber = inputAccount(language);
        String passString = inputPassword(language);
        String captchaGenerated = generateCaptcha(6);
        Account account = checkAccount(accountNumber, passString, accounts);
        while (true) {
            if (!checkInputCaptcha(captchaGenerated, language)) {
                getWordLanguage(language, "captchaInputError");
                System.out.println();
            } else {
                if (account != null) {
                    getWordLanguage(language, "loginSuccess");
                    System.out.println();
                    break;
                }
            }
        }
    }
}

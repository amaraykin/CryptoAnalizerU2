package com.javarush.maraykin;

import java.util.Scanner;

public class MainRunner {
    private static final Cipher cipher = new Cipher(Alphabet.ALPHABET);
    private static final FileManager fileManager = new FileManager();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Программа шифрования Цезаря");
        System.out.println("=========================");

        while (true) {
            showMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    encryptMode();
                    break;
                case "2":
                    decryptMode();
                    break;
                case "3":
                    System.out.println("Выход из программы...");
                    return;
                default:
                    System.out.println("Попробуйте снова.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\nВыберите режим:");
        System.out.println("1. Шифрование текста");
        System.out.println("2. Расшифровка текста");
        System.out.println("3. Выход");
        System.out.print("Ваш выбор: ");
    }

    private static void encryptMode() {
        try {
            System.out.print("Введите путь к исходному файлу: ");
            String inputFile = scanner.nextLine();

            System.out.print("Введите путь для зашифрованного файла: ");
            String outputFile = scanner.nextLine();

            System.out.print("Введите ключ сдвига: ");
            int key = Integer.parseInt(scanner.nextLine());

            String text = fileManager.readFile(inputFile);
            String encryptedText = cipher.encrypt(text, key);
            fileManager.writeFile(encryptedText, outputFile);

            System.out.println("Текст успешно зашифрован и сохранён в: " + outputFile);
        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }

    private static void decryptMode() {
        try {
            System.out.print("Введите путь к зашифрованному файлу: ");
            String inputFile = scanner.nextLine();

            System.out.print("Введите путь для расшифрованного файла: ");
            String outputFile = scanner.nextLine();

            System.out.print("Введите ключ сдвига: ");
            int key = Integer.parseInt(scanner.nextLine());

            String encryptedText = fileManager.readFile(inputFile);
            String decryptedText = cipher.decrypt(encryptedText, key);
            fileManager.writeFile(decryptedText, outputFile);

            System.out.println("Текст успешно расшифрован и сохранён в: " + outputFile);
        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}


import java.io.*;
import java.util.Scanner;
public class FileHandlingUtility {


    /**
      A utility script to demonstrate various file handling operations in Java.
      Operations include:
      1. Creating a file
      2. Writing to a file
      3. Reading from a file
      4. Appending to a file
      5. Deleting a file
     */


        // Path to the file
        private static final String FILE_NAME = "New Folder.txt";

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            boolean running = true;

            while (running) {
                System.out.println("\nFile Handling Operations:");
                System.out.println("1. Create a file");
                System.out.println("2. Write to the file");
                System.out.println("3. Read from the file");
                System.out.println("4. Append to the file");
                System.out.println("5. Delete the file");
                System.out.println("6. Exit");
                System.out.print("Choose an option: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline

                switch (choice) {
                    case 1 -> createFile();
                    case 2 -> {
                        System.out.print("Enter text to write to the file: ");
                        String content = scanner.nextLine();
                        writeFile(content);
                    }
                    case 3 -> readFile();
                    case 4 -> {
                        System.out.print("Enter text to append to the file: ");
                        String content = scanner.nextLine();
                        appendToFile(content);
                    }
                    case 5 -> deleteFile();
                    case 6 -> {
                        running = false;
                        System.out.println("Exiting program. Goodbye!");
                    }
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            }

            scanner.close();
        }

        /**
          Creates a new file.
         */
        public static void createFile() {
            try {
                File file = new File(FILE_NAME);
                if (file.createNewFile()) {
                    System.out.println("File created: " + file.getName());
                } else {
                    System.out.println("File already exists.");
                }
            } catch (IOException e) {
                System.out.println("An error occurred while creating the file.");
                e.printStackTrace();
            }
        }

        /**
         * Writes the given content to the file. Overwrites existing content.
         *
         * @param content The content to write to the file.
         */
        public static void writeFile(String content) {
            try (FileWriter writer = new FileWriter(FILE_NAME)) {
                writer.write(content);
                System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred while writing to the file.");
                e.printStackTrace();
            }
        }

        /**
         * Reads and displays the content of the file.
         */
        public static void readFile() {
            try (Scanner reader = new Scanner(new File(FILE_NAME))) {
                System.out.println("File content:");
                while (reader.hasNextLine()) {
                    System.out.println(reader.nextLine());
                }
            } catch (FileNotFoundException e) {
                System.out.println("The file does not exist.");
                e.printStackTrace();
            }
        }

        /**
         * Appends the given content to the file.
         *
         * @param content The content to append to the file.
         */
        public static void appendToFile(String content) {
            try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
                writer.write(content + System.lineSeparator());
                System.out.println("Successfully appended to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred while appending to the file.");
                e.printStackTrace();
            }
        }

        /**
         * Deletes the file.
         */
        public static void deleteFile() {
            File file = new File(FILE_NAME);
            if (file.delete()) {
                System.out.println("File deleted: " + file.getName());
            } else {
                System.out.println("Failed to delete the file. It may not exist.");
            }
        }


}

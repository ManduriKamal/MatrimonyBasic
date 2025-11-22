package com.Matrimony;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        MatrimonyManager manager = new MatrimonyManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Matrimony Application ---");
            System.out.println("1. Register Profile");
            System.out.println("2. View All Profiles");
            System.out.println("3. Find Matches");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Gender (Male/Female): ");
                    String gender = sc.nextLine();

                    System.out.print("Profession: ");
                    String profession = sc.nextLine();

                    System.out.print("City: ");
                    String city = sc.nextLine();

                    System.out.print("Preferred Match City: ");
                    String prefCity = sc.nextLine();

                    Candidate c = new Candidate(name, age, gender, profession, city, prefCity);
                    manager.registerCandidate(c);

                    System.out.println("Profile Registered Successfully!");
                    break;

                case 2:
                    manager.showAll();
                    break;

                case 3:
                    System.out.print("Enter your name to search matches: ");
                    String searchName = sc.nextLine();

                    Candidate user = null;

                    Candidate[] list = manager.getCandidates();

                    for (int i = 0; i < manager.getCount(); i++) {
                        if (list[i].getName().equalsIgnoreCase(searchName)) {
                            user = list[i];
                            break;
                        }
                    }

                    if (user == null) {
                        System.out.println("Profile not found!");
                        break;
                    }

                    Candidate[] matches = manager.findMatches(user, list, manager.getCount());

                    System.out.println("\n--- Matches Found ---");
                    boolean found = false;

                    for (Candidate m : matches) {
                        if (m != null) {
                            System.out.println(m);
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("No matches found.");
                    }
                    break;

                case 4:
                    System.out.println("Thank you for using the matrimony application!");
                    System.exit(0);
            }
        }
    }
}


import java.util.Scanner;

 class Services {

    Scanner sc = new Scanner(System.in);

    String[] names;
    int[][] marks;
    int count = 0;
     int maxStudent=0;

    public Services(int maxStudent) {
        names = new String[maxStudent];
        marks = new int[maxStudent][3];
    }

    public void add() {

        if (count == names.length) {
            System.out.println("Your list is full");
            return;
        }

        System.out.print("Enter number of student you want to add: ");
        int numberToAdd = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < numberToAdd && count < names.length; i++) {

            System.out.println("Enter details of Student " + (count + 1));

            System.out.print("Enter Name of Student: ");
            names[count] = sc.nextLine();

            for (int j = 0; j < 3; j++) {
                System.out.print("Enter Marks"+ (j + 1) +" :");
                marks[count][j] = sc.nextInt();
            }

            sc.nextLine();
            count++;
        }
		
        System.out.println("Student added successfully.");
		
		if (count == maxStudent){
			System.out.println("Limit exceeded");
		}

    }

    public void showReport() {

        if (count == 0) {
            System.out.println("Not found");
            return;
        }

        for (int i = 0; i < count; i++) {

            int total = 0;

            for (int j = 0; j < 3; j++) {
                total += marks[i][j];
            }

            double average = total / 3.0;

            String grade;

            if (average >= 85)
                grade = "A";
            else if (average >= 75)
                grade = "B";
            else if (average >= 65)
                grade = "C";
            else if (average >= 30)
                grade = "D";
            else
                grade = "F";

				System.out.println("Name : " + names[i]);
            System.out.println("Total : " + total);
				System.out.println("Average: " + average);
            System.out.println("Grade   : " + grade);
        }
    }

    public void search() {

        if (count == 0) {
            System.out.println("Not found");
            return;
        }

        sc.nextLine();

        System.out.print("Enter name of your student= ");
        String userIn = sc.nextLine();

        boolean isFound = false;

        for (int i = 0; i < count; i++) {

            if (names[i].equalsIgnoreCase(userIn)) {

                isFound = true;

                int total = 0;

                for (int j = 0; j < 3; j++) {
                    total += marks[i][j];
                }

                double average = total / 3.0;

                String grade;

                if (average >= 90)
                    grade = "A";
                else if (average >= 75)
                    grade = "B";
                else if (average >= 65)
                    grade = "C";
                else if (average >= 30)
                    grade = "D";
                else
                    grade = "F";
				System.out.print(names[i]+"Student Found");
                System.out.println("Name  : " + names[i]);
                System.out.println("Total : " + total);
                System.out.println("Average: " + average);
                System.out.println("Grade  : " + grade);

                return;
            }
        }

        if (!isFound) {
            System.out.println("Student not found.");
        }
    }
}
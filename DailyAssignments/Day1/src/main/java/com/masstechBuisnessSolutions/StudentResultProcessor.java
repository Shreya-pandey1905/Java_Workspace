package com.masstechBuisnessSolutions;

class Student {
    int studentId;
    int mathsMarks;
    int scienceMarks;
    int physicsMarks;

    public Student(int studentId, int mathsMarks, int scienceMarks, int physicsMarks) {
        this.studentId = studentId;
        this.mathsMarks = mathsMarks;
        this.scienceMarks = scienceMarks;
        this.physicsMarks = physicsMarks;

    }

    public double calculateTotalMarks() {
        double totalMarks = mathsMarks + scienceMarks + physicsMarks;
        return totalMarks;
    }

    public double calculateTotalPercentage() {
        return (calculateTotalMarks() / 300) * 100;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", mathsMarks=" + mathsMarks +
                ", scienceMarks=" + scienceMarks +
                ", physicsMarks=" + physicsMarks +
                '}';
    }

    public void calculateGrade() {
        double percentage = calculateTotalPercentage();

        if (percentage >= 90) {
            System.out.println("A");
        } else if (percentage >= 80) {
            System.out.println("B");
        } else if (percentage >= 60) {
            System.out.println("C");
        } else if (percentage >= 50) {
            System.out.println("D");
        } else {
            System.out.println("Fail");
        }


    }
}

 class StudentResultProcessor {
    public static void main(String[] args) {
        Student obj = new Student(101, 80,50,30);
        System.out.println(obj);
        System.out.println("Total Marks= " + obj.calculateTotalMarks());
        System.out.println("Total Percentage= " + obj.calculateTotalPercentage());
        obj.calculateGrade();
    }
}


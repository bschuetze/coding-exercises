import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.PriorityQueue;
/*
 * Create the Student and Priorities classes here.
 */

    class Student implements Comparable<Student> {
        // Unique id
        private int id;
        // Name
        private String name;
        // GPA
        private double cGPA;
        
        Student(int id, String name, double cgpa) {
            this.id = id;
            this.name = name;
            this.cGPA = cgpa;
        }
        
        public int getID() {
            return this.id;
        }
        
        public String getName() {
            return this.name;
        }
        
        public double getCGPA() {
            return this.cGPA;
        }
        
        @Override
        public int compareTo(Student o) {
            if (this.getCGPA() != o.getCGPA()) {
                return Double.compare(o.getCGPA(), this.getCGPA());
            }
            if (this.getName() != o.getName()) {
                return this.getName().compareTo(o.getName());
            }
            return this.getID() - o.getID();
        }
    }
    
    class Priorities {
        
        public List<Student> getStudents(List<String> events) {
            PriorityQueue<Student> pq = new PriorityQueue<Student>();
            for (String event : events) {
                if (event.startsWith("ENTER")) {
                    String[] eventValues = event.split(" ");
                    int id = Integer.parseInt(eventValues[3]);
                    String name = eventValues[1];
                    double cGPA = Double.parseDouble(eventValues[2]);
                    Student currentStudent = new Student(id, name, cGPA);
                    pq.add(currentStudent);
                } else { // SERVED
                    pq.poll();
                }
            }
            ArrayList<Student> ret = new ArrayList<>();
            while (pq.size() > 0) {
                ret.add(pq.poll());
            }
            return ret;
        }
    }


public class Solution {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();
    
    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());    
        List<String> events = new ArrayList<>();
        
        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        
        List<Student> students = priorities.getStudents(events);
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}
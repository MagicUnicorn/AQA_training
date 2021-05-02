import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class UniversityZhdanovAnna {

    public static void main(String[] args) {
        calcPoints();
    }

    public static void calcPoints() {
        Map<Student, Task[]> objs = initObjects();
        for (Map.Entry<Student, Task[]> entry : objs.entrySet()) {
            Task[] tasks = entry.getValue();
            int countPoints = 0;
            for (int i = 0; i < tasks.length; i++) {
                countPoints += tasks[i].countPoints;
            }
            System.out.println("Student " + entry.getKey().surname + " " + entry.getKey().name + " have points : " + countPoints);
        }
    }

    public static Map<Student, Task[]> initObjects() {
        Map<Student, Task[]> collection = new HashMap<Student, Task[]>();
        for (int i = 0; i < 7; i++) {
            Student student = getStudent();
            Practice practice = getPractice();
            Lecture lecture = getLecture();
            Task[] tasks = {practice, lecture};
            collection.put(student, tasks);
        }

        return collection;
    }

    public static Student getStudent() {
        String[] maleSurnames = {"Ivanov", "Petrov", "Sidorov", "Arshavin", "Svetoch"};
        String[] maleNames = {"Andrei", "Ivan", "Igor", "Viktor", "Dmitry"};
        String[] femaleSurnames = {"Ivanova", "Petrova", "Sidorova", "Arshavina", "Svetocheva"};
        String[] femaleNames = {"Kate", "Yulia", "Sasha", "Tania"};
        int choiceType = getRandomInt(1, 2);
        int choiceAge = getRandomInt(16, 28);
        int choiceName;
        int choiceSurname;
        Student result = null;
        switch (choiceType) {
            case 1:
                choiceName = getRandomInt(0, maleNames.length-1);
                choiceSurname = getRandomInt(0, maleSurnames.length-1);
                return new BoyStudent(maleSurnames[choiceSurname], maleNames[choiceName], choiceAge);
            case 2:
                choiceName = getRandomInt(0, femaleNames.length-1);
                choiceSurname = getRandomInt(0, femaleSurnames.length-1);
                return new GirlStudent(femaleSurnames[choiceSurname], femaleNames[choiceName], choiceAge);
            default:
                break;
        }
        return null;
    }

    public static Lecture getLecture() {
        int choicePoints = getRandomInt(1, 10);
        Lecture lecture = new Lecture("Lecture", choicePoints);
        return lecture;
    }

    public static Practice getPractice() {
        int choicePoints = getRandomInt(10, 100);
        int choiceLevel = getRandomInt(1, 3);
        Practice result = new Practice("Practice", choicePoints, choiceLevel);
        return result;
    }

    public static int getRandomInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    public static class Student {
        String name;
        String surname;
        int age;

        Student(String surname, String name, int age) {
            this.name = name;
            this.surname = surname;
            this.age = age;
        }
    }

    public static class Task {
        String typeTask;
        int countPoints;

        Task(String typeTask, int countPoints) {
            this.typeTask = typeTask;
            this.countPoints = countPoints;
        }
    }

    public static class Practice extends Task {

        public static Level level;

        Practice(String typeTask, int countPoints, int level) {
            super(typeTask, countPoints);
            setLevel(level);
        }

        public void setLevel(int l) {
            switch (l) {
                case 1:
                    level = Level.Easy;
                case 2:
                    level = Level.Medium;
                case 3:
                    level = Level.Hard;
                default:
                    this.countPoints = this.countPoints * level.getNumVal();
                    break;
            }
        }

        public enum Level {
            Easy(1), Medium(2), Hard(3),
            ;

            private final int numVal;

            Level(int numVal) {
                this.numVal = numVal;
            }

            public int getNumVal() {
                return numVal;
            }
        }
    }

    public static class Lecture extends Task {

        Lecture(String typeTask, int countPoints) {
            super(typeTask, countPoints);
        }
    }


    public static class GirlStudent extends Student {

        GirlStudent(String surname, String name, int age) {
            super(surname, name, age);
        }
    }

    public static class BoyStudent extends Student {

        BoyStudent(String surname, String name, int age) {
            super(surname, name, age);
        }
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Course course1 = new Course("Программирование JAVA");
        Course course2 = new Course("Тестирование");
        Course course3 = new Course("Веб-разработка");

        List<Student> studentList = new ArrayList<Student>(Arrays.asList(
                new Student("Андрей Александров", Arrays.asList(course1)),
                new Student("Николай Андреев", Arrays.asList(course3)),
                new Student("Александр Николаев", Arrays.asList(course1, course2, course3)),
                new Student("Иван Петров", Arrays.asList(course1, course2, course3)),
                new Student("Сергей Иванов", Arrays.asList(course2)),
                new Student("Петр Сергеев", Arrays.asList(course1, course3)))
        );

        System.out.println("Задание №1:");
        uniqueCourses(studentList);
        System.out.println();
        System.out.println("Задание №2:");
        studentsWithMostCourses(studentList);
        System.out.println();
        System.out.println("Задание №3:");
        studentsAtThisCourse(studentList, course2);
    }

    public static List<Course> uniqueCourses (List<Student> studentList){
        List<Course> courses = studentList.stream()
                .map(s -> s.getCourses())
                .flatMap(c -> c.stream())
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Список уникальных курсов, на которые подписаны студенты:");
        System.out.println(courses);
        return courses;

    }

    public static List<Student> studentsWithMostCourses (List<Student> studentList){
        List<Student> curiousStudents = studentList.stream()
                .sorted((s1, s2) -> s2.getCourses().size() - s1.getCourses().size())
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("Список из трех самых любознательных студентов:");
        System.out.println(curiousStudents);
        return curiousStudents;
    }

    public static List<Student> studentsAtThisCourse (List<Student> studentList, Course course){
        List<Student> whoIsStudyingList = studentList.stream()
                .filter(s -> s.getCourses().contains(course))
                .collect(Collectors.toList());
        System.out.println("Список студентов, которые посещают курс " + course + ":");
        System.out.println(whoIsStudyingList);
        return whoIsStudyingList;
    }
}

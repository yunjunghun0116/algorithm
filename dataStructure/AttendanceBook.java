public class AttendanceBook<Type> {
    String[] students;
    int count;

    public AttendanceBook(int size) {
        students = new String[size];
        this.count = 0;
    }

    public int insertStudent(String name) {
        students[count++] = name;
        return count;
    }

    public void deleteStudent(int index) {
        students[index] = null;
        for (int i = index; i < count; i++) {
            students[i] = students[i + 1];
        }
        count--;
    }

    public void showAllStudents(){
        for(int i = 0; i < count; i++){
            System.out.println(students[i]);
        }
    }
}

public class AttendanceBook<T> {
    T[] students;
    int count;

    public AttendanceBook(int size) {
        students = (T[]) new Object[size];
        this.count = 0;
    }

    public int insertStudent(T name) {
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

    public void deleteStudent(String name) {
        int index = 0;
        for(int i = 0; i < count; i++){
            if(students[i].equals(name)){
                index = i;
                break;
            }
        }
        deleteStudent(index);
    }

    public void showAllStudents() {
        for (int i = 0; i < count; i++) {
            System.out.println(students[i]);
        }
    }
}

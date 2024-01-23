public class day2 {
    public static void main(String[] args) {
        AttendanceBook attendanceBook = new AttendanceBook(20);
        for(int i = 0; i < 10; i++){
            attendanceBook.insertStudent("name"+i);
        }
        attendanceBook.deleteStudent(4);

        attendanceBook.showAllStudents();
    }

}

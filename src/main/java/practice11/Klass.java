package practice11;


import java.util.ArrayList;
import java.util.List;

public class Klass {
    private int number;
    private Student leader;
    private List<Student> memberList;
    private List<joinOrAssignListener> teacherList;

    public Klass(int number) {
        this.number = number;
        this.memberList = new ArrayList<>();
        this.teacherList = new ArrayList<>();
    }

    public void registerListener(Teacher teacher) {
        teacherList.add(teacher);
    }

    public int getNumber() {
        return number;
    }

    public Student getLeader() {
        return leader;
    }

    public void setLeader(Student leader) {
        this.leader = leader;
    }

    public String getDisplayName() {
        return "Class " + number;
    }

    public void assignLeader(Student student) {
        if(memberList.indexOf(student) < 0) {
            System.out.print("It is not one of us.\n");
        } else {
            this.leader = student;
            teacherList.forEach(teacher -> {
                teacher.updateLeader(student);
            });
        }
    }
    public void appendMember(Student student) {
        this.memberList.add(student);
        student.setKlass(this);
        teacherList.forEach(teacher -> {
            teacher.updateMember(student);
        });
    }

    public boolean isIn(Student student) {
        if(this.number == student.getKlass().getNumber()) {
            return true;
        }
        return false;
    }
}

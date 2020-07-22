package practice10;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Teacher extends Person{
    private List<Klass> classes = new ArrayList<>();
    private List<Integer> classNumList = new ArrayList<>();
    private List<String> memberList = new ArrayList<>();

    public Teacher(int id, String name, int age, List<Klass> classes) {
        super(id, name, age);
        this.classes.addAll(classes);
        Iterator it = classes.iterator();
        while (it.hasNext()) {
            Klass obj = (Klass) it.next();
            classNumList.add(obj.getNumber());
        }
    }

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public List<Klass> getClasses() {
        return classes;
    }

    public void setClasses(List<Klass> classes) {
        this.classes = classes;
    }

    @Override
    public String introduce() {
        if(classes.size() > 0) {
            String classStr = "";
            for(int i = 0; i < classNumList.size(); i++) {
                if(i != classNumList.size()-1) {
                    classStr = classStr + classNumList.get(i) + ", ";
                } else {
                    classStr = classStr + classNumList.get(i);
                }
            }
            return super.introduce() + " I am a Teacher. I teach Class " + classStr + ".";
        } else {
            return super.introduce() + " I am a Teacher. I teach No Class.";
        }
    }

    public String introduceWith(Student student) {
        if(classNumList.indexOf(student.getKlass().getNumber()) >= 0) {
            return super.introduce() + " I am a Teacher. I teach " + student.getName() + ".";
        } else {
            return super.introduce() + " I am a Teacher. I don't teach " + student.getName() + ".";
        }
    }

    public boolean isTeaching(Student student) {
        Iterator it = this.classes.iterator();
        while(it.hasNext()) {
            Klass obj = (Klass) it.next();
            if(obj.isIn(student)) {
                return true;
            }
        }
        return false;
    }
}

package StudentListTest;

import java.io.*;
public class StudentListTest {
    public static void main (String[]args) throws IOException{
        int off = 1;
        int c=0;
        StudentList one;
        one=new StudentList(100);
        while(off!=0);
        {
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         String s=in.readLine();
         String[] ok=s.split(" ");
         switch (Integer.parseInt(ok[c++])) {
            case 1:
                Student stu;
                stu = new Student(ok[c++], ok[c++]); stu.enterMarks( Integer.parseInt(ok[c++]), Integer.parseInt(ok[c++]), Integer.parseInt(ok[c++]));
                one.add(stu);System.out.println(one.getTotal()+" Students at the moment as described below:");
                for(int i=1;i<one.getTotal()+1;i++){
                    one.getItem(i);
                }
                break;
            case 2:
                if(one.remove(ok[c++]))
                {
                    System.out.println("Remove successfully");
                    System.out.println(one.getTotal()+" Students at the moment as described below:");
                    for(int i=1;i<one.getTotal()+1;i++)
                    {
                        one.getItem(i);
                    }
                }
                break;
            case 3:
                if(one.getTotal()<Integer.parseInt(ok[c++]))System.out.println("No such student");
                else { one.remove(Integer.parseInt(ok[c++]));System.out.println("Remove successfully");System.out.println(one.getTotal()+" Students at the moment as described below:");
                    for(int i=1;i<one.getTotal()+1;i++)
                    {
                        one.getItem(i);
                    }
                }
                break;
            case 4:
                one.isEmpty();
                break;
            case 5:
                if(Integer.parseInt(ok[c])<=one.getTotal()){System.out.println("Student Info:");}
                one.getItem(Integer.parseInt(ok[c]));c++;

                break;
            case 6:
                one.getItem(ok[c++]);
                break;
            case 7:if(one.getTotal()!=0){System.out.println(one.getTotal()+" Students at the moment as described below:");}
                for (int i = 1; i < one.getTotal()+1; i++) {
                    one.getItem(i);
                }
                break;
            case 8:
                off=0;
                break;
         }
        }
    }
}
class Student {
    private String studentNumber;
    private String studentName;
    private Integer markForMaths,markForEnglish,markForScience;
    public Student(String number ,String name ){
        studentNumber=number;
        studentName=name;
        markForMaths=null;
        markForEnglish= null;
        markForScience= null;
    }
    public Student(){
        this("0","null");
    }
    public void enterMarks(Integer markForMaths,Integer markForEnglish,Integer markForScience){
        this.markForEnglish= markForEnglish;
        this.markForMaths=markForMaths;
        this.markForScience=markForScience;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public Integer getMarkForEnglish() {
        return markForEnglish;
    }

    public Integer getMarkForScience() {
        return markForScience;
    }

    public Integer getMarkForMaths() {
        return markForMaths;
    }
    public double calculateAverage(double math,double English,double Science){
        return (math+English+Science)/3.0;
    }
    public String toString() {
        return ("Student Info:");
    }
}
class StudentList {
    private  int total=0;
    private Student list[];
    public  StudentList(int length){
        list = new Student[length];
    }
    public boolean add(Student stu){
        if(total>=list.length)return false;
        {this.list[total]= new Student(new String(stu.getStudentNumber()),new String(stu.getStudentName()));
            this.list[total].enterMarks(stu.getMarkForMaths(),stu.getMarkForEnglish(),stu.getMarkForScience());
        total++;
        return true;}
    }
    public  boolean remove(int no){
        if(no>total){ return false;}
        else{
            for (int i = no; i < total; i++) {
                list[i - 1] = list[i];
            }
            total--;

        }
        return true;
    }
    public boolean remove(String number){
        int pos;
        pos=-1;
        for(int i=0;i<total;i++){
            if (list[i].getStudentNumber().equals(number)){
                pos=i;
                break;}

        }
        if(pos ==-1) { System.out.println("No such student");return false;}
        else {
            for (int y = pos + 1; y < total; y++) {
                list[y - 1] = list[y];
            }
            total--;

        return true;}
    }
    public boolean isEmpty(){
        if (total==0) {System.out.println("Yes");return false;}
        else {System.out.println("No");return true;}
    }
    public Student getItem(int no){
        if (no>total)  System.out.println("No such student");
        else {
            System.out.println("Number:" + list[no - 1].getStudentNumber());
            System.out.println("Name:" + list[no - 1].getStudentName());
            System.out.println("Math:" + list[no - 1].getMarkForMaths());
            System.out.println("English:" + list[no - 1].getMarkForEnglish());
            System.out.println("Science:" + list[no - 1].getMarkForScience());
            System.out.printf("Ave:%.2f", list[no - 1].calculateAverage(list[no - 1].getMarkForMaths(), list[no - 1].getMarkForEnglish(), list[no - 1].getMarkForScience()));
            System.out.println(); }return list[1];
    }
    public Student getItem(String number){
        int y=0;
        for (int i=0;i<total;i++ ){
            if(list[i].getStudentNumber().equals(number)){System.out.println("Student Info:");
                System.out.println("Number:"+list[i].getStudentNumber());
                System.out.println("Name:"+list[i].getStudentName());
                System.out.println("Math:"+list[i].getMarkForMaths());
                System.out.println("English:"+list[i].getMarkForEnglish());
                System.out.println("Science:"+list[i].getMarkForEnglish());
                System.out.printf("Ave:%.2f",list[i].calculateAverage(list[i].getMarkForMaths(),list[i].getMarkForEnglish(),list[i].getMarkForScience()));System.out.println();
                y=1;
                break;
            }
            if(y==0) System.out.println("No such student");

        }return list[1];

    }
    int getTotal(){
        return total;
    }
}
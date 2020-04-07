package StudentListTest;

import javax.swing.*;
import java.io.*;


public class StudentListTest {
    public static void main (String[]args) throws IOException{
        int off = 1;
        while (off!=0)
        {
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

         String s=in.readLine();
         String[] ok=s.split(" ");
         StudentList one;
         one=new StudentList();
         switch (Integer.parseInt(ok[0])) {
            case 1:
                Student stu;
                stu = new Student(ok[1], ok[2], Integer.parseInt(ok[3]), Integer.parseInt(ok[4]), Integer.parseInt(ok[5]));
                one.add(stu);System.out.println(one.getTotal()+" Students at the moment as described below:");
                for(int i=0;i<one.getTotal();i++){
                    one.getItem(i);
                }
                break;
            case 2:
                one.remove(ok[1]);
                if(one.pos!=-1)
                    for(int i=0;i<one.getTotal();i++){
                        one.getItem(i);
                    }
                break;
            case 3:if(one.getTotal()<Integer.parseInt(ok[1]))System.out.println("No such student");
                else one.remove(Integer.parseInt(ok[1]));
                break;
            case 4:
                one.isEmpty();
                break;
            case 5:
                if(Integer.parseInt(ok[1])<=one.getTotal()){System.out.println("Student Info:");}
                one.getItem(Integer.parseInt(ok[1]));

                break;
            case 6:
                one.getItem(ok[1]);
                break;
            case 7:
                for (int i = 0; i < one.getTotal(); i++) {
                    one.getItem(i);
                }
                break;
            case 8:off=0;
                break;
         }
        }


    }
}
class Student {
    private String studentNumber;
    private String studentName;
    private Integer markForMaths,markForEnglish,markForScience;
    public Student(String number ,String name,Integer Maths,Integer English,Integer Science ){
        studentNumber=number;
        studentName=name;
        markForMaths=Maths;
        markForEnglish= English;
        markForScience= Science;
    }
    public Student(){
        this("0","null",null,null,null);
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
    private  int total=0;int pos;
    private Student list[];
    public int StudentList(int length){
         return 0;
    }
    public boolean add(Student stu){
        if(total==list.length)return false;
        else {this.list[total]= new Student(new String(stu.getStudentNumber()),new String(stu.getStudentName()),stu.getMarkForMaths(),stu.getMarkForEnglish(),stu.getMarkForScience());
        total++;
        return true;}
    }
    public  boolean remove(int no){
        if(no>=total){ return false;}
        else{
            for (int i = no; i < total; i++) {
                list[i - 1] = list[i];
            }
            total--;

        }
        return true;
    }
    public boolean remove(String number){

        pos=-1;
        for(int i=0;i<total;i++){
            if (list[i].getStudentNumber()==number){
                pos=i;
                break;}

        }
        if(pos ==-1) { System.out.println("No such student");return false;}
        else {
            for (int y = pos + 1; y < total; y++) {
                list[y - 1] = list[y];
            }
            total--;
        }
        return true;
    }
    public boolean isEmpty(){
        if (total==0) return false;
        else return true;
    }
    public void getItem(int no){
        if (no>total)  System.out.println("No such student");
        else {

            System.out.println("Number:" + list[no - 1].getStudentNumber());
            System.out.println("Name:" + list[no - 1].getStudentName());
            System.out.println("Math:" + list[no - 1].getMarkForMaths());
            System.out.println("English:" + list[no - 1].getMarkForEnglish());
            System.out.println("Science:" + list[no - 1].getMarkForScience());
            System.out.printf("Ave:%.2f", list[no - 1].calculateAverage(list[no - 1].getMarkForMaths(), list[no - 1].getMarkForEnglish(), list[no - 1].getMarkForScience()));
        }
    }
    public void getItem(String number){
        int y=0;
        for (int i=0;i<total;i++ ){
            if(list[i].getStudentNumber()==number){

                System.out.println("Number:"+list[i-1].getStudentNumber());
                System.out.println("Name:"+list[i-1].getStudentName());
                System.out.println("Math:"+list[i-1].getMarkForMaths());
                System.out.println("English:"+list[i-1].getMarkForEnglish());
                System.out.println("Science:"+list[i-1].getMarkForScience());
                System.out.printf("Ave:%.2f",list[i-1].calculateAverage(list[i-1].getMarkForMaths(),list[i-1].getMarkForEnglish(),list[i-1].getMarkForScience()));
                y=1;
                break;
            }
            if(y==0) System.out.println("null");

        }

    }
    int getTotal(){
        return total;
    }
}
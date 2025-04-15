package type;

public class Arr1 {
    public static void main(String[] args) {
        String[] students;
        students = new String[6];

        students[0]="김서연";
        students[1]="안태현";
        students[2]="김영오";
        students[3]="전규진";
        students[4]="최재원";
        students[5]="김은지";

        for(int i=0;i<students.length;i++){
            System.out.println("내 집에 왔더라? " + students[i]);
        }
    }
}

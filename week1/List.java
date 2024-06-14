package week1;

import java.util.ArrayList;

public class List{
    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();
        list.add(22);
        list.add("Hanuma");
        list.add(5.5);

        for (Object element : list) {
            System.out.println(element);
        }
    }
}

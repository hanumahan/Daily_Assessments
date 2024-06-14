package week1;

import java.util.ArrayList;

public class ArrayListEx {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("kumar");
        list.add("rahul");
        list.add("bhuvi");

        for (String name : list) {
            System.out.println(name);
        }
    }
}

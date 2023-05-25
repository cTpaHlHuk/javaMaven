package Lesson16;

public class Main {
    public static void main(String[] args) {
        Person personFromApi = PersonApi.getPersonFromApi();
        System.out.println(personFromApi);
        //String s = "1950-10-09T15:12:01.213Z";
        //System.out.println(s);

    }
}

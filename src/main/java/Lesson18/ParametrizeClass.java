package Lesson18;

public class ParametrizeClass {
    public static void main(String[] args) {
        ParamClass<Integer> aClass = new ParamClass<>(123);
        aClass.print();
    }
}


class ParamClass<T>{
    private T value;

    public ParamClass(T value) {
        this.value = value;
    }
    public void print(){
        System.out.println(value);
    }
}

package stat;

public class Bowl {

    static{
        System.out.println("Bowl static");
    }

    public Bowl(int marker) {
        System.out.println("Bowl(" + marker + ")");
    }

    public void f1(int marker){
        System.out.println("f1(" + marker + ")");
    }
}

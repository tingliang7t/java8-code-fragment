package stat;

public class Table {

    static{
        System.out.println("Table static");
    }

    private static Bowl bowl = new Bowl(1);
    private static Bowl bowl2 = new Bowl(2);

    public Table(){
        System.out.println("Table()");
        bowl2.f1(1);
    }

    public  void f2(int marker){
        System.out.println("f2("+marker+")");
    }

}

package stat;

public class CupBoard {

    static{
        System.out.println("Cupboard static");
    }

    Bowl bowl3 = new Bowl(3);
    static Bowl bowl4 = new Bowl(4);
    static Bowl bowl5 = new Bowl(5);

    CupBoard(){
        System.out.println("CupBoard()");
        bowl4.f1(2);
    }

    public void f3(int marker) {
        System.out.println("f3("+marker+")");
    }

}

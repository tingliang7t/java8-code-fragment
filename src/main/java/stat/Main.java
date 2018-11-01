package stat;

public class Main {

    static{
        System.out.println("main static");
    }

    public static void main(String[] args){

        System.out.println(-1231%2);

    }

    private static Table table = new Table();
    private static CupBoard cupBoard = new CupBoard();
}

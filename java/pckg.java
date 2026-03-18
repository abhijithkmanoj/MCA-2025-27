import arithmetic.*;
public class pckg{
    public static void main (String []args){
        int a=10;
        int b=5;
        Add add=new Add();
        Subtract sub=new Subtract();
        Multiply mul=new Multiply();
        Divide div=new Divide();
        add.calculate(a,b);
        sub.calculate(a,b);
        mul.calculate(a,b);
        div.calculate(a,b);
    }
}
package src.oop.codes.oop_6.lambda.example_2_op;

public class Main {

    public static void main(String[] args) {
        Operations add = (a, b) -> (a + b);// same as: Operations addingNice = Integer::sum;
        Operations sub = (a, b) -> (a - b);
        Operations prod = (a, b) -> (a * b);
        // can directly print like this
        // System.out.println(add.operation(3, 5));
        System.out.println(operate(3, 5, add));

        // Engine engine = new PowerEngine(); // start() is in Engine
        // engine.start() calls start method overridden in PowerEngine
        // Operations op = add type // operations() is in Operation
        // op.operation calls overridden method in here, add
    }

    static int operate(int a, int b, Operations op) { // add will be passed here
        return op.operation(a, b); // it will call function in interface
        // that function is overridden by 'add' in psvm
    }
}

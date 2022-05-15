package src.oop.codes.oop_6.lambda.example_2_op;

@FunctionalInterface // this will make sure we have only one abstract method in this interface
// cause lamba can be used then only, if we don't add check, we get error there where we used lambda
public interface Operations {
    int operation(int a, int b);
}

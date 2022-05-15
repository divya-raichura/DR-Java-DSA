package src.oop.codes.oop_6.lambda.example_1;

public class Example {
    public static void main(String[] args) {
        // https://www.w3schools.com/java/java_lambda.asp
        // https://www.javatpoint.com/java-lambda-expressions
//        String name = "Divya";
//        Students s = () -> {
//            System.out.println("Hey " + name);
//        };


        // of course, we need to call it in this way:
//        s.hello();

        // example 2 with return type:-

        Students s2 = (naam) ->{
            return "Hey " + naam;
        };
        // same as
        Students s3 = (naamBolonaam) -> "Hey " + naamBolonaam;

        System.out.println(s2.namaste("Divya"));
        System.out.println(s3.namaste("Divya"));
    }
}

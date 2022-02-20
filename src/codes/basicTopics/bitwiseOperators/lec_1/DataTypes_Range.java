package bitwiseOperators.lec_1;


// https://docs.oracle.com/cd/E19253-01/817-6223/chp-typeopexpr-2/index.html
// mast =  https://www.w3schools.com/java/java_data_types.asp


            // W3 SCHOOLS OP
/*
- Primitive data types - includes byte, short, int, long, float, double, boolean and char
- Non-primitive data types - such as String, Arrays and Classes

//// Range formula = -2(^n-1) to [2(^n-1)]-1

byte	==> 1 byte	==>Stores whole numbers from -128 to 127
short	==> 2 bytes	==>Stores whole numbers from -32,768 to 32,767
int	    ==> 4 bytes	==>Stores whole numbers from -2,147,483,648 to 2,147,483,647
long	==> 8 bytes	==>Stores whole numbers from -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
float	==> 4 bytes	==>Stores fractional numbers. Sufficient for storing 6 to 7 decimal digits
double	==> 8 bytes	==>Stores fractional numbers. Sufficient for storing 15 decimal digits
boolean	==> 1 bit	==>Stores true or false values
char	==> 2 bytes	==>Stores a single character/letter or ASCII values
 */

// typecasting is done by using this, bade wale me kuch bhi save karskte
// typecasting to write bigger data type in smaller data type and convert it into smaller data type

/*
Type casting is when you assign a value of one primitive data type to another type.

In Java, there are two types of casting:

Widening Casting (automatically) - converting a smaller type to a larger type size
byte -> short -> char -> int -> long -> float -> double

Narrowing Casting (manually) - converting a larger type to a smaller size type
double -> float -> long -> int -> char -> short -> byte
 */



public class DataTypes_Range {
    public static void main(String[] args) {
        byte a = 127;
        byte b = (byte) 130; // as 130 is more than range(aur int banjata) so caste into byte
        int n = (int)1.2;
        float m = 1;
        System.out.println(m);
        System.out.println(n);
        System.out.println(b);
    }
}

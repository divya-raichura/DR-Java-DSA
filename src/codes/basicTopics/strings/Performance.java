package lectures.strings;


                            // *** IMPORTANT *** //


// complexity is O n(2) as every time, new obj is created like
// ""+'a' = "a"
// "a"+'b'= "ab"
// "ab" + 'c' = "abc"
// and so on till "abc...xyz"
// so everytime it creates new object as wkt strings can't be modified
// so all this "a" "ab" "abc" ... "abcd...vwxy" large strings will have no ref var, wastage of space
// so size 1 + size 2 + size 3 + ... size N
// --> n(n+1)/2 ==> O(n2) complexity
// all this cause u can't modify string value, it would be great if we had data type that allowed us to modify the value
// eg -> "abc" + 'd' = "abcd" , it modified/made changes in abc itself and no new obj was created
// data type that doesn't create new obj but adds in og obj
// so if u want to add n items, u would run n iterations even here also we are running for loop n times
// but when we were adding the strings, it was also running it several times that's why n2
// such data type exists, it's stringbuilder





public class Performance {
    public static void main(String[] args) {
        String series = " ";
        for (int i = 0; i < 26; i++) {
            char ch = (char) ('a' + i);
//            System.out.println(ch);
            series = series + ch; // series += ch
            // wkt, in strings, it joins/concatenates ie => "a" + "b" = ab
            // similarly, " " + ch = ch
            // cause wkt string is not converted to other data types
            // if one of the data type is string, ans will be string
        }
        System.out.println(series); // PRINTS abcde...xyz
    }
}

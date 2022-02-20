package timeComplexity;



// LINKS TO REFER
// --> (best) https://adrianmejia.com/how-to-find-time-complexity-of-an-algorithm-code-big-o-notation/
// --> https://pages.cs.wisc.edu/~vernon/cs367/notes/3.COMPLEXITY.html
// --> https://www.geeksforgeeks.org/analysis-of-algorithms-set-4-analysis-of-loops/
// --> http://en.wikipedia.org/wiki/Big_O_notation
// --> https://www.mygreatlearning.com/blog/why-is-time-complexity-essential/#:~:text=To%20elaborate%2C%20Time%20complexity%20measures,run%20that%20function%20each%20time.


public class Time_Complexity {
    public static void main(String[] args) {
                   // my understanding -
        // time complexity is basically how time changes when input is changed
        // time = f(input) // time(T) = dependent axis(y) and input(N) = x axis
        // so, f(n) = 2n^4 + 5n^2 + 9n + 3 ~= n^4
        // so, T (Time complexity) = o(n^4) , as f(n) = T


                    // o(1) vs o(n) :
        // o(1) --> doesn't depend on input, takes same time for any amount of input --> graph parallel to x axis
        // 1 minute for eating 100 banana, 1 minute to eat 500 bananas
        // o(n) --> time increases as input increases --> linear graph

        // nice example of linear search --> if arr[0] = target then no matter
        // what's the size of array, in this case 0(1)


                    // log N
        //O(Logn) Time Complexity of a loop is considered as O(Logn) if the loop
        // variables are divided/multiplied by a constant amount.
        //log(n) increases only by a tiny amount as N increases.
        // When N doubles, log(n) only increases by 1

        /*
         O(n) basically means the algorithm will take as much time to execute as
         there are elements in n. O(1) means the algorithm always takes a constant
         time, regardless of how many elements are in the input. O(n^2) means the
         algorithm takes number of items squared time i.e. slows down more and more
         the bigger the input is
         */


        /*
        if..else is just one normal statement you do to each item once. It does
        neither increase nor decrease the runtime/complexity. Your algorithm is O(n).
         */


        /*
        In short, O(1) means that it takes a constant time, like 14 nanoseconds, or
        three minutes no matter the amount of data in the set.
        means it takes an amount of time linear with the size of the set, so a
        set twice the size will take twice the time
         */

        /*
        Here is a simple analogy; Imagine you are downloading movies online, with O(1), if
        it takes 5 minutes to download one movie, it will still take the same time to
        download 20 movies. So it doesn't matter how many movies you are downloading, they
        will take the same time(5 minutes) whether it's one or 20 movies. A normal example
        of this analogy is when you go to a movie library, whether you are taking one movie
        or 5, you will simply just pick them at once. Hence spending the same time.
        However, with O(n), if it takes 5 minutes to download one movie, it will take about
        50 minutes to download 10 movies. So time is not constant or is somehow proportional
        to the number of movies you are downloading.
         */
    }
}

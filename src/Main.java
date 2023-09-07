public class Main
{
    public static void main(String[] args)
    {
        StringBuilder input = new StringBuilder("I have numbers 2.55 and 6.31. Plus, I have 0.8 and 8.");
        System.out.println("How it was: " + input);
        StringBuilder sortedInput = Sorting.sortNumbers(input);
        System.out.println("How it is now: " + sortedInput);
    }
}
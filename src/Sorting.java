import java.util.ArrayList;
import java.util.Collections;

public class Sorting
{
    public static StringBuilder sortNumbers(StringBuilder text)
    {
        ArrayList<Double> nums = new ArrayList<>();
        ArrayList<Integer> positions = new ArrayList<>();

        for (int i = 0; i < text.length(); i++)
        {
            StringBuilder temp = new StringBuilder();
            char currentChar = text.charAt(i);
            if (Character.isDigit(currentChar) && i < text.length() - 2 &&
                    text.charAt(i+1) == '.' && Character.isDigit(text.charAt(i+2)))
            {
                positions.add(i);
                temp.append(currentChar);
                temp.append('.');
                i+=2;

                while (i < text.length() && Character.isDigit(text.charAt(i)))
                {
                    temp.append(text.charAt(i));
                    i++;
                }

                nums.add(Double.valueOf(temp.toString()));
            }
        }

        Collections.sort(nums);
        Collections.sort(positions);

        for (int i = 0; i < text.length(); i++)
        {
            char currentChar = text.charAt(i);
            int start = i;
            if (Character.isDigit(currentChar) && i < text.length() - 2 &&
                    text.charAt(i+1) == '.' && Character.isDigit(text.charAt(i+2)))
            {
                i+=2;
                while (i < text.length() && Character.isDigit(text.charAt(i)))
                {
                    i++;
                }
            }
            int end = i;
            text.delete(start, end);
        }

        for (int i = 0; i < positions.size(); i++)
        {
            int j = nums.get(i).toString().length() - 3;
            text.insert(positions.get(i)-j, nums.get(i).toString());
        }

        return text;
    }
}

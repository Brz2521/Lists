import javax.swing.JOptionPane;
import java.util.Arrays;

public class OneDArray 
{
	private int[] array;
	private int size;
	private int low;
	private int high;
	
public OneDArray(int s, int l, int h)
{
	array = new int[s];
	for (int i=0; i<s; i++)
    	array[i] = l + (int)((h-l+1)*Math.random());
}
public OneDArray()
{
	size = 100;
	low = 1;
	high = 100;
	array = new int[size];
	for (int i=0; i<size; i++)
    	array[i] = low + (int)((high-low+1)*Math.random());
}
public void createArray()
{
	String input = JOptionPane.showInputDialog(null,"Please enter an integer < 1000:",
			"Size of One-Dimensional Array",JOptionPane.QUESTION_MESSAGE);
    size=Integer.parseInt(input);
    array = new int[size];
    input = JOptionPane.showInputDialog(null,"Please enter an integer > 0:",
			"Lowest Value in the Array",JOptionPane.QUESTION_MESSAGE);
    low = Integer.parseInt(input);
    input = JOptionPane.showInputDialog(null,"Please enter an integer < 1000:",
			"Highest Value in the Array",JOptionPane.QUESTION_MESSAGE);
    high = Integer.parseInt(input);
    for (int i=0; i<size; i++)
    	array[i] = low + (int)((high-low+1)*Math.random());
}
public int getMaximum()
{
	int max = Integer.MIN_VALUE;
	for(int i=0; i<array.length; i++)
	{
		if(max<array[i]) 
		{
			max = array[i];
		}
	}
	return max;
}
public int getMinimum()
{
	
	int min = Integer.MAX_VALUE;
	for(int i=0; i<array.length; i++)
	{
		if(min>array[i]) 
		{
			min = array[i];
		}
	}
	return min;
}
public double getAverage()
{
	double sum = 0.0;
	for(int i=0; i<array.length; i++)
	{
		sum = sum + array[i];
	}
	
	return sum/array.length;
}

public boolean search(int key)
{
	for(int i=0; i<array.length; i++)
	{
		if(array[i]==key)
		{
			return true;
		}
	}
	
	return false;
}
public int[] sort()
{
	Arrays.sort(array);
	return array;
}
public int[] getArray() { return array;}
public int getSize() { return size;}
public int getLow() { return low;}
public int getHigh() { return high;}
}

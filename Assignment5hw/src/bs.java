
public class bs
{
	public static void main(String[] args) 
	{
		int x = 0;
		System.out.println(rec(x));
	}
	
	public static int rec(int x)
	{
		if(x > 10)
			return x;
		else
		{
			x++;
			rec(x);
		}
		return x;
	
	}
}

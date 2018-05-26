package ShellSort;
public class ShellSort
{
	public static void function(int []data)
	{
		int temp;
		int h=data.length;
		while(h!=1)
		{
			h=(h%2==0)?(h/2):(h/2+1);
			for(int i=0;i+h<data.length;i++)
			{
				if(data[i]>data[i+h])
				{
					temp=data[i];
					data[i]=data[i+h];
					data[i+h]=temp;
				}
			}
		}
	}
}
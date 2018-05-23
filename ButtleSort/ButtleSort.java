package BubbleSort;
public class BubbleSort
{
	public static void function(int []data)
	{
		int temp;
		for(int i=data.length;i>0;i--)
		{
			for(int j=0;j<i-1;j++)
			{
				if(data[j]>data[j+1])
				{	
					temp=data[j];
					data[j]=data[j+1];
					data[j+1]=temp;
				}
			}
		}
	}
}
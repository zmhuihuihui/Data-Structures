package InsertSort;
public class InsertSort
{
	public static void funciton(int[]data)
	{
		for(int i=1;i<data.length;i++)
		{
			int temp=data[i];
			int j;
			for(j=i-1;j>=0;j--)
			{
				if(temp>=data[j]) break;
				data[j+1]=data[j];
			}
			data[j+1]=temp;
		}
	}
}
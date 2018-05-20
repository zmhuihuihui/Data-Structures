package SelectSort;
public class SelectSort
{
	public static void funciton(int[]data)
	{
		for(int i=0;i<data.length;i++)
		{
			int Min=data[i];
			int MinIndex=i;
			int temp;
			for(int j=i+1;j<data.length;j++)
			{
				if(data[j]<Min)
				{
					Min=data[j];
					MinIndex=j;
				}
			}
			temp=data[i];
			data[i]=data[MinIndex];
			data[MinIndex]=temp;
		}
	}
}
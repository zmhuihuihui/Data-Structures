package QuickSort;
public class QuickSort
{
	public static void function(int []data,int left,int right)
	{
		if(left>=right) return;
		int temp=data[left];
		int i=left;
		int j=right;
		int t;
		while(i!=j)
		{
			while(data[j]>=temp&&i<j) j--;
			while(data[i]<=temp&&i<j) i++;
			if(i<j)
			{
				t=data[i];
				data[i]=data[j];
				data[j]=t;
			}
		}
		data[left]=data[i];
		data[i]=temp;
		function(data,left,i-1);
		function(data,i+1,right);
	}
}
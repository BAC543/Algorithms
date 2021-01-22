
public class Pair 
{

		private int minVal;
		
		private int minIndex;
		
		private int maxVal;
		
		private int maxIndex;
		
		public Pair (int newMin, int newMinIndex, int newMaxIndex, int newMax)
		{
			minVal = newMin;
			minIndex = newMinIndex;
			maxVal = newMax;
			maxIndex = newMaxIndex;
		}//full constructor
		
		public Pair()
		{
			minVal = Integer.MAX_VALUE;
			minIndex = Integer.MIN_VALUE;
			
			maxVal = Integer.MIN_VALUE;
			maxIndex = Integer.MAX_VALUE;
		}//null constructor
		
		public void setMin(int newMin)
		{
			  minVal  = newMin;
		}//setMin
		
		public int getMin()
		{
			return minVal;
		}//getMin
		
		public void setMinIndex(int newMinIndex)
		{
			  minIndex  = newMinIndex;
		}//setMinIndex
		
		public int getMinIndex()
		{
			return minIndex;
		}//getMinIndex
		
		public void setMax(int newMax)
		{
			  maxVal  = newMax;
		}//setMax
		
		public int getMax()
		{
			return maxVal;
		}//getMax
		
		public void setMaxIndex(int newMaxIndex)
		{
			  maxIndex  = newMaxIndex;
		}//setMinIndex
		
		public int getMaxIndex()
		{
			return maxIndex;
		}//getMinIndex
		
		public int getRange()
		{
			return maxVal - minVal;
		}//getRange

}//Pair

public class Trio<T> 
{
	private T item1, item2, item3;
	
	public Trio(T item1, T item2, T item3) 
	{
		this.item1 = item1;
		this.item2 = item2;
		this.item3 = item3;
	}
	public Trio(T item)
	{
		this(item, item, item);
	}
	
	
	public T getItem1() {
		return item1;
	}
	public void setItem1(T item1) {
		this.item1 = item1;
	}
	public T getItem2() {
		return item2;
	}
	public void setItem2(T item2) {
		this.item2 = item2;
	}
	public T getItem3() {
		return item3;
	}
	public void setItem3(T item3) {
		this.item3 = item3;
	}
	
	@Override
	public String toString()
	{
		return "First item: " + item1.toString() +"\n"
				+"Second item: " + item2.toString() +"\n"
				+"Third item: " + item3.toString() + "\n";
	}
	
	public void replaceAll(T item)
	{
		this.item1 = item;
		this.item2 = item;
		this.item3 = item;
	}
	
	
	public boolean hasDuplicates()
	{
		int duplicateCount = 0;
	
		if(item1.equals(item2))
		{
			duplicateCount++;
		}
		if(item2.equals(item3)) {
			duplicateCount++;
		}
		if(item3.equals(item1)) {
			duplicateCount++;
		}
		return duplicateCount >=1;
	}
	
	
	public int count(T item)
	{	
		int counter = 0;
		if( item1.equals(item))
			counter++;
		if (item2.equals(item))
			counter++;
		if (item3.equals(item))
			counter++;
		
		return counter;		
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if(obj instanceof Trio<?>)
		{
			Trio<?> otherItem = (Trio<?>) obj;

			boolean firstItem = false;
			boolean secondItem = false;
			boolean thirdItem = false;
			
			//first vs first
			if (item1.equals(otherItem.getItem1()))
				{
				firstItem = true;
				if (item2.equals(otherItem.getItem2()))
					{
					secondItem = true;
					thirdItem = item3.equals(otherItem.getItem3());
					}
				else if (item2.equals(otherItem.getItem3()))
					{
					secondItem = true;
					thirdItem = item3.equals(otherItem.getItem2());
					}
				}
			
			//first vs second
			else if (item1.equals(otherItem.getItem2()))
			{
				firstItem = true;
				if (item2.equals(otherItem.getItem1()))
				{
					secondItem = true;
					thirdItem = item3.equals(otherItem.getItem3());
				}
				else if (item2.equals(otherItem.getItem3()))
				{
					secondItem = true;
					thirdItem = item3.equals(otherItem.getItem1());
				}
						
			}
			
			//first vs third	
			else if (item1.equals(otherItem.getItem3()))
			{
				firstItem = true;
				if (item2.equals(otherItem.getItem1()))
				{
					secondItem = true;
					thirdItem = item3.equals(otherItem.getItem2());
				}
				else if (item2.equals(otherItem.getItem2()))
				{
					secondItem = true;
					thirdItem = item3.equals(otherItem.getItem1());
				}
									
			}
			
			return(firstItem && secondItem & thirdItem);
		}
		else
			return false;
	}
	
}


public class ArrayUtils {

	private boolean isSubSet(int[] bArray, int[] aArray) {
		boolean allAvailable = true;
		for(int b : bArray) {
			boolean available = false;
			for(int a : aArray) {
				if (b==a) {
					available = true;
					break;
				}
			}
			if (!available) {
				allAvailable = false;
				break;
			}
		}
		return allAvailable;
	}
	private void printArr(int[] nums) {
		for(int e : nums)
			System.out.print(e + " ");
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayUtils au = new ArrayUtils();
		//check whether bArray is a subset of aArray ?
		
//		int[] aArray = {1,5,3,11,17,99,25,20};
//		int[] bArray = {5,3};
		
//		int[] aArray = {1,5,3,11,17,99,25,20};
//		int[] bArray = {5,3,50};

//		int[] aArray = {1,5,3,11,17,99,25,20};
//		int[] bArray = {};

//		int[] aArray = {};
//		int[] bArray = {5,3};
		
		int[] aArray = {};
		int[] bArray = {};
		
		System.out.print("main array is : ");
		au.printArr(aArray);
		System.out.print("sub array is : ");
		au.printArr(bArray);
		
		boolean isSubArray = au.isSubSet(bArray, aArray);
		if (isSubArray)
			System.out.println("yes, subArray is a subset of mainArray");
		else
			System.out.println("no, subArray is not a subset of mainArray");
		
		//
	}
	
}

class Sorted{
	public static void main(String[]args){
		LinearSearch linearSearch = new LinearSearch();
		linearSearch.Benchmark();
		Binary binary = new Binary();
		int[] array = {1,2,3,4};
		int key = 4;
		boolean result = binary.searchBinary(array, key);
		System.out.println(result);
	}
}

public class Item{
	private ItemType type;
	private int value = 0;

	public Item(ItemType type){
		this.type = type;
	}

	public Item (int value){
		this.type = ItemType.VALUE;
		this.value = value;
	}
	public ItemType getType(){
		return this.type;
	}
	public int getValue(){
		return this.value;
	}
}

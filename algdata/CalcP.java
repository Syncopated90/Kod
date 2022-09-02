class CalcP{
	Item[] items;

	public void run(){
		items = new Item[25];

		items[0] = new Item(10);
		items[1] = new Item(9);
		items[2] = new Item(ItemType.PNUMBER);
		items[3] = new Item(0);
		items[4] = new Item(0);
		items[5] = new Item(ItemType.PNUMBER);
		items[6] = new Item(2);
		items[7] = new Item(1);
		items[8] = new Item(ItemType.PNUMBER);
		items[9] = new Item(6);
		items[10] = new Item(0);
		items[11] = new Item(ItemType.PNUMBER);
		items[12] = new Item(7);
		items[13] = new Item(3);
		items[14] = new Item(ItemType.PNUMBER);
		for(int i = 15; i < 23; i++)
			items[i] = new Item(ItemType.ADD);
		items[23] = new Item(ItemType.MODULO10);
		items[24] = new Item(ItemType.SUB);
		Calculator calculator = new Calculator(items);
		System.out.println("Last digit of personnummer: " + calculator.run());
	}
}
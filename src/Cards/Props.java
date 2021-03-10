package Cards;

import java.util.*;

public class Props extends Cards {
	private int count;
	private String name;
	private boolean theMiddleCard;

	public enum Prop {
		one("The Rabbit", 19), two("Carrots", 13), three("The Hat", 20), four("Carrots", 13), five("Carrots", 13),
		six("The Lettuce", 10), seven("The Other Rabbit", 16);

		private final String name;
		private final int count;

		public String getName() {
			return this.name;

		}

		private Prop(String name, int count) {
			this.name = name;
			this.count = count;

		}

		public String toString() {
			return (this.name);
		}
	}

	public Props(String name) {
		this.name = name;
	}

	public boolean equals(Props p) {
		return this.name == p.name;
	}

	public int getCount() {
		return this.count;
	}

	public LinkedList<Props> TasdeProps() {
		LinkedList tasdeProps = new LinkedList<Props>();
		for (Prop pr : Prop.values()) {
			Props p = new Props(pr.count, pr.name, false);
			tasdeProps.add(p);
		}
		return tasdeProps;
	}

	private boolean isFacedUp;

	public Props(int count, String name, boolean theMiddleCard) {
		super();
		this.isFacedUp = false;
		this.count = count;
		this.name = name;
		this.theMiddleCard = false;
	}

	public boolean isFacedUp() {
		return this.isFacedUp;
	}

	public void isFacedUp(boolean b) {
		this.isFacedUp = b;
	}

	public void setPropsAtMiddle() {
		this.theMiddleCard = true;
	}

	public String toString() {
		return this.name;
	}

	public String getName() {
		return name;
	}

	public static void main(String[] args) {
		Props Rabbit = new Props("The Rabbit");
	}
}

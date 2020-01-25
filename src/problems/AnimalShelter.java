package problems;

import java.util.LinkedList;

public class AnimalShelter {
	class Animal {
		Integer type;// 0 for dog, 1 for cat
		Integer pos;

		Animal(Integer type, Integer pos) {
			this.type = type;
			this.pos = pos;
		}

		@Override
		public String toString() {
			return "{Type = " + type + ", Pos = " + pos + "}";
		}
	}

	private LinkedList<Animal> dogQueue;
	private LinkedList<Animal> catQueue;
	private int pos;

	public AnimalShelter() {
		this.dogQueue = new LinkedList<>();
		this.catQueue = new LinkedList<>();
		this.pos = 0;
	}

	public void enqueue(int type) {
		Animal animal = new Animal(type, pos);
		if(type == 0)
			this.dogQueue.addLast(animal);
		else
			this.catQueue.addLast(animal);
		this.pos++;
	}

	public int dequeueAny() {
		if (this.catQueue.size() == 0 && this.dogQueue.size() == 0)
			return -1;
		else {
			int cat = -1, dog = -1;
			if(this.catQueue.size() != 0)
				cat = this.catQueue.peekFirst().pos;
			if(this.dogQueue.size() != 0)
				dog = this.dogQueue.peekFirst().pos;
			if(cat < dog)
				return this.catQueue.removeFirst().type;
			else
				return this.dogQueue.removeFirst().type;
		}
	}

	public int dequeueCat() {
		if(this.catQueue.size() == 0)
			return -1;
		return this.catQueue.removeFirst().pos;
	}

	public int dequeueDog() {
		if(this.dogQueue.size() == 0)
			return -1;
		return this.dogQueue.removeFirst().pos;
	}

	@Override
	public String toString() {
		return "cat: " + this.catQueue.toString() + ", dog: " + this.dogQueue.toString();
	}

	public static void main(String[] args) {
		AnimalShelter as = new AnimalShelter();
		as.enqueue(0);
		as.enqueue(1);
		as.enqueue(0);
		as.enqueue(0);
		as.enqueue(1);
		as.enqueue(1);
		System.out.println(as);
		System.out.println(as.dequeueCat());
		System.out.println(as);
		System.out.println(as.dequeueAny());
		System.out.println(as);
		System.out.println(as.dequeueCat());
		System.out.println(as.dequeueDog());
		System.out.println(as);
	}
}

package trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTree {
	class Node{
		int data;
		Node left;
		Node right;
		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	private Node root;
	
	public BinaryTree() {
		Scanner s = new Scanner(System.in);
		this.root = takeIn(s, null, null);
	}
	
	public BinaryTree(int[] arr) {
		LinkedList<Node> q = new LinkedList<>();
		this.root = new Node(arr[0]);
		Node curr = null;
		q.add(this.root);
		int count = 0;
		for(int i = 1;i<arr.length;i++){
			Node node = new Node(arr[i]);
			if(count == 0) {
				curr = q.removeFirst();
			}
			if(count == 0) {
				count++;
				if(arr[i] != -1) {
					curr.left = node;
				}else {
					curr.left = null;
				}
			}else {
				count = 0;
				if(arr[i]!=-1) {
					curr.right = node;
				}else {
					curr.right = null;
				}
			}
			if(arr[i]!=-1)
				q.addLast(node);
		}
	}

	//true - leftChild ++++ false - rightChild
	private Node takeIn(Scanner s, Node parent, Boolean isLeftOrRight) {
		if(parent==null) {
			System.out.println("Enter the data for root node : ");
		}else { 
			if(isLeftOrRight) {
				System.out.println("Enter the data for the left child of " + parent.data);
			}else {
				System.out.println("Enter the data for the right child of " + parent.data);
			}
		}
		int data = s.nextInt();
		Node node = new Node(data);
		Boolean choice = null;
		System.out.println("Does it has left child : ");
		choice = s.nextBoolean();
		if(choice) {
			node.left = takeIn(s, node, true);
		}
		choice = null;
		System.out.println("Does it has right child : ");
		choice = s.nextBoolean();
		if(choice) {
			node.right = takeIn(s, node, false);
		}
		return node;
	}

	public void display() {
		this.display(this.root);
	}
	
	private void display(Node node) {
		String str = "";
		if(node == null) {
			return;
		}
		if(node.left!=null) {
			str += node.left.data + "=>";
		}else {
			str += "END=>";
		}
		str += node.data;
		if(node.right!=null) {
			str += "<=" + node.right.data ;
		}else {
			str += "<=END";
		}
		
		System.out.println(str);
		
		if(node.left!=null) {
			this.display(node.left);
		}
		if(node.right!=null) {
			this.display(node.right);
		}
	}

	//Method to find the Maximum element from Binary Tree
	//Time Complexity : O(n)
	//Space Complexity : O(n)
	public int MaxElement() {
		return this.MaxElement(root);
	}
	private int MaxElement(Node parent) {
		int left = Integer.MIN_VALUE,right = Integer.MIN_VALUE;
		if(parent.left!=null) {
			left = MaxElement(parent.left);
		}
		if(parent.right!=null) {
			right = MaxElement(parent.right);
		}
		return Math.max(parent.data, Math.max(left, right));
	}
	
	class PairHD{
		Node node;
		int hd;
		PairHD(Node node, int hd){
			this.hd = hd;
			this.node = node;
		}
	}
	public void VerticalOrderTraversal() {
		this.VerticalOrderTraversal(this.root);
	}
	private void VerticalOrderTraversal(Node root) {
		LinkedList<PairHD> q = new LinkedList<>();
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		PairHD p = new PairHD(root,0);
		q.addLast(p);
		ArrayList<Integer> tm = new ArrayList<>();
		tm.add(root.data);
		map.put(0,tm);
		while(!q.isEmpty()) {
			PairHD tmp = q.removeFirst();
			Node node = tmp.node;
			int pHD = tmp.hd;
			if(node.left!=null) {
				int lHD = pHD - 1;
				ArrayList<Integer> list = map.get(lHD);
				if(list==null) {
					list = new ArrayList<>();
					list.add(node.left.data);
					map.put(lHD, list);
				}else {
					list.add(node.left.data);
					map.put(lHD, list);
				}
				
				PairHD pair = new PairHD(node.left, lHD);
				q.addLast(pair);
			}
			if(node.right!=null) {
				int rHD = pHD + 1;
				ArrayList<Integer> list = map.get(rHD);
				if(list==null) {
					list = new ArrayList<>();
					list.add(node.right.data);
					map.put(rHD, list);
				}else {
					list.add(node.right.data);
					map.put(rHD, list);
				}
				
				PairHD pair = new PairHD(node.right, rHD);
				q.addLast(pair);
			}
		}
		ArrayList<Integer> keys = new ArrayList<>(map.keySet());
		keys.sort(null);
		for(int key : keys) {
			System.out.println(map.get(key));
		}
	}
	public void BottomView() {
		this.BottomView(this.root);
	}
	private void BottomView(Node root) {
		LinkedList<PairHD> q = new LinkedList<>();
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		PairHD p = new PairHD(root,0);
		q.addLast(p);
		ArrayList<Integer> tm = new ArrayList<>();
		tm.add(root.data);
		map.put(0,tm);
		while(!q.isEmpty()) {
			PairHD tmp = q.removeFirst();
			Node node = tmp.node;
			int pHD = tmp.hd;
			if(node.left!=null) {
				int lHD = pHD - 1;
				ArrayList<Integer> list = map.get(lHD);
				if(list==null) {
					list = new ArrayList<>();
					list.add(node.left.data);
					map.put(lHD, list);
				}else {
					list.add(node.left.data);
					map.put(lHD, list);
				}
				
				PairHD pair = new PairHD(node.left, lHD);
				q.addLast(pair);
			}
			if(node.right!=null) {
				int rHD = pHD + 1;
				ArrayList<Integer> list = map.get(rHD);
				if(list==null) {
					list = new ArrayList<>();
					list.add(node.right.data);
					map.put(rHD, list);
				}else {
					list.add(node.right.data);
					map.put(rHD, list);
				}
				
				PairHD pair = new PairHD(node.right, rHD);
				q.addLast(pair);
			}
		}
		ArrayList<Integer> keys = new ArrayList<>(map.keySet());
		keys.sort(null);
		for(int key : keys) {
			ArrayList<Integer> vals = map.get(key);
			System.out.print(vals.get(vals.size()-1) + " ");
		}
	}
	public void TopView() {
		this.TopView(this.root);
	}
	private void TopView(Node root) {
		LinkedList<PairHD> q = new LinkedList<>();
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		PairHD p = new PairHD(root,0);
		q.addLast(p);
		ArrayList<Integer> tm = new ArrayList<>();
		tm.add(root.data);
		map.put(0,tm);
		while(!q.isEmpty()) {
			PairHD tmp = q.removeFirst();
			Node node = tmp.node;
			int pHD = tmp.hd;
			if(node.left!=null) {
				int lHD = pHD - 1;
				ArrayList<Integer> list = map.get(lHD);
				if(list==null) {
					list = new ArrayList<>();
					list.add(node.left.data);
					map.put(lHD, list);
				}else {
					list.add(node.left.data);
					map.put(lHD, list);
				}
				
				PairHD pair = new PairHD(node.left, lHD);
				q.addLast(pair);
			}
			if(node.right!=null) {
				int rHD = pHD + 1;
				ArrayList<Integer> list = map.get(rHD);
				if(list==null) {
					list = new ArrayList<>();
					list.add(node.right.data);
					map.put(rHD, list);
				}else {
					list.add(node.right.data);
					map.put(rHD, list);
				}
				
				PairHD pair = new PairHD(node.right, rHD);
				q.addLast(pair);
			}
		}
		ArrayList<Integer> keys = new ArrayList<>(map.keySet());
		keys.sort(null);
		for(int key : keys) {
			ArrayList<Integer> vals = map.get(key);
			System.out.print(vals.get(0) + " ");
		}
	}
	public void leftView() {
		this.leftView(this.root);
	}
	private void leftView(Node root) {
		LinkedList<PairHD> q = new LinkedList<>();
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		PairHD p = new PairHD(root,0);
		q.addLast(p);
		ArrayList<Integer> tm = new ArrayList<>();
		tm.add(root.data);
		map.put(0,tm);
		while(!q.isEmpty()) {
			PairHD tmp = q.removeFirst();
			Node node = tmp.node;
			int pHD = tmp.hd;
			if(node.left!=null) {
				int lHD = pHD + 1;
				ArrayList<Integer> list = map.get(lHD);
				if(list==null) {
					list = new ArrayList<>();
					list.add(node.left.data);
					map.put(lHD, list);
				}else {
					list.add(node.left.data);
					map.put(lHD, list);
				}
				
				PairHD pair = new PairHD(node.left, lHD);
				q.addLast(pair);
			}
			if(node.right!=null) {
				int rHD = pHD + 1;
				ArrayList<Integer> list = map.get(rHD);
				if(list==null) {
					list = new ArrayList<>();
					list.add(node.right.data);
					map.put(rHD, list);
				}else {
					list.add(node.right.data);
					map.put(rHD, list);
				}
				
				PairHD pair = new PairHD(node.right, rHD);
				q.addLast(pair);
			}
		}
		ArrayList<Integer> keys = new ArrayList<>(map.keySet());
		keys.sort(null);
		for(int key : keys) {
			ArrayList<Integer> vals = map.get(key);
			System.out.print(vals.get(0) + " ");
		}
	}
	private int height(Node node) {
		if(node==null)
			return 0;
		int leftHeight = height(node.left);
		int rightHeight = height(node.right);
		return leftHeight>rightHeight ? leftHeight+1 : rightHeight+1;
	}
	
	public int diamter() {
		return this.diameter(root);
	}
	
	private int diameter(Node root) {
		if(root == null)
			return 0;
		//For current node diameter
		int len1 = height(root.left) + height(root.right) + 1;
		//Recursive doing this for all other nodes
		int len2 = Math.max(diameter(root.left), diameter(root.right));
		//returning maximum of all nodes height
		return Math.max(len1, len2);
	}
	
	public int width() {
		int maxWidth = Integer.MIN_VALUE;
		int levels = height(this.root);
		for(int i = 0;i<levels;i++)
		{
			int temp = width(this.root, i);
			maxWidth = Math.max(maxWidth, temp);
		}
		return maxWidth;
	}
	private int width(Node node, int depth) {
		if(node==null)
			return 0;
		else {
			if(depth == 0)
				return 1;
			else {
				return width(node.left,depth-1) + width(node.right,depth-1);
			}
		}
	}
	
	public int maxSumLevel() {
		return this.maxSumLevel(this.root);
	}

	private int maxSumLevel(Node node) {
		int maxSum = Integer.MIN_VALUE, currSum = 0;
		int count = 0;
		int maxLevel = 0;
		Queue<Node> q = new LinkedList<>();
		q.offer(node);
		q.offer(null);
		while(!q.isEmpty()) {
			Node tmp = q.poll();
			if(tmp!=null) {
				currSum += tmp.data;
				if(tmp.left!=null)
					q.offer(tmp.left);
				if(tmp.right!=null)
					q.offer(tmp.right);
			}else {
				if(currSum > maxSum) {
					maxSum = currSum;
					maxLevel = count;
				}
				currSum = 0;
				count++;
				if(!q.isEmpty())
					q.offer(null);
			}
		}
		return maxLevel + 1 ;
	}
	
	public int fca(int a, int b) {
		return this.fca(this.root, this.root, a, b).data;
	}
    
	private Node fca(Node parent, Node child, int a, int b) {
		if(parent == null || child == null) {
			return null;
		}
		if(child.data == a || child.data == b) {
			return parent;
		}
		Node leftSubtree = fca(child, child.left, a, b);
		Node rightSubtree = fca(child, child.right, a, b);
		if(leftSubtree == rightSubtree)
			return rightSubtree;
		else {
			if(leftSubtree == null)
				return rightSubtree;
			else
				return leftSubtree;
		}
	}
	
	protected void countPaths(int sum) {
		int ans = countPathsWithSum(this.root, 0, sum, new HashMap<>());
		System.out.println(ans);
	}
	
	private int countPathsWithSum(Node node, int runningSum, int targetSum, HashMap<Integer, Integer> count) {
		if(node==null) return 0;
		
		runningSum += node.data;
		int sum = runningSum - targetSum;
		int totalPaths = count.getOrDefault(sum, 0);
		
		//One extra path
		if(runningSum == targetSum)
			totalPaths++;
		
		incrementHashTable(count, runningSum, 1); //increment paths by 1
		totalPaths += countPathsWithSum(node.left, runningSum, targetSum, count);
		totalPaths += countPathsWithSum(node.right, runningSum, targetSum, count);
		incrementHashTable(count, runningSum, -1); //decrement paths by 1
		
		return totalPaths;
	}
	
	private void incrementHashTable(HashMap<Integer, Integer> map, int runningSum, int delta) {
		int newCount = map.getOrDefault(runningSum, 0) + delta;
		if(newCount == 0) {
			map.remove(runningSum);
		}else {
			map.put(runningSum, newCount);
		}
	}
}

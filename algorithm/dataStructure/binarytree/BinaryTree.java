package dataStructure.binarytree;


/* 완전 이진 트리 */
public class BinaryTree {
	
	private Object[] nodes;
	private final int SIZE; // final이지만 생성자에서 초기화 가능
	private final int MAX_LEVEL;
	private int lastIndex;
	
	BinaryTree(int size){
		SIZE = size;
		nodes = new Object[size+1];
		MAX_LEVEL = (int)Math.ceil(Math.log(size+1)/Math.log(2));
		System.out.println(MAX_LEVEL);
	}
	
	public void add(Object e) {
		if(isFull()) throw new RuntimeException("Tree is already full!");
		nodes[++lastIndex] = e;
	}
	
	public boolean isEmpty() {
		return lastIndex == 0;
	}
	
	public boolean isFull() {
		return lastIndex == SIZE;
	}
	
	/* 전위 순회 실행 , 아래 실행 부분을 숨기기 위한 구조 */
	public void printPreorder() {
		printPreorder(1);
		System.out.println();
	}
	
	/* 전위 순회 */
	private void printPreorder(int current) {
		if(current <= lastIndex) {
			System.out.print(nodes[current] + " "); //
			printPreorder(current*2);
			printPreorder(current*2+1);
		}
	}
	
	/* 중위 순회 실행 */
	public void printInorder() {
		printInorder(1);
		System.out.println();
	}
	
	/* 중위 순회 */
	private void printInorder(int current) {
		if(current <= lastIndex) {
			printInorder(current*2);
			System.out.print(nodes[current] + " "); //
			printInorder(current*2+1);
		}
	}
	
	/* 후위 순회 실행 */
	public void printPostorder() {
		printPostorder(1);
		System.out.println();
	}
	
	/* 후위 순회 */
	private void printPostorder(int current) {
		if(current <= lastIndex) {
			printPostorder(current*2);
			printPostorder(current*2+1);
			System.out.print(nodes[current] + " "); //
		}
	}
	
	public void printTreeByLevelOrder() {
		for(int i =0; i< MAX_LEVEL; i++) {
			int start = (int)Math.pow(2, i); // 각 레벨 첫노드 인덱스
			int end = (int)Math.pow(2,  i+1) -1; // 각 레벨 마지막 노드 인덱스 
			for(int j= start; j<= end && j<= lastIndex; j++) { // 레벨별 출력
				System.out.print(nodes[j] + " ");
			}
			System.out.println();
		}
	}
	
	
	
}

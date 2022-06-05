
import java.util.Scanner;

public class Main {
    // 문제 : https://www.acmicpc.net/problem/1991
    // 코드 참고 : https://velog.io/@jini_eun/%EB%B0%B1%EC%A4%80-1991%EB%B2%88-%ED%8A%B8%EB%A6%AC-%EC%88%9C%ED%9A%8C-Java-Python

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int NODE_AMOUNT = sc.nextInt();

        Tree tree = new Tree();
        for(int i = 0; i < NODE_AMOUNT; i++){
            tree.createTree(sc.next(), sc.next(), sc.next());
        }

        tree.preOrder(tree.root);
        sb.append("\n");
        tree.inOrder(tree.root);
        sb.append("\n");
        tree.postOrder(tree.root);

        System.out.println(sb);

    }

    static class Tree {
        Node root;

        /* 트리에 노드들 추가 */
        public void createTree(String data, String leftData, String rightData){
            if(root == null){ // root 노드 생성
                root = new Node(data);

                String noChild = ".";
                if(!noChild.equals(leftData)){
                    root.left = new Node(leftData);
                }
                if(!noChild.equals(rightData)){
                    root.right = new Node(rightData);
                }
            } else { // 초기상태가 아닌 경우 위치 찾기
                search(root, data, leftData, rightData);
            }
        }

        /* 자식노드 탐색하여 그 하위 레벨에 노드 추가 */
        public void search(Node node, String data, String leftData, String rightData){
            if(node == null) return; // 재귀호출 종료
            else if (node.data.equals(data)){
                String noChild = ".";
                if(!noChild.equals(leftData)){
                    node.left = new Node(leftData);
                }
                if(!noChild.equals(rightData)){
                    node.right = new Node(rightData);
                }
            } else {
                search(node.left, data, leftData, rightData);
                search(node.right, data, leftData, rightData);
            }
        }

        /* 전위순회 : 루트 -> 좌 -> 우 */
        public void preOrder(Node root) {
            sb.append(root.data);
            if(root.left != null){
                preOrder(root.left);
            }
            if(root.right != null){
                preOrder(root.right);
            }
        }

        /* 중위순회 : 좌 -> 루트 -> 우 */
        public void inOrder(Node root){
            if(root.left != null){
                inOrder(root.left);
            }
            sb.append(root.data);
            if(root.right != null){
                inOrder(root.right);
            }
        }

        /* 후위순회 : 좌 -> 우 -> 루트 */
        public void postOrder(Node root){
            if(root.left != null){
                postOrder(root.left);
            }
            if(root.right != null){
                postOrder(root.right);
            }
            sb.append(root.data);
        }
    }
}



class Node {
    String data;
    Node left, right;

    public Node(String data){
        this.data = data;
    }

}

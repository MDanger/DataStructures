//package tree;
//
//import node.BinaryTreeNode;
//
//public class ExpressionTree extends LinkedBinaryTree<ExpressionTreeOp> {
//
//    public ExpressionTree(){
//        super();
//    }
//
//    public ExpressionTree(ExpressionTreeOp element, ExpressionTree leftSubtree, ExpressionTree rightSubtree){
//        root = new BinaryTreeNode<ExpressionTreeOp>(element, leftSubtree, rightSubtree);
//    }
//
//    public int evaluateTree(){
//        return evaluateNode(root);
//    }
//
//    public int evaluateNode(BinaryTreeNode root){
//        int result, operand1, operand2;
//        ExpressionTreeOp temp;
//
//        if (root==null) {
//            result = 0;
//        } else {
//            temp = (ExpressionTreeOp) root.getElement();
//
//            if (temp.isOperator()) {
//                operand1 = evaluateNode(root.getLeft());
//                operand2 = evaluateNode(root.getRight());
//                result = computeTerm(temp.getOperator(), operand1, operand2);
//            } else {
//                result = temp.getValue();
//            }
//        }
//
//        return result;
//    }
//
//
//}

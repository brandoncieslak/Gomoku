package gomoku_main;

import java.util.ArrayList;

public class Player {
	
	private int playouts;
	
	public Player(int playouts){
		this.playouts = playouts;
	}

	public int getBestMove(Board board, boolean showTree) {
		SearchTree tree = new SearchTree();
		for (int i = 0; i < playouts; i++) {
			tree.createRootNodes(board);
			tree.expandUCTTree(board);
		}
		ArrayList<SearchNode> nodes = tree.getNodes();
		int bestNodeIndex = 0;
		for (int i = 1; i < nodes.size(); i++) {
			if (nodes.get(i).getWins() > nodes.get(bestNodeIndex).getWins()) {
				bestNodeIndex = i;
			}
		}
		if (showTree){
			System.out.println(tree);
		}
		return nodes.get(bestNodeIndex).getMove();
	}
}

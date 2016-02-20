import java.io.*;
import java.lang.*;
import java.util.*;

/* Note : Small discrepancies but Would rather spend time explaining the correc thought process than debug Java error 
 * Key = correct logic, then figure out nit pick code pieces later, please read comments
 */
public class Solution {
	/** Need a HashMap so you can lookup IDs and scores in constant time 
	 * Space should be irrelvant compared to time complexity
	 * Assumption : all Player IDs are unique */
	HashMap<String, Double> playerID_score_map = new HashMap<String, Double>();

	/** 
	 * Insert elements into a binary tree, much easier to keep track instead always
	 * sorting an array (Insertion Sort and QuickSort would still take a long time and
	 * would require that you sort each time 
	 */
	TreeNode root = null;

	public Solution(){}
	public static void main(String args[]){
		// Assumption : Take in both a playerID and a score
		/* Best Case Scenario
			write(playerId, score);			O(1) + O(logN)
			getScoreByPlayerId(score);		O(1)
			getScoreAtPercentile(percentile);   O(logN)

			O(logN)
		*/

			/* Worst Case Scenario
			write(playerId, score);			O(N) + O(N)
			getScoreByPlayerId(score);		O(N)
			getScoreAtPercentile(percentile);   O(N)
			O(N)
		*/

	}
	void write (String playerId, Double score) {
		/** 
		 * Put O(1) time
		 * Assumption : Score can only be positive
		 * Key : playerId, Value : score
		 */
		if (playerId != null && score >= 0 && score != null)
			playerID_score_map.put(playerId, score);	

		insertScoreInTree(score);		
	}

	/* O(logN) on balanced tree, O(N) unbalanced tree */
	void insertScoreInTree(Double score) {
		if (root == null) root = new TreeNode(score);
		else root.insert(score);
	}
	/* Lookup O(1) time via HashMap because playerIds are unique */
	Double getScoreByPlayerId(String playerId) {
		Double result = 0.0;
		if (playerId != null)
			return playerID_score_map.get(playerId);
		else return null;
	}
	/* O(logN) on balanced tree, O(N) unbalanced tree */
	Double getScoreAtPercentile(Double percentile) {
		// assume percentile 0 - 100, (ex. 80th percentile)
		percentile /= 100;				// .80
		int amountOfScores = playerID_score_map.size();
		int rank = (int)(percentile * amountOfScores);		// .80 * 20 scores = rank
		
		return root.getScore(rank);
	}
	public class TreeNode {
		public int leftSize = 0;
		public TreeNode left, right;
		public Double data = 0.0;
		public TreeNode(Double data) {
			data = this.data;
		}
		/* O(logN) on balanced tree, O(N) unbalanced tree */
		public void insert(Double d) {
			if (d <= data) {
				if (left != null)	left.insert(d);
				else left = new TreeNode(d);
			}
			else {
				if (right != null) right.insert(d);
				else right = new TreeNode(d);
			}
		}

		/* O(logN) on balanced tree, O(N) unbalanced tree */
		public Double getScore(int rank) {
			int r = leftSize+1;
			if (rank == r) {
				return root.data;
			}
			else if(rank < r) {
				return left.getScore(rank);
			}
			else {
				return right.getScore(rank-r);
			}
			
		}
	}
}


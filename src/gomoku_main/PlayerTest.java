package gomoku_main;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PlayerTest {

	Player player;
	Board board;

	@Before
	public void setUp() throws Exception {
		player = new Player(100, true);
		board = new Board();
	}

	@Test
	public void testPlayWinningMove() {
		board.play("b2");
		board.play("c2");
		board.play("e5");
		board.play("d2");
		board.play("a1");
		board.play("e2");
		board.play("f6");
		board.play("f2");
		board.play("a4");
		String s = board.indexToString(player.getBestMove(board, true));
		System.out.println(board);
		assertEquals("g2", s);
	}

	@Test
	public void testBlockWinningMove() {
		board.play("b2");
		board.play("c2");
		board.play("e5");
		board.play("d2");
		board.play("a1");
		board.play("e2");
		board.play("f6");
		board.play("f2");
		assertEquals("g2", board.indexToString(player.getBestMove(board, false)));
	}

}

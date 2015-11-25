import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by semanticer on 19. 11. 2015.
 */
public class TreeNodeTest {


    private TreeNode testTree;

    @Before
    public void setUp() throws Exception {
        testTree = getTestTree();
    }


    @org.junit.Test
    public void testIsIn() throws Exception {
        assertTrue(testTree.isIn(10));
        assertTrue(testTree.isIn(150));
        assertTrue(testTree.isIn(100));
        assertTrue(testTree.isIn(50));
        assertTrue(testTree.isIn(15));

        assertFalse(testTree.isIn(0));
        assertFalse(testTree.isIn(-1));
        assertFalse(testTree.isIn(120));
        assertFalse(testTree.isIn(40));
    }

    @org.junit.Test
    public void testDepth() throws Exception {
        TreeNode deepTwo = new Some(0, new None(), new None());
        TreeNode deepOne = new None();

        assertEquals(2, deepTwo.depth());
        assertEquals(1, deepOne.depth());
        assertEquals(5, testTree.depth());
    }

    @org.junit.Test
    public void testAdd() throws Exception {
        // WARNING add test is based on depth function
        TreeNode newBig = testTree.add(200);

        assertEquals(6, newBig.depth());
    }

    @Test
    public void testSelect() throws Exception {
        assertEquals(10, testTree.select(0)); // smallest
        assertEquals(15, testTree.select(1)); // second smallest
        assertEquals(50, testTree.select(3));
        assertEquals(60, testTree.select(4));
        assertEquals(150, testTree.select(6));
    }

    public static TreeNode getTestTree() {
        /**
         *           50
         *         /    \
         *        /      \
         *       /        \
         *     10          80
         *    /  \        /   \
         *   N   15     60    100
         *      /  \   / \    / \
         *     N    N N   N  N   150
         *                      /   \
         *                     N     N
         */

        return new Some(50,
                new Some(10,
                        new None(),
                        new Some(15, new None(), new None())
                ),
                new Some(80,
                        new Some(60,
                                new None(),
                                new None()
                        ),
                        new Some(100,
                                new None(),
                                new Some(150, new None(), new None())
                        )
                )
        );
    }
}
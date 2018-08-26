import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * AVL tests.
 * @author Timothy Gregg, Andrew Wittenmyer
 * @version 1.0
 */
public class AndrewGeneratedTest {

    private AVLInterface<Integer> avlTree;

    @Before
    public void setup() {
        avlTree = new AVL<>();
    }

    @Test
    public void StressTestIsBestTest() {
        List<Integer> comparisonList;
        assertEquals(0, avlTree.size());
        avlTree.add(73);
        Integer[] levelCompArr0 = {73};
        Integer[] inorderCompArr0 = {73};
        assertEquals(1, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr0), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr0), avlTree.inorder());

        avlTree.add(43);
        Integer[] levelCompArr1 = {73, 43};
        Integer[] inorderCompArr1 = {43, 73};
        assertEquals(2, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr1), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr1), avlTree.inorder());

        avlTree.add(100);
        Integer[] levelCompArr2 = {73, 43, 100};
        Integer[] inorderCompArr2 = {43, 73, 100};
        assertEquals(3, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr2), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr2), avlTree.inorder());

        avlTree.add(190);
        Integer[] levelCompArr3 = {73, 43, 100, 190};
        Integer[] inorderCompArr3 = {43, 73, 100, 190};
        assertEquals(4, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr3), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr3), avlTree.inorder());

        avlTree.add(34);
        Integer[] levelCompArr4 = {73, 43, 100, 34, 190};
        Integer[] inorderCompArr4 = {34, 43, 73, 100, 190};
        assertEquals(5, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr4), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr4), avlTree.inorder());

        avlTree.add(96);
        Integer[] levelCompArr5 = {73, 43, 100, 34, 96, 190};
        Integer[] inorderCompArr5 = {34, 43, 73, 96, 100, 190};
        assertEquals(6, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr5), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr5), avlTree.inorder());

        avlTree.add(87);
        Integer[] levelCompArr6 = {73, 43, 100, 34, 96, 190, 87};
        Integer[] inorderCompArr6 = {34, 43, 73, 87, 96, 100, 190};
        assertEquals(7, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr6), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr6), avlTree.inorder());

        avlTree.add(137);
        Integer[] levelCompArr7 = {73, 43, 100, 34, 96, 190, 87, 137};
        Integer[] inorderCompArr7 = {34, 43, 73, 87, 96, 100, 137, 190};
        assertEquals(8, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr7), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr7), avlTree.inorder());

        avlTree.add(31);
        Integer[] levelCompArr8 = {73, 34, 100, 31, 43, 96, 190, 87, 137};
        Integer[] inorderCompArr8 = {31, 34, 43, 73, 87, 96, 100, 137, 190};
        assertEquals(9, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr8), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr8), avlTree.inorder());

        avlTree.add(53);
        Integer[] levelCompArr9 = {73, 34, 100, 31, 43, 96, 190, 53, 87, 137};
        Integer[] inorderCompArr9 = {31, 34, 43, 53, 73, 87, 96, 100, 137, 190};
        assertEquals(10, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr9), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr9), avlTree.inorder());

        avlTree.add(62);
        Integer[] levelCompArr10 = {73, 34, 100, 31, 53, 96, 190, 43, 62, 87, 137};
        Integer[] inorderCompArr10 = {31, 34, 43, 53, 62, 73, 87, 96, 100, 137, 190};
        assertEquals(11, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr10), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr10), avlTree.inorder());

        avlTree.add(155);
        Integer[] levelCompArr11 = {73, 34, 100, 31, 53, 96, 155, 43, 62, 87, 137, 190};
        Integer[] inorderCompArr11 = {31, 34, 43, 53, 62, 73, 87, 96, 100, 137, 155, 190};
        assertEquals(12, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr11), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr11), avlTree.inorder());

        avlTree.add(123);
        Integer[] levelCompArr12 = {73, 34, 100, 31, 53, 96, 155, 43, 62, 87, 137, 190, 123};
        Integer[] inorderCompArr12 = {31, 34, 43, 53, 62, 73, 87, 96, 100, 123, 137, 155, 190};
        assertEquals(13, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr12), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr12), avlTree.inorder());

        avlTree.add(152);
        Integer[] levelCompArr13 = {73, 34, 100, 31, 53, 96, 155, 43, 62, 87, 137, 190, 123, 152};
        Integer[] inorderCompArr13 = {31, 34, 43, 53, 62, 73, 87, 96, 100, 123, 137, 152, 155, 190};
        assertEquals(14, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr13), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr13), avlTree.inorder());

        avlTree.add(86);
        Integer[] levelCompArr14 = {73, 34, 100, 31, 53, 87, 155, 43, 62, 86, 96, 137, 190, 123, 152};
        Integer[] inorderCompArr14 = {31, 34, 43, 53, 62, 73, 86, 87, 96, 100, 123, 137, 152, 155, 190};
        assertEquals(15, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr14), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr14), avlTree.inorder());

        avlTree.add(60);
        Integer[] levelCompArr15 = {73, 53, 100, 34, 62, 87, 155, 31, 43, 60, 86, 96, 137, 190, 123, 152};
        Integer[] inorderCompArr15 = {31, 34, 43, 53, 60, 62, 73, 86, 87, 96, 100, 123, 137, 152, 155, 190};
        assertEquals(16, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr15), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr15), avlTree.inorder());

        avlTree.add(154);
        Integer[] levelCompArr16 = {73, 53, 100, 34, 62, 87, 152, 31, 43, 60, 86, 96, 137, 155, 123, 154, 190};
        Integer[] inorderCompArr16 = {31, 34, 43, 53, 60, 62, 73, 86, 87, 96, 100, 123, 137, 152, 154, 155, 190};
        assertEquals(17, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr16), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr16), avlTree.inorder());

        avlTree.add(122);
        Integer[] levelCompArr17 = {73, 53, 100, 34, 62, 87, 152, 31, 43, 60, 86, 96, 123, 155, 122, 137, 154, 190};
        Integer[] inorderCompArr17 = {31, 34, 43, 53, 60, 62, 73, 86, 87, 96, 100, 122, 123, 137, 152, 154, 155, 190};
        assertEquals(18, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr17), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr17), avlTree.inorder());

        avlTree.add(1);
        Integer[] levelCompArr18 = {73, 53, 100, 34, 62, 87, 152, 31, 43, 60, 86, 96, 123, 155, 1, 122, 137, 154, 190};
        Integer[] inorderCompArr18 = {1, 31, 34, 43, 53, 60, 62, 73, 86, 87, 96, 100, 122, 123, 137, 152, 154, 155, 190};
        assertEquals(19, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr18), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr18), avlTree.inorder());

        avlTree.add(109);
        Integer[] levelCompArr19 = {73, 53, 123, 34, 62, 100, 152, 31, 43, 60, 87, 122, 137, 155, 1, 86, 96, 109, 154, 190};
        Integer[] inorderCompArr19 = {1, 31, 34, 43, 53, 60, 62, 73, 86, 87, 96, 100, 109, 122, 123, 137, 152, 154, 155, 190};
        assertEquals(20, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr19), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr19), avlTree.inorder());

        avlTree.add(11);
        Integer[] levelCompArr20 = {73, 53, 123, 34, 62, 100, 152, 11, 43, 60, 87, 122, 137, 155, 1, 31, 86, 96, 109, 154, 190};
        Integer[] inorderCompArr20 = {1, 11, 31, 34, 43, 53, 60, 62, 73, 86, 87, 96, 100, 109, 122, 123, 137, 152, 154, 155, 190};
        assertEquals(21, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr20), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr20), avlTree.inorder());

        avlTree.add(163);
        Integer[] levelCompArr21 = {73, 53, 123, 34, 62, 100, 155, 11, 43, 60, 87, 122, 152, 190, 1, 31, 86, 96, 109, 137, 154, 163};
        Integer[] inorderCompArr21 = {1, 11, 31, 34, 43, 53, 60, 62, 73, 86, 87, 96, 100, 109, 122, 123, 137, 152, 154, 155, 163, 190};
        assertEquals(22, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr21), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr21), avlTree.inorder());

        avlTree.add(188);
        Integer[] levelCompArr22 = {73, 53, 123, 34, 62, 100, 155, 11, 43, 60, 87, 122, 152, 188, 1, 31, 86, 96, 109, 137, 154, 163, 190};
        Integer[] inorderCompArr22 = {1, 11, 31, 34, 43, 53, 60, 62, 73, 86, 87, 96, 100, 109, 122, 123, 137, 152, 154, 155, 163, 188, 190};
        assertEquals(23, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr22), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr22), avlTree.inorder());

        assertEquals((Integer) 11, avlTree.remove(11));
        Integer[] levelCompArr23 = {73, 53, 123, 34, 62, 100, 155, 1, 43, 60, 87, 122, 152, 188, 31, 86, 96, 109, 137, 154, 163, 190};
        Integer[] inorderCompArr23 = {1, 31, 34, 43, 53, 60, 62, 73, 86, 87, 96, 100, 109, 122, 123, 137, 152, 154, 155, 163, 188, 190};
        assertEquals(22, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr23), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr23), avlTree.inorder());

        avlTree.add(82);
        Integer[] levelCompArr24 = {73, 53, 123, 34, 62, 100, 155, 1, 43, 60, 87, 122, 152, 188, 31, 86, 96, 109, 137, 154, 163, 190, 82};
        Integer[] inorderCompArr24 = {1, 31, 34, 43, 53, 60, 62, 73, 82, 86, 87, 96, 100, 109, 122, 123, 137, 152, 154, 155, 163, 188, 190};
        assertEquals(23, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr24), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr24), avlTree.inorder());

        avlTree.add(24);
        Integer[] levelCompArr25 = {73, 53, 123, 34, 62, 100, 155, 24, 43, 60, 87, 122, 152, 188, 1, 31, 86, 96, 109, 137, 154, 163, 190, 82};
        Integer[] inorderCompArr25 = {1, 24, 31, 34, 43, 53, 60, 62, 73, 82, 86, 87, 96, 100, 109, 122, 123, 137, 152, 154, 155, 163, 188, 190};
        assertEquals(24, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr25), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr25), avlTree.inorder());

        assertEquals((Integer) 190, avlTree.remove(190));
        Integer[] levelCompArr26 = {73, 53, 123, 34, 62, 100, 155, 24, 43, 60, 87, 122, 152, 188, 1, 31, 86, 96, 109, 137, 154, 163, 82};
        Integer[] inorderCompArr26 = {1, 24, 31, 34, 43, 53, 60, 62, 73, 82, 86, 87, 96, 100, 109, 122, 123, 137, 152, 154, 155, 163, 188};
        assertEquals(23, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr26), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr26), avlTree.inorder());

        avlTree.add(178);
        Integer[] levelCompArr27 = {73, 53, 123, 34, 62, 100, 155, 24, 43, 60, 87, 122, 152, 178, 1, 31, 86, 96, 109, 137, 154, 163, 188, 82};
        Integer[] inorderCompArr27 = {1, 24, 31, 34, 43, 53, 60, 62, 73, 82, 86, 87, 96, 100, 109, 122, 123, 137, 152, 154, 155, 163, 178, 188};
        assertEquals(24, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr27), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr27), avlTree.inorder());

        assertEquals((Integer) 87, avlTree.remove(87));
        Integer[] levelCompArr28 = {73, 53, 123, 34, 62, 100, 155, 24, 43, 60, 86, 122, 152, 178, 1, 31, 82, 96, 109, 137, 154, 163, 188};
        Integer[] inorderCompArr28 = {1, 24, 31, 34, 43, 53, 60, 62, 73, 82, 86, 96, 100, 109, 122, 123, 137, 152, 154, 155, 163, 178, 188};
        assertEquals(23, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr28), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr28), avlTree.inorder());

        assertEquals((Integer) 53, avlTree.remove(53));
        Integer[] levelCompArr29 = {73, 43, 123, 24, 62, 100, 155, 1, 34, 60, 86, 122, 152, 178, 31, 82, 96, 109, 137, 154, 163, 188};
        Integer[] inorderCompArr29 = {1, 24, 31, 34, 43, 60, 62, 73, 82, 86, 96, 100, 109, 122, 123, 137, 152, 154, 155, 163, 178, 188};
        assertEquals(22, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr29), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr29), avlTree.inorder());

        assertEquals((Integer) 154, avlTree.remove(154));
        Integer[] levelCompArr30 = {73, 43, 123, 24, 62, 100, 155, 1, 34, 60, 86, 122, 152, 178, 31, 82, 96, 109, 137, 163, 188};
        Integer[] inorderCompArr30 = {1, 24, 31, 34, 43, 60, 62, 73, 82, 86, 96, 100, 109, 122, 123, 137, 152, 155, 163, 178, 188};
        assertEquals(21, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr30), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr30), avlTree.inorder());

        assertEquals((Integer) 34, avlTree.remove(34));
        Integer[] levelCompArr31 = {73, 43, 123, 24, 62, 100, 155, 1, 31, 60, 86, 122, 152, 178, 82, 96, 109, 137, 163, 188};
        Integer[] inorderCompArr31 = {1, 24, 31, 43, 60, 62, 73, 82, 86, 96, 100, 109, 122, 123, 137, 152, 155, 163, 178, 188};
        assertEquals(20, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr31), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr31), avlTree.inorder());

        avlTree.add(121);
        Integer[] levelCompArr32 = {73, 43, 123, 24, 62, 100, 155, 1, 31, 60, 86, 121, 152, 178, 82, 96, 109, 122, 137, 163, 188};
        Integer[] inorderCompArr32 = {1, 24, 31, 43, 60, 62, 73, 82, 86, 96, 100, 109, 121, 122, 123, 137, 152, 155, 163, 178, 188};
        assertEquals(21, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr32), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr32), avlTree.inorder());

        assertEquals((Integer) 82, avlTree.remove(82));
        Integer[] levelCompArr33 = {73, 43, 123, 24, 62, 100, 155, 1, 31, 60, 86, 121, 152, 178, 96, 109, 122, 137, 163, 188};
        Integer[] inorderCompArr33 = {1, 24, 31, 43, 60, 62, 73, 86, 96, 100, 109, 121, 122, 123, 137, 152, 155, 163, 178, 188};
        assertEquals(20, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr33), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr33), avlTree.inorder());

        avlTree.add(21);
        Integer[] levelCompArr34 = {73, 43, 123, 24, 62, 100, 155, 1, 31, 60, 86, 121, 152, 178, 21, 96, 109, 122, 137, 163, 188};
        Integer[] inorderCompArr34 = {1, 21, 24, 31, 43, 60, 62, 73, 86, 96, 100, 109, 121, 122, 123, 137, 152, 155, 163, 178, 188};
        assertEquals(21, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr34), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr34), avlTree.inorder());

        avlTree.add(185);
        Integer[] levelCompArr35 = {73, 43, 123, 24, 62, 100, 155, 1, 31, 60, 86, 121, 152, 178, 21, 96, 109, 122, 137, 163, 188, 185};
        Integer[] inorderCompArr35 = {1, 21, 24, 31, 43, 60, 62, 73, 86, 96, 100, 109, 121, 122, 123, 137, 152, 155, 163, 178, 185, 188};
        assertEquals(22, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr35), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr35), avlTree.inorder());

        avlTree.add(186);
        Integer[] levelCompArr36 = {73, 43, 123, 24, 62, 100, 155, 1, 31, 60, 86, 121, 152, 178, 21, 96, 109, 122, 137, 163, 186, 185, 188};
        Integer[] inorderCompArr36 = {1, 21, 24, 31, 43, 60, 62, 73, 86, 96, 100, 109, 121, 122, 123, 137, 152, 155, 163, 178, 185, 186, 188};
        assertEquals(23, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr36), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr36), avlTree.inorder());

        assertEquals((Integer) 73, avlTree.remove(73));
        Integer[] levelCompArr37 = {123, 62, 155, 24, 100, 152, 178, 1, 43, 86, 121, 137, 163, 186, 21, 31, 60, 96, 109, 122, 185, 188};
        Integer[] inorderCompArr37 = {1, 21, 24, 31, 43, 60, 62, 86, 96, 100, 109, 121, 122, 123, 137, 152, 155, 163, 178, 185, 186, 188};
        assertEquals(22, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr37), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr37), avlTree.inorder());

        avlTree.add(58);
        Integer[] levelCompArr38 = {123, 62, 155, 24, 100, 152, 178, 1, 43, 86, 121, 137, 163, 186, 21, 31, 60, 96, 109, 122, 185, 188, 58};
        Integer[] inorderCompArr38 = {1, 21, 24, 31, 43, 58, 60, 62, 86, 96, 100, 109, 121, 122, 123, 137, 152, 155, 163, 178, 185, 186, 188};
        assertEquals(23, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr38), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr38), avlTree.inorder());

        assertEquals((Integer) 43, avlTree.remove(43));
        Integer[] levelCompArr39 = {123, 62, 155, 24, 100, 152, 178, 1, 58, 86, 121, 137, 163, 186, 21, 31, 60, 96, 109, 122, 185, 188};
        Integer[] inorderCompArr39 = {1, 21, 24, 31, 58, 60, 62, 86, 96, 100, 109, 121, 122, 123, 137, 152, 155, 163, 178, 185, 186, 188};
        assertEquals(22, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr39), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr39), avlTree.inorder());

        avlTree.add(49);
        Integer[] levelCompArr40 = {123, 62, 155, 24, 100, 152, 178, 1, 58, 86, 121, 137, 163, 186, 21, 31, 60, 96, 109, 122, 185, 188, 49};
        Integer[] inorderCompArr40 = {1, 21, 24, 31, 49, 58, 60, 62, 86, 96, 100, 109, 121, 122, 123, 137, 152, 155, 163, 178, 185, 186, 188};
        assertEquals(23, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr40), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr40), avlTree.inorder());

        assertEquals((Integer) 185, avlTree.remove(185));
        Integer[] levelCompArr41 = {123, 62, 155, 24, 100, 152, 178, 1, 58, 86, 121, 137, 163, 186, 21, 31, 60, 96, 109, 122, 188, 49};
        Integer[] inorderCompArr41 = {1, 21, 24, 31, 49, 58, 60, 62, 86, 96, 100, 109, 121, 122, 123, 137, 152, 155, 163, 178, 186, 188};
        assertEquals(22, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr41), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr41), avlTree.inorder());

        avlTree.add(72);
        Integer[] levelCompArr42 = {123, 62, 155, 24, 100, 152, 178, 1, 58, 86, 121, 137, 163, 186, 21, 31, 60, 72, 96, 109, 122, 188, 49};
        Integer[] inorderCompArr42 = {1, 21, 24, 31, 49, 58, 60, 62, 72, 86, 96, 100, 109, 121, 122, 123, 137, 152, 155, 163, 178, 186, 188};
        assertEquals(23, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr42), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr42), avlTree.inorder());

        avlTree.add(103);
        Integer[] levelCompArr43 = {123, 62, 155, 24, 100, 152, 178, 1, 58, 86, 121, 137, 163, 186, 21, 31, 60, 72, 96, 109, 122, 188, 49, 103};
        Integer[] inorderCompArr43 = {1, 21, 24, 31, 49, 58, 60, 62, 72, 86, 96, 100, 103, 109, 121, 122, 123, 137, 152, 155, 163, 178, 186, 188};
        assertEquals(24, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr43), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr43), avlTree.inorder());

        avlTree.add(26);
        Integer[] levelCompArr44 = {123, 62, 155, 24, 100, 152, 178, 1, 58, 86, 121, 137, 163, 186, 21, 31, 60, 72, 96, 109, 122, 188, 26, 49, 103};
        Integer[] inorderCompArr44 = {1, 21, 24, 26, 31, 49, 58, 60, 62, 72, 86, 96, 100, 103, 109, 121, 122, 123, 137, 152, 155, 163, 178, 186, 188};
        assertEquals(25, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr44), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr44), avlTree.inorder());

        avlTree.add(87);
        Integer[] levelCompArr45 = {123, 62, 155, 24, 100, 152, 178, 1, 58, 86, 121, 137, 163, 186, 21, 31, 60, 72, 96, 109, 122, 188, 26, 49, 87, 103};
        Integer[] inorderCompArr45 = {1, 21, 24, 26, 31, 49, 58, 60, 62, 72, 86, 87, 96, 100, 103, 109, 121, 122, 123, 137, 152, 155, 163, 178, 186, 188};
        assertEquals(26, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr45), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr45), avlTree.inorder());

        assertEquals((Integer) 26, avlTree.remove(26));
        Integer[] levelCompArr46 = {123, 62, 155, 24, 100, 152, 178, 1, 58, 86, 121, 137, 163, 186, 21, 31, 60, 72, 96, 109, 122, 188, 49, 87, 103};
        Integer[] inorderCompArr46 = {1, 21, 24, 31, 49, 58, 60, 62, 72, 86, 87, 96, 100, 103, 109, 121, 122, 123, 137, 152, 155, 163, 178, 186, 188};
        assertEquals(25, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr46), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr46), avlTree.inorder());

        avlTree.add(106);
        Integer[] levelCompArr47 = {123, 62, 155, 24, 100, 152, 178, 1, 58, 86, 121, 137, 163, 186, 21, 31, 60, 72, 96, 106, 122, 188, 49, 87, 103, 109};
        Integer[] inorderCompArr47 = {1, 21, 24, 31, 49, 58, 60, 62, 72, 86, 87, 96, 100, 103, 106, 109, 121, 122, 123, 137, 152, 155, 163, 178, 186, 188};
        assertEquals(26, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr47), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr47), avlTree.inorder());

        avlTree.add(32);
        Integer[] levelCompArr48 = {123, 62, 155, 24, 100, 152, 178, 1, 58, 86, 121, 137, 163, 186, 21, 32, 60, 72, 96, 106, 122, 188, 31, 49, 87, 103, 109};
        Integer[] inorderCompArr48 = {1, 21, 24, 31, 32, 49, 58, 60, 62, 72, 86, 87, 96, 100, 103, 106, 109, 121, 122, 123, 137, 152, 155, 163, 178, 186, 188};
        assertEquals(27, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr48), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr48), avlTree.inorder());

        avlTree.add(54);
        Integer[] levelCompArr49 = {123, 62, 155, 24, 100, 152, 178, 1, 49, 86, 121, 137, 163, 186, 21, 32, 58, 72, 96, 106, 122, 188, 31, 54, 60, 87, 103, 109};
        Integer[] inorderCompArr49 = {1, 21, 24, 31, 32, 49, 54, 58, 60, 62, 72, 86, 87, 96, 100, 103, 106, 109, 121, 122, 123, 137, 152, 155, 163, 178, 186, 188};
        assertEquals(28, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr49), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr49), avlTree.inorder());

        avlTree.add(135);
        Integer[] levelCompArr50 = {123, 62, 155, 24, 100, 137, 178, 1, 49, 86, 121, 135, 152, 163, 186, 21, 32, 58, 72, 96, 106, 122, 188, 31, 54, 60, 87, 103, 109};
        Integer[] inorderCompArr50 = {1, 21, 24, 31, 32, 49, 54, 58, 60, 62, 72, 86, 87, 96, 100, 103, 106, 109, 121, 122, 123, 135, 137, 152, 155, 163, 178, 186, 188};
        assertEquals(29, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr50), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr50), avlTree.inorder());

        avlTree.add(173);
        Integer[] levelCompArr51 = {123, 62, 155, 24, 100, 137, 178, 1, 49, 86, 121, 135, 152, 163, 186, 21, 32, 58, 72, 96, 106, 122, 173, 188, 31, 54, 60, 87, 103, 109};
        Integer[] inorderCompArr51 = {1, 21, 24, 31, 32, 49, 54, 58, 60, 62, 72, 86, 87, 96, 100, 103, 106, 109, 121, 122, 123, 135, 137, 152, 155, 163, 173, 178, 186, 188};
        assertEquals(30, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr51), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr51), avlTree.inorder());

        avlTree.add(194);
        Integer[] levelCompArr52 = {123, 62, 155, 24, 100, 137, 178, 1, 49, 86, 121, 135, 152, 163, 188, 21, 32, 58, 72, 96, 106, 122, 173, 186, 194, 31, 54, 60, 87, 103, 109};
        Integer[] inorderCompArr52 = {1, 21, 24, 31, 32, 49, 54, 58, 60, 62, 72, 86, 87, 96, 100, 103, 106, 109, 121, 122, 123, 135, 137, 152, 155, 163, 173, 178, 186, 188, 194};
        assertEquals(31, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr52), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr52), avlTree.inorder());

        avlTree.add(9);
        Integer[] levelCompArr53 = {123, 62, 155, 24, 100, 137, 178, 9, 49, 86, 121, 135, 152, 163, 188, 1, 21, 32, 58, 72, 96, 106, 122, 173, 186, 194, 31, 54, 60, 87, 103, 109};
        Integer[] inorderCompArr53 = {1, 9, 21, 24, 31, 32, 49, 54, 58, 60, 62, 72, 86, 87, 96, 100, 103, 106, 109, 121, 122, 123, 135, 137, 152, 155, 163, 173, 178, 186, 188, 194};
        assertEquals(32, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr53), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr53), avlTree.inorder());

        avlTree.add(10);
        Integer[] levelCompArr54 = {123, 62, 155, 24, 100, 137, 178, 9, 49, 86, 121, 135, 152, 163, 188, 1, 21, 32, 58, 72, 96, 106, 122, 173, 186, 194, 10, 31, 54, 60, 87, 103, 109};
        Integer[] inorderCompArr54 = {1, 9, 10, 21, 24, 31, 32, 49, 54, 58, 60, 62, 72, 86, 87, 96, 100, 103, 106, 109, 121, 122, 123, 135, 137, 152, 155, 163, 173, 178, 186, 188, 194};
        assertEquals(33, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr54), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr54), avlTree.inorder());

        assertEquals((Integer) 24, avlTree.remove(24));
        Integer[] levelCompArr55 = {123, 62, 155, 21, 100, 137, 178, 9, 49, 86, 121, 135, 152, 163, 188, 1, 10, 32, 58, 72, 96, 106, 122, 173, 186, 194, 31, 54, 60, 87, 103, 109};
        Integer[] inorderCompArr55 = {1, 9, 10, 21, 31, 32, 49, 54, 58, 60, 62, 72, 86, 87, 96, 100, 103, 106, 109, 121, 122, 123, 135, 137, 152, 155, 163, 173, 178, 186, 188, 194};
        assertEquals(32, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr55), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr55), avlTree.inorder());

        assertEquals((Integer) 31, avlTree.remove(31));
        Integer[] levelCompArr56 = {123, 62, 155, 21, 100, 137, 178, 9, 49, 86, 121, 135, 152, 163, 188, 1, 10, 32, 58, 72, 96, 106, 122, 173, 186, 194, 54, 60, 87, 103, 109};
        Integer[] inorderCompArr56 = {1, 9, 10, 21, 32, 49, 54, 58, 60, 62, 72, 86, 87, 96, 100, 103, 106, 109, 121, 122, 123, 135, 137, 152, 155, 163, 173, 178, 186, 188, 194};
        assertEquals(31, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr56), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr56), avlTree.inorder());

        avlTree.add(47);
        Integer[] levelCompArr57 = {123, 62, 155, 21, 100, 137, 178, 9, 49, 86, 121, 135, 152, 163, 188, 1, 10, 32, 58, 72, 96, 106, 122, 173, 186, 194, 47, 54, 60, 87, 103, 109};
        Integer[] inorderCompArr57 = {1, 9, 10, 21, 32, 47, 49, 54, 58, 60, 62, 72, 86, 87, 96, 100, 103, 106, 109, 121, 122, 123, 135, 137, 152, 155, 163, 173, 178, 186, 188, 194};
        assertEquals(32, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr57), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr57), avlTree.inorder());

        avlTree.add(83);
        Integer[] levelCompArr58 = {123, 62, 155, 21, 100, 137, 178, 9, 49, 86, 121, 135, 152, 163, 188, 1, 10, 32, 58, 72, 96, 106, 122, 173, 186, 194, 47, 54, 60, 83, 87, 103, 109};
        Integer[] inorderCompArr58 = {1, 9, 10, 21, 32, 47, 49, 54, 58, 60, 62, 72, 83, 86, 87, 96, 100, 103, 106, 109, 121, 122, 123, 135, 137, 152, 155, 163, 173, 178, 186, 188, 194};
        assertEquals(33, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr58), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr58), avlTree.inorder());

        avlTree.add(6);
        Integer[] levelCompArr59 = {123, 62, 155, 21, 100, 137, 178, 9, 49, 86, 121, 135, 152, 163, 188, 1, 10, 32, 58, 72, 96, 106, 122, 173, 186, 194, 6, 47, 54, 60, 83, 87, 103, 109};
        Integer[] inorderCompArr59 = {1, 6, 9, 10, 21, 32, 47, 49, 54, 58, 60, 62, 72, 83, 86, 87, 96, 100, 103, 106, 109, 121, 122, 123, 135, 137, 152, 155, 163, 173, 178, 186, 188, 194};
        assertEquals(34, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr59), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr59), avlTree.inorder());

        avlTree.add(68);
        Integer[] levelCompArr60 = {123, 62, 155, 21, 100, 137, 178, 9, 49, 86, 121, 135, 152, 163, 188, 1, 10, 32, 58, 72, 96, 106, 122, 173, 186, 194, 6, 47, 54, 60, 68, 83, 87, 103, 109};
        Integer[] inorderCompArr60 = {1, 6, 9, 10, 21, 32, 47, 49, 54, 58, 60, 62, 68, 72, 83, 86, 87, 96, 100, 103, 106, 109, 121, 122, 123, 135, 137, 152, 155, 163, 173, 178, 186, 188, 194};
        assertEquals(35, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr60), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr60), avlTree.inorder());

        avlTree.add(105);
        Integer[] levelCompArr61 = {123, 62, 155, 21, 100, 137, 178, 9, 49, 86, 106, 135, 152, 163, 188, 1, 10, 32, 58, 72, 96, 103, 121, 173, 186, 194, 6, 47, 54, 60, 68, 83, 87, 105, 109, 122};
        Integer[] inorderCompArr61 = {1, 6, 9, 10, 21, 32, 47, 49, 54, 58, 60, 62, 68, 72, 83, 86, 87, 96, 100, 103, 105, 106, 109, 121, 122, 123, 135, 137, 152, 155, 163, 173, 178, 186, 188, 194};
        assertEquals(36, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr61), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr61), avlTree.inorder());

        avlTree.add(158);
        Integer[] levelCompArr62 = {123, 62, 155, 21, 100, 137, 178, 9, 49, 86, 106, 135, 152, 163, 188, 1, 10, 32, 58, 72, 96, 103, 121, 158, 173, 186, 194, 6, 47, 54, 60, 68, 83, 87, 105, 109, 122};
        Integer[] inorderCompArr62 = {1, 6, 9, 10, 21, 32, 47, 49, 54, 58, 60, 62, 68, 72, 83, 86, 87, 96, 100, 103, 105, 106, 109, 121, 122, 123, 135, 137, 152, 155, 158, 163, 173, 178, 186, 188, 194};
        assertEquals(37, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr62), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr62), avlTree.inorder());

        assertEquals((Integer) 103, avlTree.remove(103));
        Integer[] levelCompArr63 = {123, 62, 155, 21, 100, 137, 178, 9, 49, 86, 106, 135, 152, 163, 188, 1, 10, 32, 58, 72, 96, 105, 121, 158, 173, 186, 194, 6, 47, 54, 60, 68, 83, 87, 109, 122};
        Integer[] inorderCompArr63 = {1, 6, 9, 10, 21, 32, 47, 49, 54, 58, 60, 62, 68, 72, 83, 86, 87, 96, 100, 105, 106, 109, 121, 122, 123, 135, 137, 152, 155, 158, 163, 173, 178, 186, 188, 194};
        assertEquals(36, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr63), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr63), avlTree.inorder());

        avlTree.add(50);
        Integer[] levelCompArr64 = {62, 21, 123, 9, 49, 100, 155, 1, 10, 32, 58, 86, 106, 137, 178, 6, 47, 54, 60, 72, 96, 105, 121, 135, 152, 163, 188, 50, 68, 83, 87, 109, 122, 158, 173, 186, 194};
        Integer[] inorderCompArr64 = {1, 6, 9, 10, 21, 32, 47, 49, 50, 54, 58, 60, 62, 68, 72, 83, 86, 87, 96, 100, 105, 106, 109, 121, 122, 123, 135, 137, 152, 155, 158, 163, 173, 178, 186, 188, 194};
        assertEquals(37, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr64), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr64), avlTree.inorder());

        avlTree.add(5);
        Integer[] levelCompArr65 = {62, 21, 123, 9, 49, 100, 155, 5, 10, 32, 58, 86, 106, 137, 178, 1, 6, 47, 54, 60, 72, 96, 105, 121, 135, 152, 163, 188, 50, 68, 83, 87, 109, 122, 158, 173, 186, 194};
        Integer[] inorderCompArr65 = {1, 5, 6, 9, 10, 21, 32, 47, 49, 50, 54, 58, 60, 62, 68, 72, 83, 86, 87, 96, 100, 105, 106, 109, 121, 122, 123, 135, 137, 152, 155, 158, 163, 173, 178, 186, 188, 194};
        assertEquals(38, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr65), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr65), avlTree.inorder());

        assertEquals((Integer) 194, avlTree.remove(194));
        Integer[] levelCompArr66 = {62, 21, 123, 9, 49, 100, 155, 5, 10, 32, 58, 86, 106, 137, 178, 1, 6, 47, 54, 60, 72, 96, 105, 121, 135, 152, 163, 188, 50, 68, 83, 87, 109, 122, 158, 173, 186};
        Integer[] inorderCompArr66 = {1, 5, 6, 9, 10, 21, 32, 47, 49, 50, 54, 58, 60, 62, 68, 72, 83, 86, 87, 96, 100, 105, 106, 109, 121, 122, 123, 135, 137, 152, 155, 158, 163, 173, 178, 186, 188};
        assertEquals(37, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr66), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr66), avlTree.inorder());

        avlTree.add(12);
        Integer[] levelCompArr67 = {62, 21, 123, 9, 49, 100, 155, 5, 10, 32, 58, 86, 106, 137, 178, 1, 6, 12, 47, 54, 60, 72, 96, 105, 121, 135, 152, 163, 188, 50, 68, 83, 87, 109, 122, 158, 173, 186};
        Integer[] inorderCompArr67 = {1, 5, 6, 9, 10, 12, 21, 32, 47, 49, 50, 54, 58, 60, 62, 68, 72, 83, 86, 87, 96, 100, 105, 106, 109, 121, 122, 123, 135, 137, 152, 155, 158, 163, 173, 178, 186, 188};
        assertEquals(38, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr67), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr67), avlTree.inorder());

        avlTree.add(85);
        Integer[] levelCompArr68 = {62, 21, 123, 9, 49, 100, 155, 5, 10, 32, 58, 86, 106, 137, 178, 1, 6, 12, 47, 54, 60, 72, 96, 105, 121, 135, 152, 163, 188, 50, 68, 83, 87, 109, 122, 158, 173, 186, 85};
        Integer[] inorderCompArr68 = {1, 5, 6, 9, 10, 12, 21, 32, 47, 49, 50, 54, 58, 60, 62, 68, 72, 83, 85, 86, 87, 96, 100, 105, 106, 109, 121, 122, 123, 135, 137, 152, 155, 158, 163, 173, 178, 186, 188};
        assertEquals(39, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr68), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr68), avlTree.inorder());

        avlTree.add(78);
        Integer[] levelCompArr69 = {62, 21, 123, 9, 49, 100, 155, 5, 10, 32, 58, 86, 106, 137, 178, 1, 6, 12, 47, 54, 60, 72, 96, 105, 121, 135, 152, 163, 188, 50, 68, 83, 87, 109, 122, 158, 173, 186, 78, 85};
        Integer[] inorderCompArr69 = {1, 5, 6, 9, 10, 12, 21, 32, 47, 49, 50, 54, 58, 60, 62, 68, 72, 78, 83, 85, 86, 87, 96, 100, 105, 106, 109, 121, 122, 123, 135, 137, 152, 155, 158, 163, 173, 178, 186, 188};
        assertEquals(40, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr69), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr69), avlTree.inorder());

        avlTree.add(28);
        Integer[] levelCompArr70 = {62, 21, 123, 9, 49, 100, 155, 5, 10, 32, 58, 86, 106, 137, 178, 1, 6, 12, 28, 47, 54, 60, 72, 96, 105, 121, 135, 152, 163, 188, 50, 68, 83, 87, 109, 122, 158, 173, 186, 78, 85};
        Integer[] inorderCompArr70 = {1, 5, 6, 9, 10, 12, 21, 28, 32, 47, 49, 50, 54, 58, 60, 62, 68, 72, 78, 83, 85, 86, 87, 96, 100, 105, 106, 109, 121, 122, 123, 135, 137, 152, 155, 158, 163, 173, 178, 186, 188};
        assertEquals(41, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr70), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr70), avlTree.inorder());

        assertEquals((Integer) 68, avlTree.remove(68));
        Integer[] levelCompArr71 = {62, 21, 123, 9, 49, 100, 155, 5, 10, 32, 58, 86, 106, 137, 178, 1, 6, 12, 28, 47, 54, 60, 83, 96, 105, 121, 135, 152, 163, 188, 50, 72, 85, 87, 109, 122, 158, 173, 186, 78};
        Integer[] inorderCompArr71 = {1, 5, 6, 9, 10, 12, 21, 28, 32, 47, 49, 50, 54, 58, 60, 62, 72, 78, 83, 85, 86, 87, 96, 100, 105, 106, 109, 121, 122, 123, 135, 137, 152, 155, 158, 163, 173, 178, 186, 188};
        assertEquals(40, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr71), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr71), avlTree.inorder());

        avlTree.add(69);
        Integer[] levelCompArr72 = {62, 21, 123, 9, 49, 100, 155, 5, 10, 32, 58, 86, 106, 137, 178, 1, 6, 12, 28, 47, 54, 60, 83, 96, 105, 121, 135, 152, 163, 188, 50, 72, 85, 87, 109, 122, 158, 173, 186, 69, 78};
        Integer[] inorderCompArr72 = {1, 5, 6, 9, 10, 12, 21, 28, 32, 47, 49, 50, 54, 58, 60, 62, 69, 72, 78, 83, 85, 86, 87, 96, 100, 105, 106, 109, 121, 122, 123, 135, 137, 152, 155, 158, 163, 173, 178, 186, 188};
        assertEquals(41, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr72), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr72), avlTree.inorder());

        avlTree.add(23);
        Integer[] levelCompArr73 = {62, 21, 123, 9, 49, 100, 155, 5, 10, 32, 58, 86, 106, 137, 178, 1, 6, 12, 28, 47, 54, 60, 83, 96, 105, 121, 135, 152, 163, 188, 23, 50, 72, 85, 87, 109, 122, 158, 173, 186, 69, 78};
        Integer[] inorderCompArr73 = {1, 5, 6, 9, 10, 12, 21, 23, 28, 32, 47, 49, 50, 54, 58, 60, 62, 69, 72, 78, 83, 85, 86, 87, 96, 100, 105, 106, 109, 121, 122, 123, 135, 137, 152, 155, 158, 163, 173, 178, 186, 188};
        assertEquals(42, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr73), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr73), avlTree.inorder());

        avlTree.add(45);
        Integer[] levelCompArr74 = {62, 21, 123, 9, 49, 100, 155, 5, 10, 32, 58, 86, 106, 137, 178, 1, 6, 12, 28, 47, 54, 60, 83, 96, 105, 121, 135, 152, 163, 188, 23, 45, 50, 72, 85, 87, 109, 122, 158, 173, 186, 69, 78};
        Integer[] inorderCompArr74 = {1, 5, 6, 9, 10, 12, 21, 23, 28, 32, 45, 47, 49, 50, 54, 58, 60, 62, 69, 72, 78, 83, 85, 86, 87, 96, 100, 105, 106, 109, 121, 122, 123, 135, 137, 152, 155, 158, 163, 173, 178, 186, 188};
        assertEquals(43, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr74), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr74), avlTree.inorder());

        assertEquals((Integer) 123, avlTree.remove(123));
        Integer[] levelCompArr75 = {62, 21, 122, 9, 49, 100, 155, 5, 10, 32, 58, 86, 106, 137, 178, 1, 6, 12, 28, 47, 54, 60, 83, 96, 105, 121, 135, 152, 163, 188, 23, 45, 50, 72, 85, 87, 109, 158, 173, 186, 69, 78};
        Integer[] inorderCompArr75 = {1, 5, 6, 9, 10, 12, 21, 23, 28, 32, 45, 47, 49, 50, 54, 58, 60, 62, 69, 72, 78, 83, 85, 86, 87, 96, 100, 105, 106, 109, 121, 122, 135, 137, 152, 155, 158, 163, 173, 178, 186, 188};
        assertEquals(42, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr75), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr75), avlTree.inorder());

        assertEquals((Integer) 121, avlTree.remove(121));
        Integer[] levelCompArr76 = {62, 21, 122, 9, 49, 86, 155, 5, 10, 32, 58, 83, 100, 137, 178, 1, 6, 12, 28, 47, 54, 60, 72, 85, 96, 106, 135, 152, 163, 188, 23, 45, 50, 69, 78, 87, 105, 109, 158, 173, 186};
        Integer[] inorderCompArr76 = {1, 5, 6, 9, 10, 12, 21, 23, 28, 32, 45, 47, 49, 50, 54, 58, 60, 62, 69, 72, 78, 83, 85, 86, 87, 96, 100, 105, 106, 109, 122, 135, 137, 152, 155, 158, 163, 173, 178, 186, 188};
        assertEquals(41, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr76), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr76), avlTree.inorder());

        assertEquals((Integer) 54, avlTree.remove(54));
        Integer[] levelCompArr77 = {62, 21, 122, 9, 49, 86, 155, 5, 10, 32, 58, 83, 100, 137, 178, 1, 6, 12, 28, 47, 50, 60, 72, 85, 96, 106, 135, 152, 163, 188, 23, 45, 69, 78, 87, 105, 109, 158, 173, 186};
        Integer[] inorderCompArr77 = {1, 5, 6, 9, 10, 12, 21, 23, 28, 32, 45, 47, 49, 50, 58, 60, 62, 69, 72, 78, 83, 85, 86, 87, 96, 100, 105, 106, 109, 122, 135, 137, 152, 155, 158, 163, 173, 178, 186, 188};
        assertEquals(40, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr77), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr77), avlTree.inorder());

        assertEquals((Integer) 178, avlTree.remove(178));
        Integer[] levelCompArr78 = {62, 21, 122, 9, 49, 86, 155, 5, 10, 32, 58, 83, 100, 137, 173, 1, 6, 12, 28, 47, 50, 60, 72, 85, 96, 106, 135, 152, 163, 188, 23, 45, 69, 78, 87, 105, 109, 158, 186};
        Integer[] inorderCompArr78 = {1, 5, 6, 9, 10, 12, 21, 23, 28, 32, 45, 47, 49, 50, 58, 60, 62, 69, 72, 78, 83, 85, 86, 87, 96, 100, 105, 106, 109, 122, 135, 137, 152, 155, 158, 163, 173, 186, 188};
        assertEquals(39, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr78), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr78), avlTree.inorder());

        assertEquals((Integer) 109, avlTree.remove(109));
        Integer[] levelCompArr79 = {62, 21, 122, 9, 49, 86, 155, 5, 10, 32, 58, 83, 100, 137, 173, 1, 6, 12, 28, 47, 50, 60, 72, 85, 96, 106, 135, 152, 163, 188, 23, 45, 69, 78, 87, 105, 158, 186};
        Integer[] inorderCompArr79 = {1, 5, 6, 9, 10, 12, 21, 23, 28, 32, 45, 47, 49, 50, 58, 60, 62, 69, 72, 78, 83, 85, 86, 87, 96, 100, 105, 106, 122, 135, 137, 152, 155, 158, 163, 173, 186, 188};
        assertEquals(38, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr79), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr79), avlTree.inorder());

        assertEquals((Integer) 186, avlTree.remove(186));
        Integer[] levelCompArr80 = {62, 21, 122, 9, 49, 86, 155, 5, 10, 32, 58, 83, 100, 137, 173, 1, 6, 12, 28, 47, 50, 60, 72, 85, 96, 106, 135, 152, 163, 188, 23, 45, 69, 78, 87, 105, 158};
        Integer[] inorderCompArr80 = {1, 5, 6, 9, 10, 12, 21, 23, 28, 32, 45, 47, 49, 50, 58, 60, 62, 69, 72, 78, 83, 85, 86, 87, 96, 100, 105, 106, 122, 135, 137, 152, 155, 158, 163, 173, 188};
        assertEquals(37, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr80), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr80), avlTree.inorder());

        assertEquals((Integer) 47, avlTree.remove(47));
        Integer[] levelCompArr81 = {62, 21, 122, 9, 49, 86, 155, 5, 10, 32, 58, 83, 100, 137, 173, 1, 6, 12, 28, 45, 50, 60, 72, 85, 96, 106, 135, 152, 163, 188, 23, 69, 78, 87, 105, 158};
        Integer[] inorderCompArr81 = {1, 5, 6, 9, 10, 12, 21, 23, 28, 32, 45, 49, 50, 58, 60, 62, 69, 72, 78, 83, 85, 86, 87, 96, 100, 105, 106, 122, 135, 137, 152, 155, 158, 163, 173, 188};
        assertEquals(36, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr81), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr81), avlTree.inorder());

        assertEquals((Integer) 60, avlTree.remove(60));
        Integer[] levelCompArr82 = {62, 21, 122, 9, 49, 86, 155, 5, 10, 32, 58, 83, 100, 137, 173, 1, 6, 12, 28, 45, 50, 72, 85, 96, 106, 135, 152, 163, 188, 23, 69, 78, 87, 105, 158};
        Integer[] inorderCompArr82 = {1, 5, 6, 9, 10, 12, 21, 23, 28, 32, 45, 49, 50, 58, 62, 69, 72, 78, 83, 85, 86, 87, 96, 100, 105, 106, 122, 135, 137, 152, 155, 158, 163, 173, 188};
        assertEquals(35, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr82), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr82), avlTree.inorder());

        assertEquals((Integer) 86, avlTree.remove(86));
        Integer[] levelCompArr83 = {62, 21, 122, 9, 49, 85, 155, 5, 10, 32, 58, 72, 100, 137, 173, 1, 6, 12, 28, 45, 50, 69, 83, 96, 106, 135, 152, 163, 188, 23, 78, 87, 105, 158};
        Integer[] inorderCompArr83 = {1, 5, 6, 9, 10, 12, 21, 23, 28, 32, 45, 49, 50, 58, 62, 69, 72, 78, 83, 85, 87, 96, 100, 105, 106, 122, 135, 137, 152, 155, 158, 163, 173, 188};
        assertEquals(34, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr83), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr83), avlTree.inorder());

        assertEquals((Integer) 85, avlTree.remove(85));
        Integer[] levelCompArr84 = {62, 21, 122, 9, 49, 83, 155, 5, 10, 32, 58, 72, 100, 137, 173, 1, 6, 12, 28, 45, 50, 69, 78, 96, 106, 135, 152, 163, 188, 23, 87, 105, 158};
        Integer[] inorderCompArr84 = {1, 5, 6, 9, 10, 12, 21, 23, 28, 32, 45, 49, 50, 58, 62, 69, 72, 78, 83, 87, 96, 100, 105, 106, 122, 135, 137, 152, 155, 158, 163, 173, 188};
        assertEquals(33, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr84), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr84), avlTree.inorder());

        assertEquals((Integer) 163, avlTree.remove(163));
        Integer[] levelCompArr85 = {62, 21, 122, 9, 49, 83, 155, 5, 10, 32, 58, 72, 100, 137, 173, 1, 6, 12, 28, 45, 50, 69, 78, 96, 106, 135, 152, 158, 188, 23, 87, 105};
        Integer[] inorderCompArr85 = {1, 5, 6, 9, 10, 12, 21, 23, 28, 32, 45, 49, 50, 58, 62, 69, 72, 78, 83, 87, 96, 100, 105, 106, 122, 135, 137, 152, 155, 158, 173, 188};
        assertEquals(32, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr85), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr85), avlTree.inorder());

        assertEquals((Integer) 10, avlTree.remove(10));
        Integer[] levelCompArr86 = {62, 21, 122, 9, 49, 83, 155, 5, 12, 32, 58, 72, 100, 137, 173, 1, 6, 28, 45, 50, 69, 78, 96, 106, 135, 152, 158, 188, 23, 87, 105};
        Integer[] inorderCompArr86 = {1, 5, 6, 9, 12, 21, 23, 28, 32, 45, 49, 50, 58, 62, 69, 72, 78, 83, 87, 96, 100, 105, 106, 122, 135, 137, 152, 155, 158, 173, 188};
        assertEquals(31, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr86), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr86), avlTree.inorder());

        assertEquals((Integer) 78, avlTree.remove(78));
        Integer[] levelCompArr87 = {62, 21, 122, 9, 49, 83, 155, 5, 12, 32, 58, 72, 100, 137, 173, 1, 6, 28, 45, 50, 69, 96, 106, 135, 152, 158, 188, 23, 87, 105};
        Integer[] inorderCompArr87 = {1, 5, 6, 9, 12, 21, 23, 28, 32, 45, 49, 50, 58, 62, 69, 72, 83, 87, 96, 100, 105, 106, 122, 135, 137, 152, 155, 158, 173, 188};
        assertEquals(30, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr87), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr87), avlTree.inorder());

        assertEquals((Integer) 122, avlTree.remove(122));
        Integer[] levelCompArr88 = {62, 21, 106, 9, 49, 83, 155, 5, 12, 32, 58, 72, 100, 137, 173, 1, 6, 28, 45, 50, 69, 96, 105, 135, 152, 158, 188, 23, 87};
        Integer[] inorderCompArr88 = {1, 5, 6, 9, 12, 21, 23, 28, 32, 45, 49, 50, 58, 62, 69, 72, 83, 87, 96, 100, 105, 106, 135, 137, 152, 155, 158, 173, 188};
        assertEquals(29, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr88), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr88), avlTree.inorder());

        assertEquals((Integer) 83, avlTree.remove(83));
        Integer[] levelCompArr89 = {62, 21, 106, 9, 49, 96, 155, 5, 12, 32, 58, 72, 100, 137, 173, 1, 6, 28, 45, 50, 69, 87, 105, 135, 152, 158, 188, 23};
        Integer[] inorderCompArr89 = {1, 5, 6, 9, 12, 21, 23, 28, 32, 45, 49, 50, 58, 62, 69, 72, 87, 96, 100, 105, 106, 135, 137, 152, 155, 158, 173, 188};
        assertEquals(28, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr89), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr89), avlTree.inorder());

        assertEquals((Integer) 137, avlTree.remove(137));
        Integer[] levelCompArr90 = {62, 21, 106, 9, 49, 96, 155, 5, 12, 32, 58, 72, 100, 135, 173, 1, 6, 28, 45, 50, 69, 87, 105, 152, 158, 188, 23};
        Integer[] inorderCompArr90 = {1, 5, 6, 9, 12, 21, 23, 28, 32, 45, 49, 50, 58, 62, 69, 72, 87, 96, 100, 105, 106, 135, 152, 155, 158, 173, 188};
        assertEquals(27, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr90), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr90), avlTree.inorder());

        assertEquals((Integer) 158, avlTree.remove(158));
        Integer[] levelCompArr91 = {62, 21, 106, 9, 49, 96, 155, 5, 12, 32, 58, 72, 100, 135, 173, 1, 6, 28, 45, 50, 69, 87, 105, 152, 188, 23};
        Integer[] inorderCompArr91 = {1, 5, 6, 9, 12, 21, 23, 28, 32, 45, 49, 50, 58, 62, 69, 72, 87, 96, 100, 105, 106, 135, 152, 155, 173, 188};
        assertEquals(26, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr91), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr91), avlTree.inorder());

        assertEquals((Integer) 12, avlTree.remove(12));
        Integer[] levelCompArr92 = {62, 21, 106, 5, 49, 96, 155, 1, 9, 32, 58, 72, 100, 135, 173, 6, 28, 45, 50, 69, 87, 105, 152, 188, 23};
        Integer[] inorderCompArr92 = {1, 5, 6, 9, 21, 23, 28, 32, 45, 49, 50, 58, 62, 69, 72, 87, 96, 100, 105, 106, 135, 152, 155, 173, 188};
        assertEquals(25, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr92), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr92), avlTree.inorder());

        assertEquals((Integer) 106, avlTree.remove(106));
        Integer[] levelCompArr93 = {62, 21, 105, 5, 49, 96, 155, 1, 9, 32, 58, 72, 100, 135, 173, 6, 28, 45, 50, 69, 87, 152, 188, 23};
        Integer[] inorderCompArr93 = {1, 5, 6, 9, 21, 23, 28, 32, 45, 49, 50, 58, 62, 69, 72, 87, 96, 100, 105, 135, 152, 155, 173, 188};
        assertEquals(24, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr93), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr93), avlTree.inorder());

        assertEquals((Integer) 21, avlTree.remove(21));
        Integer[] levelCompArr94 = {62, 32, 105, 9, 49, 96, 155, 5, 28, 45, 58, 72, 100, 135, 173, 1, 6, 23, 50, 69, 87, 152, 188};
        Integer[] inorderCompArr94 = {1, 5, 6, 9, 23, 28, 32, 45, 49, 50, 58, 62, 69, 72, 87, 96, 100, 105, 135, 152, 155, 173, 188};
        assertEquals(23, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr94), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr94), avlTree.inorder());

        assertEquals((Integer) 23, avlTree.remove(23));
        Integer[] levelCompArr95 = {62, 32, 105, 9, 49, 96, 155, 5, 28, 45, 58, 72, 100, 135, 173, 1, 6, 50, 69, 87, 152, 188};
        Integer[] inorderCompArr95 = {1, 5, 6, 9, 28, 32, 45, 49, 50, 58, 62, 69, 72, 87, 96, 100, 105, 135, 152, 155, 173, 188};
        assertEquals(22, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr95), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr95), avlTree.inorder());

        assertEquals((Integer) 32, avlTree.remove(32));
        Integer[] levelCompArr96 = {62, 28, 105, 5, 49, 96, 155, 1, 9, 45, 58, 72, 100, 135, 173, 6, 50, 69, 87, 152, 188};
        Integer[] inorderCompArr96 = {1, 5, 6, 9, 28, 45, 49, 50, 58, 62, 69, 72, 87, 96, 100, 105, 135, 152, 155, 173, 188};
        assertEquals(21, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr96), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr96), avlTree.inorder());

        assertEquals((Integer) 6, avlTree.remove(6));
        Integer[] levelCompArr97 = {62, 28, 105, 5, 49, 96, 155, 1, 9, 45, 58, 72, 100, 135, 173, 50, 69, 87, 152, 188};
        Integer[] inorderCompArr97 = {1, 5, 9, 28, 45, 49, 50, 58, 62, 69, 72, 87, 96, 100, 105, 135, 152, 155, 173, 188};
        assertEquals(20, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr97), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr97), avlTree.inorder());

        assertEquals((Integer) 9, avlTree.remove(9));
        Integer[] levelCompArr98 = {62, 28, 105, 5, 49, 96, 155, 1, 45, 58, 72, 100, 135, 173, 50, 69, 87, 152, 188};
        Integer[] inorderCompArr98 = {1, 5, 28, 45, 49, 50, 58, 62, 69, 72, 87, 96, 100, 105, 135, 152, 155, 173, 188};
        assertEquals(19, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr98), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr98), avlTree.inorder());

        assertEquals((Integer) 69, avlTree.remove(69));
        Integer[] levelCompArr99 = {62, 28, 105, 5, 49, 96, 155, 1, 45, 58, 72, 100, 135, 173, 50, 87, 152, 188};
        Integer[] inorderCompArr99 = {1, 5, 28, 45, 49, 50, 58, 62, 72, 87, 96, 100, 105, 135, 152, 155, 173, 188};
        assertEquals(18, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr99), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr99), avlTree.inorder());

        assertEquals((Integer) 49, avlTree.remove(49));
        Integer[] levelCompArr100 = {62, 28, 105, 5, 50, 96, 155, 1, 45, 58, 72, 100, 135, 173, 87, 152, 188};
        Integer[] inorderCompArr100 = {1, 5, 28, 45, 50, 58, 62, 72, 87, 96, 100, 105, 135, 152, 155, 173, 188};
        assertEquals(17, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr100), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr100), avlTree.inorder());

        assertEquals((Integer) 1, avlTree.remove(1));
        Integer[] levelCompArr101 = {62, 28, 105, 5, 50, 96, 155, 45, 58, 72, 100, 135, 173, 87, 152, 188};
        Integer[] inorderCompArr101 = {5, 28, 45, 50, 58, 62, 72, 87, 96, 100, 105, 135, 152, 155, 173, 188};
        assertEquals(16, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr101), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr101), avlTree.inorder());

        assertEquals((Integer) 100, avlTree.remove(100));
        Integer[] levelCompArr102 = {62, 28, 105, 5, 50, 87, 155, 45, 58, 72, 96, 135, 173, 152, 188};
        Integer[] inorderCompArr102 = {5, 28, 45, 50, 58, 62, 72, 87, 96, 105, 135, 152, 155, 173, 188};
        assertEquals(15, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr102), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr102), avlTree.inorder());

        assertEquals((Integer) 155, avlTree.remove(155));
        Integer[] levelCompArr103 = {62, 28, 105, 5, 50, 87, 152, 45, 58, 72, 96, 135, 173, 188};
        Integer[] inorderCompArr103 = {5, 28, 45, 50, 58, 62, 72, 87, 96, 105, 135, 152, 173, 188};
        assertEquals(14, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr103), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr103), avlTree.inorder());

        assertEquals((Integer) 45, avlTree.remove(45));
        Integer[] levelCompArr104 = {62, 28, 105, 5, 50, 87, 152, 58, 72, 96, 135, 173, 188};
        Integer[] inorderCompArr104 = {5, 28, 50, 58, 62, 72, 87, 96, 105, 135, 152, 173, 188};
        assertEquals(13, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr104), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr104), avlTree.inorder());

        assertEquals((Integer) 87, avlTree.remove(87));
        Integer[] levelCompArr105 = {62, 28, 105, 5, 50, 72, 152, 58, 96, 135, 173, 188};
        Integer[] inorderCompArr105 = {5, 28, 50, 58, 62, 72, 96, 105, 135, 152, 173, 188};
        assertEquals(12, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr105), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr105), avlTree.inorder());

        assertEquals((Integer) 188, avlTree.remove(188));
        Integer[] levelCompArr106 = {62, 28, 105, 5, 50, 72, 152, 58, 96, 135, 173};
        Integer[] inorderCompArr106 = {5, 28, 50, 58, 62, 72, 96, 105, 135, 152, 173};
        assertEquals(11, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr106), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr106), avlTree.inorder());

        assertEquals((Integer) 152, avlTree.remove(152));
        Integer[] levelCompArr107 = {62, 28, 105, 5, 50, 72, 135, 58, 96, 173};
        Integer[] inorderCompArr107 = {5, 28, 50, 58, 62, 72, 96, 105, 135, 173};
        assertEquals(10, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr107), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr107), avlTree.inorder());

        assertEquals((Integer) 96, avlTree.remove(96));
        Integer[] levelCompArr108 = {62, 28, 105, 5, 50, 72, 135, 58, 173};
        Integer[] inorderCompArr108 = {5, 28, 50, 58, 62, 72, 105, 135, 173};
        assertEquals(9, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr108), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr108), avlTree.inorder());

        assertEquals((Integer) 50, avlTree.remove(50));
        Integer[] levelCompArr109 = {62, 28, 105, 5, 58, 72, 135, 173};
        Integer[] inorderCompArr109 = {5, 28, 58, 62, 72, 105, 135, 173};
        assertEquals(8, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr109), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr109), avlTree.inorder());

        assertEquals((Integer) 173, avlTree.remove(173));
        Integer[] levelCompArr110 = {62, 28, 105, 5, 58, 72, 135};
        Integer[] inorderCompArr110 = {5, 28, 58, 62, 72, 105, 135};
        assertEquals(7, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr110), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr110), avlTree.inorder());

        assertEquals((Integer) 62, avlTree.remove(62));
        Integer[] levelCompArr111 = {58, 28, 105, 5, 72, 135};
        Integer[] inorderCompArr111 = {5, 28, 58, 72, 105, 135};
        assertEquals(6, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr111), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr111), avlTree.inorder());

        assertEquals((Integer) 28, avlTree.remove(28));
        Integer[] levelCompArr112 = {58, 5, 105, 72, 135};
        Integer[] inorderCompArr112 = {5, 58, 72, 105, 135};
        assertEquals(5, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr112), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr112), avlTree.inorder());

        assertEquals((Integer) 105, avlTree.remove(105));
        Integer[] levelCompArr113 = {58, 5, 72, 135};
        Integer[] inorderCompArr113 = {5, 58, 72, 135};
        assertEquals(4, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr113), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr113), avlTree.inorder());

        assertEquals((Integer) 72, avlTree.remove(72));
        Integer[] levelCompArr114 = {58, 5, 135};
        Integer[] inorderCompArr114 = {5, 58, 135};
        assertEquals(3, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr114), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr114), avlTree.inorder());

        assertEquals((Integer) 58, avlTree.remove(58));
        Integer[] levelCompArr115 = {5, 135};
        Integer[] inorderCompArr115 = {5, 135};
        assertEquals(2, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr115), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr115), avlTree.inorder());

        assertEquals((Integer) 135, avlTree.remove(135));
        Integer[] levelCompArr116 = {5};
        Integer[] inorderCompArr116 = {5};
        assertEquals(1, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr116), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr116), avlTree.inorder());

        assertEquals((Integer) 5, avlTree.remove(5));
        Integer[] levelCompArr117 = {};
        Integer[] inorderCompArr117 = {};
        assertEquals(0, avlTree.size());
        assertEquals(Arrays.asList(levelCompArr117), avlTree.levelorder());
        assertEquals(Arrays.asList(inorderCompArr117), avlTree.inorder());

    }
}
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;

public class TestWriter {
    static int toAdd, toRemove;
    static Random rand = new Random();
    static ArrayList<Integer> already = new ArrayList<>();
    static AVL<Integer> avl = new AVL<>();
    static int numArrs;

    public static void main(String[] args) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("TGreggStressTestRound2.java"));
            bw.write("import org.junit.Before;\n"
                    + "import org.junit.Test;\n"
                    + "\n"
                    + "import java.util.Arrays;\n"
                    + "import java.util.LinkedList;\n"
                    + "import java.util.List;\n"
                    + "\n"
                    + "import static org.junit.Assert.*;\n"
                    + "\n"
                    + "/**\n"
                    + " * AVL tests.\n"
                    + " * @author Timothy Gregg\n"
                    + " * @version 1.0\n"
                    + " */\n"
                    + "public class TGreggStressTestRound2 {\n"
                    + "\n"
                    + "    private AVLInterface<Integer> avlTree;\n"
                    + "\n"
                    + "    @Before\n"
                    + "    public void setup() {\n"
                    + "        avlTree = new AVL<>();\n"
                    + "    }\n"
                    + "\n"
                    + "    @Test\n"
                    + "    public void StressTestIsBestTest() {\n");
            bw.write("        List<Integer> comparisonList;\n");
            for (int i = 0; i < 75; i++) {
                if (avl.size() == 0) {
                    bw.write("        assertEquals(0, avlTree.size());\n");
                    addNum(bw);
                } else {
                    if (rand.nextInt(10) > 7) {
                        remNum(bw);
                    } else {
                        addNum(bw);
                    }
                }
            }
            while (already.size() > 0) {
                remNum(bw);
            }
            bw.write("    }\n}");
            bw.close();
        } catch (Exception e) {}
    }

    static void addNum(BufferedWriter bw) {
        try {
            toAdd = rand.nextInt(2147483647);
            while (already.contains(toAdd)) {
                toAdd = rand.nextInt(2147483647);
            }
            already.add(toAdd);
            avl.add(toAdd);
            bw.write("        avlTree.add(" + toAdd + ");\n");
            String levelOrder = avl.levelorder().toString();
            bw.write("        Integer[] comparisonArr" + numArrs + " = {" + levelOrder.substring(1, levelOrder.length() - 1) + "};\n");
            bw.write("        assertEquals(" + avl.size() + ", avlTree.size());\n");
            bw.write("        comparisonList = new LinkedList<>(Arrays.asList(comparisonArr" + numArrs++ + "));\n");
            bw.write("        assertEquals(comparisonList, avlTree.levelorder());\n");
        } catch (Exception e) {}
    }

    static void remNum(BufferedWriter bw) {
        try {
            toRemove = already.remove(rand.nextInt(already.size()));
            avl.remove(toRemove);
            bw.write("        assertEquals((Integer) " + toRemove + ", avlTree.remove(" + toRemove + "));\n");
            String levelOrder = avl.levelorder().toString();
            bw.write("        Integer[] comparisonArr" + numArrs + " = {" + levelOrder.substring(1, levelOrder.length() - 1) + "};\n");
            bw.write("        assertEquals(" + avl.size() + ", avlTree.size());\n");
            bw.write("        comparisonList = new LinkedList<>(Arrays.asList(comparisonArr" + numArrs++ + "));\n");
            bw.write("        assertEquals(comparisonList, avlTree.levelorder());\n");
        } catch (Exception e) {}
    }
}
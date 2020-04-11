import org.junit.Assert;
import org.junit.Test;

public class dataStructuresTest {
    public static int testVertical = 10;
    public static int testHorizontal = 10;
    dataStructures data = new dataStructures();

    //0 and 1 represent dead and alive, respectively.
    int[][] testGrid = {
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 1, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 1, 1, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
    };

    //expected output after applying the rules of life to the above grid
    // (0 for + and 1 for #)
    String expectedString =
            "++++++++++" +
            "++++++++++" +
            "++++++++++" +
            "+++++++##+" +
            "+++++++##+" +
            "++++++++++" +
            "++++++++++" +
            "+###++++++" +
            "+###++++++" +
            "++++++++++";

    @Test
    public void rulesTest()
    {
        Assert.assertEquals(data.nextGen(testGrid, testVertical, testHorizontal), expectedString);
    }
}

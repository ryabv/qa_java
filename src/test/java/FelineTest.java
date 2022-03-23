import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

@RunWith(Parameterized.class)
public class FelineTest {

    private final int passedKittensCount;
    private final int expectedKittensCount;

    public FelineTest(int passedKittensCount, int expectedKittensCount) {
        this.passedKittensCount = passedKittensCount;
        this.expectedKittensCount = expectedKittensCount;
    }

    @Parameterized.Parameters
    public static Object[][] getKittensCount() {
        return new Object[][] {
                { 1, 1 },
                { 2, 2 },
                { 3, 3 }
        };
    }

    @Test
    public void shouldGetFamily() {
        Feline feline = new Feline();
        String family = feline.getFamily();
        Assert.assertEquals("Кошачьи", family);
    }

    @Test
    public void shouldEatMeat() throws Exception {
        Feline feline = new Feline();
        List<String> food = feline.eatMeat();
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }

    @Test
    public void shouldReturnKittens() {
        Feline feline = new Feline();
        int kittensCount = feline.getKittens(passedKittensCount);
        Assert.assertEquals(expectedKittensCount, kittensCount);
    }

    @Test
    public void shouldReturnDefaultKittens() {
        Feline feline = new Feline();
        int kittensCount = feline.getKittens();
        Assert.assertEquals(1, kittensCount);
    }
}

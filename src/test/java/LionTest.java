import com.example.Cat;
import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

@RunWith(Parameterized.class)
public class LionTest {

    private final String sex;
    private final boolean shouldHasMane;

    public LionTest(String sex, boolean shouldHasMane) {
        this.sex = sex;
        this.shouldHasMane = shouldHasMane;
    }

    @Parameterized.Parameters
    public static Object[][] getLionData() {
        return new Object[][] {
                { "Самец", true },
                { "Самка", false }
        };
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    private Feline feline;

    @Test
    public void shouldGetKittens() throws Exception {
        Mockito.when(feline.getKittens()).thenReturn(1);
        Lion lion = new Lion(feline, "Самец");
        int kittensCount = lion.getKittens();
        Assert.assertEquals(1, kittensCount);
    }

    @Test
    public void shouldManeRelateToSex() throws Exception {
        Lion lion = new Lion(feline, sex);
        boolean hasMane = lion.doesHaveMane();
        Assert.assertEquals(shouldHasMane, hasMane);
    }

    @Test
    public void shouldThrowUnknownSexError() {
        try {
            new Lion(feline, "Не определился");
        } catch (Exception exception) {
            Assert.assertEquals(
                    "Используйте допустимые значения пола животного - самей или самка",
                    exception.getMessage());
        }
    }

    @Test
    public void shouldGetFood() throws Exception {
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Мясо"));
        Lion lion = new Lion(feline, "Самка");
        List<String> food = lion.getFood();
        Assert.assertEquals(List.of("Мясо"), food);
    }
}

import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    private Feline predator;

    @Test
    public void shouldGetSound() {
        Cat cat = new Cat(predator);
        String sound = cat.getSound();
        Assert.assertEquals("Мяу", sound);
    }

    @Test
    public void shouldGetFood() throws Exception {
        Mockito.when(predator.eatMeat()).thenReturn(List.of("Мясо"));
        Cat cat = new Cat(predator);
        List<String> food = cat.getFood();
        Assert.assertEquals(List.of("Мясо"), food);
    }
}

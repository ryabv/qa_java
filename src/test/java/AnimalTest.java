import com.example.Animal;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class AnimalTest {

    @Test
    public void shouldGetGrassFood() throws Exception {
        Animal animal = new Animal();
        List<String> food = animal.getFood("Травоядное");
        Assert.assertEquals(List.of("Трава", "Различные растения"), food);
    }

    @Test
    public void shouldGetMeatFood() throws Exception {
        Animal animal = new Animal();
        List<String> food = animal.getFood("Хищник");
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }

    @Test
    public void shouldGetUnknownAnimalTypeError() {
        Animal animal = new Animal();

        try {
            animal.getFood("Гриб");
            Assert.fail("Должен вернуть ошибку");
        } catch (Exception exception) {
            Assert.assertEquals(
                    "Неизвестный вид животного, используйте значение Травоядное или Хищник",
                    exception.getMessage());
        }
    }

    @Test
    public void shouldGetFamily() {
        Animal animal = new Animal();
        String family = animal.getFamily();
        Assert.assertEquals(
                "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи",
                family);
    }
}

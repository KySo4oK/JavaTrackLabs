import javaTrack.model.Animal;
import javaTrack.model.DataSource;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class DataSourceTest {
    @Test
    public void WriteAndReadJson() throws IOException {
        DataSource dataSource = new DataSource();
        Animal[] animalsBeforeSaving = dataSource.getAnimalsFromFile();
        dataSource.saveAnimals(animalsBeforeSaving,"test.json");
        Animal[] animalsAfterSaving = dataSource.getAnimalsFromFile();
        for (int i = 0; i < animalsBeforeSaving.length; i++) {
            if (!animalsBeforeSaving[i].equals(animalsAfterSaving[i])) {
                Assert.fail();
            }
        }
    }
}

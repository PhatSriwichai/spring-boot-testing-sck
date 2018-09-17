package com.aiwine.train;

import com.aiwine.train.category.UnitTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.junit.Assert.*;


@Category(UnitTest.class)
public class DemoTest {

    @Test
    public void getById() {
        Repository repository = new StubRepository();
        // Constructor Injection
        Controller controller = new Controller();

        // Setter Injection
        controller.setRepository(repository);
        controller.getById(1);
    }

}

class StubRepository implements Repository {
    @Override
    public String getData(int id) {
        return "XXX";
    }
}
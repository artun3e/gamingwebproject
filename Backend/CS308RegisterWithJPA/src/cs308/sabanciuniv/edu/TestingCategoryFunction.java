package cs308.sabanciuniv.edu;

import java.util.ArrayList;
import java.util.List;

public class TestingCategoryFunction {
    public static void main(String[] args){
        try {
            List<String> categories = new ArrayList<>();
            categories.add("FPS");
            categories.add("Multiplayer");
            categories.add("World War II");
            List<Games> gameList = GamesManager.findByCategory(categories);
            for(Games game : gameList)
            {
                System.out.println(game);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

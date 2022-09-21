package levvel.io;

import levvel.io.model.Blog;
import levvel.io.model.Comment;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class BlogTests {
    @Test
    void testComments() throws FileNotFoundException, ParseException {
        JSONParser parser = new JSONParser(new FileReader("src/main/resources/addComment.json"));
        HashMap<String, Object> map = parser.parseObject();
        assert (map.get("author").equals("Bruce Wayne"));
        assert (map.get("text").equals("This is sample text for a comment!"));
    }
}

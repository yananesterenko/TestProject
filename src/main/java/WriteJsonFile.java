import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.project.models.Item;

import java.io.File;
import java.io.IOException;

public class WriteJsonFile {
    private static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) {
        writeJsonFile();

    }
    private static void writeJsonFile(){
        Item itemObject = new Item();
        itemObject.setPrice(123);
        itemObject.setName("name");
        itemObject.setImageURL("/http:image");
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            // read from object to json
            mapper.writeValue(new File("data/output.json"), itemObject);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

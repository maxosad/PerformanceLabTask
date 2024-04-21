package org.example.task3;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Task3 {
    public static final String ID = "id";
    public static final String VALUE = "value";
    public static final String VALUES = "values";
    public static final String TESTS = "tests";
    private Map<Integer, JsonNode> id2Value = new HashMap<>();

    public void processNode(JsonNode jsonNode) {
        if (jsonNode.isValueNode()) {

        } else if (jsonNode.isObject()) {
            int id = jsonNode.get(ID).intValue();
            if (id2Value.containsKey(id)) {
                jsonNode = ((ObjectNode) jsonNode).set(VALUE, id2Value.get(id));
            }
            if (jsonNode.has(VALUES)) {
                processNode(jsonNode.get(VALUES));
            }

        } else if (jsonNode.isArray()) {
            var it = jsonNode.elements();
            JsonNode element;
            while (it.hasNext()) {
                element = it.next();
                processNode(element);
            }
        }
    }


    public static void main(String[] args) {
        Task3 task3 = new Task3();

        Path valuePath = Paths.get(args[0]);
        Path testPath = Paths.get(args[1]);
        Path reportPath = Paths.get(args[2]);

        try (FileReader valuesReader = new FileReader(valuePath.toFile());
             FileReader testReader = new FileReader(testPath.toFile());
             FileWriter reportWriter = new FileWriter(reportPath.toFile());
        ) {
            final ObjectMapper valueMapper = new ObjectMapper();
            JsonNode valuesRoot = valueMapper.readTree(valuesReader);
            var valuesArrayIterator = valuesRoot.get(VALUES).elements();
            JsonNode arrayElement;
            while (valuesArrayIterator.hasNext()) {
                arrayElement = valuesArrayIterator.next();
                task3.id2Value.put(arrayElement.get(ID).intValue()
                        , arrayElement.get(VALUE));
            }

            final ObjectMapper testMapper = new ObjectMapper();
            JsonNode testRoot = testMapper.readTree(testReader);
            task3.processNode(testRoot.get(TESTS));

            final ObjectMapper reportMapper = new ObjectMapper();
            reportMapper.writeValue(reportWriter, testRoot);

        } catch (IOException e) {
            System.out.println("IOException" + e);
        }
    }
}

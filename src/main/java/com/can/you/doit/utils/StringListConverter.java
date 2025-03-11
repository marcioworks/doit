package com.can.you.doit.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;

import java.io.IOException;
import java.util.List;

public class StringListConverter implements AttributeConverter<List<String>, String> {

private static final ObjectMapper objectMapper = new ObjectMapper();

@Override
public String convertToDatabaseColumn(List<String> attribute) {
    try {
        // Convert the List<String> to JSON string
        return objectMapper.writeValueAsString(attribute);
    } catch (IOException e) {
        e.printStackTrace();
        return null;
    }
}

    @Override
    public List<String> convertToEntityAttribute(String dbData) {
        try {
            // Check if the input is not null and not empty
            if (dbData != null && !dbData.isEmpty()) {
                // Remove unnecessary extra brackets, if any
                dbData = dbData.replace("[[", "[").replace("]]", "]");
                // Convert the JSON string back to List<String>
                return objectMapper.readValue(dbData, new TypeReference<List<String>>() {});
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;  // Return null if something goes wrong
    }
}
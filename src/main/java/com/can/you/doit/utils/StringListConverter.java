package com.can.you.doit.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringListConverter implements AttributeConverter<List<String>, String> {

private static final ObjectMapper objectMapper = new ObjectMapper();

@Override
public String convertToDatabaseColumn(List<String> attribute) {
    try {
        // Convert the List<String> to JSON string
        return objectMapper.writeValueAsString(attribute);
    } catch (IOException e) {
       return "[]";
    }
}

    @Override
    public List<String> convertToEntityAttribute(String data) {
        if (data == null || data.isBlank()) {
            return new ArrayList<>();
        }

        try {
            data = data.trim();

            // Se for tipo "Antihistamines", sem colchetes e sem aspas
            if (!data.startsWith("[") && !data.contains(",")) {
                return List.of(data);
            }

            // Se for tipo "a,b,c"
            if (!data.startsWith("[") && data.contains(",")) {
                return Arrays.stream(data.split(","))
                        .map(String::trim)
                        .collect(Collectors.toList());
            }

            // JSON válido
            return objectMapper.readValue(data, new TypeReference<>() {});
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
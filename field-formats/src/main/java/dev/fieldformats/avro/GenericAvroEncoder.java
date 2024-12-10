package dev.fieldformats.avro;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.io.BinaryEncoder;
import org.json.JSONObject;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

public class GenericAvroEncoder {
    public static ByteBuffer encodeAvro(String schemaJson, String jsonData) throws Exception {
        Schema schema = new Schema.Parser().parse(schemaJson);
        GenericRecord record = new GenericData.Record(schema);
        JSONObject json = new JSONObject(jsonData);

        // Populate the record with JSON data
        for (Schema.Field field : schema.getFields()) {
            String fieldName = field.name();
            Object value = json.has(fieldName) ? json.get(fieldName) : null;
            
            // Handle null values or type conversion if needed
            if (value != null && field.schema().getType() == Schema.Type.UNION) {
                Schema actualType = field.schema().getTypes().get(1); // Assuming null is first, actual type second
                if (actualType.getType() == Schema.Type.LONG && value instanceof Integer) {
                    value = ((Integer) value).longValue();
                }
            }

            record.put(fieldName, value);
        }

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        BinaryEncoder encoder = EncoderFactory.get().binaryEncoder(out, null);
        DatumWriter<GenericRecord> writer = new GenericData().createDatumWriter(schema);
        writer.write(record, encoder);
        encoder.flush();
        out.close();

        return ByteBuffer.wrap(out.toByteArray());
    }

    public static void main(String[] args) {
        //

        String schemaJson = "{\"type\":\"record\",\"name\":\"MyRecord\",\"fields\":[{\"name\":\"field1\",\"type\":[\"null\",\"string\"]},{\"name\":\"field2\",\"type\":[\"null\",\"long\"]}]}";
        String jsonData = "{\"field1\":\"value1\",\"field2\":123}";
        ByteBuffer encode;
        try {
            encode = encodeAvro(schemaJson, jsonData);
            System.out.println("Encode: " + encode.toString());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}

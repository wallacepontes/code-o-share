package dev.fieldformats.avro;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.io.BinaryDecoder;
import java.nio.ByteBuffer;
import org.json.JSONObject;

public class GenericAvroDecoder {
    public static String decodeAvro(String schemaJson, ByteBuffer buffer) throws Exception {
        Schema schema = new Schema.Parser().parse(schemaJson);
        DatumReader<GenericRecord> reader = new GenericData().createDatumReader(schema);
        BinaryDecoder decoder = DecoderFactory.get().binaryDecoder(buffer.array(), null);
        GenericRecord record = reader.read(null, decoder);

        JSONObject json = new JSONObject();
        for (Schema.Field field : schema.getFields()) {
            String fieldName = field.name();
            json.put(fieldName, record.get(fieldName));
        }

        return json.toString();
    }

    public static void main(String[] args) {
        String schemaJson = "{\"type\":\"record\",\"name\":\"MyRecord\",\"fields\":[{\"name\":\"field1\",\"type\":[\"null\",\"string\"]},{\"name\":\"field2\",\"type\":[\"null\",\"long\"]}]}";
        String jsonData = "{\"field1\":\"value1\",\"field2\":123}";
        ByteBuffer encode;
        String result;
        try {
            encode = GenericAvroEncoder.encodeAvro(schemaJson, jsonData);

            result = decodeAvro(schemaJson, encode);
            
            System.out.println("Encode: " + encode.toString());
            System.out.println("Decode: " + result);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

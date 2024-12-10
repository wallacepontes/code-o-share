package dev.fieldformats.uuid;

import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.UUID;

public class DeterministicUUID {
    
    public static UUID generate(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(input.getBytes());

            ByteBuffer buffer = ByteBuffer.wrap(hash);
            long mostSigBits = buffer.getLong();
            long leastSigBits = buffer.getLong();

            return new UUID(mostSigBits, leastSigBits);
        } catch (Exception e) {
            throw new RuntimeException("Error generating deterministic UUID", e);
        }
    }
    public static void main(String[] args) {
        
        // Example usage
        String legacyId = "1234";
        UUID deterministicUUID = generate(legacyId);
        System.out.println("Generated UUID: " + deterministicUUID);
   }
}

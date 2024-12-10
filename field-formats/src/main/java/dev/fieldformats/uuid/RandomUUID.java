package dev.fieldformats.uuid;

import java.util.UUID;
public class RandomUUID {
    public static UUID generate() {
        return UUID.randomUUID();
    }
    public static void main(String[] args) {
        // Example usage
        UUID deterministicUUID = generate();
        System.out.println("Generated UUID: " + deterministicUUID);
   }
}

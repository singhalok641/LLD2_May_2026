package org.example.designpatterns.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * BulletTypeFactory — Flyweight Factory.
 *
 * Caches and reuses BulletType instances so that only ONE object
 * exists per bullet type (e.g. "AKM", "M416", "AWM").
 *
 * This is the core of the Flyweight pattern:
 *   - If a BulletType with the given name already exists → return it.
 *   - Otherwise → create it, cache it, and return it.
 *
 * Without this factory, every bullet would carry its own
 * copy of the image and shared attributes (~1 KB each).
 */
public class BulletTypeFactory {
    private static final Map<String, BulletType> CACHE = new HashMap<>();

    public static BulletType getBulletType(String name) {
        if (CACHE.containsKey(name)) {
            return CACHE.get(name); // reuse the exisiting
        }

        // First time - create the heavy object
        BulletType bulletType = createBulletType(name);
        CACHE.put(name, bulletType); // cache it for reuse
        return bulletType;
    }

    private static BulletType createBulletType(String name) {
        return switch (name) {
            case "AKM" -> new BulletType("GOLD", 8.0, 3.9, 48,
                    400, new byte[1024]);
            case "M416" -> new BulletType("SILVER", 8.0, 3.9, 48,
                    400, new byte[1024]);
            default -> new BulletType("GRAY", 7.0, 3.0, 30,
                    300, new byte[1024]);
        };
    }
}

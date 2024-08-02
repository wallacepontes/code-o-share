package dev.multithreading;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class J8ObjectsEligibleGC {

	public static void main(String[] args) {
		
		// 1. Nullifying References
		Object obj = new Object();
        // Use the object
        obj = null; // Now the object is eligible for GC
        
        // 2. Reassigning References
        Object obj1 = new Object();
        Object obj2 = new Object();
        // Use the objects
        obj1 = obj2; // Now the first object is eligible for GC
        
        // 3. Objects Going Out of Scope
        createObject();
        
        // 4. Dereferencing in Data Structures
        List<Object> list = new ArrayList<>();
        Object obj3 = new Object();
        list.add(obj3);
        // Use the object
        list.remove(obj3); // Now obj is eligible for GC if no other references exist
        
        // 5. Weak References
        Object obj5 = new Object();
        WeakReference<Object> weakRef = new WeakReference<>(obj5);
        obj5 = null; // Now the object is eligible for GC
        
        // 6. Using Phantom References
        Object obj6 = new Object();
        ReferenceQueue<Object> refQueue = new ReferenceQueue<>();
        PhantomReference<Object> phantomRef = new PhantomReference<>(obj6, refQueue);
        obj6 = null; // Now the object is eligible for GC
        
        // Calling System.gc() suggests to the JVM that it might be a good time 
        // to run the garbage collector, but it is not guaranteed to do so 
        // immediately or at all.
        System.gc(); // Suggest garbage collection
	}
	public static void createObject() {
        Object obj = new Object();
        // Use the object
    } // obj is now eligible for GC
}

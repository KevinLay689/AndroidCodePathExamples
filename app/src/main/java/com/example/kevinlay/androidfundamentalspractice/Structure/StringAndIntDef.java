package com.example.kevinlay.androidfundamentalspractice.Structure;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * String and Int Def
 *
 * Steps to create Int or String Def Class
 *      1. Annotate class with @Retention(RentionPolicy.SOURCE)
 *          1a. This describes when the annotation will be discarded
 *      2. Create the Enumerated valid values for the interface
 *          2a. Looks like @IntDef({xx, xx, xx})
 *      3. Create an interface for validating types
 *          3a. Looks like public @interface ItemTypeDef{}
 *      4. Create the constants
 *      5. Create constructor for class and annotate the parameter with the interface type
 *          5a. public Item(@ItemTypeDef int itemType) {this.itemType = itemType};
 *
 */
public class StringAndIntDef {

    private static final String TAG = "StringAndIntDef";

    public static class ItemTypeDescriptor {
        // ... type definitions
        // Describes when the annotation will be discarded
        @Retention(RetentionPolicy.SOURCE)

        // Enumerate valid values for this interface
        @IntDef({TYPE_MUSIC, TYPE_PHOTO, TYPE_TEXT})

        // Create an interface for validating int types
        public @interface ItemTypeDef {}

        // Declare the constants
        public static final int TYPE_MUSIC = 0;
        public static final int TYPE_PHOTO = 1;
        public static final int TYPE_TEXT = 2;

        public final int itemType;

        // Mark the argument as restricted to these enumerated types
        public ItemTypeDescriptor(@ItemTypeDef int itemType) {
            this.itemType = itemType;
        }
    }

    ItemTypeDescriptor itemTypeDescriptor = new ItemTypeDescriptor(ItemTypeDescriptor.TYPE_MUSIC);
}

/**
 * Int Def
 * Replace an interger enum where theres a parameter that only accepts explicit int values
 *
 * Example:
     public class ItemTypeDescriptor {
     public static final int TYPE_MUSIC = 0;
     public static final int TYPE_PHOTO = 1;
     public static final int TYPE_TEXT = 2;

     public final int itemType;

     public ItemTypeDescriptor(int itemType) {
     this.itemType = itemType;
     }
     }
     * There are no current validations to ensure the type passed into the constructor is valid, IntDef
     * is used to ensure the value passed to the constructor is one of the expected values
     *
     * Example:
     public class ItemTypeDescriptor {
     // ... type definitions
     // Describes when the annotation will be discarded
     @Retention(RetentionPolicy.SOURCE)

     // Enumerate valid values for this interface
     @IntDef({TYPE_MUSIC, TYPE_PHOTO, TYPE_TEXT})

     // Create an interface for validating int types
     public @interface ItemTypeDef {}

     // Declare the constants
     public static final int TYPE_MUSIC = 0;
     public static final int TYPE_PHOTO = 1;
     public static final int TYPE_TEXT = 2;

     // Mark the argument as restricted to these enumerated types
     public ItemTypeDescriptor(@ItemTypeDef int itemType) {
     this.itemType = itemType;
     }
     }
      *
      * String Def
      * Same thing as int def but for strings
      *
      * Example
     public class FilterColorDescriptor {
     public static final String FILTER_BLUE = "blue";
     public static final String FILTER_RED = "red";
     public static final String FILTER_GRAY = "gray";

     public final String filterColor;

     public FilterColorDescriptor(String filterColor) {
     this.filterColor = filterColor;
     }
     }
      * There is currently no validations to ensure the type passed is valid, so we use StringDef
      *
      * Example:
     public class FilterColorDescriptor {
     // ... type definitions
     // Describes when the annotation will be discarded
     @Retention(RetentionPolicy.SOURCE)

     // Enumerate valid values for this interface
     @StringDef({FILTER_BLUE, FILTER_RED, FILTER_GRAY})

     // Create an interface for validating String types
     public @interface FilterColorDef {}

     // Declare the constants
     public static final String FILTER_BLUE = "blue";
     public static final String FILTER_RED = "red";
     public static final String FILTER_GRAY = "gray";

     // Mark the argument as restricted to these enumerated types
     public FilterColorDescriptor(@FilterColorDef String filterColor) {
     this.filterColor = filterColor;
     }
     }
 *
 */


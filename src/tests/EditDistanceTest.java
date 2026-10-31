package tests;

import dp.EditDistance;

public class EditDistanceTest {

    public static void run() {
        EditDistance editDistance = new EditDistance();

        TestHelper.assertEquals("Edit distance identical strings", 0, editDistance.distance("kitten", "kitten"));
        TestHelper.assertEquals("Edit distance second string empty", 3, editDistance.distance("abc", ""));
        TestHelper.assertEquals("Edit distance first string empty", 3, editDistance.distance("", "abc"));
        TestHelper.assertEquals("Edit distance substitution", 1, editDistance.distance("cat", "cut"));
        TestHelper.assertEquals("Edit distance insertion", 1, editDistance.distance("cat", "cart"));
        TestHelper.assertEquals("Edit distance deletion", 1, editDistance.distance("cart", "cat"));
        TestHelper.assertEquals("Edit distance classic example", 3, editDistance.distance("kitten", "sitting"));
    }
}
package addToCompareList;

import base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AddToCompareListTest extends BaseTest {

    @Test
    public void testAddToCompareList() {
        // Set the number of products to add to the comparison list
        int numberOfProducts = 2;

        // Add the specified number of products to the comparison list
        homePage.addProductsToCompareList(numberOfProducts);

        // Assert that the header reflects the correct number of items added to the comparison list
        assertTrue(
                homePage.getNumberOfItemsAddedInHeader().contains(numberOfProducts + " items"),
                "The header does not show the expected number of items in the comparison list."
        );

        // Click the 'Compare Products' link and verify that the correct number of products was added to the list
        assertEquals(
                homePage.clickCompareProductsLink().getNumberOfProductsAdded(),
                numberOfProducts,
                "The number of products added to the comparison list is incorrect."
        );
    }
}

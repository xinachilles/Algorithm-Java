package AmazonOA;

import org.junit.Test;

import static org.junit.Assert.*;

public class ItemAssociationTest {

    @Test
    public void itemAssociation() {
        ItemAssociation2 target = new ItemAssociation2();
        target.ItemAssociation(new String[][] { new String[] { "itemA", "itemB" }, new String[] { "itemB", "itemC" },new String[] { "itemC", "itemA" }, new String[] { "itemD", "itemE" } });

    }
}
package test;

import node.BinaryTreeNode;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class BinaryTreeNodeTest {

    BinaryTreeNode rootNode;
    @Before
    public void setUp(){
        int element = 1;
        rootNode = new BinaryTreeNode(element);
    }

//    @After

    @org.junit.Test
    public void numChildren() throws Exception {
        assertEquals(0, rootNode.numChildren());
    }

    @org.junit.Test
    public void getElement() throws Exception {
    }

    @org.junit.Test
    public void getRight() throws Exception {
    }

    @org.junit.Test
    public void setRight() throws Exception {
    }

    @org.junit.Test
    public void getLeft() throws Exception {
    }

    @org.junit.Test
    public void setLeft() throws Exception {
    }

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(BinaryTreeNode.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

}

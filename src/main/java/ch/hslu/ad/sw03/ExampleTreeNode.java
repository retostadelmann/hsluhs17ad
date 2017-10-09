/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.ad.sw03;

import java.util.Comparator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.omg.CORBA.SystemException;

/**
 *
 * @author reto.stadelmann
 */
public final class ExampleTreeNode implements ITreeNode, Comparator<ITreeNode> {

    static Logger LOG = LogManager.getLogger(ExampleTreeNode.class);

    private int value;
    private ITreeNode leftNode, rightNode;

    public ExampleTreeNode(final int value) {
        this.value = value;
    }

    @Override
    public int getValue() {
        return this.value;
    }

    @Override
    public void setValue(final int value) {
        this.value = value;
    }

    @Override
    public void addNode(ITreeNode node) {
        if (this.compare(node, this) == 0) {
            throw new IllegalArgumentException("Value already in the tree");
        } else if (this.compare(node, this) == -1) {
            if (this.getLeftNode() == null) {
                this.leftNode = node;
            } else {
                this.getLeftNode().addNode(node);
            }

        } else {
            if (this.getRightNode() == null) {
                this.rightNode = node;
            } else {
                this.getRightNode().addNode(node);
            }
        }
    }

    @Override
    public ITreeNode search(int value) {
        LOG.info("Processing node with value " + this.value);
        if (this.getValue() == value) {
            LOG.info("Matching and returning");
            return this;
        } else if (value < this.getValue()) {
            LOG.info("Search value is smaller than " + this.value);
            if (this.getLeftNode() == null) {
                LOG.warn("Reached the end of the tree");
                throw new ArrayIndexOutOfBoundsException("Value could not be found");
            }
            LOG.info("Processing with Left Node");
            return this.getLeftNode().search(value);
        } else {
            LOG.info("Search value is greater than " + this.value);
            if (this.getRightNode() == null) {
                LOG.warn("Reached the end of the tree");
                throw new ArrayIndexOutOfBoundsException("Value could not be found");
            }
            LOG.info("Processing with Right Node");

            return this.getRightNode().search(value);
        }
    }

    @Override
    public ITreeNode getLeftNode() {
        return this.leftNode;
    }

    @Override
    public ITreeNode getRightNode() {
        return this.rightNode;
    }

    @Override
    public int compare(ITreeNode t, ITreeNode t1) {
        if (t.getValue() > t1.getValue()) {
            return 1;
        } else if (t.getValue() < t1.getValue()) {
            return -1;
        } else {
            return 0;
        }
    }
}

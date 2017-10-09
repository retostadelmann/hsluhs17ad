/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.ad.sw03;

import java.util.Comparator;
import java.util.Objects;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author reto.stadelmann
 */
public final class ExampleTreeNode<T extends Comparable<T>> implements ITreeNode<T>, Comparable<ITreeNode>, Comparator<ITreeNode> {

    static Logger LOG = LogManager.getLogger(ExampleTreeNode.class);

    private T value;
    private final int hash;

    private ITreeNode leftNode, rightNode, parentNode;

    /**
     * Creates a new Example Tree Node
     *
     * @param value The data value.
     */
    public ExampleTreeNode(final T value) {
        this.value = value;
        this.hash = this.hashCode();
    }

    @Override
    public T getValue() {
        return this.value;
    }

    @Override
    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public void addNode(ITreeNode node) {
        if (this.getHash() == node.getHash()) {
            throw new IllegalArgumentException("Value already in the tree");
        } else if (this.compare(node, this) == -1) {
            if (this.getLeftNode() == null) {
                node.setParentNode(this);
                this.leftNode = node;
            } else {
                this.getLeftNode().addNode(node);
            }

        } else {
            if (this.getRightNode() == null) {
                node.setParentNode(this);
                this.rightNode = node;
            } else {
                this.getRightNode().addNode(node);
            }
        }
    }

    @Override
    public boolean canBeRemoved() {
        return this.getLeftNode() == null && this.getRightNode() == null;
    }

    @Override
    public ITreeNode search(final T value) {
        LOG.info("Processing node with value " + this.value);
        if (value.compareTo(this.getValue()) < 0) {
            LOG.info("Search value is smaller than " + this.value);
            if (this.getLeftNode() == null) {
                LOG.warn("Reached the end of the tree");
                throw new ArrayIndexOutOfBoundsException("Value could not be found");
            }
            LOG.info("Processing with Left Node");
            return this.getLeftNode().search(value);
        } else if (this.getValue() == value) {
            LOG.info("Matching and returning");
            return this;
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
        return ((T) t.getValue()).compareTo((T) t1.getValue());
    }

    @Override
    public ITreeNode getParentNode() {
        return this.parentNode;
    }

    @Override
    public void setParentNode(ITreeNode node) {
        this.parentNode = node;
    }

    @Override
    public void removeLeftNode() {
        this.leftNode = null;
    }

    @Override
    public void removeRightNode() {
        this.rightNode = null;
    }

    @Override
    public int getHash() {
        return this.hash;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.value);
    }

    @Override
    public int compareTo(ITreeNode t) {
        return this.value.compareTo((T) t.getValue());
    }
}

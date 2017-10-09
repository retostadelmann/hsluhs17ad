/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.ad.sw03;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author reto.stadelmann
 */
public final class ExampleTree<T extends Comparable<T>> implements ITree<T> {

    static Logger LOG = LogManager.getLogger(ExampleTree.class);

    private ITreeNode rootNode;

    @Override
    public ITreeNode getRootNode() {
        return this.rootNode;
    }

    @Override
    public void addNode(T value) {
        ITreeNode<T> node = new ExampleTreeNode(value);
        if (this.rootNode == null) {
            this.rootNode = node;
        } else {
            rootNode.addNode(node);
        }
    }

    @Override
    public void removeNode(final T value) {
        ITreeNode node = this.search(value);
        ITreeNode leftNode = node.getParentNode().getLeftNode();
        ITreeNode rightNode = node.getParentNode().getRightNode();

        if (!node.canBeRemoved()) {
            throw new IllegalAccessError("Node with value " + value + " cannot be removed because it contains children");
        }

        if (leftNode.getValue() == value) {
            node.removeLeftNode();
        } else {
            node.removeRightNode();
        }
    }

    @Override
    public ITreeNode search(final T value) {
        LOG.info("Starting search for value " + value);
        if (this.rootNode.getValue() == value) {
            return this.rootNode;
        } else {
            return this.rootNode.search(value);
        }
    }
}

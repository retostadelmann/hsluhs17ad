/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.ad.sw03;

/**
 *
 * @author reto.stadelmann
 */
public interface ITreeNode<T extends Comparable<T>> {

    /**
     * The hash value of the data value.
     *
     * @return the integer hash value.
     */
    int getHash();

    /**
     * Returns the data value.
     *
     * @return The data value.
     */
    T getValue();

    /**
     * Sets the data value.
     *
     * @param value The data value.
     */
    void setValue(final T value);

    /**
     * Adds a new node to the tree.
     *
     * @param node The node to add.
     */
    void addNode(ITreeNode node);

    /**
     * Returns the left node.
     *
     * @return The left Node object.
     */
    ITreeNode getLeftNode();

    /**
     * Returns the right node.
     *
     * @return The right node object.
     */
    ITreeNode getRightNode();

    /**
     * Removes the left node.
     */
    void removeLeftNode();

    /**
     * Removes the right node.
     */
    void removeRightNode();

    /**
     * Searches for the value in the tree.
     *
     * @param value The value to search for.
     * @return The node containing the value.
     */
    ITreeNode search(T value);

    /**
     * Checks whether the node can be removed.
     *
     * @return A boolean value indicating whether the node can be removed.
     */
    boolean canBeRemoved();

    /**
     * Gets the parent node.
     *
     * @return The parent node.
     */
    ITreeNode getParentNode();

    /**
     * Sets the parent node.
     *
     * @param node The node to be set as parent.
     */
    void setParentNode(ITreeNode node);
}

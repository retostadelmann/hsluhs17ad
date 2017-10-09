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
public interface ITree<T extends Comparable<T>> {

    /**
     * Gets the root node.
     *
     * @return The root node.
     */
    ITreeNode getRootNode();

    /**
     * Adds a new node to the tree.
     *
     * @param value The data value to add.
     */
    void addNode(final T value);

    /**
     * Remove the node with the given value.
     *
     * @param value The data to remove.
     */
    void removeNode(final T value);

    /**
     * Searches the tree for the given value.
     *
     * @param value The value to search for.
     * @return The node containing the value.
     */
    ITreeNode search(final T value);
}

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
public interface ITree<T> {
    ITreeNode getRootNode();
    void addNode(final T value);
    void removeNode(final T value);
    ITreeNode search(final T value);
}

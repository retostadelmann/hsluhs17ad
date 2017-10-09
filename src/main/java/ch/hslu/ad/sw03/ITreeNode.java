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
public interface ITreeNode <T> {
    int getHash();
    T getValue();
    void setValue(final T value);
    void addNode(ITreeNode node);
    ITreeNode getLeftNode();
    ITreeNode getRightNode();
    void removeLeftNode();
    void removeRightNode();
    ITreeNode search(T value);
    boolean canBeRemoved();
    ITreeNode getParentNode();
    void setParentNode(ITreeNode node);
}

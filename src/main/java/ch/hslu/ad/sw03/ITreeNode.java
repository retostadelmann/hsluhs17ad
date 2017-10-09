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
public interface ITreeNode {
    int getValue();
    void setValue(final int value);
    void addNode(ITreeNode node);
    ITreeNode getLeftNode();
    ITreeNode getRightNode();
    ITreeNode search(int value);
}

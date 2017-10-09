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
public final class ExampleTree implements ITree {
    static Logger LOG = LogManager.getLogger(ExampleTree.class);
    private ITreeNode rootNode;

    @Override
    public ITreeNode getRootNode() {
        return this.rootNode;
    }

    @Override
    public void addNode(int value) {
        ITreeNode node = new ExampleTreeNode(value);
        if(this.rootNode == null){
            this.rootNode = node;
        }
        else{
            rootNode.addNode(node);
        }
    }

    @Override
    public ITreeNode removeRootNode() {
        ITreeNode node = this.rootNode;
        this.rootNode = null;
        return node;
    }

    @Override
    public ITreeNode search(final int value) {
        LOG.info("Starting search for value " + value);
        if(this.rootNode.getValue() == value){
            return this.rootNode;
        }
        else{
            return this.rootNode.search(value);
        }
    }
}

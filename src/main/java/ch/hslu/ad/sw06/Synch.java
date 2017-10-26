/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.ad.sw06;

/**
 * Schnittstelle für die Zutrittsverwaltung geschützter Bereiche.
 */
public interface Synch {

    /**
     * Eintritt in einen geschützten Bereich erlangen, falls kein Zutritt
     * möglich ist warten.
     *
     * @throws InterruptedException, wenn das Warten unterbrochen wird.
     */
    public void acquire() throws InterruptedException;

    /**
     * Freigabe des geschützten Bereiches.
     */
    public void release();
}

package com.fbad.fbad.model;

import com.fbad.fbad.model.dom.DocumentSearchBy;

public class DOMElement {

    String key; // The key of the element
    String value; // The value to replace
    DocumentSearchBy searchMethod; // The method with to find the element


    public DOMElement(String key, String value, DocumentSearchBy searchMethod) {
        this.key = key;
        this.value = value;
        this.searchMethod = searchMethod;
    }
}

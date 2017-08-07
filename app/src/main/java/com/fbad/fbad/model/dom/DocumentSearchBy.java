package com.fbad.fbad.model.dom;


public enum DocumentSearchBy {
    CLASS("document.getElementsByClassName(\'%s\')"), ID("document.getElementById(\'%s\')");

    public String value;

    DocumentSearchBy(String value) {
        this.value = value;
    }

}
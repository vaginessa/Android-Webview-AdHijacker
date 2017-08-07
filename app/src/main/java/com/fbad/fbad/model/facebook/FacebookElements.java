package com.fbad.fbad.model.facebook;


public enum FacebookElements {
    BANNER_IMAGE_CLASSNAME("icon"), BANNER_BUTTONID("fbAdLink"),;

    final String value;
    FacebookElements(String value) {
        this.value = value;
    }
}

package com.fbad.fbad.model.facebook;

import com.fbad.fbad.model.DOMElement;
import com.fbad.fbad.model.InjectionScript;
import com.fbad.fbad.model.dom.DocumentSearchBy;

import java.util.ArrayList;

public class FacebookInjectedScript extends InjectionScript {

    public FacebookInjectedScript(String targetLink, String targetSrc) {
        scriptElements = new ArrayList<>();

        //TODO: This ought to be moved out and implement dependency injection...
        DOMElement Banner_Button_Link = new DOMElement(FacebookElements.BANNER_BUTTONID.value, targetLink, DocumentSearchBy.ID);
        DOMElement Banner_Image_Src = new DOMElement(FacebookElements.BANNER_IMAGE_CLASSNAME.value, targetSrc, DocumentSearchBy.CLASS);

        scriptElements.add(Banner_Image_Src);
        scriptElements.add(Banner_Button_Link);
    }
}

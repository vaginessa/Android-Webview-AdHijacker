package com.fbad.fbad.model;


import com.fbad.fbad.model.dom.DocumentSearchBy;

import java.util.List;

public class InjectionScript {

    protected List<DOMElement> scriptElements;

    @Override
    public String toString() {
        StringBuilder script = new StringBuilder();
        script.append("(function() { ");

        for (DOMElement elem :
                this.scriptElements) {

            //Search by METHOD with KEY
            script.append(String.format(elem.searchMethod.value, elem.key));

            //To Inject with
            if (elem.searchMethod == DocumentSearchBy.CLASS)
                script.append(String.format("[0].src=\"%s\"; ", elem.value));
            else
                script.append(String.format(".href=\"%s\"; ", elem.value));
        }

        script.append("})()");
        return script.toString();
    }
}
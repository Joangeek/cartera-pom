package com.comun.controlador.util;

import java.util.Iterator;

import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;

public final class UtilidadPrime {
    public static void fijarAtributo(String idComponent, String atr,
            Object value) {
        UIComponent padre = Utilidad.buscarHtmlComponete(idComponent);
        if (padre != null) {
            padre.getAttributes().put(atr, value);
        }
    }

    public static void fijarAtributo(String idComponent, String atr,
            Object value, boolean Padres) {
        UIComponent padre = Utilidad.buscarHtmlComponete(idComponent);

        if (padre != null) {

            if (padre instanceof HtmlInputText) {
                padre.getAttributes().put(atr, value);
            }

            Iterator<UIComponent> kids = padre.getFacetsAndChildren();
            while (kids.hasNext()) {
                UIComponent kid = kids.next();

                fijarAtributo(kid.getId(), atr, value, true);

            }
        }
    }
}
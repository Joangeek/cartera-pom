package com.comun.controlador.util.core;

import java.util.List;

import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import com.comun.controlador.util.Utilidad;


/**
 * permite convertir de un valor de f:selectItems a una entidad para ello la
 * entidad deve tener el atributo id
 * 
 * @author 
 * 
 */

public class GenericConvertEntity2 implements Converter {

    @SuppressWarnings("unchecked")
    public Object getAsObject(FacesContext context, UIComponent component,
            String value) {
        String proFijar = obtenerPropiedadFijar(context, component);
        Object bean = obtenerBeanFijar(context, component, proFijar);

        List<UIComponent> hijos = component.getChildren();
        UISelectItems items = null;
        for (UIComponent uiComponent : hijos) {
            if (uiComponent instanceof UISelectItems) {
                items = (UISelectItems) uiComponent;
                break;
            }
        }
        if (items != null) {
            ValueExpression valueExp = items.getValueExpression("value");
            List<Object> listaValores = (List<Object>) valueExp
                    .getValue(FacesContext.getCurrentInstance().getELContext());
            if (null != listaValores) {
                for (Object object : listaValores) {
                    if (obtener_id_entidad(object).equals(value)) {
                        Utilidad.fijarPropiedad(bean, proFijar, object);
                        return Long.valueOf(obtener_id_entidad(object));
                    }
                }
            }
        }
        return null;
    }

    public String getAsString(FacesContext context, UIComponent component,
            Object value) {

        return (value == null ? null : value.toString());
    }

    private String obtenerPropiedadFijar(FacesContext context,
            UIComponent component) {
        String valueExpCom = component.getValueExpression("value")
                .getExpressionString();
        valueExpCom = valueExpCom.replace(".oid", "");
        int indiceUltPunto = valueExpCom.lastIndexOf('.');
        valueExpCom = valueExpCom.substring(indiceUltPunto + 1);
        return valueExpCom.replace("}", "");
    }

    private Object obtenerBeanFijar(FacesContext context,
            UIComponent component, String prop) {
        String valueExpCom = component.getValueExpression("value")
                .getExpressionString();
        valueExpCom = valueExpCom.replace(".oid", "");
        valueExpCom = valueExpCom.replace(prop, "");
        valueExpCom = valueExpCom.replace(".}", "}");
        return context.getApplication().evaluateExpressionGet(context,
                valueExpCom, Object.class);
    }

    private String obtener_id_entidad(Object entidad) {
        return Utilidad.obtenerPropiedad(entidad, "oid");
    }

}

package com.comun.controlador.util.core;

import java.util.List;

import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

public class GenericConvertEntity implements Converter {

	@SuppressWarnings("unchecked")
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
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
					if (object.toString().equals(value)) {
						return object;
					}
				}
			}
		}

		return null;
	}

	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		// para q retorne com.hds.vpm.entidad.Sexo@4a581bce
		return (value == null ? null : value.toString());
	}

}

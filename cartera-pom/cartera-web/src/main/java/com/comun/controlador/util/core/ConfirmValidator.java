package com.comun.controlador.util.core;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.primefaces.util.MessageFactory;

public class ConfirmValidator implements Validator {

    public void validate(FacesContext context, UIComponent component,
            Object value) throws ValidatorException {

        String valor = value.toString();
        String idInput = (String) component.getAttributes().get(
                "idInputConfirm");

        UIInput uiInputConfirm = (UIInput) context.getViewRoot().findComponent(
                idInput);

        Object confirmValue = uiInputConfirm.getSubmittedValue();

        if (valor == null || valor.isEmpty()) {
            return;
        }

        if (confirmValue == null || confirmValue.toString().isEmpty()) {
            uiInputConfirm.setValid(false);
            context.addMessage(uiInputConfirm.getClientId(), MessageFactory
                    .getMessage(UIInput.REQUIRED_MESSAGE_ID,
                            FacesMessage.SEVERITY_ERROR, new Object[] { "" }));
            return;
        }

        if (!valor.equals(confirmValue)) {
            uiInputConfirm.setValid(false);
            throw new ValidatorException(MessageFactory.getMessage(
                    "validator.confirm.invalid", FacesMessage.SEVERITY_ERROR,
                    null));
        }

    }
}

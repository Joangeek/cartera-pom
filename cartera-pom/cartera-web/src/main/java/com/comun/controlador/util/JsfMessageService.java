package com.comun.controlador.util;

import java.text.MessageFormat;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

/**
 * 
 * @author Camilo Palacios
 * @author Carlos Cepeda
 */
public class JsfMessageService {

    public enum MessageSeverity {

        SEVERITY_INFO(FacesMessage.SEVERITY_INFO), SEVERITY_WARN(
                FacesMessage.SEVERITY_WARN), SEVERITY_ERROR(
                FacesMessage.SEVERITY_ERROR), SEVERITY_FATAL(
                FacesMessage.SEVERITY_FATAL);
        private final transient Severity severity;

        private MessageSeverity(Severity severity) {
            this.severity = severity;
        }
    }

    public enum SourceBundle {
        COMUN("com/hds/autorizaciones-medicas/mensajes/mensajes_comunes"), AUDITORIA(
                "com/hds/autorizaciones-medicas/mensajes/auditoria_es_CO"), AUDITORIA_EGRESO(
                "com/hds/vpm/properties/autoservicios/web/auditoria_es_CO"), TRAMITANTES(
                "com/hds/recepcion/messages/messages_recepcionSolicitudes_es_CO"), AGENDA(
                "com/hds/contactcenter/messages/web/agenda_es_CO"), AGENDA_AUTO(
                "com/hds/vpm/properties/agenda/agenda_es_CO"), ASEGURABILIDAD(
                "com/hds/contactcenter/messages/web/verDetalleAsegurabilidad_es_CO"), CERTIFICACION_PROV(
                "com/hds/vpm/properties/comun/certificacion_proveedores_es_CO"),
        // INVENTARIO("com/hds/messages/generarInventario_es_CO");
        TOOLBAR("META-INF/resources/recursos/idiomas/mensajes_toolbar_es_CO"), COFIME(
                "com/hds/captura/messages/messages_ejecutarCofimevi_es_CO");

        private final String bundlePath;

        private SourceBundle(String bundlePath) {
            this.bundlePath = bundlePath;
        }

        public String getBundlePath() {
            return bundlePath;
        }
    }

    private JsfMessageService() {
    }

    public static void displayMessage(MessageSeverity messageSeverity,
            String title, String summary) {
        final FacesMessage message = new FacesMessage(messageSeverity.severity,
                title, summary);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public static void displayStaticMessage(SourceBundle sourceBundle,
            MessageSeverity messageSeverity, String messageSummaryKey,
            String messageDetailKey) {
        displayStaticMessage(sourceBundle, messageSeverity, messageSummaryKey,
                messageDetailKey, null);
    }

    public static void displayStaticMessage(SourceBundle sourceBundle,
            MessageSeverity messageSeverity, String messageSummaryKey,
            String messageDetailKey, String idSource) {

        String bundleMessageSummary = "";
        String bundleMessageDetail = "";

        if (messageSummaryKey != null && !messageSummaryKey.isEmpty()) {
            bundleMessageSummary = getBundleMessage(sourceBundle,
                    messageSummaryKey);
        }
        if (messageDetailKey != null && !messageDetailKey.isEmpty()) {
            bundleMessageDetail = getBundleMessage(sourceBundle,
                    messageDetailKey);
        }
        final FacesMessage message = new FacesMessage(messageSeverity.severity,
                bundleMessageSummary, bundleMessageDetail);
        FacesContext.getCurrentInstance().addMessage(idSource, message);
    }

    public static void displayDynamicMessage(SourceBundle sourceBundle,
            MessageSeverity messageSeverity, String messageSummaryKey,
            String messageDetailKey, List<String> messageSummaryParameters,
            List<String> messageDetailParameters) {
        displayDynamicMessage(sourceBundle, messageSeverity, messageSummaryKey,
                messageDetailKey, messageSummaryParameters,
                messageDetailParameters, null);
    }

    public static void displayDynamicMessage(SourceBundle sourceBundle,
            MessageSeverity messageSeverity, String messageSummaryKey,
            String messageDetailKey, List<String> messageSummaryParameters,
            List<String> messageDetailParameters, String idSource) {

        String bundleMessageSummary = "";
        String bundleMessageDetail = "";

        if (messageSummaryKey != null && !messageSummaryKey.isEmpty()) {
            bundleMessageSummary = getBundleMessage(sourceBundle,
                    messageSummaryKey);
            if (messageSummaryParameters != null
                    && !messageSummaryParameters.isEmpty()) {
                bundleMessageSummary = MessageFormat.format(
                        bundleMessageSummary,
                        messageSummaryParameters.toArray());
            }
        }
        if (messageDetailKey != null && !messageDetailKey.isEmpty()) {
            bundleMessageDetail = getBundleMessage(sourceBundle,
                    messageDetailKey);
            if (messageDetailParameters != null
                    && !messageDetailParameters.isEmpty()) {
                bundleMessageDetail = MessageFormat.format(bundleMessageDetail,
                        messageDetailParameters.toArray());
            }
        }
        final FacesMessage message = new FacesMessage(messageSeverity.severity,
                bundleMessageSummary, bundleMessageDetail);
        FacesContext.getCurrentInstance().addMessage(idSource, message);
    }

    public static String getBundleMessage(SourceBundle sourceBundle,
            String messageKey) {
        final Locale locale = FacesContext.getCurrentInstance().getViewRoot()
                .getLocale();
        final ResourceBundle resourceBundle = ResourceBundle.getBundle(
                sourceBundle.bundlePath, locale);
        return resourceBundle.getString(messageKey);
    }

}

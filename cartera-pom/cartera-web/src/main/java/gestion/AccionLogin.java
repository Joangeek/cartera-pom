package gestion;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import com.comun.controlador.util.ConfiguracionGlobal;



/**
 * Bean manejado que controla el evento de inicio de sesion para el modulo de
 * CfgOperativa. Por configuracion el proceso de inicio de sesion se realiza
 * solamente en el proyecto principal, por lo cual la unica accion que se
 * realiza aqui es redireccionar a VPM
 * 
 * @author Freymam Vallejo
 * 
 */
@ManagedBean(name = "login")
@RequestScoped
public class AccionLogin {

    private String error;

    @PostConstruct
    public void init() {

    }

    /**
     * Funcion que se invoca para cerrar sesion desde este modulo y se encarga
     * de invocar la url en vpm que se encarga de invalidar la sesion
     */
    public void doLogout() {
        try {
            final HttpServletResponse response = (HttpServletResponse) FacesContext
                    .getCurrentInstance().getExternalContext().getResponse();
            response.sendRedirect(ConfiguracionGlobal.URL_VPM_LOGOUT);
        } catch (IOException e) {
            error = "logout.error.navegacion";
        }
    }

    /**
     * Funcion que se invoca cuando se quiere iniciar sesion a causa de intentar
     * una url de este modulo. Toda clase de inicio se sesion se realiza desde
     * el proyecto principal de VPM, por lo tanto se realiza la redireccion a la
     * url de inicio se sesion de Vpm
     */
    public void goToLogin() {
        try {
            final HttpServletResponse response = (HttpServletResponse) FacesContext
                    .getCurrentInstance().getExternalContext().getResponse();
            response.sendRedirect(ConfiguracionGlobal.URL_VPM_LOGIN);
        } catch (IOException e) {
            error = "logout.error.navegacion";
        }
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

}

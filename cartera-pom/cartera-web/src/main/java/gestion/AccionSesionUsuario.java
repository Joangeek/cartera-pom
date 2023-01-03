package gestion;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

/**
 * Bean manejado que controla y almacena los elementos de la sesion que inicia
 * un usuario. Esta clase mantiene en memoria el usuario proveniente de Acs que
 * realizo el firmado en el aplicativo. Contiene metodos de verificacion del
 * estado de sesion obtenidos a partir del consumo de servicios web del modulo
 * Acs; igualmente gestiona la creacion y mantenimiento del menu de usuario
 * 
 * @author Freymam Vallejo
 * 
 */
@ManagedBean(name = "sesionUsuario")
@SessionScoped
public class AccionSesionUsuario implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nombreUsuario;
    private String clave;
   // private boolean estaActivoPorAcs;
   // private boolean estaFirmado;


    @PostConstruct
    public void init() {
//        estaActivoPorAcs = false;
//        estaFirmado = false;
    }

    /**
     * Valida que se halla realiza un inicio de sesion desde otro modulo,
     * consiguiendo el nombre de usuario registrado y verificando su existencia
     * en Acs para conseguir sus datos de usuario, roles y permisos para asi
     * armar el menu de usuario
     * 
     * @throws UsuarioInactivoException_Exception
     */
   /* public void validarInicioSesionDesdeOtroModulo()
            throws UsuarioInactivoException_Exception {
        if (!estaFirmado) {
            nombreUsuario = FacesContext.getCurrentInstance()
                    .getExternalContext().getRemoteUser();
            usuarioAcs = buscarUsuarioAcs(nombreUsuario);
            if (null == usuarioAcs) {
            	mostrarMensajeError("El servicio de Acs no esta disponible en este momento");
            } else {
            	if (null != usuarioAcs.getRoles()
                        && !usuarioAcs.getRoles().isEmpty()) {
                    accionMenu.cargarMenuPorUsuario(nombreUsuario, usuarioAcs
                            .getRoles().get(0).getProducto().getId());
                    estaFirmado = true;
                }    
            }
        }
    }

    /**
     * Actualiza el nombre de usuario y si esta firmado o no
     */
    public void verificarNombreUsuario() {
        final String nombre = FacesContext.getCurrentInstance()
                .getExternalContext().getRemoteUser();
        if (null != nombre && !nombre.isEmpty()) {
            if (!nombre.equals(nombreUsuario)) {
               // estaFirmado = false;
                nombreUsuario = nombre;
            }
        } else {
           // estaFirmado = false;
        }
    }

    /**
     * Muestra mensaje de estado de error en pantalla
     * 
     * @param mensaje
     */
    private void mostrarMensajeError(String mensaje) {
        final FacesMessage message = new FacesMessage(
                FacesMessage.SEVERITY_ERROR, mensaje, "Error");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    /**
     * Consume el servicio web de ACS para buscar el nombre de usuario y sus
     * roles y permisos
     * 
     * @param nombreUsuario_
     * @return
     * @throws UsuarioInactivoException_Exception
   /*  */
  /*  private Usuario buscarUsuarioAcs(String nombreUsuario_)
            throws UsuarioInactivoException_Exception {
        try {
            final UsuarioWS_Service service = new UsuarioWS_Service();
            final UsuarioWS port = service.getUsuarioWSImplPort();
            if (null == port || null == nombreUsuario_
                    || nombreUsuario_.isEmpty()) {
                return null;
            }
            return port.buscarUsuarioPorLogin(nombreUsuario_);
        } catch (WebServiceException ex) {
            return null;
        }
    }

    /**
     * Cierra la sesion invocando una pagina en vpm
     */
    public void cerrarSesion() {
        FacesContext.getCurrentInstance().getExternalContext().getRequest();
        final HttpServletResponse response = (HttpServletResponse) FacesContext
                .getCurrentInstance().getExternalContext().getResponse();
        try {
            response.sendRedirect("/vpm/logout.seam");
        } catch (IOException e) {
            mostrarMensajeError("logout.error.navegacion");
        }
//        FacesContext.getCurrentInstance().getExternalContext()
//                .invalidateSession();
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

  /*  public Usuario getUsuarioAcs() {
        return usuarioAcs;
    }

    public void setUsuarioAcs(Usuario usuarioAcs) {
        this.usuarioAcs = usuarioAcs;
    }

    public boolean isEstaActivoPorAcs() {
        return estaActivoPorAcs;
    }

    public void setEstaActivoPorAcs(boolean estaActivoPorAcs) {
        this.estaActivoPorAcs = estaActivoPorAcs;
    }

    public boolean isEstaFirmado() {
        return estaFirmado;
    }

    public void setEstaFirmado(boolean estaFirmado) {
        this.estaFirmado = estaFirmado;
    }

    public AccionMenu getAccionMenu() {
        return accionMenu;
    }

    public void setAccionMenu(AccionMenu accionMenu) {
        this.accionMenu = accionMenu;
    }*/

}

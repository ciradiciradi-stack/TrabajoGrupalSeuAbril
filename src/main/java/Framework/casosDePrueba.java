package Framework;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

// Para practicar cualquier flujo de prueba que quieran automatizar, pueden utilizar paginas como:
// - Swag Labs (https://www.saucedemo.com/"): interfaz sencilla y de rapida respuesta, pueden simular (para validar) sesiones de usuario erroneas como problemas generales de carga y renderizado.
// - Simple. (https://sauce-demo.myshopify.com/): interfaz compleja, representa mayores de safios a la hora de identificar elementos y la interaccion en los tiempos que corresponden, puede requerir validaciones de estado de objetos como tiempo de cargas parametrizados.

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class casosDePrueba extends configuracionBase
{
    @Test @Order(5)
    public void ValidarCarro() throws Exception {
        // Todo...
        funcionesDeNegocio.Login("standard_user","secret_sauce");
        accionesBase.Click("//*[@id='add-to-cart-sauce-labs-backpack']");

        accionesBase.Click(objetosDePagina.Catalogo_Carrito);
        accionesBase.CompararTexto(objetosDePagina.Carrito_Titulo, TitYourCart, "La página no corresponde a la del carro");
        List<WebElement> links =Driver.findElements(By.xpath("//*[@id='cart_contents_container']/div/div[1]/div[3]"));

// Iterar sobre los elementos
        for (WebElement link : links) {
            if (!link.getText().isEmpty()) {
            System.out.println("Número de productos: " + links.size());
            } else System.out.println("No hay elementos");
        }
        accionesBase.Click(objetosDePagina.Carrito_Btn_CheckOut);
    }
    @Test @Order(6)
    public void InformacionCompra() throws Exception {
        accionesBase.CompararTexto(objetosDePagina.CheckOut_Titulo, TitCheckoutInformation, "No esta en el CheckOut");
        accionesBase.Escribir(objetosDePagina.CheckOut_AddName, CheckOutTxtAddName);
        accionesBase.Escribir(objetosDePagina.CheckOut_AddLastName, CheckOutTxtAddLastName);
        accionesBase.Escribir(objetosDePagina.CheckOut_AddPostalCode, CheckOutTxtAddPostalCode);
        accionesBase.Click(objetosDePagina.CheckOut_BtnContinue);
    }
    @Test @Order(7)
    public void InformacionCheckOut() throws Exception {
        accionesBase.CompararTexto(objetosDePagina.OverView_Titulo, TitCheckoutOverview, "No esta en el OverView");
        System.out.println(accionesBase.LeerTexto(objetosDePagina.OverView_SummaryPayment));
        System.out.println(accionesBase.LeerTexto(objetosDePagina.OverView_ShippingInfo));
    }

}

package Framework;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

import static Framework.funcionesDeNegocio.Login;

public class configuracionBase
{
    // Definición de variables globales y parámetros de configuración
    public static WebDriver Driver;
    public static Boolean LoginRequerido = false;
    public static String UrlDemo = "https://www.saucedemo.com/";
    public static String Username = "standard_user";
    public static String Password = "secret_sauce";
    
    //Textos casos 5 a l7
    public static String TitYourCart = "Your Cart";
    public static String TitCheckoutInformation = "Checkout: Your Information";
    public static String TitCheckoutOverview ="Checkout: Overview";
    public static String CheckOutTxtAddName= "CARO";
    public static String CheckOutTxtAddLastName= "CARO2";
    public static String CheckOutTxtAddPostalCode= "1010101";
    
    @BeforeAll
    public static void AntesDeTodo() throws Exception {
        System.out.println("Rutina: Before All (Antes de Todos los Casos de Prueba)");

        // Configuración del Driver: Definición de ruta y propiedades del sistema
        String ChromeDriver = "drivers/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", ChromeDriver);
        ChromeOptions options = new ChromeOptions();

        // Ajustes del Navegador: Configuración de preferencias y seguridad de Chrome
        Map<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("profile.password_manager_leak_detection", false);
        chromePrefs.put("credentials_enable_service", false);
        options.setExperimentalOption("prefs", chromePrefs);

        // Inicialización: Lanzamiento del navegador y carga de la URL base
        Driver = new ChromeDriver(options);
        Driver.get(UrlDemo);
        Thread.sleep(1000);
    }

    @BeforeEach
    public void AntesDeCaso() throws Exception {
        System.out.println("Rutina: Before Each (Antes de un Caso de Prueba)");

        // Gestión de sesión: Login automático condicional antes de cada test
        if (LoginRequerido.equals(true)) {
            Login(Username, Password);
        }
        Thread.sleep(1000);
    }

    @AfterEach
    public void DespuesDeCaso() throws Exception {
        System.out.println("Rutina: After Each (Despues de un Caso de Prueba)");

        // Limpieza post-ejecución: Reseteo de cookies y retorno a página principal
        if (LoginRequerido.equals(true)) {
            Driver.manage().deleteAllCookies();
            Driver.get(UrlDemo);
        }
        Thread.sleep(1000);
    }

    @AfterAll
    public static void DespuesDeTodo() throws Exception {
        System.out.println("Rutina: After All (Despues de Todos los Casos de Prueba)");

        // Finalización: Cierre total del proceso del WebDriver y navegador
        Thread.sleep(1000);
        Driver.quit();
    }
}

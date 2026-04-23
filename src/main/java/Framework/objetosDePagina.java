package Framework;

public class objetosDePagina
{
    // Rutas de elementos, pagina Login.
    public static String Login_username = "//*[@id='user-name']";
    public static String Login_password = "//*[@id='password']";
    public static String Login_submit = "//*[@id='login-button']";
    public static String Login_login_logo = "//*[@id='root']/div/div[1]";

    // Rutas de elementos, pagina Catalogo.
    public static String Catalogo_titulo_productos = "//*[@class='title']";
    public static String Catalogo_burger_menu = "//*[@id='react-burger-menu-btn']";
    public static String Catalogo_link_logout = "//*[@id='logout_sidebar_link']";
    public static String Catalogo_Carrito = "//*[@class='shopping_cart_link']";
    // Rutas de elementos, pagina Carrito.
    public static String Carrito_Titulo = "//*[@class='title']";
    public static String Carrito_Count = "//*[@id='cart_contents_container']/div/div[1]/div[3]/div[1]";
    public static String Carrito_Btn_CheckOut = "//*[@id='checkout']";
    // Rutas de elementos, pagina Checkout.
    public static String CheckOut_Titulo = "//*[@id='header_container']/div[2]/span";
    public static String CheckOut_AddName = "//*[@id='first-name']";
    public static String CheckOut_AddLastName = "//*[@id='last-name']";
    public static String CheckOut_AddPostalCode = "//*[@id='postal-code']";
    public static String CheckOut_BtnContinue = "//*[@id='continue']";
    // Rutas de elementos, pagina overview.
    public static String OverView_Titulo = "//*[@id='header_container']/div[2]/span";
    public static String OverView_SummaryPayment = "//*[@id='checkout_summary_container']/div/div[2]/div[2]";
    public static String OverView_ShippingInfo = "//*[@id='checkout_summary_container']/div/div[2]/div[4]";

}

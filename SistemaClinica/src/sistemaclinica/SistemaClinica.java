/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemaclinica;
import Controlador.MenuControlador;
import Visual.Menu;
public class SistemaClinica {

    public static void main(String[] args) {
    Menu menu = new Menu();
    MenuControlador menuController = new MenuControlador(menu);
    menu.setVisible(true);
    }
    
}

package seminarThreeHW;

import seminarThreeHW.onlineShop.ProductDatabase;
import seminarThreeHW.onlineShop.ShopManager;
import seminarThreeHW.view.OnlineShopUI;

public class MainClassTaskOne {
    public static void main(String[] args) {
        ProductDatabase db = new ProductDatabase();
        ShopManager manager = new ShopManager(db);
        OnlineShopUI onlineShopUI = new OnlineShopUI(manager);
        onlineShopUI.run();
    }
}

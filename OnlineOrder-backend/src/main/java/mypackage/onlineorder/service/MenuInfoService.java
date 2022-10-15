package mypackage.onlineorder.service;

import mypackage.onlineorder.dao.MenuInfoDao;
import mypackage.onlineorder.entity.MenuItem;
import mypackage.onlineorder.entity.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuInfoService {

   @Autowired
   private MenuInfoDao menuInfoDao;


   public List<Restaurant> getRestaurants() {
      return menuInfoDao.getRestaurants();
   }

   public List<MenuItem> getAllMenuItem(int restaurantId) {
      return menuInfoDao.getAllMenuItem(restaurantId);
   }

   public MenuItem getMenuItem(int id) {
      return menuInfoDao.getMenuItem(id);
   }
}


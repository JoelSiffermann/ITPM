package de.hdm.itprojekt.projektmarktplatz.client.gui;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.RootPanel;

public class Home {

	   private void showSelectedMenuItem(String menuItemName){
		      Window.alert("Menu item: "+menuItemName+" selected");
		   }
		   
		   public void onModuleLoad() {
			       
		   // Create a menu bar
		   MenuBar menu = new MenuBar();
		   menu.setAutoOpen(true);
		   menu.setWidth("550px");
		   menu.setAnimationEnabled(true);

		   // Create the profil menu
		   MenuBar profilMenu = new MenuBar(true);
		   profilMenu.setAnimationEnabled(true);

		   profilMenu.addItem("Bearbeiten", new Command() {
		      @Override
		      public void execute() {
		         showSelectedMenuItem("bearbeiten");
		      }
		   });
		   
		   profilMenu.addItem("Anzeigen", new Command() {
		      @Override
		      public void execute() {
		         showSelectedMenuItem("anzeigen");
		      }
		   });
		   
		   profilMenu.addSeparator();
		   profilMenu.addItem("Loeschen", new Command() {
		      @Override
		      public void execute() {
		         showSelectedMenuItem("loeschen");
		      }
		   });

		   // Create the projektmarktplatz menu
		   MenuBar projektmarktplatzMenu = new MenuBar(true);
		   projektmarktplatzMenu.setAnimationEnabled(true);

		   projektmarktplatzMenu.addItem("Anzeigen", new Command() {
		      @Override
		      public void execute() {
		         showSelectedMenuItem("anzeigen");
		      }
		   });
		   
		   projektmarktplatzMenu.addItem("Bearbeiten", new Command() {
		      @Override
		      public void execute() {
		         showSelectedMenuItem("bearbeiten");
		      }
		   });	
		   
		   projektmarktplatzMenu.addItem("Loeschen", new Command() {
		      @Override
		      public void execute() {
		         showSelectedMenuItem("loeschen");
		      }
		   });
		   
		   // Create the bewerbung menu
		   MenuBar bewerbungMenu = new MenuBar(true);
		   bewerbungMenu.setAnimationEnabled(true);

		   bewerbungMenu.addItem("Anzeigen", new Command() {
		      @Override
		      public void execute() {
		         showSelectedMenuItem("anzeigen");
		      }
		   });
		   
		   bewerbungMenu.addItem("Bearbeiten", new Command() {
		      @Override
		      public void execute() {
		         showSelectedMenuItem("bearbeiten");
		      }
		   });	
		   
		   bewerbungMenu.addItem("Loeschen", new Command() {
		      @Override
		      public void execute() {
		         showSelectedMenuItem("loeschen");
		      }
		   });
		   
		   // Create the bewertung menu
		   MenuBar bewertungMenu = new MenuBar(true);
		   bewertungMenu.setAnimationEnabled(true);

		   bewertungMenu.addItem("Anzeigen", new Command() {
		      @Override
		      public void execute() {
		         showSelectedMenuItem("anzeigen");
		      }
		   });
		   
		   bewertungMenu.addItem("Bearbeiten", new Command() {
		      @Override
		      public void execute() {
		         showSelectedMenuItem("bearbeiten");
		      }
		   });	   
		   
		   bewertungMenu.addItem("Loeschen", new Command() {
		      @Override
		      public void execute() {
		         showSelectedMenuItem("loeschen");
		      }
		   });
		   
		   // Create the report menu
		   MenuBar reportMenu = new MenuBar(true);
		   reportMenu.setAnimationEnabled(true);

		   reportMenu.addItem("Suchen", new Command() {
		      @Override
		      public void execute() {
		         showSelectedMenuItem("suchen");
		      }
		   });
		   
		   reportMenu.addItem("Bearbeiten", new Command() {
		      @Override
		      public void execute() {
		         showSelectedMenuItem("bearbeiten");
		      }
		   });	   
		   
		   reportMenu.addItem("Loeschen", new Command() {
		      @Override
		      public void execute() {
		         showSelectedMenuItem("loeschen");
		      }
		      
		   });	  
		   
		   // Create the ausschreibung menu
		   
		   MenuBar ausschreibungMenu = new MenuBar(true);
		   ausschreibungMenu.setAnimationEnabled(true);

		   ausschreibungMenu.addItem("Anzeigen", new Command() {
		      @Override
		      public void execute() {
		         showSelectedMenuItem("anzeigen");
		      }
		   });
		   
		   ausschreibungMenu.addItem("Bearbeiten", new Command() {
		      @Override
		      public void execute() {
		         showSelectedMenuItem("bearbeiten");
		      }
		   });	   
		   
		   ausschreibungMenu.addItem("Loeschen", new Command() {
		      @Override
		      public void execute() {
		         showSelectedMenuItem("loeschen");
		      }
		   });

		   reportMenu.addItem("Suchen", new Command() {
		      @Override
		      public void execute() {
		         showSelectedMenuItem("suchen");
		      }
		   });
		   
		   menu.addItem(new MenuItem("Profil", profilMenu));
		   menu.addSeparator();
		   menu.addItem(new MenuItem("Projektmarktplatz", projektmarktplatzMenu));
		   menu.addSeparator();
		   menu.addItem(new MenuItem("Bewerbung", bewerbungMenu));
		   menu.addSeparator();
		   menu.addItem(new MenuItem("Bewertung", bewertungMenu));
		   menu.addSeparator();
		   menu.addItem(new MenuItem("Report", reportMenu));
		   menu.addSeparator();
		   menu.addItem(new MenuItem("Ausschreibung", ausschreibungMenu));

		   //add the menu to the root panel
		   RootPanel.get("main").add(menu);
		   }	
}

import java.awt.*;
public class Tester extends java.applet.Applet {
	Dimension okno = Toolkit.getDefaultToolkit().getScreenSize();
	public void init(){
		setSize(okno.width, okno.height);
	}
	
	public void paint(Graphics g) {
		Complex c = new Complex(-0.1,0.65), kopia=null; //PARAMETR C FUNKCJI--------
//DWIE PÊTLE 1 I 2 "PRZELATUJ¥CE" PRZEZ KA¯DY PIKSEL NA EKRANIE---------------------
		for(int h=-okno.getSize().height/2; h<okno.getSize().height/2; h++){
			int w=-okno.getSize().width/2;
			for(; w<okno.getSize().width/2; w++){
				Complex z0 = new Complex((w/(double)okno.getSize().width*2.999), h/(double)okno.getSize().height*2.999);
				
//SPRAWDZENIE CZY DANY PIKSEL NALE¯Y DO ZBIORU JULII--------------------------------
				int i=0; kopia=z0;
				do{
					i++;
					z0=z0.kwadrat().dodaj(c);
				}while(z0.modul2()<2 && i<30);
//WYLICZANIE SZYBKOŒCI UCIECZKI POZOSTA£YCH PUNKTÓW(T£O)
				int argument=i;
				do{
					i++;
					z0=z0.kwadrat().dodaj(c);
				}while(z0.modul2()<2 && i<argument*100);

//---------------------------------------------------KOLOROWANIE PIKSELI---------------------------------------------------------------
				if(argument<30){					
					g.setColor(Color.getHSBColor(((float)argument/76), 1.0f , 1.0f));
					g.fillOval((int)((kopia.getX()+1.5)*getSize().width/3), (int)((kopia.getY()+1.5)*getSize().height/3), 2, 2);
				}
				if(i>30){					
					g.setColor(Color.getHSBColor(((float)i/76), 1.0f , 1.0f));
					g.fillOval((int)((kopia.getX()+1.5)*getSize().width/3), (int)((kopia.getY()+1.5)*getSize().height/3), 2, 2);
				}
//---------------------------------------------------KONIEC KOLOROWANIA----------------------------------------------------------------
			}//KONIEC PÊTLI 1
		}//KONIEC PÊTLI 2
	}
}
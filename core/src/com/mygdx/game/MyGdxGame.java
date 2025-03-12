package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.Grafiche.*;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	BitmapFont font;
	BitmapFont cronometro;
	BitmapFont parole;

	long tempoInizio = 0;
	long tempoTrascorso;

	int paroleContate = 0;

	private String parola;
	private Player p1;
	private Strada s1;
	private Strada s2;
	private Layer1 l1,l2;
	private Layer2 b1,b2;
	private Layer3 c1,c2;
	private Layer4 d1,d2;

	private static int movimento = 2;

	private char currentChar;
	private int indexOfchar = 0;
	private long frame = 0;
	Texture img;

	Texture strada1;
	Texture strada2;

	Texture layer1;
	Texture layer2;

	Texture palazzi1;
	Texture palazzi2;

	Texture montagna1;
	Texture montagna2;

	Texture stelle1;
	Texture stelle2;

	Texture player;

	private void initGraphics()
	{
		s1 = new Strada(0,0);
		s2 = new Strada(640,0);

		l1 = new Layer1(0,0);
		l2 = new Layer1(640,0);

		b1 = new Layer2(0,0);
		b2 = new Layer2(640,0);

		c1 = new Layer3(0,0);
		c2 = new Layer3(640,0);

		d1 = new Layer4(0,0);
		d2 = new Layer4(640,0);

		layer1 = Layer1.getImage();
		layer2 = Layer1.getImage();

		palazzi1 = Layer2.getImage();
		palazzi2 = Layer2.getImage();

		montagna1 = Layer3.getImage();
		montagna2 = Layer3.getImage();

		strada1 = Strada.getImage();
		strada2 = Strada.getImage();

		stelle1 = Layer4.getImage();
		stelle2 = Layer4.getImage();

		font = new BitmapFont();
		cronometro = new BitmapFont();
		parole = new BitmapFont();
	}

	private void initBackGround()
	{
		img = new Texture("data/cielo.png");
	}

	private void initDictionary()
	{
		WordsDictionary w = new WordsDictionary();
		parola = WordsDictionary.getSingleWord();
		currentChar = parola.charAt(indexOfchar);
	}

	@Override
	public void create () {
		batch = new SpriteBatch();

		initBackGround();

		initGraphics();

		p1 = new Player();
		player = p1.getImage();

		initDictionary();
	}

	@Override
	public void render () {
		keyListener();
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		//

		if(tempoInizio!=0)
		{
			tempoTrascorso = System.currentTimeMillis()-tempoInizio;
			System.out.println(tempoTrascorso);
		}

		paintAll();
		frame+=1;

		//
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}

	private void renderStrada()
	{
		batch.draw(strada1,s1.getX(),0);
		batch.draw(strada1,s2.getX(),0);

		s1.incX((int) p1.getSpeed());
		s2.incX((int) p1.getSpeed());

		if(s1.getX() <= -640)
		{
			s1.setX(640 +s2.getX());
		}
		if(s2.getX() <= -640)
		{
			s2.setX(s1.getX()+640);
		}

	}

	private void renderLayer1()
	{
		batch.draw(layer1,l1.getX(),0);
		batch.draw(layer2,l2.getX(),0);

		//l1.incX((int) (p1.getSpeed()/4));
		//l2.incX((int) (p1.getSpeed()/4));

		if(frame%movimento==0 && p1.getSpeed()>0)
		{
			l1.incX(1);
			l2.incX(1);
		}
		if(l1.getX() <= -640)
		{
			l1.setX(640);
		}
		if(l2.getX() <= -640)
		{
			l2.setX(640);
		}
	}

	private void renderLayer2()
	{
		batch.draw(palazzi1,b1.getX(),0);
		batch.draw(palazzi2,b2.getX(),0);

		//b1.incX((int) (p1.getSpeed()/8));
		//b2.incX((int) (p1.getSpeed()/8));

		if(frame%(movimento*movimento)==0 && p1.getSpeed()>0)
		{
			b1.incX(1);
			b2.incX(1);
		}
		if(b1.getX() <= -640)
		{
			b1.setX(640);
		}
		if(b2.getX() <= -640)
		{
			b2.setX(640);
		}
	}

	private void renderLayer3()
	{
		batch.draw(montagna1,c1.getX(),0);
		batch.draw(montagna2,c2.getX(),0);

		//c1.incX((int) p1.getSpeed()/16);
		//c2.incX((int) p1.getSpeed()/16);

		if(c1.getX() <= -640)
		{
			c1.setX(640 +c2.getX());
		}
		if(c2.getX() <= -640)
		{
			c2.setX(640 +l2.getX());
		}
	}

	private void renderLayer4()
	{
		batch.draw(stelle1,d1.getX(),0);
		batch.draw(stelle1,d2.getX(),0);

		if(frame%60==0)
		{
			d1.incX(1);
			d2.incX(1);
		}
		if(d1.getX() <= -640)
		{
			d1.setX(640 + d2.getX());
		}
		if(d2.getX() <= -640)
		{
			d2.setX(640 + d1.getX());
		}
	}

	private void
	paintAll()
	{
		batch.draw(img, 0, 0);

		renderLayer4();
		renderLayer3();
		renderLayer2();
		renderLayer1();
		renderStrada();

		font.draw(batch, ""+p1.getSpeed() ,10,350);
		cronometro.draw(batch,tempoTrascorso/1000+ "s",300,350);
		parole.draw(batch,"Parole: "+(paroleContate),550,350);

		batch.draw(player,p1.getX(),p1.getY());
		printWord();
		if(frame%15 == 0)
			if(p1.getSpeed()<10)
				p1.slowDown(1);
			else p1.slowDown((int) (p1.getSpeed()/10));
	}

	public void keyListener() {
		if(Gdx.input.isKeyPressed(currentChar-68))
		{
			currentChar =  Lettera.formatta(currentChar);
			if(indexOfchar < parola.length()-1)
			{
				indexOfchar++;
				currentChar = parola.charAt(indexOfchar);

				if(tempoInizio == 0) tempoInizio = System.currentTimeMillis();
				p1.accelerate(3);
			}
			else
			{
				paroleContate++;
				indexOfchar = 0;
				parola = WordsDictionary.getSingleWord();
				currentChar = parola.charAt(indexOfchar);
			}
		}
	}

	private void printWord()
	{
		for(int i = 0; i < parola.length();i++)
		{
			Lettera x = new Lettera(parola.charAt(i));
			x.loadImage();
			batch.draw(x.getImage(),x.getX()+(i*15),x.getY());
		}
		Lettera curr = new Lettera(currentChar);
		curr.loadImage();
		batch.draw(curr.getImage(),250+(indexOfchar*15),280);
	}
}

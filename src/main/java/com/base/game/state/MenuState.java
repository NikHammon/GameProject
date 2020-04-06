package com.base.game.state;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.base.game.Assets;
import com.base.game.Handler;
import com.base.game.Selector;

public class MenuState extends State {
	private State state;
	private Fading fading;
	private Selector selectorBox;

	private enum State {TITLE_SCREEN, LOAD_SELECTION, START_GAME, GAME_STATE}
	private enum Fading {FADING_IN, FADING_OUT, STABLE}

	public MenuState(Handler handler) {
		super(handler);
		state = State.TITLE_SCREEN;
		fading = Fading.STABLE;
		selectorBox = new Selector(handler.getGame().getWidth() - 60, handler.getGame().getHeight() - 60, 45, 45);
	}
	
	State nextState = null;
	int selector, fileNum;

	private void fadeOutOfState(State toState) {
		effects.fade(1);
		selectorBox.setHide(true);
		fading = Fading.FADING_OUT;
		nextState = toState;
	}

	private void fadeIntoState(State toState) {
		if(toState == State.LOAD_SELECTION)
			selectorBox.setAll(new Rectangle(handler.getWidth()/2 - 350, handler.getHeight()/8, 700, 150));
		else if(toState == State.START_GAME)
			selectorBox.setAll(new Rectangle(handler.getGame().getWidth()/2 - 450, 400, 400, 100));
		else if(toState == State.TITLE_SCREEN)
			selectorBox.setAll(new Rectangle(handler.getGame().getWidth() - 60, handler.getGame().getHeight() - 60, 45, 45));
		else if(toState == State.GAME_STATE)
			handler.getGame().startGame(fileNum);

		state = toState;
		selector = 0;
		selectorBox.setHide(false);
		effects.fade(0);
	}

	@Override public void update() {
		selectorBox.update();

		if(fading == Fading.FADING_OUT) {
			if(effects.getAlpha() >= 1) {
				fadeIntoState(nextState);
			}
			alpha += alphaRate;
		}
		else if(fading == Fading.FADING_IN) {
			if(effects.getAlpha() <= 0) {
				fading = Fading.STABLE;
			}
			alpha -= alphaRate;
		}

		if(state == State.TITLE_SCREEN && handler.getInput().a) {
			fadeOutOfState(State.LOAD_SELECTION);
		}
		else if(state == State.LOAD_SELECTION) {
			if(handler.getInput().a) {
				fileNum = selector;
				fadeOutOfState(State.START_GAME);
			}
			if(handler.getInput().d)
				fadeOutOfState(State.TITLE_SCREEN);
			if(handler.getInput().upPressed) {
				selector = (selector > 0) ? selector - 1 : 2;
				selectorBox.setY(handler.getHeight()/8 + 150 * selector);
			}
			if(handler.getInput().downPressed) {
				selector = (selector < 2) ? selector + 1 : 0;
				selectorBox.setY(handler.getHeight()/8 + 150 * selector);
			}
		}
		else if(state == State.START_GAME) {
			if(handler.getInput().a) {
				if(effects.isActiveDBox()) {
					if(effects.getdBox().answer()) {
						handler.getGame().getUserData(fileNum).setFile(false);
						fadeOutOfState(State.TITLE_SCREEN);
					}
				}
				else if(selector == 0) {
					nextState = State.GAME_STATE;
					selectorBox.setHide(true);
					effects.fade(1);
				}
				else
					effects.displayDialog(1);
			}
			else if(handler.getInput().d) {
				if(effects.isActiveDBox())
					effects.getdBox().answer();
				else
					fadeOutOfState(State.LOAD_SELECTION);
			}
			if(handler.getInput().leftPressed) {
				selector = (selector > 0) ? selector - 1 : 2;
				selectorBox.setX(handler.getGame().getWidth() / 2 - 450 + (400 * selector));
				selectorBox.setWidth(selector == 2 ? 100 : 400);
			}
			if(handler.getInput().rightPressed) {
				selector = (selector < 2) ? selector + 1 : 0;
				selectorBox.setX(handler.getGame().getWidth() / 2 - 450 + (400 * selector));
				selectorBox.setWidth(selector == 2 ? 100 : 400);
			}
		}
	}

	String text;
	float alpha = .1f, alphaRate = .02f;

	@Override public void render(Graphics g) {
		if(state == State.TITLE_SCREEN) {
			g.drawImage(Assets.titleScreen, 0, 0, handler.getWidth(), handler.getHeight(), null);
			g.drawImage(Assets.aKey, handler.getGame().getWidth() - 60, handler.getGame().getHeight() - 60, null);
		}
		else if(state == State.LOAD_SELECTION) {
			g.drawImage(Assets.titleScreenBG, 0, 0, handler.getWidth(), handler.getHeight(), null);
			
			//Utils.drawFadedImage(g, alpha, Assets.selector700x150, handler.getWidth()/2 - 350, handler.getHeight()/8 + selector * 150, 700, 150);
			for(int i = 0; i < handler.getGame().SAVE_FILE_COUNT; ++i)
				g.drawImage(Assets.box700x150, handler.getWidth()/2 - 340 - 10*(selector==i?1:0), handler.getHeight()/8 + (150*i)+10 - 10*(selector==i?1:0), 680+20*(selector==i?1:0), 130+20*(selector==i?1:0), null);

			for(int i = 0; i < Assets.menuNumbers.length; ++i)
				g.drawImage(Assets.menuNumbers[i], handler.getWidth()/2 - 330, handler.getHeight()/8 + 15 + 150*i, null);

			g.setColor(Color.WHITE);
			g.setFont(new Font(handler.getGame().font, Font.BOLD, 30));
			
			for(int i = 0; i < handler.getGame().SAVE_FILE_COUNT; i++) {
				if(handler.getGame().getUserData(i).isFile()) {
					g.setFont(new Font(handler.getGame().font, Font.BOLD, 30));
					Effects.drawStringWithShadow(g, "FILE " + Integer.toString(i + 1), Color.WHITE, 300, handler.getHeight()/8 + 70 + i * 150);
					
					for(int a = 0; a < handler.getGame().getUserData(i).getTotalHeartCrystals(); a++) {
						if(a < handler.getGame().getUserData(i).getActiveHeartCrystals())
							g.drawImage(Assets.heartCrystal, 620 + a *17, handler.getHeight()/8 + 47 + i * 150, null);
						else
							g.drawImage(Assets.usedHeartCrystal, 620 + a *17, handler.getHeight()/8 + 47 + i * 150, null);
					}
					
					g.drawLine(300, handler.getHeight()/8 + 75 + i * 150, 800, handler.getHeight()/8 + 75 + i * 150);
					
					g.setFont(new Font(handler.getGame().font, Font.BOLD, 15));
					Effects.drawStringWithShadow(g, String.format("Total play time %34s", handler.getGame().getUserData(i).getTotalPlayTime()), new Color(134, 211, 61),370, handler.getHeight()/8 + 90 + i * 150);
				}
				else {
					text = "NEW FILE";
					g.setFont(new Font(handler.getGame().font, Font.BOLD, 30));
					Effects.drawStringWithShadow(g, text, Color.WHITE, (handler.getWidth() - g.getFontMetrics().stringWidth(text))/2 - 2, handler.getHeight()/8 + 95 + i * 150);
				}
			}
			
			
		}
		else if(state == State.START_GAME) {
			g.drawImage(Assets.titleScreenBG, 0, 0, handler.getWidth(), handler.getHeight(), null);
			
			g.drawImage(Assets.box700x150, handler.getGame().getWidth()/2 - 350, handler.getHeight()/8, null);
			
			//Utils.drawFadedImage(g, alpha, Assets.selector400x100, handler.getGame().getWidth()/2 - 450 + selector * 400, 400, 400, 100);

			g.drawImage(Assets.box400x100, handler.getGame().getWidth()/2 - 440 - 10*(selector==0?1:0), 410 - 10*(selector==0?1:0), 380 + 20*(selector==0?1:0), 80 + 20*(selector==0?1:0), null);
			g.drawImage(Assets.box400x100, handler.getGame().getWidth()/2 - 40  - 10*(selector==1?1:0), 410 - 10*(selector==1?1:0), 380 + 20*(selector==1?1:0), 80 + 20*(selector==1?1:0), null);
			g.drawImage(Assets.box100x100, handler.getGame().getWidth()/2 + 360 - 10*(selector==2?1:0), 410 - 10*(selector==2?1:0), 80 + 20*(selector==2?1:0), 80+ 20*(selector==2?1:0), null);

			g.drawImage(Assets.menuNumbers[fileNum], handler.getWidth()/2 - 330, handler.getHeight()/8 + 15, null);
			
			if(handler.getGame().getUserData(fileNum).isFile()) {
				g.setFont(new Font(handler.getGame().font, Font.BOLD, 30));
				Effects.drawStringWithShadow(g,"FILE " + Integer.toString(fileNum + 1), Color.WHITE,300, handler.getHeight()/8 + 70 );
				for(int a = 0; a < handler.getGame().getUserData(fileNum).getTotalHeartCrystals(); a++) {
					if(a < handler.getGame().getUserData(fileNum).getActiveHeartCrystals())
						g.drawImage(Assets.heartCrystal, 620 + a *17, handler.getHeight()/8 + 47, null);
					else
						g.drawImage(Assets.usedHeartCrystal, 620 + a *17, handler.getHeight()/8 + 47, null);
				}
				
				g.drawLine(300, handler.getHeight()/8 + 75, 800, handler.getHeight()/8 + 75);
				
				g.setFont(new Font(handler.getGame().font, Font.BOLD, 15));
				Effects.drawStringWithShadow(g, String.format("Total play time %34s", handler.getGame().getUserData(fileNum).getTotalPlayTime()), new Color(134, 211, 61), 370, handler.getHeight()/8 + 90);
			}
			else {
				text = "NEW FILE";
				g.setFont(new Font(handler.getGame().font, Font.BOLD, 30));
				Effects.drawStringWithShadow(g, text, Color.WHITE, (handler.getWidth() - g.getFontMetrics().stringWidth(text))/2 - 2, handler.getHeight()/8 + 95);
			}
			
			g.setFont(new Font(handler.getGame().font, Font.BOLD, 40));
			Effects.drawStringWithShadow(g, "START", Color.WHITE, handler.getGame().getWidth()/2 - 327, 465);
			Effects.drawStringWithShadow(g, "ERASE", Color.WHITE, handler.getGame().getWidth()/2 + 90, 465);
			g.drawImage(Assets.settingsIcon, handler.getGame().getWidth()/2 + 350, 400, null);
		}
		
		selectorBox.render(g);
		effects.render(g);
	}

}

package com.base.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

public class DialogBox {
	private Handler handler;
	private Selector selectorBox;

	private String text;
	private String[] availableText;
	private String speaker;
	private int scriptNum;
	private boolean nextAvailable;
	private boolean isComplete;

	public DialogBox(Handler handler) {
		this.handler = handler;
		selectorBox = new Selector(0, 0, 0, 0);
		text = "";
		speaker = "";
		availableText = new String[4];
		clearText();// because null Strings are no goood
	}

	public void setScriptNum(int scriptNum) {
		this.scriptNum = scriptNum;
		if (scriptNum == 3
				&& !handler.getGame().getGameState().getLevelManager().getBaseCamp().getEvents().get(0).isRunning())// wht
																													// the
																													// helllllll
		{

		} else
			text = Utils.readScript(Integer.toString(scriptNum));
	}

	float arrowPos = 5;
	float arrowRate = 0.25f;
	float arrowStart = arrowPos;
	float arrowEnd = arrowPos + 5;

	int index;
	int textLine;

	boolean refresh, questionBox, selector;

	StringBuilder sb = new StringBuilder();

	public void update() {

		if (nextAvailable) {
			if (!questionBox) {
				if (arrowPos < arrowStart || arrowPos > arrowEnd)
					arrowRate = -arrowRate;

				arrowPos += arrowRate;
			} else {
				if (handler.getInput().upPressed || handler.getInput().downPressed)
					selector = !selector;

				if (selector)
					selectorBox.setAll(
							new Rectangle(handler.getWidth() - 205, handler.getGame().getHeight() - 405, 200, 100));
				else
					selectorBox.setAll(
							new Rectangle(handler.getWidth() - 205, handler.getGame().getHeight() - 305, 200, 100));

				selectorBox.update();
			}

		} else {
			if (index == 0 && textLine == 0 && speaker != "" && !isComplete)
				availableText[textLine] = sb.append(speaker + ": ").toString();

			if (index >= text.length() && !nextAvailable)
				isComplete = true;
			else if (!nextAvailable && refresh) {
				textLine = 0;
				clearText();
				sb.setLength(0);// clears stringBuilder
				refresh = false;
			} else {
				if (text.charAt(index) == ';') {
					nextAvailable = true;
					refresh = true;
				} else if (text.charAt(index) == '/') {
					speaker = "";
					index++;
					if (text.charAt(index) == '*') {
						speaker = handler.getGame().getPlayer().getName();
						index++;
					} else {
						while (text.charAt(index) != '/') {
							speaker += text.charAt(index);
							index++;
						}
					}

					availableText[textLine] = sb.append(speaker + ": ").toString();
				} else if (text.charAt(index) == ':') {
					sb.setLength(0);// clears stringBuilder
					textLine++;
					index++;
				} else if (text.charAt(index) == '~') {
					nextAvailable = true;
					refresh = true;
					questionBox = true;
				} else if (text.charAt(index) == '*') {
					availableText[textLine] = sb.append(handler.getGame().getPlayer().getName()).toString();
				} else {
					availableText[textLine] = sb.append(text.charAt(index)).toString();
				}

				index++;

			}
		}

		if (nextAvailable && (handler.getInput().a || handler.getInput().d) && !questionBox) {
			speaker = "";
			nextAvailable = false;
		}
	}

	public boolean answer() {
		selectorBox.setWidth(0);
		questionBox = false;
		nextAvailable = false;
		return selector;
	}

	public void clearText() {
		for (int i = 0; i < availableText.length; i++)
			availableText[i] = "";
	}

	public void reset() {
		sb.setLength(0);// clears stringBuilder
		availableText[0] = "";
		isComplete = false;
		index = 0;
	}

	public void render(Graphics g) {
		renderCharacter(g);
		g.drawImage(Assets.dialogBox, 0, handler.getGame().getHeight() - 200, handler.getWidth(), 200, null);

		if (nextAvailable) {
			if (!questionBox)
				g.drawImage(Assets.dialogArrow, handler.getGame().getWidth() / 2 - 12,
						(int) (handler.getGame().getHeight() - 30 + arrowPos), 24, 24, null);
			else {
				// g.drawImage(Assets.selector200x100, handler.getWidth()-205,
				// handler.getGame().getHeight() - 405 + (selector? 0:100), null);
				g.drawImage(Assets.box200x100, handler.getWidth() - 205, handler.getGame().getHeight() - 405, null);
				g.drawImage(Assets.box200x100, handler.getWidth() - 205, handler.getGame().getHeight() - 305, null);

				g.setColor(Color.WHITE);
				g.setFont(new Font("American Typewriter", Font.BOLD, 30));

				g.drawString("YES", handler.getWidth() - 130, handler.getGame().getHeight() - 340);
				g.drawString("NO", handler.getWidth() - 125, handler.getGame().getHeight() - 240);

				selectorBox.render(g);
			}
		}

		g.setColor(Color.WHITE);
		g.setFont(new Font("American Typewriter", Font.BOLD, 20));

		for (int i = 0; i < availableText.length; i++)
			g.drawString(availableText[i], 30, handler.getGame().getHeight() - 150 + i * 30);

	}

	public void renderCharacter(Graphics g) {
		if (speaker.equals(handler.getGame().getPlayer().getName())) {
			g.drawImage(Assets.chars[0], handler.getWidth() - 300, handler.getHeight() - 495, null);
		} else {
			switch (speaker) {
				case "DRACE":
					g.drawImage(Assets.chars[1], handler.getWidth() - 300, handler.getHeight() - 495, null);
					break;
				case "CASSIOPIA":
					if (handler.getBaseCamp().getGameProgress() < 13)
						g.drawImage(Assets.chars[2], handler.getWidth() - 300, handler.getHeight() - 495, null);
					else
						g.drawImage(Assets.chars[10], handler.getWidth() - 300, handler.getHeight() - 495, null);
					break;
				case "SEBASTIAN":
					g.drawImage(Assets.chars[3], handler.getWidth() - 300, handler.getHeight() - 495, null);
					break;
				case "FINEAS":
					g.drawImage(Assets.chars[4], handler.getWidth() - 300, handler.getHeight() - 495, null);
					break;
				case "SERII":
					g.drawImage(Assets.chars[5], handler.getWidth() - 300, handler.getHeight() - 495, null);
					break;
				case "BUDAROTH":
					g.drawImage(Assets.chars[6], handler.getWidth() - 300, handler.getHeight() - 495, null);
					break;
				case "OBIN":
					if (scriptNum == 109)
						g.drawImage(Assets.chars[11], handler.getWidth() - 300, handler.getHeight() - 495, null);
					else
						g.drawImage(Assets.chars[7], handler.getWidth() - 300, handler.getHeight() - 495, null);
					break;
				case "CRAWFORD":
					g.drawImage(Assets.chars[8], handler.getWidth() - 300, handler.getHeight() - 495, null);
					break;
				case "RIGGS":
					g.drawImage(Assets.chars[9], handler.getWidth() - 300, handler.getHeight() - 495, null);
					break;
				case "DOLLFACE":
					if (scriptNum == 109)
						g.drawImage(Assets.chars[12], handler.getWidth() - 300, handler.getHeight() - 495, null);
					else
						g.drawImage(Assets.chars[10], handler.getWidth() - 300, handler.getHeight() - 495, null);
					break;
				case "RUBEL":
					g.drawImage(Assets.chars[13], handler.getWidth() - 300, handler.getHeight() - 495, null);
					break;
				case "FAIRY":
					g.drawImage(Assets.chars[14], handler.getWidth() - 300, handler.getHeight() - 495, null);
					break;
				case "SHADOW CHILDREN":
					g.drawImage(Assets.chars[15], handler.getWidth() - 300, handler.getHeight() - 495, null);
					break;
				case "????":
					if (scriptNum == 71)
						g.drawImage(Assets.chars[8], handler.getWidth() - 300, handler.getHeight() - 495, null);
					else if (scriptNum == 90 || scriptNum == 91)
						g.drawImage(Assets.chars[6], handler.getWidth() - 300, handler.getHeight() - 495, null);
					else if (scriptNum == 114)
						g.drawImage(Assets.chars[13], handler.getWidth() - 300, handler.getHeight() - 495, null);
					else if (scriptNum == 129)
						g.drawImage(Assets.chars[15], handler.getWidth() - 300, handler.getHeight() - 495, null);
			}
		}
	}

	public boolean isNextAvailible() {
		return nextAvailable;
	}

	public void setNextAvailible(boolean nextAvailible) {
		this.nextAvailable = nextAvailible;
	}

	public boolean isComplete() {
		return isComplete;
	}

	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}

	public String getSpeaker() {
		return speaker;
	}

	public void setSpeaker(String speaker) {
		this.speaker = speaker;
	}

}

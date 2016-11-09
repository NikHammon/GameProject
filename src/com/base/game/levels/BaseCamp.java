package com.base.game.levels;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;
import com.base.game.entity.Entity;
import com.base.game.entity.EntityManager;
import com.base.game.entity.Player;
import com.base.game.entity.eventEntity.BlackSmith;
import com.base.game.entity.eventEntity.ShopKeeper;
import com.base.game.entity.eventEntity.SpecialDoor;
import com.base.game.entity.eventEntity.Storage;
import com.base.game.entity.eventEntity.NPC.Boy;
import com.base.game.entity.eventEntity.NPC.Cassiopia;
import com.base.game.entity.eventEntity.NPC.CrawfordNPC;
import com.base.game.entity.eventEntity.NPC.Drace;
import com.base.game.entity.eventEntity.NPC.Fineas;
import com.base.game.entity.eventEntity.NPC.Girl;
import com.base.game.entity.eventEntity.NPC.Ken;
import com.base.game.entity.eventEntity.NPC.NPC;
import com.base.game.entity.eventEntity.NPC.NPC12;
import com.base.game.entity.eventEntity.NPC.NPC13;
import com.base.game.entity.eventEntity.NPC.NPC14;
import com.base.game.entity.eventEntity.NPC.NPC15;
import com.base.game.entity.eventEntity.NPC.NPC16;
import com.base.game.entity.eventEntity.NPC.NPC17;
import com.base.game.entity.eventEntity.NPC.Obin;
import com.base.game.entity.eventEntity.NPC.OldMan;
import com.base.game.entity.eventEntity.NPC.RiggsNPC;
import com.base.game.entity.eventEntity.NPC.RoyalGuard;
import com.base.game.entity.eventEntity.NPC.Rubel;
import com.base.game.entity.eventEntity.NPC.Sebastian;
import com.base.game.entity.eventEntity.NPC.Serii;
import com.base.game.entity.eventEntity.NPC.Woman;
import com.base.game.entity.monsters.Bat;
import com.base.game.entity.monsters.Beetle;
import com.base.game.entity.monsters.DarkMagi;
import com.base.game.entity.monsters.FlyingTurtle;
import com.base.game.entity.monsters.Goblin;
import com.base.game.entity.monsters.Gremlin;
import com.base.game.entity.monsters.LgtMagi;
import com.base.game.entity.monsters.LightKnight;
import com.base.game.entity.monsters.Millipede;
import com.base.game.entity.monsters.Slime;
import com.base.game.entity.monsters.Snake;
import com.base.game.entity.monsters.Spider;
import com.base.game.entity.monsters.Wolf;
import com.base.game.entity.staticEntity.Barrier;
import com.base.game.entity.staticEntity.Crate;
import com.base.game.entity.staticEntity.Door;
import com.base.game.event.Event;
import com.base.game.event.Event1;
import com.base.game.event.Event10;
import com.base.game.event.Event11;
import com.base.game.event.Event12;
import com.base.game.event.Event13;
import com.base.game.event.Event14;
import com.base.game.event.Event15;
import com.base.game.event.Event16;
import com.base.game.event.Event17;
import com.base.game.event.Event18;
import com.base.game.event.Event19;
import com.base.game.event.Event2;
import com.base.game.event.Event3;
import com.base.game.event.Event4;
import com.base.game.event.Event5;
import com.base.game.event.Event6;
import com.base.game.event.Event7;
import com.base.game.event.Event8;
import com.base.game.event.Event9;
import com.base.game.tiles.Tile;

public class BaseCamp 
{
	private Handler handler;
	private EntityManager eManager;
	private QuestBoard qBoard;
	private ShopKeeper sKeeper;
	private BlackSmith bSmith;
	private Storage myStorage;
	
	private Rectangle specialDoor, questBoard, shopKeeper, blackSmith, storage, bed, mainAreaToConnector, castleAreaToConnector, connectorToCastleArea, connectorToMainArea, bedroomToMainArea;
	
	private Door houseDoor;
	
	private ArrayList<Event> events;
	
	private Animation currentLocation;
	private int currentWidth, currentHeight;
	
	private String state, nextArea;
	
	private boolean[] chestsOpened;
	private int gameProgress, dungeonsUnlocked, dungeonsCleared, questsCompleted, questTracker = -1;
	private boolean activeShopKeeper, activebSmith, activeBoat, isEventRunning, bedActive;
	int boatX;
	boolean storing, sleeping;
	
	public BaseCamp(Handler handler)
	{
		this.handler = handler;	
		eManager = new EntityManager(handler, new Player(handler));
		
		qBoard = new QuestBoard(handler);
		sKeeper = new ShopKeeper(handler);
		bSmith = new BlackSmith(handler);
		myStorage = new Storage(handler);
		currentLocation = new Animation(200, Assets.baseCamp, 0);
		
		specialDoor = new Rectangle(856, 2687, 60, 64);
		questBoard = new Rectangle(480, 1800, 80, 40);
		shopKeeper = new Rectangle(1060, 1660, 64, 56);
		blackSmith = new Rectangle(1220, 1660, 64, 56);
		mainAreaToConnector = new Rectangle(-100, 1050, 102, 264);
		castleAreaToConnector = new Rectangle(738, 1458, 190, 2);
		connectorToCastleArea = new Rectangle(640, -102, 310, 102);
		connectorToMainArea = new Rectangle(1798, 370, 102, 290);
		bedroomToMainArea = new Rectangle(490, 780, 152, 102);
		houseDoor = new Door(handler, 576, 1602, 0, "BEDROOM");
		storage = new Rectangle(620, 360, 46, 72);
		bed = new Rectangle(248, 244, 64, 64);
		chestsOpened = new boolean[8];

		events = new ArrayList<Event>();
		events.add(new Event1(handler));
		events.add(new Event2(handler));
		events.add(new Event3(handler));
		events.add(new Event4(handler));
		events.add(new Event5(handler));
		events.add(new Event6(handler));
		events.add(new Event7(handler));
		events.add(new Event8(handler));
		events.add(new Event9(handler));
		events.add(new Event10(handler));
		events.add(new Event11(handler));
		events.add(new Event12(handler));
		events.add(new Event13(handler));
		events.add(new Event14(handler));
		events.add(new Event15(handler));
		events.add(new Event16(handler));
		events.add(new Event17(handler));
		events.add(new Event18(handler));
		events.add(new Event19(handler));
		
	}
	
	Iterator<Entity> itr;
	public void update()
	{
		
		if(state == "MAINAREA" && !isEventRunning)//try with event running
		{		
			if(handler.getGame().getPlayer().getCollisionBounds(0, 0).intersects(specialDoor) && handler.getGame().getPlayer().getState() != "FORCEMOVE" && gameProgress > 2)
			{	
				state = "TOSAIL";
				handler.getGame().getGameState().getEffects().displayDialog(20);
				handler.getGame().getPlayer().setPaused(true);
				
			}	
			else if(handler.getGame().getPlayer().getCollisionBounds(0, 0).intersects(questBoard) && handler.getInput().a && (handler.getGame().getPlayer().getDirection() == 0 || handler.getGame().getPlayer().getDirection() == 7 || handler.getGame().getPlayer().getDirection() == 1))
			{	
				if(qBoard.getQuests().isEmpty())
				{
					handler.getGame().getGameState().getEffects().displayDialog(158);
				}
				else
				{
					state = "QUESTSELECT";	
					handler.getGame().getPlayer().setPaused(true);
					handler.getGame().getGameState().getLevelManager().getpInterface().setActive(false);
				}
			}
			else if(activeShopKeeper && handler.getGame().getPlayer().getCollisionBounds(0, 0).intersects(shopKeeper) && handler.getInput().a && (handler.getGame().getPlayer().getDirection() == 0 || handler.getGame().getPlayer().getDirection() == 7 || handler.getGame().getPlayer().getDirection() == 1))
			{		
				state = "SHOPKEEPER";
				handler.getGame().getPlayer().setPaused(true);
			}
			else if(activebSmith && handler.getGame().getPlayer().getCollisionBounds(0, 0).intersects(blackSmith) && handler.getInput().a && (handler.getGame().getPlayer().getDirection() == 0 || handler.getGame().getPlayer().getDirection() == 7 || handler.getGame().getPlayer().getDirection() == 1))
			{		
				state = "BLACKSMITH";
				handler.getGame().getPlayer().setPaused(true);
			}
			else if(nextArea != "CONNECTOR" && handler.getGame().getPlayer().getCollisionBounds(0, 0).intersects(mainAreaToConnector) && handler.getGame().getPlayer().getState() != "FORCEMOVE")
			{		
				handler.getGame().getGameState().getEffects().fade(1);
				handler.getGame().getPlayer().setForceMove("LEFT");
				nextArea = "CONNECTOR";
			}
			else if(nextArea == "CONNECTOR" && handler.getGame().getGameState().getEffects().getAlpha() == 1)
			{
				handler.getGame().getGameState().getEffects().fade(0);
				handler.getGame().getPlayer().setX(1820);
				handler.getGame().getPlayer().setY(470);
				handler.getGame().getPlayer().setForceMove("LEFT", "LEFT");
				state = "CONNECTOR";
				setNPCs();
				setBarriers();
				nextArea = "";
				
			}
			else if(nextArea == "BEDROOM" && handler.getGame().getGameState().getEffects().getAlpha() == 1)
			{
				handler.getGame().getGameState().getEffects().fade(0);
				handler.getGame().getPlayer().setX(530);
				handler.getGame().getPlayer().setY(780);
				handler.getGame().getPlayer().setForceMove("UP", "UP");
				state = "BEDROOM";
				setNPCs();
				setBarriers();
				nextArea = "";
				
			}			
				
		}
		else if(state == "CONNECTOR" && !isEventRunning)
		{
			if(nextArea != "MAINAREA" && handler.getGame().getPlayer().getCollisionBounds(0, 0).intersects(connectorToMainArea) && handler.getGame().getPlayer().getState() != "FORCEMOVE")
			{		
				handler.getGame().getGameState().getEffects().fade(1);
				handler.getGame().getPlayer().setForceMove("RIGHT");
				nextArea = "MAINAREA";
			}
			else if(nextArea == "MAINAREA" && handler.getGame().getGameState().getEffects().getAlpha() == 1)
			{
				handler.getGame().getGameState().getEffects().fade(0);
				handler.getGame().getPlayer().setX(-20);
				handler.getGame().getPlayer().setY(1150);
				handler.getGame().getPlayer().setForceMove("RIGHT", "RIGHT");
				state = "MAINAREA";
				setNPCs();
				setBarriers();
				nextArea = "";
			}
			else if(nextArea != "CASTLEAREA" && handler.getGame().getPlayer().getCollisionBounds(0, 0).intersects(connectorToCastleArea) && handler.getGame().getPlayer().getState() != "FORCEMOVE")
			{		
				handler.getGame().getGameState().getEffects().fade(1);
				handler.getGame().getPlayer().setForceMove("UP");
				nextArea = "CASTLEAREA";
			}
			else if(nextArea == "CASTLEAREA" && handler.getGame().getGameState().getEffects().getAlpha() == 1)
			{
				handler.getGame().getGameState().getEffects().fade(0);
				handler.getGame().getPlayer().setX(800);
				handler.getGame().getPlayer().setY(1430);
				handler.getGame().getPlayer().setForceMove("UP");
				state = "CASTLEAREA";
				setNPCs();
				setBarriers();
				nextArea = "";
				
			}
		}
		else if(state == "CASTLEAREA" && !isEventRunning)
		{
			if(nextArea != "CONNECTOR" && handler.getGame().getPlayer().getCollisionBounds(0, 0).intersects(castleAreaToConnector) && handler.getGame().getPlayer().getState() != "FORCEMOVE")
			{		
				handler.getGame().getGameState().getEffects().fade(1);
				handler.getGame().getPlayer().setForceMove("DOWN");
				nextArea = "CONNECTOR";
			}
			else if(nextArea == "CONNECTOR" && handler.getGame().getGameState().getEffects().getAlpha() == 1)
			{
				handler.getGame().getGameState().getEffects().fade(0);
				handler.getGame().getPlayer().setX(760);
				handler.getGame().getPlayer().setY(-20);
				handler.getGame().getPlayer().setForceMove("DOWN", "DOWN");
				state = "CONNECTOR";
				setNPCs();
				setBarriers();
				nextArea = "";
			}
		}
		else if(state == "BEDROOM" && !isEventRunning)
		{
			
			if(handler.getGame().getPlayer().getCollisionBounds(0, 0).intersects(storage) && handler.getInput().a && (handler.getGame().getPlayer().getDirection() == 5 || handler.getGame().getPlayer().getDirection() == 6 || handler.getGame().getPlayer().getDirection() == 7))
			{		
				storing = true;
				handler.getGame().getGameState().getLevelManager().getpInterface().setActive(false);
				handler.getGame().getPlayer().setPaused(true);
			}
			if(handler.getGame().getPlayer().getCollisionBounds(0, 0).intersects(bed) && bedActive)
			{	
				if(handler.getGame().getGameState().getEffects().getAlpha() == 0)
				{
					state = "TOSAVE";
					bedActive = false;
					handler.getGame().getGameState().getEffects().displayDialog(280);
				}
			
				handler.getGame().getPlayer().setPaused(true);	
			}
			if(!handler.getGame().getPlayer().getCollisionBounds(0, 0).intersects(bed) && !bedActive)
			{	
				bedActive = true;
			}
			
			if(nextArea != "MAINAREA" && handler.getGame().getPlayer().getCollisionBounds(0, 0).intersects(bedroomToMainArea) && handler.getGame().getPlayer().getState() != "FORCEMOVE")
			{		
				handler.getGame().getGameState().getEffects().fade(1);
				handler.getGame().getPlayer().setForceMove("DOWN", "DOWN");
				nextArea = "MAINAREA";
			}
			else if(nextArea == "MAINAREA" && handler.getGame().getGameState().getEffects().getAlpha() == 1)
			{
				handler.getGame().getGameState().getEffects().fade(0);
				
				handler.getGame().getPlayer().setX(576);
				handler.getGame().getPlayer().setY(1664);
				handler.getGame().getPlayer().setForceMove("DOWN");
				houseDoor.setState("CLOSING");
				state = "MAINAREA";
				setNPCs();
				setBarriers();
				nextArea = "";
			}			
			if(storing)
				myStorage.update();
		}
		else if(state == "DUNGEONSELECT" && handler.getGame().getGameState().getEffects().getAlpha() == 1)
		{
			handler.getGame().getGameState().getEffects().fade(0);
			handler.getGame().getGameState().getLevelManager().getWorldMap().setActive(true);
		}
		else if(state == "SAVING" && handler.getGame().getGameState().getEffects().getAlpha() == 1)
		{
			handler.getGame().getGameState().getEffects().fade(0);
			handler.getGame().getGameState().getEffects().displayDialog(281);
			state = "BEDROOM";
		}
		else if(state == "QUESTSELECT")
		{
			qBoard.update();
			
			if(handler.getInput().d)
			{
				state = "MAINAREA";
				handler.getGame().getPlayer().setPaused(false);
				handler.getGame().getGameState().getLevelManager().getpInterface().setActive(true);
			}
		}
		else if(state == "SHOPKEEPER")
		{
			sKeeper.update();
		}
		else if(state == "BLACKSMITH")
		{
			bSmith.update();
		}
		else if(state == "TOSAIL" && handler.getGame().getGameState().getEffects().getdBox().isNextAvailible())
		{
			if(handler.getInput().a)
			{
				if(handler.getGame().getGameState().getEffects().getdBox().answer())
				{
					handler.getGame().getPlayer().setPaused(false);
					boatX = 0;
					
					handler.getGame().getGameState().getEffects().fade(1);
					state = "DUNGEONSELECT";
				}
				else
				{
					handler.getGame().getPlayer().setPaused(false);
					handler.getGame().getPlayer().setForceMove("UP", "UP");
					state = "MAINAREA";
				}
			}
			else if(handler.getInput().d)
			{
				handler.getGame().getGameState().getEffects().getdBox().answer();
				handler.getGame().getPlayer().setPaused(false);
				handler.getGame().getPlayer().setForceMove("UP", "UP");
				state = "MAINAREA";
			}
		}
		else if(state == "TOSAVE" && handler.getGame().getGameState().getEffects().getdBox().isNextAvailible())
		{
			if(handler.getInput().a)
			{
				if(handler.getGame().getGameState().getEffects().getdBox().answer())
				{
					handler.getGame().getPlayer().setPaused(false);
					handler.getGame().getGameState().getEffects().fade(1);
					handler.getGame().saveState();
					state = "SAVING";
				}
				else
				{
					handler.getGame().getPlayer().setPaused(false);					
					state = "BEDROOM";
				}
			}
			else if(handler.getInput().d)
			{
				handler.getGame().getGameState().getEffects().getdBox().answer();
				handler.getGame().getPlayer().setPaused(false);
				state = "BEDROOM";
			}
		}
		
		
		houseDoor.update();
		eManager.update();
		currentLocation.update();
	}
	
	
	
	public void setNPCs()
	{
		if(gameProgress >= 2 && gameProgress != 20 && gameProgress != 21 && gameProgress != 22)
			activeShopKeeper = true;
		if(gameProgress >= 4)
			activebSmith = true;
		
		itr = eManager.getEntities().iterator();
		while(itr.hasNext())
		{
			Entity e = itr.next();
			if(e instanceof NPC)
			{
				eManager.removeEntity(e);
			}
		}
		
		OldMan abraham = new OldMan(handler, 1740, 2000, 0);
		Boy bean = new Boy(handler, 314, 2174, 0);
		Girl jane = new Girl(handler, 680, 266, 0);
		Woman erika = new Woman(handler, 2080, 328, 0);
		NPC17 clarabel = new NPC17(handler, 512, 970, 0);
		Ken ken = new Ken(handler, 1240, 928, 0);
		NPC12 garrison = new NPC12(handler, 1278, 2352, 0);
		NPC13 shane = new NPC13(handler, 1410, 1574, 0);
		NPC14 felicity = new NPC14(handler, 2666, 2132, 0);
		NPC15 victor = new NPC15(handler, 1520, 1752, 0);
		NPC16 miranda = new NPC16(handler, 1852, 2256, 0);
		Sebastian sebastian = new Sebastian(handler, 460, 1820, 0);
		Serii serii = new Serii(handler, 1250, 1880, 0);
		Rubel rubel = new Rubel(handler, 1400, 1800, 0);
		RoyalGuard guard1 = new RoyalGuard(handler, 620, 950, 0);
		RoyalGuard guard2 = new RoyalGuard(handler, 980, 950, 0);
		Drace drace = new Drace(handler, 448, 1220, 0);
		Obin obin = new Obin(handler, 400, 1140, 0);
		Cassiopia cassiopia = new Cassiopia(handler, 352, 1220, 0);
		Fineas fineas = new Fineas(handler, 352, 1220, 0);
		CrawfordNPC crawford = new CrawfordNPC(handler, 2632, 432, 0);
		RiggsNPC riggs = new RiggsNPC(handler, 2746, 312, 0);
		if(state == "MAINAREA")
		{
			if(gameProgress >= 0)
			{
				
				eManager.addEntity(abraham);
				abraham.setScriptNum(164);
				
				eManager.addEntity(bean);
				bean.setScriptNum(165);
				
				eManager.addEntity(jane);
				jane.setScriptNum(166);
				
				eManager.addEntity(erika);
				erika.setScriptNum(167);
			}
			if(gameProgress >= 2)
			{
				eManager.addEntity(clarabel);
			}
			if(gameProgress >= 4)
			{
				
				eManager.addEntity(ken);
				ken.setDirection(4);
				ken.setDoesNotMove(true);
				ken.setScriptNum(171);
				
				eManager.addEntity(garrison);
				garrison.setScriptNum(172);
				
				eManager.addEntity(shane);
				shane.setScriptNum(173);
				
				eManager.addEntity(felicity);
				felicity.setScriptNum(174);
				
				eManager.addEntity(victor);
				victor.setScriptNum(175);
				
				eManager.addEntity(miranda);
				miranda.setScriptNum(176);
				
				clarabel.setScriptNum(177);
				abraham.setScriptNum(178);
				bean.setScriptNum(179);
				jane.setScriptNum(180);
				erika.setScriptNum(181);
			}
			if(gameProgress >= 5)
			{
				eManager.addEntity(sebastian);
				sebastian.setScriptNum(182);
				sebastian.setDoesNotMove(true);
			}
			if(gameProgress >= 8)
			{
				ken.setScriptNum(183);
				garrison.setScriptNum(184);
				shane.setScriptNum(185);
				felicity.setScriptNum(186);
				victor.setScriptNum(187);
				miranda.setScriptNum(188);				
				clarabel.setScriptNum(189);
				abraham.setScriptNum(190);
				bean.setScriptNum(191);
				jane.setScriptNum(192);
				erika.setScriptNum(193);
			}
			if(gameProgress == 8 || gameProgress == 15 || (questTracker != -1 && !events.get(7).isRanOnce()))
			{
				eManager.removeEntity(sebastian);
			}
			
			if(gameProgress >= 11)
			{
				eManager.addEntity(crawford);
				crawford.setCurrentAnimation(crawford.upRgt);
				crawford.setDoesNotMove(true);
				crawford.setScriptNum(208);
				eManager.addEntity(riggs);
				riggs.setCurrentAnimation(riggs.dwnLft);
				riggs.setDoesNotMove(true);
				serii.setX(400);
				serii.setY(1820);
				ken.setScriptNum(195);
				garrison.setScriptNum(196);
				shane.setScriptNum(197);
				felicity.setScriptNum(198);
				victor.setScriptNum(199);
				miranda.setScriptNum(200);				
				clarabel.setScriptNum(201);
				abraham.setScriptNum(202);
				bean.setScriptNum(203);
				jane.setScriptNum(204);
				erika.setScriptNum(205);
				
			}
			if(gameProgress >= 14)
			{
				eManager.addEntity(serii);
				serii.setDirection(5);
				serii.setDoesNotMove(true);
				serii.setScriptNum(209);
				serii.setDirection(2);
				sebastian.setDirection(6);
				ken.setScriptNum(210);
				garrison.setScriptNum(211);
				shane.setScriptNum(212);
				felicity.setScriptNum(213);
				victor.setScriptNum(214);
				miranda.setScriptNum(215);				
				clarabel.setScriptNum(216);
				abraham.setScriptNum(217);
				bean.setScriptNum(218);
				jane.setScriptNum(219);
				erika.setScriptNum(220);
			}
			if(gameProgress >= 17)
			{
				ken.setScriptNum(221);
				garrison.setScriptNum(222);
				shane.setScriptNum(223);
				felicity.setScriptNum(224);
				victor.setScriptNum(225);
				miranda.setScriptNum(226);				
				clarabel.setScriptNum(227);
				abraham.setScriptNum(228);
				bean.setScriptNum(229);
				jane.setScriptNum(230);
				erika.setScriptNum(231);
			}
			if(gameProgress >= 19)
			{
				eManager.addEntity(rubel);
				ken.setScriptNum(232);
				garrison.setScriptNum(233);
				shane.setScriptNum(234);
				felicity.setScriptNum(235);
				victor.setScriptNum(236);
				miranda.setScriptNum(237);				
				clarabel.setScriptNum(238);
				abraham.setScriptNum(239);
				bean.setScriptNum(240);
				jane.setScriptNum(241);
				erika.setScriptNum(242);
			}
				
			if(gameProgress >= 21)
			{
				if(dungeonsUnlocked < 7)
					rubel.setScriptNum(131);
				else
					rubel.setScriptNum(132);
				
				ken.setScriptNum(243);
				garrison.setScriptNum(244);
				shane.setScriptNum(245);
				felicity.setScriptNum(246);
				victor.setScriptNum(247);
				miranda.setScriptNum(248);				
				clarabel.setScriptNum(249);
				abraham.setScriptNum(250);
				bean.setScriptNum(251);
				jane.setScriptNum(252);
				erika.setScriptNum(253);
			}
			
			if(gameProgress >= 24)
			{
				ken.setScriptNum(254);
				garrison.setScriptNum(255);
				shane.setScriptNum(256);
				felicity.setScriptNum(257);
				victor.setScriptNum(258);
				miranda.setScriptNum(259);				
				clarabel.setScriptNum(260);
				abraham.setScriptNum(261);
				bean.setScriptNum(262);
				jane.setScriptNum(263);
				erika.setScriptNum(264);
				rubel.setScriptNum(265);
			}
		}
		else if(state == "CASTLEAREA")
		{
			if(gameProgress >= 0)
			{
				eManager.addEntity(guard1);
				guard1.setDirection(4);
				guard1.setDoesNotMove(true);
				guard1.setScriptNum(168);
				eManager.addEntity(guard2);
				guard2.setDirection(4);
				guard2.setDoesNotMove(true);
				guard2.setScriptNum(169);
			}
			if(gameProgress >= 8)
			{
				eManager.addEntity(drace);
				drace.setDirection(6);
				drace.setDoesNotMove(true);
				drace.setScriptNum(266);
				eManager.addEntity(cassiopia);
				cassiopia.setDirection(2);
				cassiopia.setDoesNotMove(true);
				cassiopia.setScriptNum(267);
			}
			if(gameProgress >= 10)
			{
				drace.setScriptNum(268);
				eManager.addEntity(fineas);
				fineas.setDirection(2);
				fineas.setDoesNotMove(true);
				fineas.setScriptNum(269);
				cassiopia.setX(1242);
				cassiopia.setY(1136);
				cassiopia.setDoesNotMove(false);
				cassiopia.setScriptNum(283);
			}
			if(gameProgress >= 11)
			{
				eManager.removeEntity(cassiopia);
				drace.setScriptNum(270);
				fineas.setScriptNum(271);
			}
			if(gameProgress >= 17)
			{
				drace.setScriptNum(272);
				fineas.setScriptNum(273);
			}
			if(gameProgress >= 19)
			{
				eManager.addEntity(obin);
				obin.setDoesNotMove(true);
				obin.setDirection(4);
				drace.setScriptNum(274);
				fineas.setScriptNum(275);
				obin.setScriptNum(276);
			}	
			if(gameProgress >= 24)
			{
				drace.setScriptNum(277);
				fineas.setScriptNum(278);
				obin.setScriptNum(279);
			}
			if(gameProgress == 14 || gameProgress == 17 ||gameProgress == 23)
			{
				eManager.removeEntity(drace);
				eManager.removeEntity(fineas);
				eManager.removeEntity(obin);
			}
			
		}
		

	}
	
	public void setBarriers()
	{
		itr = eManager.getEntities().iterator();
		while(itr.hasNext())
		{
			Entity e = itr.next();
			if(e instanceof Barrier)
			{
				eManager.removeEntity(e);
			}
		}
		
		if(state == "CONNECTOR")
		{
			eManager.addEntity(new Barrier(handler, 0, 680, 0, 1800, 200));
			eManager.addEntity(new Barrier(handler, 940, 0, 0, 860, 376));
			eManager.addEntity(new Barrier(handler, 0, 0, 0, 640, 720));
		}
		else if(state == "CASTLEAREA")
		{
			eManager.addEntity(new Barrier(handler, 0, 1340, 0, 740, 200));
			eManager.addEntity(new Barrier(handler, 928, 1340, 0, 740, 200));
			eManager.addEntity(new Barrier(handler, 0, 0, 0, 230, 1460));
			eManager.addEntity(new Barrier(handler, 1434, 0, 0, 230, 1460));
			eManager.addEntity(new Barrier(handler, 0, 0, 0, 1606, 980));
		}
		else if(state == "MAINAREA")
		{
//			if(gameProgress < 3)
//				eManager.addEntity(new Barrier(handler, 574, 1620, 0, 68, 108));
			
			eManager.addEntity(new Barrier(handler, 0, 0, 0, 240, 1056));
			eManager.addEntity(new Barrier(handler, 0, 0, 0, 3072, 168));
			eManager.addEntity(new Barrier(handler, 0, 1348, 0, 184, 1724));
			eManager.addEntity(new Barrier(handler, 180, 2432, 0, 200, 640));
			eManager.addEntity(new Barrier(handler, 378, 2498, 0, 460, 574));
			eManager.addEntity(new Barrier(handler, 840, 2284, 0, 16, 788));
			eManager.addEntity(new Barrier(handler, 1130, 2284, 0, 16, 788));
			eManager.addEntity(new Barrier(handler, 842, 2740, 0, 2230, 332));
			eManager.addEntity(new Barrier(handler, 1142, 2496, 0, 1930, 576));
			eManager.addEntity(new Barrier(handler, 1414, 2436, 0, 904, 102));
			eManager.addEntity(new Barrier(handler, 2692, 2308, 0, 380, 118));
			eManager.addEntity(new Barrier(handler, 2818, 2242, 0, 254, 80));
			eManager.addEntity(new Barrier(handler, 2882, 2118, 0, 190, 142));
			eManager.addEntity(new Barrier(handler, 2946, 0, 0, 126, 2254));
			eManager.addEntity(new Barrier(handler, 2886, 196, 0, 94, 1270));
			eManager.addEntity(new Barrier(handler, 2818, 388, 0, 100, 886));
			eManager.addEntity(new Barrier(handler, 2762, 642, 0, 68, 248));
			eManager.addEntity(new Barrier(handler, 2082, 554, 0, 490, 864));
			eManager.addEntity(new Barrier(handler, 1978, 1522, 0, 864, 490));
			eManager.addEntity(new Barrier(handler, 1008, 2678, 0, 122, 70));
			eManager.addEntity(new Barrier(handler, 488, 1658, 0, 64, 140));
			eManager.addEntity(new Barrier(handler, 310, 1472, 0, 394, 190));
			eManager.addEntity(new Barrier(handler, 512, 1652, 0, 64, 76));
			eManager.addEntity(new Barrier(handler, 640, 1620, 0, 64, 106));
			eManager.addEntity(new Barrier(handler, 628, 896, 0, 344, 192));
			eManager.addEntity(new Barrier(handler, 1128, 416, 0, 826, 262));
			eManager.addEntity(new Barrier(handler, 1180, 676, 0, 774, 140));
			eManager.addEntity(new Barrier(handler, 1180, 816, 0, 734, 48));
			eManager.addEntity(new Barrier(handler, 1196, 864, 0, 676, 64));
			eManager.addEntity(new Barrier(handler, 1678, 1752, 0, 100, 88));
			eManager.addEntity(new Barrier(handler, 950, 1344, 0, 396, 320));
			eManager.addEntity(new Barrier(handler, 1344, 1344, 0, 512, 192));
			eManager.addEntity(new Barrier(handler, 964, 1616, 0, 96, 70));
			eManager.addEntity(new Barrier(handler, 1124, 1628, 0, 108, 58));
			eManager.addEntity(new Barrier(handler, 1342, 1524, 0, 42, 92));
			eManager.addEntity(new Barrier(handler, 1600, 1496, 0, 256, 76));
			eManager.addEntity(new Barrier(handler, 830, 464, 0, 74, 94));
			eManager.addEntity(new Barrier(handler, 1812, 1736, 0, 48, 54));
			eManager.addEntity(new Barrier(handler, 1758, 1810, 0, 48, 54));
		}
		else if(state == "BEDROOM")
		{
			eManager.addEntity(new Barrier(handler, 0, 0, 0, 1078, 254));
			eManager.addEntity(new Barrier(handler, 0, 0, 0, 54, 824));
			eManager.addEntity(new Barrier(handler, 54, 310, 0, 100, 320));
			eManager.addEntity(new Barrier(handler, 118, 384, 0, 74, 256));
			eManager.addEntity(new Barrier(handler, 192, 384, 0, 56, 310));
			eManager.addEntity(new Barrier(handler, 312, 448, 0, 50, 250));
			eManager.addEntity(new Barrier(handler, 362, 448, 0, 334, 192));
			eManager.addEntity(new Barrier(handler, 696, 384, 0, 192, 256));
			eManager.addEntity(new Barrier(handler, 504, 50, 0, 62, 412));
			eManager.addEntity(new Barrier(handler, 504, 50, 0, 62, 412));
			eManager.addEntity(new Barrier(handler, 952, 448, 0, 64, 248));
			eManager.addEntity(new Barrier(handler, 950, 48, 0, 74, 266));
			eManager.addEntity(new Barrier(handler, 1016, 0, 0, 62, 826));
			eManager.addEntity(new Barrier(handler, 832, 640, 0, 48, 56));
			eManager.addEntity(new Barrier(handler, 582, 640, 0, 34, 40));
			eManager.addEntity(new Barrier(handler, 390, 640, 0, 34, 40));
			eManager.addEntity(new Barrier(handler, 452, 406, 0, 52, 42));
			eManager.addEntity(new Barrier(handler, 312, 192, 0, 128, 128));
			eManager.addEntity(new Barrier(handler, 568, 342, 0, 56, 106));
			eManager.addEntity(new Barrier(handler, 0, 766, 0, 504, 60));
			eManager.addEntity(new Barrier(handler, 630, 766, 0, 488, 60));
			
		}
	}
	
	public void render(Graphics g)
	{		
		if(state == "CASTLEAREA")
		{
			currentWidth = Assets.townCastle.getWidth()*2;currentHeight = Assets.townCastle.getHeight()*2;
			g.drawImage(Assets.townCastle, (int)-handler.getCamera().getxOffset(), (int)-handler.getCamera().getyOffset(), Assets.townCastle.getWidth()*2, Assets.townCastle.getHeight()*2, null);	
			
			for(Entity e : eManager.getEntities())
			{
				eManager.render(e, g);
			}
			
			g.drawImage(Assets.townCastleTop, (int)-handler.getCamera().getxOffset(), (int)-handler.getCamera().getyOffset(), Assets.townCastle.getWidth()*2, Assets.townCastle.getHeight()*2, null);	
			
		}
		else if(state == "CONNECTOR")
		{
			currentWidth = Assets.connection1.getWidth()*2;currentHeight = Assets.connection1.getHeight()*2;
			g.drawImage(Assets.connection1, (int)-handler.getCamera().getxOffset(), (int)-handler.getCamera().getyOffset(), Assets.connection1.getWidth()*2, Assets.connection1.getHeight()*2, null);	
			
			for(Entity e : eManager.getEntities())
			{
				eManager.render(e, g);
			}
			g.drawImage(Assets.connectionTop, (int)-handler.getCamera().getxOffset(), (int)-handler.getCamera().getyOffset(), Assets.connectionTop.getWidth()*2, Assets.connectionTop.getHeight()*2, null);	
			
		}
		else if(state == "BEDROOM" || state == "TOSAVE" || state == "SAVING")
		{
			currentWidth = Assets.bedroom.getWidth()*2;currentHeight = Assets.bedroom.getHeight()*2;
			g.drawImage(Assets.bedroom, (int)-handler.getCamera().getxOffset(), (int)-handler.getCamera().getyOffset(), Assets.bedroom.getWidth()*2, Assets.bedroom.getHeight()*2, null);	
			
			for(Entity e : eManager.getEntities())
			{
				eManager.render(e, g);
			}
			g.drawImage(Assets.bedroomTop, (int)-handler.getCamera().getxOffset(), (int)-handler.getCamera().getyOffset(), Assets.bedroom.getWidth()*2, Assets.bedroom.getHeight()*2, null);	
			
			if(storing)
			{
				myStorage.render(g);
			}	
		}
		else
		{
			currentWidth = currentLocation.getCurrentFrame().getWidth()*2;currentHeight = currentLocation.getCurrentFrame().getHeight()*2;
			g.drawImage(currentLocation.getCurrentFrame(), (int)-handler.getCamera().getxOffset(), (int)-handler.getCamera().getyOffset(), currentLocation.getCurrentFrame().getWidth()*2, currentLocation.getCurrentFrame().getHeight()*2, null);	
			
			if(activeShopKeeper)
			{
				g.drawImage(Assets.zaria, (int)(1064 - handler.getCamera().getxOffset()), (int)(1560-handler.getCamera().getyOffset()), Assets.zaria.getWidth()*2, Assets.zaria.getHeight()*2, null);	
			}
			if(activebSmith)
			{
				g.drawImage(Assets.max, (int)(1212 - handler.getCamera().getxOffset()), (int)(1563-handler.getCamera().getyOffset()), Assets.max.getWidth()*2, Assets.max.getHeight()*2, null);	
			}
			
			g.drawImage(Assets.buildingDecor, (int)-handler.getCamera().getxOffset(), (int)-handler.getCamera().getyOffset(), currentLocation.getCurrentFrame().getWidth()*2, currentLocation.getCurrentFrame().getHeight()*2, null);
				
			houseDoor.render(g);
			
			for(Entity e : eManager.getEntities())
			{
				eManager.render(e, g);
			}
			
			g.drawImage(Assets.buildings, (int)-handler.getCamera().getxOffset(), (int)-handler.getCamera().getyOffset(), currentLocation.getCurrentFrame().getWidth()*2, currentLocation.getCurrentFrame().getHeight()*2, null);
			
			if(state == "QUESTSELECT")
			{
				qBoard.render(g);
			}
			else if(state == "SHOPKEEPER")
			{
				sKeeper.render(g);
			}
			else if(state == "BLACKSMITH")
			{
				bSmith.render(g);
			}
			
			if(!activeBoat)
			{
				g.drawImage(Assets.boat, (int)(940 - handler.getCamera().getxOffset()), (int)(2800-handler.getCamera().getyOffset()), Assets.boat.getWidth()*2, Assets.boat.getHeight()*2, null);	
			}
			else
			{
				boatX += 6;
				g.drawImage(Assets.boatWPlayer, (int)(940 + boatX - handler.getCamera().getxOffset()), (int)(2800-handler.getCamera().getyOffset()), Assets.boat.getWidth()*2, Assets.boat.getHeight()*2, null);
				if(handler.getGame().getGameState().getEffects().getAlpha() == 1)
				{
					activeBoat = false;
				}
			}
			
		}
		
		isEventRunning = false;
		for(Event e : events)
		{
			if(handler.getGame().getPlayer().getCollisionBounds(0, 0).intersects(e.getEventSpace()) && e.meetsRequirements() && !e.isRunning())
				e.setRunning(true);
			if(e.isRunning())
			{
				isEventRunning = true;
				e.run(g);
			}
		}
			
	}
	
	public void addQuest()
	{
		questsCompleted++;
		qBoard.generateQuests();
		
		if(questTracker >= 0)
		{
			questTracker++;
			if(questTracker >= 1)//number of quests done between events
			{
				gameProgress++;
				questTracker = -1;
			}
			events.get(7).setRanOnce(false);
		}
	}

	public EntityManager geteManager() {
		return eManager;
	}

	public void seteManager(EntityManager eManager) {
		this.eManager = eManager;
	}

	public BufferedImage getCurrentLocation() {
		return currentLocation.getCurrentFrame();
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getGameProgress() {
		return gameProgress;
	}

	public void setGameProgress(int gameProgress) {
		this.gameProgress = gameProgress;
	}

	public ArrayList<Event> getEvents() {
		return events;
	}

	public void setEvents(ArrayList<Event> events) {
		this.events = events;
	}

	public String getNextArea() {
		return nextArea;
	}

	public void setNextArea(String nextArea) {
		this.nextArea = nextArea;
	}

	public int getQuestsCompleted() {
		return questsCompleted;
	}

	public void setQuestsCompleted(int questsCompleted) {
		this.questsCompleted = questsCompleted;
	}

	public int getQuestTracker() {
		return questTracker;
	}

	public void setQuestTracker(int questTracker) {
		this.questTracker = questTracker;
	}

	public QuestBoard getqBoard() {
		return qBoard;
	}

	public void setqBoard(QuestBoard qBoard) {
		this.qBoard = qBoard;
	}

	public boolean isStoring() {
		return storing;
	}

	public void setStoring(boolean storing) {
		this.storing = storing;
	}

	public boolean isActiveBoat() {
		return activeBoat;
	}

	public void setActiveBoat(boolean activeBoat) {
		this.activeBoat = activeBoat;
	}



	public int getDungeonsUnlocked() {
		return dungeonsUnlocked;
	}



	public void setDungeonsUnlocked(int dungeonsUnlocked) {
		this.dungeonsUnlocked = dungeonsUnlocked;
	}



	public int getDungeonsCleared() {
		return dungeonsCleared;
	}



	public void setDungeonsCleared(int dungeonsCleared) {
		this.dungeonsCleared = dungeonsCleared;
	}



	public boolean isEventRunning() {
		return isEventRunning;
	}



	public void setEventRunning(boolean isEventRunning) {
		this.isEventRunning = isEventRunning;
	}



	public boolean isSleeping() {
		return sleeping;
	}



	public void setSleeping(boolean sleeping) {
		this.sleeping = sleeping;
	}



	public int getCurrentWidth() {
		return currentWidth;
	}



	public void setCurrentWidth(int currentWidth) {
		this.currentWidth = currentWidth;
	}



	public int getCurrentHeight() {
		return currentHeight;
	}



	public void setCurrentHeight(int currentHeight) {
		this.currentHeight = currentHeight;
	}



	public boolean[] getChestsOpened() {
		return chestsOpened;
	}



	public void setChestsOpened(boolean[] chestsOpened) {
		this.chestsOpened = chestsOpened;
	}
	
	
	
	
	
	
	
}

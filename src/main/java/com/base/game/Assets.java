package com.base.game;
import java.awt.image.BufferedImage;

public class Assets 
{
	private static final int width = 32, height = 32;
	
	public static BufferedImage black, titleScreen, titleScreenBG, settingsIcon, aKey, sKey, wKey, dKey, eKey;
	public static BufferedImage[] menuNumbers;
	public static BufferedImage selectorTLft, selectorTRgt, selectorBLft, selectorBRgt;
	
	public static BufferedImage scroll, scrollTaken, bossIcon, artifact;
	public static BufferedImage paraIcon, burIcon, posiIcon, freezIcon;
	public static BufferedImage worldMap, mapCloud;
	public static BufferedImage[] dungeonMapIcon;
	
	public static BufferedImage[] baseCamp;
	public static BufferedImage buildings, buildingDecor, townCastle, townCastleTop, bedroom, bedroomTop, forestBG, connection1, connectionTop;
	public static BufferedImage zaria, max;
	
	public static BufferedImage[] stoneDoorOpening, stoneDoorClosing, woodDoorOpening, woodDoorClosing;
	
	public static BufferedImage[] holoMap, playerDot;
	
	public static BufferedImage[] D1Tileset, D2Tileset, D3Tileset, D4Tileset, D5Tileset, D6Tileset, D7Tileset, D8Tileset;
	
	public static BufferedImage[] D1StaticEntities1;
	
	public static BufferedImage cave, pitfall, vines, water, cliffs;
	public static BufferedImage switchOff, switchOn;
	public static BufferedImage shadow, night, whiteOut, yellowLightning, blueLightning;
	public static BufferedImage[] shocked, suprised, laughing, inquisitive, embarassed, angry;
	public static BufferedImage[] burned;
	public static BufferedImage gold, wallet, heartCrystal, usedHeartCrystal;
	public static BufferedImage[] energy, crate, chestDown, chestUp, chestLeft, chestRight, boulder;
	public static BufferedImage[] pressureSwitchDown, pressureSwitchUp;
			
	public static BufferedImage hpDisplay, hpBar;
	public static BufferedImage dialogBox, dialogArrow, box800x500, box100x100, box440x240, box300x350, box700x150, box750x100, box400x100, box200x100, selector200x100, selector100x100, selector300x20, selector700x150, selector400x100;
	public static BufferedImage boxGlowMidSect, boxGlowTopSect, boxGlowBotSect;
	
	public static BufferedImage[] hole;
	public static BufferedImage[] playerStationary, playerStationaryMonkey, playerStationaryShadow, playerStationaryGunLance, playerStationaryGravityBoots;
	public static BufferedImage[] playerDown, playerLeft, playerRight, playerUp, playerDownLeft, playerDownRight, playerUpLeft, playerUpRight;
	
	public static BufferedImage[] playerDownShadow, playerLeftShadow, playerRightShadow, playerUpShadow, playerDownLeftShadow, playerDownRightShadow, playerUpLeftShadow, playerUpRightShadow;

	public static BufferedImage[] playerDownMonkey, playerLeftMonkey, playerRightMonkey, playerUpMonkey, playerDownLeftMonkey, playerDownRightMonkey, playerUpLeftMonkey, playerUpRightMonkey;
	
	public static BufferedImage[] playerDownGunLance, playerLeftGunLance, playerRightGunLance, playerUpGunLance, playerDownLeftGunLance, playerDownRightGunLance, playerUpLeftGunLance, playerUpRightGunLance;
	
	public static BufferedImage[] attackDownGunLance, attackLeftGunLance, attackRightGunLance, attackUpGunLance, attackDownLeftGunLance, attackDownRightGunLance, attackUpLeftGunLance, attackUpRightGunLance;
	
	public static BufferedImage[] playerDownShine, playerUpShine, playerLeftShine, playerRightShine;
	public static BufferedImage[] playerGBootsUp, playerGBootsDwn, playerGBootsLft, playerGBootsRgt;
	public static BufferedImage[] playerGloves;
	
	public static BufferedImage[] playerFallingDown, playerFallingLeft, playerFallingRight, playerFallingUp;
	public static BufferedImage[] playerFallingDownGBoots, playerFallingLeftGBoots, playerFallingRightGBoots, playerFallingUpGBoots;
	public static BufferedImage[] playerClimbing;
	public static BufferedImage[] playerDead, playerRise, playerCheering;
	
	public static BufferedImage[] player2Stationary;
	public static BufferedImage[] player2Down, player2Left, player2Right, player2Up, player2DownLeft, player2DownRight, player2UpLeft, player2UpRight;
	public static BufferedImage[] player2Dead, player2Rise;
	
	public static BufferedImage[] player3Stationary;
	public static BufferedImage[] player3Down, player3Left, player3Right, player3Up, player3DownLeft, player3DownRight, player3UpLeft, player3UpRight;
	public static BufferedImage[] player3Dead, player3Rise;
	
	public static BufferedImage[] gThrustDownLeft, gThrustDownRight, gThrustUpLeft, gThrustUpRight;
	public static BufferedImage[] itemIcons, itemOutlines, itemsInUse;
	public static BufferedImage[] tessen;
	
	public static BufferedImage[] questNPCsMaleDwn, questNPCsMaleLft, questNPCsMaleUp, questNPCsMaleRgt;
	public static BufferedImage[] questNPCsFemaleDwn, questNPCsFemaleLft, questNPCsFemaleUp, questNPCsFemaleRgt;
	
	public static BufferedImage[] chars;
	
	public static BufferedImage[] NPC10Stationary, NPC10Lft, NPC10Rgt, NPC10Up, NPC10Dwn;
	public static BufferedImage[] NPC12Stationary, NPC12Lft, NPC12Rgt, NPC12Up, NPC12Dwn;
	public static BufferedImage[] NPC13Stationary, NPC13Lft, NPC13Rgt, NPC13Up, NPC13Dwn;
	public static BufferedImage[] NPC14Stationary, NPC14Lft, NPC14Rgt, NPC14Up, NPC14Dwn;
	public static BufferedImage[] NPC15Stationary, NPC15Lft, NPC15Rgt, NPC15Up, NPC15Dwn;
	public static BufferedImage[] NPC16Stationary, NPC16Lft, NPC16Rgt, NPC16Up, NPC16Dwn;
	public static BufferedImage[] NPC17Stationary, NPC17Lft, NPC17Rgt, NPC17Up, NPC17Dwn;
	public static BufferedImage[] NPC18Stationary, NPC18Lft, NPC18Rgt, NPC18Up, NPC18Dwn;
	public static BufferedImage[] NPC2Stationary, NPC2Lft, NPC2Rgt, NPC2Up, NPC2Dwn;
	public static BufferedImage[] NPC9Stationary, NPC9Lft, NPC9Rgt, NPC9Up, NPC9Dwn;
	public static BufferedImage[] NPC5Stationary, NPC5Lft, NPC5Rgt, NPC5Up, NPC5Dwn;
	public static BufferedImage[] NPC3Stationary, NPC3Lft, NPC3Rgt, NPC3Up, NPC3Dwn;
	public static BufferedImage[] NPC4Stationary, NPC4Lft, NPC4Rgt, NPC4Up, NPC4Dwn;
	public static BufferedImage[] NPC6Stationary, NPC6Lft, NPC6Rgt, NPC6Up, NPC6Dwn;
	public static BufferedImage[] NPC7Stationary, NPC7Lft, NPC7Rgt, NPC7Up, NPC7Dwn;
	public static BufferedImage[] NPC8Stationary, NPC8Lft, NPC8Rgt, NPC8Up, NPC8Dwn;
	public static BufferedImage[] NPC1Stationary, NPC1Lft, NPC1Rgt, NPC1Up, NPC1Dwn;
	public static BufferedImage[] NPC11Stationary, NPC11Lft, NPC11Rgt, NPC11Up, NPC11Dwn, NPC11Attack;
	public static BufferedImage[] fineasStationary, fineasLft, fineasRgt, fineasUp, fineasDwn;
	public static BufferedImage[] obinStationary, obinLft, obinRgt, obinUp, obinDwn;
	public static BufferedImage[] budaDwnLft, budaDwnRgt, budaUpLft, budaUpRgt;
	public static BufferedImage[] fairyDwnLft, fairyDwnRgt, fairyUpLft, fairyUpRgt;
	
	public static BufferedImage[] elements, selector;
	public static BufferedImage[] whipUp, whipRgt, whipDwn, whipLft;
	public static BufferedImage[] whipHeadDwnRgt, whipHeadDwnLft, whipHeadUpRgt, whipHeadUpLft;
	public static BufferedImage[] whipHeadDwnRgt2, whipHeadDwnLft2, whipHeadUpRgt2, whipHeadUpLft2;
	public static BufferedImage[] whipBody, whipBodyFins;
	public static BufferedImage[] whipTail;
	
	public static BufferedImage[] whipDwnLft, whipDwnRgt, whipUpLft, whipUpRgt;
			
	public static BufferedImage[] tornado, tornadoDissapate;
	
	public static BufferedImage[] staffAtkUp, staffAtkDwn, staffAtkLft, staffAtkRgt;
	
	public static BufferedImage[] crawDwnLft, crawDwnRgt, crawUpLft, crawUpRgt, crawAtkDwnLft, crawAtkDwnRgt, crawAtkUpLft, crawAtkUpRgt;
	public static BufferedImage[] riggsDwnLft, riggsDwnRgt, riggsUpLft, riggsUpRgt, riggsAtkDwnLft, riggsAtkDwnRgt, riggsAtkUpLft, riggsAtkUpRgt;
	
	public static BufferedImage[] spiderLeft, spiderRight;
	public static BufferedImage[] batLeft, batRight;
	public static BufferedImage[] beetleDwnLft, beetleDwnRgt, beetleUpLft, beetleUpRgt, beetleDwnLftAtk, beetleDwnRgtAtk, beetleUpLftAtk, beetleUpRgtAtk;
	public static BufferedImage[] milliBodyDownLeft, milliBodyDownRight, milliBodyUpLeft, milliBodyUpRight, milliHead, milliTail;
	
	public static BufferedImage[] scorpionLeft, scorpionLeftInHole, scorpionRightInHole, scorpionDamagedLeft, scorpionDamagedRight, scorpionLftAtk, scorpionRgtAtk, scorpionLeftFall, scorpionUp;
	
	public static BufferedImage[] gremlinDwnLft, gremlinUpLft, gremlinUpRgt, gremlinDwnRgt, gremlinIdleDwnLft, gremlinAtkDwnLft, gremlinIdleUpLft, gremlinAtkUpLft, gremlinIdleDwnRgt, gremlinAtkDwnRgt, gremlinIdleUpRgt, gremlinAtkUpRgt;	
	public static BufferedImage[] turtleDwnLft, turtleUpLft, turtleUpRgt, turtleDwnRgt, turtleInShell;
	public static BufferedImage[] birdDwnLft, birdUpLft, birdUpRgt, birdDwnRgt, birdAtkDwnLft, birdAtkUpLft, birdAtkUpRgt, birdAtkDwnRgt;
	public static BufferedImage[] slimeDwnLft, slimeUpLft, slimeUpRgt, slimeDwnRgt;
	
	public static BufferedImage[] sharkDwnLft, sharkUpLft, sharkUpRgt, sharkDwnRgt, sharkAtkDwnLft, sharkAtkUpLft, sharkAtkUpRgt, sharkAtkDwnRgt, sharkIdleDwnLft, sharkIdleUpLft, sharkIdleUpRgt, sharkIdleDwnRgt;
	public static BufferedImage[] squidDwnLft, squidUpLft, squidUpRgt, squidDwnRgt, squidAtkDwnLft, squidAtkUpLft, squidAtkUpRgt, squidAtkDwnRgt;
	public static BufferedImage[] seaMineDwnLft, seaMineUpLft, seaMineUpRgt, seaMineDwnRgt, seaMineAtkDwnLft, seaMineAtkUpLft, seaMineAtkUpRgt, seaMineAtkDwnRgt;
	public static BufferedImage[] starfishDwnLft, starfishUpLft, starfishUpRgt, starfishDwnRgt, starfishAtkDwnLft, starfishAtkUpLft, starfishAtkUpRgt, starfishAtkDwnRgt;
	
	public static BufferedImage[] hippoDwnLft, hippoUpLft, hippoUpRgt, hippoDwnRgt, hippoAtkDwnLft, hippoAtkUpLft, hippoAtkUpRgt, hippoAtkDwnRgt;
	public static BufferedImage[] lizardDwnLft, lizardUpLft, lizardUpRgt, lizardDwnRgt, lizardAtkDwnLft, lizardAtkUpLft, lizardAtkUpRgt, lizardAtkDwnRgt;
	public static BufferedImage[] fireMilliBodyDownLeft, fireMilliBodyDownRight, fireMilliBodyUpLeft, fireMilliBodyUpRight, fireMilliHead, fireMilliTail;
	public static BufferedImage[] fireBatLeft, fireBatRight;
	
	public static BufferedImage[] wolfDwnLft, wolfUpLft, wolfUpRgt, wolfDwnRgt, wolfAtkDwnLft, wolfAtkUpLft, wolfAtkUpRgt, wolfAtkDwnRgt, wolfIdleDwnLft, wolfIdleUpLft, wolfIdleUpRgt, wolfIdleDwnRgt;
	public static BufferedImage[] snakeDwnLft, snakeUpLft, snakeUpRgt, snakeDwnRgt, snakeAtkDwnLft, snakeAtkUpLft, snakeAtkUpRgt, snakeAtkDwnRgt;
	public static BufferedImage[] iceSpiderLeft, iceSpiderRight;
	public static BufferedImage[] iceBeetleDwnLft, iceBeetleDwnRgt, iceBeetleUpLft, iceBeetleUpRgt, iceBeetleDwnLftAtk, iceBeetleDwnRgtAtk, iceBeetleUpLftAtk, iceBeetleUpRgtAtk;;
	
	public static BufferedImage[] lightKnightDwnLft, lightKnightUpLft, lightKnightUpRgt, lightKnightDwnRgt, lightKnightLft, lightKnightRgt, lightKnightAtkUp, lightKnightAtkDwn, lightKnightAtkLft, lightKnightAtkRgt, lightKnightShieldUp, lightKnightShieldRgt, lightKnightShieldDwn, lightKnightShieldLft;
	public static BufferedImage[] lgtMagiDwnLft, lgtMagiUpLft, lgtMagiUpRgt, lgtMagiDwnRgt, lgtMagiAtkDwnLft, lgtMagiAtkUpLft, lgtMagiAtkUpRgt, lgtMagiAtkDwnRgt, lgtMagiWarpDwnLft, lgtMagiWarpUpLft, lgtMagiWarpUpRgt, lgtMagiWarpDwnRgt;
	public static BufferedImage[] flyTurtleDwnLft, flyTurtleUpLft, flyTurtleUpRgt, flyTurtleDwnRgt;
	public static BufferedImage[] goblinDwnLft, goblinUpLft, goblinUpRgt, goblinDwnRgt, goblinIdleDwnLft, goblinAtkDwnLft, goblinIdleUpLft, goblinAtkUpLft, goblinIdleDwnRgt, goblinAtkDwnRgt, goblinIdleUpRgt, goblinAtkUpRgt;	
	
	public static BufferedImage[] drkKnightDwnLft, drkKnightUpLft, drkKnightUpRgt, drkKnightDwnRgt, drkKnightLft, drkKnightRgt, drkKnightAtkUp, drkKnightAtkDwn, drkKnightAtkLft, drkKnightAtkRgt, drkKnightShieldUp, drkKnightShieldRgt, drkKnightShieldDwn, drkKnightShieldLft;
	public static BufferedImage[] darkMagiDwnLft, darkMagiUpLft, darkMagiUpRgt, darkMagiDwnRgt, darkMagiAtkDwnLft, darkMagiAtkUpLft, darkMagiAtkUpRgt, darkMagiAtkDwnRgt, darkMagiWarpDwnLft, darkMagiWarpUpLft, darkMagiWarpUpRgt, darkMagiWarpDwnRgt, darkMagiInvDwnLft, darkMagiInvUpLft, darkMagiInvUpRgt, darkMagiInvDwnRgt;
	public static BufferedImage[] drkSlimeDwnLft, drkSlimeUpLft, drkSlimeUpRgt, drkSlimeDwnRgt;
	
	public static BufferedImage[] enemyDeath;
	
	public static BufferedImage[] spark, spikesUp, spikesDown;
	public static BufferedImage[] slashDwnLft, slashUpLft, slashDwnRgt, slashUpRgt;
	public static BufferedImage[] ooze, explosion, blast, ink, fireBall, electroBall, split, join, ice, quake, shadowIn, shadowOut,
		lightSlash, greenMagic, greenFire;
	
	public static BufferedImage[] beam, genoblade, genobladeDest, portal, smokeScreen, lightning, lightningSplash, lightningOrb;
	public static BufferedImage boat, boatWPlayer;
	public static BufferedImage[] b8DwnLft, b8UpLft, b8UpRgt, b8DwnRgt, b8AtkDwnLft, b8AtkUpLft, b8AtkUpRgt, b8AtkDwnRgt;
	public static BufferedImage[] b1DwnLft, b1UpLft, b1UpRgt, b1DwnRgt, b1AtkDwnLft, b1AtkUpLft, b1AtkUpRgt, b1AtkDwnRgt;
	public static BufferedImage[] b2DwnLft, b2UpLft, b2UpRgt, b2DwnRgt, b2AtkDwnLft, b2AtkUpLft, b2AtkUpRgt, b2AtkDwnRgt;
	public static BufferedImage[] b4DwnLft, b4UpLft, b4UpRgt, b4DwnRgt, b4AtkDwnLft, b4AtkUpLft, b4AtkUpRgt, b4AtkDwnRgt;
	public static BufferedImage[] b5EleStationary, b5EleUp, b5EleRgt, b5EleDwn, b5EleLft, b5ChargeUp, b5ChargeRgt, b5ChargeDwn, b5ChargeLft;
			
	public static SpriteSheet cloudSheet;
	
	public static void init()
	{
		SpriteSheet titleScreenSheet = new SpriteSheet(ResourceLoader.loadTexture("titleScreen.jpg"));
		SpriteSheet titleScreenBGSheet = new SpriteSheet(ResourceLoader.loadTexture("redBG.jpg"));
		SpriteSheet worldMapSheet = new SpriteSheet(ResourceLoader.loadTexture("worldMap.jpg"));
		SpriteSheet cloud = new SpriteSheet(ResourceLoader.loadTexture("cloud.png"));
		SpriteSheet holoMapSheet = new SpriteSheet(ResourceLoader.loadTexture("holomap.png"));
		cloudSheet = new SpriteSheet(ResourceLoader.loadTexture("clouds.png"));
		SpriteSheet baseCampSheet0 = new SpriteSheet(ResourceLoader.loadTexture("town1-1.png"));
		SpriteSheet baseCampSheet1 = new SpriteSheet(ResourceLoader.loadTexture("town1-2.png"));
		SpriteSheet baseCampSheet2 = new SpriteSheet(ResourceLoader.loadTexture("town1-3.png"));
		SpriteSheet castleSheet = new SpriteSheet(ResourceLoader.loadTexture("townCastle.png"));
		SpriteSheet castleSheetTop = new SpriteSheet(ResourceLoader.loadTexture("townCastleTop.png"));
		SpriteSheet connectionSheet = new SpriteSheet(ResourceLoader.loadTexture("connection1.png"));
		SpriteSheet connectionTopSheet = new SpriteSheet(ResourceLoader.loadTexture("connection2.png"));
		SpriteSheet forestBGSheet = new SpriteSheet(ResourceLoader.loadTexture("forestBG.png"));
		SpriteSheet bedroomSheet = new SpriteSheet(ResourceLoader.loadTexture("bedroom.png"));
		SpriteSheet bedroomTopSheet = new SpriteSheet(ResourceLoader.loadTexture("bedroomTop.png"));
		SpriteSheet buildingSheet = new SpriteSheet(ResourceLoader.loadTexture("buildings.png"));
		SpriteSheet buildingDecorSheet = new SpriteSheet(ResourceLoader.loadTexture("buildingDecor.png"));
		SpriteSheet townSheet = new SpriteSheet(ResourceLoader.loadTexture("townTileset.png"));
		SpriteSheet hpDisp = new SpriteSheet(ResourceLoader.loadTexture("healthDisplay.png"));
		SpriteSheet healthBar = new SpriteSheet(ResourceLoader.loadTexture("healthBar.png"));
		SpriteSheet dialogBoxSheet = new SpriteSheet(ResourceLoader.loadTexture("dialogBox.png"));
		SpriteSheet box800x500Sheet = new SpriteSheet(ResourceLoader.loadTexture("800x500Box.png"));
		SpriteSheet box100x100Sheet = new SpriteSheet(ResourceLoader.loadTexture("box100x100.png"));
		SpriteSheet numberSheet = new SpriteSheet(ResourceLoader.loadTexture("numberSheet.png"));
		SpriteSheet keyButtonSheet = new SpriteSheet(ResourceLoader.loadTexture("keyBoardSheet.png"));
		SpriteSheet mainItemIcons = new SpriteSheet(ResourceLoader.loadTexture("itemIcons.png"));
		SpriteSheet expressions = new SpriteSheet(ResourceLoader.loadTexture("expressions.png"));
		SpriteSheet items = new SpriteSheet(ResourceLoader.loadTexture("items.png"));
		SpriteSheet itemOutlinesSheet = new SpriteSheet(ResourceLoader.loadTexture("itemOutlines.png"));
		SpriteSheet itemsInUseSheet = new SpriteSheet(ResourceLoader.loadTexture("itemInUse.png"));
		SpriteSheet treasure = new SpriteSheet(ResourceLoader.loadTexture("treasure.png"));	
		SpriteSheet doors = new SpriteSheet(ResourceLoader.loadTexture("doors.png"));
		SpriteSheet elementalSymbols = new SpriteSheet(ResourceLoader.loadTexture("elementalSymbols.png"));
		SpriteSheet questNPCMaleSheet = new SpriteSheet(ResourceLoader.loadTexture("questNPCsMale.png"));
		SpriteSheet questNPCFemaleSheet = new SpriteSheet(ResourceLoader.loadTexture("questNPCsFemale.png"));
		SpriteSheet charSheet = new SpriteSheet(ResourceLoader.loadTexture("chars.png"));
		
		loadNPCs();
		loadTileSets();	
		loadEnimiesD1D2();
		loadEnimiesD3D4();
		loadEnimiesD5D6();
		loadEnimiesD7D8();
		loadBosses();
		loadPlayerAnims();
		loadPlayer2();
		loadPlayer3();
		loadEffects();
		loadEffects2();
		loadEffects3();
		
		chars = new BufferedImage[16];
		for(int i = 0; i < chars.length; i++)
			chars[i] = charSheet.crop(i * 300, 0, 300, 300);
		
		titleScreen = titleScreenSheet.crop(0, 0, 1920, 1080);
		titleScreenBG = titleScreenBGSheet.crop(0, 0, 1800, 1200);
		
		scroll = items.crop(162, 0, 34, 34);
		scrollTaken = items.crop(128, 0, 34, 34);
		bossIcon = items.crop(196, 0, 34, 34);
		artifact = items.crop(0, 96, 32, 32);
		
		posiIcon = items.crop(0, 64, 32, 32);
		paraIcon = items.crop(0, 64, 32, 32);
		burIcon = items.crop(0, 64, 32, 32);
		freezIcon = items.crop(0, 64, 32, 32);
		
		
		worldMap = worldMapSheet.crop(0, 0, 2500, 1200);
		mapCloud = cloud.crop(0, 0, 385, 290);
		dungeonMapIcon = new BufferedImage[4];
		dungeonMapIcon[0] = items.crop(0, 32, 22, 16);
		dungeonMapIcon[1] = items.crop(22, 32, 22, 16);
		dungeonMapIcon[2] = items.crop(44, 32, 22, 16);
		dungeonMapIcon[3] = items.crop(22, 32, 22, 16);
		
		holoMap = new BufferedImage[15];
		holoMap[0] = holoMapSheet.crop(200, 0, 50, 50);
		holoMap[1] = holoMapSheet.crop(200, 50, 50, 50);
		holoMap[2] = holoMapSheet.crop(150, 0, 50, 50);
		holoMap[3] = holoMapSheet.crop(100, 50, 50, 50);
		holoMap[4] = holoMapSheet.crop(0, 0, 50, 50);
		holoMap[5] = holoMapSheet.crop(150, 50, 50, 50);
		holoMap[6] = holoMapSheet.crop(100, 0, 50, 50);
		holoMap[7] = holoMapSheet.crop(250, 50, 50, 50);
		holoMap[8] = holoMapSheet.crop(50, 0, 50, 50);
		holoMap[9] = holoMapSheet.crop(150, 100, 50, 50);
		holoMap[10] = holoMapSheet.crop(100, 100, 50, 50);
		holoMap[11] = holoMapSheet.crop(0, 50, 50, 50);
		holoMap[12] = holoMapSheet.crop(50, 100, 50, 50);
		holoMap[13] = holoMapSheet.crop(0, 100, 50, 50);
		holoMap[14] = holoMapSheet.crop(50, 50, 50, 50);
		
		playerDot = new BufferedImage[3];
		playerDot[0] = holoMapSheet.crop(250, 0, 8, 8);
		playerDot[1] = holoMapSheet.crop(258, 0, 8, 8);
		playerDot[2] = holoMapSheet.crop(266, 0, 8, 8);

		menuNumbers = new BufferedImage[3];
		for(int i = 0; i < menuNumbers.length; ++i)
			menuNumbers[i] = numberSheet.crop(120 * i, 0, 120, 120);
		
		aKey = keyButtonSheet.crop(0, 0, 45, 45);
		
		box800x500 = box800x500Sheet.crop(0, 0, 800, 500);
		box100x100 = box100x100Sheet.crop(0, 0, 100, 100);
		boxGlowMidSect = box100x100Sheet.crop(100, 40, 100, 18);
		boxGlowTopSect = box100x100Sheet.crop(100, 6, 100, 18);
		boxGlowBotSect = box100x100Sheet.crop(100, 77, 100, 18);
		settingsIcon = box100x100Sheet.crop(200, 0, 100, 100);
		box440x240 = box100x100Sheet.crop(0, 100, 440, 240);
		box300x350 = box100x100Sheet.crop(450, 0, 400, 350);//item box
		box700x150 = box100x100Sheet.crop(0, 400, 700, 150);
		box750x100 = box100x100Sheet.crop(0, 750, 750, 100);
		box400x100 = box100x100Sheet.crop(0, 550, 400, 100);
		box200x100 = box100x100Sheet.crop(0, 650, 200, 100);
		selector200x100 = box100x100Sheet.crop(200, 650, 200, 100);
		selector400x100 = box100x100Sheet.crop(400, 550, 400, 100);
		selector700x150 = box100x100Sheet.crop(700, 400, 700, 150);
		selector100x100 = box100x100Sheet.crop(100, 0, 100, 100);
		selector300x20 = box100x100Sheet.crop(450, 350, 300, 20);
		dialogArrow = dialogBoxSheet.crop(0, 0, 24, 24);
		dialogBox = dialogBoxSheet.crop(0, 32, 800, 200);

		itemIcons = new BufferedImage[8];
		itemIcons[0] = mainItemIcons.crop(0, 0, 100, 100);
		itemIcons[1] = mainItemIcons.crop(100, 0, 100, 100);
		itemIcons[2] = mainItemIcons.crop(200, 0, 100, 100);
		itemIcons[3] = mainItemIcons.crop(300, 0, 100, 100);
		itemIcons[4] = mainItemIcons.crop(0, 100, 100, 100);
		itemIcons[5] = mainItemIcons.crop(100, 100, 100, 100);
		itemIcons[6] = mainItemIcons.crop(200, 100, 100, 100);
		itemIcons[7] = mainItemIcons.crop(300, 100, 100, 100);
		
		itemOutlines = new BufferedImage[8];
		itemOutlines[0] = itemOutlinesSheet.crop(0, 0, 100, 100);
		itemOutlines[1] = itemOutlinesSheet.crop(100, 0, 100, 100);
		itemOutlines[2] = itemOutlinesSheet.crop(200, 0, 100, 100);
		itemOutlines[3] = itemOutlinesSheet.crop(300, 0, 100, 100);
		itemOutlines[4] = itemOutlinesSheet.crop(0, 100, 100, 100);
		itemOutlines[5] = itemOutlinesSheet.crop(100, 100, 100, 100);
		itemOutlines[6] = itemOutlinesSheet.crop(200, 100, 100, 100);
		itemOutlines[7] = itemOutlinesSheet.crop(300, 100, 100, 100);
		
		itemsInUse = new BufferedImage[8];
		itemsInUse[0] = itemsInUseSheet.crop(0, 0, 100, 100);
		itemsInUse[1] = itemsInUseSheet.crop(100, 0, 100, 100);
		itemsInUse[2] = itemsInUseSheet.crop(200, 0, 100, 100);
		itemsInUse[3] = itemsInUseSheet.crop(300, 0, 100, 100);
		itemsInUse[4] = itemsInUseSheet.crop(0, 100, 100, 100);
		itemsInUse[5] = itemsInUseSheet.crop(100, 100, 100, 100);
		itemsInUse[6] = itemsInUseSheet.crop(200, 100, 100, 100);
		itemsInUse[7] = itemsInUseSheet.crop(300, 100, 100, 100);
		
		questNPCsMaleDwn = new BufferedImage[15];
		for(int i = 0; i < 15; i++)
			questNPCsMaleDwn[i] = questNPCMaleSheet.crop(0, i * 35, 35, 35);
		questNPCsMaleLft = new BufferedImage[15];
		for(int i = 0; i < 15; i++)
			questNPCsMaleLft[i] = questNPCMaleSheet.crop(35, i * 35, 35, 35);
		questNPCsMaleUp = new BufferedImage[15];
		for(int i = 0; i < 15; i++)
			questNPCsMaleUp[i] = questNPCMaleSheet.crop(70, i * 35, 35, 35);
		questNPCsMaleRgt = new BufferedImage[15];
		for(int i = 0; i < 15; i++)
			questNPCsMaleRgt[i] = questNPCMaleSheet.crop(105, i * 35, 35, 35);
		questNPCsFemaleDwn = new BufferedImage[15];
		for(int i = 0; i < 15; i++)
			questNPCsFemaleDwn[i] = questNPCFemaleSheet.crop(0, i * 35, 35, 35);
		questNPCsFemaleLft = new BufferedImage[15];
		for(int i = 0; i < 15; i++)
			questNPCsFemaleLft[i] = questNPCFemaleSheet.crop(35, i * 35, 35, 35);
		questNPCsFemaleUp = new BufferedImage[15];
		for(int i = 0; i < 15; i++)
			questNPCsFemaleUp[i] = questNPCFemaleSheet.crop(70, i * 35, 35, 35);
		questNPCsFemaleRgt = new BufferedImage[15];
		for(int i = 0; i < 15; i++)
			questNPCsFemaleRgt[i] = questNPCFemaleSheet.crop(105, i * 35, 35, 35);
		
		gold = items.crop(0, 0, width, height);
		wallet = items.crop(width, 0, width, height);
		heartCrystal = items.crop(width * 2, 0, width, height);
		usedHeartCrystal = items.crop(width * 3, 0, width, height);

		baseCamp = new BufferedImage[3];
		baseCamp[0] = baseCampSheet0.crop(0, 0, 1536, 1536);
		baseCamp[1] = baseCampSheet1.crop(0, 0, 1536, 1536);
		baseCamp[2] = baseCampSheet2.crop(0, 0, 1536, 1536);
		
		buildings = buildingSheet.crop(0, 0, 1536, 1536);
		buildingDecor = buildingDecorSheet.crop(0, 0, 1536, 1536);
		
		townCastle = castleSheet.crop(0, 0, 832, 730);
		townCastleTop = castleSheetTop.crop(0, 0, 832, 730);
		forestBG = forestBGSheet.crop(0, 0, 480, 270);
		bedroom = bedroomSheet.crop(0, 0, 539, 413);
		bedroomTop = bedroomTopSheet.crop(0, 0, 539, 413);
		
		connection1 = connectionSheet.crop(0, 0, 900, 700);
		connectionTop = connectionTopSheet.crop(0, 0, 900, 700);

		vines = townSheet.crop(256, 16, 32, 48);
		
		shadow = expressions.crop(0, 0, 32, 12);	
		shocked = new BufferedImage[2];
		shocked[0] = expressions.crop(0, 12, 23, 23);
		shocked[1] = expressions.crop(23, 12, 23, 23);
		
		inquisitive = new BufferedImage[10];
		inquisitive[0] = expressions.crop(0, 34, 10, 15);
		inquisitive[1] = expressions.crop(10, 34, 10, 15);
		inquisitive[2] = expressions.crop(20, 34, 10, 15);
		inquisitive[3] = expressions.crop(30, 34, 10, 15);
		inquisitive[4] = expressions.crop(40, 34, 10, 15);
		inquisitive[5] = expressions.crop(50, 34, 10, 15);
		inquisitive[6] = expressions.crop(60, 34, 10, 15);
		inquisitive[7] = expressions.crop(70, 34, 10, 15);
		inquisitive[8] = expressions.crop(80, 34, 10, 15);
		inquisitive[9] = expressions.crop(90, 34, 10, 15);
		
		suprised = new BufferedImage[5];
		suprised[0] = expressions.crop(0, 49, 8, 14);
		suprised[1] = expressions.crop(8, 49, 8, 14);
		suprised[2] = expressions.crop(16, 49, 8, 14);
		suprised[3] = expressions.crop(24, 49, 8, 14);
		suprised[4] = expressions.crop(32, 49, 8, 14);
		
		laughing = new BufferedImage[3];
		laughing[0] = expressions.crop(0, 63, 22, 16);
		laughing[1] = expressions.crop(22, 63, 22, 16);
		laughing[2] = expressions.crop(44, 63, 22, 16);
		
		embarassed = new BufferedImage[2];
		embarassed[0] = expressions.crop(0, 79, 7, 12);
		embarassed[1] = expressions.crop(7, 79, 7, 12);
		
		angry = new BufferedImage[2];
		angry[0] = expressions.crop(0, 91, 15, 15);
		angry[1] = expressions.crop(15, 91, 15, 15);
		
		burned = new BufferedImage[5];
		burned[0] = expressions.crop(0, 106, 32, 32);
		burned[1] = expressions.crop(32, 106, 32, 32);
		burned[2] = expressions.crop(64, 106, 32, 32);
		burned[3] = expressions.crop(96, 106, 32, 32);
		burned[4] = expressions.crop(128, 106, 32, 32);
		
		night = expressions.crop(0, 138, 34, 34);
		whiteOut = expressions.crop(35, 138, 34, 34);
		yellowLightning = expressions.crop(70, 138, 34, 34);
		blueLightning = expressions.crop(105, 138, 34, 34);
		
		max = expressions.crop(0, 172, 24, 21);
		zaria = expressions.crop(24, 172, 24, 21);
		
		elements = new BufferedImage[9];
		elements[0] = elementalSymbols.crop(384, 0, 96, 96);
		elements[1] = elementalSymbols.crop(0, 0, 96, 96);
		elements[2] = elementalSymbols.crop(96, 0, 96, 96);
		elements[3] = elementalSymbols.crop(192, 0, 96, 96);
		elements[4] = elementalSymbols.crop(288, 0, 96, 96);
		elements[5] = elementalSymbols.crop(288, 96, 96, 96);
		elements[6] = elementalSymbols.crop(672, 96, 96, 96);
		elements[7] = elementalSymbols.crop(0, 192, 96, 96);
		elements[8] = elementalSymbols.crop(96, 96, 96, 96);
		
		selector = new BufferedImage[1];
		selector[0] = elementalSymbols.crop(0, 96, 96, 96);

		
		stoneDoorOpening = new BufferedImage[3];
		stoneDoorOpening[0] = doors.crop(192, 256, width, height*2);
		stoneDoorOpening[1] = doors.crop(192, 320, width, height*2);
		stoneDoorOpening[2] = doors.crop(192, 384, width, height*2);
		
		stoneDoorClosing = new BufferedImage[3];
		stoneDoorClosing[0] = doors.crop(192, 384, width, height*2);
		stoneDoorClosing[1] = doors.crop(192, 320, width, height*2);
		stoneDoorClosing[2] = doors.crop(192, 256, width, height*2);
		
		woodDoorOpening = new BufferedImage[3];
		woodDoorOpening[0] = doors.crop(0, 0, width, height*2);
		woodDoorOpening[1] = doors.crop(0, 64, width, height*2);
		woodDoorOpening[2] = doors.crop(0, 128, width, height*2);
		
		woodDoorClosing = new BufferedImage[3];
		woodDoorClosing[0] = doors.crop(0, 128, width, height*2);
		woodDoorClosing[1] = doors.crop(0, 64, width, height*2);
		woodDoorClosing[2] = doors.crop(0, 0, width, height*2);

		chestDown = new BufferedImage[4];
		chestDown[0] = treasure.crop(0, 0, 32, 48);
		chestDown[1] = treasure.crop(0, 48, 32, 48);
		chestDown[2] = treasure.crop(0, 96, 32, 48);
		chestDown[3] = treasure.crop(0, 144, 32, 48);
		
		chestLeft = new BufferedImage[4];
		chestLeft[0] = treasure.crop(32, 0, 32, 48);
		chestLeft[1] = treasure.crop(32, 48, 32, 48);
		chestLeft[2] = treasure.crop(32, 96, 32, 48);
		chestLeft[3] = treasure.crop(32, 144, 32, 48);
		
		chestRight = new BufferedImage[4];
		chestRight[0] = treasure.crop(64, 0, 32, 48);
		chestRight[1] = treasure.crop(64, 48, 32, 48);
		chestRight[2] = treasure.crop(64, 96, 32, 48);
		chestRight[3] = treasure.crop(64, 144, 32, 48);
		
		chestUp = new BufferedImage[4];
		chestUp[0] = treasure.crop(96, 0, 32, 48);
		chestUp[1] = treasure.crop(96, 48, 32, 48);
		chestUp[2] = treasure.crop(96, 96, 32, 48);
		chestUp[3] = treasure.crop(96, 144, 32, 48);
	
		hpBar = healthBar.crop(0, 0, 34, 23);
		
		hpDisplay = hpDisp.crop(0, 0, width * 11, 230);		
	}
	
	public static void loadEffects3()
	{
		SpriteSheet effects3 = new SpriteSheet(ResourceLoader.loadTexture("effects3.png"));
		
		enemyDeath = new BufferedImage[9];
		enemyDeath[0] = effects3.crop(0, 0, 30, 20);
		enemyDeath[1] = effects3.crop(30, 0, 30, 20);
		enemyDeath[2] = effects3.crop(60, 0, 30, 20);
		enemyDeath[3] = effects3.crop(90, 0, 30, 20);
		enemyDeath[4] = effects3.crop(210, 0, 30, 20);
		enemyDeath[5] = effects3.crop(240, 0, 30, 20);
		enemyDeath[6] = effects3.crop(270, 0, 30, 20);
		enemyDeath[7] = effects3.crop(300, 0, 30, 20);
		enemyDeath[8] = effects3.crop(330, 0, 30, 20);
		
		lightSlash = new BufferedImage[8];
		lightSlash[0] = effects3.crop(0, 20, 16, 16);
		lightSlash[1] = effects3.crop(16, 20, 16, 16);
		lightSlash[2] = effects3.crop(32, 20, 16, 16);
		lightSlash[3] = effects3.crop(48, 20, 16, 16);
		lightSlash[4] = effects3.crop(64, 20, 16, 16);
		lightSlash[5] = effects3.crop(80, 20, 16, 16);
		lightSlash[6] = effects3.crop(96, 20, 16, 16);
		lightSlash[7] = effects3.crop(112, 20, 16, 16);
		
		slashDwnLft = new BufferedImage[4];
		slashDwnLft[0] = effects3.crop(0, 34, 44, 50);
		slashDwnLft[1] = effects3.crop(44, 34, 44, 50);
		slashDwnLft[2] = effects3.crop(88, 34, 44, 50);
		slashDwnLft[3] = effects3.crop(132, 34, 44, 50);
		
		slashUpLft = new BufferedImage[4];
		slashUpLft[0] = effects3.crop(0, 84, 44, 50);
		slashUpLft[1] = effects3.crop(44, 84, 44, 50);
		slashUpLft[2] = effects3.crop(88, 84, 44, 50);
		slashUpLft[3] = effects3.crop(132, 84, 44, 50);
		
		slashUpRgt = new BufferedImage[4];
		slashUpRgt[0] = effects3.crop(0, 134, 44, 50);
		slashUpRgt[1] = effects3.crop(44, 134, 44, 50);
		slashUpRgt[2] = effects3.crop(88, 134, 44, 50);
		slashUpRgt[3] = effects3.crop(132, 134, 44, 50);
		
		slashDwnRgt = new BufferedImage[4];
		slashDwnRgt[0] = effects3.crop(0, 184, 44, 50);
		slashDwnRgt[1] = effects3.crop(44, 184, 44, 50);
		slashDwnRgt[2] = effects3.crop(88, 184, 44, 50);
		slashDwnRgt[3] = effects3.crop(132, 184, 44, 50);
		
		selectorTLft = effects3.crop(0, 234, 18, 18);
		selectorTRgt = effects3.crop(18, 234, 18, 18);
		selectorBLft = effects3.crop(36, 234, 18, 18);
		selectorBRgt = effects3.crop(54, 234, 18, 18);
		
		greenMagic = new BufferedImage[2];
		greenMagic[0] = effects3.crop(0, 252, 16, 16);
		greenMagic[1] = effects3.crop(16, 252, 16, 16);
		
		greenFire = new BufferedImage[8];
		greenFire[0] = effects3.crop(0, 268, 32, 80);
		greenFire[1] = effects3.crop(32, 268, 32, 80);
		greenFire[2] = effects3.crop(64, 268, 32, 80);
		greenFire[3] = effects3.crop(96, 268, 32, 80);
		greenFire[4] = effects3.crop(128, 268, 32, 80);
		greenFire[5] = effects3.crop(160, 268, 32, 80);
		greenFire[6] = effects3.crop(192, 268, 32, 80);
		greenFire[7] = effects3.crop(224, 268, 32, 80);
		
		beam = new BufferedImage[4];
		beam[0] = effects3.crop(0, 348, 32, 128);
		beam[1] = effects3.crop(32, 348, 32, 128);
		beam[2] = effects3.crop(64, 348, 32, 128);
		beam[3] = effects3.crop(96, 348, 32, 128);
		
		genoblade = new BufferedImage[4];
		genoblade[0] = effects3.crop(0, 476, 45, 110);
		genoblade[1] = effects3.crop(45, 476, 45, 110);
		genoblade[2] = effects3.crop(90, 476, 45, 110);
		genoblade[3] = effects3.crop(45, 476, 45, 110);
		
		genobladeDest = new BufferedImage[6];
		genobladeDest[0] = effects3.crop(0, 476, 45, 110);
		genobladeDest[1] = effects3.crop(45, 476, 45, 110);
		genobladeDest[2] = effects3.crop(90, 476, 45, 110);
		genobladeDest[3] = effects3.crop(135, 476, 45, 110);
		genobladeDest[4] = effects3.crop(180, 476, 45, 110);
		genobladeDest[5] = effects3.crop(225, 476, 45, 110);
		
		portal = new BufferedImage[4];
		portal[0] = effects3.crop(0, 586, 64, 64);
		portal[1] = effects3.crop(64, 586, 64, 64);
		portal[2] = effects3.crop(128, 586, 64, 64);
		portal[3] = effects3.crop(192, 586, 64, 64);
		
		boat = effects3.crop(0, 650, 100, 60);
		boatWPlayer = effects3.crop(100, 650, 100, 60);
		
		smokeScreen = new BufferedImage[8];
		smokeScreen[0] = effects3.crop(0, 710, 32, 80);
		smokeScreen[1] = effects3.crop(32, 710, 32, 80);
		smokeScreen[2] = effects3.crop(64, 710, 32, 80);
		smokeScreen[3] = effects3.crop(96, 710, 32, 80);
		smokeScreen[4] = effects3.crop(128, 710, 32, 80);
		smokeScreen[5] = effects3.crop(160, 710, 32, 80);
		smokeScreen[6] = effects3.crop(192, 710, 32, 80);
		smokeScreen[7] = effects3.crop(224, 710, 32, 80);
		
		lightning = new BufferedImage[8];
		for(int i = 0; i < lightning.length; i++)
			lightning[i] = effects3.crop(i * 72, 790, 72, 122);
		lightningSplash = new BufferedImage[8];
		for(int i = 0; i < lightningSplash.length; i++)
			lightningSplash[i] = effects3.crop(i * 92, 912, 92, 80);
		lightningOrb = new BufferedImage[8];
		for(int i = 0; i < lightningOrb.length; i++)
			lightningOrb[i] = effects3.crop(i * 32, 992, 32, 32);
		
	}
	
	public static void loadEffects2()
	{
		SpriteSheet effects2 = new SpriteSheet(ResourceLoader.loadTexture("effects2.png"));
		
		hole = new BufferedImage[7];
		hole[0] = effects2.crop(0, 96, 64, 64);
		hole[1] = effects2.crop(64, 96, 64, 64);
		hole[2] = effects2.crop(128, 96, 64, 64);
		hole[3] = effects2.crop(192, 96, 64, 64);
		hole[4] = effects2.crop(256, 96, 64, 64);
		hole[5] = effects2.crop(320, 96, 64, 64);
		hole[6] = effects2.crop(384, 96, 64, 64);
		
		ooze = new BufferedImage[9];
		ooze[0] = effects2.crop(64, 160, 64, 64);
		ooze[1] = effects2.crop(128, 160, 64, 64);
		ooze[2] = effects2.crop(192, 160, 64, 64);
		ooze[3] = effects2.crop(256, 160, 64, 64);
		ooze[4] = effects2.crop(320, 160, 64, 64);
		ooze[5] = effects2.crop(384, 160, 64, 64);
		ooze[6] = effects2.crop(448, 160, 64, 64);
		ooze[7] = effects2.crop(512, 160, 64, 64);
		ooze[8] = effects2.crop(576, 160, 64, 64);
		
		explosion = new BufferedImage[7];
		explosion[0] = effects2.crop(0, 226, 80, 100);
		explosion[1] = effects2.crop(80, 226, 80, 100);
		explosion[2] = effects2.crop(160, 226, 80, 100);
		explosion[3] = effects2.crop(240, 226, 80, 100);
		explosion[4] = effects2.crop(320, 226, 80, 100);
		explosion[5] = effects2.crop(400, 226, 80, 100);
		explosion[6] = effects2.crop(480, 226, 80, 100);
		
		blast = new BufferedImage[7];
		blast[0] = effects2.crop(0, 452, 100, 100);
		blast[1] = effects2.crop(100, 452, 100, 100);
		blast[2] = effects2.crop(200, 452, 100, 100);
		blast[3] = effects2.crop(300, 452, 100, 100);
		blast[4] = effects2.crop(400, 452, 100, 100);
		blast[5] = effects2.crop(500, 452, 100, 100);
		blast[6] = effects2.crop(600, 452, 100, 100);
		
		ice = new BufferedImage[10];
		ice[0] = effects2.crop(0, 588, 70, 60);
		ice[1] = effects2.crop(70, 588, 70, 60);
		ice[2] = effects2.crop(140, 588, 70, 60);
		ice[3] = effects2.crop(210, 588, 70, 60);
		ice[4] = effects2.crop(280, 588, 70, 60);
		ice[5] = effects2.crop(350, 588, 70, 60);
		ice[6] = effects2.crop(420, 588, 70, 60);
		ice[7] = effects2.crop(480, 588, 70, 60);
		ice[8] = effects2.crop(550, 588, 70, 60);
		ice[9] = effects2.crop(620, 588, 70, 60);

		quake = new BufferedImage[10]; 
		quake[0] = effects2.crop(0, 648, 112, 80);
		quake[1] = effects2.crop(112, 648, 112, 80);
		quake[2] = effects2.crop(224, 648, 112, 80);
		quake[3] = effects2.crop(336, 648, 112, 80);
		quake[4] = effects2.crop(448, 648, 112, 80);
		quake[5] = effects2.crop(550, 648, 112, 80);
		quake[6] = effects2.crop(662, 648, 112, 80);
		quake[7] = effects2.crop(0, 728, 112, 80);
		quake[8] = effects2.crop(112, 728, 112, 80);
		quake[9] = effects2.crop(224, 728, 112, 80);
		
		fireBall = new BufferedImage[6];
		fireBall[0] = effects2.crop(0, 552, 32, 32);
		fireBall[1] = effects2.crop(32, 552, 32, 32);
		fireBall[2] = effects2.crop(64, 552, 32, 32);
		fireBall[3] = effects2.crop(96, 552, 32, 32);
		fireBall[4] = effects2.crop(128, 552, 32, 32);
		fireBall[5] = effects2.crop(160, 552, 32, 32);
		
		ink = new BufferedImage[5];
		ink[0] = effects2.crop(0, 326, 32, 32);
		ink[1] = effects2.crop(32, 326, 32, 32);
		ink[2] = effects2.crop(64, 326, 32, 32);
		ink[3] = effects2.crop(96, 326, 32, 32);
		ink[4] = effects2.crop(128, 326, 32, 32);
		
		electroBall = new BufferedImage[6];
		electroBall[0] = effects2.crop(0, 358, 32, 32);
		electroBall[1] = effects2.crop(32, 358, 32, 32);
		electroBall[2] = effects2.crop(64, 358, 32, 32);
		electroBall[3] = effects2.crop(96, 358, 32, 32);
		electroBall[4] = effects2.crop(128, 358, 32, 32);
		electroBall[5] = effects2.crop(160, 358, 32, 32);
		
		split = new BufferedImage[6];
		split[0] = effects2.crop(0, 390, 56, 30);
		split[1] = effects2.crop(56, 390, 56, 30);
		split[2] = effects2.crop(112, 390, 56, 30);
		split[3] = effects2.crop(168, 390, 56, 30);
		split[4] = effects2.crop(224, 390, 56, 30);
		split[5] = effects2.crop(280, 390, 56, 30);
		
		join = new BufferedImage[6];
		join[0] = effects2.crop(280, 390, 56, 30);
		join[1] = effects2.crop(224, 390, 56, 30);
		join[2] = effects2.crop(168, 390, 56, 30);
		join[3] = effects2.crop(112, 390, 56, 30);
		join[4] = effects2.crop(56, 390, 56, 30);
		join[5] = effects2.crop(0, 390, 56, 30);
		
		shadowIn = new BufferedImage[8];
		shadowIn[0] = effects2.crop(0, 420, 32, 32);
		shadowIn[1] = effects2.crop(32, 420, 32, 32);
		shadowIn[2] = effects2.crop(64, 420, 32, 32);
		shadowIn[3] = effects2.crop(96, 420, 32, 32);
		shadowIn[4] = effects2.crop(128, 420, 32, 32);
		shadowIn[5] = effects2.crop(160, 420, 32, 32);
		shadowIn[6] = effects2.crop(192, 420, 32, 32);
		shadowIn[7] = effects2.crop(224, 420, 32, 32);
		
		shadowOut = new BufferedImage[8];
		shadowOut[0] = effects2.crop(224, 420, 32, 32);
		shadowOut[1] = effects2.crop(192, 420, 32, 32);
		shadowOut[2] = effects2.crop(160, 420, 32, 32);
		shadowOut[3] = effects2.crop(128, 420, 32, 32);
		shadowOut[4] = effects2.crop(96, 420, 32, 32);
		shadowOut[5] = effects2.crop(64, 420, 32, 32);
		shadowOut[6] = effects2.crop(32, 420, 32, 32);
		shadowOut[7] = effects2.crop(0, 420, 32, 32);
		
		tornado = new BufferedImage[4];
		tornado[0] = effects2.crop(0, height, width, height);
		tornado[1] = effects2.crop(width, height, width, height);
		tornado[2] = effects2.crop(width*2, height, width, height);
		tornado[3] = effects2.crop(width*3, height, width, height);
		
		tornadoDissapate = new BufferedImage[4];
		tornadoDissapate[0] = effects2.crop(0, height*2, width, height);
		tornadoDissapate[1] = effects2.crop(width, height*2, width, height);
		tornadoDissapate[2] = effects2.crop(width*2, height*2, width, height);
		tornadoDissapate[3] = effects2.crop(width*3, height*2, width, height);
		
		pressureSwitchDown = new BufferedImage[4];
		pressureSwitchDown[0] = effects2.crop(0, 0, width, height);
		pressureSwitchDown[1] = effects2.crop(width, 0, width, height);
		pressureSwitchDown[2] = effects2.crop(width*2, 0, width, height);
		pressureSwitchDown[3] = effects2.crop(width*3, 0, width, height);
		
		pressureSwitchUp = new BufferedImage[4];
		pressureSwitchUp[0] = effects2.crop(width*3, 0, width, height);
		pressureSwitchUp[1] = effects2.crop(width*2, 0, width, height);
		pressureSwitchUp[2] = effects2.crop(width, 0, width, height);
		pressureSwitchUp[3] = effects2.crop(0, 0, width, height);
	}
	
	public static void loadEffects()
	{
		
		SpriteSheet effects = new SpriteSheet(ResourceLoader.loadTexture("effects.png"));
		
		pitfall = effects.crop(0, 97, width, height);
		
		switchOff = effects.crop(0, height * 2 + 3, width, height);
		switchOn = effects.crop(width, height * 2 + 3, width, height);
		
		spikesUp = new BufferedImage[3];
		spikesUp[0] = effects.crop(0, height + 3, width, height);
		spikesUp[1] = effects.crop(width, height + 3, width, height);
		spikesUp[2] = effects.crop(width * 2, height + 3, width, height);
		
		spikesDown = new BufferedImage[3];
		spikesDown[2] = effects.crop(0, height + 3, width, height);
		spikesDown[1] = effects.crop(width, height + 3, width, height);
		spikesDown[0] = effects.crop(width * 2, height + 3, width, height);
		
		crate = new BufferedImage[10];
		crate[0] = effects.crop(0, 345, 48, 48);
		crate[1] = effects.crop(48, 345, 48, 48);
		crate[2] = effects.crop(96, 345, 48, 48);
		crate[3] = effects.crop(144, 345, 48, 48);
		crate[4] = effects.crop(192, 345, 48, 48);
		crate[5] = effects.crop(240, 345, 48, 48);
		crate[6] = effects.crop(0, 393, 48, 48);
		crate[7] = effects.crop(48, 393, 48, 48);
		crate[8] = effects.crop(96, 393, 48, 48);
		crate[9] = effects.crop(144, 393, 48, 48);
		
		energy = new BufferedImage[4];
		energy[0] = effects.crop(0, 450, width, height);
		energy[1] = effects.crop(32, 450, width, height);
		energy[2] = effects.crop(64, 450, width, height);
		energy[3] = effects.crop(32, 450, width, height);
		
		boulder = new BufferedImage[9];
		boulder[0] = effects.crop(0, 144, width*2, height*2);
		boulder[1] = effects.crop(64, 144, width*2, height*2);
		boulder[2] = effects.crop(128, 144, width*2, height*2);
		boulder[3] = effects.crop(192, 144, width*2, height*2);
		boulder[4] = effects.crop(64, 208, width*2, height*2);
		boulder[5] = effects.crop(64, 208, width*2, height*2);
		boulder[6] = effects.crop(128, 208, width*2, height*2);
		boulder[7] = effects.crop(192, 208, width*2, height*2);
		boulder[8] = effects.crop(0, 272, width*2, height*2);
	}
	
	public static void loadPlayerAnims()
	{
		SpriteSheet heroSprites = new SpriteSheet(ResourceLoader.loadTexture("heroSprites.png"));
		SpriteSheet heroSprites2 = new SpriteSheet(ResourceLoader.loadTexture("heroSprites2.png"));
		SpriteSheet heroMonkeySprites = new SpriteSheet(ResourceLoader.loadTexture("heroMonkeySprites.png"));
		SpriteSheet heroShadowSprites = new SpriteSheet(ResourceLoader.loadTexture("heroShadowSprites.png"));
		SpriteSheet gunLanceSprites = new SpriteSheet(ResourceLoader.loadTexture("gunlanceSprites.png"));
		SpriteSheet gunLanceAttack = new SpriteSheet(ResourceLoader.loadTexture("gunLanceAttack.png"));
		SpriteSheet mainItems = new SpriteSheet(ResourceLoader.loadTexture("mainItems.png"));
		SpriteSheet mainItems2 = new SpriteSheet(ResourceLoader.loadTexture("mainItems2.png"));
		SpriteSheet whipParts = new SpriteSheet(ResourceLoader.loadTexture("whipParts.png"));
		
		playerDead = new BufferedImage[3];
		playerDead[0] = heroSprites.crop(65, height * 8, width, height);
		playerDead[1] = heroSprites.crop(width + 2, height * 8, width, height);
		playerDead[2] = heroSprites.crop(0, height * 8, width + 2, height);
		
		playerRise = new BufferedImage[3];
		playerRise[0] = heroSprites.crop(0, height * 8, width + 2, height);
		playerRise[1] = heroSprites.crop(width + 2, height * 8, width, height);
		playerRise[2] = heroSprites.crop(65, height * 8, width, height);
		
		playerGloves = new BufferedImage[4];
		playerGloves[0] = mainItems2.crop(0, height*8, width, height);
		playerGloves[1] = mainItems2.crop(width, height*8, width, height);
		playerGloves[2] = mainItems2.crop(width*2, height*8, width, height);
		playerGloves[3] = mainItems2.crop(width*3, height*8, width, height);
		
		playerFallingDownGBoots = new BufferedImage[2];
		playerFallingDownGBoots[0] = mainItems2.crop(0, height*9, width, height);
		playerFallingDownGBoots[1] = mainItems2.crop(width, height*9, width, height);
		
		playerFallingUpGBoots = new BufferedImage[2];
		playerFallingUpGBoots[0] = mainItems2.crop(0, height*10, width, height);
		playerFallingUpGBoots[1] = mainItems2.crop(width, height*10, width, height);
		
		playerFallingLeftGBoots = new BufferedImage[2];
		playerFallingLeftGBoots[0] = mainItems2.crop(0, height*11, width, height);
		playerFallingLeftGBoots[1] = mainItems2.crop(width, height*11, width, height);
		
		playerFallingRightGBoots = new BufferedImage[2];
		playerFallingRightGBoots[0] = mainItems2.crop(0, height*12, width, height);
		playerFallingRightGBoots[1] = mainItems2.crop(width, height*12, width, height);
		
		playerGBootsUp = new BufferedImage[4];
		playerGBootsUp[0] = mainItems2.crop(width * 2, height*10, width, height);
		playerGBootsUp[1] = mainItems2.crop(width * 3, height*10, width, height);
		playerGBootsUp[2] = mainItems2.crop(width * 4, height*10, width, height);
		playerGBootsUp[3] = mainItems2.crop(width * 5, height*10, width, height);
		
		playerGBootsDwn = new BufferedImage[4];
		playerGBootsDwn[0] = mainItems2.crop(width * 2, height*9, width, height);
		playerGBootsDwn[1] = mainItems2.crop(width * 3, height*9, width, height);
		playerGBootsDwn[2] = mainItems2.crop(width * 4, height*9, width, height);
		playerGBootsDwn[3] = mainItems2.crop(width * 5, height*9, width, height);
		
		playerGBootsLft = new BufferedImage[4];
		playerGBootsLft[0] = mainItems2.crop(width * 2, height*11, width, height);
		playerGBootsLft[1] = mainItems2.crop(width * 3, height*11, width, height);
		playerGBootsLft[2] = mainItems2.crop(width * 4, height*11, width, height);
		playerGBootsLft[3] = mainItems2.crop(width * 5, height*11, width, height);
		
		playerGBootsRgt = new BufferedImage[4];
		playerGBootsRgt[0] = mainItems2.crop(width * 2, height*12, width, height);
		playerGBootsRgt[1] = mainItems2.crop(width * 3, height*12, width, height);
		playerGBootsRgt[2] = mainItems2.crop(width * 4, height*12, width, height);
		playerGBootsRgt[3] = mainItems2.crop(width * 5, height*12, width, height);
		
		staffAtkDwn = new BufferedImage[5];
		staffAtkDwn[0] = mainItems2.crop(0, 0, width, height);
		staffAtkDwn[1] = mainItems2.crop(width, 0, width, height);
		staffAtkDwn[2] = mainItems2.crop(width*2, 0, width, height);
		staffAtkDwn[3] = mainItems2.crop(width*3, 0, width, height);
		staffAtkDwn[4] = mainItems2.crop(width*4, 0, width, height);
		
		staffAtkUp = new BufferedImage[5];
		staffAtkUp[0] = mainItems2.crop(0, height, width, height);
		staffAtkUp[1] = mainItems2.crop(width, height, width, height);
		staffAtkUp[2] = mainItems2.crop(width*2, height, width, height);
		staffAtkUp[3] = mainItems2.crop(width*3, height, width, height);
		staffAtkUp[4] = mainItems2.crop(width*4, height, width, height);
		
		staffAtkRgt = new BufferedImage[5];
		staffAtkRgt[0] = mainItems2.crop(0, height * 2, width, height);
		staffAtkRgt[1] = mainItems2.crop(width, height * 2, width, height);
		staffAtkRgt[2] = mainItems2.crop(width*2, height * 2, width, height);
		staffAtkRgt[3] = mainItems2.crop(width*3, height * 2, width, height);
		staffAtkRgt[4] = mainItems2.crop(width*4, height * 2, width, height);
		
		staffAtkLft = new BufferedImage[5];
		staffAtkLft[0] = mainItems2.crop(0, height * 3, width, height);
		staffAtkLft[1] = mainItems2.crop(width, height * 3, width, height);
		staffAtkLft[2] = mainItems2.crop(width*2, height * 3, width, height);
		staffAtkLft[3] = mainItems2.crop(width*3, height * 3, width, height);
		staffAtkLft[4] = mainItems2.crop(width*4, height * 3, width, height);
		
		tessen = new BufferedImage[4];
		tessen[2] = mainItems.crop(0, height*4, width, height);
		tessen[0] = mainItems.crop(width, height*4, width, height);
		tessen[3] = mainItems.crop(width*2, height*4, width, height);
		tessen[1] = mainItems.crop(width*3, height*4, width, height);
		
		playerDownShine = new BufferedImage[4];
		playerDownShine[0] = mainItems2.crop(0, height*4, width, height);
		playerDownShine[1] = mainItems2.crop(width, height*4, width, height);
		playerDownShine[2] = mainItems2.crop(width*2, height*4, width, height);
		playerDownShine[3] = mainItems2.crop(width*3, height*4, width, height);
		
		playerLeftShine = new BufferedImage[4];
		playerLeftShine[0] = mainItems2.crop(0, height*5, width, height);
		playerLeftShine[1] = mainItems2.crop(width, height*5, width, height);
		playerLeftShine[2] = mainItems2.crop(width*2, height*5, width, height);
		playerLeftShine[3] = mainItems2.crop(width*3, height*5, width, height);
		
		playerUpShine = new BufferedImage[4];
		playerUpShine[0] = mainItems2.crop(0, height * 6, width, height);
		playerUpShine[1] = mainItems2.crop(width, height * 6, width, height);
		playerUpShine[2] = mainItems2.crop(width*2, height * 6, width, height);
		playerUpShine[3] = mainItems2.crop(width*3, height * 6, width, height);
		
		playerRightShine = new BufferedImage[4];
		playerRightShine[0] = mainItems2.crop(0, height * 7, width, height);
		playerRightShine[1] = mainItems2.crop(width, height * 7, width, height);
		playerRightShine[2] = mainItems2.crop(width*2, height * 7, width, height);
		playerRightShine[3] = mainItems2.crop(width*3, height * 7, width, height);
		
		whipHeadDwnRgt = new BufferedImage[4];
		whipHeadDwnRgt[0] = whipParts.crop(0, height, width, height);
		whipHeadDwnRgt[1] = whipParts.crop(width, height, width, height);
		whipHeadDwnRgt[2] = whipParts.crop(width*2, height, width, height);
		whipHeadDwnRgt[3] = whipParts.crop(width*3, height, width, height);
		
		whipHeadDwnLft = new BufferedImage[4];
		whipHeadDwnLft[0] = whipParts.crop(0, 0, width, height);
		whipHeadDwnLft[1] = whipParts.crop(width, 0, width, height);
		whipHeadDwnLft[2] = whipParts.crop(width * 2, 0, width, height);
		whipHeadDwnLft[3] = whipParts.crop(width * 3, 0, width, height);
		
		whipHeadUpLft = new BufferedImage[4];
		whipHeadUpLft[0] = whipParts.crop(0, height * 2, width, height);
		whipHeadUpLft[1] = whipParts.crop(width, height * 2, width, height);
		whipHeadUpLft[2] = whipParts.crop(width * 2, height * 2, width, height);
		whipHeadUpLft[3] = whipParts.crop(width * 3, height * 2, width, height);
		
		whipHeadUpRgt = new BufferedImage[4];
		whipHeadUpRgt[0] = whipParts.crop(0, height * 3, width, height);
		whipHeadUpRgt[1] = whipParts.crop(width, height * 3, width, height);
		whipHeadUpRgt[2] = whipParts.crop(width * 2, height * 3, width, height);
		whipHeadUpRgt[3] = whipParts.crop(width * 3, height * 3, width, height);
		
		whipHeadDwnRgt2 = new BufferedImage[4];
		whipHeadDwnRgt2[0] = whipParts.crop(0, height*7, width, height);
		whipHeadDwnRgt2[1] = whipParts.crop(width, height*7, width, height);
		whipHeadDwnRgt2[2] = whipParts.crop(width*2, height*7, width, height);
		whipHeadDwnRgt2[3] = whipParts.crop(width*3, height*7, width, height);
		
		whipHeadDwnLft2 = new BufferedImage[4];
		whipHeadDwnLft2[0] = whipParts.crop(0, height*6, width, height);
		whipHeadDwnLft2[1] = whipParts.crop(width, height*6, width, height);
		whipHeadDwnLft2[2] = whipParts.crop(width * 2, height*6, width, height);
		whipHeadDwnLft2[3] = whipParts.crop(width * 3, height*6, width, height);
		
		whipHeadUpLft2 = new BufferedImage[4];
		whipHeadUpLft2[0] = whipParts.crop(0, height * 8, width, height);
		whipHeadUpLft2[1] = whipParts.crop(width, height * 8, width, height);
		whipHeadUpLft2[2] = whipParts.crop(width * 2, height * 8, width, height);
		whipHeadUpLft2[3] = whipParts.crop(width * 3, height * 8, width, height);
		
		whipHeadUpRgt2 = new BufferedImage[4];
		whipHeadUpRgt2[0] = whipParts.crop(0, height * 9, width, height);
		whipHeadUpRgt2[1] = whipParts.crop(width, height * 9, width, height);
		whipHeadUpRgt2[2] = whipParts.crop(width * 2, height * 9, width, height);
		whipHeadUpRgt2[3] = whipParts.crop(width * 3, height * 9, width, height);
		
		whipBody = new BufferedImage[4];
		whipBody[0] = whipParts.crop(0, height * 4, width, height);
		whipBody[1] = whipParts.crop(width, height * 4, width, height);
		whipBody[2] = whipParts.crop(0, height * 4, width, height);
		whipBody[3] = whipParts.crop(width*2, height * 4, width, height);
		
		whipBodyFins = new BufferedImage[4];
		whipBodyFins[0] = whipParts.crop(0, height * 5, width, height);
		whipBodyFins[1] = whipParts.crop(width, height * 5, width, height);
		whipBodyFins[2] = whipParts.crop(0, height * 5, width, height);
		whipBodyFins[3] = whipParts.crop(width*2, height * 5, width, height);
		
		whipTail = new BufferedImage[4];
		whipTail[0] = whipParts.crop(0, height*2, width, height);
		whipTail[1] = whipParts.crop(width, height*2, width, height);
		whipTail[2] = whipParts.crop(0, height*2, width, height);
		whipTail[3] = whipParts.crop(width, height*2, width, height);

		whipDwn = new BufferedImage[4];
		whipDwn[0] = mainItems.crop(0, height*5, 41, 38);
		whipDwn[1] = mainItems.crop(41, height*5, 41, 38);
		whipDwn[2] = mainItems.crop(82, height*5, 41, 38);
		whipDwn[3] = mainItems.crop(123, height*5, 41, 38);
		
		whipUp = new BufferedImage[4];
		whipUp[0] = mainItems.crop(0, height*5 + 38, 41, 38);
		whipUp[1] = mainItems.crop(41, height*5 + 38, 41, 38);
		whipUp[2] = mainItems.crop(82, height*5 + 38, 41, 38);
		whipUp[3] = mainItems.crop(123, height*5 + 38, 41, 38);
		
		whipLft = new BufferedImage[4];
		whipLft[0] = mainItems.crop(0, height*5 + 76, 41, 38);
		whipLft[1] = mainItems.crop(41, height*5 + 76, 41, 38);
		whipLft[2] = mainItems.crop(82, height*5 + 76, 41, 38);
		whipLft[3] = mainItems.crop(123, height*5 + 76, 41, 38);
		
		whipRgt = new BufferedImage[4];
		whipRgt[0] = mainItems.crop(82, height*5 + 114, 41, 38);
		whipRgt[1] = mainItems.crop(41, height*5 + 114, 41, 38);
		whipRgt[2] = mainItems.crop(0, height*5 + 114, 41, 38);
		whipRgt[3] = mainItems.crop(0, height*5 + 114, 41, 38);
		
		gThrustDownLeft = new BufferedImage[4];
		gThrustDownLeft[0] = mainItems.crop(0, 0, width, height);
		gThrustDownLeft[1] = mainItems.crop(width, 0, width, height);
		gThrustDownLeft[2] = mainItems.crop(width * 2, 0, width, height);
		gThrustDownLeft[3] = mainItems.crop(width * 3, 0, width, height);
		
		gThrustDownRight = new BufferedImage[4];
		gThrustDownRight[0] = mainItems.crop(0, height, width, height);
		gThrustDownRight[1] = mainItems.crop(width, height, width, height);
		gThrustDownRight[2] = mainItems.crop(width * 2, height, width, height);
		gThrustDownRight[3] = mainItems.crop(width * 3, height, width, height);
		
		gThrustUpLeft = new BufferedImage[4];
		gThrustUpLeft[0] = mainItems.crop(0, height * 2, width, height);
		gThrustUpLeft[1] = mainItems.crop(width, height * 2, width, height);
		gThrustUpLeft[2] = mainItems.crop(width * 2, height * 2, width, height);
		gThrustUpLeft[3] = mainItems.crop(width * 3, height * 2, width, height);
		
		gThrustUpRight = new BufferedImage[4];
		gThrustUpRight[0] = mainItems.crop(0, height * 3, width, height);
		gThrustUpRight[1] = mainItems.crop(width, height * 3, width, height);
		gThrustUpRight[2] = mainItems.crop(width * 2, height * 3, width, height);
		gThrustUpRight[3] = mainItems.crop(width * 3, height * 3, width, height);
				
		playerFallingDown = new BufferedImage[2];
		playerFallingDown[0] = heroSprites2.crop(0, 0, width, height);
		playerFallingDown[1] = heroSprites2.crop(width, 0, width, height);
		
		playerFallingUp = new BufferedImage[2];
		playerFallingUp[0] = heroSprites2.crop(0, height, width, height);
		playerFallingUp[1] = heroSprites2.crop(width, height, width, height);
		
		playerFallingLeft = new BufferedImage[2];
		playerFallingLeft[0] = heroSprites2.crop(0, height * 2, width, height);
		playerFallingLeft[1] = heroSprites2.crop(width, height * 2, width, height);
		
		playerFallingRight = new BufferedImage[2];
		playerFallingRight[0] = heroSprites2.crop(0, height * 3, width, height);
		playerFallingRight[1] = heroSprites2.crop(width, height * 3, width, height);
		
		playerClimbing = new BufferedImage[6];
		playerClimbing[0] = heroSprites2.crop(0, height * 4, width, height);
		playerClimbing[1] = heroSprites2.crop(width, height * 4, width, height);
		playerClimbing[2] = heroSprites2.crop(width * 2, height * 4, width, height);
		playerClimbing[3] = heroSprites2.crop(width * 3, height * 4, width, height);
		playerClimbing[4] = heroSprites2.crop(width * 4, height * 4, width, height);
		playerClimbing[5] = heroSprites2.crop(width * 5, height * 4, width, height);
		
		playerCheering = new BufferedImage[8];
		playerCheering[0] = heroSprites2.crop(0, height * 5, width, height + 2);
		playerCheering[1] = heroSprites2.crop(width, height * 5, width, height + 2);
		playerCheering[2] = heroSprites2.crop(width * 2, height * 5, width, height + 2);
		playerCheering[3] = heroSprites2.crop(width * 3, height * 5, width, height + 2);
		playerCheering[4] = heroSprites2.crop(width * 4, height * 5, width, height + 2);
		playerCheering[5] = heroSprites2.crop(width * 5, height * 5, width, height + 2);
		playerCheering[6] = heroSprites2.crop(width * 6, height * 5, width, height + 2);
		playerCheering[7] = heroSprites2.crop(width * 7, height * 5, width, height + 2);
		
		playerStationary = new BufferedImage[8];
		playerStationary[4] = heroSprites.crop(0, 0, width, height);
		playerStationary[6] = heroSprites.crop(0, height, width, height);
		playerStationary[0] = heroSprites.crop(0, height * 2, width, height);
		playerStationary[2] = heroSprites.crop(0, height * 3, width, height);
		playerStationary[5] = heroSprites.crop(0, height * 4, width, height);
		playerStationary[3] = heroSprites.crop(0, height * 5, width, height);
		playerStationary[7] = heroSprites.crop(0, height * 6, width, height);
		playerStationary[1] = heroSprites.crop(0, height * 7, width, height);
		
		playerDown = new BufferedImage[6];
		playerDown[0] = heroSprites.crop(width, 0, width, height);
		playerDown[1] = heroSprites.crop(width * 2, 0, width, height);
		playerDown[2] = heroSprites.crop(width * 3, 0, width, height);
		playerDown[3] = heroSprites.crop(width * 4, 0, width, height);
		playerDown[4] = heroSprites.crop(width * 5, 0, width, height);
		playerDown[5] = heroSprites.crop(width * 6, 0, width, height);	
		
		playerLeft = new BufferedImage[6];
		playerLeft[0] = heroSprites.crop(width, height, width, height);
		playerLeft[1] = heroSprites.crop(width * 2, height, width, height);
		playerLeft[2] = heroSprites.crop(width * 3, height, width, height);
		playerLeft[3] = heroSprites.crop(width * 4, height, width, height);
		playerLeft[4] = heroSprites.crop(width * 5, height, width, height);
		playerLeft[5] = heroSprites.crop(width * 6, height, width, height);
		
		playerUp = new BufferedImage[6];
		playerUp[0] = heroSprites.crop(width, height * 2, width, height);
		playerUp[1] = heroSprites.crop(width * 2, height * 2, width, height);
		playerUp[2] = heroSprites.crop(width * 3, height * 2, width, height);
		playerUp[3] = heroSprites.crop(width * 4, height * 2, width, height);
		playerUp[4] = heroSprites.crop(width * 5, height * 2, width, height);
		playerUp[5] = heroSprites.crop(width * 6, height * 2, width, height);
		
		playerRight = new BufferedImage[6];
		playerRight[0] = heroSprites.crop(width, height * 3, width, height);
		playerRight[1] = heroSprites.crop(width * 2, height * 3, width, height);
		playerRight[2] = heroSprites.crop(width * 3, height * 3, width, height);
		playerRight[3] = heroSprites.crop(width * 4, height * 3, width, height);
		playerRight[4] = heroSprites.crop(width * 5, height * 3, width, height);
		playerRight[5] = heroSprites.crop(width * 6, height * 3, width, height);
		
		playerDownLeft = new BufferedImage[6];
		playerDownLeft[0] = heroSprites.crop(width, height * 4, width, height);
		playerDownLeft[1] = heroSprites.crop(width * 2, height * 4, width, height);
		playerDownLeft[2] = heroSprites.crop(width * 3, height * 4, width, height);
		playerDownLeft[3] = heroSprites.crop(width * 4, height * 4, width, height);
		playerDownLeft[4] = heroSprites.crop(width * 5, height * 4, width, height);
		playerDownLeft[5] = heroSprites.crop(width * 6, height * 4, width, height);
		
		playerDownRight = new BufferedImage[6];
		playerDownRight[0] = heroSprites.crop(width, height * 5, width, height);
		playerDownRight[1] = heroSprites.crop(width * 2, height * 5, width, height);
		playerDownRight[2] = heroSprites.crop(width * 3, height * 5, width, height);
		playerDownRight[3] = heroSprites.crop(width * 4, height * 5, width, height);
		playerDownRight[4] = heroSprites.crop(width * 5, height * 5, width, height);
		playerDownRight[5] = heroSprites.crop(width * 6, height * 5, width, height);
		
		playerUpLeft = new BufferedImage[6];
		playerUpLeft[0] = heroSprites.crop(width, height * 6, width, height);
		playerUpLeft[1] = heroSprites.crop(width * 2, height * 6, width, height);
		playerUpLeft[2] = heroSprites.crop(width * 3, height * 6, width, height);
		playerUpLeft[3] = heroSprites.crop(width * 4, height * 6, width, height);
		playerUpLeft[4] = heroSprites.crop(width * 5, height * 6, width, height);
		playerUpLeft[5] = heroSprites.crop(width * 6, height * 6, width, height);
		
		playerUpRight = new BufferedImage[6];
		playerUpRight[0] = heroSprites.crop(width, height * 7, width, height);
		playerUpRight[1] = heroSprites.crop(width * 2, height * 7, width, height);
		playerUpRight[2] = heroSprites.crop(width * 3, height * 7, width, height);
		playerUpRight[3] = heroSprites.crop(width * 4, height * 7, width, height);
		playerUpRight[4] = heroSprites.crop(width * 5, height * 7, width, height);
		playerUpRight[5] = heroSprites.crop(width * 6, height * 7, width, height);
		
		
		playerStationaryMonkey = new BufferedImage[8];
		playerStationaryMonkey[4] = heroMonkeySprites.crop(0, 0, width, height);
		playerStationaryMonkey[6] = heroMonkeySprites.crop(0, height, width, height);
		playerStationaryMonkey[0] = heroMonkeySprites.crop(0, height * 2, width, height);
		playerStationaryMonkey[2] = heroMonkeySprites.crop(0, height * 3, width, height);
		playerStationaryMonkey[5] = heroMonkeySprites.crop(0, height * 4, width, height);
		playerStationaryMonkey[3] = heroMonkeySprites.crop(0, height * 5, width, height);
		playerStationaryMonkey[7] = heroMonkeySprites.crop(0, height * 6, width, height);
		playerStationaryMonkey[1] = heroMonkeySprites.crop(0, height * 7, width, height);
		
		playerDownMonkey = new BufferedImage[6];
		playerDownMonkey[0] = heroMonkeySprites.crop(width, 0, width, height);
		playerDownMonkey[1] = heroMonkeySprites.crop(width * 2, 0, width, height);
		playerDownMonkey[2] = heroMonkeySprites.crop(width * 3, 0, width, height);
		playerDownMonkey[3] = heroMonkeySprites.crop(width * 4, 0, width, height);
		playerDownMonkey[4] = heroMonkeySprites.crop(width * 5, 0, width, height);
		playerDownMonkey[5] = heroMonkeySprites.crop(width * 6, 0, width, height);	
		
		playerLeftMonkey = new BufferedImage[6];
		playerLeftMonkey[0] = heroMonkeySprites.crop(width, height, width, height);
		playerLeftMonkey[1] = heroMonkeySprites.crop(width * 2, height, width, height);
		playerLeftMonkey[2] = heroMonkeySprites.crop(width * 3, height, width, height);
		playerLeftMonkey[3] = heroMonkeySprites.crop(width * 4, height, width, height);
		playerLeftMonkey[4] = heroMonkeySprites.crop(width * 5, height, width, height);
		playerLeftMonkey[5] = heroMonkeySprites.crop(width * 6, height, width, height);
		
		playerUpMonkey = new BufferedImage[6];
		playerUpMonkey[0] = heroMonkeySprites.crop(width, height * 2, width, height);
		playerUpMonkey[1] = heroMonkeySprites.crop(width * 2, height * 2, width, height);
		playerUpMonkey[2] = heroMonkeySprites.crop(width * 3, height * 2, width, height);
		playerUpMonkey[3] = heroMonkeySprites.crop(width * 4, height * 2, width, height);
		playerUpMonkey[4] = heroMonkeySprites.crop(width * 5, height * 2, width, height);
		playerUpMonkey[5] = heroMonkeySprites.crop(width * 6, height * 2, width, height);
		
		playerRightMonkey = new BufferedImage[6];
		playerRightMonkey[0] = heroMonkeySprites.crop(width, height * 3, width, height);
		playerRightMonkey[1] = heroMonkeySprites.crop(width * 2, height * 3, width, height);
		playerRightMonkey[2] = heroMonkeySprites.crop(width * 3, height * 3, width, height);
		playerRightMonkey[3] = heroMonkeySprites.crop(width * 4, height * 3, width, height);
		playerRightMonkey[4] = heroMonkeySprites.crop(width * 5, height * 3, width, height);
		playerRightMonkey[5] = heroMonkeySprites.crop(width * 6, height * 3, width, height);
		
		playerDownLeftMonkey = new BufferedImage[6];
		playerDownLeftMonkey[0] = heroMonkeySprites.crop(width, height * 4, width, height);
		playerDownLeftMonkey[1] = heroMonkeySprites.crop(width * 2, height * 4, width, height);
		playerDownLeftMonkey[2] = heroMonkeySprites.crop(width * 3, height * 4, width, height);
		playerDownLeftMonkey[3] = heroMonkeySprites.crop(width * 4, height * 4, width, height);
		playerDownLeftMonkey[4] = heroMonkeySprites.crop(width * 5, height * 4, width, height);
		playerDownLeftMonkey[5] = heroMonkeySprites.crop(width * 6, height * 4, width, height);
		
		playerDownRightMonkey = new BufferedImage[6];
		playerDownRightMonkey[0] = heroMonkeySprites.crop(width, height * 5, width, height);
		playerDownRightMonkey[1] = heroMonkeySprites.crop(width * 2, height * 5, width, height);
		playerDownRightMonkey[2] = heroMonkeySprites.crop(width * 3, height * 5, width, height);
		playerDownRightMonkey[3] = heroMonkeySprites.crop(width * 4, height * 5, width, height);
		playerDownRightMonkey[4] = heroMonkeySprites.crop(width * 5, height * 5, width, height);
		playerDownRightMonkey[5] = heroMonkeySprites.crop(width * 6, height * 5, width, height);
		
		playerUpLeftMonkey = new BufferedImage[6];
		playerUpLeftMonkey[0] = heroMonkeySprites.crop(width, height * 6, width, height);
		playerUpLeftMonkey[1] = heroMonkeySprites.crop(width * 2, height * 6, width, height);
		playerUpLeftMonkey[2] = heroMonkeySprites.crop(width * 3, height * 6, width, height);
		playerUpLeftMonkey[3] = heroMonkeySprites.crop(width * 4, height * 6, width, height);
		playerUpLeftMonkey[4] = heroMonkeySprites.crop(width * 5, height * 6, width, height);
		playerUpLeftMonkey[5] = heroMonkeySprites.crop(width * 6, height * 6, width, height);
		
		playerUpRightMonkey = new BufferedImage[6];
		playerUpRightMonkey[0] = heroMonkeySprites.crop(width, height * 7, width, height);
		playerUpRightMonkey[1] = heroMonkeySprites.crop(width * 2, height * 7, width, height);
		playerUpRightMonkey[2] = heroMonkeySprites.crop(width * 3, height * 7, width, height);
		playerUpRightMonkey[3] = heroMonkeySprites.crop(width * 4, height * 7, width, height);
		playerUpRightMonkey[4] = heroMonkeySprites.crop(width * 5, height * 7, width, height);
		playerUpRightMonkey[5] = heroMonkeySprites.crop(width * 6, height * 7, width, height);
		
		playerStationaryShadow = new BufferedImage[8];
		playerStationaryShadow[4] = heroShadowSprites.crop(0, 0, width, height);
		playerStationaryShadow[6] = heroShadowSprites.crop(0, height, width, height);
		playerStationaryShadow[0] = heroShadowSprites.crop(0, height * 2, width, height);
		playerStationaryShadow[2] = heroShadowSprites.crop(0, height * 3, width, height);
		playerStationaryShadow[5] = heroShadowSprites.crop(0, height * 4, width, height);
		playerStationaryShadow[3] = heroShadowSprites.crop(0, height * 5, width, height);
		playerStationaryShadow[7] = heroShadowSprites.crop(0, height * 6, width, height);
		playerStationaryShadow[1] = heroShadowSprites.crop(0, height * 7, width, height);
		
		playerDownShadow = new BufferedImage[6];
		playerDownShadow[0] = heroShadowSprites.crop(width, 0, width, height);
		playerDownShadow[1] = heroShadowSprites.crop(width * 2, 0, width, height);
		playerDownShadow[2] = heroShadowSprites.crop(width * 3, 0, width, height);
		playerDownShadow[3] = heroShadowSprites.crop(width * 4, 0, width, height);
		playerDownShadow[4] = heroShadowSprites.crop(width * 5, 0, width, height);
		playerDownShadow[5] = heroShadowSprites.crop(width * 6, 0, width, height);	
		
		playerLeftShadow = new BufferedImage[6];
		playerLeftShadow[0] = heroShadowSprites.crop(width, height, width, height);
		playerLeftShadow[1] = heroShadowSprites.crop(width * 2, height, width, height);
		playerLeftShadow[2] = heroShadowSprites.crop(width * 3, height, width, height);
		playerLeftShadow[3] = heroShadowSprites.crop(width * 4, height, width, height);
		playerLeftShadow[4] = heroShadowSprites.crop(width * 5, height, width, height);
		playerLeftShadow[5] = heroShadowSprites.crop(width * 6, height, width, height);
		
		playerUpShadow = new BufferedImage[6];
		playerUpShadow[0] = heroShadowSprites.crop(width, height * 2, width, height);
		playerUpShadow[1] = heroShadowSprites.crop(width * 2, height * 2, width, height);
		playerUpShadow[2] = heroShadowSprites.crop(width * 3, height * 2, width, height);
		playerUpShadow[3] = heroShadowSprites.crop(width * 4, height * 2, width, height);
		playerUpShadow[4] = heroShadowSprites.crop(width * 5, height * 2, width, height);
		playerUpShadow[5] = heroShadowSprites.crop(width * 6, height * 2, width, height);
		
		playerRightShadow = new BufferedImage[6];
		playerRightShadow[0] = heroShadowSprites.crop(width, height * 3, width, height);
		playerRightShadow[1] = heroShadowSprites.crop(width * 2, height * 3, width, height);
		playerRightShadow[2] = heroShadowSprites.crop(width * 3, height * 3, width, height);
		playerRightShadow[3] = heroShadowSprites.crop(width * 4, height * 3, width, height);
		playerRightShadow[4] = heroShadowSprites.crop(width * 5, height * 3, width, height);
		playerRightShadow[5] = heroShadowSprites.crop(width * 6, height * 3, width, height);
		
		playerDownLeftShadow = new BufferedImage[6];
		playerDownLeftShadow[0] = heroShadowSprites.crop(width, height * 4, width, height);
		playerDownLeftShadow[1] = heroShadowSprites.crop(width * 2, height * 4, width, height);
		playerDownLeftShadow[2] = heroShadowSprites.crop(width * 3, height * 4, width, height);
		playerDownLeftShadow[3] = heroShadowSprites.crop(width * 4, height * 4, width, height);
		playerDownLeftShadow[4] = heroShadowSprites.crop(width * 5, height * 4, width, height);
		playerDownLeftShadow[5] = heroShadowSprites.crop(width * 6, height * 4, width, height);
		
		playerDownRightShadow = new BufferedImage[6];
		playerDownRightShadow[0] = heroShadowSprites.crop(width, height * 5, width, height);
		playerDownRightShadow[1] = heroShadowSprites.crop(width * 2, height * 5, width, height);
		playerDownRightShadow[2] = heroShadowSprites.crop(width * 3, height * 5, width, height);
		playerDownRightShadow[3] = heroShadowSprites.crop(width * 4, height * 5, width, height);
		playerDownRightShadow[4] = heroShadowSprites.crop(width * 5, height * 5, width, height);
		playerDownRightShadow[5] = heroShadowSprites.crop(width * 6, height * 5, width, height);
		
		playerUpLeftShadow = new BufferedImage[6];
		playerUpLeftShadow[0] = heroShadowSprites.crop(width, height * 6, width, height);
		playerUpLeftShadow[1] = heroShadowSprites.crop(width * 2, height * 6, width, height);
		playerUpLeftShadow[2] = heroShadowSprites.crop(width * 3, height * 6, width, height);
		playerUpLeftShadow[3] = heroShadowSprites.crop(width * 4, height * 6, width, height);
		playerUpLeftShadow[4] = heroShadowSprites.crop(width * 5, height * 6, width, height);
		playerUpLeftShadow[5] = heroShadowSprites.crop(width * 6, height * 6, width, height);
		
		playerUpRightShadow = new BufferedImage[6];
		playerUpRightShadow[0] = heroShadowSprites.crop(width, height * 7, width, height);
		playerUpRightShadow[1] = heroShadowSprites.crop(width * 2, height * 7, width, height);
		playerUpRightShadow[2] = heroShadowSprites.crop(width * 3, height * 7, width, height);
		playerUpRightShadow[3] = heroShadowSprites.crop(width * 4, height * 7, width, height);
		playerUpRightShadow[4] = heroShadowSprites.crop(width * 5, height * 7, width, height);
		playerUpRightShadow[5] = heroShadowSprites.crop(width * 6, height * 7, width, height);
		
		
		playerStationaryGunLance = new BufferedImage[8];
		playerStationaryGunLance[0] = gunLanceSprites.crop(0, 0, 35, 40);
		playerStationaryGunLance[1] = gunLanceSprites.crop(0, 40, 35, 40);
		playerStationaryGunLance[2] = gunLanceSprites.crop(0, 80, 35, 40);
		playerStationaryGunLance[3] = gunLanceSprites.crop(0, 120, 35, 40);
		playerStationaryGunLance[4] = gunLanceSprites.crop(0, 160, 35, 40);
		playerStationaryGunLance[5] = gunLanceSprites.crop(0, 200, 35, 40);
		playerStationaryGunLance[6] = gunLanceSprites.crop(0, 240, 35, 40);
		playerStationaryGunLance[7] = gunLanceSprites.crop(0, 280, 35, 40);
		
		
		playerUpGunLance = new BufferedImage[6];
		playerUpGunLance[0] = gunLanceSprites.crop(35, 0, 35, 40);
		playerUpGunLance[1] = gunLanceSprites.crop(70, 0, 35, 40);
		playerUpGunLance[2] = gunLanceSprites.crop(105, 0, 35, 40);
		playerUpGunLance[3] = gunLanceSprites.crop(140, 0, 35, 40);
		playerUpGunLance[4] = gunLanceSprites.crop(175, 0, 35, 40);
		playerUpGunLance[5] = gunLanceSprites.crop(210, 0, 35, 40);
		
		playerUpRightGunLance = new BufferedImage[6];
		playerUpRightGunLance[0] = gunLanceSprites.crop(35, 40, 35, 40);
		playerUpRightGunLance[1] = gunLanceSprites.crop(70, 40, 35, 40);
		playerUpRightGunLance[2] = gunLanceSprites.crop(105, 40, 35, 40);
		playerUpRightGunLance[3] = gunLanceSprites.crop(140, 40, 35, 40);
		playerUpRightGunLance[4] = gunLanceSprites.crop(175, 40, 35, 40);
		playerUpRightGunLance[5] = gunLanceSprites.crop(210, 40, 35, 40);
		
		playerRightGunLance = new BufferedImage[6];
		playerRightGunLance[0] = gunLanceSprites.crop(35, 80, 35, 40);
		playerRightGunLance[1] = gunLanceSprites.crop(70, 80, 35, 40);
		playerRightGunLance[2] = gunLanceSprites.crop(105, 80, 35, 40);
		playerRightGunLance[3] = gunLanceSprites.crop(140, 80, 35, 40);
		playerRightGunLance[4] = gunLanceSprites.crop(175, 80, 35, 40);
		playerRightGunLance[5] = gunLanceSprites.crop(210, 80, 35, 40);
		
		playerDownRightGunLance = new BufferedImage[6];
		playerDownRightGunLance[0] = gunLanceSprites.crop(35, 120, 35, 40);
		playerDownRightGunLance[1] = gunLanceSprites.crop(70, 120, 35, 40);
		playerDownRightGunLance[2] = gunLanceSprites.crop(105, 120, 35, 40);
		playerDownRightGunLance[3] = gunLanceSprites.crop(140, 120, 35, 40);
		playerDownRightGunLance[4] = gunLanceSprites.crop(175, 120, 35, 40);
		playerDownRightGunLance[5] = gunLanceSprites.crop(210, 120, 35, 40);
		
		playerDownGunLance = new BufferedImage[6];
		playerDownGunLance[0] = gunLanceSprites.crop(35, 160, 35, 40);
		playerDownGunLance[1] = gunLanceSprites.crop(70, 160, 35, 40);
		playerDownGunLance[2] = gunLanceSprites.crop(105, 160, 35, 40);
		playerDownGunLance[3] = gunLanceSprites.crop(140, 160, 35, 40);
		playerDownGunLance[4] = gunLanceSprites.crop(175, 160, 35, 40);
		playerDownGunLance[5] = gunLanceSprites.crop(210, 160, 35, 40);
		
		playerDownLeftGunLance = new BufferedImage[6];
		playerDownLeftGunLance[0] = gunLanceSprites.crop(35, 200, 35, 40);
		playerDownLeftGunLance[1] = gunLanceSprites.crop(70, 200, 35, 40);
		playerDownLeftGunLance[2] = gunLanceSprites.crop(105, 200, 35, 40);
		playerDownLeftGunLance[3] = gunLanceSprites.crop(140, 200, 35, 40);
		playerDownLeftGunLance[4] = gunLanceSprites.crop(175, 200, 35, 40);
		playerDownLeftGunLance[5] = gunLanceSprites.crop(210, 200, 35, 40);
		
		playerLeftGunLance = new BufferedImage[6];
		playerLeftGunLance[0] = gunLanceSprites.crop(35, 240, 35, 40);
		playerLeftGunLance[1] = gunLanceSprites.crop(70, 240, 35, 40);
		playerLeftGunLance[2] = gunLanceSprites.crop(105, 240, 35, 40);
		playerLeftGunLance[3] = gunLanceSprites.crop(140, 240, 35, 40);
		playerLeftGunLance[4] = gunLanceSprites.crop(175, 240, 35, 40);
		playerLeftGunLance[5] = gunLanceSprites.crop(210, 240, 35, 40);
		
		playerUpLeftGunLance = new BufferedImage[6];
		playerUpLeftGunLance[0] = gunLanceSprites.crop(35, 280, 35, 40);
		playerUpLeftGunLance[1] = gunLanceSprites.crop(70, 280, 35, 40);
		playerUpLeftGunLance[2] = gunLanceSprites.crop(105, 280, 35, 40);
		playerUpLeftGunLance[3] = gunLanceSprites.crop(140, 280, 35, 40);
		playerUpLeftGunLance[4] = gunLanceSprites.crop(175, 280, 35, 40);
		playerUpLeftGunLance[5] = gunLanceSprites.crop(210, 280, 35, 40);
		
		attackUpGunLance = new BufferedImage[4];
		attackUpGunLance[0] = gunLanceAttack.crop(0, 0, 35, 40);
		attackUpGunLance[1] = gunLanceAttack.crop(35, 0, 35, 40);
		attackUpGunLance[2] = gunLanceAttack.crop(70, 0, 35, 40);
		attackUpGunLance[3] = gunLanceAttack.crop(105, 0, 35, 40);
		
		attackUpRightGunLance = new BufferedImage[4];
		attackUpRightGunLance[0] = gunLanceAttack.crop(0, 40, 35, 40);
		attackUpRightGunLance[1] = gunLanceAttack.crop(35, 40, 35, 40);
		attackUpRightGunLance[2] = gunLanceAttack.crop(70, 40, 35, 40);
		attackUpRightGunLance[3] = gunLanceAttack.crop(105, 40, 35, 40);
		
		attackRightGunLance = new BufferedImage[4];
		attackRightGunLance[0] = gunLanceAttack.crop(0, 80, 35, 40);
		attackRightGunLance[1] = gunLanceAttack.crop(35, 80, 35, 40);
		attackRightGunLance[2] = gunLanceAttack.crop(70, 80, 35, 40);
		attackRightGunLance[3] = gunLanceAttack.crop(105, 80, 35, 40);
		
		attackDownRightGunLance = new BufferedImage[4];
		attackDownRightGunLance[0] = gunLanceAttack.crop(0, 120, 35, 40);
		attackDownRightGunLance[1] = gunLanceAttack.crop(35, 120, 35, 40);
		attackDownRightGunLance[2] = gunLanceAttack.crop(70, 120, 35, 40);
		attackDownRightGunLance[3] = gunLanceAttack.crop(105, 120, 35, 40);
		
		attackDownGunLance = new BufferedImage[4];
		attackDownGunLance[0] = gunLanceAttack.crop(0, 160, 35, 40);
		attackDownGunLance[1] = gunLanceAttack.crop(35, 160, 35, 40);
		attackDownGunLance[2] = gunLanceAttack.crop(70, 160, 35, 40);
		attackDownGunLance[3] = gunLanceAttack.crop(105, 160, 35, 40);
		
		attackDownLeftGunLance = new BufferedImage[4];
		attackDownLeftGunLance[0] = gunLanceAttack.crop(0, 200, 35, 40);
		attackDownLeftGunLance[1] = gunLanceAttack.crop(35, 200, 35, 40);
		attackDownLeftGunLance[2] = gunLanceAttack.crop(70, 200, 35, 40);
		attackDownLeftGunLance[3] = gunLanceAttack.crop(105, 200, 35, 40);
		
		attackLeftGunLance = new BufferedImage[4];
		attackLeftGunLance[0] = gunLanceAttack.crop(0, 240, 35, 40);
		attackLeftGunLance[1] = gunLanceAttack.crop(35, 240, 35, 40);
		attackLeftGunLance[2] = gunLanceAttack.crop(70, 240, 35, 40);
		attackLeftGunLance[3] = gunLanceAttack.crop(105, 240, 35, 40);
		
		attackUpLeftGunLance = new BufferedImage[4];
		attackUpLeftGunLance[0] = gunLanceAttack.crop(0, 280, 35, 40);
		attackUpLeftGunLance[1] = gunLanceAttack.crop(35, 280, 35, 40);
		attackUpLeftGunLance[2] = gunLanceAttack.crop(70, 280, 35, 40);
		attackUpLeftGunLance[3] = gunLanceAttack.crop(105, 280, 35, 40);
	}
	
	public static void loadPlayer2()
	{
		SpriteSheet p2Sprites = new SpriteSheet(ResourceLoader.loadTexture("sebastian.png"));
		
		player2Stationary = new BufferedImage[8];
		player2Stationary[4] = p2Sprites.crop(0, 0, width, height);
		player2Stationary[6] = p2Sprites.crop(0, height, width, height);
		player2Stationary[0] = p2Sprites.crop(0, height * 2, width, height);
		player2Stationary[2] = p2Sprites.crop(0, height * 3, width, height);
		player2Stationary[5] = p2Sprites.crop(0, height * 4, width, height);
		player2Stationary[3] = p2Sprites.crop(0, height * 5, width, height);
		player2Stationary[7] = p2Sprites.crop(0, height * 6, width, height);
		player2Stationary[1] = p2Sprites.crop(0, height * 7, width, height);
		
		player2Down = new BufferedImage[6];
		player2Down[0] = p2Sprites.crop(width, 0, width, height);
		player2Down[1] = p2Sprites.crop(width * 2, 0, width, height);
		player2Down[2] = p2Sprites.crop(width * 3, 0, width, height);
		player2Down[3] = p2Sprites.crop(width * 4, 0, width, height);
		player2Down[4] = p2Sprites.crop(width * 5, 0, width, height);
		player2Down[5] = p2Sprites.crop(width * 6, 0, width, height);	
		
		player2Left = new BufferedImage[6];
		player2Left[0] = p2Sprites.crop(width, height, width, height);
		player2Left[1] = p2Sprites.crop(width * 2, height, width, height);
		player2Left[2] = p2Sprites.crop(width * 3, height, width, height);
		player2Left[3] = p2Sprites.crop(width * 4, height, width, height);
		player2Left[4] = p2Sprites.crop(width * 5, height, width, height);
		player2Left[5] = p2Sprites.crop(width * 6, height, width, height);
		
		player2Up = new BufferedImage[6];
		player2Up[0] = p2Sprites.crop(width, height * 2, width, height);
		player2Up[1] = p2Sprites.crop(width * 2, height * 2, width, height);
		player2Up[2] = p2Sprites.crop(width * 3, height * 2, width, height);
		player2Up[3] = p2Sprites.crop(width * 4, height * 2, width, height);
		player2Up[4] = p2Sprites.crop(width * 5, height * 2, width, height);
		player2Up[5] = p2Sprites.crop(width * 6, height * 2, width, height);
		
		player2Right = new BufferedImage[6];
		player2Right[0] = p2Sprites.crop(width, height * 3, width, height);
		player2Right[1] = p2Sprites.crop(width * 2, height * 3, width, height);
		player2Right[2] = p2Sprites.crop(width * 3, height * 3, width, height);
		player2Right[3] = p2Sprites.crop(width * 4, height * 3, width, height);
		player2Right[4] = p2Sprites.crop(width * 5, height * 3, width, height);
		player2Right[5] = p2Sprites.crop(width * 6, height * 3, width, height);
		
		player2DownLeft = new BufferedImage[6];
		player2DownLeft[0] = p2Sprites.crop(width, height * 4, width, height);
		player2DownLeft[1] = p2Sprites.crop(width * 2, height * 4, width, height);
		player2DownLeft[2] = p2Sprites.crop(width * 3, height * 4, width, height);
		player2DownLeft[3] = p2Sprites.crop(width * 4, height * 4, width, height);
		player2DownLeft[4] = p2Sprites.crop(width * 5, height * 4, width, height);
		player2DownLeft[5] = p2Sprites.crop(width * 6, height * 4, width, height);
		
		player2DownRight = new BufferedImage[6];
		player2DownRight[0] = p2Sprites.crop(width, height * 5, width, height);
		player2DownRight[1] = p2Sprites.crop(width * 2, height * 5, width, height);
		player2DownRight[2] = p2Sprites.crop(width * 3, height * 5, width, height);
		player2DownRight[3] = p2Sprites.crop(width * 4, height * 5, width, height);
		player2DownRight[4] = p2Sprites.crop(width * 5, height * 5, width, height);
		player2DownRight[5] = p2Sprites.crop(width * 6, height * 5, width, height);
		
		player2UpLeft = new BufferedImage[6];
		player2UpLeft[0] = p2Sprites.crop(width, height * 6, width, height);
		player2UpLeft[1] = p2Sprites.crop(width * 2, height * 6, width, height);
		player2UpLeft[2] = p2Sprites.crop(width * 3, height * 6, width, height);
		player2UpLeft[3] = p2Sprites.crop(width * 4, height * 6, width, height);
		player2UpLeft[4] = p2Sprites.crop(width * 5, height * 6, width, height);
		player2UpLeft[5] = p2Sprites.crop(width * 6, height * 6, width, height);
		
		player2UpRight = new BufferedImage[6];
		player2UpRight[0] = p2Sprites.crop(width, height * 7, width, height);
		player2UpRight[1] = p2Sprites.crop(width * 2, height * 7, width, height);
		player2UpRight[2] = p2Sprites.crop(width * 3, height * 7, width, height);
		player2UpRight[3] = p2Sprites.crop(width * 4, height * 7, width, height);
		player2UpRight[4] = p2Sprites.crop(width * 5, height * 7, width, height);
		player2UpRight[5] = p2Sprites.crop(width * 6, height * 7, width, height);
		
		player2Dead = new BufferedImage[3];
		player2Dead[0] = p2Sprites.crop(65, height * 8, width, height);
		player2Dead[1] = p2Sprites.crop(width + 2, height * 8, width, height);
		player2Dead[2] = p2Sprites.crop(0, height * 8, width + 2, height);
		
		player2Rise = new BufferedImage[3];
		player2Rise[0] = p2Sprites.crop(0, height * 8, width + 2, height);
		player2Rise[1] = p2Sprites.crop(width + 2, height * 8, width + 2, height);
		player2Rise[2] = p2Sprites.crop(68, height * 8, width + 2, height);
	}
	
	public static void loadPlayer3()
	{
		SpriteSheet p3Sprites = new SpriteSheet(ResourceLoader.loadTexture("serii.png"));
		
		player3Stationary = new BufferedImage[8];
		player3Stationary[4] = p3Sprites.crop(0, 0, width, height);
		player3Stationary[6] = p3Sprites.crop(0, height, width, height);
		player3Stationary[0] = p3Sprites.crop(0, height * 2, width, height);
		player3Stationary[2] = p3Sprites.crop(0, height * 3, width, height);
		player3Stationary[5] = p3Sprites.crop(0, height * 4, width, height);
		player3Stationary[3] = p3Sprites.crop(0, height * 5, width, height);
		player3Stationary[7] = p3Sprites.crop(0, height * 6, width, height);
		player3Stationary[1] = p3Sprites.crop(0, height * 7, width, height);
		
		player3Down = new BufferedImage[6];
		player3Down[0] = p3Sprites.crop(width, 0, width, height);
		player3Down[1] = p3Sprites.crop(width * 2, 0, width, height);
		player3Down[2] = p3Sprites.crop(width * 3, 0, width, height);
		player3Down[3] = p3Sprites.crop(width * 4, 0, width, height);
		player3Down[4] = p3Sprites.crop(width * 5, 0, width, height);
		player3Down[5] = p3Sprites.crop(width * 6, 0, width, height);	
		
		player3Left = new BufferedImage[6];
		player3Left[0] = p3Sprites.crop(width, height, width, height);
		player3Left[1] = p3Sprites.crop(width * 2, height, width, height);
		player3Left[2] = p3Sprites.crop(width * 3, height, width, height);
		player3Left[3] = p3Sprites.crop(width * 4, height, width, height);
		player3Left[4] = p3Sprites.crop(width * 5, height, width, height);
		player3Left[5] = p3Sprites.crop(width * 6, height, width, height);
		
		player3Up = new BufferedImage[6];
		player3Up[0] = p3Sprites.crop(width, height * 2, width, height);
		player3Up[1] = p3Sprites.crop(width * 2, height * 2, width, height);
		player3Up[2] = p3Sprites.crop(width * 3, height * 2, width, height);
		player3Up[3] = p3Sprites.crop(width * 4, height * 2, width, height);
		player3Up[4] = p3Sprites.crop(width * 5, height * 2, width, height);
		player3Up[5] = p3Sprites.crop(width * 6, height * 2, width, height);
		
		player3Right = new BufferedImage[6];
		player3Right[0] = p3Sprites.crop(width, height * 3, width, height);
		player3Right[1] = p3Sprites.crop(width * 2, height * 3, width, height);
		player3Right[2] = p3Sprites.crop(width * 3, height * 3, width, height);
		player3Right[3] = p3Sprites.crop(width * 4, height * 3, width, height);
		player3Right[4] = p3Sprites.crop(width * 5, height * 3, width, height);
		player3Right[5] = p3Sprites.crop(width * 6, height * 3, width, height);
		
		player3DownLeft = new BufferedImage[6];
		player3DownLeft[0] = p3Sprites.crop(width, height * 4, width, height);
		player3DownLeft[1] = p3Sprites.crop(width * 2, height * 4, width, height);
		player3DownLeft[2] = p3Sprites.crop(width * 3, height * 4, width, height);
		player3DownLeft[3] = p3Sprites.crop(width * 4, height * 4, width, height);
		player3DownLeft[4] = p3Sprites.crop(width * 5, height * 4, width, height);
		player3DownLeft[5] = p3Sprites.crop(width * 6, height * 4, width, height);
	
		player3DownRight = new BufferedImage[6];
		player3DownRight[0] = p3Sprites.crop(width, height * 5, width, height);
		player3DownRight[1] = p3Sprites.crop(width * 2, height * 5, width, height);
		player3DownRight[2] = p3Sprites.crop(width * 3, height * 5, width, height);
		player3DownRight[3] = p3Sprites.crop(width * 4, height * 5, width, height);
		player3DownRight[4] = p3Sprites.crop(width * 5, height * 5, width, height);
		player3DownRight[5] = p3Sprites.crop(width * 6, height * 5, width, height);
		
		player3UpLeft = new BufferedImage[6];
		player3UpLeft[0] = p3Sprites.crop(width, height * 6, width, height);
		player3UpLeft[1] = p3Sprites.crop(width * 2, height * 6, width, height);
		player3UpLeft[2] = p3Sprites.crop(width * 3, height * 6, width, height);
		player3UpLeft[3] = p3Sprites.crop(width * 4, height * 6, width, height);
		player3UpLeft[4] = p3Sprites.crop(width * 5, height * 6, width, height);
		player3UpLeft[5] = p3Sprites.crop(width * 6, height * 6, width, height);
	
		player3UpRight = new BufferedImage[6];
		player3UpRight[0] = p3Sprites.crop(width, height * 7, width, height);
		player3UpRight[1] = p3Sprites.crop(width * 2, height * 7, width, height);
		player3UpRight[2] = p3Sprites.crop(width * 3, height * 7, width, height);
		player3UpRight[3] = p3Sprites.crop(width * 4, height * 7, width, height);
		player3UpRight[4] = p3Sprites.crop(width * 5, height * 7, width, height);
		player3UpRight[5] = p3Sprites.crop(width * 6, height * 7, width, height);
		
		player3Dead = new BufferedImage[3];
		player3Dead[0] = p3Sprites.crop(65, height * 8, width, height);
		player3Dead[1] = p3Sprites.crop(width + 2, height * 8, width, height);
		player3Dead[2] = p3Sprites.crop(0, height * 8, width + 2, height);
	
		player3Rise = new BufferedImage[3];
		player3Rise[0] = p3Sprites.crop(0, height * 8, width + 2, height);
		player3Rise[1] = p3Sprites.crop(width + 2, height * 8, width, height);
		player3Rise[2] = p3Sprites.crop(65, height * 8, width, height);
	}
	
	public static void loadEnimiesD7D8()
	{
		SpriteSheet darkMagicianSheet = new SpriteSheet(ResourceLoader.loadTexture("darkMagician.png"));
		SpriteSheet drkKnightSheet = new SpriteSheet(ResourceLoader.loadTexture("drkKnightSheet.png"));
		SpriteSheet enemiesD7 = new SpriteSheet(ResourceLoader.loadTexture("enemiesD7.png"));
		
		darkMagiDwnLft = new BufferedImage[3];
		darkMagiDwnLft[0] = darkMagicianSheet.crop(0, 0, 35, 35);
		darkMagiDwnLft[1] = darkMagicianSheet.crop(35, 0, 35, 35);
		darkMagiDwnLft[2] = darkMagicianSheet.crop(70, 0, 35, 35);
		
		darkMagiUpLft = new BufferedImage[3];
		darkMagiUpLft[0] = darkMagicianSheet.crop(0, 35, 35, 35);
		darkMagiUpLft[1] = darkMagicianSheet.crop(35, 35, 35, 35);
		darkMagiUpLft[2] = darkMagicianSheet.crop(70, 35, 35, 35);
		
		darkMagiUpRgt = new BufferedImage[3];
		darkMagiUpRgt[0] = darkMagicianSheet.crop(175, 35, 35, 35);
		darkMagiUpRgt[1] = darkMagicianSheet.crop(140, 35, 35, 35);
		darkMagiUpRgt[2] = darkMagicianSheet.crop(105, 35, 35, 35);
		
		darkMagiDwnRgt = new BufferedImage[3];
		darkMagiDwnRgt[0] = darkMagicianSheet.crop(175, 0, 35, 35);
		darkMagiDwnRgt[1] = darkMagicianSheet.crop(140, 0, 35, 35);
		darkMagiDwnRgt[2] = darkMagicianSheet.crop(105, 0, 35, 35);

		darkMagiAtkDwnLft = new BufferedImage[3];
		darkMagiAtkDwnLft[0] = darkMagicianSheet.crop(0, 70, 35, 35);
		darkMagiAtkDwnLft[1] = darkMagicianSheet.crop(35, 70, 35, 35);
		darkMagiAtkDwnLft[2] = darkMagicianSheet.crop(70, 70, 35, 35);
		
		darkMagiAtkUpLft = new BufferedImage[3];
		darkMagiAtkUpLft[0] = darkMagicianSheet.crop(0, 105, 35, 35);
		darkMagiAtkUpLft[1] = darkMagicianSheet.crop(35, 105, 35, 35);
		darkMagiAtkUpLft[2] = darkMagicianSheet.crop(70, 105, 35, 35);
		
		darkMagiAtkUpRgt = new BufferedImage[3];
		darkMagiAtkUpRgt[0] = darkMagicianSheet.crop(175, 105, 35, 35);
		darkMagiAtkUpRgt[1] = darkMagicianSheet.crop(140, 105, 35, 35);
		darkMagiAtkUpRgt[2] = darkMagicianSheet.crop(105, 105, 35, 35);
		
		darkMagiAtkDwnRgt = new BufferedImage[3];
		darkMagiAtkDwnRgt[0] = darkMagicianSheet.crop(175, 70, 35, 35);
		darkMagiAtkDwnRgt[1] = darkMagicianSheet.crop(140, 70, 35, 35);
		darkMagiAtkDwnRgt[2] = darkMagicianSheet.crop(105, 70, 35, 35);

		darkMagiWarpDwnLft = new BufferedImage[6];
		darkMagiWarpDwnLft[0] = darkMagicianSheet.crop(0, 140, 35, 35);
		darkMagiWarpDwnLft[1] = darkMagicianSheet.crop(35, 140, 35, 35);
		darkMagiWarpDwnLft[2] = darkMagicianSheet.crop(70, 140, 35, 35);
		darkMagiWarpDwnLft[3] = darkMagicianSheet.crop(105, 140, 35, 35);
		darkMagiWarpDwnLft[4] = darkMagicianSheet.crop(140, 140, 35, 35);
		darkMagiWarpDwnLft[5] = darkMagicianSheet.crop(175, 140, 35, 35);
		
		darkMagiWarpUpLft = new BufferedImage[6];
		darkMagiWarpUpLft[0] = darkMagicianSheet.crop(385, 175, 35, 35);
		darkMagiWarpUpLft[1] = darkMagicianSheet.crop(350, 175, 35, 35);
		darkMagiWarpUpLft[2] = darkMagicianSheet.crop(315, 175, 35, 35);
		darkMagiWarpUpLft[3] = darkMagicianSheet.crop(280, 175, 35, 35);
		darkMagiWarpUpLft[4] = darkMagicianSheet.crop(245, 175, 35, 35);
		darkMagiWarpUpLft[5] = darkMagicianSheet.crop(210, 175, 35, 35);

		darkMagiWarpUpRgt = new BufferedImage[6];
		darkMagiWarpUpRgt[0] = darkMagicianSheet.crop(0, 175, 35, 35);
		darkMagiWarpUpRgt[1] = darkMagicianSheet.crop(35, 175, 35, 35);
		darkMagiWarpUpRgt[2] = darkMagicianSheet.crop(70, 175, 35, 35);
		darkMagiWarpUpRgt[3] = darkMagicianSheet.crop(105, 175, 35, 35);
		darkMagiWarpUpRgt[4] = darkMagicianSheet.crop(140, 175, 35, 35);
		darkMagiWarpUpRgt[5] = darkMagicianSheet.crop(175, 175, 35, 35);

		darkMagiWarpDwnRgt = new BufferedImage[6];
		darkMagiWarpDwnRgt[0] = darkMagicianSheet.crop(385, 140, 35, 35);
		darkMagiWarpDwnRgt[1] = darkMagicianSheet.crop(350, 140, 35, 35);
		darkMagiWarpDwnRgt[2] = darkMagicianSheet.crop(315, 140, 35, 35);
		darkMagiWarpDwnRgt[3] = darkMagicianSheet.crop(280, 140, 35, 35);
		darkMagiWarpDwnRgt[4] = darkMagicianSheet.crop(245, 140, 35, 35);
		darkMagiWarpDwnRgt[5] = darkMagicianSheet.crop(210, 140, 35, 35);
		
		darkMagiInvDwnLft = new BufferedImage[3];
		darkMagiInvDwnLft[0] = darkMagicianSheet.crop(0, 210, 35, 35);
		darkMagiInvDwnLft[1] = darkMagicianSheet.crop(35, 210, 35, 35);
		darkMagiInvDwnLft[2] = darkMagicianSheet.crop(70, 210, 35, 35);
		
		darkMagiInvUpLft = new BufferedImage[3];
		darkMagiInvUpLft[0] = darkMagicianSheet.crop(0, 245, 35, 35);
		darkMagiInvUpLft[1] = darkMagicianSheet.crop(35, 245, 35, 35);
		darkMagiInvUpLft[2] = darkMagicianSheet.crop(70, 245, 35, 35);
		
		darkMagiInvUpRgt = new BufferedImage[3];
		darkMagiInvUpRgt[0] = darkMagicianSheet.crop(175, 245, 35, 35);
		darkMagiInvUpRgt[1] = darkMagicianSheet.crop(140, 245, 35, 35);
		darkMagiInvUpRgt[2] = darkMagicianSheet.crop(105, 245, 35, 35);
		
		darkMagiInvDwnRgt = new BufferedImage[3];
		darkMagiInvDwnRgt[0] = darkMagicianSheet.crop(175, 210, 35, 35);
		darkMagiInvDwnRgt[1] = darkMagicianSheet.crop(140, 210, 35, 35);
		darkMagiInvDwnRgt[2] = darkMagicianSheet.crop(105, 210, 35, 35);
	}
	
	public static void loadEnimiesD5D6()
	{
		SpriteSheet lgtMagicianSheet = new SpriteSheet(ResourceLoader.loadTexture("lgtMagician.png"));
		SpriteSheet lightKnightSheet = new SpriteSheet(ResourceLoader.loadTexture("lightKnightSheet.png"));
		SpriteSheet enemiesD5 = new SpriteSheet(ResourceLoader.loadTexture("enemiesD5.png"));
		SpriteSheet enemiesD6 = new SpriteSheet(ResourceLoader.loadTexture("enemiesD6.png"));
		
		flyTurtleDwnLft = new BufferedImage[4];
		flyTurtleDwnLft[0] = enemiesD6.crop(0, 192, 45, 45);
		flyTurtleDwnLft[1] = enemiesD6.crop(45, 192, 45, 45);
		flyTurtleDwnLft[2] = enemiesD6.crop(90, 192, 45, 45);
		flyTurtleDwnLft[3] = enemiesD6.crop(135, 192, 45, 45);
		
		flyTurtleUpLft = new BufferedImage[4];
		flyTurtleUpLft[0] = enemiesD6.crop(0, 237, 45, 45);
		flyTurtleUpLft[1] = enemiesD6.crop(45, 237, 45, 45);
		flyTurtleUpLft[2] = enemiesD6.crop(90, 237, 45, 45);
		flyTurtleUpLft[3] = enemiesD6.crop(135, 237, 45, 45);
		
		flyTurtleUpRgt = new BufferedImage[4];
		flyTurtleUpRgt[0] = enemiesD6.crop(180, 237, 45, 45);
		flyTurtleUpRgt[1] = enemiesD6.crop(225, 237, 45, 45);
		flyTurtleUpRgt[2] = enemiesD6.crop(270, 237, 45, 45);
		flyTurtleUpRgt[3] = enemiesD6.crop(315, 237, 45, 45);
		
		flyTurtleDwnRgt = new BufferedImage[4];
		flyTurtleDwnRgt[0] = enemiesD6.crop(180, 192, 45, 45);
		flyTurtleDwnRgt[1] = enemiesD6.crop(225, 192, 45, 45);
		flyTurtleDwnRgt[2] = enemiesD6.crop(270, 192, 45, 45);
		flyTurtleDwnRgt[3] = enemiesD6.crop(315, 192, 45, 45);
		
		goblinDwnLft = new BufferedImage[4];
		goblinDwnLft[0] = enemiesD6.crop(0, 0, width, height);
		goblinDwnLft[1] = enemiesD6.crop(width, 0, width, height);
		goblinDwnLft[2] = enemiesD6.crop(width * 2, 0, width, height);
		goblinDwnLft[3] = enemiesD6.crop(width * 3, 0, width, height);
		
		goblinUpLft = new BufferedImage[4];
		goblinUpLft[0] = enemiesD6.crop(width * 4, 0, width, height);
		goblinUpLft[1] = enemiesD6.crop(width * 5, 0, width, height);
		goblinUpLft[2] = enemiesD6.crop(width * 6, 0, width, height);
		goblinUpLft[3] = enemiesD6.crop(width * 7, 0, width, height);
		
		goblinUpRgt = new BufferedImage[4];
		goblinUpRgt[0] = enemiesD6.crop(width * 3, height, width, height);
		goblinUpRgt[1] = enemiesD6.crop(width * 2, height, width, height);
		goblinUpRgt[2] = enemiesD6.crop(width, height, width, height);
		goblinUpRgt[3] = enemiesD6.crop(0, height, width, height);
		
		goblinDwnRgt = new BufferedImage[4];
		goblinDwnRgt[0] = enemiesD6.crop(width * 7, height, width, height);
		goblinDwnRgt[1] = enemiesD6.crop(width * 6, height, width, height);
		goblinDwnRgt[2] = enemiesD6.crop(width * 5, height, width, height);
		goblinDwnRgt[3] = enemiesD6.crop(width * 4, height, width, height);
		
		goblinIdleDwnLft = new BufferedImage[4];
		goblinIdleDwnLft[0] = enemiesD6.crop(0, height * 2, width, height);
		goblinIdleDwnLft[1] = enemiesD6.crop(width, height * 2, width, height);
		goblinIdleDwnLft[2] = enemiesD6.crop(width * 2, height * 2, width, height);
		goblinIdleDwnLft[3] = enemiesD6.crop(width, height * 2, width, height);

		goblinAtkDwnLft  = new BufferedImage[7];
		goblinAtkDwnLft[0] = enemiesD6.crop(width * 3, height * 2, width, height);
		goblinAtkDwnLft[1] = enemiesD6.crop(width * 4, height * 2, width, height);
		goblinAtkDwnLft[2] = enemiesD6.crop(width * 5, height * 2, width, height);
		goblinAtkDwnLft[3] = enemiesD6.crop(width * 6, height * 2, width, height);
		goblinAtkDwnLft[4] = enemiesD6.crop(width * 7, height * 2, width, height);
		goblinAtkDwnLft[5] = enemiesD6.crop(width * 7, height * 2, width, height);
		goblinAtkDwnLft[6] = enemiesD6.crop(width * 7, height * 2, width, height);
		
		goblinIdleUpLft = new BufferedImage[4];
		goblinIdleUpLft[0] = enemiesD6.crop(0, height * 3, width, height);
		goblinIdleUpLft[1] = enemiesD6.crop(width, height * 3, width, height);
		goblinIdleUpLft[2] = enemiesD6.crop(width * 2, height * 3, width, height);
		goblinIdleUpLft[3] = enemiesD6.crop(width, height * 3, width, height);

		goblinAtkUpLft  = new BufferedImage[7];
		goblinAtkUpLft[0] = enemiesD6.crop(width * 3, height * 3, width, height);
		goblinAtkUpLft[1] = enemiesD6.crop(width * 4, height * 3, width, height);
		goblinAtkUpLft[2] = enemiesD6.crop(width * 5, height * 3, width, height);
		goblinAtkUpLft[3] = enemiesD6.crop(width * 6, height * 3, width, height);
		goblinAtkUpLft[4] = enemiesD6.crop(width * 7, height * 3, width, height);
		goblinAtkUpLft[5] = enemiesD6.crop(width * 7, height * 3, width, height);
		goblinAtkUpLft[6] = enemiesD6.crop(width * 7, height * 3, width, height);

		goblinIdleDwnRgt = new BufferedImage[4];
		goblinIdleDwnRgt[0] = enemiesD6.crop(width * 6, height * 4, width, height);
		goblinIdleDwnRgt[1] = enemiesD6.crop(width * 5, height * 4, width, height);
		goblinIdleDwnRgt[2] = enemiesD6.crop(width * 6, height * 4, width, height);
		goblinIdleDwnRgt[3] = enemiesD6.crop(width * 7, height * 4, width, height);

		goblinAtkDwnRgt  = new BufferedImage[7];
		goblinAtkDwnRgt[0] = enemiesD6.crop(width * 4, height * 4, width, height);
		goblinAtkDwnRgt[1] = enemiesD6.crop(width * 3, height * 4, width, height);
		goblinAtkDwnRgt[2] = enemiesD6.crop(width * 2, height * 4, width, height);
		goblinAtkDwnRgt[3] = enemiesD6.crop(width, height * 4, width, height);
		goblinAtkDwnRgt[4] = enemiesD6.crop(0, height * 4, width, height);
		goblinAtkDwnRgt[5] = enemiesD6.crop(0, height * 4, width, height);
		goblinAtkDwnRgt[6] = enemiesD6.crop(0, height * 4, width, height);
		
		goblinIdleUpRgt = new BufferedImage[4];
		goblinIdleUpRgt[0] = enemiesD6.crop(width * 6, height * 5, width, height);
		goblinIdleUpRgt[1] = enemiesD6.crop(width * 5, height * 5, width, height);
		goblinIdleUpRgt[2] = enemiesD6.crop(width * 6, height * 5, width, height);
		goblinIdleUpRgt[3] = enemiesD6.crop(width * 7, height * 5, width, height);

		goblinAtkUpRgt  = new BufferedImage[7];
		goblinAtkUpRgt[0] = enemiesD6.crop(width * 4, height * 5, width, height);
		goblinAtkUpRgt[1] = enemiesD6.crop(width * 3, height * 5, width, height);
		goblinAtkUpRgt[2] = enemiesD6.crop(width * 2, height * 5, width, height);
		goblinAtkUpRgt[3] = enemiesD6.crop(width, height * 5, width, height);
		goblinAtkUpRgt[4] = enemiesD6.crop(0, height * 5, width, height);
		goblinAtkUpRgt[5] = enemiesD6.crop(0, height * 5, width, height);
		goblinAtkUpRgt[6] = enemiesD6.crop(0, height * 5, width, height);
		
		lgtMagiDwnLft = new BufferedImage[3];
		lgtMagiDwnLft[0] = lgtMagicianSheet.crop(0, 0, 35, 35);
		lgtMagiDwnLft[1] = lgtMagicianSheet.crop(35, 0, 35, 35);
		lgtMagiDwnLft[2] = lgtMagicianSheet.crop(70, 0, 35, 35);
		
		lgtMagiUpLft = new BufferedImage[3];
		lgtMagiUpLft[0] = lgtMagicianSheet.crop(0, 35, 35, 35);
		lgtMagiUpLft[1] = lgtMagicianSheet.crop(35, 35, 35, 35);
		lgtMagiUpLft[2] = lgtMagicianSheet.crop(70, 35, 35, 35);
		
		lgtMagiUpRgt = new BufferedImage[3];
		lgtMagiUpRgt[0] = lgtMagicianSheet.crop(175, 35, 35, 35);
		lgtMagiUpRgt[1] = lgtMagicianSheet.crop(140, 35, 35, 35);
		lgtMagiUpRgt[2] = lgtMagicianSheet.crop(105, 35, 35, 35);
		
		lgtMagiDwnRgt = new BufferedImage[3];
		lgtMagiDwnRgt[0] = lgtMagicianSheet.crop(175, 0, 35, 35);
		lgtMagiDwnRgt[1] = lgtMagicianSheet.crop(140, 0, 35, 35);
		lgtMagiDwnRgt[2] = lgtMagicianSheet.crop(105, 0, 35, 35);

		lgtMagiAtkDwnLft = new BufferedImage[3];
		lgtMagiAtkDwnLft[0] = lgtMagicianSheet.crop(0, 70, 35, 35);
		lgtMagiAtkDwnLft[1] = lgtMagicianSheet.crop(35, 70, 35, 35);
		lgtMagiAtkDwnLft[2] = lgtMagicianSheet.crop(70, 70, 35, 35);
		
		lgtMagiAtkUpLft = new BufferedImage[3];
		lgtMagiAtkUpLft[0] = lgtMagicianSheet.crop(0, 105, 35, 35);
		lgtMagiAtkUpLft[1] = lgtMagicianSheet.crop(35, 105, 35, 35);
		lgtMagiAtkUpLft[2] = lgtMagicianSheet.crop(70, 105, 35, 35);
		
		lgtMagiAtkUpRgt = new BufferedImage[3];
		lgtMagiAtkUpRgt[0] = lgtMagicianSheet.crop(175, 105, 35, 35);
		lgtMagiAtkUpRgt[1] = lgtMagicianSheet.crop(140, 105, 35, 35);
		lgtMagiAtkUpRgt[2] = lgtMagicianSheet.crop(105, 105, 35, 35);
		
		lgtMagiAtkDwnRgt = new BufferedImage[3];
		lgtMagiAtkDwnRgt[0] = lgtMagicianSheet.crop(175, 70, 35, 35);
		lgtMagiAtkDwnRgt[1] = lgtMagicianSheet.crop(140, 70, 35, 35);
		lgtMagiAtkDwnRgt[2] = lgtMagicianSheet.crop(105, 70, 35, 35);

		lgtMagiWarpDwnLft = new BufferedImage[6];
		lgtMagiWarpDwnLft[0] = lgtMagicianSheet.crop(0, 140, 35, 35);
		lgtMagiWarpDwnLft[1] = lgtMagicianSheet.crop(35, 140, 35, 35);
		lgtMagiWarpDwnLft[2] = lgtMagicianSheet.crop(70, 140, 35, 35);
		lgtMagiWarpDwnLft[3] = lgtMagicianSheet.crop(105, 140, 35, 35);
		lgtMagiWarpDwnLft[4] = lgtMagicianSheet.crop(140, 140, 35, 35);
		lgtMagiWarpDwnLft[5] = lgtMagicianSheet.crop(175, 140, 35, 35);
		
		lgtMagiWarpUpLft = new BufferedImage[6];
		lgtMagiWarpUpLft[0] = lgtMagicianSheet.crop(385, 175, 35, 35);
		lgtMagiWarpUpLft[1] = lgtMagicianSheet.crop(350, 175, 35, 35);
		lgtMagiWarpUpLft[2] = lgtMagicianSheet.crop(315, 175, 35, 35);
		lgtMagiWarpUpLft[3] = lgtMagicianSheet.crop(280, 175, 35, 35);
		lgtMagiWarpUpLft[4] = lgtMagicianSheet.crop(245, 175, 35, 35);
		lgtMagiWarpUpLft[5] = lgtMagicianSheet.crop(210, 175, 35, 35);

		lgtMagiWarpUpRgt = new BufferedImage[6];
		lgtMagiWarpUpRgt[0] = lgtMagicianSheet.crop(0, 175, 35, 35);
		lgtMagiWarpUpRgt[1] = lgtMagicianSheet.crop(35, 175, 35, 35);
		lgtMagiWarpUpRgt[2] = lgtMagicianSheet.crop(70, 175, 35, 35);
		lgtMagiWarpUpRgt[3] = lgtMagicianSheet.crop(105, 175, 35, 35);
		lgtMagiWarpUpRgt[4] = lgtMagicianSheet.crop(140, 175, 35, 35);
		lgtMagiWarpUpRgt[5] = lgtMagicianSheet.crop(175, 175, 35, 35);

		lgtMagiWarpDwnRgt = new BufferedImage[6];
		lgtMagiWarpDwnRgt[0] = lgtMagicianSheet.crop(385, 140, 35, 35);
		lgtMagiWarpDwnRgt[1] = lgtMagicianSheet.crop(350, 140, 35, 35);
		lgtMagiWarpDwnRgt[2] = lgtMagicianSheet.crop(315, 140, 35, 35);
		lgtMagiWarpDwnRgt[3] = lgtMagicianSheet.crop(280, 140, 35, 35);
		lgtMagiWarpDwnRgt[4] = lgtMagicianSheet.crop(245, 140, 35, 35);
		lgtMagiWarpDwnRgt[5] = lgtMagicianSheet.crop(210, 140, 35, 35);
		
		lightKnightDwnLft = new BufferedImage[6];
		lightKnightDwnLft[0] = lightKnightSheet.crop(0, 0, 65, 65);
		lightKnightDwnLft[1] = lightKnightSheet.crop(65, 0, 65, 65);
		lightKnightDwnLft[2] = lightKnightSheet.crop(130, 0, 65, 65);
		lightKnightDwnLft[3] = lightKnightSheet.crop(195, 0, 65, 65);
		lightKnightDwnLft[4] = lightKnightSheet.crop(260, 0, 65, 65);
		lightKnightDwnLft[5] = lightKnightSheet.crop(325, 0, 65, 65);
		
		lightKnightDwnRgt = new BufferedImage[6];
		lightKnightDwnRgt[0] = lightKnightSheet.crop(0, 65, 65, 65);
		lightKnightDwnRgt[1] = lightKnightSheet.crop(65, 65, 65, 65);
		lightKnightDwnRgt[2] = lightKnightSheet.crop(130, 65, 65, 65);
		lightKnightDwnRgt[3] = lightKnightSheet.crop(195, 65, 65, 65);
		lightKnightDwnRgt[4] = lightKnightSheet.crop(260, 65, 65, 65);
		lightKnightDwnRgt[5] = lightKnightSheet.crop(325, 65, 65, 65);
		
		lightKnightUpLft = new BufferedImage[6];
		lightKnightUpLft[0] = lightKnightSheet.crop(0, 130, 65, 65);
		lightKnightUpLft[1] = lightKnightSheet.crop(65, 130, 65, 65);
		lightKnightUpLft[2] = lightKnightSheet.crop(130, 130, 65, 65);
		lightKnightUpLft[3] = lightKnightSheet.crop(195, 130, 65, 65);
		lightKnightUpLft[4] = lightKnightSheet.crop(260, 130, 65, 65);
		lightKnightUpLft[5] = lightKnightSheet.crop(325, 130, 65, 65);
		
		lightKnightUpRgt = new BufferedImage[6];
		lightKnightUpRgt[0] = lightKnightSheet.crop(0, 195, 65, 65);
		lightKnightUpRgt[1] = lightKnightSheet.crop(65, 195, 65, 65);
		lightKnightUpRgt[2] = lightKnightSheet.crop(130, 195, 65, 65);
		lightKnightUpRgt[3] = lightKnightSheet.crop(195, 195, 65, 65);
		lightKnightUpRgt[4] = lightKnightSheet.crop(260, 195, 65, 65);
		lightKnightUpRgt[5] = lightKnightSheet.crop(325, 195, 65, 65);
		
		lightKnightLft = new BufferedImage[6];
		lightKnightLft[0] = lightKnightSheet.crop(0, 520, 65, 65);
		lightKnightLft[1] = lightKnightSheet.crop(65, 520, 65, 65);
		lightKnightLft[2] = lightKnightSheet.crop(130, 520, 65, 65);
		lightKnightLft[3] = lightKnightSheet.crop(195, 520, 65, 65);
		lightKnightLft[4] = lightKnightSheet.crop(260, 520, 65, 65);
		lightKnightLft[5] = lightKnightSheet.crop(325, 520, 65, 65);
		
		lightKnightRgt = new BufferedImage[6];
		lightKnightRgt[0] = lightKnightSheet.crop(0, 585, 65, 65);
		lightKnightRgt[1] = lightKnightSheet.crop(65, 585, 65, 65);
		lightKnightRgt[2] = lightKnightSheet.crop(130, 585, 65, 65);
		lightKnightRgt[3] = lightKnightSheet.crop(195, 585, 65, 65);
		lightKnightRgt[4] = lightKnightSheet.crop(260, 585, 65, 65);
		lightKnightRgt[5] = lightKnightSheet.crop(325, 585, 65, 65);
		
		lightKnightAtkUp = new BufferedImage[9];
		lightKnightAtkUp[0] = lightKnightSheet.crop(0, 390, 65, 65);
		lightKnightAtkUp[1] = lightKnightSheet.crop(65, 390, 65, 65);
		lightKnightAtkUp[2] = lightKnightSheet.crop(130, 390, 65, 65);
		lightKnightAtkUp[3] = lightKnightSheet.crop(195, 390, 65, 65);
		lightKnightAtkUp[4] = lightKnightSheet.crop(260, 390, 65, 65);
		lightKnightAtkUp[5] = lightKnightSheet.crop(325, 390, 65, 65);
		lightKnightAtkUp[6] = lightKnightSheet.crop(390, 390, 65, 65);
		lightKnightAtkUp[7] = lightKnightSheet.crop(455, 390, 65, 65);
		lightKnightAtkUp[8] = lightKnightSheet.crop(520, 390, 65, 65);
		
		lightKnightAtkDwn = new BufferedImage[9];
		lightKnightAtkDwn[0] = lightKnightSheet.crop(0, 325, 65, 65);
		lightKnightAtkDwn[1] = lightKnightSheet.crop(65, 325, 65, 65);
		lightKnightAtkDwn[2] = lightKnightSheet.crop(130, 325, 65, 65);
		lightKnightAtkDwn[3] = lightKnightSheet.crop(195, 325, 65, 65);
		lightKnightAtkDwn[4] = lightKnightSheet.crop(260, 325, 65, 65);
		lightKnightAtkDwn[5] = lightKnightSheet.crop(325, 325, 65, 65);
		lightKnightAtkDwn[6] = lightKnightSheet.crop(390, 325, 65, 65);
		lightKnightAtkDwn[7] = lightKnightSheet.crop(455, 325, 65, 65);
		lightKnightAtkDwn[8] = lightKnightSheet.crop(520, 325, 65, 65);
		
		lightKnightAtkUp = new BufferedImage[9];
		lightKnightAtkUp[0] = lightKnightSheet.crop(0, 390, 65, 65);
		lightKnightAtkUp[1] = lightKnightSheet.crop(65, 390, 65, 65);
		lightKnightAtkUp[2] = lightKnightSheet.crop(130, 390, 65, 65);
		lightKnightAtkUp[3] = lightKnightSheet.crop(195, 390, 65, 65);
		lightKnightAtkUp[4] = lightKnightSheet.crop(260, 390, 65, 65);
		lightKnightAtkUp[5] = lightKnightSheet.crop(325, 390, 65, 65);
		lightKnightAtkUp[6] = lightKnightSheet.crop(390, 390, 65, 65);
		lightKnightAtkUp[7] = lightKnightSheet.crop(455, 390, 65, 65);
		lightKnightAtkUp[8] = lightKnightSheet.crop(520, 390, 65, 65);
		
		lightKnightAtkLft = new BufferedImage[9];
		lightKnightAtkLft[0] = lightKnightSheet.crop(0, 260, 65, 65);
		lightKnightAtkLft[1] = lightKnightSheet.crop(65, 260, 65, 65);
		lightKnightAtkLft[2] = lightKnightSheet.crop(130, 260, 65, 65);
		lightKnightAtkLft[3] = lightKnightSheet.crop(195, 260, 65, 65);
		lightKnightAtkLft[4] = lightKnightSheet.crop(260, 260, 65, 65);
		lightKnightAtkLft[5] = lightKnightSheet.crop(325, 260, 65, 65);
		lightKnightAtkLft[6] = lightKnightSheet.crop(390, 260, 65, 65);
		lightKnightAtkLft[7] = lightKnightSheet.crop(455, 260, 65, 65);
		lightKnightAtkLft[8] = lightKnightSheet.crop(520, 260, 65, 65);
		
		lightKnightAtkRgt = new BufferedImage[9];
		lightKnightAtkRgt[0] = lightKnightSheet.crop(520, 455, 65, 65);
		lightKnightAtkRgt[1] = lightKnightSheet.crop(455, 455, 65, 65);
		lightKnightAtkRgt[2] = lightKnightSheet.crop(390, 455, 65, 65);
		lightKnightAtkRgt[3] = lightKnightSheet.crop(325, 455, 65, 65);
		lightKnightAtkRgt[4] = lightKnightSheet.crop(260, 455, 65, 65);
		lightKnightAtkRgt[5] = lightKnightSheet.crop(195, 455, 65, 65);
		lightKnightAtkRgt[6] = lightKnightSheet.crop(130, 455, 65, 65);
		lightKnightAtkRgt[7] = lightKnightSheet.crop(65, 455, 65, 65);
		lightKnightAtkRgt[8] = lightKnightSheet.crop(0, 455, 65, 65);
		
		lightKnightShieldUp = new BufferedImage[6];
		lightKnightShieldUp[0] = lightKnightSheet.crop(0, 650, 65, 65);
		lightKnightShieldUp[1] = lightKnightSheet.crop(65, 650, 65, 65);
		lightKnightShieldUp[2] = lightKnightSheet.crop(130, 650, 65, 65);
		lightKnightShieldUp[3] = lightKnightSheet.crop(195, 650, 65, 65);
		lightKnightShieldUp[4] = lightKnightSheet.crop(260, 650, 65, 65);
		lightKnightShieldUp[5] = lightKnightSheet.crop(325, 650, 65, 65);
		
		lightKnightShieldRgt = new BufferedImage[6];
		lightKnightShieldRgt[0] = lightKnightSheet.crop(325, 715, 65, 65);
		lightKnightShieldRgt[1] = lightKnightSheet.crop(260, 715, 65, 65);
		lightKnightShieldRgt[2] = lightKnightSheet.crop(195, 715, 65, 65);
		lightKnightShieldRgt[3] = lightKnightSheet.crop(130, 715, 65, 65);
		lightKnightShieldRgt[4] = lightKnightSheet.crop(65, 715, 65, 65);
		lightKnightShieldRgt[5] = lightKnightSheet.crop(0, 715, 65, 65);
		
		lightKnightShieldDwn = new BufferedImage[6];
		lightKnightShieldDwn[0] = lightKnightSheet.crop(0, 780, 65, 65);
		lightKnightShieldDwn[1] = lightKnightSheet.crop(65, 780, 65, 65);
		lightKnightShieldDwn[2] = lightKnightSheet.crop(130, 780, 65, 65);
		lightKnightShieldDwn[3] = lightKnightSheet.crop(195, 780, 65, 65);
		lightKnightShieldDwn[4] = lightKnightSheet.crop(260, 780, 65, 65);
		lightKnightShieldDwn[5] = lightKnightSheet.crop(325, 780, 65, 65);
		
		lightKnightShieldLft = new BufferedImage[6];
		lightKnightShieldLft[0] = lightKnightSheet.crop(0, 845, 65, 65);
		lightKnightShieldLft[1] = lightKnightSheet.crop(65, 845, 65, 65);
		lightKnightShieldLft[2] = lightKnightSheet.crop(130, 845, 65, 65);
		lightKnightShieldLft[3] = lightKnightSheet.crop(195, 845, 65, 65);
		lightKnightShieldLft[4] = lightKnightSheet.crop(260, 845, 65, 65);
		lightKnightShieldLft[5] = lightKnightSheet.crop(325, 845, 65, 65);
		
		iceBeetleDwnLft = new BufferedImage[3];
		iceBeetleDwnLft[0] = enemiesD5.crop(0, 544, 40, 34);
		iceBeetleDwnLft[1] = enemiesD5.crop(40, 544, 40, 34);
		iceBeetleDwnLft[2] = enemiesD5.crop(80, 544, 40, 34);
		
		iceBeetleDwnRgt = new BufferedImage[3];
		iceBeetleDwnRgt[0] = enemiesD5.crop(0, 578, 40, 34);
		iceBeetleDwnRgt[1] = enemiesD5.crop(40, 578, 40, 34);
		iceBeetleDwnRgt[2] = enemiesD5.crop(80, 578, 40, 34);
		
		iceBeetleUpLft = new BufferedImage[3];
		iceBeetleUpLft[0] = enemiesD5.crop(0, 612, 40, 34);
		iceBeetleUpLft[1] = enemiesD5.crop(40, 612, 40, 34);
		iceBeetleUpLft[2] = enemiesD5.crop(80, 612, 40, 34);
		
		iceBeetleUpRgt = new BufferedImage[3];
		iceBeetleUpRgt[0] = enemiesD5.crop(0, 646, 40, 34);
		iceBeetleUpRgt[1] = enemiesD5.crop(40, 646, 40, 34);
		iceBeetleUpRgt[2] = enemiesD5.crop(80, 646, 40, 34);
		
		iceBeetleDwnLftAtk = new BufferedImage[3];
		iceBeetleDwnLftAtk[0] = enemiesD5.crop(120, 544, 40, 34);
		iceBeetleDwnLftAtk[1] = enemiesD5.crop(160, 544, 40, 34);
		iceBeetleDwnLftAtk[2] = enemiesD5.crop(200, 544, 40, 34);
		
		iceBeetleDwnRgtAtk = new BufferedImage[3];
		iceBeetleDwnRgtAtk[0] = enemiesD5.crop(120, 578, 40, 34);
		iceBeetleDwnRgtAtk[1] = enemiesD5.crop(160, 578, 40, 34);
		iceBeetleDwnRgtAtk[2] = enemiesD5.crop(200, 578, 40, 34);
		
		iceBeetleUpLftAtk = new BufferedImage[3];
		iceBeetleUpLftAtk[0] = enemiesD5.crop(120, 612, 40, 34);
		iceBeetleUpLftAtk[1] = enemiesD5.crop(160, 612, 40, 34);
		iceBeetleUpLftAtk[2] = enemiesD5.crop(200, 612, 40, 34);
		
		iceBeetleUpRgtAtk = new BufferedImage[3];
		iceBeetleUpRgtAtk[0] = enemiesD5.crop(120, 646, 40, 34);
		iceBeetleUpRgtAtk[1] = enemiesD5.crop(160, 646, 40, 34);
		iceBeetleUpRgtAtk[2] = enemiesD5.crop(200, 646, 40, 34);
		
		iceSpiderLeft = new BufferedImage[3];
		iceSpiderLeft[0] = enemiesD5.crop(0, 480, width, height);
		iceSpiderLeft[1] = enemiesD5.crop(width, 480, width, height);
		iceSpiderLeft[2] = enemiesD5.crop(width * 2, 480, width, height);
		
		iceSpiderRight = new BufferedImage[3];
		iceSpiderRight[0] = enemiesD5.crop(0, 512, width, height);
		iceSpiderRight[1] = enemiesD5.crop(width, 512, width, height);
		iceSpiderRight[2] = enemiesD5.crop(width * 2, 512, width, height);
		
		snakeDwnLft = new BufferedImage[4];
		snakeDwnLft[0] = enemiesD5.crop(0, 240, 60, 60);
		snakeDwnLft[1] = enemiesD5.crop(60, 240, 60, 60);
		snakeDwnLft[2] = enemiesD5.crop(120, 240, 60, 60);
		snakeDwnLft[3] = enemiesD5.crop(180, 240, 60, 60);
		
		snakeUpLft = new BufferedImage[4];
		snakeUpLft[0] = enemiesD5.crop(420, 300, 60, 60);
		snakeUpLft[1] = enemiesD5.crop(360, 300, 60, 60);
		snakeUpLft[2] = enemiesD5.crop(300, 300, 60, 60);
		snakeUpLft[3] = enemiesD5.crop(240, 300, 60, 60);
		
		snakeUpRgt = new BufferedImage[4];
		snakeUpRgt[0] = enemiesD5.crop(0, 300, 60, 60);
		snakeUpRgt[1] = enemiesD5.crop(60, 300, 60, 60);
		snakeUpRgt[2] = enemiesD5.crop(120, 300, 60, 60);
		snakeUpRgt[3] = enemiesD5.crop(180, 300, 60, 60);
		
		snakeDwnRgt = new BufferedImage[4];
		snakeDwnRgt[0] = enemiesD5.crop(420, 240, 60, 60);
		snakeDwnRgt[1] = enemiesD5.crop(360, 240, 60, 60);
		snakeDwnRgt[2] = enemiesD5.crop(300, 240, 60, 60);
		snakeDwnRgt[3] = enemiesD5.crop(240, 240, 60, 60);
		
		snakeAtkDwnLft = new BufferedImage[3];
		snakeAtkDwnLft[0] = enemiesD5.crop(0, 360, 60, 60);
		snakeAtkDwnLft[1] = enemiesD5.crop(60, 360, 60, 60);
		snakeAtkDwnLft[2] = enemiesD5.crop(120, 360, 60, 60);
		
		snakeAtkUpLft = new BufferedImage[3];
		snakeAtkUpLft[0] = enemiesD5.crop(300, 420, 60, 60);
		snakeAtkUpLft[1] = enemiesD5.crop(240, 420, 60, 60);
		snakeAtkUpLft[2] = enemiesD5.crop(180, 420, 60, 60);
		
		snakeAtkUpRgt = new BufferedImage[3];
		snakeAtkUpRgt[0] = enemiesD5.crop(0, 420, 60, 60);
		snakeAtkUpRgt[1] = enemiesD5.crop(60, 420, 60, 60);
		snakeAtkUpRgt[2] = enemiesD5.crop(120, 420, 60, 60);
		
		snakeAtkDwnRgt = new BufferedImage[3];
		snakeAtkDwnRgt[0] = enemiesD5.crop(300, 360, 60, 60);
		snakeAtkDwnRgt[1] = enemiesD5.crop(240, 360, 60, 60);
		snakeAtkDwnRgt[2] = enemiesD5.crop(180, 360, 60, 60);
		
		wolfDwnLft = new BufferedImage[6];
		wolfDwnLft[0] = enemiesD5.crop(0, 80, 44, 40);
		wolfDwnLft[1] = enemiesD5.crop(44, 80, 44, 40);
		wolfDwnLft[2] = enemiesD5.crop(88, 80, 44, 40);
		wolfDwnLft[3] = enemiesD5.crop(132, 80, 44, 40);
		
		wolfUpLft = new BufferedImage[4];
		wolfUpLft[0] = enemiesD5.crop(0, 120, 44, 40);
		wolfUpLft[1] = enemiesD5.crop(44, 120, 44, 40);
		wolfUpLft[2] = enemiesD5.crop(88, 120, 44, 40);
		wolfUpLft[3] = enemiesD5.crop(132, 120, 44, 40);
		
		wolfUpRgt = new BufferedImage[4];
		wolfUpRgt[0] = enemiesD5.crop(308, 120, 44, 40);
		wolfUpRgt[1] = enemiesD5.crop(264, 120, 44, 40);
		wolfUpRgt[2] = enemiesD5.crop(220, 120, 44, 40);
		wolfUpRgt[3] = enemiesD5.crop(176, 120, 44, 40);
		
		wolfDwnRgt = new BufferedImage[4];
		wolfDwnRgt[0] = enemiesD5.crop(308, 80, 44, 40);
		wolfDwnRgt[1] = enemiesD5.crop(264, 80, 44, 40);
		wolfDwnRgt[2] = enemiesD5.crop(220, 80, 44, 40);
		wolfDwnRgt[3] = enemiesD5.crop(176, 80, 44, 40);

		wolfAtkDwnLft  = new BufferedImage[4];
		wolfAtkDwnLft[0] = enemiesD5.crop(0, 160, 44, 40);
		wolfAtkDwnLft[1] = enemiesD5.crop(44, 160, 44, 40);
		wolfAtkDwnLft[2] = enemiesD5.crop(88, 160, 44, 40);
		wolfAtkDwnLft[3] = enemiesD5.crop(132, 160, 44, 40);
		
		wolfAtkUpLft = new BufferedImage[4];
		wolfAtkUpLft[0] = enemiesD5.crop(0, 200, 44, 40);
		wolfAtkUpLft[1] = enemiesD5.crop(44, 200, 44, 40);
		wolfAtkUpLft[2] = enemiesD5.crop(88, 200, 44, 40);
		wolfAtkUpLft[3] = enemiesD5.crop(132, 200, 44, 40);
		
		wolfAtkUpRgt  = new BufferedImage[4];
		wolfAtkUpRgt[0] = enemiesD5.crop(308, 200, 44, 40);
		wolfAtkUpRgt[1] = enemiesD5.crop(264, 200, 44, 40);
		wolfAtkUpRgt[2] = enemiesD5.crop(220, 200, 44, 40);
		wolfAtkUpRgt[3] = enemiesD5.crop(176, 200, 44, 40);

		wolfAtkDwnRgt = new BufferedImage[4];
		wolfAtkDwnRgt[0] = enemiesD5.crop(308, 160, 44, 40);
		wolfAtkDwnRgt[1] = enemiesD5.crop(264, 160, 44, 40);
		wolfAtkDwnRgt[2] = enemiesD5.crop(220, 160, 44, 40);
		wolfAtkDwnRgt[3] = enemiesD5.crop(176, 160, 44, 40);
		
		wolfIdleDwnLft  = new BufferedImage[4];
		wolfIdleDwnLft[0] = enemiesD5.crop(0, 0, 44, 40);
		wolfIdleDwnLft[1] = enemiesD5.crop(44, 0, 44, 40);
		wolfIdleDwnLft[2] = enemiesD5.crop(88, 0, 44, 40);
		wolfIdleDwnLft[3] = enemiesD5.crop(132, 0, 44, 40);
		
		wolfIdleUpLft = new BufferedImage[4];
		wolfIdleUpLft[0] = enemiesD5.crop(0, 40, 44, 40);
		wolfIdleUpLft[1] = enemiesD5.crop(44, 40, 44, 40);
		wolfIdleUpLft[2] = enemiesD5.crop(88, 40, 44, 40);
		wolfIdleUpLft[3] = enemiesD5.crop(132, 40, 44, 40);

		wolfIdleUpRgt  = new BufferedImage[4];
		wolfIdleUpRgt[0] = enemiesD5.crop(308, 40, 44, 40);
		wolfIdleUpRgt[1] = enemiesD5.crop(264, 40, 44, 40);
		wolfIdleUpRgt[2] = enemiesD5.crop(220, 40, 44, 40);
		wolfIdleUpRgt[3] = enemiesD5.crop(176, 40, 44, 40);

		wolfIdleDwnRgt = new BufferedImage[4];
		wolfIdleDwnRgt[0] = enemiesD5.crop(308, 0, 44, 40);
		wolfIdleDwnRgt[1] = enemiesD5.crop(264, 0, 44, 40);
		wolfIdleDwnRgt[2] = enemiesD5.crop(220, 0, 44, 40);
		wolfIdleDwnRgt[3] = enemiesD5.crop(176, 0, 44, 40);
	}

	public static void loadEnimiesD3D4()
	{
		SpriteSheet enemiesD3 = new SpriteSheet(ResourceLoader.loadTexture("enemiesD3.png"));
		SpriteSheet enemiesD4 = new SpriteSheet(ResourceLoader.loadTexture("enemiesD4.png"));
		SpriteSheet crawford = new SpriteSheet(ResourceLoader.loadTexture("crawford.png"));
		SpriteSheet riggs = new SpriteSheet(ResourceLoader.loadTexture("riggs.png"));
		
		fireBatLeft = new BufferedImage[4];
		fireBatLeft[0] = enemiesD4.crop(0, 493, width, height);
		fireBatLeft[1] = enemiesD4.crop(width, 493, width, height);
		fireBatLeft[2] = enemiesD4.crop(width * 2, 493, width, height);
		fireBatLeft[3] = enemiesD4.crop(width * 3, 493, width, height);
		
		fireBatRight = new BufferedImage[4];
		fireBatRight[0] = enemiesD4.crop(0, 525, width, height);
		fireBatRight[1] = enemiesD4.crop(width, 525, width, height);
		fireBatRight[2] = enemiesD4.crop(width * 2, 525, width, height);
		fireBatRight[3] = enemiesD4.crop(width * 3, 525, width, height);
		
		fireMilliBodyDownLeft = new BufferedImage[4];
		fireMilliBodyDownLeft[0] = enemiesD4.crop(0, 421, 18, 18);
		fireMilliBodyDownLeft[1] = enemiesD4.crop(18, 421, 18, 18);
		fireMilliBodyDownLeft[2] = enemiesD4.crop(36, 421, 18, 18);
		fireMilliBodyDownLeft[3] = enemiesD4.crop(54, 421, 18, 18);
		
		fireMilliBodyDownRight = new BufferedImage[4];
		fireMilliBodyDownRight[0] = enemiesD4.crop(0, 439, 18, 18);
		fireMilliBodyDownRight[1] = enemiesD4.crop(18, 439, 18, 18);
		fireMilliBodyDownRight[2] = enemiesD4.crop(36, 439, 18, 18);
		fireMilliBodyDownRight[3] = enemiesD4.crop(54, 439, 18, 18);
		
		fireMilliBodyUpRight = new BufferedImage[4];
		fireMilliBodyUpRight[0] = enemiesD4.crop(0, 457, 18, 18);
		fireMilliBodyUpRight[1] = enemiesD4.crop(18, 457, 18, 18);
		fireMilliBodyUpRight[2] = enemiesD4.crop(36, 457, 18, 18);
		fireMilliBodyUpRight[3] = enemiesD4.crop(54, 457, 18, 18);
		
		fireMilliBodyUpLeft = new BufferedImage[4];
		fireMilliBodyUpLeft[0] = enemiesD4.crop(0, 475, 18, 18);
		fireMilliBodyUpLeft[1] = enemiesD4.crop(18, 475, 18, 18);
		fireMilliBodyUpLeft[2] = enemiesD4.crop(36, 475, 18, 18);
		fireMilliBodyUpLeft[3] = enemiesD4.crop(54, 475, 18, 18);
		
		fireMilliHead = new BufferedImage[4];
		fireMilliHead[0] = enemiesD4.crop(72, 421, 18, 18);
		fireMilliHead[1] = enemiesD4.crop(72, 439, 18, 18);
		fireMilliHead[2] = enemiesD4.crop(72, 457, 18, 18);
		fireMilliHead[3] = enemiesD4.crop(72, 475, 18, 18);
		
		fireMilliTail = new BufferedImage[4];
		fireMilliTail[0] = enemiesD4.crop(90, 421, 18, 18);
		fireMilliTail[1] = enemiesD4.crop(90, 439, 18, 18);
		fireMilliTail[2] = enemiesD4.crop(90, 457, 18, 18);
		fireMilliTail[3] = enemiesD4.crop(90, 475, 18, 18);
		
		hippoDwnLft = new BufferedImage[4];
		hippoDwnLft[0] = enemiesD4.crop(0, 0, 60, 52);
		hippoDwnLft[1] = enemiesD4.crop(60, 0, 60, 52);
		hippoDwnLft[2] = enemiesD4.crop(120, 0, 60, 52);
		hippoDwnLft[3] = enemiesD4.crop(180, 0, 60, 52);
		
		hippoUpLft = new BufferedImage[4];
		hippoUpLft[0] = enemiesD4.crop(0, 52, 60, 52);
		hippoUpLft[1] = enemiesD4.crop(60, 52, 60, 52);
		hippoUpLft[2] = enemiesD4.crop(120, 52, 60, 52);
		hippoUpLft[3] = enemiesD4.crop(180, 52, 60, 52);
		
		hippoUpRgt = new BufferedImage[4];
		hippoUpRgt[0] = enemiesD4.crop(420, 52, 60, 52);
		hippoUpRgt[1] = enemiesD4.crop(360, 52, 60, 52);
		hippoUpRgt[2] = enemiesD4.crop(300, 52, 60, 52);
		hippoUpRgt[3] = enemiesD4.crop(240, 52, 60, 52);
		
		hippoDwnRgt = new BufferedImage[4];
		hippoDwnRgt[0] = enemiesD4.crop(420, 0, 60, 52);
		hippoDwnRgt[1] = enemiesD4.crop(360, 0, 60, 52);
		hippoDwnRgt[2] = enemiesD4.crop(300, 0, 60, 52);
		hippoDwnRgt[3] = enemiesD4.crop(240, 0, 60, 52);

		hippoAtkDwnLft  = new BufferedImage[3];
		hippoAtkDwnLft[0] = enemiesD4.crop(60, 104, 60, 52);
		hippoAtkDwnLft[1] = enemiesD4.crop(120, 104, 60, 52);
		hippoAtkDwnLft[2] = enemiesD4.crop(0, 104, 60, 52);
		
		hippoAtkUpLft = new BufferedImage[3];
		hippoAtkUpLft[0] = enemiesD4.crop(60, 156, 60, 52);
		hippoAtkUpLft[1] = enemiesD4.crop(120, 156, 60, 52);
		hippoAtkUpLft[2] = enemiesD4.crop(0, 156, 60, 52);
		
		hippoAtkUpRgt  = new BufferedImage[3];
		hippoAtkUpRgt[0] = enemiesD4.crop(240, 156, 60, 52);
		hippoAtkUpRgt[1] = enemiesD4.crop(180, 156, 60, 52);
		hippoAtkUpRgt[2] = enemiesD4.crop(300, 156, 60, 52);

		hippoAtkDwnRgt = new BufferedImage[3];
		hippoAtkDwnRgt[0] = enemiesD4.crop(240, 104, 60, 52);
		hippoAtkDwnRgt[1] = enemiesD4.crop(180, 104, 60, 52);
		hippoAtkDwnRgt[2] = enemiesD4.crop(300, 104, 60, 52);
		
		lizardDwnLft = new BufferedImage[5];
		lizardDwnLft[0] = enemiesD4.crop(0, 208, 50, 50);
		lizardDwnLft[1] = enemiesD4.crop(50, 208, 50, 50);
		lizardDwnLft[2] = enemiesD4.crop(100, 208, 50, 50);
		lizardDwnLft[3] = enemiesD4.crop(150, 208, 50, 50);
		lizardDwnLft[4] = enemiesD4.crop(200, 208, 50, 50);
		
		lizardUpLft = new BufferedImage[5];
		lizardUpLft[0] = enemiesD4.crop(0, 258, 50, 50);
		lizardUpLft[1] = enemiesD4.crop(50, 258, 50, 50);
		lizardUpLft[2] = enemiesD4.crop(100, 258, 50, 50);
		lizardUpLft[3] = enemiesD4.crop(150, 258, 50, 50);
		lizardUpLft[4] = enemiesD4.crop(200, 258, 50, 50);
		
		lizardUpRgt = new BufferedImage[5];
		lizardUpRgt[0] = enemiesD4.crop(450, 258, 50, 50);
		lizardUpRgt[1] = enemiesD4.crop(400, 258, 50, 50);
		lizardUpRgt[2] = enemiesD4.crop(350, 258, 50, 50);
		lizardUpRgt[3] = enemiesD4.crop(300, 258, 50, 50);
		lizardUpRgt[4] = enemiesD4.crop(250, 258, 50, 50);
	
		lizardDwnRgt = new BufferedImage[5];
		lizardDwnRgt[0] = enemiesD4.crop(450, 208, 50, 50);
		lizardDwnRgt[1] = enemiesD4.crop(400, 208, 50, 50);
		lizardDwnRgt[2] = enemiesD4.crop(350, 208, 50, 50);
		lizardDwnRgt[3] = enemiesD4.crop(300, 208, 50, 50);
		lizardDwnRgt[4] = enemiesD4.crop(250, 208, 50, 50);

		lizardAtkDwnLft  = new BufferedImage[5];
		lizardAtkDwnLft[0] = enemiesD4.crop(0, 308, 50, 50);
		lizardAtkDwnLft[1] = enemiesD4.crop(50, 308, 50, 50);
		lizardAtkDwnLft[2] = enemiesD4.crop(100, 308, 50, 50);
		lizardAtkDwnLft[3] = enemiesD4.crop(150, 308, 50, 50);
		lizardAtkDwnLft[4] = enemiesD4.crop(200, 308, 50, 50);
		
		lizardAtkUpLft = new BufferedImage[5];
		lizardAtkUpLft[0] = enemiesD4.crop(0, 358, 50, 50);
		lizardAtkUpLft[1] = enemiesD4.crop(50, 358, 50, 50);
		lizardAtkUpLft[2] = enemiesD4.crop(100, 358, 50, 50);
		lizardAtkUpLft[3] = enemiesD4.crop(150, 358, 50, 50);
		lizardAtkUpLft[4] = enemiesD4.crop(200, 358, 50, 50);
		
		lizardAtkUpRgt  = new BufferedImage[5];
		lizardAtkUpRgt[0] = enemiesD4.crop(450, 358, 50, 50);
		lizardAtkUpRgt[1] = enemiesD4.crop(400, 358, 50, 50);
		lizardAtkUpRgt[2] = enemiesD4.crop(350, 358, 50, 50);
		lizardAtkUpRgt[3] = enemiesD4.crop(300, 358, 50, 50);
		lizardAtkUpRgt[4] = enemiesD4.crop(250, 358, 50, 50);

		lizardAtkDwnRgt = new BufferedImage[5];
		lizardAtkDwnRgt[0] = enemiesD4.crop(450, 308, 50, 50);
		lizardAtkDwnRgt[1] = enemiesD4.crop(400, 308, 50, 50);
		lizardAtkDwnRgt[2] = enemiesD4.crop(350, 308, 50, 50);
		lizardAtkDwnRgt[3] = enemiesD4.crop(300, 308, 50, 50);
		lizardAtkDwnRgt[4] = enemiesD4.crop(250, 308, 50, 50);
		
		riggsDwnLft = new BufferedImage[3];
		riggsDwnLft[0] = riggs.crop(0, 0, 50, 50);
		riggsDwnLft[1] = riggs.crop(50, 0, 50, 50);
		riggsDwnLft[2] = riggs.crop(100, 0, 50, 50);
		
		riggsUpLft = new BufferedImage[3];
		riggsUpLft[0] = riggs.crop(0, 50, 50, 50);
		riggsUpLft[1] = riggs.crop(50, 50, 50, 50);
		riggsUpLft[2] = riggs.crop(100, 50, 50, 50);
		
		riggsUpRgt = new BufferedImage[3];
		riggsUpRgt[0] = riggs.crop(150, 50, 50, 50);
		riggsUpRgt[1] = riggs.crop(200, 50, 50, 50);
		riggsUpRgt[2] = riggs.crop(250, 50, 50, 50);
		
		riggsDwnRgt = new BufferedImage[3];
		riggsDwnRgt[0] = riggs.crop(150, 0, 50, 50);
		riggsDwnRgt[1] = riggs.crop(200, 0, 50, 50);
		riggsDwnRgt[2] = riggs.crop(250, 0, 50, 50);

		riggsAtkDwnLft  = new BufferedImage[3];
		riggsAtkDwnLft[0] = riggs.crop(0, 100, 50, 50);
		riggsAtkDwnLft[1] = riggs.crop(50, 100, 50, 50);
		riggsAtkDwnLft[2] = riggs.crop(100, 100, 50, 50);
		
		riggsAtkUpLft = new BufferedImage[3];
		riggsAtkUpLft[0] = riggs.crop(0, 150, 50, 50);
		riggsAtkUpLft[1] = riggs.crop(50, 150, 50, 50);
		riggsAtkUpLft[2] = riggs.crop(100, 150, 50, 50);
		
		riggsAtkUpRgt  = new BufferedImage[3];
		riggsAtkUpRgt[0] = riggs.crop(250, 150, 50, 50);
		riggsAtkUpRgt[1] = riggs.crop(200, 150, 50, 50);
		riggsAtkUpRgt[2] = riggs.crop(150, 150, 50, 50);

		riggsAtkDwnRgt = new BufferedImage[3];
		riggsAtkDwnRgt[0] = riggs.crop(250, 100, 50, 50);
		riggsAtkDwnRgt[1] = riggs.crop(200, 100, 50, 50);
		riggsAtkDwnRgt[2] = riggs.crop(150, 100, 50, 50);
		
		crawDwnLft = new BufferedImage[3];
		crawDwnLft[0] = crawford.crop(0, 0, 30, 30);
		crawDwnLft[1] = crawford.crop(30, 0, 30, 30);
		crawDwnLft[2] = crawford.crop(60, 0, 30, 30);
		
		crawUpLft = new BufferedImage[3];
		crawUpLft[0] = crawford.crop(0, 30, 30, 30);
		crawUpLft[1] = crawford.crop(30, 30, 30, 30);
		crawUpLft[2] = crawford.crop(60, 30, 30, 30);
		
		crawUpRgt = new BufferedImage[3];
		crawUpRgt[0] = crawford.crop(90, 30, 30, 30);
		crawUpRgt[1] = crawford.crop(120, 30, 30, 30);
		crawUpRgt[2] = crawford.crop(150, 30, 30, 30);
		
		crawDwnRgt = new BufferedImage[3];
		crawDwnRgt[0] = crawford.crop(90, 0, 30, 30);
		crawDwnRgt[1] = crawford.crop(120, 0, 30, 30);
		crawDwnRgt[2] = crawford.crop(150, 0, 30, 30);

		crawAtkDwnLft  = new BufferedImage[6];
		crawAtkDwnLft[0] = crawford.crop(0, 60, 30, 30);
		crawAtkDwnLft[1] = crawford.crop(30, 60, 30, 30);
		crawAtkDwnLft[2] = crawford.crop(60, 60, 30, 30);
		crawAtkDwnLft[3] = crawford.crop(90, 60, 30, 30);
		crawAtkDwnLft[4] = crawford.crop(120, 60, 30, 30);
		crawAtkDwnLft[5] = crawford.crop(150, 60, 30, 30);
		
		crawAtkUpLft = new BufferedImage[6];
		crawAtkUpLft[0] = crawford.crop(0, 90, 30, 30);
		crawAtkUpLft[1] = crawford.crop(30, 90, 30, 30);
		crawAtkUpLft[2] = crawford.crop(60, 90, 30, 30);
		crawAtkUpLft[3] = crawford.crop(90, 90, 30, 30);
		crawAtkUpLft[4] = crawford.crop(120, 90, 30, 30);
		crawAtkUpLft[5] = crawford.crop(150, 90, 30, 30);
		
		crawAtkUpRgt  = new BufferedImage[6];
		crawAtkUpRgt[0] = crawford.crop(330, 90, 30, 30);
		crawAtkUpRgt[1] = crawford.crop(300, 90, 30, 30);
		crawAtkUpRgt[2] = crawford.crop(270, 90, 30, 30);
		crawAtkUpRgt[3] = crawford.crop(240, 90, 30, 30);
		crawAtkUpRgt[4] = crawford.crop(210, 90, 30, 30);
		crawAtkUpRgt[5] = crawford.crop(180, 90, 30, 30);

		crawAtkDwnRgt = new BufferedImage[6];
		crawAtkDwnRgt[0] = crawford.crop(330, 60, 30, 30);
		crawAtkDwnRgt[1] = crawford.crop(300, 60, 30, 30);
		crawAtkDwnRgt[2] = crawford.crop(270, 60, 30, 30);
		crawAtkDwnRgt[3] = crawford.crop(240, 60, 30, 30);
		crawAtkDwnRgt[4] = crawford.crop(210, 60, 30, 30);
		crawAtkDwnRgt[5] = crawford.crop(180, 60, 30, 30);

		
		squidDwnLft = new BufferedImage[4];
		squidDwnLft[0] = enemiesD3.crop(0, 360, 48, 48);
		squidDwnLft[1] = enemiesD3.crop(48, 360, 48, 48);
		squidDwnLft[2] = enemiesD3.crop(96, 360, 48, 48);
		squidDwnLft[3] = enemiesD3.crop(144, 360, 48, 48);
		
		squidUpLft = new BufferedImage[4];
		squidUpLft[0] = enemiesD3.crop(0, 408, 48, 48);
		squidUpLft[1] = enemiesD3.crop(48, 408, 48, 48);
		squidUpLft[2] = enemiesD3.crop(96, 408, 48, 48);
		squidUpLft[3] = enemiesD3.crop(144, 408, 48, 48);
		
		squidUpRgt = new BufferedImage[4];
		squidUpRgt[0] = enemiesD3.crop(192, 408, 48, 48);
		squidUpRgt[1] = enemiesD3.crop(240, 408, 48, 48);
		squidUpRgt[2] = enemiesD3.crop(288, 408, 48, 48);
		squidUpRgt[3] = enemiesD3.crop(336, 408, 48, 48);
		
		squidDwnRgt = new BufferedImage[4];
		squidDwnRgt[0] = enemiesD3.crop(192, 360, 48, 48);
		squidDwnRgt[1] = enemiesD3.crop(240, 360, 48, 48);
		squidDwnRgt[2] = enemiesD3.crop(288, 360, 48, 48);
		squidDwnRgt[3] = enemiesD3.crop(336, 360, 48, 48);

		squidAtkDwnLft  = new BufferedImage[6];
		squidAtkDwnLft[0] = enemiesD3.crop(0, 456, 48, 48);
		squidAtkDwnLft[1] = enemiesD3.crop(48, 456, 48, 48);
		squidAtkDwnLft[2] = enemiesD3.crop(96, 456, 48, 48);
		squidAtkDwnLft[3] = enemiesD3.crop(144, 456, 48, 48);
		squidAtkDwnLft[4] = enemiesD3.crop(192, 456, 48, 48);
		squidAtkDwnLft[5] = enemiesD3.crop(240, 456, 48, 48);
		
		squidAtkUpLft = new BufferedImage[6];
		squidAtkUpLft[0] = enemiesD3.crop(0, 504, 48, 48);
		squidAtkUpLft[1] = enemiesD3.crop(48, 504, 48, 48);
		squidAtkUpLft[2] = enemiesD3.crop(96, 504, 48, 48);
		squidAtkUpLft[3] = enemiesD3.crop(144, 504, 48, 48);
		squidAtkUpLft[4] = enemiesD3.crop(192, 504, 48, 48);
		squidAtkUpLft[5] = enemiesD3.crop(240, 504, 48, 48);
		
		squidAtkUpRgt  = new BufferedImage[6];
		squidAtkUpRgt[0] = enemiesD3.crop(528, 504, 48, 48);
		squidAtkUpRgt[1] = enemiesD3.crop(480, 504, 48, 48);
		squidAtkUpRgt[2] = enemiesD3.crop(432, 504, 48, 48);
		squidAtkUpRgt[3] = enemiesD3.crop(384, 504, 48, 48);
		squidAtkUpRgt[4] = enemiesD3.crop(336, 504, 48, 48);
		squidAtkUpRgt[5] = enemiesD3.crop(288, 504, 48, 48);

		squidAtkDwnRgt = new BufferedImage[6];
		squidAtkDwnRgt[0] = enemiesD3.crop(528, 456, 48, 48);
		squidAtkDwnRgt[1] = enemiesD3.crop(480, 456, 48, 48);
		squidAtkDwnRgt[2] = enemiesD3.crop(432, 456, 48, 48);
		squidAtkDwnRgt[3] = enemiesD3.crop(384, 456, 48, 48);
		squidAtkDwnRgt[4] = enemiesD3.crop(336, 456, 48, 48);
		squidAtkDwnRgt[5] = enemiesD3.crop(288, 456, 48, 48);
		
		seaMineDwnLft = new BufferedImage[3];
		seaMineDwnLft[0] = enemiesD3.crop(0, 552, 40, 40);
		seaMineDwnLft[1] = enemiesD3.crop(40, 552, 40, 40);
		seaMineDwnLft[2] = enemiesD3.crop(80, 552, 40, 40);
		
		seaMineUpLft = new BufferedImage[3];
		seaMineUpLft[0] = enemiesD3.crop(0, 592, 40, 40);
		seaMineUpLft[1] = enemiesD3.crop(40, 592, 40, 40);
		seaMineUpLft[2] = enemiesD3.crop(80, 592, 40, 40);
		
		seaMineUpRgt = new BufferedImage[3];
		seaMineUpRgt[0] = enemiesD3.crop(200, 592, 40, 40);
		seaMineUpRgt[1] = enemiesD3.crop(160, 592, 40, 40);
		seaMineUpRgt[2] = enemiesD3.crop(120, 592, 40, 40);
		
		seaMineDwnRgt = new BufferedImage[3];
		seaMineDwnRgt[0] = enemiesD3.crop(200, 552, 40, 40);
		seaMineDwnRgt[1] = enemiesD3.crop(160, 552, 40, 40);
		seaMineDwnRgt[2] = enemiesD3.crop(120, 552, 40, 40);

		seaMineAtkDwnLft  = new BufferedImage[3];
		seaMineAtkDwnLft[0] = enemiesD3.crop(0, 632, 40, 40);
		seaMineAtkDwnLft[1] = enemiesD3.crop(40, 632, 40, 40);
		seaMineAtkDwnLft[2] = enemiesD3.crop(80, 632, 40, 40);
		
		seaMineAtkUpLft = new BufferedImage[3];
		seaMineAtkUpLft[0] = enemiesD3.crop(200, 672, 40, 40);
		seaMineAtkUpLft[1] = enemiesD3.crop(160, 672, 40, 40);
		seaMineAtkUpLft[2] = enemiesD3.crop(120, 672, 40, 40);
		
		seaMineAtkUpRgt  = new BufferedImage[3];
		seaMineAtkUpRgt[0] = enemiesD3.crop(0, 672, 40, 40);
		seaMineAtkUpRgt[1] = enemiesD3.crop(40, 672, 40, 40);
		seaMineAtkUpRgt[2] = enemiesD3.crop(80, 672, 40, 40);

		seaMineAtkDwnRgt = new BufferedImage[3];
		seaMineAtkDwnRgt[0] = enemiesD3.crop(200, 632, 40, 40);
		seaMineAtkDwnRgt[1] = enemiesD3.crop(160, 632, 40, 40);
		seaMineAtkDwnRgt[2] = enemiesD3.crop(120, 632, 40, 40);
		
		starfishDwnLft = new BufferedImage[4];
		starfishDwnLft[0] = enemiesD3.crop(0, 712, 35, 35);
		starfishDwnLft[1] = enemiesD3.crop(35, 712, 35, 35);
		starfishDwnLft[2] = enemiesD3.crop(70, 712, 35, 35);
		starfishDwnLft[3] = enemiesD3.crop(105, 712, 35, 35);
		
		starfishUpLft = new BufferedImage[4];
		starfishUpLft[0] = enemiesD3.crop(0, 747, 35, 35);
		starfishUpLft[1] = enemiesD3.crop(35, 747, 35, 35);
		starfishUpLft[2] = enemiesD3.crop(70, 747, 35, 35);
		starfishUpLft[3] = enemiesD3.crop(105, 747, 35, 35);
		
		starfishUpRgt = new BufferedImage[4];
		starfishUpRgt[0] = enemiesD3.crop(245, 747, 35, 35);
		starfishUpRgt[1] = enemiesD3.crop(210, 747, 35, 35);
		starfishUpRgt[2] = enemiesD3.crop(175, 747, 35, 35);
		starfishUpRgt[3] = enemiesD3.crop(140, 747, 35, 35);
		
		starfishDwnRgt = new BufferedImage[4];
		starfishDwnRgt[0] = enemiesD3.crop(245, 712, 35, 35);
		starfishDwnRgt[1] = enemiesD3.crop(210, 712, 35, 35);
		starfishDwnRgt[2] = enemiesD3.crop(175, 712, 35, 35);
		starfishDwnRgt[3] = enemiesD3.crop(140, 712, 35, 35);
		

		starfishAtkDwnLft  = new BufferedImage[3];
		starfishAtkDwnLft[0] = enemiesD3.crop(0, 782, 35, 35);
		starfishAtkDwnLft[1] = enemiesD3.crop(35, 782, 35, 35);
		starfishAtkDwnLft[2] = enemiesD3.crop(70, 782, 35, 35);
		
		starfishAtkUpLft = new BufferedImage[3];
		starfishAtkUpLft[0] = enemiesD3.crop(0, 817, 35, 35);
		starfishAtkUpLft[1] = enemiesD3.crop(35, 817, 35, 35);
		starfishAtkUpLft[2] = enemiesD3.crop(70, 817, 35, 35);
		
		starfishAtkUpRgt  = new BufferedImage[3];
		starfishAtkUpRgt[0] = enemiesD3.crop(175, 817, 35, 35);
		starfishAtkUpRgt[1] = enemiesD3.crop(140, 817, 35, 35);
		starfishAtkUpRgt[2] = enemiesD3.crop(105, 817, 35, 35);

		starfishAtkDwnRgt = new BufferedImage[3];
		starfishAtkDwnRgt[0] = enemiesD3.crop(175, 782, 35, 35);
		starfishAtkDwnRgt[1] = enemiesD3.crop(140, 782, 35, 35);
		starfishAtkDwnRgt[2] = enemiesD3.crop(105, 782, 35, 35);
		
		sharkDwnLft = new BufferedImage[4];
		sharkDwnLft[0] = enemiesD3.crop(0, 90, 45, 45);
		sharkDwnLft[1] = enemiesD3.crop(45, 90, 45, 45);
		sharkDwnLft[2] = enemiesD3.crop(90, 90, 45, 45);
		sharkDwnLft[3] = enemiesD3.crop(135, 90, 45, 45);
		
		sharkUpLft = new BufferedImage[4];
		sharkUpLft[0] = enemiesD3.crop(0, 135, 45, 45);
		sharkUpLft[1] = enemiesD3.crop(45, 135, 45, 45);
		sharkUpLft[2] = enemiesD3.crop(90, 135, 45, 45);
		sharkUpLft[3] = enemiesD3.crop(135, 135, 45, 45);
		
		sharkUpRgt = new BufferedImage[4];
		sharkUpRgt[0] = enemiesD3.crop(180, 135, 45, 45);
		sharkUpRgt[1] = enemiesD3.crop(225, 135, 45, 45);
		sharkUpRgt[2] = enemiesD3.crop(270, 135, 45, 45);
		sharkUpRgt[3] = enemiesD3.crop(315, 135, 45, 45);
		
		sharkDwnRgt = new BufferedImage[4];
		sharkDwnRgt[0] = enemiesD3.crop(180, 90, 45, 45);
		sharkDwnRgt[1] = enemiesD3.crop(225, 90, 45, 45);
		sharkDwnRgt[2] = enemiesD3.crop(270, 90, 45, 45);
		sharkDwnRgt[3] = enemiesD3.crop(315, 90, 45, 45);

		sharkAtkDwnLft  = new BufferedImage[8];
		sharkAtkDwnLft[0] = enemiesD3.crop(0, 180, 45, 45);
		sharkAtkDwnLft[1] = enemiesD3.crop(45, 180, 45, 45);
		sharkAtkDwnLft[2] = enemiesD3.crop(90, 180, 45, 45);
		sharkAtkDwnLft[3] = enemiesD3.crop(135, 180, 45, 45);
		sharkAtkDwnLft[4] = enemiesD3.crop(180, 180, 45, 45);
		sharkAtkDwnLft[5] = enemiesD3.crop(225, 180, 45, 45);
		sharkAtkDwnLft[6] = enemiesD3.crop(270, 180, 45, 45);
		sharkAtkDwnLft[7] = enemiesD3.crop(315, 180, 45, 45);
		
		sharkAtkUpLft = new BufferedImage[8];
		sharkAtkUpLft[0] = enemiesD3.crop(0, 225, 45, 45);
		sharkAtkUpLft[1] = enemiesD3.crop(45, 225, 45, 45);
		sharkAtkUpLft[2] = enemiesD3.crop(90, 225, 45, 45);
		sharkAtkUpLft[3] = enemiesD3.crop(135, 225, 45, 45);
		sharkAtkUpLft[4] = enemiesD3.crop(180, 225, 45, 45);
		sharkAtkUpLft[5] = enemiesD3.crop(225, 225, 45, 45);
		sharkAtkUpLft[6] = enemiesD3.crop(270, 225, 45, 45);
		sharkAtkUpLft[7] = enemiesD3.crop(315, 225, 45, 45);
		
		sharkAtkUpRgt  = new BufferedImage[8];
		sharkAtkUpRgt[0] = enemiesD3.crop(0, 315, 45, 45);
		sharkAtkUpRgt[1] = enemiesD3.crop(45, 315, 45, 45);
		sharkAtkUpRgt[2] = enemiesD3.crop(90, 315, 45, 45);
		sharkAtkUpRgt[3] = enemiesD3.crop(135, 315, 45, 45);
		sharkAtkUpRgt[4] = enemiesD3.crop(180, 315, 45, 45);
		sharkAtkUpRgt[5] = enemiesD3.crop(225, 315, 45, 45);
		sharkAtkUpRgt[6] = enemiesD3.crop(270, 315, 45, 45);
		sharkAtkUpRgt[7] = enemiesD3.crop(315, 315, 45, 45);

		sharkAtkDwnRgt = new BufferedImage[8];
		sharkAtkDwnRgt[0] = enemiesD3.crop(0, 270, 45, 45);
		sharkAtkDwnRgt[1] = enemiesD3.crop(45, 270, 45, 45);
		sharkAtkDwnRgt[2] = enemiesD3.crop(90, 270, 45, 45);
		sharkAtkDwnRgt[3] = enemiesD3.crop(135, 270, 45, 45);
		sharkAtkDwnRgt[4] = enemiesD3.crop(180, 270, 45, 45);
		sharkAtkDwnRgt[5] = enemiesD3.crop(225, 270, 45, 45);
		sharkAtkDwnRgt[6] = enemiesD3.crop(270, 270, 45, 45);
		sharkAtkDwnRgt[7] = enemiesD3.crop(315, 270, 45, 45);
		
		sharkIdleDwnLft  = new BufferedImage[4];
		sharkIdleDwnLft[0] = enemiesD3.crop(0, 0, 45, 45);
		sharkIdleDwnLft[1] = enemiesD3.crop(45, 0, 45, 45);
		sharkIdleDwnLft[2] = enemiesD3.crop(90, 0, 45, 45);
		sharkIdleDwnLft[3] = enemiesD3.crop(135, 0, 45, 45);
		
		sharkIdleUpLft = new BufferedImage[4];
		sharkIdleUpLft[0] = enemiesD3.crop(0, 45, 45, 45);
		sharkIdleUpLft[1] = enemiesD3.crop(45, 45, 45, 45);
		sharkIdleUpLft[2] = enemiesD3.crop(90, 45, 45, 45);
		sharkIdleUpLft[3] = enemiesD3.crop(135, 45, 45, 45);

		sharkIdleUpRgt  = new BufferedImage[4];
		sharkIdleUpRgt[0] = enemiesD3.crop(180, 45, 45, 45);
		sharkIdleUpRgt[1] = enemiesD3.crop(225, 45, 45, 45);
		sharkIdleUpRgt[2] = enemiesD3.crop(270, 45, 45, 45);
		sharkIdleUpRgt[3] = enemiesD3.crop(315, 45, 45, 45);

		sharkIdleDwnRgt = new BufferedImage[4];
		sharkIdleDwnRgt[0] = enemiesD3.crop(180, 0, 45, 45);
		sharkIdleDwnRgt[1] = enemiesD3.crop(225, 0, 45, 45);
		sharkIdleDwnRgt[2] = enemiesD3.crop(270, 0, 45, 45);
		sharkIdleDwnRgt[3] = enemiesD3.crop(315, 0, 45, 45);
		
		
	}
	
	public static void loadEnimiesD1D2()
	{
		SpriteSheet enemiesD1 = new SpriteSheet(ResourceLoader.loadTexture("enemiesD1.png"));
		SpriteSheet enemiesD2 = new SpriteSheet(ResourceLoader.loadTexture("enemiesD2.png"));
		
		turtleDwnLft = new BufferedImage[4];
		turtleDwnLft[0] = enemiesD2.crop(0, height * 6, width, height);
		turtleDwnLft[1] = enemiesD2.crop(width, height * 6, width, height);
		turtleDwnLft[2] = enemiesD2.crop(width * 2, height * 6, width, height);
		turtleDwnLft[3] = enemiesD2.crop(width, height * 6, width, height);
		
		turtleUpRgt = new BufferedImage[4];
		turtleUpRgt[0] = enemiesD2.crop(width * 3, height * 6, width, height);
		turtleUpRgt[1] = enemiesD2.crop(width * 4, height * 6, width, height);
		turtleUpRgt[2] = enemiesD2.crop(width * 5, height * 6, width, height);
		turtleUpRgt[3] = enemiesD2.crop(width * 4, height * 6, width, height);
		
		turtleUpLft = new BufferedImage[4];
		turtleUpLft[0] = enemiesD2.crop(width * 2, height * 7, width, height);
		turtleUpLft[1] = enemiesD2.crop(width * 3, height * 7, width, height);
		turtleUpLft[2] = enemiesD2.crop(width * 4, height * 7, width, height);
		turtleUpLft[3] = enemiesD2.crop(width * 3, height * 7, width, height);
		
		turtleDwnRgt = new BufferedImage[4];
		turtleDwnRgt[0] = enemiesD2.crop(width * 5, height * 7, width, height);
		turtleDwnRgt[1] = enemiesD2.crop(width * 6, height * 7, width, height);
		turtleDwnRgt[2] = enemiesD2.crop(width * 7, height * 7, width, height);
		turtleDwnRgt[3] = enemiesD2.crop(width * 6, height * 7, width, height);
		
		turtleInShell = new BufferedImage[4];
		turtleInShell[0] = enemiesD2.crop(width * 7, height * 6, width, height);
		turtleInShell[1] = enemiesD2.crop(0, height * 7, width, height);
		turtleInShell[2] = enemiesD2.crop(width * 6, height * 6, width, height);
		turtleInShell[3] = enemiesD2.crop(width, height * 7, width, height);
		
		slimeDwnLft = new BufferedImage[4];
		slimeDwnLft[0] = enemiesD2.crop(256, 0, width, height);
		slimeDwnLft[1] = enemiesD2.crop(288, 0, width, height);
		slimeDwnLft[2] = enemiesD2.crop(320, 0, width, height);
		slimeDwnLft[3] = enemiesD2.crop(352, 0, width, height);
		
		slimeUpLft = new BufferedImage[4];
		slimeUpLft[0] = enemiesD2.crop(256, 32, width, height);
		slimeUpLft[1] = enemiesD2.crop(288, 32, width, height);
		slimeUpLft[2] = enemiesD2.crop(320, 32, width, height);
		slimeUpLft[3] = enemiesD2.crop(352, 32, width, height);
		
		slimeUpRgt = new BufferedImage[4];
		slimeUpRgt[0] = enemiesD2.crop(256, 96, width, height);
		slimeUpRgt[1] = enemiesD2.crop(288, 96, width, height);
		slimeUpRgt[2] = enemiesD2.crop(320, 96, width, height);
		slimeUpRgt[3] = enemiesD2.crop(352, 96, width, height);
		
		slimeDwnRgt = new BufferedImage[4];
		slimeDwnRgt[0] = enemiesD2.crop(256, 64, width, height);
		slimeDwnRgt[1] = enemiesD2.crop(288, 64, width, height);
		slimeDwnRgt[2] = enemiesD2.crop(320, 64, width, height);
		slimeDwnRgt[3] = enemiesD2.crop(352, 64, width, height);
		
		birdDwnLft = new BufferedImage[4];
		birdDwnLft[0] = enemiesD2.crop(192, 256, 48, 45);
		birdDwnLft[1] = enemiesD2.crop(240, 256, 48, 45);
		birdDwnLft[2] = enemiesD2.crop(288, 256, 48, 45);
		birdDwnLft[3] = enemiesD2.crop(336, 256, 48, 45);
		
		birdUpLft = new BufferedImage[4];
		birdUpLft[0] = enemiesD2.crop(192, 301, 48, 45);
		birdUpLft[1] = enemiesD2.crop(240, 301, 48, 45);
		birdUpLft[2] = enemiesD2.crop(288, 301, 48, 45);
		birdUpLft[3] = enemiesD2.crop(336, 301, 48, 45);
		
		birdUpRgt = new BufferedImage[4];
		birdUpRgt[0] = enemiesD2.crop(0, 301, 48, 45);
		birdUpRgt[1] = enemiesD2.crop(48, 301, 48, 45);
		birdUpRgt[2] = enemiesD2.crop(96, 301, 48, 45);
		birdUpRgt[3] = enemiesD2.crop(144, 301, 48, 45);
		
		birdDwnRgt = new BufferedImage[4];
		birdDwnRgt[0] = enemiesD2.crop(0, 256, 48, 45);
		birdDwnRgt[1] = enemiesD2.crop(48, 256, 48, 45);
		birdDwnRgt[2] = enemiesD2.crop(96, 256, 48, 45);
		birdDwnRgt[3] = enemiesD2.crop(144, 256, 48, 45);

		birdAtkDwnLft  = new BufferedImage[4];
		birdAtkDwnLft[0] = enemiesD2.crop(336, 346, 48, 45);
		birdAtkDwnLft[1] = enemiesD2.crop(288, 346, 48, 45);
		birdAtkDwnLft[2] = enemiesD2.crop(240, 346, 48, 45);
		birdAtkDwnLft[3] = enemiesD2.crop(192, 346, 48, 45);
		
		birdAtkUpLft = new BufferedImage[4];
		birdAtkUpLft[0] = enemiesD2.crop(336, 391, 48, 45);
		birdAtkUpLft[1] = enemiesD2.crop(288, 391, 48, 45);
		birdAtkUpLft[2] = enemiesD2.crop(240, 391, 48, 45);
		birdAtkUpLft[3] = enemiesD2.crop(192, 391, 48, 45);

		birdAtkUpRgt  = new BufferedImage[4];
		birdAtkUpRgt[0] = enemiesD2.crop(0, 391, 48, 45);
		birdAtkUpRgt[1] = enemiesD2.crop(48, 391, 48, 45);
		birdAtkUpRgt[2] = enemiesD2.crop(96, 391, 48, 45);
		birdAtkUpRgt[3] = enemiesD2.crop(144, 391, 48, 45);

		birdAtkDwnRgt = new BufferedImage[4];
		birdAtkDwnRgt[0] = enemiesD2.crop(0, 346, 48, 45);
		birdAtkDwnRgt[1] = enemiesD2.crop(48, 346, 48, 45);
		birdAtkDwnRgt[2] = enemiesD2.crop(96, 346, 48, 45);
		birdAtkDwnRgt[3] = enemiesD2.crop(144, 346, 48, 45);
		
		gremlinDwnLft = new BufferedImage[4];
		gremlinDwnLft[0] = enemiesD2.crop(0, 0, width, height);
		gremlinDwnLft[1] = enemiesD2.crop(width, 0, width, height);
		gremlinDwnLft[2] = enemiesD2.crop(width * 2, 0, width, height);
		gremlinDwnLft[3] = enemiesD2.crop(width * 3, 0, width, height);
		
		gremlinUpLft = new BufferedImage[4];
		gremlinUpLft[0] = enemiesD2.crop(width * 4, 0, width, height);
		gremlinUpLft[1] = enemiesD2.crop(width * 5, 0, width, height);
		gremlinUpLft[2] = enemiesD2.crop(width * 6, 0, width, height);
		gremlinUpLft[3] = enemiesD2.crop(width * 7, 0, width, height);
		
		gremlinUpRgt = new BufferedImage[4];
		gremlinUpRgt[0] = enemiesD2.crop(width * 3, height, width, height);
		gremlinUpRgt[1] = enemiesD2.crop(width * 2, height, width, height);
		gremlinUpRgt[2] = enemiesD2.crop(width, height, width, height);
		gremlinUpRgt[3] = enemiesD2.crop(0, height, width, height);
		
		gremlinDwnRgt = new BufferedImage[4];
		gremlinDwnRgt[0] = enemiesD2.crop(width * 7, height, width, height);
		gremlinDwnRgt[1] = enemiesD2.crop(width * 6, height, width, height);
		gremlinDwnRgt[2] = enemiesD2.crop(width * 5, height, width, height);
		gremlinDwnRgt[3] = enemiesD2.crop(width * 4, height, width, height);
		
		gremlinIdleDwnLft = new BufferedImage[4];
		gremlinIdleDwnLft[0] = enemiesD2.crop(0, height * 2, width, height);
		gremlinIdleDwnLft[1] = enemiesD2.crop(width, height * 2, width, height);
		gremlinIdleDwnLft[2] = enemiesD2.crop(width * 2, height * 2, width, height);
		gremlinIdleDwnLft[3] = enemiesD2.crop(width, height * 2, width, height);

		gremlinAtkDwnLft  = new BufferedImage[7];
		gremlinAtkDwnLft[0] = enemiesD2.crop(width * 3, height * 2, width, height);
		gremlinAtkDwnLft[1] = enemiesD2.crop(width * 4, height * 2, width, height);
		gremlinAtkDwnLft[2] = enemiesD2.crop(width * 5, height * 2, width, height);
		gremlinAtkDwnLft[3] = enemiesD2.crop(width * 6, height * 2, width, height);
		gremlinAtkDwnLft[4] = enemiesD2.crop(width * 7, height * 2, width, height);
		gremlinAtkDwnLft[5] = enemiesD2.crop(width * 7, height * 2, width, height);
		gremlinAtkDwnLft[6] = enemiesD2.crop(width * 7, height * 2, width, height);
		
		gremlinIdleUpLft = new BufferedImage[4];
		gremlinIdleUpLft[0] = enemiesD2.crop(0, height * 3, width, height);
		gremlinIdleUpLft[1] = enemiesD2.crop(width, height * 3, width, height);
		gremlinIdleUpLft[2] = enemiesD2.crop(width * 2, height * 3, width, height);
		gremlinIdleUpLft[3] = enemiesD2.crop(width, height * 3, width, height);

		gremlinAtkUpLft  = new BufferedImage[7];
		gremlinAtkUpLft[0] = enemiesD2.crop(width * 3, height * 3, width, height);
		gremlinAtkUpLft[1] = enemiesD2.crop(width * 4, height * 3, width, height);
		gremlinAtkUpLft[2] = enemiesD2.crop(width * 5, height * 3, width, height);
		gremlinAtkUpLft[3] = enemiesD2.crop(width * 6, height * 3, width, height);
		gremlinAtkUpLft[4] = enemiesD2.crop(width * 7, height * 3, width, height);
		gremlinAtkUpLft[5] = enemiesD2.crop(width * 7, height * 3, width, height);
		gremlinAtkUpLft[6] = enemiesD2.crop(width * 7, height * 3, width, height);

		gremlinIdleDwnRgt = new BufferedImage[4];
		gremlinIdleDwnRgt[0] = enemiesD2.crop(width * 6, height * 4, width, height);
		gremlinIdleDwnRgt[1] = enemiesD2.crop(width * 5, height * 4, width, height);
		gremlinIdleDwnRgt[2] = enemiesD2.crop(width * 6, height * 4, width, height);
		gremlinIdleDwnRgt[3] = enemiesD2.crop(width * 7, height * 4, width, height);

		gremlinAtkDwnRgt  = new BufferedImage[7];
		gremlinAtkDwnRgt[0] = enemiesD2.crop(width * 4, height * 4, width, height);
		gremlinAtkDwnRgt[1] = enemiesD2.crop(width * 3, height * 4, width, height);
		gremlinAtkDwnRgt[2] = enemiesD2.crop(width * 2, height * 4, width, height);
		gremlinAtkDwnRgt[3] = enemiesD2.crop(width, height * 4, width, height);
		gremlinAtkDwnRgt[4] = enemiesD2.crop(0, height * 4, width, height);
		gremlinAtkDwnRgt[5] = enemiesD2.crop(0, height * 4, width, height);
		gremlinAtkDwnRgt[6] = enemiesD2.crop(0, height * 4, width, height);
		
		gremlinIdleUpRgt = new BufferedImage[4];
		gremlinIdleUpRgt[0] = enemiesD2.crop(width * 6, height * 5, width, height);
		gremlinIdleUpRgt[1] = enemiesD2.crop(width * 5, height * 5, width, height);
		gremlinIdleUpRgt[2] = enemiesD2.crop(width * 6, height * 5, width, height);
		gremlinIdleUpRgt[3] = enemiesD2.crop(width * 7, height * 5, width, height);

		gremlinAtkUpRgt  = new BufferedImage[7];
		gremlinAtkUpRgt[0] = enemiesD2.crop(width * 4, height * 5, width, height);
		gremlinAtkUpRgt[1] = enemiesD2.crop(width * 3, height * 5, width, height);
		gremlinAtkUpRgt[2] = enemiesD2.crop(width * 2, height * 5, width, height);
		gremlinAtkUpRgt[3] = enemiesD2.crop(width, height * 5, width, height);
		gremlinAtkUpRgt[4] = enemiesD2.crop(0, height * 5, width, height);
		gremlinAtkUpRgt[5] = enemiesD2.crop(0, height * 5, width, height);
		gremlinAtkUpRgt[6] = enemiesD2.crop(0, height * 5, width, height);
		
		batLeft = new BufferedImage[4];
		batLeft[0] = enemiesD1.crop(0, 326, width, height);
		batLeft[1] = enemiesD1.crop(width, 326, width, height);
		batLeft[2] = enemiesD1.crop(width * 2, 326, width, height);
		batLeft[3] = enemiesD1.crop(width * 3, 326, width, height);
		
		batRight = new BufferedImage[4];
		batRight[0] = enemiesD1.crop(0, 358, width, height);
		batRight[1] = enemiesD1.crop(width, 358, width, height);
		batRight[2] = enemiesD1.crop(width * 2, 358, width, height);
		batRight[3] = enemiesD1.crop(width * 3, 358, width, height);
		
		spiderLeft = new BufferedImage[3];
		spiderLeft[0] = enemiesD1.crop(0, 0, width, height);
		spiderLeft[1] = enemiesD1.crop(width, 0, width, height);
		spiderLeft[2] = enemiesD1.crop(width * 2, 0, width, height);
		
		spiderRight = new BufferedImage[3];
		spiderRight[0] = enemiesD1.crop(0, height, width, height);
		spiderRight[1] = enemiesD1.crop(width, height, width, height);
		spiderRight[2] = enemiesD1.crop(width * 2, height, width, height);
		
		beetleDwnLft = new BufferedImage[3];
		beetleDwnLft[0] = enemiesD1.crop(0, 191, 40, 34);
		beetleDwnLft[1] = enemiesD1.crop(40, 191, 40, 34);
		beetleDwnLft[2] = enemiesD1.crop(80, 191, 40, 34);
		
		beetleDwnRgt = new BufferedImage[3];
		beetleDwnRgt[0] = enemiesD1.crop(0, 225, 40, 34);
		beetleDwnRgt[1] = enemiesD1.crop(40, 225, 40, 34);
		beetleDwnRgt[2] = enemiesD1.crop(80, 225, 40, 34);
		
		beetleUpLft = new BufferedImage[3];
		beetleUpLft[0] = enemiesD1.crop(0, 259, 40, 34);
		beetleUpLft[1] = enemiesD1.crop(40, 259, 40, 34);
		beetleUpLft[2] = enemiesD1.crop(80, 259, 40, 34);
		
		beetleUpRgt = new BufferedImage[3];
		beetleUpRgt[0] = enemiesD1.crop(0, 293, 40, 34);
		beetleUpRgt[1] = enemiesD1.crop(40, 293, 40, 34);
		beetleUpRgt[2] = enemiesD1.crop(80, 293, 40, 34);
		
		beetleDwnLftAtk = new BufferedImage[3];
		beetleDwnLftAtk[0] = enemiesD1.crop(120, 191, 40, 34);
		beetleDwnLftAtk[1] = enemiesD1.crop(160, 191, 40, 34);
		beetleDwnLftAtk[2] = enemiesD1.crop(200, 191, 40, 34);
		
		beetleDwnRgtAtk = new BufferedImage[3];
		beetleDwnRgtAtk[0] = enemiesD1.crop(120, 225, 40, 34);
		beetleDwnRgtAtk[1] = enemiesD1.crop(160, 225, 40, 34);
		beetleDwnRgtAtk[2] = enemiesD1.crop(200, 225, 40, 34);
		
		beetleUpLftAtk = new BufferedImage[3];
		beetleUpLftAtk[0] = enemiesD1.crop(120, 259, 40, 34);
		beetleUpLftAtk[1] = enemiesD1.crop(160, 259, 40, 34);
		beetleUpLftAtk[2] = enemiesD1.crop(200, 259, 40, 34);
		
		beetleUpRgtAtk = new BufferedImage[3];
		beetleUpRgtAtk[0] = enemiesD1.crop(120, 293, 40, 34);
		beetleUpRgtAtk[1] = enemiesD1.crop(160, 293, 40, 34);
		beetleUpRgtAtk[2] = enemiesD1.crop(200, 293, 40, 34);
		
		milliBodyDownLeft = new BufferedImage[4];
		milliBodyDownLeft[0] = enemiesD1.crop(0, height * 2 + 13, 18, 18);
		milliBodyDownLeft[1] = enemiesD1.crop(width, height * 2 + 13, 18, 18);
		milliBodyDownLeft[2] = enemiesD1.crop(width * 2, height * 2 + 13, 18, 18);
		milliBodyDownLeft[3] = enemiesD1.crop(width * 3, height * 2 + 13, 18, 18);
		
		milliBodyDownRight = new BufferedImage[4];
		milliBodyDownRight[0] = enemiesD1.crop(0, height * 3 + 13, 18, 18);
		milliBodyDownRight[1] = enemiesD1.crop(width, height * 3 + 13, 18, 18);
		milliBodyDownRight[2] = enemiesD1.crop(width * 2, height * 3 + 13, 18, 18);
		milliBodyDownRight[3] = enemiesD1.crop(width * 3, height * 3 + 13, 18, 18);
		
		milliBodyUpRight = new BufferedImage[4];
		milliBodyUpRight[0] = enemiesD1.crop(0, height * 4 + 13, 18, 18);
		milliBodyUpRight[1] = enemiesD1.crop(width, height * 4 + 13, 18, 18);
		milliBodyUpRight[2] = enemiesD1.crop(width * 2, height * 4 + 13, 18, 18);
		milliBodyUpRight[3] = enemiesD1.crop(width * 3, height * 4 + 13, 18, 18);
		
		milliBodyUpLeft = new BufferedImage[4];
		milliBodyUpLeft[0] = enemiesD1.crop(0, height * 5 + 13, 18, 18);
		milliBodyUpLeft[1] = enemiesD1.crop(width, height * 5 + 13, 18, 18);
		milliBodyUpLeft[2] = enemiesD1.crop(width * 2, height * 5 + 13, 18, 18);
		milliBodyUpLeft[3] = enemiesD1.crop(width * 3, height * 5 + 13, 18, 18);
		
		milliHead = new BufferedImage[4];
		milliHead[0] = enemiesD1.crop(width * 4, height * 2 + 13, 18, 18);
		milliHead[1] = enemiesD1.crop(width * 4, height * 3 + 13, 18, 18);
		milliHead[2] = enemiesD1.crop(width * 4, height * 4 + 13, 18, 18);
		milliHead[3] = enemiesD1.crop(width * 4, height * 5 + 13, 18, 18);
		
		milliTail = new BufferedImage[4];
		milliTail[0] = enemiesD1.crop(width * 5, height * 2 + 13, 18, 18);
		milliTail[1] = enemiesD1.crop(width * 5, height * 3 + 13, 18, 18);
		milliTail[2] = enemiesD1.crop(width * 5, height * 4 + 13, 18, 18);
		milliTail[3] = enemiesD1.crop(width * 5, height * 5 + 13, 18, 18);
	}
	
	public static void loadTileSets()
	{
		SpriteSheet sheet4 = new SpriteSheet(ResourceLoader.loadTexture("blackTile.png"));
		SpriteSheet D1TileSheet = new SpriteSheet(ResourceLoader.loadTexture("D1Tileset.png"));
		SpriteSheet D2TileSheet = new SpriteSheet(ResourceLoader.loadTexture("D2Tileset.png"));
		SpriteSheet D3TileSheet = new SpriteSheet(ResourceLoader.loadTexture("D3Tileset.png"));
		SpriteSheet D4TileSheet = new SpriteSheet(ResourceLoader.loadTexture("D4Tileset.png"));
		SpriteSheet D5TileSheet = new SpriteSheet(ResourceLoader.loadTexture("D5Tileset.png"));
		SpriteSheet D7TileSheet = new SpriteSheet(ResourceLoader.loadTexture("D7Tileset.png"));
		SpriteSheet D8TileSheet = new SpriteSheet(ResourceLoader.loadTexture("D8Tileset.png"));

		D1Tileset = new BufferedImage[30];
		D1Tileset[0] = sheet4.crop(0, 0, width, height);

		D1Tileset[1] = D1TileSheet.crop(0, 0, width, height);
		D1Tileset[2] = D1TileSheet.crop(width, 0, width , height);
		D1Tileset[3] = D1TileSheet.crop(width * 2, 0, width, height);
		D1Tileset[4] = D1TileSheet.crop(width * 3, 0, width, height);
		D1Tileset[5] = D1TileSheet.crop(width * 4, 0, width, height);
		D1Tileset[6] = D1TileSheet.crop(width * 0, height * 1, width, height * 1);
		D1Tileset[7] = D1TileSheet.crop(width * 1, height * 1, width * 1, height * 1);
		D1Tileset[8] = D1TileSheet.crop(width * 2, height * 1, width * 1, height * 1);
		D1Tileset[9] = D1TileSheet.crop(width * 3, height * 1, width * 1, height * 1);
		D1Tileset[10] = D1TileSheet.crop(width * 4, height * 1, width * 1, height * 1);
		D1Tileset[11] = D1TileSheet.crop(0, height * 2, width, height);
		D1Tileset[12] = D1TileSheet.crop(width * 1, height * 2, width * 1, height * 1);
		D1Tileset[13] = D1TileSheet.crop(width*2, height*2, width, height);
		D1Tileset[14] = D1TileSheet.crop(width * 0, height * 3, width * 1, height * 1);
		D1Tileset[15] = D1TileSheet.crop(width * 1, height * 3, width * 1, height * 1);
		D1Tileset[16] = D1TileSheet.crop(width * 2, height * 3, width * 1, height * 1);
		D1Tileset[17] = D1TileSheet.crop(width * 0, height * 5, width * 1, height * 1);
		D1Tileset[18] = D1TileSheet.crop(width * 1, height * 5, width * 1, height * 1);
		D1Tileset[19] = D1TileSheet.crop(width * 2, height * 5, width * 1, height * 1);
		for(int i = 20; i < 26; ++i)
			D1Tileset[i] = sheet4.crop(0, 0, width, height);
		D1Tileset[26] = D1TileSheet.crop(320, 480, width * 1, height * 1);
		D1Tileset[27] = D1TileSheet.crop(352, 480, width * 1, height * 1);
		D1Tileset[28] = D1TileSheet.crop(384, 480, width * 1, height * 1);
		D1Tileset[29] = D1TileSheet.crop(width * 4, height * 2, width * 1, height * 1);

		
		D1StaticEntities1 = new BufferedImage[1];
		D1StaticEntities1[0] = D1TileSheet.crop(width * 7, height * 9, width, height * 2);
		
		D2Tileset = new BufferedImage[24];
		D2Tileset[0] = sheet4.crop(0, 0, width, height);
		D2Tileset[1] = D2TileSheet.crop(0, 0, width, height);
		D2Tileset[3] = D2TileSheet.crop(width * 2, 0, width, height);
		D2Tileset[11] = D2TileSheet.crop(0, height * 2, width, height);
		D2Tileset[13] = D2TileSheet.crop(width*2, height*2, width, height);
		D2Tileset[7] = D2TileSheet.crop(width * 1, height * 1, width * 1, height * 1);
		D2Tileset[4] = D2TileSheet.crop(width * 3, height * 0, width * 1, height * 1);
		D2Tileset[5] = D2TileSheet.crop(width * 4, height * 0, width * 1, height * 1);
		D2Tileset[10] = D2TileSheet.crop(width * 4, height * 1, width * 1, height * 1);
		D2Tileset[6] = D2TileSheet.crop(width * 0, height * 1, width * 1, height * 1);
		D2Tileset[2] = D2TileSheet.crop(width * 1, height * 0, width * 1, height * 1);
		D2Tileset[12] = D2TileSheet.crop(width * 1, height * 2, width * 1, height * 1);
		D2Tileset[8] = D2TileSheet.crop(width * 2, height * 1, width * 1, height * 1);
		D2Tileset[9] = D2TileSheet.crop(width * 3, height * 1, width * 1, height * 1);
		D2Tileset[14] = D2TileSheet.crop(width * 0, height * 3, width * 1, height * 1);
		D2Tileset[15] = D2TileSheet.crop(width * 1, height * 3, width * 1, height * 1);
		D2Tileset[16] = D2TileSheet.crop(width * 2, height * 3, width * 1, height * 1);
		D2Tileset[17] = D2TileSheet.crop(width * 0, height * 5, width * 1, height * 1);
		D2Tileset[18] = D2TileSheet.crop(width * 1, height * 5, width * 1, height * 1);
		D2Tileset[19] = D2TileSheet.crop(width * 2, height * 5, width * 1, height * 1);
		D2Tileset[20] = D2TileSheet.crop(320, 480, width * 1, height * 1);
		D2Tileset[21] = D2TileSheet.crop(352, 480, width * 1, height * 1);
		D2Tileset[22] = D2TileSheet.crop(384, 480, width * 1, height * 1);
		D2Tileset[23] = D2TileSheet.crop(width * 4, height * 2, width * 1, height * 1);
		
		D3Tileset = new BufferedImage[24];
		D3Tileset[0] = sheet4.crop(0, 0, width, height);
		D3Tileset[1] = D3TileSheet.crop(0, 0, width, height);
		D3Tileset[3] = D3TileSheet.crop(width * 2, 0, width, height);
		D3Tileset[11] = D3TileSheet.crop(0, height * 2, width, height);
		D3Tileset[13] = D3TileSheet.crop(width*2, height*2, width, height);
		D3Tileset[7] = D3TileSheet.crop(width * 1, height * 1, width * 1, height * 1);
		D3Tileset[4] = D3TileSheet.crop(width * 3, height * 0, width * 1, height * 1);
		D3Tileset[5] = D3TileSheet.crop(width * 4, height * 0, width * 1, height * 1);
		D3Tileset[10] = D3TileSheet.crop(width * 4, height * 1, width * 1, height * 1);
		D3Tileset[6] = D3TileSheet.crop(width * 0, height * 1, width * 1, height * 1);
		D3Tileset[2] = D3TileSheet.crop(width * 1, height * 0, width * 1, height * 1);
		D3Tileset[12] = D3TileSheet.crop(width * 1, height * 2, width * 1, height * 1);
		D3Tileset[8] = D3TileSheet.crop(width * 2, height * 1, width * 1, height * 1);
		D3Tileset[9] = D3TileSheet.crop(width * 3, height * 1, width * 1, height * 1);
		D3Tileset[14] = D3TileSheet.crop(width * 0, height * 3, width * 1, height * 1);
		D3Tileset[15] = D3TileSheet.crop(width * 1, height * 3, width * 1, height * 1);
		D3Tileset[16] = D3TileSheet.crop(width * 2, height * 3, width * 1, height * 1);
		D3Tileset[17] = D3TileSheet.crop(width * 0, height * 5, width * 1, height * 1);
		D3Tileset[18] = D3TileSheet.crop(width * 1, height * 5, width * 1, height * 1);
		D3Tileset[19] = D3TileSheet.crop(width * 2, height * 5, width * 1, height * 1);
		D3Tileset[20] = D3TileSheet.crop(320, 480, width * 1, height * 1);
		D3Tileset[21] = D3TileSheet.crop(352, 480, width * 1, height * 1);
		D3Tileset[22] = D3TileSheet.crop(384, 480, width * 1, height * 1);
		D3Tileset[23] = D3TileSheet.crop(width * 4, height * 2, width * 1, height * 1);
		
		water = D3TileSheet.crop(192, 416, width * 1, height * 1);
		
		D4Tileset = new BufferedImage[24];
		D4Tileset[0] = sheet4.crop(0, 0, width, height);
		D4Tileset[1] = D4TileSheet.crop(0, 0, width, height);
		D4Tileset[3] = D4TileSheet.crop(width * 2, 0, width, height);
		D4Tileset[11] = D4TileSheet.crop(0, height * 2, width, height);
		D4Tileset[13] = D4TileSheet.crop(width*2, height*2, width, height);
		D4Tileset[7] = D4TileSheet.crop(width * 1, height * 1, width * 1, height * 1);
		D4Tileset[4] = D4TileSheet.crop(width * 3, height * 0, width * 1, height * 1);
		D4Tileset[5] = D4TileSheet.crop(width * 4, height * 0, width * 1, height * 1);
		D4Tileset[10] = D4TileSheet.crop(width * 4, height * 1, width * 1, height * 1);
		D4Tileset[6] = D4TileSheet.crop(width * 0, height * 1, width * 1, height * 1);
		D4Tileset[2] = D4TileSheet.crop(width * 1, height * 0, width * 1, height * 1);
		D4Tileset[12] = D4TileSheet.crop(width * 1, height * 2, width * 1, height * 1);
		D4Tileset[8] = D4TileSheet.crop(width * 2, height * 1, width * 1, height * 1);
		D4Tileset[9] = D4TileSheet.crop(width * 3, height * 1, width * 1, height * 1);
		D4Tileset[14] = D4TileSheet.crop(width * 0, height * 3, width * 1, height * 1);
		D4Tileset[15] = D4TileSheet.crop(width * 1, height * 3, width * 1, height * 1);
		D4Tileset[16] = D4TileSheet.crop(width * 2, height * 3, width * 1, height * 1);
		D4Tileset[17] = D4TileSheet.crop(width * 0, height * 5, width * 1, height * 1);
		D4Tileset[18] = D4TileSheet.crop(width * 1, height * 5, width * 1, height * 1);
		D4Tileset[19] = D4TileSheet.crop(width * 2, height * 5, width * 1, height * 1);
		D4Tileset[20] = D4TileSheet.crop(320, 480, width * 1, height * 1);
		D4Tileset[21] = D4TileSheet.crop(352, 480, width * 1, height * 1);
		D4Tileset[22] = D4TileSheet.crop(384, 480, width * 1, height * 1);
		D4Tileset[23] = D4TileSheet.crop(width * 4, height * 2, width * 1, height * 1);
		
		D5Tileset = new BufferedImage[24];
		D5Tileset[0] = sheet4.crop(0, 0, width, height);
		D5Tileset[1] = D5TileSheet.crop(0, 0, width, height);
		D5Tileset[3] = D5TileSheet.crop(width * 2, 0, width, height);
		D5Tileset[11] = D5TileSheet.crop(0, height * 2, width, height);
		D5Tileset[13] = D5TileSheet.crop(width*2, height*2, width, height);
		D5Tileset[7] = D5TileSheet.crop(width * 1, height * 1, width * 1, height * 1);
		D5Tileset[4] = D5TileSheet.crop(width * 3, height * 0, width * 1, height * 1);
		D5Tileset[5] = D5TileSheet.crop(width * 4, height * 0, width * 1, height * 1);
		D5Tileset[10] = D5TileSheet.crop(width * 4, height * 1, width * 1, height * 1);
		D5Tileset[6] = D5TileSheet.crop(width * 0, height * 1, width * 1, height * 1);
		D5Tileset[2] = D5TileSheet.crop(width * 1, height * 0, width * 1, height * 1);
		D5Tileset[12] = D5TileSheet.crop(width * 1, height * 2, width * 1, height * 1);
		D5Tileset[8] = D5TileSheet.crop(width * 2, height * 1, width * 1, height * 1);
		D5Tileset[9] = D5TileSheet.crop(width * 3, height * 1, width * 1, height * 1);
		D5Tileset[14] = D5TileSheet.crop(width * 0, height * 3, width * 1, height * 1);
		D5Tileset[15] = D5TileSheet.crop(width * 1, height * 3, width * 1, height * 1);
		D5Tileset[16] = D5TileSheet.crop(width * 2, height * 3, width * 1, height * 1);
		D5Tileset[17] = D5TileSheet.crop(width * 0, height * 5, width * 1, height * 1);
		D5Tileset[18] = D5TileSheet.crop(width * 1, height * 5, width * 1, height * 1);
		D5Tileset[19] = D5TileSheet.crop(width * 2, height * 5, width * 1, height * 1);
		D5Tileset[20] = D5TileSheet.crop(320, 480, width * 1, height * 1);
		D5Tileset[21] = D5TileSheet.crop(352, 480, width * 1, height * 1);
		D5Tileset[22] = D5TileSheet.crop(384, 480, width * 1, height * 1);
		D5Tileset[23] = D5TileSheet.crop(width * 4, height * 2, width * 1, height * 1);
		
		D7Tileset = new BufferedImage[24];
		D7Tileset[0] = sheet4.crop(0, 0, width, height);
		D7Tileset[1] = D7TileSheet.crop(0, 0, width, height);
		D7Tileset[3] = D7TileSheet.crop(width * 2, 0, width, height);
		D7Tileset[11] = D7TileSheet.crop(0, height * 2, width, height);
		D7Tileset[13] = D7TileSheet.crop(width*2, height*2, width, height);
		D7Tileset[7] = D7TileSheet.crop(width * 1, height * 1, width * 1, height * 1);
		D7Tileset[4] = D7TileSheet.crop(width * 3, height * 0, width * 1, height * 1);
		D7Tileset[5] = D7TileSheet.crop(width * 4, height * 0, width * 1, height * 1);
		D7Tileset[10] = D7TileSheet.crop(width * 4, height * 1, width * 1, height * 1);
		D7Tileset[6] = D7TileSheet.crop(width * 0, height * 1, width * 1, height * 1);
		D7Tileset[2] = D7TileSheet.crop(width * 1, height * 0, width * 1, height * 1);
		D7Tileset[12] = D7TileSheet.crop(width * 1, height * 2, width * 1, height * 1);
		D7Tileset[8] = D7TileSheet.crop(width * 2, height * 1, width * 1, height * 1);
		D7Tileset[9] = D7TileSheet.crop(width * 3, height * 1, width * 1, height * 1);
		D7Tileset[14] = D7TileSheet.crop(width * 0, height * 3, width * 1, height * 1);
		D7Tileset[15] = D7TileSheet.crop(width * 1, height * 3, width * 1, height * 1);
		D7Tileset[16] = D7TileSheet.crop(width * 2, height * 3, width * 1, height * 1);
		D7Tileset[17] = D7TileSheet.crop(width * 0, height * 5, width * 1, height * 1);
		D7Tileset[18] = D7TileSheet.crop(width * 1, height * 5, width * 1, height * 1);
		D7Tileset[19] = D7TileSheet.crop(width * 2, height * 5, width * 1, height * 1);
		D7Tileset[20] = D7TileSheet.crop(320, 480, width * 1, height * 1);
		D7Tileset[21] = D7TileSheet.crop(352, 480, width * 1, height * 1);
		D7Tileset[22] = D7TileSheet.crop(384, 480, width * 1, height * 1);
		D7Tileset[23] = D7TileSheet.crop(width * 4, height * 2, width * 1, height * 1);
		
		D8Tileset = new BufferedImage[24];
		D8Tileset[0] = sheet4.crop(0, 0, width, height);
		D8Tileset[1] = D8TileSheet.crop(0, 0, width, height);
		D8Tileset[3] = D8TileSheet.crop(width * 2, 0, width, height);
		D8Tileset[11] = D8TileSheet.crop(0, height * 2, width, height);
		D8Tileset[13] = D8TileSheet.crop(width*2, height*2, width, height);
		D8Tileset[7] = D8TileSheet.crop(width * 1, height * 1, width * 1, height * 1);
		D8Tileset[4] = D8TileSheet.crop(width * 3, height * 0, width * 1, height * 1);
		D8Tileset[5] = D8TileSheet.crop(width * 4, height * 0, width * 1, height * 1);
		D8Tileset[10] = D8TileSheet.crop(width * 4, height * 1, width * 1, height * 1);
		D8Tileset[6] = D8TileSheet.crop(width * 0, height * 1, width * 1, height * 1);
		D8Tileset[2] = D8TileSheet.crop(width * 1, height * 0, width * 1, height * 1);
		D8Tileset[12] = D8TileSheet.crop(width * 1, height * 2, width * 1, height * 1);
		D8Tileset[8] = D8TileSheet.crop(width * 2, height * 1, width * 1, height * 1);
		D8Tileset[9] = D8TileSheet.crop(width * 3, height * 1, width * 1, height * 1);
		D8Tileset[14] = D8TileSheet.crop(width * 0, height * 3, width * 1, height * 1);
		D8Tileset[15] = D8TileSheet.crop(width * 1, height * 3, width * 1, height * 1);
		D8Tileset[16] = D8TileSheet.crop(width * 2, height * 3, width * 1, height * 1);
		D8Tileset[17] = D8TileSheet.crop(width * 0, height * 5, width * 1, height * 1);
		D8Tileset[18] = D8TileSheet.crop(width * 1, height * 5, width * 1, height * 1);
		D8Tileset[19] = D8TileSheet.crop(width * 2, height * 5, width * 1, height * 1);
		D8Tileset[20] = D8TileSheet.crop(320, 480, width * 1, height * 1);
		D8Tileset[21] = D8TileSheet.crop(352, 480, width * 1, height * 1);
		D8Tileset[22] = D8TileSheet.crop(384, 480, width * 1, height * 1);
		D8Tileset[23] = D8TileSheet.crop(width * 4, height * 2, width * 1, height * 1);
	}
	
	public static void loadNPCs()
	{
		SpriteSheet NPC18Sheet = new SpriteSheet(ResourceLoader.loadTexture("NPC17.png"));
		SpriteSheet NPC16Sheet = new SpriteSheet(ResourceLoader.loadTexture("NPC16.png"));
		SpriteSheet NPC15Sheet = new SpriteSheet(ResourceLoader.loadTexture("NPC15.png"));
		SpriteSheet NPC14Sheet = new SpriteSheet(ResourceLoader.loadTexture("NPC14.png"));
		SpriteSheet NPC13Sheet = new SpriteSheet(ResourceLoader.loadTexture("NPC13.png"));
		SpriteSheet NPC12Sheet = new SpriteSheet(ResourceLoader.loadTexture("NPC12.png"));
		SpriteSheet NPC11Sheet = new SpriteSheet(ResourceLoader.loadTexture("NPC11.png"));
		SpriteSheet NPC10Sheet = new SpriteSheet(ResourceLoader.loadTexture("NPC10.png"));
		SpriteSheet NPC3Sheet = new SpriteSheet(ResourceLoader.loadTexture("NPC3.png"));
		SpriteSheet NPC4Sheet = new SpriteSheet(ResourceLoader.loadTexture("NPC4.png"));
		SpriteSheet NPC5Sheet = new SpriteSheet(ResourceLoader.loadTexture("NPC5.png"));
		SpriteSheet NPC6Sheet = new SpriteSheet(ResourceLoader.loadTexture("NPC6.png"));
		SpriteSheet NPC8Sheet = new SpriteSheet(ResourceLoader.loadTexture("NPC8.png"));
		SpriteSheet NPC9Sheet = new SpriteSheet(ResourceLoader.loadTexture("NPC9.png"));
		SpriteSheet NPC7Sheet = new SpriteSheet(ResourceLoader.loadTexture("NPC7.png"));
		SpriteSheet NPC2Sheet = new SpriteSheet(ResourceLoader.loadTexture("NPC2.png"));
		SpriteSheet NPC1Sheet = new SpriteSheet(ResourceLoader.loadTexture("NPC1.png"));
		SpriteSheet fineasSheet = new SpriteSheet(ResourceLoader.loadTexture("fineas.png"));
		SpriteSheet obinSheet = new SpriteSheet(ResourceLoader.loadTexture("obin.png"));
		SpriteSheet budaSheet = new SpriteSheet(ResourceLoader.loadTexture("skull.png"));
		SpriteSheet fairySheet = new SpriteSheet(ResourceLoader.loadTexture("fairy.png"));
		
		
		NPC18Stationary = new BufferedImage[4];
		NPC18Stationary[0] = NPC18Sheet.crop(0, 0, 36, 36);
		NPC18Stationary[1] = NPC18Sheet.crop(0, 36, 36, 36);
		NPC18Stationary[2] = NPC18Sheet.crop(0, 72, 36, 36);
		NPC18Stationary[3] = NPC18Sheet.crop(0, 108, 36, 36);
		
		NPC18Up = new BufferedImage[6];
		NPC18Up[0] = NPC18Sheet.crop(36, 0, 36, 36);
		NPC18Up[1] = NPC18Sheet.crop(72, 0, 36, 36);
		NPC18Up[2] = NPC18Sheet.crop(108, 0, 36, 36);
		NPC18Up[3] = NPC18Sheet.crop(144, 0, 36, 36);
		NPC18Up[4] = NPC18Sheet.crop(180, 0, 36, 36);
		NPC18Up[5] = NPC18Sheet.crop(216, 0, 36, 36);
		
		NPC18Rgt = new BufferedImage[6];
		NPC18Rgt[0] = NPC18Sheet.crop(36, 36, 36, 36);
		NPC18Rgt[1] = NPC18Sheet.crop(72, 36, 36, 36);
		NPC18Rgt[2] = NPC18Sheet.crop(108, 36, 36, 36);
		NPC18Rgt[3] = NPC18Sheet.crop(144, 36, 36, 36);
		NPC18Rgt[4] = NPC18Sheet.crop(180, 36, 36, 36);
		NPC18Rgt[5] = NPC18Sheet.crop(216, 36, 36, 36);
		
		NPC18Dwn = new BufferedImage[6];
		NPC18Dwn[0] = NPC18Sheet.crop(36, 72, 36, 36);
		NPC18Dwn[1] = NPC18Sheet.crop(72, 72, 36, 36);
		NPC18Dwn[2] = NPC18Sheet.crop(108, 72, 36, 36);
		NPC18Dwn[3] = NPC18Sheet.crop(144, 72, 36, 36);
		NPC18Dwn[4] = NPC18Sheet.crop(180, 72, 36, 36);
		NPC18Dwn[5] = NPC18Sheet.crop(216, 72, 36, 36);
		
		NPC18Lft = new BufferedImage[6];
		NPC18Lft[0] = NPC18Sheet.crop(36, 108, 36, 36);
		NPC18Lft[1] = NPC18Sheet.crop(72, 108, 36, 36);
		NPC18Lft[2] = NPC18Sheet.crop(108, 108, 36, 36);
		NPC18Lft[3] = NPC18Sheet.crop(144, 108, 36, 36);
		NPC18Lft[4] = NPC18Sheet.crop(180, 108, 36, 36);
		NPC18Lft[5] = NPC18Sheet.crop(216, 108, 36, 36);
		
		NPC8Stationary = new BufferedImage[4];
		NPC8Stationary[0] = NPC8Sheet.crop(0, 0, 36, 36);
		NPC8Stationary[1] = NPC8Sheet.crop(0, 36, 36, 36);
		NPC8Stationary[2] = NPC8Sheet.crop(0, 72, 36, 36);
		NPC8Stationary[3] = NPC8Sheet.crop(0, 108, 36, 36);
		
		NPC8Up = new BufferedImage[6];
		NPC8Up[0] = NPC8Sheet.crop(36, 0, 36, 36);
		NPC8Up[1] = NPC8Sheet.crop(72, 0, 36, 36);
		NPC8Up[2] = NPC8Sheet.crop(108, 0, 36, 36);
		NPC8Up[3] = NPC8Sheet.crop(144, 0, 36, 36);
		NPC8Up[4] = NPC8Sheet.crop(180, 0, 36, 36);
		NPC8Up[5] = NPC8Sheet.crop(216, 0, 36, 36);
		
		NPC8Rgt = new BufferedImage[6];
		NPC8Rgt[0] = NPC8Sheet.crop(36, 36, 36, 36);
		NPC8Rgt[1] = NPC8Sheet.crop(72, 36, 36, 36);
		NPC8Rgt[2] = NPC8Sheet.crop(108, 36, 36, 36);
		NPC8Rgt[3] = NPC8Sheet.crop(144, 36, 36, 36);
		NPC8Rgt[4] = NPC8Sheet.crop(180, 36, 36, 36);
		NPC8Rgt[5] = NPC8Sheet.crop(216, 36, 36, 36);
		
		NPC8Dwn = new BufferedImage[6];
		NPC8Dwn[0] = NPC8Sheet.crop(36, 72, 36, 36);
		NPC8Dwn[1] = NPC8Sheet.crop(72, 72, 36, 36);
		NPC8Dwn[2] = NPC8Sheet.crop(108, 72, 36, 36);
		NPC8Dwn[3] = NPC8Sheet.crop(144, 72, 36, 36);
		NPC8Dwn[4] = NPC8Sheet.crop(180, 72, 36, 36);
		NPC8Dwn[5] = NPC8Sheet.crop(216, 72, 36, 36);
		
		NPC8Lft = new BufferedImage[6];
		NPC8Lft[0] = NPC8Sheet.crop(36, 108, 36, 36);
		NPC8Lft[1] = NPC8Sheet.crop(72, 108, 36, 36);
		NPC8Lft[2] = NPC8Sheet.crop(108, 108, 36, 36);
		NPC8Lft[3] = NPC8Sheet.crop(144, 108, 36, 36);
		NPC8Lft[4] = NPC8Sheet.crop(180, 108, 36, 36);
		NPC8Lft[5] = NPC8Sheet.crop(216, 108, 36, 36);
		
		NPC16Stationary = new BufferedImage[4];
		NPC16Stationary[0] = NPC16Sheet.crop(0, 0, 36, 36);
		NPC16Stationary[1] = NPC16Sheet.crop(0, 36, 36, 36);
		NPC16Stationary[2] = NPC16Sheet.crop(0, 72, 36, 36);
		NPC16Stationary[3] = NPC16Sheet.crop(0, 108, 36, 36);
		
		NPC16Up = new BufferedImage[6];
		NPC16Up[0] = NPC16Sheet.crop(36, 0, 36, 36);
		NPC16Up[1] = NPC16Sheet.crop(72, 0, 36, 36);
		NPC16Up[2] = NPC16Sheet.crop(108, 0, 36, 36);
		NPC16Up[3] = NPC16Sheet.crop(144, 0, 36, 36);
		NPC16Up[4] = NPC16Sheet.crop(180, 0, 36, 36);
		NPC16Up[5] = NPC16Sheet.crop(216, 0, 36, 36);
		
		NPC16Rgt = new BufferedImage[6];
		NPC16Rgt[0] = NPC16Sheet.crop(36, 36, 36, 36);
		NPC16Rgt[1] = NPC16Sheet.crop(72, 36, 36, 36);
		NPC16Rgt[2] = NPC16Sheet.crop(108, 36, 36, 36);
		NPC16Rgt[3] = NPC16Sheet.crop(144, 36, 36, 36);
		NPC16Rgt[4] = NPC16Sheet.crop(180, 36, 36, 36);
		NPC16Rgt[5] = NPC16Sheet.crop(216, 36, 36, 36);
		
		NPC16Dwn = new BufferedImage[6];
		NPC16Dwn[0] = NPC16Sheet.crop(36, 72, 36, 36);
		NPC16Dwn[1] = NPC16Sheet.crop(72, 72, 36, 36);
		NPC16Dwn[2] = NPC16Sheet.crop(108, 72, 36, 36);
		NPC16Dwn[3] = NPC16Sheet.crop(144, 72, 36, 36);
		NPC16Dwn[4] = NPC16Sheet.crop(180, 72, 36, 36);
		NPC16Dwn[5] = NPC16Sheet.crop(216, 72, 36, 36);
		
		NPC16Lft = new BufferedImage[6];
		NPC16Lft[0] = NPC16Sheet.crop(36, 108, 36, 36);
		NPC16Lft[1] = NPC16Sheet.crop(72, 108, 36, 36);
		NPC16Lft[2] = NPC16Sheet.crop(108, 108, 36, 36);
		NPC16Lft[3] = NPC16Sheet.crop(144, 108, 36, 36);
		NPC16Lft[4] = NPC16Sheet.crop(180, 108, 36, 36);
		NPC16Lft[5] = NPC16Sheet.crop(216, 108, 36, 36);
		
		NPC15Stationary = new BufferedImage[4];
		NPC15Stationary[0] = NPC15Sheet.crop(0, 0, 36, 36);
		NPC15Stationary[1] = NPC15Sheet.crop(0, 36, 36, 36);
		NPC15Stationary[2] = NPC15Sheet.crop(0, 72, 36, 36);
		NPC15Stationary[3] = NPC15Sheet.crop(0, 108, 36, 36);
		
		NPC15Up = new BufferedImage[6];
		NPC15Up[0] = NPC15Sheet.crop(36, 0, 36, 36);
		NPC15Up[1] = NPC15Sheet.crop(72, 0, 36, 36);
		NPC15Up[2] = NPC15Sheet.crop(108, 0, 36, 36);
		NPC15Up[3] = NPC15Sheet.crop(144, 0, 36, 36);
		NPC15Up[4] = NPC15Sheet.crop(180, 0, 36, 36);
		NPC15Up[5] = NPC15Sheet.crop(216, 0, 36, 36);
		
		NPC15Rgt = new BufferedImage[6];
		NPC15Rgt[0] = NPC15Sheet.crop(36, 36, 36, 36);
		NPC15Rgt[1] = NPC15Sheet.crop(72, 36, 36, 36);
		NPC15Rgt[2] = NPC15Sheet.crop(108, 36, 36, 36);
		NPC15Rgt[3] = NPC15Sheet.crop(144, 36, 36, 36);
		NPC15Rgt[4] = NPC15Sheet.crop(180, 36, 36, 36);
		NPC15Rgt[5] = NPC15Sheet.crop(216, 36, 36, 36);
		
		NPC15Dwn = new BufferedImage[6];
		NPC15Dwn[0] = NPC15Sheet.crop(36, 72, 36, 36);
		NPC15Dwn[1] = NPC15Sheet.crop(72, 72, 36, 36);
		NPC15Dwn[2] = NPC15Sheet.crop(108, 72, 36, 36);
		NPC15Dwn[3] = NPC15Sheet.crop(144, 72, 36, 36);
		NPC15Dwn[4] = NPC15Sheet.crop(180, 72, 36, 36);
		NPC15Dwn[5] = NPC15Sheet.crop(216, 72, 36, 36);
		
		NPC15Lft = new BufferedImage[6];
		NPC15Lft[0] = NPC15Sheet.crop(36, 108, 36, 36);
		NPC15Lft[1] = NPC15Sheet.crop(72, 108, 36, 36);
		NPC15Lft[2] = NPC15Sheet.crop(108, 108, 36, 36);
		NPC15Lft[3] = NPC15Sheet.crop(144, 108, 36, 36);
		NPC15Lft[4] = NPC15Sheet.crop(180, 108, 36, 36);
		NPC15Lft[5] = NPC15Sheet.crop(216, 108, 36, 36);
		
		NPC14Stationary = new BufferedImage[4];
		NPC14Stationary[0] = NPC14Sheet.crop(0, 0, 36, 36);
		NPC14Stationary[1] = NPC14Sheet.crop(0, 36, 36, 36);
		NPC14Stationary[2] = NPC14Sheet.crop(0, 72, 36, 36);
		NPC14Stationary[3] = NPC14Sheet.crop(0, 108, 36, 36);
		
		NPC14Up = new BufferedImage[6];
		NPC14Up[0] = NPC14Sheet.crop(36, 0, 36, 36);
		NPC14Up[1] = NPC14Sheet.crop(72, 0, 36, 36);
		NPC14Up[2] = NPC14Sheet.crop(108, 0, 36, 36);
		NPC14Up[3] = NPC14Sheet.crop(144, 0, 36, 36);
		NPC14Up[4] = NPC14Sheet.crop(180, 0, 36, 36);
		NPC14Up[5] = NPC14Sheet.crop(216, 0, 36, 36);
		
		NPC14Rgt = new BufferedImage[6];
		NPC14Rgt[0] = NPC14Sheet.crop(36, 36, 36, 36);
		NPC14Rgt[1] = NPC14Sheet.crop(72, 36, 36, 36);
		NPC14Rgt[2] = NPC14Sheet.crop(108, 36, 36, 36);
		NPC14Rgt[3] = NPC14Sheet.crop(144, 36, 36, 36);
		NPC14Rgt[4] = NPC14Sheet.crop(180, 36, 36, 36);
		NPC14Rgt[5] = NPC14Sheet.crop(216, 36, 36, 36);
		
		NPC14Dwn = new BufferedImage[6];
		NPC14Dwn[0] = NPC14Sheet.crop(36, 72, 36, 36);
		NPC14Dwn[1] = NPC14Sheet.crop(72, 72, 36, 36);
		NPC14Dwn[2] = NPC14Sheet.crop(108, 72, 36, 36);
		NPC14Dwn[3] = NPC14Sheet.crop(144, 72, 36, 36);
		NPC14Dwn[4] = NPC14Sheet.crop(180, 72, 36, 36);
		NPC14Dwn[5] = NPC14Sheet.crop(216, 72, 36, 36);
		
		NPC14Lft = new BufferedImage[6];
		NPC14Lft[0] = NPC14Sheet.crop(36, 108, 36, 36);
		NPC14Lft[1] = NPC14Sheet.crop(72, 108, 36, 36);
		NPC14Lft[2] = NPC14Sheet.crop(108, 108, 36, 36);
		NPC14Lft[3] = NPC14Sheet.crop(144, 108, 36, 36);
		NPC14Lft[4] = NPC14Sheet.crop(180, 108, 36, 36);
		NPC14Lft[5] = NPC14Sheet.crop(216, 108, 36, 36);
		
		NPC13Stationary = new BufferedImage[4];
		NPC13Stationary[0] = NPC13Sheet.crop(0, 0, 36, 36);
		NPC13Stationary[1] = NPC13Sheet.crop(0, 36, 36, 36);
		NPC13Stationary[2] = NPC13Sheet.crop(0, 72, 36, 36);
		NPC13Stationary[3] = NPC13Sheet.crop(0, 108, 36, 36);
		
		NPC13Up = new BufferedImage[6];
		NPC13Up[0] = NPC13Sheet.crop(36, 0, 36, 36);
		NPC13Up[1] = NPC13Sheet.crop(72, 0, 36, 36);
		NPC13Up[2] = NPC13Sheet.crop(108, 0, 36, 36);
		NPC13Up[3] = NPC13Sheet.crop(144, 0, 36, 36);
		NPC13Up[4] = NPC13Sheet.crop(180, 0, 36, 36);
		NPC13Up[5] = NPC13Sheet.crop(216, 0, 36, 36);
		
		NPC13Rgt = new BufferedImage[6];
		NPC13Rgt[0] = NPC13Sheet.crop(36, 36, 36, 36);
		NPC13Rgt[1] = NPC13Sheet.crop(72, 36, 36, 36);
		NPC13Rgt[2] = NPC13Sheet.crop(108, 36, 36, 36);
		NPC13Rgt[3] = NPC13Sheet.crop(144, 36, 36, 36);
		NPC13Rgt[4] = NPC13Sheet.crop(180, 36, 36, 36);
		NPC13Rgt[5] = NPC13Sheet.crop(216, 36, 36, 36);
		
		NPC13Dwn = new BufferedImage[6];
		NPC13Dwn[0] = NPC13Sheet.crop(36, 72, 36, 36);
		NPC13Dwn[1] = NPC13Sheet.crop(72, 72, 36, 36);
		NPC13Dwn[2] = NPC13Sheet.crop(108, 72, 36, 36);
		NPC13Dwn[3] = NPC13Sheet.crop(144, 72, 36, 36);
		NPC13Dwn[4] = NPC13Sheet.crop(180, 72, 36, 36);
		NPC13Dwn[5] = NPC13Sheet.crop(216, 72, 36, 36);
		
		NPC13Lft = new BufferedImage[6];
		NPC13Lft[0] = NPC13Sheet.crop(36, 108, 36, 36);
		NPC13Lft[1] = NPC13Sheet.crop(72, 108, 36, 36);
		NPC13Lft[2] = NPC13Sheet.crop(108, 108, 36, 36);
		NPC13Lft[3] = NPC13Sheet.crop(144, 108, 36, 36);
		NPC13Lft[4] = NPC13Sheet.crop(180, 108, 36, 36);
		NPC13Lft[5] = NPC13Sheet.crop(216, 108, 36, 36);
		
		NPC17Stationary = new BufferedImage[4];
		NPC17Stationary[0] = NPC12Sheet.crop(0, 0, 36, 36);
		NPC17Stationary[1] = NPC12Sheet.crop(0, 36, 36, 36);
		NPC17Stationary[2] = NPC12Sheet.crop(0, 72, 36, 36);
		NPC17Stationary[3] = NPC12Sheet.crop(0, 108, 36, 36);
		
		NPC17Up = new BufferedImage[6];
		NPC17Up[0] = NPC12Sheet.crop(36, 0, 36, 36);
		NPC17Up[1] = NPC12Sheet.crop(72, 0, 36, 36);
		NPC17Up[2] = NPC12Sheet.crop(108, 0, 36, 36);
		NPC17Up[3] = NPC12Sheet.crop(144, 0, 36, 36);
		NPC17Up[4] = NPC12Sheet.crop(180, 0, 36, 36);
		NPC17Up[5] = NPC12Sheet.crop(216, 0, 36, 36);
		
		NPC17Rgt = new BufferedImage[6];
		NPC17Rgt[0] = NPC12Sheet.crop(36, 36, 36, 36);
		NPC17Rgt[1] = NPC12Sheet.crop(72, 36, 36, 36);
		NPC17Rgt[2] = NPC12Sheet.crop(108, 36, 36, 36);
		NPC17Rgt[3] = NPC12Sheet.crop(144, 36, 36, 36);
		NPC17Rgt[4] = NPC12Sheet.crop(180, 36, 36, 36);
		NPC17Rgt[5] = NPC12Sheet.crop(216, 36, 36, 36);
		
		NPC17Dwn = new BufferedImage[6];
		NPC17Dwn[0] = NPC12Sheet.crop(36, 72, 36, 36);
		NPC17Dwn[1] = NPC12Sheet.crop(72, 72, 36, 36);
		NPC17Dwn[2] = NPC12Sheet.crop(108, 72, 36, 36);
		NPC17Dwn[3] = NPC12Sheet.crop(144, 72, 36, 36);
		NPC17Dwn[4] = NPC12Sheet.crop(180, 72, 36, 36);
		NPC17Dwn[5] = NPC12Sheet.crop(216, 72, 36, 36);
		
		NPC17Lft = new BufferedImage[6];
		NPC17Lft[0] = NPC12Sheet.crop(36, 108, 36, 36);
		NPC17Lft[1] = NPC12Sheet.crop(72, 108, 36, 36);
		NPC17Lft[2] = NPC12Sheet.crop(108, 108, 36, 36);
		NPC17Lft[3] = NPC12Sheet.crop(144, 108, 36, 36);
		NPC17Lft[4] = NPC12Sheet.crop(180, 108, 36, 36);
		NPC17Lft[5] = NPC12Sheet.crop(216, 108, 36, 36);
		
		fairyDwnLft = new BufferedImage[4];
		fairyDwnLft[0] = fairySheet.crop(0, 0, 26, 30);
		fairyDwnLft[1] = fairySheet.crop(26, 0, 26, 30);
		fairyDwnLft[2] = fairySheet.crop(52, 0, 26, 30);
		fairyDwnLft[3] = fairySheet.crop(78, 0, 26, 30);
		
		fairyDwnRgt = new BufferedImage[4];
		fairyDwnRgt[0] = fairySheet.crop(182, 0, 26, 30);
		fairyDwnRgt[1] = fairySheet.crop(156, 0, 26, 30);
		fairyDwnRgt[2] = fairySheet.crop(130, 0, 26, 30);
		fairyDwnRgt[3] = fairySheet.crop(104, 0, 26, 30);
		
		fairyUpLft = new BufferedImage[4];
		fairyUpLft[0] = fairySheet.crop(0, 30, 26, 30);
		fairyUpLft[1] = fairySheet.crop(26, 30, 26, 30);
		fairyUpLft[2] = fairySheet.crop(52, 30, 26, 30);
		fairyUpLft[3] = fairySheet.crop(78, 30, 26, 30);
		
		fairyUpRgt = new BufferedImage[4];
		fairyUpRgt[0] = fairySheet.crop(182, 30, 26, 30);
		fairyUpRgt[1] = fairySheet.crop(156, 30, 26, 30);
		fairyUpRgt[2] = fairySheet.crop(130, 30, 26, 30);
		fairyUpRgt[3] = fairySheet.crop(104, 30, 26, 30);
		
		NPC4Stationary = new BufferedImage[4];
		NPC4Stationary[0] = NPC4Sheet.crop(0, 0, 36, 36);
		NPC4Stationary[1] = NPC4Sheet.crop(0, 36, 36, 36);
		NPC4Stationary[2] = NPC4Sheet.crop(0, 72, 36, 36);
		NPC4Stationary[3] = NPC4Sheet.crop(0, 108, 36, 36);
		
		NPC4Up = new BufferedImage[6];
		NPC4Up[0] = NPC4Sheet.crop(36, 0, 36, 36);
		NPC4Up[1] = NPC4Sheet.crop(72, 0, 36, 36);
		NPC4Up[2] = NPC4Sheet.crop(108, 0, 36, 36);
		NPC4Up[3] = NPC4Sheet.crop(144, 0, 36, 36);
		NPC4Up[4] = NPC4Sheet.crop(180, 0, 36, 36);
		NPC4Up[5] = NPC4Sheet.crop(216, 0, 36, 36);
		
		NPC4Rgt = new BufferedImage[6];
		NPC4Rgt[0] = NPC4Sheet.crop(36, 36, 36, 36);
		NPC4Rgt[1] = NPC4Sheet.crop(72, 36, 36, 36);
		NPC4Rgt[2] = NPC4Sheet.crop(108, 36, 36, 36);
		NPC4Rgt[3] = NPC4Sheet.crop(144, 36, 36, 36);
		NPC4Rgt[4] = NPC4Sheet.crop(180, 36, 36, 36);
		NPC4Rgt[5] = NPC4Sheet.crop(216, 36, 36, 36);
		
		NPC4Dwn = new BufferedImage[6];
		NPC4Dwn[0] = NPC4Sheet.crop(36, 72, 36, 36);
		NPC4Dwn[1] = NPC4Sheet.crop(72, 72, 36, 36);
		NPC4Dwn[2] = NPC4Sheet.crop(108, 72, 36, 36);
		NPC4Dwn[3] = NPC4Sheet.crop(144, 72, 36, 36);
		NPC4Dwn[4] = NPC4Sheet.crop(180, 72, 36, 36);
		NPC4Dwn[5] = NPC4Sheet.crop(216, 72, 36, 36);
		
		NPC4Lft = new BufferedImage[6];
		NPC4Lft[0] = NPC4Sheet.crop(36, 108, 36, 36);
		NPC4Lft[1] = NPC4Sheet.crop(72, 108, 36, 36);
		NPC4Lft[2] = NPC4Sheet.crop(108, 108, 36, 36);
		NPC4Lft[3] = NPC4Sheet.crop(144, 108, 36, 36);
		NPC4Lft[4] = NPC4Sheet.crop(180, 108, 36, 36);
		NPC4Lft[5] = NPC4Sheet.crop(216, 108, 36, 36);
		
		budaDwnLft = new BufferedImage[3];
		budaDwnLft[0] = budaSheet.crop(0, 0, 40, 40);
		budaDwnLft[1] = budaSheet.crop(40, 0, 40, 40);
		budaDwnLft[2] = budaSheet.crop(80, 0, 40, 40);
		
		budaDwnRgt = new BufferedImage[3];
		budaDwnRgt[0] = budaSheet.crop(120, 0, 40, 40);
		budaDwnRgt[1] = budaSheet.crop(160, 0, 40, 40);
		budaDwnRgt[2] = budaSheet.crop(200, 0, 40, 40);
		
		budaUpLft = new BufferedImage[3];
		budaUpLft[0] = budaSheet.crop(0, 40, 40, 40);
		budaUpLft[1] = budaSheet.crop(40, 40, 40, 40);
		budaUpLft[2] = budaSheet.crop(80, 40, 40, 40);
		
		budaUpRgt = new BufferedImage[3];
		budaUpRgt[0] = budaSheet.crop(120, 40, 40, 40);
		budaUpRgt[1] = budaSheet.crop(160, 40, 40, 40);
		budaUpRgt[2] = budaSheet.crop(200, 40, 40, 40);
		
		
		NPC11Stationary = new BufferedImage[4];
		NPC11Stationary[0] = NPC11Sheet.crop(0, 0, 36, 36);
		NPC11Stationary[1] = NPC11Sheet.crop(0, 36, 36, 36);
		NPC11Stationary[2] = NPC11Sheet.crop(0, 72, 36, 36);
		NPC11Stationary[3] = NPC11Sheet.crop(0, 108, 36, 36);
		
		NPC11Up = new BufferedImage[6];
		NPC11Up[0] = NPC11Sheet.crop(36, 0, 36, 36);
		NPC11Up[1] = NPC11Sheet.crop(72, 0, 36, 36);
		NPC11Up[2] = NPC11Sheet.crop(108, 0, 36, 36);
		NPC11Up[3] = NPC11Sheet.crop(144, 0, 36, 36);
		NPC11Up[4] = NPC11Sheet.crop(180, 0, 36, 36);
		NPC11Up[5] = NPC11Sheet.crop(216, 0, 36, 36);
		
		NPC11Rgt = new BufferedImage[6];
		NPC11Rgt[0] = NPC11Sheet.crop(36, 36, 36, 36);
		NPC11Rgt[1] = NPC11Sheet.crop(72, 36, 36, 36);
		NPC11Rgt[2] = NPC11Sheet.crop(108, 36, 36, 36);
		NPC11Rgt[3] = NPC11Sheet.crop(144, 36, 36, 36);
		NPC11Rgt[4] = NPC11Sheet.crop(180, 36, 36, 36);
		NPC11Rgt[5] = NPC11Sheet.crop(216, 36, 36, 36);
		
		NPC11Dwn = new BufferedImage[6];
		NPC11Dwn[0] = NPC11Sheet.crop(36, 72, 36, 36);
		NPC11Dwn[1] = NPC11Sheet.crop(72, 72, 36, 36);
		NPC11Dwn[2] = NPC11Sheet.crop(108, 72, 36, 36);
		NPC11Dwn[3] = NPC11Sheet.crop(144, 72, 36, 36);
		NPC11Dwn[4] = NPC11Sheet.crop(180, 72, 36, 36);
		NPC11Dwn[5] = NPC11Sheet.crop(216, 72, 36, 36);
		
		NPC11Lft = new BufferedImage[6];
		NPC11Lft[0] = NPC11Sheet.crop(36, 108, 36, 36);
		NPC11Lft[1] = NPC11Sheet.crop(72, 108, 36, 36);
		NPC11Lft[2] = NPC11Sheet.crop(108, 108, 36, 36);
		NPC11Lft[3] = NPC11Sheet.crop(144, 108, 36, 36);
		NPC11Lft[4] = NPC11Sheet.crop(180, 108, 36, 36);
		NPC11Lft[5] = NPC11Sheet.crop(216, 108, 36, 36);
		
		NPC11Attack = new BufferedImage[6];
		NPC11Attack[0] = NPC11Sheet.crop(36, 144, 36, 36);
		NPC11Attack[1] = NPC11Sheet.crop(72, 144, 36, 36);
		NPC11Attack[2] = NPC11Sheet.crop(108, 144, 36, 36);
		NPC11Attack[3] = NPC11Sheet.crop(144, 144, 36, 36);
		NPC11Attack[4] = NPC11Sheet.crop(180, 144, 36, 36);
		NPC11Attack[5] = NPC11Sheet.crop(216, 144, 36, 36);
		
		NPC2Stationary = new BufferedImage[4];
		NPC2Stationary[0] = NPC2Sheet.crop(0, 0, 36, 36);
		NPC2Stationary[1] = NPC2Sheet.crop(0, 36, 36, 36);
		NPC2Stationary[2] = NPC2Sheet.crop(0, 72, 36, 36);
		NPC2Stationary[3] = NPC2Sheet.crop(0, 108, 36, 36);
		
		NPC2Up = new BufferedImage[6];
		NPC2Up[0] = NPC2Sheet.crop(36, 0, 36, 36);
		NPC2Up[1] = NPC2Sheet.crop(72, 0, 36, 36);
		NPC2Up[2] = NPC2Sheet.crop(108, 0, 36, 36);
		NPC2Up[3] = NPC2Sheet.crop(144, 0, 36, 36);
		NPC2Up[4] = NPC2Sheet.crop(180, 0, 36, 36);
		NPC2Up[5] = NPC2Sheet.crop(216, 0, 36, 36);
		
		NPC2Rgt = new BufferedImage[6];
		NPC2Rgt[0] = NPC2Sheet.crop(36, 36, 36, 36);
		NPC2Rgt[1] = NPC2Sheet.crop(72, 36, 36, 36);
		NPC2Rgt[2] = NPC2Sheet.crop(108, 36, 36, 36);
		NPC2Rgt[3] = NPC2Sheet.crop(144, 36, 36, 36);
		NPC2Rgt[4] = NPC2Sheet.crop(180, 36, 36, 36);
		NPC2Rgt[5] = NPC2Sheet.crop(216, 36, 36, 36);
		
		NPC2Dwn = new BufferedImage[6];
		NPC2Dwn[0] = NPC2Sheet.crop(36, 72, 36, 36);
		NPC2Dwn[1] = NPC2Sheet.crop(72, 72, 36, 36);
		NPC2Dwn[2] = NPC2Sheet.crop(108, 72, 36, 36);
		NPC2Dwn[3] = NPC2Sheet.crop(144, 72, 36, 36);
		NPC2Dwn[4] = NPC2Sheet.crop(180, 72, 36, 36);
		NPC2Dwn[5] = NPC2Sheet.crop(216, 72, 36, 36);
		
		NPC2Lft = new BufferedImage[6];
		NPC2Lft[0] = NPC2Sheet.crop(36, 108, 36, 36);
		NPC2Lft[1] = NPC2Sheet.crop(72, 108, 36, 36);
		NPC2Lft[2] = NPC2Sheet.crop(108, 108, 36, 36);
		NPC2Lft[3] = NPC2Sheet.crop(144, 108, 36, 36);
		NPC2Lft[4] = NPC2Sheet.crop(180, 108, 36, 36);
		NPC2Lft[5] = NPC2Sheet.crop(216, 108, 36, 36);
		
		obinStationary = new BufferedImage[4];
		obinStationary[0] = obinSheet.crop(0, 96, 54, 32);
		obinStationary[1] = obinSheet.crop(0, 64, 54, 32);
		obinStationary[2] = obinSheet.crop(0, 0, 54, 32);
		obinStationary[3] = obinSheet.crop(0, 32, 54, 32);
		
		obinUp = new BufferedImage[3];
		obinUp[0] = obinSheet.crop(54, 96, 54, 32);
		obinUp[1] = obinSheet.crop(108, 96, 54, 32);
		obinUp[2] = obinSheet.crop(162, 96, 54, 32);
		
		obinRgt = new BufferedImage[3];
		obinRgt[0] = obinSheet.crop(54, 64, 54, 32);
		obinRgt[1] = obinSheet.crop(108, 64, 54, 32);
		obinRgt[2] = obinSheet.crop(162, 64, 54, 32);
		
		obinDwn = new BufferedImage[3];
		obinDwn[0] = obinSheet.crop(54, 0, 54, 32);
		obinDwn[1] = obinSheet.crop(108, 0, 54, 32);
		obinDwn[2] = obinSheet.crop(162, 0, 54, 32);
		
		obinLft = new BufferedImage[3];
		obinLft[0] = obinSheet.crop(54, 32, 54, 32);
		obinLft[1] = obinSheet.crop(108, 32, 54, 32);
		obinLft[2] = obinSheet.crop(162, 32, 54, 32);
		
		fineasStationary = new BufferedImage[4];
		fineasStationary[0] = fineasSheet.crop(0, 0, 36, 36);
		fineasStationary[1] = fineasSheet.crop(0, 36, 36, 36);
		fineasStationary[2] = fineasSheet.crop(0, 72, 36, 36);
		fineasStationary[3] = fineasSheet.crop(0, 108, 36, 36);
		
		fineasUp = new BufferedImage[6];
		fineasUp[0] = fineasSheet.crop(36, 0, 36, 36);
		fineasUp[1] = fineasSheet.crop(72, 0, 36, 36);
		fineasUp[2] = fineasSheet.crop(108, 0, 36, 36);
		fineasUp[3] = fineasSheet.crop(144, 0, 36, 36);
		fineasUp[4] = fineasSheet.crop(180, 0, 36, 36);
		fineasUp[5] = fineasSheet.crop(216, 0, 36, 36);
		
		fineasRgt = new BufferedImage[6];
		fineasRgt[0] = fineasSheet.crop(36, 36, 36, 36);
		fineasRgt[1] = fineasSheet.crop(72, 36, 36, 36);
		fineasRgt[2] = fineasSheet.crop(108, 36, 36, 36);
		fineasRgt[3] = fineasSheet.crop(144, 36, 36, 36);
		fineasRgt[4] = fineasSheet.crop(180, 36, 36, 36);
		fineasRgt[5] = fineasSheet.crop(216, 36, 36, 36);
		
		fineasDwn = new BufferedImage[6];
		fineasDwn[0] = fineasSheet.crop(36, 72, 36, 36);
		fineasDwn[1] = fineasSheet.crop(72, 72, 36, 36);
		fineasDwn[2] = fineasSheet.crop(108, 72, 36, 36);
		fineasDwn[3] = fineasSheet.crop(144, 72, 36, 36);
		fineasDwn[4] = fineasSheet.crop(180, 72, 36, 36);
		fineasDwn[5] = fineasSheet.crop(216, 72, 36, 36);
		
		fineasLft = new BufferedImage[6];
		fineasLft[0] = fineasSheet.crop(36, 108, 36, 36);
		fineasLft[1] = fineasSheet.crop(72, 108, 36, 36);
		fineasLft[2] = fineasSheet.crop(108, 108, 36, 36);
		fineasLft[3] = fineasSheet.crop(144, 108, 36, 36);
		fineasLft[4] = fineasSheet.crop(180, 108, 36, 36);
		fineasLft[5] = fineasSheet.crop(216, 108, 36, 36);
		
		NPC1Stationary = new BufferedImage[4];
		NPC1Stationary[0] = NPC1Sheet.crop(0, 0, 36, 36);
		NPC1Stationary[1] = NPC1Sheet.crop(0, 36, 36, 36);
		NPC1Stationary[2] = NPC1Sheet.crop(0, 72, 36, 36);
		NPC1Stationary[3] = NPC1Sheet.crop(0, 108, 36, 36);
		
		NPC1Up = new BufferedImage[6];
		NPC1Up[0] = NPC1Sheet.crop(36, 0, 36, 36);
		NPC1Up[1] = NPC1Sheet.crop(72, 0, 36, 36);
		NPC1Up[2] = NPC1Sheet.crop(108, 0, 36, 36);
		NPC1Up[3] = NPC1Sheet.crop(144, 0, 36, 36);
		NPC1Up[4] = NPC1Sheet.crop(180, 0, 36, 36);
		NPC1Up[5] = NPC1Sheet.crop(216, 0, 36, 36);
		
		NPC1Rgt = new BufferedImage[6];
		NPC1Rgt[0] = NPC1Sheet.crop(36, 36, 36, 36);
		NPC1Rgt[1] = NPC1Sheet.crop(72, 36, 36, 36);
		NPC1Rgt[2] = NPC1Sheet.crop(108, 36, 36, 36);
		NPC1Rgt[3] = NPC1Sheet.crop(144, 36, 36, 36);
		NPC1Rgt[4] = NPC1Sheet.crop(180, 36, 36, 36);
		NPC1Rgt[5] = NPC1Sheet.crop(216, 36, 36, 36);
		
		NPC1Dwn = new BufferedImage[6];
		NPC1Dwn[0] = NPC1Sheet.crop(36, 72, 36, 36);
		NPC1Dwn[1] = NPC1Sheet.crop(72, 72, 36, 36);
		NPC1Dwn[2] = NPC1Sheet.crop(108, 72, 36, 36);
		NPC1Dwn[3] = NPC1Sheet.crop(144, 72, 36, 36);
		NPC1Dwn[4] = NPC1Sheet.crop(180, 72, 36, 36);
		NPC1Dwn[5] = NPC1Sheet.crop(216, 72, 36, 36);
		
		NPC1Lft = new BufferedImage[6];
		NPC1Lft[0] = NPC1Sheet.crop(36, 108, 36, 36);
		NPC1Lft[1] = NPC1Sheet.crop(72, 108, 36, 36);
		NPC1Lft[2] = NPC1Sheet.crop(108, 108, 36, 36);
		NPC1Lft[3] = NPC1Sheet.crop(144, 108, 36, 36);
		NPC1Lft[4] = NPC1Sheet.crop(180, 108, 36, 36);
		NPC1Lft[5] = NPC1Sheet.crop(216, 108, 36, 36);
		
		NPC10Stationary = new BufferedImage[4];
		NPC10Stationary[0] = NPC10Sheet.crop(108, 0, 36, 36);
		NPC10Stationary[1] = NPC10Sheet.crop(72, 0, 36, 36);
		NPC10Stationary[2] = NPC10Sheet.crop(0, 0, 36, 36);
		NPC10Stationary[3] = NPC10Sheet.crop(36, 0, 36, 36);
		
		NPC10Up = new BufferedImage[4];
		NPC10Up[0] = NPC10Sheet.crop(108, 0, 36, 36);
		NPC10Up[1] = NPC10Sheet.crop(108, 36, 36, 36);
		NPC10Up[2] = NPC10Sheet.crop(108, 0, 36, 36);
		NPC10Up[3] = NPC10Sheet.crop(108, 72, 36, 36);
		
		NPC10Rgt = new BufferedImage[4];
		NPC10Rgt[0] = NPC10Sheet.crop(72, 0, 36, 36);
		NPC10Rgt[1] = NPC10Sheet.crop(72, 36, 36, 36);
		NPC10Rgt[2] = NPC10Sheet.crop(72, 0, 36, 36);
		NPC10Rgt[3] = NPC10Sheet.crop(72, 72, 36, 36);
		
		NPC10Lft = new BufferedImage[4];
		NPC10Lft[0] = NPC10Sheet.crop(36, 0, 36, 36);
		NPC10Lft[1] = NPC10Sheet.crop(36, 36, 36, 36);
		NPC10Lft[2] = NPC10Sheet.crop(36, 0, 36, 36);
		NPC10Lft[3] = NPC10Sheet.crop(36, 72, 36, 36);
		
		NPC10Dwn = new BufferedImage[4];
		NPC10Dwn[0] = NPC10Sheet.crop(0, 0, 36, 36);
		NPC10Dwn[1] = NPC10Sheet.crop(0, 36, 36, 36);
		NPC10Dwn[2] = NPC10Sheet.crop(0, 0, 36, 36);
		NPC10Dwn[3] = NPC10Sheet.crop(0, 72, 36, 36);
		
		NPC12Stationary = new BufferedImage[4];
		NPC12Stationary[0] = NPC10Sheet.crop(252, 0, 36, 36);
		NPC12Stationary[1] = NPC10Sheet.crop(216, 0, 36, 36);
		NPC12Stationary[2] = NPC10Sheet.crop(144, 0, 36, 36);
		NPC12Stationary[3] = NPC10Sheet.crop(180, 0, 36, 36);
		
		NPC12Up = new BufferedImage[4];
		NPC12Up[0] = NPC10Sheet.crop(252, 0, 36, 36);
		NPC12Up[1] = NPC10Sheet.crop(252, 36, 36, 36);
		NPC12Up[2] = NPC10Sheet.crop(252, 0, 36, 36);
		NPC12Up[3] = NPC10Sheet.crop(252, 72, 36, 36);
		
		NPC12Rgt = new BufferedImage[4];
		NPC12Rgt[0] = NPC10Sheet.crop(216, 0, 36, 36);
		NPC12Rgt[1] = NPC10Sheet.crop(216, 36, 36, 36);
		NPC12Rgt[2] = NPC10Sheet.crop(216, 0, 36, 36);
		NPC12Rgt[3] = NPC10Sheet.crop(216, 72, 36, 36);
		
		NPC12Lft = new BufferedImage[4];
		NPC12Lft[0] = NPC10Sheet.crop(180, 0, 36, 36);
		NPC12Lft[1] = NPC10Sheet.crop(180, 36, 36, 36);
		NPC12Lft[2] = NPC10Sheet.crop(180, 0, 36, 36);
		NPC12Lft[3] = NPC10Sheet.crop(180, 72, 36, 36);
		
		NPC12Dwn = new BufferedImage[4];
		NPC12Dwn[0] = NPC10Sheet.crop(144, 0, 36, 36);
		NPC12Dwn[1] = NPC10Sheet.crop(144, 36, 36, 36);
		NPC12Dwn[2] = NPC10Sheet.crop(144, 0, 36, 36);
		NPC12Dwn[3] = NPC10Sheet.crop(144, 72, 36, 36);
		
		NPC9Stationary = new BufferedImage[4];
		NPC9Stationary[0] = NPC9Sheet.crop(0, 0, 36, 36);
		NPC9Stationary[1] = NPC9Sheet.crop(0, 36, 36, 36);
		NPC9Stationary[2] = NPC9Sheet.crop(0, 72, 36, 36);
		NPC9Stationary[3] = NPC9Sheet.crop(0, 108, 36, 36);
		
		NPC9Up = new BufferedImage[6];
		NPC9Up[0] = NPC9Sheet.crop(36, 0, 36, 36);
		NPC9Up[1] = NPC9Sheet.crop(72, 0, 36, 36);
		NPC9Up[2] = NPC9Sheet.crop(108, 0, 36, 36);
		NPC9Up[3] = NPC9Sheet.crop(144, 0, 36, 36);
		NPC9Up[4] = NPC9Sheet.crop(180, 0, 36, 36);
		NPC9Up[5] = NPC9Sheet.crop(216, 0, 36, 36);
		
		NPC9Rgt = new BufferedImage[6];
		NPC9Rgt[0] = NPC9Sheet.crop(36, 36, 36, 36);
		NPC9Rgt[1] = NPC9Sheet.crop(72, 36, 36, 36);
		NPC9Rgt[2] = NPC9Sheet.crop(108, 36, 36, 36);
		NPC9Rgt[3] = NPC9Sheet.crop(144, 36, 36, 36);
		NPC9Rgt[4] = NPC9Sheet.crop(180, 36, 36, 36);
		NPC9Rgt[5] = NPC9Sheet.crop(216, 36, 36, 36);
		
		NPC9Dwn = new BufferedImage[6];
		NPC9Dwn[0] = NPC9Sheet.crop(36, 72, 36, 36);
		NPC9Dwn[1] = NPC9Sheet.crop(72, 72, 36, 36);
		NPC9Dwn[2] = NPC9Sheet.crop(108, 72, 36, 36);
		NPC9Dwn[3] = NPC9Sheet.crop(144, 72, 36, 36);
		NPC9Dwn[4] = NPC9Sheet.crop(180, 72, 36, 36);
		NPC9Dwn[5] = NPC9Sheet.crop(216, 72, 36, 36);
		
		NPC9Lft = new BufferedImage[6];
		NPC9Lft[0] = NPC9Sheet.crop(36, 108, 36, 36);
		NPC9Lft[1] = NPC9Sheet.crop(72, 108, 36, 36);
		NPC9Lft[2] = NPC9Sheet.crop(108, 108, 36, 36);
		NPC9Lft[3] = NPC9Sheet.crop(144, 108, 36, 36);
		NPC9Lft[4] = NPC9Sheet.crop(180, 108, 36, 36);
		NPC9Lft[5] = NPC9Sheet.crop(216, 108, 36, 36);
		
		NPC5Stationary = new BufferedImage[4];
		NPC5Stationary[0] = NPC5Sheet.crop(0, 0, 36, 36);
		NPC5Stationary[1] = NPC5Sheet.crop(0, 36, 36, 36);
		NPC5Stationary[2] = NPC5Sheet.crop(0, 72, 36, 36);
		NPC5Stationary[3] = NPC5Sheet.crop(0, 108, 36, 36);
		
		NPC5Up = new BufferedImage[6];
		NPC5Up[0] = NPC5Sheet.crop(36, 0, 36, 36);
		NPC5Up[1] = NPC5Sheet.crop(72, 0, 36, 36);
		NPC5Up[2] = NPC5Sheet.crop(108, 0, 36, 36);
		NPC5Up[3] = NPC5Sheet.crop(144, 0, 36, 36);
		NPC5Up[4] = NPC5Sheet.crop(180, 0, 36, 36);
		NPC5Up[5] = NPC5Sheet.crop(216, 0, 36, 36);
		
		NPC5Rgt = new BufferedImage[6];
		NPC5Rgt[0] = NPC5Sheet.crop(36, 36, 36, 36);
		NPC5Rgt[1] = NPC5Sheet.crop(72, 36, 36, 36);
		NPC5Rgt[2] = NPC5Sheet.crop(108, 36, 36, 36);
		NPC5Rgt[3] = NPC5Sheet.crop(144, 36, 36, 36);
		NPC5Rgt[4] = NPC5Sheet.crop(180, 36, 36, 36);
		NPC5Rgt[5] = NPC5Sheet.crop(216, 36, 36, 36);
		
		NPC5Dwn = new BufferedImage[6];
		NPC5Dwn[0] = NPC5Sheet.crop(36, 72, 36, 36);
		NPC5Dwn[1] = NPC5Sheet.crop(72, 72, 36, 36);
		NPC5Dwn[2] = NPC5Sheet.crop(108, 72, 36, 36);
		NPC5Dwn[3] = NPC5Sheet.crop(144, 72, 36, 36);
		NPC5Dwn[4] = NPC5Sheet.crop(180, 72, 36, 36);
		NPC5Dwn[5] = NPC5Sheet.crop(216, 72, 36, 36);
		
		NPC5Lft = new BufferedImage[6];
		NPC5Lft[0] = NPC5Sheet.crop(36, 108, 36, 36);
		NPC5Lft[1] = NPC5Sheet.crop(72, 108, 36, 36);
		NPC5Lft[2] = NPC5Sheet.crop(108, 108, 36, 36);
		NPC5Lft[3] = NPC5Sheet.crop(144, 108, 36, 36);
		NPC5Lft[4] = NPC5Sheet.crop(180, 108, 36, 36);
		NPC5Lft[5] = NPC5Sheet.crop(216, 108, 36, 36);
		
		NPC3Stationary = new BufferedImage[4];
		NPC3Stationary[0] = NPC3Sheet.crop(0, 0, 36, 36);
		NPC3Stationary[1] = NPC3Sheet.crop(0, 36, 36, 36);
		NPC3Stationary[2] = NPC3Sheet.crop(0, 72, 36, 36);
		NPC3Stationary[3] = NPC3Sheet.crop(0, 108, 36, 36);
		
		NPC3Up = new BufferedImage[6];
		NPC3Up[0] = NPC3Sheet.crop(36, 0, 36, 36);
		NPC3Up[1] = NPC3Sheet.crop(72, 0, 36, 36);
		NPC3Up[2] = NPC3Sheet.crop(108, 0, 36, 36);
		NPC3Up[3] = NPC3Sheet.crop(144, 0, 36, 36);
		NPC3Up[4] = NPC3Sheet.crop(180, 0, 36, 36);
		NPC3Up[5] = NPC3Sheet.crop(216, 0, 36, 36);
		
		NPC3Rgt = new BufferedImage[6];
		NPC3Rgt[0] = NPC3Sheet.crop(36, 36, 36, 36);
		NPC3Rgt[1] = NPC3Sheet.crop(72, 36, 36, 36);
		NPC3Rgt[2] = NPC3Sheet.crop(108, 36, 36, 36);
		NPC3Rgt[3] = NPC3Sheet.crop(144, 36, 36, 36);
		NPC3Rgt[4] = NPC3Sheet.crop(180, 36, 36, 36);
		NPC3Rgt[5] = NPC3Sheet.crop(216, 36, 36, 36);
		
		NPC3Dwn = new BufferedImage[6];
		NPC3Dwn[0] = NPC3Sheet.crop(36, 72, 36, 36);
		NPC3Dwn[1] = NPC3Sheet.crop(72, 72, 36, 36);
		NPC3Dwn[2] = NPC3Sheet.crop(108, 72, 36, 36);
		NPC3Dwn[3] = NPC3Sheet.crop(144, 72, 36, 36);
		NPC3Dwn[4] = NPC3Sheet.crop(180, 72, 36, 36);
		NPC3Dwn[5] = NPC3Sheet.crop(216, 72, 36, 36);
		
		NPC3Lft = new BufferedImage[6];
		NPC3Lft[0] = NPC3Sheet.crop(36, 108, 36, 36);
		NPC3Lft[1] = NPC3Sheet.crop(72, 108, 36, 36);
		NPC3Lft[2] = NPC3Sheet.crop(108, 108, 36, 36);
		NPC3Lft[3] = NPC3Sheet.crop(144, 108, 36, 36);
		NPC3Lft[4] = NPC3Sheet.crop(180, 108, 36, 36);
		NPC3Lft[5] = NPC3Sheet.crop(216, 108, 36, 36);
		
		NPC6Stationary = new BufferedImage[4];
		NPC6Stationary[0] = NPC6Sheet.crop(0, 0, 36, 36);
		NPC6Stationary[1] = NPC6Sheet.crop(0, 36, 36, 36);
		NPC6Stationary[2] = NPC6Sheet.crop(0, 72, 36, 36);
		NPC6Stationary[3] = NPC6Sheet.crop(0, 108, 36, 36);
		
		NPC6Up = new BufferedImage[6];
		NPC6Up[0] = NPC6Sheet.crop(36, 0, 36, 36);
		NPC6Up[1] = NPC6Sheet.crop(72, 0, 36, 36);
		NPC6Up[2] = NPC6Sheet.crop(108, 0, 36, 36);
		NPC6Up[3] = NPC6Sheet.crop(144, 0, 36, 36);
		NPC6Up[4] = NPC6Sheet.crop(180, 0, 36, 36);
		NPC6Up[5] = NPC6Sheet.crop(216, 0, 36, 36);
		
		NPC6Rgt = new BufferedImage[6];
		NPC6Rgt[0] = NPC6Sheet.crop(36, 36, 36, 36);
		NPC6Rgt[1] = NPC6Sheet.crop(72, 36, 36, 36);
		NPC6Rgt[2] = NPC6Sheet.crop(108, 36, 36, 36);
		NPC6Rgt[3] = NPC6Sheet.crop(144, 36, 36, 36);
		NPC6Rgt[4] = NPC6Sheet.crop(180, 36, 36, 36);
		NPC6Rgt[5] = NPC6Sheet.crop(216, 36, 36, 36);
		
		NPC6Dwn = new BufferedImage[6];
		NPC6Dwn[0] = NPC6Sheet.crop(36, 72, 36, 36);
		NPC6Dwn[1] = NPC6Sheet.crop(72, 72, 36, 36);
		NPC6Dwn[2] = NPC6Sheet.crop(108, 72, 36, 36);
		NPC6Dwn[3] = NPC6Sheet.crop(144, 72, 36, 36);
		NPC6Dwn[4] = NPC6Sheet.crop(180, 72, 36, 36);
		NPC6Dwn[5] = NPC6Sheet.crop(216, 72, 36, 36);
		
		NPC6Lft = new BufferedImage[6];
		NPC6Lft[0] = NPC6Sheet.crop(36, 108, 36, 36);
		NPC6Lft[1] = NPC6Sheet.crop(72, 108, 36, 36);
		NPC6Lft[2] = NPC6Sheet.crop(108, 108, 36, 36);
		NPC6Lft[3] = NPC6Sheet.crop(144, 108, 36, 36);
		NPC6Lft[4] = NPC6Sheet.crop(180, 108, 36, 36);
		NPC6Lft[5] = NPC6Sheet.crop(216, 108, 36, 36);
		
		NPC7Stationary = new BufferedImage[4];
		NPC7Stationary[0] = NPC7Sheet.crop(0, 0, 36, 36);
		NPC7Stationary[1] = NPC7Sheet.crop(0, 36, 36, 36);
		NPC7Stationary[2] = NPC7Sheet.crop(0, 72, 36, 36);
		NPC7Stationary[3] = NPC7Sheet.crop(0, 108, 36, 36);
		
		NPC7Up = new BufferedImage[6];
		NPC7Up[0] = NPC7Sheet.crop(36, 0, 36, 36);
		NPC7Up[1] = NPC7Sheet.crop(72, 0, 36, 36);
		NPC7Up[2] = NPC7Sheet.crop(108, 0, 36, 36);
		NPC7Up[3] = NPC7Sheet.crop(144, 0, 36, 36);
		NPC7Up[4] = NPC7Sheet.crop(180, 0, 36, 36);
		NPC7Up[5] = NPC9Sheet.crop(216, 0, 36, 36);
		
		NPC7Rgt = new BufferedImage[6];
		NPC7Rgt[0] = NPC7Sheet.crop(36, 36, 36, 36);
		NPC7Rgt[1] = NPC7Sheet.crop(72, 36, 36, 36);
		NPC7Rgt[2] = NPC7Sheet.crop(108, 36, 36, 36);
		NPC7Rgt[3] = NPC7Sheet.crop(144, 36, 36, 36);
		NPC7Rgt[4] = NPC7Sheet.crop(180, 36, 36, 36);
		NPC7Rgt[5] = NPC7Sheet.crop(216, 36, 36, 36);
		
		NPC7Dwn = new BufferedImage[6];
		NPC7Dwn[0] = NPC7Sheet.crop(36, 72, 36, 36);
		NPC7Dwn[1] = NPC7Sheet.crop(72, 72, 36, 36);
		NPC7Dwn[2] = NPC7Sheet.crop(108, 72, 36, 36);
		NPC7Dwn[3] = NPC7Sheet.crop(144, 72, 36, 36);
		NPC7Dwn[4] = NPC7Sheet.crop(180, 72, 36, 36);
		NPC7Dwn[5] = NPC7Sheet.crop(216, 72, 36, 36);
		
		NPC7Lft = new BufferedImage[6];
		NPC7Lft[0] = NPC7Sheet.crop(36, 108, 36, 36);
		NPC7Lft[1] = NPC7Sheet.crop(72, 108, 36, 36);
		NPC7Lft[2] = NPC7Sheet.crop(108, 108, 36, 36);
		NPC7Lft[3] = NPC7Sheet.crop(144, 108, 36, 36);
		NPC7Lft[4] = NPC7Sheet.crop(180, 108, 36, 36);
		NPC7Lft[5] = NPC7Sheet.crop(216, 108, 36, 36);
	}
	
	
	public static void loadBosses()
	{
		int bossWidth, bossHeight;
		SpriteSheet bossSheet;
		
		bossSheet = new SpriteSheet(ResourceLoader.loadTexture("D8Boss.png"));
		bossWidth = 100; bossHeight = 100;
		
		b8DwnLft = new BufferedImage[6];
		b8DwnLft[0] = bossSheet.crop(bossWidth * 0, bossHeight * 0, bossWidth, bossHeight);
		b8DwnLft[1] = bossSheet.crop(bossWidth * 1, bossHeight * 0, bossWidth, bossHeight);
		b8DwnLft[2] = bossSheet.crop(bossWidth * 2, bossHeight * 0, bossWidth, bossHeight);
		b8DwnLft[3] = bossSheet.crop(bossWidth * 3, bossHeight * 0, bossWidth, bossHeight);
		b8DwnLft[4] = bossSheet.crop(bossWidth * 4, bossHeight * 0, bossWidth, bossHeight);
		b8DwnLft[5] = bossSheet.crop(bossWidth * 5, bossHeight * 0, bossWidth, bossHeight);
		
		b8UpLft = new BufferedImage[6];
		b8UpLft[0] = bossSheet.crop(bossWidth * 0, bossHeight * 1, bossWidth, bossHeight);
		b8UpLft[1] = bossSheet.crop(bossWidth * 1, bossHeight * 1, bossWidth, bossHeight);
		b8UpLft[2] = bossSheet.crop(bossWidth * 2, bossHeight * 1, bossWidth, bossHeight);
		b8UpLft[3] = bossSheet.crop(bossWidth * 3, bossHeight * 1, bossWidth, bossHeight);
		b8UpLft[4] = bossSheet.crop(bossWidth * 4, bossHeight * 1, bossWidth, bossHeight);
		b8UpLft[5] = bossSheet.crop(bossWidth * 5, bossHeight * 1, bossWidth, bossHeight);
		
		b8UpRgt = new BufferedImage[6];
		b8UpRgt[0] = bossSheet.crop(bossWidth * 6, bossHeight * 1, bossWidth, bossHeight);
		b8UpRgt[1] = bossSheet.crop(bossWidth * 7, bossHeight * 1, bossWidth, bossHeight);
		b8UpRgt[2] = bossSheet.crop(bossWidth * 8, bossHeight * 1, bossWidth, bossHeight);
		b8UpRgt[3] = bossSheet.crop(bossWidth * 9, bossHeight * 1, bossWidth, bossHeight);
		b8UpRgt[4] = bossSheet.crop(bossWidth * 10, bossHeight * 1, bossWidth, bossHeight);
		b8UpRgt[5] = bossSheet.crop(bossWidth * 11, bossHeight * 1, bossWidth, bossHeight);
		
		b8DwnRgt = new BufferedImage[6];
		b8DwnRgt[0] = bossSheet.crop(bossWidth * 6, bossHeight * 0, bossWidth, bossHeight);
		b8DwnRgt[1] = bossSheet.crop(bossWidth * 7, bossHeight * 0, bossWidth, bossHeight);
		b8DwnRgt[2] = bossSheet.crop(bossWidth * 8, bossHeight * 0, bossWidth, bossHeight);
		b8DwnRgt[3] = bossSheet.crop(bossWidth * 9, bossHeight * 0, bossWidth, bossHeight);
		b8DwnRgt[4] = bossSheet.crop(bossWidth * 10, bossHeight * 0, bossWidth, bossHeight);
		b8DwnRgt[5] = bossSheet.crop(bossWidth * 11, bossHeight * 0, bossWidth, bossHeight);

		b8AtkDwnLft = new BufferedImage[2];
		b8AtkDwnLft[0] = bossSheet.crop(bossWidth * 0, bossHeight * 2, bossWidth, bossHeight);
		b8AtkDwnLft[1] = bossSheet.crop(bossWidth * 1, bossHeight * 2, bossWidth, bossHeight);
		
		b8AtkUpLft = new BufferedImage[2];
		b8AtkUpLft[0] = bossSheet.crop(bossWidth * 0, bossHeight * 3, bossWidth, bossHeight);
		b8AtkUpLft[1] = bossSheet.crop(bossWidth * 1, bossHeight * 3, bossWidth, bossHeight);
		
		b8AtkUpRgt = new BufferedImage[2];
		b8AtkUpRgt[0] = bossSheet.crop(bossWidth * 2, bossHeight * 3, bossWidth, bossHeight);
		b8AtkUpRgt[1] = bossSheet.crop(bossWidth * 3, bossHeight * 3, bossWidth, bossHeight);
		
		b8AtkDwnRgt = new BufferedImage[2];
		b8AtkDwnRgt[0] = bossSheet.crop(bossWidth * 2, bossHeight * 2, bossWidth, bossHeight);
		b8AtkDwnRgt[1] = bossSheet.crop(bossWidth * 3, bossHeight * 2, bossWidth, bossHeight);
		
		bossSheet = new SpriteSheet(ResourceLoader.loadTexture("D1Boss.png"));
		bossWidth = 80; bossHeight = 60;
		
		b1DwnLft = new BufferedImage[4];
		b1DwnLft[0] = bossSheet.crop(bossWidth * 0, bossHeight * 0, bossWidth, bossHeight);
		b1DwnLft[1] = bossSheet.crop(bossWidth * 1, bossHeight * 0, bossWidth, bossHeight);
		b1DwnLft[2] = bossSheet.crop(bossWidth * 2, bossHeight * 0, bossWidth, bossHeight);
		b1DwnLft[3] = bossSheet.crop(bossWidth * 3, bossHeight * 0, bossWidth, bossHeight);
		
		b1UpLft = new BufferedImage[4];
		b1UpLft[0] = bossSheet.crop(bossWidth * 0, bossHeight * 1, bossWidth, bossHeight);
		b1UpLft[1] = bossSheet.crop(bossWidth * 1, bossHeight * 1, bossWidth, bossHeight);
		b1UpLft[2] = bossSheet.crop(bossWidth * 2, bossHeight * 1, bossWidth, bossHeight);
		b1UpLft[3] = bossSheet.crop(bossWidth * 3, bossHeight * 1, bossWidth, bossHeight);
		
		b1UpRgt = new BufferedImage[4];
		b1UpRgt[0] = bossSheet.crop(bossWidth * 7, bossHeight * 1, bossWidth, bossHeight);
		b1UpRgt[1] = bossSheet.crop(bossWidth * 6, bossHeight * 1, bossWidth, bossHeight);
		b1UpRgt[2] = bossSheet.crop(bossWidth * 5, bossHeight * 1, bossWidth, bossHeight);
		b1UpRgt[3] = bossSheet.crop(bossWidth * 4, bossHeight * 1, bossWidth, bossHeight);
		
		b1DwnRgt = new BufferedImage[4];
		b1DwnRgt[0] = bossSheet.crop(bossWidth * 7, bossHeight * 0, bossWidth, bossHeight);
		b1DwnRgt[1] = bossSheet.crop(bossWidth * 6, bossHeight * 0, bossWidth, bossHeight);
		b1DwnRgt[2] = bossSheet.crop(bossWidth * 5, bossHeight * 0, bossWidth, bossHeight);
		b1DwnRgt[3] = bossSheet.crop(bossWidth * 4, bossHeight * 0, bossWidth, bossHeight);

		b1AtkDwnLft = new BufferedImage[3];
		b1AtkDwnLft[0] = bossSheet.crop(bossWidth * 0, bossHeight * 2, bossWidth, bossHeight);
		b1AtkDwnLft[1] = bossSheet.crop(bossWidth * 1, bossHeight * 2, bossWidth, bossHeight);
		b1AtkDwnLft[2] = bossSheet.crop(bossWidth * 2, bossHeight * 2, bossWidth, bossHeight);
		
		b1AtkUpLft = new BufferedImage[3];
		b1AtkUpLft[0] = bossSheet.crop(bossWidth * 0, bossHeight * 3, bossWidth, bossHeight);
		b1AtkUpLft[1] = bossSheet.crop(bossWidth * 1, bossHeight * 3, bossWidth, bossHeight);
		b1AtkUpLft[2] = bossSheet.crop(bossWidth * 2, bossHeight * 3, bossWidth, bossHeight);
		
		b1AtkUpRgt = new BufferedImage[3];
		b1AtkUpRgt[0] = bossSheet.crop(bossWidth * 5, bossHeight * 3, bossWidth, bossHeight);
		b1AtkUpRgt[1] = bossSheet.crop(bossWidth * 4, bossHeight * 3, bossWidth, bossHeight);
		b1AtkUpRgt[2] = bossSheet.crop(bossWidth * 3, bossHeight * 3, bossWidth, bossHeight);
		
		b1AtkDwnRgt = new BufferedImage[3];
		b1AtkDwnRgt[0] = bossSheet.crop(bossWidth * 5, bossHeight * 2, bossWidth, bossHeight);
		b1AtkDwnRgt[1] = bossSheet.crop(bossWidth * 4, bossHeight * 2, bossWidth, bossHeight);
		b1AtkDwnRgt[2] = bossSheet.crop(bossWidth * 3, bossHeight * 2, bossWidth, bossHeight);
		
		bossSheet = new SpriteSheet(ResourceLoader.loadTexture("D2Boss.png"));
		bossWidth = 100; bossHeight = 100;
		
		b2DwnLft = new BufferedImage[4];
		b2DwnLft[0] = bossSheet.crop(bossWidth * 0, bossHeight * 0, bossWidth, bossHeight);
		b2DwnLft[1] = bossSheet.crop(bossWidth * 1, bossHeight * 0, bossWidth, bossHeight);
		b2DwnLft[2] = bossSheet.crop(bossWidth * 2, bossHeight * 0, bossWidth, bossHeight);
		b2DwnLft[3] = bossSheet.crop(bossWidth * 3, bossHeight * 0, bossWidth, bossHeight);
		
		b2UpLft = new BufferedImage[4];
		b2UpLft[0] = bossSheet.crop(bossWidth * 0, bossHeight * 1, bossWidth, bossHeight);
		b2UpLft[1] = bossSheet.crop(bossWidth * 1, bossHeight * 1, bossWidth, bossHeight);
		b2UpLft[2] = bossSheet.crop(bossWidth * 2, bossHeight * 1, bossWidth, bossHeight);
		b2UpLft[3] = bossSheet.crop(bossWidth * 3, bossHeight * 1, bossWidth, bossHeight);
		
		b2UpRgt = new BufferedImage[4];
		b2UpRgt[0] = bossSheet.crop(bossWidth * 7, bossHeight * 1, bossWidth, bossHeight);
		b2UpRgt[1] = bossSheet.crop(bossWidth * 6, bossHeight * 1, bossWidth, bossHeight);
		b2UpRgt[2] = bossSheet.crop(bossWidth * 5, bossHeight * 1, bossWidth, bossHeight);
		b2UpRgt[3] = bossSheet.crop(bossWidth * 4, bossHeight * 1, bossWidth, bossHeight);
		
		b2DwnRgt = new BufferedImage[4];
		b2DwnRgt[0] = bossSheet.crop(bossWidth * 7, bossHeight * 0, bossWidth, bossHeight);
		b2DwnRgt[1] = bossSheet.crop(bossWidth * 6, bossHeight * 0, bossWidth, bossHeight);
		b2DwnRgt[2] = bossSheet.crop(bossWidth * 5, bossHeight * 0, bossWidth, bossHeight);
		b2DwnRgt[3] = bossSheet.crop(bossWidth * 4, bossHeight * 0, bossWidth, bossHeight);

		b2AtkDwnLft = new BufferedImage[3];
		b2AtkDwnLft[0] = bossSheet.crop(bossWidth * 0, bossHeight * 2, bossWidth, bossHeight);
		b2AtkDwnLft[1] = bossSheet.crop(bossWidth * 1, bossHeight * 2, bossWidth, bossHeight);
		b2AtkDwnLft[2] = bossSheet.crop(bossWidth * 2, bossHeight * 2, bossWidth, bossHeight);
		
		b2AtkUpLft = new BufferedImage[3];
		b2AtkUpLft[0] = bossSheet.crop(bossWidth * 0, bossHeight * 3, bossWidth, bossHeight);
		b2AtkUpLft[1] = bossSheet.crop(bossWidth * 1, bossHeight * 3, bossWidth, bossHeight);
		b2AtkUpLft[2] = bossSheet.crop(bossWidth * 2, bossHeight * 3, bossWidth, bossHeight);
		
		b2AtkUpRgt = new BufferedImage[3];
		b2AtkUpRgt[0] = bossSheet.crop(bossWidth * 5, bossHeight * 3, bossWidth, bossHeight);
		b2AtkUpRgt[1] = bossSheet.crop(bossWidth * 4, bossHeight * 3, bossWidth, bossHeight);
		b2AtkUpRgt[2] = bossSheet.crop(bossWidth * 3, bossHeight * 3, bossWidth, bossHeight);
		
		b2AtkDwnRgt = new BufferedImage[3];
		b2AtkDwnRgt[0] = bossSheet.crop(bossWidth * 5, bossHeight * 2, bossWidth, bossHeight);
		b2AtkDwnRgt[1] = bossSheet.crop(bossWidth * 4, bossHeight * 2, bossWidth, bossHeight);
		b2AtkDwnRgt[2] = bossSheet.crop(bossWidth * 3, bossHeight * 2, bossWidth, bossHeight);
		
		bossSheet = new SpriteSheet(ResourceLoader.loadTexture("D4Boss.png"));
		bossWidth = 80; bossHeight = 60;
		
		b4DwnLft = new BufferedImage[4];
		b4DwnLft[0] = bossSheet.crop(bossWidth * 0, bossHeight * 0, bossWidth, bossHeight);
		b4DwnLft[1] = bossSheet.crop(bossWidth * 1, bossHeight * 0, bossWidth, bossHeight);
		b4DwnLft[2] = bossSheet.crop(bossWidth * 2, bossHeight * 0, bossWidth, bossHeight);
		b4DwnLft[3] = bossSheet.crop(bossWidth * 3, bossHeight * 0, bossWidth, bossHeight);
		
		b4UpLft = new BufferedImage[4];
		b4UpLft[0] = bossSheet.crop(bossWidth * 0, bossHeight * 1, bossWidth, bossHeight);
		b4UpLft[1] = bossSheet.crop(bossWidth * 1, bossHeight * 1, bossWidth, bossHeight);
		b4UpLft[2] = bossSheet.crop(bossWidth * 2, bossHeight * 1, bossWidth, bossHeight);
		b4UpLft[3] = bossSheet.crop(bossWidth * 3, bossHeight * 1, bossWidth, bossHeight);
		
		b4UpRgt = new BufferedImage[4];
		b4UpRgt[0] = bossSheet.crop(bossWidth * 7, bossHeight * 1, bossWidth, bossHeight);
		b4UpRgt[1] = bossSheet.crop(bossWidth * 6, bossHeight * 1, bossWidth, bossHeight);
		b4UpRgt[2] = bossSheet.crop(bossWidth * 5, bossHeight * 1, bossWidth, bossHeight);
		b4UpRgt[3] = bossSheet.crop(bossWidth * 4, bossHeight * 1, bossWidth, bossHeight);
		
		b4DwnRgt = new BufferedImage[4];
		b4DwnRgt[0] = bossSheet.crop(bossWidth * 7, bossHeight * 0, bossWidth, bossHeight);
		b4DwnRgt[1] = bossSheet.crop(bossWidth * 6, bossHeight * 0, bossWidth, bossHeight);
		b4DwnRgt[2] = bossSheet.crop(bossWidth * 5, bossHeight * 0, bossWidth, bossHeight);
		b4DwnRgt[3] = bossSheet.crop(bossWidth * 4, bossHeight * 0, bossWidth, bossHeight);

		b4AtkDwnLft = new BufferedImage[4];
		b4AtkDwnLft[0] = bossSheet.crop(bossWidth * 0, bossHeight * 2, bossWidth, bossHeight);
		b4AtkDwnLft[1] = bossSheet.crop(bossWidth * 1, bossHeight * 2, bossWidth, bossHeight);
		b4AtkDwnLft[2] = bossSheet.crop(bossWidth * 2, bossHeight * 2, bossWidth, bossHeight);
		b4AtkDwnLft[3] = bossSheet.crop(bossWidth * 3, bossHeight * 2, bossWidth, bossHeight);
	
		b4AtkUpLft = new BufferedImage[4];
		b4AtkUpLft[0] = bossSheet.crop(bossWidth * 0, bossHeight * 3, bossWidth, bossHeight);
		b4AtkUpLft[1] = bossSheet.crop(bossWidth * 1, bossHeight * 3, bossWidth, bossHeight);
		b4AtkUpLft[2] = bossSheet.crop(bossWidth * 2, bossHeight * 3, bossWidth, bossHeight);
		b4AtkUpLft[3] = bossSheet.crop(bossWidth * 3, bossHeight * 3, bossWidth, bossHeight);
		
		b4AtkUpRgt = new BufferedImage[4];
		b4AtkUpRgt[0] = bossSheet.crop(bossWidth * 7, bossHeight * 3, bossWidth, bossHeight);
		b4AtkUpRgt[1] = bossSheet.crop(bossWidth * 6, bossHeight * 3, bossWidth, bossHeight);
		b4AtkUpRgt[2] = bossSheet.crop(bossWidth * 5, bossHeight * 3, bossWidth, bossHeight);
		b4AtkUpRgt[3] = bossSheet.crop(bossWidth * 4, bossHeight * 3, bossWidth, bossHeight);
	
		b4AtkDwnRgt = new BufferedImage[4];
		b4AtkDwnRgt[0] = bossSheet.crop(bossWidth * 7, bossHeight * 2, bossWidth, bossHeight);
		b4AtkDwnRgt[1] = bossSheet.crop(bossWidth * 6, bossHeight * 2, bossWidth, bossHeight);
		b4AtkDwnRgt[2] = bossSheet.crop(bossWidth * 5, bossHeight * 2, bossWidth, bossHeight);
		b4AtkDwnRgt[3] = bossSheet.crop(bossWidth * 4, bossHeight * 2, bossWidth, bossHeight);
		
		bossSheet = new SpriteSheet(ResourceLoader.loadTexture("D5Boss.png"));
		bossWidth = 36; bossHeight = 36;
		
		b5EleStationary = new BufferedImage[4];
		b5EleStationary[0] = bossSheet.crop(0, 0, 36, 36);
		b5EleStationary[1] = bossSheet.crop(0, 36, 36, 36);
		b5EleStationary[2] = bossSheet.crop(0, 72, 36, 36);
		b5EleStationary[3] = bossSheet.crop(0, 108, 36, 36);
		
		b5EleUp = new BufferedImage[6];
		b5EleUp[0] = bossSheet.crop(36, 0, 36, 36);
		b5EleUp[1] = bossSheet.crop(72, 0, 36, 36);
		b5EleUp[2] = bossSheet.crop(108, 0, 36, 36);
		b5EleUp[3] = bossSheet.crop(144, 0, 36, 36);
		b5EleUp[4] = bossSheet.crop(180, 0, 36, 36);
		b5EleUp[5] = bossSheet.crop(216, 0, 36, 36);
		
		b5EleRgt = new BufferedImage[6];
		b5EleRgt[0] = bossSheet.crop(36, 36, 36, 36);
		b5EleRgt[1] = bossSheet.crop(72, 36, 36, 36);
		b5EleRgt[2] = bossSheet.crop(108, 36, 36, 36);
		b5EleRgt[3] = bossSheet.crop(144, 36, 36, 36);
		b5EleRgt[4] = bossSheet.crop(180, 36, 36, 36);
		b5EleRgt[5] = bossSheet.crop(216, 36, 36, 36);
		
		b5EleDwn = new BufferedImage[6];
		b5EleDwn[0] = bossSheet.crop(36, 72, 36, 36);
		b5EleDwn[1] = bossSheet.crop(72, 72, 36, 36);
		b5EleDwn[2] = bossSheet.crop(108, 72, 36, 36);
		b5EleDwn[3] = bossSheet.crop(144, 72, 36, 36);
		b5EleDwn[4] = bossSheet.crop(180, 72, 36, 36);
		b5EleDwn[5] = bossSheet.crop(216, 72, 36, 36);
		
		b5EleLft = new BufferedImage[6];
		b5EleLft[0] = bossSheet.crop(36, 108, 36, 36);
		b5EleLft[1] = bossSheet.crop(72, 108, 36, 36);
		b5EleLft[2] = bossSheet.crop(108, 108, 36, 36);
		b5EleLft[3] = bossSheet.crop(144, 108, 36, 36);
		b5EleLft[4] = bossSheet.crop(180, 108, 36, 36);
		b5EleLft[5] = bossSheet.crop(216, 108, 36, 36);
		
		b5ChargeUp = new BufferedImage[4];
		for(int i = 0; i < b5ChargeUp.length; i++)
			b5ChargeUp[i] = bossSheet.crop(i * 36, 144, bossWidth, bossHeight);
		
		b5ChargeRgt = new BufferedImage[4];
		for(int i = 0; i < b5ChargeRgt.length; i++)
			b5ChargeRgt[i] = bossSheet.crop(i * 36, 180, bossWidth, bossHeight);
		
		b5ChargeDwn = new BufferedImage[4];
		for(int i = 0; i < b5ChargeDwn.length; i++)
			b5ChargeDwn[i] = bossSheet.crop(i * 36, 216, bossWidth, bossHeight);
		
		b5ChargeLft = new BufferedImage[4];
		for(int i = 0; i < b5ChargeLft.length; i++)
			b5ChargeLft[i] = bossSheet.crop(i * 36, 252, bossWidth, bossHeight);
	}

	
}

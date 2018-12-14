package com.cognizant.jose.pokemonclicker;

import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class MainPage {
	
	@FindBy (id = "Squirtle")
	private WebElement squirtle;
	
	@FindBy (id = "Charmander")
	private WebElement charmander;
	
	@FindBy (id = "Bulbasaur")
	private WebElement bulbasaur;

	
	public WebElement pokemonChoose() {
		int num = new Random().nextInt(2);		
		switch(num) {
			case 0: return squirtle;
			case 1: return charmander;
			case 2: return bulbasaur;
			default: return charmander;
		}
	}
	
	@FindBy(id = "startAdventure")
	public WebElement startAdventure;
	
//	@FindBy(partialLinkText = "You successfully caught")
//	public WebElement successfulCaught;
	
	@FindBy(id = "enemy")
	public WebElement enemy;
	
	@FindBy(xpath = "//*[@id=\"currentRoute\"]")
	public WebElement counter;
	
	public String counterText() {
		return counter.getText();
	}

	@FindBy(id = "oakModal")
	public WebElement oak;
}

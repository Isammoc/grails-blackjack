package net.isammoc.gbj

import grails.test.*
import net.isammoc.gbj.auth.User

class CardServiceTests extends GrailsUnitTestCase {

	def cardService
	def ace = new Card(name:"Ah",rank:"A",suit:"h")
	def jack = new Card(name:"Jc",rank:"J",suit:"c")
	def nine = new Card(name:"9s",rank:"9",suit:"s")

	protected void setUp() {
		super.setUp()
		cardService = new CardService()
	}

	protected void tearDown() {
		super.tearDown()
	}

	void testScoreToDisplay() {
		assert "1 / 11" == cardService.scoreToDisplay([ace])
		assert "Blackjack" == cardService.scoreToDisplay([ace, jack])
		assert "10 / 20" == cardService.scoreToDisplay([ace, nine])
		assert "11 / 21" == cardService.scoreToDisplay([ace, ace, nine])
	}

	void testCanCard() {
		def table = new Table()
		table.bank = [ace]
		// Possible card
		table.player = [jack,nine]
		assert cardService.canCard(table)
		table.player = [ace, ace, nine]
		assert cardService.canCard(table)
		
		// Impossible card
		table.player = [jack,jack,jack]
		assert !cardService.canCard(table)
		table.player = [ace, jack]
		assert !cardService.canCard(table)
		table.bank = [ace, jack]
		assert !cardService.canCard(table)
		table.player = [jack, nine]
		assert !cardService.canCard(table)
	}
	
	void testWhoWin() {
		def table = new Table()
		table.user = new User(username:'tester')
		mockDomain(Table, [table])
		table.bank = [nine]
		table.player = [ace, ace]
		assert null == cardService.whoWin(table)
		table.bank = [jack,nine]
		assert "bank" == cardService.whoWin(table)
		table.player = [jack,jack]
		assert "player" == cardService.whoWin(table)
		
		table.bank = table.player
		assert "draw" == cardService.whoWin(table)
		
		table.player = [jack, ace]
		table.bank = [jack, jack, ace]
		assert "player" == cardService.whoWin(table)
		
		table.player = [jack, jack, ace]
		table.bank = [jack, ace]
		assert "bank" == cardService.whoWin(table)

		table.player = table.bank = [jack, ace]
		assert "draw" == cardService.whoWin(table)
		
		table.player = [jack, jack, jack]
		assert "bank" == cardService.whoWin(table)
		
		table.bank = [jack, jack, jack]
		table.player = [ace, nine]
		assert "player" == cardService.whoWin(table)
	}
}

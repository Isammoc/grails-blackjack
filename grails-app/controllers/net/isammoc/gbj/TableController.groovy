package net.isammoc.gbj

import grails.plugins.springsecurity.Secured;

class TableController {

	def cardService
	def springSecurityService

	def index = { redirect(action:"create") }

	@Secured(['ROLE_USER'])
	def create = {
		def table = new Table()
		table.addToBank(cardService.random())
		table.addToPlayer(cardService.random())
		table.addToPlayer(cardService.random())
		table.abandon = false
		table.user = springSecurityService.currentUser
		table.bet = 2
		table.user.account -= 2
		table.save(flush:true)
		if(!cardService.canCard(table)) {
			cardService.playBank(table)
		}
		redirect(action:"show",params:[id:table.id])
	}

	def show = {
		def table = Table.get(params.id)
		[
					table:table,
					score:cardService.scoreToDisplay(table.player),
					bankScore:cardService.scoreToDisplay(table.bank),
					canCard:cardService.canCard(table),
					winner:cardService.whoWin(table),
					bankBurn:cardService.score(table.bank) > 21,
					playerBurn:cardService.score(table.player) > 21
				]
	}

	@Secured(['ROLE_USER'])
	def card = {
		def table = Table.get(params.id)
		if(table.user != springSecurityService.currentUser) {
			flash.message = "Vous ne pouvez pas tirer une carte sur la table d'un autre joueur"
			redirect(action:"show",params:[id:table.id])
			return
		}

		if(cardService.canCard(table)){
			table.addToPlayer(cardService.random())
			table.save(flush:true)
			if(!cardService.canCard(table)) {
				cardService.playBank(table)
			}
		} else {
			flash.message = "Mais puisque je vous dis que vous ne pouvez pas tirer de carte !!!"
		}
		redirect(action:"show",params:[id:table.id])
	}

	@Secured(['ROLE_USER'])
	def stop = {
		def table = Table.get(params.id)
		if(table.user != springSecurityService.currentUser) {
			flash.message = "Vous ne pouvez pas stopper sur la table d'un autre joueur"
			redirect(action:"show",params:[id:table.id])
			return
		}
		cardService.playBank(table)
		redirect(action:"show",params:[id:table.id])
	}

	@Secured(['ROLE_USER'])
	def doub = {
		def table = Table.get(params.id)
		if(table.user != springSecurityService.currentUser) {
			flash.message = "Vous ne pouvez pas doubler sur la table d'un autre joueur"
			redirect(action:"show",params:[id:table.id])
			return
		}

		if(cardService.canCard(table)){
			table.user.account -= table.bet
			table.bet += table.bet
			table.addToPlayer(cardService.random())
			table.save(flush:true)
			cardService.playBank(table)
		} else {
			flash.message = "Mais puisque je vous dis que vous ne pouvez pas tirer de carte ni encore moins doubler !!!"
		}
		redirect(action:"show",params:[id:table.id])
	}

	@Secured(['ROLE_USER'])
	def abandon = {
		def table = Table.get(params.id)
		if(table.user != springSecurityService.currentUser) {
			flash.message = "Vous ne pouvez pas abandonner sur la table d'un autre joueur"
			redirect(action:"show",params:[id:table.id])
			return
		}

		if(table.player.size() == 2 && cardService.canCard(table)) {
			table.user.account += table.bet / 2
			table.bet = 0
			table.abandon = true
			table.save(flush:true)
			cardService.playBank(table)
		} else {
			flash.message = "Mais puisque je vous dis que vous ne pouvez pas abandonner !!!"
		}
		redirect(action:"show",params:[id:table.id])
	}

	@Secured(['ROLE_USER'])
	def renew = {
		def table = Table.get(params.id)
		if(table.user != springSecurityService.currentUser) {
			flash.message = "Vous ne pouvez pas rejouer sur la table d'un autre joueur"
			redirect(action:"show",params:[id:table.id])
			return
		}

		table.player = []
		table.bank = []
		table.addToBank(cardService.random())
		table.addToPlayer(cardService.random())
		table.addToPlayer(cardService.random())
		table.abandon = false
		table.bet = 2
		table.user.account -= 2
		table.save(flush:true)
		if(!cardService.canCard(table)) {
			cardService.playBank(table)
		}
		redirect(action:"show",params:[id:table.id])
	}
}

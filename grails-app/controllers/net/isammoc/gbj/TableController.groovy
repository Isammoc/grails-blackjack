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
			winner:cardService.whoWin(table)
		]
	}

	def card = {
		def table = Table.get(params.id)
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

	def stop = {
		def table = Table.get(params.id)
		cardService.playBank(table)
		redirect(action:"show",params:[id:table.id])
	}

	def renew = {
		def table = Table.get(params.id)
		table.player = []
		table.bank = []
		table.addToBank(cardService.random())
		table.addToPlayer(cardService.random())
		table.addToPlayer(cardService.random())
		table.bet = 2
		table.user.account -= 2
		table.save(flush:true)
		if(!cardService.canCard(table)) {
			cardService.playBank(table)
		}
		redirect(action:"show",params:[id:table.id])
	}
}

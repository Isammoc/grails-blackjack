package net.isammoc.gbj

class UserFilters {
	
	def springSecurityService
	
    def filters = {
        all(controller:'*', action:'*') {
            before = {
                
            }
            after = { model ->
				model.currentUser = springSecurityService.currentUser
            }
            afterView = {
                
            }
        }
    }
    
}

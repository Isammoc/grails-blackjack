// Place your Spring DSL code here
beans = {
	userDetailsService(net.isammoc.gbj.service.MyUserDetailsService) { grailsApplication = ref('grailsApplication') }

	saltSource(net.isammoc.gbj.util.UserSaltSource) {
		userPropertyToUse = application.config.grails.plugins.springsecurity.dao.reflectionSaltSourceProperty
	}
}

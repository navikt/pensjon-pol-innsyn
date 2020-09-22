package no.nav.pensjon.innsyn.popp.support

import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension
import org.springframework.data.repository.config.RepositoryBeanDefinitionRegistrarSupport
import org.springframework.data.repository.config.RepositoryConfigurationExtension

internal class PoppRepositoriesRegistrar : RepositoryBeanDefinitionRegistrarSupport() {

    override fun getAnnotation(): Class<out Annotation?> {
        return EnablePoppRepositories::class.java
    }

    override fun getExtension(): RepositoryConfigurationExtension {
        return JpaRepositoryConfigExtension()
    }
}
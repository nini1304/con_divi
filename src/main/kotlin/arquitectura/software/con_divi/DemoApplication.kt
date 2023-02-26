package arquitectura.software.con_divi


import ch.qos.logback.classic.LoggerContext
import ch.qos.logback.classic.joran.JoranConfigurator
import ch.qos.logback.core.joran.spi.JoranException
import ch.qos.logback.core.util.StatusPrinter
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication

import org.springframework.boot.runApplication
@SpringBootApplication
class DemoApplication
    //private val logger = LoggerFactory.getLogger(ConDiviApplication::class.java)
    //companion object {
        fun main(args: Array<String>) {
            runApplication<DemoApplication>(*args)

            val context = LoggerFactory.getILoggerFactory() as LoggerContext

            try {
                val configurator = JoranConfigurator()
                configurator.context = context
                context.reset()
                configurator.doConfigure("src/main/kotlin/logback.xml")
            } catch (je: JoranException) {
                je.printStackTrace()
            }
            StatusPrinter.printInCaseOfErrorsOrWarnings(context)
        }
    //}

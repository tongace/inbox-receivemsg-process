package com.example.lab.inbox.inboxreceivemsgprocess.config

import com.example.lab.inbox.inboxreceivemsgprocess.utils.Constants
import io.r2dbc.h2.H2ConnectionFactory
import io.r2dbc.h2.H2ConnectionOption
import io.r2dbc.spi.ConnectionFactory
import org.h2.tools.Server
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.core.io.ClassPathResource
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration
import org.springframework.data.r2dbc.connectionfactory.R2dbcTransactionManager
import org.springframework.data.r2dbc.connectionfactory.init.CompositeDatabasePopulator
import org.springframework.data.r2dbc.connectionfactory.init.ConnectionFactoryInitializer
import org.springframework.data.r2dbc.connectionfactory.init.ResourceDatabasePopulator
import org.springframework.data.r2dbc.core.DatabaseClient
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories
import org.springframework.transaction.ReactiveTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement
import org.springframework.transaction.reactive.TransactionalOperator
import java.sql.SQLException
private typealias H2Options = Map<H2ConnectionOption, String>

@Profile("dev")
@Configuration
@EnableR2dbcRepositories
@EnableTransactionManagement
class H2Configuration : AbstractR2dbcConfiguration() {

    private companion object {
        private const val DB_NAME = "test"
        private const val USER = "sa"
        private const val PASSWORD = "password"
        private const val PORT = "9000"
        private val OPTIONS: H2Options = mapOf(
            H2ConnectionOption.DB_CLOSE_DELAY to "-1",
            H2ConnectionOption.DB_CLOSE_ON_EXIT to "FALSE",
            H2ConnectionOption.MODE to "MSSQLServer",
            H2ConnectionOption.LOG to "2",
            H2ConnectionOption.TRACE_LEVEL_SYSTEM_OUT to "2"
        )
    }

    /**
     *  url: jdbc:h2:tcp://localhost:${port}/mem:${db in memory name}
     *  example: jdbc:h2:tcp://localhost:9000/mem:test
     * */
    @Bean(initMethod = "start", destroyMethod = "stop")
    @Throws(SQLException::class)
    fun h2Server(): Server = Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", PORT)

    @Bean
    override fun connectionFactory(): ConnectionFactory =
        H2ConnectionFactory.inMemory(DB_NAME, USER, PASSWORD, OPTIONS)

    @Bean
    fun transactionManager(connectionFactory: ConnectionFactory) =
        R2dbcTransactionManager(connectionFactory)

    @Bean
    fun transactionalOperator(transactionManager: ReactiveTransactionManager) =
        TransactionalOperator.create(transactionManager)

    @Bean
    fun databaseClient(connectionFactory: ConnectionFactory) =
        DatabaseClient.create(connectionFactory)

    @Bean
    fun initializer(connectionFactory: ConnectionFactory) =
        ConnectionFactoryInitializer().apply {
            setConnectionFactory(connectionFactory)
            setDatabasePopulator(
                CompositeDatabasePopulator().apply {
                    addPopulators(buildResourceDatabase(Constants.SCHEMA_SQL_PATH))
                    addPopulators(buildResourceDatabase(Constants.DATA_SQL_PATH))
                }
            )
        }

    private fun buildResourceDatabase(pathResource: String) =
        ResourceDatabasePopulator(
            ClassPathResource(
                pathResource
            )
        )
}

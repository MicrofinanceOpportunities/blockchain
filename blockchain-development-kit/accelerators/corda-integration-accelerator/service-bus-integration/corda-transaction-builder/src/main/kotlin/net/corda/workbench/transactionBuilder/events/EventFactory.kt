package net.corda.workbench.transactionBuilder.events

import net.corda.workbench.commons.event.Event

/**
 * Build events for storage. TODO it would
 * be nice to have typed classes here, but Event
 * is currently defined as a data class & so cant be extended
 */
object EventFactory {

    fun CORDA_APP_DEPLOYED(appname: String, network: String): Event {
        return Event(type = "CordaAppDeployed",
                aggregateId = network,
                payload = mapOf<String, Any>("appname" to appname,
                        "network" to network))

    }

    fun AGENT_STARTED(network: String, port: Int, pid: Long): Event {
        return Event(type = "AgentStarted",
                aggregateId = network,
                payload = mapOf("network" to network,
                        "port" to port,
                        "pid" to pid))
    }

    fun AGENT_STOPPED(network: String, pid: Long, message: String): Event {
        return Event(type = "AgentStopped",
                aggregateId = network,
                payload = mapOf("network" to network,
                        "pid" to pid,
                        "message" to message))
    }
}

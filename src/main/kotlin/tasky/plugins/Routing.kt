package tasky.plugins

import com.codahale.metrics.*
import com.fasterxml.jackson.databind.*
import io.ktor.serialization.jackson.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import io.ktor.server.http.content.*
import io.ktor.server.metrics.dropwizard.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import tasky.tasks.models.Task

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello World!")
        }

        route("/tasks") {
            get {
                call.respondText("Ваш список задач на сегодня!")
            }
            post {
                val task = call.receive<Task>()
                call.respondText("Создать задачу: $task")
            }
        }

        // Static plugin. Try to access `/static/index.html`
        staticResources("/static", "static")
    }
}

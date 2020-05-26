package demo

import javax.inject.Singleton
import demo.MyService

@Singleton
class MyServiceImpl : MyService {

    override fun doStuff(): String? {
        println("FROM_ORIG")
        return "FROM_ORIG"
    }
}
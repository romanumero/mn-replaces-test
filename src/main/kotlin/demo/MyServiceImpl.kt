package demo

import javax.inject.Singleton

@Singleton
class MyServiceImpl : MyService {
    override fun doStuff(): String? {
        println("FROM_ORIG")
        return "FROM_ORIG"
    }
}
package demo

import javax.inject.Singleton
import demo.MyService
import io.micronaut.context.annotation.Replaces

@Replaces(MyServiceImpl::class)
@Singleton
class MockMyService : MyService {

    override fun doStuff(): String? {
        println("FROM_MOCK")
        return "FROM_MOCK"
    }
}